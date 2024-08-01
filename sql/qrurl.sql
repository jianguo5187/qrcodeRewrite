/*
 Navicat Premium Data Transfer

 Source Server         : localhost(qrUrl)
 Source Server Type    : MySQL
 Source Server Version : 50726 (5.7.26)
 Source Host           : localhost:3306
 Source Schema         : qrurl

 Target Server Type    : MySQL
 Target Server Version : 50726 (5.7.26)
 File Encoding         : 65001

 Date: 01/08/2024 23:44:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_entry_domain
-- ----------------------------
DROP TABLE IF EXISTS `sys_entry_domain`;
CREATE TABLE `sys_entry_domain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入口域名ID',
  `web_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'web识别key',
  `qr_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入口域名',
  `web_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站名称',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入口域名表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_entry_domain
-- ----------------------------

-- ----------------------------
-- Table structure for sys_main_domain
-- ----------------------------
DROP TABLE IF EXISTS `sys_main_domain`;
CREATE TABLE `sys_main_domain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '落地域名ID',
  `web_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'web识别key',
  `main_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '落地域名',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '落地域名表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_main_domain
-- ----------------------------
INSERT INTO `sys_main_domain` VALUES (1, '1', 'http://123.sctgxs.cn', '0', '2024-08-01 23:28:44');

SET FOREIGN_KEY_CHECKS = 1;
