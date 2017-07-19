/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Version : 50633
 Source Host           : localhost
 Source Database       : classwork

 Target Server Version : 50633
 File Encoding         : utf-8

 Date: 07/19/2017 00:00:02 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `fullname` varchar(40) DEFAULT NULL,
  `idcard` varchar(40) DEFAULT NULL,
  `registertime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `logintime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `registerIp` varchar(40) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `nickname` varchar(40) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `qq` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
