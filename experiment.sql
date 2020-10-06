/*
 Navicat Premium Data Transfer

 Source Server         : link1
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : experiment

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 06/10/2020 17:34:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int NOT NULL COMMENT '课程编号',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `experiment_hours` int NOT NULL COMMENT '实验学时',
  `classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `teaching_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授课院系',
  `teaching_term` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (15054037, '数字电视原理', 12, '电0501，信0501，计0501', '机械与电气工程', '第三学期');
INSERT INTO `course` VALUES (15054038, '计算机组成原理', 12, '计0312，计0313', '计算机科学与技术', '第三学期');

-- ----------------------------
-- Table structure for experiment
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment`  (
  `course_id` int NOT NULL COMMENT '课程编号',
  `experiment_id` int NOT NULL COMMENT '实验序号',
  `experiment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验名',
  `experiment_ category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验类',
  `difficulty` int NOT NULL COMMENT '难度',
  `hours` int NOT NULL COMMENT '学时',
  `schedule_weeks` int NOT NULL COMMENT '安排周次',
  PRIMARY KEY (`experiment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES (15054037, 1505403701, '音视频AD-DA实验', '验证性', 1, 2, 3);
INSERT INTO `experiment` VALUES (15054037, 1505403702, '音频编码实验', '验证性', 2, 2, 5);
INSERT INTO `experiment` VALUES (15054037, 1505403703, '视频编码实验', '演示性', 1, 1, 9);
INSERT INTO `experiment` VALUES (15054038, 1505403801, 'ROM实验', '验证性', 2, 2, 8);
INSERT INTO `experiment` VALUES (15054038, 1505403802, 'CACHE实验', '演示性', 1, 1, 7);

-- ----------------------------
-- Table structure for experimenter
-- ----------------------------
DROP TABLE IF EXISTS `experimenter`;
CREATE TABLE `experimenter`  (
  `id` int NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experimenter
-- ----------------------------
INSERT INTO `experimenter` VALUES (1, '盛老师', 'sheng', '123');
INSERT INTO `experimenter` VALUES (2, '陈老师', 'chen', '123');
INSERT INTO `experimenter` VALUES (3, '刘老师', 'liu', '123');
INSERT INTO `experimenter` VALUES (4, '吴老师', 'wu', '123');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory`  (
  `room` int NOT NULL,
  PRIMARY KEY (`room`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES (310);
INSERT INTO `laboratory` VALUES (311);
INSERT INTO `laboratory` VALUES (410);

SET FOREIGN_KEY_CHECKS = 1;
