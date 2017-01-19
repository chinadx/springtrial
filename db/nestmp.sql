/*
Navicat MySQL Data Transfer

Source Server         : local-root
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : nestmp

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-01-19 16:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(512) NOT NULL COMMENT '请求完整路径',
  `path` varchar(256) NOT NULL COMMENT '请求相对路径',
  `ip` varchar(128) DEFAULT NULL COMMENT '请求IP',
  `ua` varchar(1024) DEFAULT NULL COMMENT '请求UA',
  `tm` datetime NOT NULL COMMENT '请求时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'http://192.168.1.7:8080/users', '/users', '192.168.1.7', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-23 15:21:51');
INSERT INTO `sys_log` VALUES ('2', 'http://localhost:8080/users/2', '/users/2', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-23 15:21:53');
INSERT INTO `sys_log` VALUES ('3', 'http://localhost:8080/users', '/users', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-23 15:22:14');
INSERT INTO `sys_log` VALUES ('4', 'http://192.168.1.7:8080/users/2', '/users/2', '192.168.1.7', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-23 15:22:18');
INSERT INTO `sys_log` VALUES ('5', 'http://192.168.1.7:8080/users/2', '/users/2', '192.168.1.246', 'Mozilla/5.0 (iPhone; CPU iPhone OS 10_2 like Mac OS X) AppleWebKit/602.3.12 (KHTML, like Gecko) Mobile/14C92 MicroMessenger/6.5.2 NetType/WIFI Language/zh_CN', '2016-12-23 15:22:43');
INSERT INTO `sys_log` VALUES ('6', 'http://localhost:8080/users', '/users', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-23 15:45:53');
INSERT INTO `sys_log` VALUES ('7', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-29 17:25:46');
INSERT INTO `sys_log` VALUES ('8', 'http://localhost:8080/users/1', '/users/1', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-29 17:26:01');
INSERT INTO `sys_log` VALUES ('9', 'http://localhost:8080/users/1', '/users/1', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-29 17:26:01');
INSERT INTO `sys_log` VALUES ('10', 'http://localhost:8080/users/1', '/users/1', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2016-12-29 17:26:50');
INSERT INTO `sys_log` VALUES ('11', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:16:15');
INSERT INTO `sys_log` VALUES ('12', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:16:54');
INSERT INTO `sys_log` VALUES ('13', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:17:53');
INSERT INTO `sys_log` VALUES ('14', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:20:34');
INSERT INTO `sys_log` VALUES ('16', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:23:36');
INSERT INTO `sys_log` VALUES ('18', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:25:30');
INSERT INTO `sys_log` VALUES ('19', 'http://localhost:8080/users/', '/users/', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-03 16:25:38');
INSERT INTO `sys_log` VALUES ('21', 'http://localhost:8080/users', '/users', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', '2017-01-04 10:15:45');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '黄鹤', '56', '123456');
INSERT INTO `user` VALUES ('2', '小姨子', '18', '123456');
INSERT INTO `user` VALUES ('3', '厂长夫人', '54', '123456');
