/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : studying

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-02-07 15:40:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `claID` int(10) NOT NULL AUTO_INCREMENT,
  `claName` varchar(255) DEFAULT NULL,
  `claCharger` varchar(255) DEFAULT NULL,
  `claPeople` int(5) DEFAULT NULL,
  PRIMARY KEY (`claID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', 'a', 'aa', '85');
INSERT INTO `classes` VALUES ('2', 'b', 'bob', '20');
INSERT INTO `classes` VALUES ('3', 'c', 'claus', '30');
INSERT INTO `classes` VALUES ('4', 'd', 'digence', '40');
INSERT INTO `classes` VALUES ('5', 'e', 'elisbai', '50');
INSERT INTO `classes` VALUES ('6', 'f', 'frok', '50');
INSERT INTO `classes` VALUES ('7', 'g', 'gog', '70');
INSERT INTO `classes` VALUES ('8', 'h', 'jk', '21');
INSERT INTO `classes` VALUES ('9', 'i', 'll', '45');
INSERT INTO `classes` VALUES ('10', 'j', 'gyu', '54');
INSERT INTO `classes` VALUES ('11', 'k', 'dse', '55');
INSERT INTO `classes` VALUES ('12', 'l', 'we', '71');
INSERT INTO `classes` VALUES ('13', 'm', 'wsd', '57');
INSERT INTO `classes` VALUES ('14', 'n', 'in', '37');
INSERT INTO `classes` VALUES ('15', 'o', 'uh', '34');
INSERT INTO `classes` VALUES ('16', 'p', 'yw', '36');
INSERT INTO `classes` VALUES ('17', 'q', 'ks', '64');
INSERT INTO `classes` VALUES ('18', 'r', 'wl', '61');
INSERT INTO `classes` VALUES ('19', 's', 'us', '57');
INSERT INTO `classes` VALUES ('20', 't', 'ee', '55');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `is_active` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('7', 'role_1517988346272', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuID` int(10) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(255) DEFAULT NULL,
  `stuSex` varchar(5) DEFAULT NULL,
  `stuAge` int(5) DEFAULT NULL,
  `registerTime` date DEFAULT NULL,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('6', 'user_1517988346272', 'role_1517988346272');
