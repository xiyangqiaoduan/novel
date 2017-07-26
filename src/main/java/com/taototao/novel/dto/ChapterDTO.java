package com.taototao.novel.dto;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.ChapterFrontController;
import com.taototao.novel.controller.ReaderController;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.entity.Chapter;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-25 15:18
 **/
public class ChapterDTO extends Chapter {

    /**
     * 下一章章节编号
     */
    private int nextChapterno;
    /**
     * 上一章章节编号
     */
    private int preChapterno;
    /**
     * 章节内容
     */
    private String content;

    /**
     * 拼音
     */
    private String pinyin;


    public int getNextChapterno() {
        return nextChapterno;
    }

    public void setNextChapterno(int nextChapterno) {
        this.nextChapterno = nextChapterno;
    }

    public int getPreChapterno() {
        return preChapterno;
    }

    public void setPreChapterno(int preChapterno) {
        this.preChapterno = preChapterno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }


    /**
     * 获取下一章章节URL
     *
     * @return 下一章章节URL
     */

    public String getNextChapterUrl() {

        if (getNextChapterno() != 0) {
            StringBuffer sb = new StringBuffer(AbstractPublicBaseController.READER_NAMES);
            sb.append("/")
                    .append(ReaderController.CHAPTER_DETAIL)
                    .append("/")
                    .append(getSubdir())
                    .append("/")
                    .append(getArticleno())
                    .append("/")
                    .append(getNextChapterno());
            return sb.toString();
        } else {
            if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE, false)) {
                return getChapterListUrl();
            } else {
                String url = getInfoUrl();
                return url;
            }
        }
    }



    /**
     * 获取上一章章节URL
     *
     * @return 上一章章节URL
     */
    public String getPreChapterUrl() {

        if (getPreChapterno() != 0) {


            StringBuffer sb = new StringBuffer(AbstractPublicBaseController.READER_NAMES);
            sb.append("/")
                    .append(ReaderController.CHAPTER_DETAIL)
                    .append("/")
                    .append(getSubdir())
                    .append("/")
                    .append(getArticleno())
                    .append("/")
                    .append(getPreChapterno());
            return sb.toString();

        } else {
            if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE, false)) {
                return getChapterListUrl();
            } else {
                String url = getInfoUrl();
                return url;
            }
        }
    }


    /**
     * 获取章节列表URL
     *
     * @return 分类列表URL
     */
    public String getChapterListUrl() {
        StringBuffer sb = new StringBuffer(AbstractPublicBaseController.INFO_NAMES);
        sb.append("/").append(ChapterFrontController.LIST).append("/")
                .append(getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES)
                .append("/")
                .append(getArticleno())
                .append("/")
                .append(getPinyin().toLowerCase());
        return sb.toString();
    }

    /**
     * 获取小说介绍页URL
     *
     * @return 小说介绍页URL
     */
    public String getInfoUrl() {
        StringBuffer sb = new StringBuffer(AbstractPublicBaseController.INFO_NAMES);
        sb.append("/")
                .append(getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES)
                .append("/")
                .append(getArticleno())
                .append("/")
                .append(getPinyin().toLowerCase());
        return sb.toString();
    }


}
