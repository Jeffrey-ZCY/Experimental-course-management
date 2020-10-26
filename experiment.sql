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

 Date: 21/10/2020 09:43:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrators_login
-- ----------------------------
DROP TABLE IF EXISTS `administrators_login`;
CREATE TABLE `administrators_login`  (
  `id` int NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrators_login
-- ----------------------------
INSERT INTO `administrators_login` VALUES (1000, '1000');

-- ----------------------------
-- Table structure for class_schedule
-- ----------------------------
DROP TABLE IF EXISTS `class_schedule`;
CREATE TABLE `class_schedule`  (
  `course_id` int NOT NULL,
  `total_number` int NOT NULL,
  `experiment_id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experiment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experiment_room` int NOT NULL,
  `batch` int NOT NULL,
  `stu_number` int NOT NULL,
  PRIMARY KEY (`experiment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_schedule
-- ----------------------------
INSERT INTO `class_schedule` VALUES (15054037, 200, 1505403701, '吴老师', '第三周周四晚上', 310, 1, 11);

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
  `experiment_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验类',
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
-- Table structure for experiment_score
-- ----------------------------
DROP TABLE IF EXISTS `experiment_score`;
CREATE TABLE `experiment_score`  (
  `experiment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_id` int NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experiment_score` int NOT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment_score
-- ----------------------------
INSERT INTO `experiment_score` VALUES ('ROM实验', '计算机组成原理', 11, '程咬金', '计0312', 90);

-- ----------------------------
-- Table structure for experimenter
-- ----------------------------
DROP TABLE IF EXISTS `experimenter`;
CREATE TABLE `experimenter`  (
  `id` int NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experimenter
-- ----------------------------
INSERT INTO `experimenter` VALUES (1, '盛老师');
INSERT INTO `experimenter` VALUES (2, '陈老师');
INSERT INTO `experimenter` VALUES (3, '刘老师');
INSERT INTO `experimenter` VALUES (4, '吴老师');
INSERT INTO `experimenter` VALUES (5, '李老师');

-- ----------------------------
-- Table structure for experimenter_login
-- ----------------------------
DROP TABLE IF EXISTS `experimenter_login`;
CREATE TABLE `experimenter_login`  (
  `id` int NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experimenter_login
-- ----------------------------
INSERT INTO `experimenter_login` VALUES (1, '1');
INSERT INTO `experimenter_login` VALUES (2, '2');
INSERT INTO `experimenter_login` VALUES (3, '3');
INSERT INTO `experimenter_login` VALUES (4, '4');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory`  (
  `room` int NOT NULL,
  `number` int NOT NULL,
  PRIMARY KEY (`room`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES (310, 60);
INSERT INTO `laboratory` VALUES (311, 60);
INSERT INTO `laboratory` VALUES (410, 60);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `stu_id` int NOT NULL,
  `stu_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  `experiment_id` int NULL DEFAULT NULL,
  `total_score` int NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (11, '计0312', 15054038, 1505403801, 80);
INSERT INTO `students` VALUES (12, '计0313', 15054038, 1505403802, 90);
INSERT INTO `students` VALUES (13, NULL, NULL, NULL, NULL);
INSERT INTO `students` VALUES (14, NULL, NULL, NULL, NULL);
INSERT INTO `students` VALUES (15, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
