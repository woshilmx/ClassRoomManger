/*
 Navicat Premium Data Transfer

 Source Server         : woshilmx
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : classroom

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 11/06/2022 12:18:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `starttime` time(0) NULL DEFAULT NULL,
  `endtime` time(0) NULL DEFAULT NULL,
  `datetime` date NULL DEFAULT NULL,
  `cid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `starttime`(`starttime`, `endtime`, `datetime`, `cid`) USING BTREE,
  INDEX `cid_couid`(`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('160023', '数据库', '08:00:00', '10:00:00', '2022-06-01', '1');
INSERT INTO `course` VALUES ('1654608696477', '数据结构', '14:00:00', '16:00:00', '2022-06-10', '7');
INSERT INTO `course` VALUES ('1654611864702', '数据库原理及其应用', '10:00:00', '12:00:00', '2022-06-15', '4');
INSERT INTO `course` VALUES ('1654611965914', '计组', '08:00:00', '10:00:00', '2022-06-10', '6');
INSERT INTO `course` VALUES ('1654687671230', '数据结构', '10:00:00', '12:00:00', '2022-06-10', '9');

-- ----------------------------
-- Table structure for croom
-- ----------------------------
DROP TABLE IF EXISTS `croom`;
CREATE TABLE `croom`  (
  `id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `foolnumber` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `roomnumber` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `maxperson` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of croom
-- ----------------------------
INSERT INTO `croom` VALUES ('1', '三行楼', 'A321', 100);
INSERT INTO `croom` VALUES ('2', '三行楼', 'A235', 100);
INSERT INTO `croom` VALUES ('3', '三行楼', 'A307', 100);
INSERT INTO `croom` VALUES ('4', '三行楼', 'A301', 100);
INSERT INTO `croom` VALUES ('5', '三行楼', 'A427', 100);
INSERT INTO `croom` VALUES ('6', '三行楼', 'A429', 100);
INSERT INTO `croom` VALUES ('7', '三行楼', 'A103', 100);
INSERT INTO `croom` VALUES ('8', '三行楼', 'A108', 100);
INSERT INTO `croom` VALUES ('9', '三行楼', 'A223', 100);

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int(0) NULL DEFAULT NULL,
  `cid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `STATU` int(0) NULL DEFAULT NULL,
  `decription` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `c_e`(`cid`) USING BTREE,
  CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `croom` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '台式电脑', 1, '1', 0, NULL);
INSERT INTO `equipment` VALUES ('10', '座椅', 100, '2', 0, NULL);
INSERT INTO `equipment` VALUES ('11', '拖布', 1, '2', 0, NULL);
INSERT INTO `equipment` VALUES ('12', '扫把', 1, '2', 0, NULL);
INSERT INTO `equipment` VALUES ('2', '幕布', 1, '1', 0, NULL);
INSERT INTO `equipment` VALUES ('3', '投影仪', 1, '1', 0, NULL);
INSERT INTO `equipment` VALUES ('4', '座椅', 100, '1', 0, NULL);
INSERT INTO `equipment` VALUES ('5', '拖布', 1, '1', 0, NULL);
INSERT INTO `equipment` VALUES ('6', '扫把', 1, '1', 0, NULL);
INSERT INTO `equipment` VALUES ('7', '台式电脑', 1, '2', 0, NULL);
INSERT INTO `equipment` VALUES ('8', '幕布', 1, '2', 0, NULL);
INSERT INTO `equipment` VALUES ('9', '投影仪', 1, '2', 0, NULL);

-- ----------------------------
-- Table structure for manger
-- ----------------------------
DROP TABLE IF EXISTS `manger`;
CREATE TABLE `manger`  (
  `id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mpassword` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manger
-- ----------------------------
INSERT INTO `manger` VALUES ('1', 'root', '123456789');

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request`  (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `thing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `datetime` date NULL DEFAULT NULL,
  `startrequest` time(0) NULL DEFAULT NULL,
  `endrequest` time(0) NULL DEFAULT NULL,
  `cid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tsid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `mid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `datetime`(`datetime`, `startrequest`, `endrequest`, `cid`) USING BTREE,
  UNIQUE INDEX `datetime_2`(`datetime`, `startrequest`, `endrequest`, `cid`, `status`) USING BTREE,
  UNIQUE INDEX `datetime_3`(`datetime`, `startrequest`, `endrequest`, `cid`, `status`) USING BTREE,
  INDEX `r_s`(`sid`) USING BTREE,
  INDEX `ts_s`(`tsid`) USING BTREE,
  INDEX `r_c`(`cid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `croom` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `request_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`studentid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `request_ibfk_3` FOREIGN KEY (`tsid`) REFERENCES `teacher` (`worknumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `request_ibfk_4` FOREIGN KEY (`mid`) REFERENCES `manger` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO `request` VALUES ('1654678597961', '开会', '2022-06-12', '08:00:00', '10:00:00', '6', '2020151112', NULL, 3, NULL);
INSERT INTO `request` VALUES ('1654686955704', '开会', '2022-06-12', '16:00:00', '18:00:00', '4', '2020151112', NULL, 2, '1');
INSERT INTO `request` VALUES ('1654687646556', '宣讲', '2022-06-10', '10:00:00', '12:00:00', '7', NULL, '132586123', 2, '1');
INSERT INTO `request` VALUES ('1654738915020', '活动', '2022-06-10', '10:00:00', '12:00:00', '8', '2020151112', NULL, 2, '1');

-- ----------------------------
-- Table structure for requestlog
-- ----------------------------
DROP TABLE IF EXISTS `requestlog`;
CREATE TABLE `requestlog`  (
  `id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `thing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `datetime` date NULL DEFAULT NULL,
  `startrequest` time(0) NULL DEFAULT NULL,
  `endrequest` time(0) NULL DEFAULT NULL,
  `cid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tsid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `mid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of requestlog
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sdept` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studentid`) USING BTREE,
  UNIQUE INDEX `studentid`(`studentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2020151112', '李满祥', '计算机系', '123456789');
INSERT INTO `student` VALUES ('2020151121', '彭士云', '计算机系', '123456789');
INSERT INTO `student` VALUES ('2020151128', '王俊强', '计算机系', '123456789');
INSERT INTO `student` VALUES ('2020151132', '谢聪', '计算机系', '123456789');
INSERT INTO `student` VALUES ('2020151139', '张蕾', '计算机系', '123456789');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `worknumber` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tdept` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tpassword` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`worknumber`) USING BTREE,
  UNIQUE INDEX `worknumber`(`worknumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('132586123', '赵六', '计算机系', '123456789');
INSERT INTO `teacher` VALUES ('132586124', '王国超', '数学系', '123456789');
INSERT INTO `teacher` VALUES ('132586125', '马汉', '舞蹈系', '123456789');
INSERT INTO `teacher` VALUES ('132586126', '商学', '数学系', '123456789');
INSERT INTO `teacher` VALUES ('132586127', '李锐', '计算机系', '123456789');
INSERT INTO `teacher` VALUES ('132586128', '山溪', '物理系', '123456789');

-- ----------------------------
-- Table structure for teacou
-- ----------------------------
DROP TABLE IF EXISTS `teacou`;
CREATE TABLE `teacou`  (
  `tsid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`tsid`, `coid`) USING BTREE,
  INDEX `coid`(`coid`) USING BTREE,
  CONSTRAINT `teacou_ibfk_1` FOREIGN KEY (`tsid`) REFERENCES `teacher` (`worknumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `teacou_ibfk_2` FOREIGN KEY (`coid`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacou
-- ----------------------------
INSERT INTO `teacou` VALUES ('132586123', '1654608696477');
INSERT INTO `teacou` VALUES ('132586123', '1654611864702');
INSERT INTO `teacou` VALUES ('132586123', '1654611965914');
INSERT INTO `teacou` VALUES ('132586123', '1654687671230');

-- ----------------------------
-- View structure for crcou
-- ----------------------------
DROP VIEW IF EXISTS `crcou`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `crcou` AS select distinct `croom`.`id` AS `id`,`course`.`id` AS `courid`,`croom`.`foolnumber` AS `foolnumber`,`croom`.`roomnumber` AS `roomnumber`,`croom`.`maxperson` AS `maxperson`,`course`.`datetime` AS `datetime`,`course`.`starttime` AS `starttime`,`course`.`endtime` AS `endtime` from (`croom` left join `course` on((`croom`.`id` = `course`.`cid`)));

-- ----------------------------
-- View structure for crew
-- ----------------------------
DROP VIEW IF EXISTS `crew`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `crew` AS select `croom`.`foolnumber` AS `foolnumber`,`croom`.`roomnumber` AS `roomnumber`,`croom`.`maxperson` AS `maxperson`,`request`.`datetime` AS `datetime`,`request`.`startrequest` AS `startrequest`,`request`.`endrequest` AS `endrequest`,`request`.`status` AS `status`,`request`.`id` AS `id` from (`croom` left join `request` on((`request`.`cid` = `croom`.`id`)));

-- ----------------------------
-- View structure for ct
-- ----------------------------
DROP VIEW IF EXISTS `ct`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `ct` AS select `course`.`id` AS `id`,`course`.`cname` AS `cname`,`course`.`starttime` AS `starttime`,`course`.`endtime` AS `endtime`,`course`.`datetime` AS `datetime`,`course`.`cid` AS `cid`,`teacou`.`tsid` AS `tsid`,`teacou`.`coid` AS `coid`,`teacher`.`tname` AS `tname`,`teacher`.`worknumber` AS `worknumber`,`teacher`.`tdept` AS `tdept`,`teacher`.`tpassword` AS `tpassword` from ((`course` join `teacou` on((`course`.`id` = `teacou`.`coid`))) join `teacher` on((`teacou`.`tsid` = `teacher`.`worknumber`)));

-- ----------------------------
-- Procedure structure for deletemoretime
-- ----------------------------
DROP PROCEDURE IF EXISTS `deletemoretime`;
delimiter ;;
CREATE PROCEDURE `deletemoretime`(in datetime1 DATE,in endrequest1 TIME)
BEGIN
--  
delete from request where datetime<datetime1 or (datetime=datetime1 and endrequest<=endrequest1);

delete from requestlog where datetime<datetime1 or (datetime=datetime1 and endrequest<=endrequest1);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table request
-- ----------------------------
DROP TRIGGER IF EXISTS `deleteorder`;
delimiter ;;
CREATE TRIGGER `deleteorder` BEFORE DELETE ON `request` FOR EACH ROW BEGIN
  INSERT into requestlog(id,thing,datetime,startrequest,endrequest,cid,sid,tsid,status,mid) VALUE (OLD.id,OLD.thing,OLD.datetime,OLD.startrequest,OLD.endrequest,OLD.cid,OLD.sid,OLD.tsid,OLD.status,OLD.mid);
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
