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

 Date: 17/04/2022 22:23:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for User_Role
-- ----------------------------
DROP TABLE IF EXISTS `User_Role`;
CREATE TABLE `User_Role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `rid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of User_Role
-- ----------------------------
BEGIN;
INSERT INTO `User_Role` VALUES (1, 1, 3);
INSERT INTO `User_Role` VALUES (2, 2, 3);
INSERT INTO `User_Role` VALUES (3, 3, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
