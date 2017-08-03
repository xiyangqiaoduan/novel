package com.taototao.novel.spider.bixiange;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-28 14:37
 **/
@Component
public class BiXianGeSpider {

    private static String URL = "http://www.bixiange.net";

    private Logger logger = LoggerFactory.getLogger(BiXianGeSpider.class);


    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ChapterService chapterService;

    @Scheduled(cron = "0 0 2 * * ?")
    public void main() {

        for (final String key : TOP_NAME_MAP.keySet()) {
            try {
//                Document document = Jsoup.connect(URL + "/" + key + "/").userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").get();
//                Element element = document.select("div.page a").first();
//                String last_url = element.attr("href");
//                String last_num = last_url.replace(".html", "").split("_")[1];
                //  for (int i = Integer.parseInt(last_num); i > 0; i--) {
                // String pageUrl = URL + "/" + key + "/" + "index_" + i + ".html";

                String pageUrl = URL + "/" + key + "/" + "index.html";
                logger.debug("当前页：{}", pageUrl);
                Document articleDocument = Jsoup.connect(pageUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").get();
                Elements elements = articleDocument.select("li div div.title strong a");
                for (final Element articleElement : elements) {
                    taskExecutor.execute(new Runnable() {
                        public void run() {
                            try {
                                String article_url = articleElement.attr("href");
                                logger.debug("文章地址：{}", article_url);
                                if (!StringUtils.contains(article_url, URL)) {
                                    article_url = URL + article_url;
                                }
                                Document contentDocument = Jsoup.connect(article_url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").get();
                                String img_url = contentDocument.select("div div.info-left div img").last().attr("src");
                                logger.debug("封面地址：{}", img_url);
                                String title = contentDocument.select("div div.info-right div.desc h1").text();
                                logger.debug("小说名称：{}", title);
                                String author = contentDocument.select("div div.info-right div.descTip p span").get(2).text().replace("作者：","");
                                logger.debug("小说作者：{}", author);
                                String intro = contentDocument.select("div div.info-right div.descInfo p").text();
                                logger.debug("小说简介：{}", intro);
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
                                article.setImgflag(TaoToTaoConstants.ImageType.JPG);
                                articleService.save(article);
                                int articleno = article.getArticleno();
                                logger.debug("小说ID:{}", articleno);

                                String imageName = img_url.substring(img_url.lastIndexOf("/") + 1, img_url.length());

                                if (!StringUtils.contains(img_url, URL)) {
                                    img_url = URL + img_url;
                                }
                                saveImg(img_url, imageName, articleno);
                                Elements chapterUrlElements = contentDocument.select("div div.info-right div.catalog ul.clearfix li a");
                                for (Element chapterUrlElement : chapterUrlElements) {
                                    String chapterName = chapterUrlElement.text();
                                    logger.debug("章节名称：{}", chapterName);
                                    String chapterUrl = chapterUrlElement.attr("href");
                                    logger.debug("章节地址：{}", chapterUrl);
                                    if (!StringUtils.contains(chapterUrl, URL)) {
                                        chapterUrl = URL + chapterUrl;
                                    }
                                    Document chapterContentDocument = Jsoup.connect(chapterUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36").timeout(5000).get();

                                    Elements contentElements = chapterContentDocument.select("div#mycontent");
                                    String content = contentElements.text();
                                    String htmlContent = contentElements.html();
                                    logger.debug("章节的内容：{}", content);
                                    logger.debug("章节的HTML内容：{}", htmlContent);
                                    Chapter chapter = new Chapter();
                                    chapter.setArticlename(title);
                                    chapter.setArticleno(articleno);
                                    chapter.setChaptername(chapterName);
                                    chapter.setChaptertype((short) 0);
                                    chapter.setPostdate(new Date());
                                    chapter.setSize(StringUtils.length(content));
                                    chapter.setModifytime(new Date());
                                    chapter.setModifyuserno(0);
                                    chapter.setPublishtime(new Date());
                                    chapter.setIspublish(true);
                                    chapter.setLastchecktime(new Date());
                                    chapter.setContent(htmlContent);
                                    chapterService.save(chapter);
//                                    try {
//                                        Utils.saveContext(chapter.getArticleno(), chapter.getChapterno(), content);
//                                    } catch (Exception e) {
//
//                                    }
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
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });


                    Thread.sleep(5000);

                }


                // }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static final Map<String, Integer> TOP_NAME_MAP = new LinkedHashMap<String, Integer>() {
        {
            put("dsyq", 3);
            put("wxxz", 2);
            put("cyjk", 1);
            put("jsls", 4);
            put("khjj", 7);
            put("ghxy", 8);
        }
    };


    private void saveImg(String src, String imageName, int articleno) {
        try {
            //连接url
            java.net.URL url = new java.net.URL(src);
            URLConnection uri = url.openConnection();
            //获取数据流
            InputStream is = uri.getInputStream();
            String path = TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.SYSTEM_PATH) + TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.RELATIVE_IAMGE_PATH);
            path = path + "/" + articleno
                    / TaoToTaoConstants.SUB_DIR_ARTICLES + "/" + articleno + "/" + articleno + "s."
                    + StringUtils.substringAfterLast(imageName, ".");
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


}
