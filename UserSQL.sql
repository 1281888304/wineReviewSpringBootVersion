/*
 Navicat Premium Data Transfer

 Source Server         : jdbc
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : WineApplication

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 17/04/2022 22:23:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint DEFAULT NULL,
  `locked` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES (1, '1281888304', '$2a$10$ro0AmDyBFIK9rujYEas0F.V7lkTynM0YUFmNs/z6/Sz9Th5yEOSRC', 1, 0);
INSERT INTO `User` VALUES (2, 'qinghang', '$2a$10$ufM6j5GdXLXjEGB8xrECUO2/Ke2vcoeWz84Dgfli3Vl6QgirfLRS6', 1, 0);
INSERT INTO `User` VALUES (3, 'test', '$2a$10$qvDEHomPRxb6u7Pmlytr2.W3DNXaMckZkpmuN8JjrwtkxzxQgwbvC', 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
