package com.taototao.novel.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.Article;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.utils.Pagination;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-19 11:08
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class ArticleController extends AbstractAdminBaseController {


    @Autowired
    private ArticleService articleService;


    @RequestMapping("article/list")
    public String list(Pagination pagination,ArticleSearchBean searchBean, ModelMap map) {
        if (pagination.getPageSize() == 0) {
            pagination.setPageSize(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.NUMBER_PER_PAGE));
        }
        if (pagination.getPageNumber() == 0) {
            pagination.setPageNumber(1);
            pagination.setStart(0);
        } else {
            pagination.setStart(pagination.getPageSize() * (pagination.getPageNumber() - 1));
        }
        if (StringUtils.isEmpty(pagination.getSortColumn())) {
            pagination.setSortColumn("lastupdate");
            pagination.setSortOrder("DESC");
        }
        //ArticleSearchBean searchBean = new ArticleSearchBean();
        pagination.setPreperties(articleService.getCount(searchBean));
        searchBean.setPageType(ArticleSearchBean.PageType.adminPage);
        searchBean.setPagination(pagination);
        List<Article> articleList = articleService.find(searchBean);
        pagination.setPageRecords(articleList.size());
        map.put("articleList", articleList);
        map.put("pagination", pagination);
        return "admin/articleList";
    }

    @RequestMapping("article/editPage/{articleno}")
    public String editPage(@PathVariable int articleno, ModelMap map) {

        Article article = articleService.getByNo(articleno);
        map.put("article", article);
        return "admin/articleEdit";
    }


    @RequestMapping("article/update")
    public String edit(Article article, MultipartFile fileData, HttpServletRequest request) {

        logger.debug("save start Article={}", article.toString());
        String pinyin = Utils.getPinYin(article.getArticlename());
        Article article1Temp = articleService.findByPinyinRegularRxpressions(pinyin);
        pinyin=getPinyin(article1Temp,pinyin);

        if(!fileData.isEmpty()){
            article.setImgflag(getImgflag(fileData));
            upload(fileData,request,article.getArticleno());
        }
        article.setPinyin(pinyin);
        article.setModifytime(new Date());
        article.setModifyuserno(0);

        articleService.update(article);

        return "redirect:/admin/article/list";
    }


    @RequestMapping("/article/addPage")
    public String addPage() {
        return "admin/articleEdit";
    }

    /**
     * 小说名称拼音
     *
     * @param article1Temp
     * @param pinyin
     * @return
     */
    private String getPinyin(Article article1Temp, String pinyin) {
        if (Utils.isDefined(article1Temp)) {
            // 存在的话
            if (StringUtils.equals(article1Temp.getPinyin(), pinyin)) {
                // 如果存在相同拼音的就在后面加数字
                pinyin = pinyin + 2;
            } else {
                // TODO 此处多线程的话会有问题，后台同时操作的时候应该不多！暂时不对应
                int suffixNumber = Integer.valueOf(StringUtils.substring(article1Temp.getPinyin(), pinyin.length(),
                        article1Temp.getPinyin().length()));
                pinyin = pinyin + (suffixNumber + 1);
            }
        }
        return pinyin;
    }

    /**
     *图片类型
     * @param fileData
     * @return
     */
    private int getImgflag( MultipartFile fileData){
        if (!fileData.isEmpty()) {
            if (ArrayUtils.contains(TaoToTaoConstants.ALLOW_PIC_TYPES, fileData.getContentType())) {
                if (StringUtils.equals(fileData.getContentType(), TaoToTaoConstants.ImgageMateType.JPG)) {
                    return TaoToTaoConstants.ImageType.JPG;
                } else if (StringUtils.equals(fileData.getContentType(), TaoToTaoConstants.ImgageMateType.GIF)) {
                    return TaoToTaoConstants.ImageType.GIF;
                } else if (StringUtils.equals(fileData.getContentType(), TaoToTaoConstants.ImgageMateType.PNG)) {
                    return TaoToTaoConstants.ImageType.PNG;
                }
            }
        }

        return 0;
    }

    /**
     * 上传封面
     * @param fileData
     * @param request
     * @param articleno
     */
    private void upload( MultipartFile fileData,HttpServletRequest request,int articleno){
        if (!fileData.isEmpty()) {
            logger.info("============上传文件开始==========");
            if (ArrayUtils.contains(TaoToTaoConstants.ALLOW_PIC_TYPES, fileData.getContentType())) {
                String fileName = fileData.getOriginalFilename();
                logger.info("-------------------->文件名称：" + fileName);
                String path = TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.RELATIVE_IAMGE_PATH);
                path = request.getServletContext().getRealPath("/") + path + "/" + articleno
                        / TaoToTaoConstants.SUB_DIR_ARTICLES + "/" + articleno + "/" + articleno + "s."
                        + StringUtils.substringAfterLast(fileName, ".");
                logger.debug("file path----------->{}", path);
                File savefile = new File(path);
                if (!savefile.getParentFile().exists()) {
                    savefile.getParentFile().mkdirs();
                }
                try {
                    fileData.transferTo(savefile);
                    savefile.createNewFile();
                } catch (IOException e) {
                    logger.error("upload image error", e);
                }
            }
            logger.debug("=================上传文件结束==================");
        }
    }


    @RequestMapping("article/save")
    public String save(Article article, MultipartFile fileData, HttpServletRequest request) {
        logger.debug("save start Article={}", article.toString());
        String pinyin = Utils.getPinYin(article.getArticlename());
        Article article1Temp = articleService.findByPinyinRegularRxpressions(pinyin);
        pinyin = getPinyin(article1Temp, pinyin);
        article.setPinyin(pinyin);
        article.setCreateuserno(0);
        article.setCreatetime(new Date());
        article.setImgflag(getImgflag(fileData));
        articleService.save(article);
        int articleno = article.getArticleno();
        logger.debug("article no-------------------------> articleno={}", articleno);
        upload(fileData,request,articleno);
        return "redirect:/admin/article/list";
    }


    @RequestMapping("article/del")
    public String delete(String articleNoList,String articleno){

        if(StringUtils.isNotBlank(articleNoList)){
            String[] articlenos=articleNoList.split(",");
            for (String ano:articlenos){
                if(StringUtils.isNotEmpty(ano)){
                    Article article=new Article();
                    article.setModifyuserno(0);
                    article.setModifytime(new Date());
                    article.setDeleteflag(true);
                    article.setArticleno(Integer.parseInt(ano));
                    articleService.delByNo(article);
                }
            }
        }else{
            Article article=new Article();
            article.setModifyuserno(0);
            article.setModifytime(new Date());
            article.setDeleteflag(true);
            article.setArticleno(Integer.parseInt(articleno));
            articleService.delByNo(article);
        }

        return "redirect:/admin/article/list";
    }


}
