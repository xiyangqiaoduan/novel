/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : novel

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-07-17 18:08:08
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
  PRIMARY KEY (`articleno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------

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
  PRIMARY KEY (`chapterno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_chapter
-- ----------------------------

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
  PRIMARY KEY (`credithistoryno`)
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------

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
  PRIMARY KEY (`reviewno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_review
-- ----------------------------

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
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`blockno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_block
-- ----------------------------

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
  PRIMARY KEY (`userno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
