package com.taototao.novel.entity;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.ChapterFrontController;
import com.taototao.novel.controller.ReaderController;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.dto.TagDTO;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 17:20
 **/
public class Article implements Serializable {

    /**
     * 文章编号
     */
    private int articleno;
    /**
     * 文章名称
     */
    private String articlename;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * pingyin首字母
     */
    private String pinyinheadchar;
    /**
     * 首字母大写
     */
    private String initial;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 作者ID
     */
    private int authorid;
    /**
     * 作者名称
     */
    private String author;
    /**
     * 分类
     */
    private int category;
    /**
     * 二级分类
     */
    private int subcategory;
    /**
     * 文章介绍
     */
    private String intro;
    /**
     * 最后章节编号
     */
    private int lastchapterno;
    /**
     * 最后章节
     */
    private String lastchapter;
    /**
     * 章节数
     */
    private int chapters;
    /**
     * 文章字数
     */
    private int size;
    /**
     * 是否全本
     */
    private boolean fullflag;
    /**
     * 图片flag
     */
    private int imgflag;
    /**
     * 代理
     */
    private String agent;
    /**
     * 1-本站首发 0-他站首发
     */
    private boolean firstflag;
    /**
     * 允许
     */
    private int permission;
    /**
     * 作者flag状态
     */
    private boolean authorflag;
    /**
     * 发表日期
     */
    private Date postdate;
    /**
     * 更新日期
     */
    private Date lastupdate;
    /**
     * 日访问量
     */
    private int dayvisit;
    /**
     * 周访问量
     */
    private int weekvisit;
    /**
     * 月访问量
     */
    private int monthvisit;
    /**
     * 总访问量
     */
    private int allvisit;
    /**
     * 日推荐量
     */
    private int dayvote;
    /**
     * 周推荐量
     */
    private int weekvote;
    /**
     * 月推荐量
     */
    private int monthvote;
    /**
     * 所有推荐量
     */
    private int allvote;
    /**
     * 删除状态
     */
    private boolean deleteflag;
    /**
     * 发表
     */
    private int publicflag;
    /**
     * 创建人编号
     */
    private int createuserno;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改人编号
     */
    private int modifyuserno;
    /**
     * 修改时间
     */
    private Date modifytime;

    private boolean usecustomizeinfotitle;
    /**
     * info标题
     */
    private String infotitle;
    /**
     * info关键字
     */
    private String infokeywords;
    /**
     * info描述
     */
    private String infodescription;

    private boolean usecustomizelisttitle;
    /**
     * list标题
     */
    private String listtitle;
    /**
     * list关键字
     */
    private String listkeywords;
    /**
     * list描述
     */
    private String listdescription;


    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinheadchar() {
        return pinyinheadchar;
    }

    public void setPinyinheadchar(String pinyinheadchar) {
        this.pinyinheadchar = pinyinheadchar;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getLastchapterno() {
        return lastchapterno;
    }

    public void setLastchapterno(int lastchapterno) {
        this.lastchapterno = lastchapterno;
    }

    public String getLastchapter() {
        return lastchapter;
    }

    public void setLastchapter(String lastchapter) {
        this.lastchapter = lastchapter;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFullflag() {
        return fullflag;
    }

    public void setFullflag(boolean fullflag) {
        this.fullflag = fullflag;
    }

    public int getImgflag() {
        return imgflag;
    }

    public void setImgflag(int imgflag) {
        this.imgflag = imgflag;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public boolean isFirstflag() {
        return firstflag;
    }

    public void setFirstflag(boolean firstflag) {
        this.firstflag = firstflag;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public boolean isAuthorflag() {
        return authorflag;
    }

    public void setAuthorflag(boolean authorflag) {
        this.authorflag = authorflag;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public int getDayvisit() {
        return dayvisit;
    }

    public void setDayvisit(int dayvisit) {
        this.dayvisit = dayvisit;
    }

    public int getWeekvisit() {
        return weekvisit;
    }

    public void setWeekvisit(int weekvisit) {
        this.weekvisit = weekvisit;
    }

    public int getMonthvisit() {
        return monthvisit;
    }

    public void setMonthvisit(int monthvisit) {
        this.monthvisit = monthvisit;
    }

    public int getAllvisit() {
        return allvisit;
    }

    public void setAllvisit(int allvisit) {
        this.allvisit = allvisit;
    }

    public int getDayvote() {
        return dayvote;
    }

    public void setDayvote(int dayvote) {
        this.dayvote = dayvote;
    }

    public int getWeekvote() {
        return weekvote;
    }

    public void setWeekvote(int weekvote) {
        this.weekvote = weekvote;
    }

    public int getMonthvote() {
        return monthvote;
    }

    public void setMonthvote(int monthvote) {
        this.monthvote = monthvote;
    }

    public int getAllvote() {
        return allvote;
    }

    public void setAllvote(int allvote) {
        this.allvote = allvote;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public int getPublicflag() {
        return publicflag;
    }

    public void setPublicflag(int publicflag) {
        this.publicflag = publicflag;
    }

    public int getCreateuserno() {
        return createuserno;
    }

    public void setCreateuserno(int createuserno) {
        this.createuserno = createuserno;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getModifyuserno() {
        return modifyuserno;
    }

    public void setModifyuserno(int modifyuserno) {
        this.modifyuserno = modifyuserno;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public boolean isUsecustomizeinfotitle() {
        return usecustomizeinfotitle;
    }

    public void setUsecustomizeinfotitle(boolean usecustomizeinfotitle) {
        this.usecustomizeinfotitle = usecustomizeinfotitle;
    }

    public String getInfotitle() {
        return infotitle;
    }

    public void setInfotitle(String infotitle) {
        this.infotitle = infotitle;
    }

    public String getInfokeywords() {
        return infokeywords;
    }

    public void setInfokeywords(String infokeywords) {
        this.infokeywords = infokeywords;
    }

    public String getInfodescription() {
        return infodescription;
    }

    public void setInfodescription(String infodescription) {
        this.infodescription = infodescription;
    }

    public boolean isUsecustomizelisttitle() {
        return usecustomizelisttitle;
    }

    public void setUsecustomizelisttitle(boolean usecustomizelisttitle) {
        this.usecustomizelisttitle = usecustomizelisttitle;
    }

    public String getListtitle() {
        return listtitle;
    }

    public void setListtitle(String listtitle) {
        this.listtitle = listtitle;
    }

    public String getListkeywords() {
        return listkeywords;
    }

    public void setListkeywords(String listkeywords) {
        this.listkeywords = listkeywords;
    }

    public String getListdescription() {
        return listdescription;
    }

    public void setListdescription(String listdescription) {
        this.listdescription = listdescription;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleno=" + articleno +
                ", articlename='" + articlename + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", pinyinheadchar='" + pinyinheadchar + '\'' +
                ", initial='" + initial + '\'' +
                ", keywords='" + keywords + '\'' +
                ", authorid=" + authorid +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", subcategory=" + subcategory +
                ", intro='" + intro + '\'' +
                ", lastchapterno=" + lastchapterno +
                ", lastchapter='" + lastchapter + '\'' +
                ", chapters=" + chapters +
                ", size=" + size +
                ", fullflag=" + fullflag +
                ", imgflag=" + imgflag +
                ", agent='" + agent + '\'' +
                ", firstflag=" + firstflag +
                ", permission=" + permission +
                ", authorflag=" + authorflag +
                ", postdate=" + postdate +
                ", lastupdate=" + lastupdate +
                ", dayvisit=" + dayvisit +
                ", weekvisit=" + weekvisit +
                ", monthvisit=" + monthvisit +
                ", allvisit=" + allvisit +
                ", dayvote=" + dayvote +
                ", weekvote=" + weekvote +
                ", monthvote=" + monthvote +
                ", allvote=" + allvote +
                ", deleteflag=" + deleteflag +
                ", publicflag=" + publicflag +
                ", createuserno=" + createuserno +
                ", createtime=" + createtime +
                ", modifyuserno=" + modifyuserno +
                ", modifytime=" + modifytime +
                ", usecustomizeinfotitle=" + usecustomizeinfotitle +
                ", infotitle='" + infotitle + '\'' +
                ", infokeywords='" + infokeywords + '\'' +
                ", infodescription='" + infodescription + '\'' +
                ", usecustomizelisttitle=" + usecustomizelisttitle +
                ", listtitle='" + listtitle + '\'' +
                ", listkeywords='" + listkeywords + '\'' +
                ", listdescription='" + listdescription + '\'' +
                '}';
    }


    /**
     * 获得图片URL
     *
     * @return 图片URL
     */
    public String getImgUrl() {
        String fileName = "";
        if (this.getImgflag() == 0) {
            fileName = "nocover.jpg";
        } else {
            switch (getImgflag()) {
                case 1:
                    fileName = getArticleno() + "s.jpg";
                    break;
                case 2:
                    fileName = getArticleno() + "s.gif";
                    break;
                case 3:
                    fileName = getArticleno() + "s.png";
                    break;
                case 10:
                    fileName = getArticleno() + "l.jpg";
                    break;
                default:
                    fileName = "nocover.jpg";
                    break;
            }
        }
        String imgUrl = TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.RELATIVE_IAMGE_PATH) + "/";
        if (StringUtils.equals("nocover.jpg", fileName)) {
            imgUrl = imgUrl + fileName;
        } else {
            if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CLEAN_IMAGE_URL, false)) {
                imgUrl = imgUrl + getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES + "-" + getArticleno() + "-"
                        + Utils.convert2MD5(imgUrl + fileName) + fileName;
            } else {
                imgUrl = imgUrl + getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES + "/" + getArticleno() + "/"
                        + fileName;
            }
        }
        return imgUrl;
    }

    /**
     * 获得最新章节名字的缩略
     *
     * @return 最新章节名字的缩略
     */
    public String getLastchapterOmit() {
        if (getLastchapter() != null && getLastchapter().length() > 10) {
            return getLastchapter().substring(0, 10);
        }
        return getLastchapter();
    }


    /**
     * 获取最新章节URL
     *
     * @return 最新章节URL
     */
    public String getLastChapterUrl() {
//        StringBuffer sb = new StringBuffer(AbstractPublicBaseController.CHAPTER_NAMES);
//        sb.append("/").append(ChapterFrontController.DETAIL).append("/")
//                .append(getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES)
//                .append("/")
//                .append(getArticleno())
//                .append("/")
//                .append(getLastchapterno()).append("/").append(getPinyin().toLowerCase());
        StringBuffer sb=new StringBuffer(AbstractPublicBaseController.READER_NAMES);
        sb.append("/")
                .append(ReaderController.CHAPTER_DETAIL)
                .append("/")
                .append(getSubdir())
                .append("/")
                .append( getArticleno())
                .append("/")
                .append(getLastchapterno());

        return sb.toString();
    }

    /**
     * 获取小说介绍页URL
     *
     * @return 小说介绍页URL
     */
    public String getUrl() {
        StringBuffer sb = new StringBuffer(AbstractPublicBaseController.INFO_NAMES);
        sb.append("/")
                .append(getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES)
                .append("/")
                .append(getArticleno())
                .append("/")
                .append(getPinyin().toLowerCase());

        return sb.toString();
    }

    /**
     * 获取章节列表URL
     *
     * @return 分类列表URL
     */
    public String getChapterListUrl() {

        StringBuffer sb = new StringBuffer(AbstractPublicBaseController.INFO_NAMES);
        sb.append("/").append(ChapterFrontController.INFO_NAMES).append("/")
                .append(getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES)
                .append("/")
                .append(getArticleno())
                .append("/")
                .append(getPinyin().toLowerCase());
        return sb.toString();
    }

    /**
     * 获得小说类别名字
     *
     * @return 小说类别名字
     */
    public String getCategoryStr() {

        String categoryStr = null;
        switch (getCategory()) {
            case 1:
                categoryStr = "玄幻魔法";
                break;
            case 2:
                categoryStr = "武侠修真";
                break;

            case 3:
                categoryStr = "都市言情";
                break;
            case 4:
                categoryStr = "历史军事";
                break;
            case 5:
                categoryStr = "侦探推理";
                break;
            case 6:
                categoryStr = "网游动漫";
                break;
            case 7:
                categoryStr = "科幻小说";
                break;
            case 8:
                categoryStr = "恐怖灵异";
                break;
            case 9:
                categoryStr = "文学著作";
                break;
            case 10:
                categoryStr = "其他类型";
                break;

        }

        return  categoryStr;
    }

    /**
     * 获取HTML格式的小说简介信息
     *
     * @return HTML格式的小说简介信息
     */
    public String getIntroForHtml() {
        if (getIntro() != null) {
            // 替换换行和空格
            String html = StringEscapeUtils.escapeHtml4(getIntro());
            return html.replaceAll("\r\n", "<br/>").replaceAll("\n", "<br/>").replaceAll("\\s", "&nbsp;");
        }
        return null;
    }


    /**
     * 获取小说tag的URL
     *
     * @return 小说介绍页拼音形式的URL
     */
    public List<TagDTO> getTagList() {
        List<String> tags = Utils.getKeyWords(getArticlename());
        List<TagDTO> tagList = new ArrayList<TagDTO>();

        for (String tag : tags) {
            TagDTO tagdto = new TagDTO();
            tagdto.setTag(tag);
            tagdto.setUrl("info/articleList?tag=" + tag);
            tagList.add(tagdto);
        }
        return tagList;
    }
    /**
     * 获得子目录 <br>
     * 默认是小说号/1000
     *
     * @return 子目录
     */
    public Integer getSubdir() {
        return getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES;
    }

}
