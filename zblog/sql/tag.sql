/*
 Navicat Premium Data Transfer

 Source Server         : my-server
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 47.92.251.247:8089
 Source Schema         : zblog

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 18/05/2020 17:17:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
