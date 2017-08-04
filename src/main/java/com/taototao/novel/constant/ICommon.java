package com.taototao.novel.constant;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-24 14:01
 **/
public interface ICommon {

    String themes=TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.THEME_NAME);


    String CACHE_NAME="taototao.com";
    String BLOCKS_CACHE_KEY="BLOCKS";
    String CHAPTER_CACHE_KEY="CHAPTER_%s";
}
