package com.taototao.novel.job;

import com.taototao.novel.constant.ICommon;
import com.taototao.novel.utils.EhcacheManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务清除缓存
 *
 * @author yangcb
 * @create 2017-08-08 14:36
 **/


@Component
public class CacheJob {

    private static final Logger logger= LoggerFactory.getLogger(CacheJob.class);

    @Autowired
    private EhcacheManagerUtils ehcacheManagerUtils;

    @Scheduled(cron = "0 0 7 * * ?")
    public void clearCache(){
        logger.debug("start ----------->删除缓存信息");
        ehcacheManagerUtils.clear(ICommon.CACHE_NAME);
        logger.debug("end ----------->删除缓存信息");
    }

}
