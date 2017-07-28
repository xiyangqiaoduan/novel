package com.taototao.novel.controller;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.bean.ReviewSearchBean;
import com.taototao.novel.cache.ArticleCountManager;
import com.taototao.novel.cache.CacheManager;
import com.taototao.novel.constant.ICommon;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.entity.Review;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
import com.taototao.novel.service.ReviewService;
import com.taototao.novel.utils.Pagination;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-25 14:27
 **/
@Controller
@RequestMapping(AbstractPublicBaseController.INFO_NAMES)
public class InfoController extends AbstractPublicBaseController {


    @Autowired
    private ArticleService articleService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/{subdir}/{articleno}/{pinyin}")
    public String index(@PathVariable int subdir, @PathVariable int articleno, @PathVariable String pinyin, ModelMap map) {

        logger.debug("load data --------------->sybdir={},articleno={},pinyin=", subdir, articleno, pinyin);

        Article article = null;

        if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_PINYINURL, false)) {
            article = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, pinyin);
            if (!Utils.isDefined(article)) {
                ArticleSearchBean searchBean = new ArticleSearchBean();
                searchBean.setPinyin(pinyin.toUpperCase());
                List<Article> articleList = articleService.find(searchBean);
                if (Utils.isDefined(articleList)) {
                    article = articleList.get(0);
                    CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, pinyin, article);
                }
            }
        } else {
            article = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, articleno);

            if (!Utils.isDefined(article)) {
                article = articleService.getByNo(articleno);
                CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, articleno, article);
            }

        }


        if (article != null) {
//            if (!YiDuConstants.yiduConf.getBoolean(YiDuConfig.ENABLE_CHAPTER_INDEX_PAGE, false)
//                    || (YiDuConstants.singleBookFlag.get() != null && YiDuConstants.singleBookFlag.get())) {
            // 获取章节信息
            ChapterSearchBean searchBean = new ChapterSearchBean();
            searchBean.setArticleno(article.getArticleno());
            List<Chapter> chapterList = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_CHAPTER_LIST_PREFIX,
                    searchBean);
            if (!Utils.isDefined(chapterList)) {
                chapterList = chapterService.findWithPinyin(searchBean);
                if (Utils.isDefined(chapterList)) {
                    CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_CHAPTER_LIST_PREFIX, searchBean,
                            chapterList);
                }
            }

            map.put("chapterList", chapterList);


            // 获取评论信息
            ReviewSearchBean reviewSearchBean = new ReviewSearchBean();
            reviewSearchBean.setArticleno(article.getArticleno());
            // 获取评论件数
            int reviewCount = reviewService.getCount(reviewSearchBean);
            map.put("reviewCount", reviewCount);
            // 获取评论
            Pagination pagination = new Pagination(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.REVIEW_NUM, 5), 1);
            pagination.setSortColumn("postdate");
            pagination.setSortOrder("DESC");
            reviewSearchBean.setPagination(pagination);
            List<Review> reviewList = reviewService.find(reviewSearchBean);
            map.put("reviewList", reviewList);
            // 更新统计信息
            articleService.updateVisitStatistic(article.getArticleno());

//            }
        }

        map.put("pageType", TaoToTaoConstants.Pagetype.PAGE_ARTICLE_INFO);
        map.put("article", article);
        map.put("enableChapterIndexPage", TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE, false));
        loadBlock(map);

        return ICommon.themes + "/pc/info";
    }


    @RequestMapping("search")
    public String search(String key, @RequestParam(defaultValue = "1") int page, ModelMap map) {
        logger.debug("loadData start.");

        if (StringUtils.isEmpty(key)) {
            key = "";
        }
        ArticleSearchBean searchBean = new ArticleSearchBean();
        searchBean.setKey(key);
        searchBean.setPageType(ArticleSearchBean.PageType.publicPage);
        Pagination pagination = new Pagination(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.COUNT_PER_PAGE, 20), 1);
        pagination.setPageNumber(page);
        pagination.setSortColumn("lastupdate");
        pagination.setSortOrder("ASC");

        Object countInfo = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_COUNT_PREFIX, searchBean);
        int count = 0;
        if (countInfo == null) {
            count = articleService.getCount(searchBean);
            CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_COUNT_PREFIX, searchBean, count);
        } else {
            count = Integer.parseInt(countInfo.toString());
        }
        // 总件数设置
        pagination.setPreperties(count);
        searchBean.setPagination(pagination);

        List<Article> articleList = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_PREFIX, searchBean);
        if (articleList == null || articleList.size() == 0) {
            articleList = articleService.find(searchBean);
            CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_PREFIX, searchBean, articleList);
        }
        map.put("articleList", articleList);
        map.put("pagination", pagination);
        map.put("pageType", TaoToTaoConstants.Pagetype.PAGE_SEARCH);
        map.put("key", key);
        loadBlock(map);
        return ICommon.themes + "/pc/search";
    }


    @RequestMapping("articleList")
    public String articleList(Integer category, String author, Boolean fullflag, String tag, @RequestParam(defaultValue = "1") int page, ModelMap map) {

        logger.debug("articleList-------------------->category={},page={}", category, page);
        ArticleSearchBean searchBean = new ArticleSearchBean();
        searchBean.setPageType(ArticleSearchBean.PageType.publicPage);
        Pagination pagination = new Pagination(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.COUNT_PER_PAGE, 20), 1);
        pagination.setPageNumber(page);
        pagination.setSortColumn("lastupdate");
        pagination.setSortOrder("DESC");
        int count = 0;

        if(category!=null){

            map.put("category",category);
            map.put("categoryStr",getCategoryStr(category));
        }

        if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CACHE_ARTICLE_COUNT, false)) {
            // 开启缓存件数的话
            if (Utils.isDefined(category)) {
                // 分类
                count = ArticleCountManager.getArticleCount(String.valueOf(category));

                if (count == 0) {
                    ArticleSearchBean countSearchBean = new ArticleSearchBean();
                    countSearchBean.setCategory(category);
                    count = articleService.getCount(countSearchBean);
                    ArticleCountManager.putArticleCount(String.valueOf(category), count);
                }
                searchBean.setCategory(category);

            } else if (Utils.isDefined(author)) {
                count = ArticleCountManager.getArticleCount(TaoToTaoConstants.CacheCountType.AUTHOR);

                if (count == 0) {
                    ArticleSearchBean countSearchBean = new ArticleSearchBean();
                    countSearchBean.setAuthor(author);
                    count = articleService.getCount(countSearchBean);
                    ArticleCountManager.putArticleCount(TaoToTaoConstants.CacheCountType.AUTHOR, count);
                }
                map.put("author",author);

                searchBean.setAuthor(author);
            } else if (fullflag != null && fullflag) {
                count = ArticleCountManager.getArticleCount(TaoToTaoConstants.CacheCountType.FULLFLAG);

                if (count == 0) {
                    ArticleSearchBean countSearchBean = new ArticleSearchBean();
                    countSearchBean.setFullflag(fullflag);
                    count = articleService.getCount(countSearchBean);
                    ArticleCountManager.putArticleCount(TaoToTaoConstants.CacheCountType.FULLFLAG, count);
                }
                map.put("fullflag",fullflag);
                searchBean.setFullflag(fullflag);
            } else if (Utils.isDefined(tag)) {
                count = ArticleCountManager.getArticleCount(TaoToTaoConstants.CacheCountType.TAG);
                if (count == 0) {
                    ArticleSearchBean countSearchBean = new ArticleSearchBean();
                    countSearchBean.setTag(tag);
                    count = articleService.getCount(countSearchBean);
                    ArticleCountManager.putArticleCount(TaoToTaoConstants.CacheCountType.TAG, count);
                }
                map.put("tag",tag);
                searchBean.setTag(tag);
            } else {
                count = ArticleCountManager.getArticleCount(TaoToTaoConstants.CacheCountType.ALL);
                if (count == 0) {
                    ArticleSearchBean countSearchBean = new ArticleSearchBean();
                    count = articleService.getCount(countSearchBean);
                    ArticleCountManager.putArticleCount(TaoToTaoConstants.CacheCountType.ALL, count);
                }
            }
        } else {
            Object countInfo = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_COUNT_PREFIX,
                    searchBean);
            if (countInfo == null) {
                count = articleService.getCount(searchBean);
                CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_COUNT_PREFIX, searchBean,
                        count);
            } else {
                count = Integer.parseInt(countInfo.toString());
            }
        }
        // 总件数设置
        pagination.setPreperties(count);
        searchBean.setPagination(pagination);

        List<Article> articleList = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_PREFIX, searchBean);
        if (!Utils.isDefined(articleList)) {
            articleList = articleService.find(searchBean);
            CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_PREFIX, searchBean, articleList);
        }

        if (Utils.isDefined(fullflag) && fullflag) {
            List<Article>  lastPostFullArticleList = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_PREFIX
                    + fullflag, searchBean);
            if (!Utils.isDefined(lastPostFullArticleList)) {
                searchBean.getPagination().setSortColumn("postdate");
                lastPostFullArticleList = articleService.find(searchBean);
                CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_LIST_PREFIX + fullflag,
                        searchBean, lastPostFullArticleList);
            }
        }
        map.put("articleList",articleList);
        map.put("pagination",pagination);
        loadBlock(map);
        map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_ARTICLE_LIST);
        return ICommon.themes + "/pc/articleList";

    }


    @RequestMapping("siteMap")
    public String siteMap(ModelMap map){
        loadBlock(map);
        map.put("articleList",articleService.find(new ArticleSearchBean()));
        map.put("pageType",0);
        return ICommon.themes + "/pc/siteMap";
    }

    @RequestMapping("top")
    public String top(String sortColumn,String sortOrder,@RequestParam(defaultValue = "1") int page,ModelMap map){
        if (!TaoToTaoConstants.TOP_NAME_MAP.containsKey(sortColumn)) {
            // 默认最近更新
            sortColumn = "lastupdate";
        }

        ArticleSearchBean searchBean = new ArticleSearchBean();
        searchBean.setPageType(ArticleSearchBean.PageType.publicPage);
        Pagination pagination = new Pagination(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.COUNT_PER_PAGE, 20), 1);
        pagination.setPageNumber(page);
        pagination.setSortColumn(sortColumn);
        pagination.setSortOrder(StringUtils.equalsIgnoreCase("ASC", sortOrder) ? sortOrder : "DESC");

        int count = 0;
        if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CACHE_ARTICLE_COUNT, false)) {
            // 开启缓存件数的话
            count = ArticleCountManager.getArticleCount(sortColumn);

            if (count == 0) {
                count = articleService.getCount(searchBean);
                ArticleCountManager.putArticleCount(sortColumn, count);
            }

        } else {
            Integer countCache = CacheManager.getObject(
                    CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_TOP_LIST_COUNT_PREFIX, null);
            if (countCache == null || countCache == 0) {
                count = articleService.getCount(searchBean);
            } else {
                count = countCache;
            }
        }
        // 总件数设置
        pagination.setPreperties(count);
        searchBean.setPagination(pagination);

        List<Article> articleList = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_TOP_LIST_PREFIX, searchBean);
        if (articleList == null || articleList.size() == 0) {
            articleList = articleService.find(searchBean);
            CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_TOP_LIST_PREFIX, searchBean,
                    articleList);
        }
        map.put("articleList",articleList);
        map.put("pagination",pagination);
        map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_TOP);
        map.put("sortColumn",sortColumn);
        map.put("topnamemap",TOP_NAME_MAP);
        loadBlock(map);
        logger.debug("normally end.");
        return ICommon.themes + "/pc/top";
    }



    public static final Map<String, String> TOP_NAME_MAP = new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = -2355068040470822368L;
        {
            put("lastupdate", "最近更新");
            put("allvisit", "总点击榜");
            put("allvote", "总推荐榜");
            put("monthvisit", "月点击榜");
            put("monthvote", "月推荐榜");
            put("weekvisit", "周点击榜");
            put("weekvote", "周推荐榜");
            put("dayvisit", "日点击榜");
            put("dayvote", "日推荐榜");
            put("postdate", "最新入库");
            put("size", "字数排行");
        }
    };


    /**
     * 获得小说类别名字
     *
     * @return 小说类别名字
     */
    public String getCategoryStr(int category) {

        String categoryStr = null;
        switch (category) {
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
                categoryStr = "散文诗词";
                break;
            case 10:
                categoryStr = "其他类型";
                break;

        }
        return  categoryStr;
    }

}
