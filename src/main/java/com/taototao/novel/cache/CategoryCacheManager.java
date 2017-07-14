package com.taototao.novel.cache;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * <p>
 * 分类信息管理器
 * </p>
 */
public class CategoryCacheManager {

	/**
	 * 输出log
	 */
	private static Log logger = LogFactory.getLog(CategoryCacheManager.class);
	/**
	 * 分类信息MAP
	 */
	private static Map<String, String> categoryMap;

	/**
	 * 分类信息处理线程
	 */
	private static Thread loadCategoryThread;

	/**
	 * 获得分类信息
	 * 
	 * @param key
	 *            键值
	 * @return 分类信息
	 */
	public static String getCategoryInfoById(String key) {

		if (categoryMap.get(key) != null) {
			return categoryMap.get(key);
		}
		return "其他分类";
	}

	/**
	 * 获得分类信息
	 * 
	 * @return 分类信息
	 */
	public static Map<String, String> getCategoryInfo() {
		return categoryMap;
	}

	/**
	 * 初始化分类信息管理器
	 */
	public static void initCategoryCacheManager() {

		logger.info("going to init ArticleCountManager.");

		categoryMap = new LinkedHashMap<String, String>();

		loadCategoryThread = new Thread(new Runnable() {

			public void run() {

				logger.info("start CategoryCache Manager daemon process.");

				while (true) {
					try {
						logger.info("CategoryCache Manager daemon process going to load info.");
						PropertiesConfiguration languageConf = new PropertiesConfiguration(
								Thread.currentThread()
										.getContextClassLoader()
										.getResource(
												"language/package.properties"));
						String value = languageConf
								.getString("collectionProperties.article.category");
						String[] items = StringUtils.split(value, ",");
						for (int j = 0; j < items.length; j++) {
							String[] property = StringUtils
									.split(items[j], ":");
							if (property.length == 2) {
								categoryMap.put(property[0], property[1]);
							}
						}
						logger.debug("CategoryCache Manager daemon process going to sleep.");

						Thread.sleep(TaoToTaoConstants.taoToTaoConf.getInt(
								TaoToTaoConfig.RELOAD_ARTICLE_COUNT_INTERVAL, 120) * 60 * 1000);

					} catch (Exception e) {
						if (!(e instanceof InterruptedException)) {
							logger.error("init CategoryCache failed.", e);
						}
						break;
					}
				}
			}
		});
		loadCategoryThread.start();
		logger.info("init ArticleCountManager normally end.");
	}

	/**
	 * 销毁分类信息缓存
	 */
	public static void dispose() {
		loadCategoryThread.interrupt();
		try {
			loadCategoryThread.join();
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
		categoryMap.clear();
		categoryMap = null;
	}

}
