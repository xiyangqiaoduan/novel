/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : novel

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-07-21 17:26:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `articleno` int(11) NOT NULL AUTO_INCREMENT,
  `articlename` varchar(100) DEFAULT NULL,
  `pinyin` varchar(400) DEFAULT NULL,
  `pinyinheadchar` varchar(32) DEFAULT NULL,
  `initial` char(1) DEFAULT NULL,
  `keywords` varchar(500) DEFAULT NULL,
  `authorid` int(11) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `category` int(11) DEFAULT '0',
  `subcategory` int(11) DEFAULT NULL,
  `intro` text,
  `lastchapterno` int(11) DEFAULT NULL,
  `lastchapter` varchar(50) DEFAULT NULL,
  `chapters` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT '0',
  `fullflag` tinyint(4) DEFAULT NULL,
  `imgflag` smallint(6) DEFAULT NULL,
  `agent` varchar(50) DEFAULT NULL,
  `firstflag` tinyint(4) DEFAULT NULL,
  `permission` int(11) DEFAULT NULL,
  `authorflag` tinyint(4) DEFAULT NULL,
  `postdate` datetime DEFAULT NULL,
  `lastupdate` datetime DEFAULT NULL,
  `dayvisit` int(10) unsigned DEFAULT '0',
  `weekvisit` int(11) DEFAULT '0',
  `monthvisit` int(11) DEFAULT '0',
  `allvisit` int(11) DEFAULT '0',
  `dayvote` int(11) DEFAULT '0',
  `weekvote` int(11) DEFAULT NULL,
  `monthvote` int(11) DEFAULT NULL,
  `allvote` int(11) DEFAULT NULL,
  `deleteflag` tinyint(4) DEFAULT NULL,
  `publicflag` int(11) DEFAULT NULL,
  `createuserno` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `usecustomizeinfotitle` tinyint(4) DEFAULT NULL,
  `infotitle` varchar(150) DEFAULT NULL,
  `infokeywords` varchar(150) DEFAULT NULL,
  `infodescription` varchar(200) DEFAULT NULL,
  `usecustomizelisttitle` tinyint(4) DEFAULT NULL,
  `listtitle` varchar(150) DEFAULT NULL,
  `listkeywords` varchar(150) DEFAULT NULL,
  `listdescription` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`articleno`),
  KEY `t_article_articlename_index` (`articlename`),
  KEY `t_article_pinyin_index` (`pinyin`(255)),
  KEY `t_article_author_index` (`author`),
  KEY `t_article_category_idx` (`category`),
  KEY `t_article_category_lastupdate_lastchapterno_deleteflag_idx` (`category`,`lastupdate`,`lastchapterno`,`deleteflag`),
  KEY `t_article_lastupdate_index` (`lastupdate`),
  KEY `t_article_allvisit_index` (`allvisit`),
  KEY `t_article_allvote_index` (`allvote`),
  KEY `t_article_monthvisit_index` (`monthvisit`),
  KEY `t_article_weekvote_index` (`weekvote`),
  KEY `t_article_dayvisit_index` (`dayvisit`),
  KEY `t_article_dayvote_index` (`dayvote`),
  KEY `t_article_postdate_index` (`postdate`),
  KEY `t_article_size_index` (`size`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '诛仙达摩祖师', 'ZHUXIANDAMOZUSHI', null, null, '', '0', '西红柿鸡蛋汤', '1', '0', '诛仙达摩祖师，传说无敌修炼成道', '0', null, '0', '0', '0', '3', '斗鸡眼', '0', '2', '0', '2017-07-20 14:38:00', null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '2017-07-21 12:59:57', '0', '', '', '', '0', '', '', '');
INSERT INTO `t_article` VALUES ('2', '测试', 'CESHI2', null, null, 'wqwqqw', '0', '嗷嗷嗷', '1', '0', 'qww', '0', null, '0', '0', '0', '0', '111', '0', '2', '0', '2017-07-20 14:38:26', null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '2017-07-20 10:38:44', '0', '', '', '', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('4', '测试', 'CESHI3', null, null, '测试', '0', '嗷嗷嗷', '1', '0', 'assas', '0', null, '0', '0', '0', '0', '111', '0', '1', '0', '2017-08-19 07:18:00', null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '2017-07-20 13:58:45', '0', '', '', '', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('5', '测试', 'CESHI4', null, null, '测试', '0', '嗷嗷嗷', '1', '0', 'assas', '0', null, '0', '0', '0', '3', '111', '0', '1', '0', '2017-08-19 07:18:00', null, '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', null, '0', '2017-07-20 16:39:12', '0', '', '', '', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('6', '测试', 'CESHI5', null, null, '测试', '0', '嗷嗷嗷', '1', '0', 'assas', '0', null, '0', '0', '0', '3', '111', '0', '1', '0', '2017-08-19 07:18:00', null, '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', null, '0', '2017-07-20 16:39:12', '0', '', '', '', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('7', '测试', 'CESHI6', null, null, '测试', '0', '嗷嗷嗷', '1', '0', 'assas', '0', null, '0', '0', '0', '3', '111', '0', '1', '0', '2017-08-19 07:18:00', null, '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', null, '0', '2017-07-20 16:30:14', '0', '', '', '', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for t_bookcase
-- ----------------------------
DROP TABLE IF EXISTS `t_bookcase`;
CREATE TABLE `t_bookcase` (
  `bookcaseno` int(11) NOT NULL AUTO_INCREMENT,
  `articleno` int(11) DEFAULT NULL,
  `articlename` varchar(100) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `userno` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `chapterno` int(11) DEFAULT NULL,
  `chaptername` varchar(100) DEFAULT NULL,
  `lastvisit` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deleteflag` tinyint(1) DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`bookcaseno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bookcase
-- ----------------------------

-- ----------------------------
-- Table structure for t_chapter
-- ----------------------------
DROP TABLE IF EXISTS `t_chapter`;
CREATE TABLE `t_chapter` (
  `chapterno` int(11) NOT NULL AUTO_INCREMENT,
  `articleno` int(11) DEFAULT NULL,
  `articlename` varchar(100) DEFAULT NULL,
  `chaptertype` tinyint(4) DEFAULT NULL,
  `chaptername` varchar(100) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `isvip` tinyint(4) DEFAULT NULL,
  `postdate` datetime DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `ispublish` tinyint(4) DEFAULT NULL,
  `lastchecktime` datetime DEFAULT NULL,
  `deleteflag` tinyint(4) DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`chapterno`),
  KEY `t_chapter_articleno_index` (`articleno`),
  KEY `t_chapter_articleno_chapterno_deleteflag_chaptertype_index` (`articleno`,`chapterno`,`deleteflag`,`chaptertype`),
  KEY `t_chapter_chaptername_index` (`chaptername`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_chapter
-- ----------------------------
INSERT INTO `t_chapter` VALUES ('1', '1', '诛仙达摩祖师', '0', '第一章 话说曹操，见到张飞，关羽在哪里', '253', '0', '2017-07-21 12:42:22', '2017-07-21 10:36:59', '1', '2017-07-21 10:36:59', '1', '0', '2017-07-21 12:47:45');

-- ----------------------------
-- Table structure for t_credit_history
-- ----------------------------
DROP TABLE IF EXISTS `t_credit_history`;
CREATE TABLE `t_credit_history` (
  `credithistoryno` int(11) NOT NULL AUTO_INCREMENT,
  `userno` int(11) DEFAULT NULL,
  `loginid` varchar(32) DEFAULT NULL,
  `articleno` int(11) DEFAULT NULL,
  `articlename` varchar(100) DEFAULT NULL,
  `chapterno` int(11) DEFAULT NULL,
  `chaptername` varchar(100) DEFAULT NULL,
  `creditpoint` int(11) DEFAULT NULL,
  `deleteflag` tinyint(4) DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`credithistoryno`),
  KEY `t_credithistory_userno_index` (`userno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_credit_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `messageno` int(11) NOT NULL AUTO_INCREMENT,
  `userno` int(11) DEFAULT NULL,
  `loginid` varchar(32) DEFAULT NULL,
  `touserno` int(11) DEFAULT NULL,
  `tologinid` varchar(32) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `category` smallint(6) DEFAULT NULL,
  `isread` tinyint(4) DEFAULT NULL,
  `postdate` datetime DEFAULT NULL,
  `deleteflag` tinyint(4) DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`messageno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', '1', '1', '1', '1', '1', '11', '1', '0', '2017-07-21 16:22:55', '0', '0', '2017-07-21 17:26:24');

-- ----------------------------
-- Table structure for t_review
-- ----------------------------
DROP TABLE IF EXISTS `t_review`;
CREATE TABLE `t_review` (
  `reviewno` int(11) NOT NULL AUTO_INCREMENT,
  `userno` int(11) DEFAULT NULL,
  `loginid` varchar(50) DEFAULT NULL,
  `articleno` int(11) DEFAULT NULL,
  `articlename` varchar(100) DEFAULT NULL,
  `chapterno` int(11) DEFAULT NULL,
  `chaptername` varchar(100) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `review` varchar(500) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `postdate` datetime DEFAULT NULL,
  `deleteflag` tinyint(4) DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`reviewno`),
  KEY `t_review_articleno` (`articleno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_review
-- ----------------------------
INSERT INTO `t_review` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-07-21 17:08:00', '0', '1', '2017-07-21 17:07:57');

-- ----------------------------
-- Table structure for t_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `t_subscribe`;
CREATE TABLE `t_subscribe` (
  `subscribeno` int(11) NOT NULL AUTO_INCREMENT,
  `userno` int(11) DEFAULT NULL,
  `articleno` int(11) DEFAULT NULL,
  PRIMARY KEY (`subscribeno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subscribe
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_block
-- ----------------------------
DROP TABLE IF EXISTS `t_system_block`;
CREATE TABLE `t_system_block` (
  `blockno` int(11) NOT NULL AUTO_INCREMENT,
  `blockid` varchar(32) DEFAULT NULL,
  `blockname` varchar(32) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `sortcol` varchar(32) DEFAULT NULL,
  `isasc` tinyint(1) DEFAULT NULL,
  `isfinish` tinyint(1) DEFAULT NULL,
  `limitnum` int(11) DEFAULT NULL,
  `content` text,
  `target` smallint(6) DEFAULT NULL,
  `deleteflag` tinyint(1) DEFAULT '0',
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`blockno`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_block
-- ----------------------------
INSERT INTO `t_system_block` VALUES ('1', 'last_update_list', '最新更新列表', '10', null, 'lastupdate', '0', null, '15', null, '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('2', 'last_insert_list', '最新入库', '10', null, 'postdate', '0', null, '15', null, '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('3', 'friend_link', '友情链接', '30', null, null, null, null, null, '< a href = \"http://www.51yd.org\" target = \"_blank\" > 易读小说系统 </ a >', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('4', 'index_yanqing_tuijian', '首页言情推荐', '20', null, null, null, null, null, '1,\r\n		2,\r\n		3,\r\n		4', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('5', 'index_xuanhuan_tuijian', '首页玄幻推荐', '20', null, null, null, null, null, '1,\r\n		2,\r\n		3,\r\n		4', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('6', 'index_junshi_tuijian', '首页军事推荐', '20', null, null, null, null, null, '1,\r\n		2,\r\n		3,\r\n		4', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('7', 'index_kongbu_tuijian', '首页恐怖灵异推荐', '20', null, null, null, null, null, '1,\r\n		2,\r\n		3,\r\n		4', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('8', 'index_wuxia_tuijian', '首页武侠修真推荐', '20', null, null, null, null, null, '1,\r\n		2,\r\n		3,\r\n		4', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('9', 'last_update_list_mobile', '手机页面更新列表', '10', null, 'lastupdate', '0', null, '6', null, '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('10', 'index_hot_list_mobile', '手机页热点', '20', null, null, '0', null, null, '58755,\r\n		58754,\r\n		58753', '6', '0', null, null);
INSERT INTO `t_system_block` VALUES ('11', 'info_random_recommand_list', '简介页随机推荐列表', '40', null, null, null, null, '6', null, '2', '0', null, null);
INSERT INTO `t_system_block` VALUES ('12', 'chapterList_randomrecommand_list', '章节列表页随机推荐列表', '40', null, null, null, null, '6', null, '3', '0', null, null);
INSERT INTO `t_system_block` VALUES ('13', 'reader_random_recommand_list', '阅读页随机推荐列表', '40', null, null, null, null, '6', null, '4', '0', null, null);
INSERT INTO `t_system_block` VALUES ('14', 'reader_recommand_list', '阅读页推荐列表', '50', null, null, null, null, '6', null, '4', '0', null, null);
INSERT INTO `t_system_block` VALUES ('15', 'info_recommand_list', '简介页推荐列表', '50', null, null, null, null, '6', null, '2', '0', null, null);
INSERT INTO `t_system_block` VALUES ('16', 'chapterList_recommand_list', '章节列表页推荐列表', '50', null, null, null, null, '6', null, '3', '0', null, null);
INSERT INTO `t_system_block` VALUES ('17', 'test_block', '测试区块搜索', '10', '1', 'lastupdate', '1', '1', '18', '1,\r\n3,\r\n4', '3', '1', '0', '2017-07-19 10:51:16');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userno` int(11) NOT NULL AUTO_INCREMENT,
  `loginid` varchar(32) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `lastlogin` datetime DEFAULT NULL,
  `lineno` varchar(32) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  `votecount` int(11) DEFAULT NULL,
  `realname` varchar(10) DEFAULT NULL,
  `id` varchar(18) DEFAULT NULL,
  `mobileno` varchar(11) DEFAULT NULL,
  `branch` varchar(50) DEFAULT NULL,
  `bankno` varchar(20) DEFAULT NULL,
  `alipayacount` varchar(50) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `subcategory` int(11) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  `activedflag` tinyint(4) DEFAULT NULL,
  `mailtoken` varchar(32) DEFAULT NULL,
  `deleteflag` tinyint(4) DEFAULT NULL,
  `modifyuserno` int(11) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`userno`),
  KEY `t_user_openid_deleteflag_index` (`openid`,`deleteflag`),
  KEY `t_user_loginid_password_deleteflag_index` (`loginid`,`password`,`deleteflag`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'yangcb1', 'dfb1dc99d556080cee3ef9c10adc2f1b', '佚名1', 'xiyangqiaoduan@126.com', '2017-07-21 15:00:02', '1', '1253245019w', null, 'LineNo1111', '10', '0', '测试1', '1234567890121', '18612568888', '北京银行1', '1234567891234567891', '1234567891234567891', '0', '0', null, '0', null, '0', '0', null);
