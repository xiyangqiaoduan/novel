package com.taototao.novel.init;

import com.taototao.novel.constant.TaoToTaoConstants;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-14 17:24
 **/
@Component
public class InitializationProcessor implements ApplicationListener<ContextRefreshedEvent> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {

            // 设定文件初期读入
            PropertiesConfiguration taoToTaoConf = new PropertiesConfiguration("taototao.properties");
            // 设定文件自动更新
            FileChangedReloadingStrategy reloadStrategy = new FileChangedReloadingStrategy();
            taoToTaoConf.setReloadingStrategy(reloadStrategy);
            TaoToTaoConstants.taoToTaoConf = taoToTaoConf;

            // 加载伪原创设置
            TaoToTaoConstants.pseudoConf = new PropertiesConfiguration("pseudo.properties");
            TaoToTaoConstants.pseudoConf.setReloadingStrategy(reloadStrategy);


            // 初始化分类信息MAP
            // CategoryCacheManager.initCategoryCacheManager();

            logger.info("Initialize successfully.");


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }


}

