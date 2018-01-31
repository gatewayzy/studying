/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : javatools

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-09-11 21:31:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('2', 'zhangsan', 'Sat Jul 16 18:31:56 CST 2016');
INSERT INTO `customer` VALUES ('3', 'zhangsan111', 'Sat Jul 16 19:52:16 CST 2016');
INSERT INTO `customer` VALUES ('4', 'zhangsan', 'Sat Jul 16 18:33:47 CST 2016');
INSERT INTO `customer` VALUES ('5', 'zhangsan', 'Sat Jul 16 18:33:47 CST 2016');
INSERT INTO `customer` VALUES ('6', 'zhangsan', 'Sat Jul 16 18:33:48 CST 2016');
INSERT INTO `customer` VALUES ('7', 'zhangsan', 'Sat Jul 16 18:36:01 CST 2016');
INSERT INTO `customer` VALUES ('8', 'zhangsan', 'Sat Jul 16 18:36:02 CST 2016');
INSERT INTO `customer` VALUES ('9', 'zhangsan', 'Sat Jul 16 18:36:02 CST 2016');
INSERT INTO `customer` VALUES ('10', 'zhangsan', 'Sat Jul 16 19:52:14 CST 2016');
INSERT INTO `customer` VALUES ('11', 'zhangsan', 'Sat Jul 16 19:52:15 CST 2016');
INSERT INTO `customer` VALUES ('12', 'zhangsan', 'Sat Jul 16 19:52:15 CST 2016');

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user1
-- ----------------------------
INSERT INTO `user1` VALUES ('1', 'zhangsan');
INSERT INTO `user1` VALUES ('2', 'zhangsan');
