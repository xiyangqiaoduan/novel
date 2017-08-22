package com.taototao.novel.spider.quanben;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
import com.taototao.novel.utils.HtmlUtils;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-08-10 14:52
 **/
@Component
public class QuanBenSpider {

    private static String URL = "http://www.quanben.co";
    private Logger logger = LoggerFactory.getLogger(QuanBenSpider.class);

    private static final int TIMEOUT = 50000;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ChapterService chapterService;


    public void main() {

        for (final String key : TOP_NAME_MAP.keySet()) {
            try {
                for (int i = 5; i > 0; i--) {
                    String key_url = "5_" + i;
                    String pageUrl = URL + "/sort/" + key_url + ".html";
                    logger.debug("当前页：{}", pageUrl);
                    Document articleDocument = Jsoup.connect(pageUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").timeout(TIMEOUT).get();
                    Element element = articleDocument.getElementById("content");
                    Elements elements = element.select("div.novel_img a");
                    logger.debug("element：{}", elements);
                    for (final Element articleElement : elements) {
                        taskExecutor.execute(new Runnable() {
                            public void run() {
                                try {

                                    String article_url = articleElement.attr("href");
                                    logger.debug("文章地址：{}", article_url);
                                    Document contentDocument = Jsoup.connect(article_url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").timeout(TIMEOUT).get();
                                    Element contentElement = contentDocument.getElementById("content");
                                    String img_url = contentElement.select("div.novel_img img").last().attr("src");
                                    logger.debug("封面地址：{}", img_url);
                                    String title = contentDocument.select("h1").last().text();
                                    logger.debug("小说名称：{}", title);
                                    logger.debug(contentDocument.select("ul.novel_msg li a").toString());
                                    String author = contentDocument.select("ul.novel_msg li a").last().text();
                                    logger.debug("小说作者：{}", author);

                                    String intro = contentElement.getElementById("description1").text().replace(Jsoup.parse("&nbsp;").text(), "");
                                    logger.debug("小说简介：{}", intro.replace("书籍简介：", ""));
                                    String pinyin = Utils.getPinYin(title);
                                    Article article1Temp = articleService.findByPinyinRegularRxpressions(pinyin);
                                    if (article1Temp != null) {
                                        return;
                                    }

                                    Article article = new Article();
                                    article.setArticlename(title);
                                    article.setIntro(intro);
                                    article.setAuthor(author);
                                    article.setCategory(TOP_NAME_MAP.get(key));
                                    article.setPermission(3);
                                    article.setPostdate(new Date());
                                    article.setFullflag(true);
                                    article.setPinyin(pinyin);
                                    article.setCreateuserno(0);
                                    article.setCreatetime(new Date());

                                    String img = img_url.substring(img_url.lastIndexOf(".") + 1);
                                    short imageType = TaoToTaoConstants.ImageType.JPG;
                                    if (img.equalsIgnoreCase("jpg")) {
                                        imageType = TaoToTaoConstants.ImageType.JPG;
                                    } else if (img.equalsIgnoreCase("gif")) {
                                        imageType = TaoToTaoConstants.ImageType.GIF;
                                    } else if (img.equalsIgnoreCase("png")) {
                                        imageType = TaoToTaoConstants.ImageType.PNG;
                                    }
                                    article.setImgflag(imageType);
                                    articleService.save(article);
                                    int articleno = article.getArticleno();
                                    logger.debug("小说ID:{}", articleno);

                                    String imageName = img_url.substring(img_url.lastIndexOf("/") + 1, img_url.length());

                                    if (!StringUtils.contains(img_url, URL)) {
                                        img_url = URL + img_url;
                                    }
                                    saveImg(img_url, imageName, articleno);


                                    String chapterListUrl = contentElement.select("li.button2 a").first().attr("href");
                                    logger.debug("小说章节列表：chapterListUrl;{}", chapterListUrl);

                                    Document chapterDocument = Jsoup.connect(URL + chapterListUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").timeout(TIMEOUT).get();
                                    Elements chapterDetailUrlElements = chapterDocument.select("div.novel_list ul li a");

                                    String chapterUrl = chapterListUrl.substring(0, chapterListUrl.lastIndexOf("/") + 1);

                                    for (Element chapterDetailUrlElement : chapterDetailUrlElements) {
                                        String chapterDetailUrl = URL + chapterUrl + chapterDetailUrlElement.attr("href");

                                        String chapterTitle = "";
                                        if (StringUtils.isNotEmpty(chapterDetailUrl)) {
                                            chapterTitle = chapterDetailUrlElement.text();
                                        }
                                        logger.debug("{}地址：{}", chapterTitle, chapterDetailUrl);

                                        if (StringUtils.isNotEmpty(chapterTitle)) {
                                            Document chapterDetailDocument = Jsoup.connect(chapterDetailUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").timeout(TIMEOUT).get();
                                            String chapterDetail = chapterDetailDocument.select("div.novel_content").after(chapterDetailDocument.select("div.novel_content div").html()).html();
                                            chapterDetail = HtmlUtils.removeScript(chapterDetail).replace("<div style=\"float:left;margin:0px 0px 0px 20px;\">", "").replace("</div>", "");
                                            logger.debug("小说详情内容：{}", chapterDetail);


                                            Chapter chapter = new Chapter();
                                            chapter.setArticlename(title);
                                            chapter.setArticleno(articleno);
                                            chapter.setChaptername(chapterTitle);
                                            chapter.setChaptertype((short) 0);
                                            chapter.setPostdate(new Date());
                                            chapter.setSize(StringUtils.length(chapterDetail));
                                            chapter.setModifytime(new Date());
                                            chapter.setModifyuserno(0);
                                            chapter.setPublishtime(new Date());
                                            chapter.setIspublish(true);
                                            chapter.setLastchecktime(new Date());
                                            chapter.setContent(chapterDetail);
                                            chapterService.save(chapter);
                                            // 最新章节等信息
                                            article = new Article();
                                            article.setArticleno(chapter.getArticleno());
                                            article.setLastchapterno(chapter.getChapterno());
                                            article.setLastchapter(chapter.getChaptername());
                                            article.setLastupdate(new Date());
                                            article.setChapters(chapterService.getChapterCount(chapter.getArticleno()));
                                            article.setSize(chapterService.getChapterCountSize(chapter.getArticleno()));
                                            article.setModifytime(new Date());
                                            article.setModifyuserno(0);
                                            articleService.updateNewChapter(article);
                                        }

                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }

    private void saveImg(String src, String imageName, int articleno) {
        try {
            //连接url
            java.net.URL url = new java.net.URL(src);
            URLConnection uri = url.openConnection();
            //获取数据流
            InputStream is = uri.getInputStream();
            String path = TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.SYSTEM_PATH) + TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.RELATIVE_IAMGE_PATH);

            String img = StringUtils.substringAfterLast(imageName, ".");

            if (img.equalsIgnoreCase("jpg") && img.equalsIgnoreCase("gif") && img.equalsIgnoreCase("png")) {
                img = "jpg";
            }

            path = path + "/" + articleno
                    / TaoToTaoConstants.SUB_DIR_ARTICLES + "/" + articleno + "/" + articleno + "s."
                    + img;
            File savefile = new File(path);
            if (!savefile.getParentFile().exists()) {
                savefile.getParentFile().mkdirs();
            }

            //写入数据流
            OutputStream os = new FileOutputStream(savefile);
            byte[] buf = new byte[1024];
            int l = 0;
            while ((l = is.read(buf)) != -1) {
                os.write(buf, 0, l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final Map<String, Integer> TOP_NAME_MAP = new LinkedHashMap<String, Integer>() {
        {
//            put("1_1", 1);
////            put("2_1", 2);
////            put("3_1", 3);
////            put("4_1", 4);
            put("5_1", 6);
 //           put("6_1", 5);
//            put("7_1", 2);
//            put("8_1", 8);
            //put("10_1", 9);
            //  put("11_1", 10);
        }
    };


}
