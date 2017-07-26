package com.taototao.novel.controller.base;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.bean.SystemBlockSearchBean;
import com.taototao.novel.cache.CacheManager;
import com.taototao.novel.constant.ICommon;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.SystemBlock;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.SystemBlockService;
import com.taototao.novel.utils.Pagination;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-24 10:18
 **/
public abstract class AbstractPublicBaseController {

    @Autowired
    private SystemBlockService systemBlockService;

    @Autowired
    private ArticleService articleService;


    /**
     * 输出log
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 章节
     */
    public final static  String CHAPTER_NAMES="chapter";
    /**
     * 小说信息
     */
    public final static  String INFO_NAMES="info";


    /**
     * reader
     */
    public final static  String READER_NAMES="reader";

    /**
     * 初始化区块信息
     */
    protected void loadBlock(ModelMap map) {

        logger.debug("loadBlock start.");

        // 从缓存中把首页用的区块信息取出
        Map<String, Object> blocks=null;

        if(!logger.isDebugEnabled()){
            blocks = CacheManager.getObject(getBlockKey(), null);
        }

        if (!TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.CACHE_EFFECTIVE) || !Utils.isDefined(blocks)) {

            blocks = new HashMap<String, Object>();

            // 没有取到的话从数据库里取出
            // block数据取得
            List<SystemBlock> blockList = new ArrayList<SystemBlock>();
            SystemBlockSearchBean searchBean = new SystemBlockSearchBean();

            searchBean.setTargets(TaoToTaoConstants.BlockTarget.ALL_SITE, getBlockTarget());

            blockList = systemBlockService.find(searchBean);

            for (SystemBlock systemBlock : blockList) {
                int limitnum = systemBlock.getLimitnum() == 0 ? 1 : systemBlock.getLimitnum();

                if (systemBlock.getType() == TaoToTaoConstants.BlockType.ARTICLE_LIST) {
                    ArticleSearchBean articleSearchBean = new ArticleSearchBean();
                    if (Utils.isDefined(systemBlock.getCategory())) {
                        articleSearchBean.setCategory(systemBlock.getCategory());
                    }
                    Pagination pagination = new Pagination(limitnum, 1);
                    pagination.setSortColumn(systemBlock.getSortcol());
                    pagination.setSortOrder(systemBlock.isIsasc() ? "ASC" : "DESC");
                    articleSearchBean.setPagination(pagination);
                    List<Article> articleList=articleService.find(articleSearchBean);
                    blocks.put(systemBlock.getBlockid(),articleList);

                }else if(systemBlock.getType()==TaoToTaoConstants.BlockType.RANDOM_LIST){
                    // 随机推荐区块
                    List<Article> articleList=articleService.findRandomRecommendArticleList(limitnum);
                    blocks.put(systemBlock.getBlockid(),articleList);
                }else if(systemBlock.getType()==TaoToTaoConstants.BlockType.RECOMMEND_LIST){
                    // 按小说分类和编号推荐区块
                    List<Article> articleList = articleService.findRecommendArticleList(getRecommondCategory(),
                            getRecommondArticleno(), limitnum);
                    blocks.put(systemBlock.getBlockid(), articleList);
                }else if (systemBlock.getType() == TaoToTaoConstants.BlockType.CUSTONIZE_ARTICLE_LIST){
                    // 自定义小说列表
                    ArticleSearchBean articleSearchBean = new ArticleSearchBean();
                    articleSearchBean.setArticlenos(systemBlock.getContent());
                    List<Article> articleList = articleService.find(articleSearchBean);
                    // 为了维持和设置一样重新排序
                    List<Article> newArticleList = new ArrayList<Article>();
                    String[] articlenos = StringUtils.split(systemBlock.getContent(), ",");
                    for (String no : articlenos) {
                        for (Article article : articleList) {
                            if (StringUtils.equals(no, String.valueOf(article.getArticleno()))) {
                                newArticleList.add(article);
                                // 减少循环次数，将已经取出的元素删掉
                                articleList.remove(article);
                                break;
                            }
                        }
                    }

                    blocks.put(systemBlock.getBlockid(), newArticleList);

                } else if (systemBlock.getType() == TaoToTaoConstants.BlockType.HTML) {
                    // HTML区块
                    blocks.put(systemBlock.getBlockid(), systemBlock.getContent());
                }else if (systemBlock.getType() == TaoToTaoConstants.BlockType.RELATIVE_LIST) {
                    // 相关小说区块（名字匹配）
                    String articleName = getRelativeArticleName();
                    if (StringUtils.isBlank(articleName)) {
                        // 小说名是空的话，直接跳过啦
                        continue;
                    }
                    List<String> keys = Utils.getKeyWords(articleName);
                    // 取相关小说
                    List<Article> articleList = articleService.findRelativeArticleList(keys,
                            systemBlock.getSortcol(), systemBlock.isIsasc(), systemBlock.getLimitnum());

                    blocks.put(systemBlock.getBlockid(), articleList);
                }else if (systemBlock.getType() == TaoToTaoConstants.BlockType.SAME_AUTHOR_LIST) {
                    // 同作者区块
                    String author = getAuthor();
                    if (StringUtils.isBlank(author)) {
                        // 作者名是空的话，直接跳过啦
                        continue;
                    }
                    ArticleSearchBean articleSearchBean = new ArticleSearchBean();
                    articleSearchBean.setAuthor(author);
                    Pagination pagination = new Pagination(limitnum, 1);
                    pagination.setSortColumn(systemBlock.getSortcol());
                    pagination.setSortOrder(systemBlock.isIsasc() ? "ASC" : "DESC");
                    articleSearchBean.setPagination(pagination);
                    List<Article> articleList = articleService.find(articleSearchBean);
                    blocks.put(systemBlock.getBlockid(), articleList);
                }
            }
            if(!logger.isDebugEnabled()) {
                CacheManager.putObject(getBlockKey(), null, blocks);
            }
        }


        map.put("blocks",blocks);
        map.put("contextPath","/novel");
        map.put("themeName", ICommon.themes);
        map.put("enableQQLogin",TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_QQLOGIN,false));

        map.put("enableChapterIndexPage",TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE, false));


        logger.debug("loadBlock normally end.");
    }


    public String getBlockKey() {
        return CacheManager.CacheKeyPrefix.CACHE_KEY_GLOBAL_BLOCK;
    }

    public Short getBlockTarget() {
        return TaoToTaoConstants.BlockTarget.ALL_SITE;
    }

    public int getRecommondCategory() {
        return 0;
    }

    public int getRecommondArticleno() {
        return 0;
    }

    public String getRelativeArticleName() {
        return null;
    }

    public String getAuthor() {
        return null;
    }
}
