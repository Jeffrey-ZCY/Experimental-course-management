/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : cssy

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 20/10/2020 13:26:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `adminname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminid` int(0) NOT NULL,
  `adminpwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`adminid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('lisi', 123, '987654');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(0) NOT NULL COMMENT '课程编号',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `experiment_hours` int(0) NOT NULL COMMENT '实验学时',
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
  `course_id` int(0) NOT NULL COMMENT '课程编号',
  `experiment_id` int(0) NOT NULL COMMENT '实验序号',
  `experiment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验名',
  `experiment_ category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验类',
  `difficulty` int(0) NOT NULL COMMENT '难度',
  `hours` int(0) NOT NULL COMMENT '学时',
  `schedule_weeks` int(0) NOT NULL COMMENT '安排周次',
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
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory`  (
  `room` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('300');
INSERT INTO `laboratory` VALUES ('301');
INSERT INTO `laboratory` VALUES ('302');

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info`  (
  `stuname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stunumber` int(0) NOT NULL,
  `stuclass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `testname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `testscore` int(0) NULL DEFAULT NULL,
  `testername` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stunumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('zhangsan', 123, '12', 'no', NULL, NULL);
INSERT INTO `stu_info` VALUES ('lisi', 1234, '1', 'English', NULL, NULL);
INSERT INTO `stu_info` VALUES ('wangwu', 12345, '12', 'yes', NULL, NULL);
INSERT INTO `stu_info` VALUES ('李四', 123456, '123', 'Math', NULL, NULL);
INSERT INTO `stu_info` VALUES ('李四', 1234567, '123', 'huaxue', NULL, NULL);

-- ----------------------------
-- Table structure for tester_info
-- ----------------------------
DROP TABLE IF EXISTS `tester_info`;
CREATE TABLE `tester_info`  (
  `testername` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `testerid` int(0) NOT NULL,
  `testerpwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`testerid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tester_info
-- ----------------------------
INSERT INTO `tester_info` VALUES ('zhangsan', 181305, '123321');
INSERT INTO `tester_info` VALUES ('Kris', 19991119, '123456');

SET FOREIGN_KEY_CHECKS = 1;
