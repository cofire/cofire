/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : cofire

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-19 17:22:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qtz_job
-- ----------------------------
DROP TABLE IF EXISTS `qtz_job`;
CREATE TABLE `qtz_job` (
  `job_id` varchar(32) NOT NULL COMMENT '定时任务id',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_desc` varchar(256) DEFAULT NULL COMMENT '任务描述',
  `year` varchar(4) NOT NULL COMMENT '年',
  `month` varchar(2) NOT NULL COMMENT '月',
  `day` varchar(10) NOT NULL COMMENT '日期',
  `week` varchar(10) NOT NULL COMMENT '星期',
  `hour` varchar(10) NOT NULL COMMENT '小时',
  `minute` varchar(10) NOT NULL COMMENT '分',
  `second` varchar(10) NOT NULL COMMENT '秒',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除标识:0-未删除；1-已删除',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `param1` varchar(32) DEFAULT NULL COMMENT '附加参数1',
  `param2` varchar(32) DEFAULT NULL COMMENT '附加参数2',
  `param3` varchar(32) DEFAULT NULL COMMENT '附加参数3',
  `param4` varchar(32) DEFAULT NULL COMMENT '附加参数4',
  `param5` varchar(32) DEFAULT NULL COMMENT '附加参数5',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_job
-- ----------------------------
INSERT INTO `qtz_job` VALUES ('test', 'test', '测试一下', '*', '*', '*', '*', '*', '*', '0/25', '1', 'admin', '20191028104144', null, null, null, null, null);

-- ----------------------------
-- Table structure for qtz_job_log
-- ----------------------------
DROP TABLE IF EXISTS `qtz_job_log`;
CREATE TABLE `qtz_job_log` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `job_id` varchar(32) DEFAULT NULL COMMENT '定时任务id',
  `run_time` varchar(14) DEFAULT NULL COMMENT '执行时间',
  `ip` varchar(32) DEFAULT NULL COMMENT '运行时ip',
  `is_success` varchar(2) DEFAULT NULL COMMENT '是否成功',
  `message` varchar(3000) DEFAULT NULL COMMENT '信息',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=963 DEFAULT CHARSET=utf8 COMMENT='批任务日志表';

-- ----------------------------
-- Records of qtz_job_log
-- ----------------------------
INSERT INTO `qtz_job_log` VALUES ('142', 'test', '20191012141410', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('143', 'test', '20191012141420', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('144', 'test', '20191012141430', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('145', 'test', '20191012141440', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('146', 'test', '20191012142950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('147', 'test', '20191012152510', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('148', 'test', '20191012152520', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('149', 'test', '20191012152530', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('150', 'test', '20191012152540', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('151', 'test', '20191021113530', '192.168.10.1', '1', '2', null, null, null);
INSERT INTO `qtz_job_log` VALUES ('152', 'test', '20191021113550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('153', 'test', '20191021113600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('154', 'test', '20191021113610', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('155', 'test', '20191021113620', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('156', 'test', '20191021113630', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('157', 'test', '20191021113640', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('158', 'test', '20191021113650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('159', 'test', '20191021113700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('160', 'test', '20191021113710', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('161', 'test', '20191021113720', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('162', 'test', '20191021113740', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('163', 'test', '20191021113800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('164', 'test', '20191021113820', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('165', 'test', '20191118114125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('166', 'test', '20191118114150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('167', 'test', '20191118114200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('168', 'test', '20191118114225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('169', 'test', '20191118114250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('170', 'test', '20191118114300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('171', 'test', '20191118114325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('172', 'test', '20191118114350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('173', 'test', '20191118114400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('174', 'test', '20191118114425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('175', 'test', '20191118114450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('176', 'test', '20191118114500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('177', 'test', '20191118114525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('178', 'test', '20191118114550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('179', 'test', '20191118114600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('180', 'test', '20191118114625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('181', 'test', '20191118114650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('182', 'test', '20191118114700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('183', 'test', '20191118114725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('184', 'test', '20191118114750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('185', 'test', '20191118114800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('186', 'test', '20191118114825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('187', 'test', '20191118114850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('188', 'test', '20191118114900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('189', 'test', '20191118114925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('190', 'test', '20191118114950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('191', 'test', '20191118115000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('192', 'test', '20191118115025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('193', 'test', '20191118115050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('194', 'test', '20191118115100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('195', 'test', '20191118115125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('196', 'test', '20191118115150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('197', 'test', '20191118115200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('198', 'test', '20191118115225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('199', 'test', '20191118115250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('200', 'test', '20191118115300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('201', 'test', '20191118115325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('202', 'test', '20191118115350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('203', 'test', '20191118115400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('204', 'test', '20191118115425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('205', 'test', '20191118115450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('206', 'test', '20191118115500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('207', 'test', '20191118115525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('208', 'test', '20191118115550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('209', 'test', '20191118115600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('210', 'test', '20191118115625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('211', 'test', '20191118115650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('212', 'test', '20191118115700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('213', 'test', '20191118115725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('214', 'test', '20191118115750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('215', 'test', '20191118115800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('216', 'test', '20191118115825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('217', 'test', '20191118115850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('218', 'test', '20191118115900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('219', 'test', '20191118115925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('220', 'test', '20191118115950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('221', 'test', '20191118120000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('222', 'test', '20191118120025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('223', 'test', '20191118120050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('224', 'test', '20191118120100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('225', 'test', '20191118120125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('226', 'test', '20191118120150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('227', 'test', '20191118120200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('228', 'test', '20191118120225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('229', 'test', '20191118120250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('230', 'test', '20191118120300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('231', 'test', '20191118120325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('232', 'test', '20191118120350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('233', 'test', '20191118120400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('234', 'test', '20191118120425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('235', 'test', '20191118120450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('236', 'test', '20191118120500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('237', 'test', '20191118120525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('238', 'test', '20191118120550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('239', 'test', '20191118120600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('240', 'test', '20191118120625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('241', 'test', '20191118120650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('242', 'test', '20191118120700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('243', 'test', '20191118120725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('244', 'test', '20191118120750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('245', 'test', '20191118120800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('246', 'test', '20191118120825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('247', 'test', '20191118120850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('248', 'test', '20191118120900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('249', 'test', '20191118120925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('250', 'test', '20191118120950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('251', 'test', '20191118121000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('252', 'test', '20191118121025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('253', 'test', '20191118121050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('254', 'test', '20191118121100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('255', 'test', '20191118121125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('256', 'test', '20191118121150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('257', 'test', '20191118121200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('258', 'test', '20191118121225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('259', 'test', '20191118121250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('260', 'test', '20191118121300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('261', 'test', '20191118121325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('262', 'test', '20191118121350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('263', 'test', '20191118121400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('264', 'test', '20191118121425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('265', 'test', '20191118121450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('266', 'test', '20191118121500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('267', 'test', '20191118121525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('268', 'test', '20191118121550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('269', 'test', '20191118121600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('270', 'test', '20191118121625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('271', 'test', '20191118121650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('272', 'test', '20191118121700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('273', 'test', '20191118121725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('274', 'test', '20191118121750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('275', 'test', '20191118121800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('276', 'test', '20191118121825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('277', 'test', '20191118121850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('278', 'test', '20191118121900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('279', 'test', '20191118121925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('280', 'test', '20191118121950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('281', 'test', '20191118122000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('282', 'test', '20191118122025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('283', 'test', '20191118122050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('284', 'test', '20191118122100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('285', 'test', '20191118122125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('286', 'test', '20191118122150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('287', 'test', '20191118122200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('288', 'test', '20191118122225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('289', 'test', '20191118122250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('290', 'test', '20191118122300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('291', 'test', '20191118122325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('292', 'test', '20191118122350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('293', 'test', '20191118122400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('294', 'test', '20191118122425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('295', 'test', '20191118122450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('296', 'test', '20191118122500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('297', 'test', '20191118122525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('298', 'test', '20191118122550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('299', 'test', '20191118122600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('300', 'test', '20191118122625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('301', 'test', '20191118122650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('302', 'test', '20191118122700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('303', 'test', '20191118122725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('304', 'test', '20191118122750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('305', 'test', '20191118122800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('306', 'test', '20191118122825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('307', 'test', '20191118122850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('308', 'test', '20191118122900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('309', 'test', '20191118122925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('310', 'test', '20191118122950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('311', 'test', '20191118123000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('312', 'test', '20191118123025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('313', 'test', '20191118123050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('314', 'test', '20191118123100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('315', 'test', '20191118123125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('316', 'test', '20191118123150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('317', 'test', '20191118123200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('318', 'test', '20191118123225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('319', 'test', '20191118123250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('320', 'test', '20191118123300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('321', 'test', '20191118123325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('322', 'test', '20191118123350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('323', 'test', '20191118123400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('324', 'test', '20191118123425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('325', 'test', '20191118123450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('326', 'test', '20191118123500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('327', 'test', '20191118123525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('328', 'test', '20191118123550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('329', 'test', '20191118123600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('330', 'test', '20191118123625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('331', 'test', '20191118123650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('332', 'test', '20191118123700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('333', 'test', '20191118123725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('334', 'test', '20191118123750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('335', 'test', '20191118123800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('336', 'test', '20191118123825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('337', 'test', '20191118123850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('338', 'test', '20191118123900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('339', 'test', '20191118123925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('340', 'test', '20191118123950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('341', 'test', '20191118124000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('342', 'test', '20191118124025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('343', 'test', '20191118124050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('344', 'test', '20191118124100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('345', 'test', '20191118124125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('346', 'test', '20191118124150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('347', 'test', '20191118124200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('348', 'test', '20191118124225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('349', 'test', '20191118124250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('350', 'test', '20191118124300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('351', 'test', '20191118124325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('352', 'test', '20191118124350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('353', 'test', '20191118124400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('354', 'test', '20191118124425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('355', 'test', '20191118124450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('356', 'test', '20191118124500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('357', 'test', '20191118124525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('358', 'test', '20191118124550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('359', 'test', '20191118124600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('360', 'test', '20191118124625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('361', 'test', '20191118124650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('362', 'test', '20191118124700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('363', 'test', '20191118124725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('364', 'test', '20191118124750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('365', 'test', '20191118124800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('366', 'test', '20191118124825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('367', 'test', '20191118124850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('368', 'test', '20191118124900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('369', 'test', '20191118124925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('370', 'test', '20191118124950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('371', 'test', '20191118125000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('372', 'test', '20191118125025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('373', 'test', '20191118125050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('374', 'test', '20191118125100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('375', 'test', '20191118125125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('376', 'test', '20191118125150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('377', 'test', '20191118125200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('378', 'test', '20191118125225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('379', 'test', '20191118125250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('380', 'test', '20191118125300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('381', 'test', '20191118125325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('382', 'test', '20191118125350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('383', 'test', '20191118125400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('384', 'test', '20191118125425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('385', 'test', '20191118125450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('386', 'test', '20191118125500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('387', 'test', '20191118125525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('388', 'test', '20191118125550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('389', 'test', '20191118125600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('390', 'test', '20191118125625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('391', 'test', '20191118125650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('392', 'test', '20191118125700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('393', 'test', '20191118125725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('394', 'test', '20191118125750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('395', 'test', '20191118125800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('396', 'test', '20191118125825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('397', 'test', '20191118125850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('398', 'test', '20191118125900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('399', 'test', '20191118125925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('400', 'test', '20191118125950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('401', 'test', '20191118130000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('402', 'test', '20191118130025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('403', 'test', '20191118130050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('404', 'test', '20191118130100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('405', 'test', '20191118130125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('406', 'test', '20191118130150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('407', 'test', '20191118130200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('408', 'test', '20191118130225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('409', 'test', '20191118130250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('410', 'test', '20191118130300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('411', 'test', '20191118130325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('412', 'test', '20191118130350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('413', 'test', '20191118130400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('414', 'test', '20191118130425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('415', 'test', '20191118130450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('416', 'test', '20191118130500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('417', 'test', '20191118130525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('418', 'test', '20191118130550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('419', 'test', '20191118130600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('420', 'test', '20191118130625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('421', 'test', '20191118130650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('422', 'test', '20191118130700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('423', 'test', '20191118130725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('424', 'test', '20191118130750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('425', 'test', '20191118130800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('426', 'test', '20191118130825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('427', 'test', '20191118130850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('428', 'test', '20191118130900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('429', 'test', '20191118130925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('430', 'test', '20191118130950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('431', 'test', '20191118131000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('432', 'test', '20191118131025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('433', 'test', '20191118131050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('434', 'test', '20191118131100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('435', 'test', '20191118131125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('436', 'test', '20191118131150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('437', 'test', '20191118131200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('438', 'test', '20191118131225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('439', 'test', '20191118131250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('440', 'test', '20191118131300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('441', 'test', '20191118131325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('442', 'test', '20191118131350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('443', 'test', '20191118131400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('444', 'test', '20191118131425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('445', 'test', '20191118131450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('446', 'test', '20191118131500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('447', 'test', '20191118131525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('448', 'test', '20191118131550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('449', 'test', '20191118131600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('450', 'test', '20191118131625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('451', 'test', '20191118131650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('452', 'test', '20191118131700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('453', 'test', '20191118131725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('454', 'test', '20191118131750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('455', 'test', '20191118131800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('456', 'test', '20191118131825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('457', 'test', '20191118131850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('458', 'test', '20191118131900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('459', 'test', '20191118131925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('460', 'test', '20191118131950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('461', 'test', '20191118132000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('462', 'test', '20191118132025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('463', 'test', '20191118132050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('464', 'test', '20191118132100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('465', 'test', '20191118132125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('466', 'test', '20191118132150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('467', 'test', '20191118132200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('468', 'test', '20191118132225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('469', 'test', '20191118132250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('470', 'test', '20191118132300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('471', 'test', '20191118132325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('472', 'test', '20191118132350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('473', 'test', '20191118132400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('474', 'test', '20191118132425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('475', 'test', '20191118132450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('476', 'test', '20191118132500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('477', 'test', '20191118132525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('478', 'test', '20191118132550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('479', 'test', '20191118132600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('480', 'test', '20191118132625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('481', 'test', '20191118132650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('482', 'test', '20191118132700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('483', 'test', '20191118132725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('484', 'test', '20191118132750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('485', 'test', '20191118132800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('486', 'test', '20191118132825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('487', 'test', '20191118132850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('488', 'test', '20191118132900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('489', 'test', '20191118132925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('490', 'test', '20191118132950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('491', 'test', '20191118133000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('492', 'test', '20191118133037', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('493', 'test', '20191118133050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('494', 'test', '20191118133100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('495', 'test', '20191118133125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('496', 'test', '20191118133150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('497', 'test', '20191118133200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('498', 'test', '20191118133225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('499', 'test', '20191118133250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('500', 'test', '20191118133300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('501', 'test', '20191118133325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('502', 'test', '20191118133350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('503', 'test', '20191118133400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('504', 'test', '20191118133425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('505', 'test', '20191118133450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('506', 'test', '20191118133500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('507', 'test', '20191118133525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('508', 'test', '20191118133550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('509', 'test', '20191118133600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('510', 'test', '20191118133625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('511', 'test', '20191118133650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('512', 'test', '20191118133700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('513', 'test', '20191118133725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('514', 'test', '20191118133750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('515', 'test', '20191118133800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('516', 'test', '20191118133825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('517', 'test', '20191118133850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('518', 'test', '20191118133900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('519', 'test', '20191118133925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('520', 'test', '20191118133950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('521', 'test', '20191118134000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('522', 'test', '20191118134025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('523', 'test', '20191118134050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('524', 'test', '20191118134100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('525', 'test', '20191118134125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('526', 'test', '20191118134150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('527', 'test', '20191118134200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('528', 'test', '20191118134225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('529', 'test', '20191118134250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('530', 'test', '20191118134300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('531', 'test', '20191118134325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('532', 'test', '20191118134350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('533', 'test', '20191118134400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('534', 'test', '20191118134425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('535', 'test', '20191118134450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('536', 'test', '20191118134500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('537', 'test', '20191118134525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('538', 'test', '20191118134550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('539', 'test', '20191118134600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('540', 'test', '20191118134625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('541', 'test', '20191118134650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('542', 'test', '20191118134700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('543', 'test', '20191118134725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('544', 'test', '20191118134750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('545', 'test', '20191118134800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('546', 'test', '20191118134825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('547', 'test', '20191118134850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('548', 'test', '20191118134900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('549', 'test', '20191118134925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('550', 'test', '20191118134950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('551', 'test', '20191118135000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('552', 'test', '20191118135025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('553', 'test', '20191118135050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('554', 'test', '20191118135100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('555', 'test', '20191118135125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('556', 'test', '20191118135150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('557', 'test', '20191118135200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('558', 'test', '20191118135225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('559', 'test', '20191118135250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('560', 'test', '20191118135300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('561', 'test', '20191118135325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('562', 'test', '20191118135350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('563', 'test', '20191118135400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('564', 'test', '20191118135425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('565', 'test', '20191118135450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('566', 'test', '20191118135500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('567', 'test', '20191118135525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('568', 'test', '20191118135550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('569', 'test', '20191118135600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('570', 'test', '20191118135625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('571', 'test', '20191118135650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('572', 'test', '20191118135700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('573', 'test', '20191118135725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('574', 'test', '20191118135750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('575', 'test', '20191118135800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('576', 'test', '20191118135825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('577', 'test', '20191118135850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('578', 'test', '20191118135900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('579', 'test', '20191118135925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('580', 'test', '20191118135950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('581', 'test', '20191118140000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('582', 'test', '20191118140025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('583', 'test', '20191118140050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('584', 'test', '20191118140100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('585', 'test', '20191118140125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('586', 'test', '20191118140150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('587', 'test', '20191118140200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('588', 'test', '20191118140225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('589', 'test', '20191118140250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('590', 'test', '20191118140300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('591', 'test', '20191118140325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('592', 'test', '20191118140350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('593', 'test', '20191118140400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('594', 'test', '20191118140425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('595', 'test', '20191118140450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('596', 'test', '20191118140500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('597', 'test', '20191118140525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('598', 'test', '20191118140550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('599', 'test', '20191118140600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('600', 'test', '20191118140625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('601', 'test', '20191118140650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('602', 'test', '20191118140700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('603', 'test', '20191118140725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('604', 'test', '20191118140750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('605', 'test', '20191118140800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('606', 'test', '20191118140825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('607', 'test', '20191118140850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('608', 'test', '20191118140900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('609', 'test', '20191118140925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('610', 'test', '20191118140950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('611', 'test', '20191118141000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('612', 'test', '20191118141025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('613', 'test', '20191118141050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('614', 'test', '20191118141100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('615', 'test', '20191118141125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('616', 'test', '20191118141150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('617', 'test', '20191118141200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('618', 'test', '20191118141225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('619', 'test', '20191118141250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('620', 'test', '20191118141300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('621', 'test', '20191118141325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('622', 'test', '20191118141350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('623', 'test', '20191118141400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('624', 'test', '20191118141425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('625', 'test', '20191118141450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('626', 'test', '20191118141500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('627', 'test', '20191118141525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('628', 'test', '20191118141550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('629', 'test', '20191118141600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('630', 'test', '20191118141625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('631', 'test', '20191118141650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('632', 'test', '20191118141700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('633', 'test', '20191118141725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('634', 'test', '20191118141750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('635', 'test', '20191118141800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('636', 'test', '20191118141825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('637', 'test', '20191118141850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('638', 'test', '20191118141900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('639', 'test', '20191118141925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('640', 'test', '20191118141950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('641', 'test', '20191118142000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('642', 'test', '20191118142025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('643', 'test', '20191118142050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('644', 'test', '20191118142100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('645', 'test', '20191118142125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('646', 'test', '20191118142150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('647', 'test', '20191118142200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('648', 'test', '20191118142225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('649', 'test', '20191118142250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('650', 'test', '20191118142300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('651', 'test', '20191118142325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('652', 'test', '20191118142350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('653', 'test', '20191118142400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('654', 'test', '20191118142425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('655', 'test', '20191118142450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('656', 'test', '20191118142500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('657', 'test', '20191118142525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('658', 'test', '20191118142550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('659', 'test', '20191118142600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('660', 'test', '20191118142625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('661', 'test', '20191118142650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('662', 'test', '20191118142700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('663', 'test', '20191118142725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('664', 'test', '20191118142750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('665', 'test', '20191118142800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('666', 'test', '20191118142825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('667', 'test', '20191118142850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('668', 'test', '20191118142900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('669', 'test', '20191118142925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('670', 'test', '20191118142950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('671', 'test', '20191118143000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('672', 'test', '20191118143025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('673', 'test', '20191118143050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('674', 'test', '20191118143100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('675', 'test', '20191118143125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('676', 'test', '20191118143150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('677', 'test', '20191118143200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('678', 'test', '20191118143225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('679', 'test', '20191118143250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('680', 'test', '20191118143300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('681', 'test', '20191118143325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('682', 'test', '20191118143350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('683', 'test', '20191118143400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('684', 'test', '20191118143425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('685', 'test', '20191118143450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('686', 'test', '20191118143500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('687', 'test', '20191118143525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('688', 'test', '20191118143550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('689', 'test', '20191118143600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('690', 'test', '20191118143625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('691', 'test', '20191118143650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('692', 'test', '20191118143700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('693', 'test', '20191118143725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('694', 'test', '20191118143750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('695', 'test', '20191118143800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('696', 'test', '20191118143825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('697', 'test', '20191118143850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('698', 'test', '20191118143900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('699', 'test', '20191118143925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('700', 'test', '20191118143950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('701', 'test', '20191118144000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('702', 'test', '20191118144025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('703', 'test', '20191118144050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('704', 'test', '20191118144100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('705', 'test', '20191118144125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('706', 'test', '20191118144150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('707', 'test', '20191118144200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('708', 'test', '20191118144225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('709', 'test', '20191118144250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('710', 'test', '20191118144300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('711', 'test', '20191118144325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('712', 'test', '20191118144350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('713', 'test', '20191118144400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('714', 'test', '20191118144425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('715', 'test', '20191118144450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('716', 'test', '20191118144500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('717', 'test', '20191118144525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('718', 'test', '20191118144550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('719', 'test', '20191118144600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('720', 'test', '20191118144625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('721', 'test', '20191118144650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('722', 'test', '20191118144700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('723', 'test', '20191118144725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('724', 'test', '20191118144750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('725', 'test', '20191118144800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('726', 'test', '20191118144825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('727', 'test', '20191118144850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('728', 'test', '20191118144900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('729', 'test', '20191118144925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('730', 'test', '20191118144950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('731', 'test', '20191118145000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('732', 'test', '20191118145025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('733', 'test', '20191118145050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('734', 'test', '20191118145100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('735', 'test', '20191118145125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('736', 'test', '20191118145150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('737', 'test', '20191118145200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('738', 'test', '20191118145225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('739', 'test', '20191118145250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('740', 'test', '20191118145300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('741', 'test', '20191118145325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('742', 'test', '20191118145350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('743', 'test', '20191118145400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('744', 'test', '20191118145425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('745', 'test', '20191118145450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('746', 'test', '20191118145500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('747', 'test', '20191118145525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('748', 'test', '20191118145550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('749', 'test', '20191118145600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('750', 'test', '20191118145625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('751', 'test', '20191118145650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('752', 'test', '20191118145700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('753', 'test', '20191118145725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('754', 'test', '20191118145750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('755', 'test', '20191118145800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('756', 'test', '20191118145825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('757', 'test', '20191118145850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('758', 'test', '20191118145900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('759', 'test', '20191118145925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('760', 'test', '20191118152905', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('761', 'test', '20191118152905', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('762', 'test', '20191118213125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('763', 'test', '20191118213150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('764', 'test', '20191118213200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('765', 'test', '20191118213225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('766', 'test', '20191118213250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('767', 'test', '20191118213300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('768', 'test', '20191118213325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('769', 'test', '20191118213350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('770', 'test', '20191118213400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('771', 'test', '20191118213425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('772', 'test', '20191118213450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('773', 'test', '20191118213500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('774', 'test', '20191118213525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('775', 'test', '20191118213550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('776', 'test', '20191118213600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('777', 'test', '20191118213625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('778', 'test', '20191118213650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('779', 'test', '20191118213700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('780', 'test', '20191118213725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('781', 'test', '20191118213750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('782', 'test', '20191118213800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('783', 'test', '20191118213825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('784', 'test', '20191118213850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('785', 'test', '20191118213900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('786', 'test', '20191118213925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('787', 'test', '20191118213950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('788', 'test', '20191118214000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('789', 'test', '20191118214025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('790', 'test', '20191118214050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('791', 'test', '20191118214100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('792', 'test', '20191118214125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('793', 'test', '20191118214150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('794', 'test', '20191118214200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('795', 'test', '20191118214225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('796', 'test', '20191118214250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('797', 'test', '20191118214300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('798', 'test', '20191118214325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('799', 'test', '20191118214350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('800', 'test', '20191118214400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('801', 'test', '20191118214425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('802', 'test', '20191118214450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('803', 'test', '20191118214500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('804', 'test', '20191118214525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('805', 'test', '20191118214550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('806', 'test', '20191118214600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('807', 'test', '20191118214625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('808', 'test', '20191118214650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('809', 'test', '20191118214700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('810', 'test', '20191118214725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('811', 'test', '20191118214750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('812', 'test', '20191118214800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('813', 'test', '20191118214825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('814', 'test', '20191118214850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('815', 'test', '20191118214900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('816', 'test', '20191118214925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('817', 'test', '20191118214950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('818', 'test', '20191118215000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('819', 'test', '20191118215025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('820', 'test', '20191118215050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('821', 'test', '20191118215100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('822', 'test', '20191118215125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('823', 'test', '20191118215150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('824', 'test', '20191118215200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('825', 'test', '20191118215225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('826', 'test', '20191118215250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('827', 'test', '20191118215300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('828', 'test', '20191118215325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('829', 'test', '20191118215350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('830', 'test', '20191118215400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('831', 'test', '20191118215425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('832', 'test', '20191118215450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('833', 'test', '20191118215500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('834', 'test', '20191118215525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('835', 'test', '20191118215550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('836', 'test', '20191118215600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('837', 'test', '20191118215625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('838', 'test', '20191118215650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('839', 'test', '20191118215700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('840', 'test', '20191118215725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('841', 'test', '20191118215750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('842', 'test', '20191118215800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('843', 'test', '20191118215825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('844', 'test', '20191118215850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('845', 'test', '20191118215900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('846', 'test', '20191118215925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('847', 'test', '20191118215950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('848', 'test', '20191118220000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('849', 'test', '20191118220025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('850', 'test', '20191118220050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('851', 'test', '20191118220100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('852', 'test', '20191118220125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('853', 'test', '20191118220150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('854', 'test', '20191118220200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('855', 'test', '20191118220225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('856', 'test', '20191118220250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('857', 'test', '20191118220300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('858', 'test', '20191118220325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('859', 'test', '20191118220350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('860', 'test', '20191118220400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('861', 'test', '20191118220425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('862', 'test', '20191118220450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('863', 'test', '20191118220500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('864', 'test', '20191118220525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('865', 'test', '20191118220550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('866', 'test', '20191118220600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('867', 'test', '20191118220625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('868', 'test', '20191118220650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('869', 'test', '20191118220700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('870', 'test', '20191118220725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('871', 'test', '20191118220750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('872', 'test', '20191118220800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('873', 'test', '20191118220825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('874', 'test', '20191118220850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('875', 'test', '20191118220900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('876', 'test', '20191118220925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('877', 'test', '20191118220950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('878', 'test', '20191118221000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('879', 'test', '20191118221025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('880', 'test', '20191118221050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('881', 'test', '20191118221100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('882', 'test', '20191118221125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('883', 'test', '20191118221150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('884', 'test', '20191118221200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('885', 'test', '20191118221225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('886', 'test', '20191118221250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('887', 'test', '20191118221300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('888', 'test', '20191118221325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('889', 'test', '20191118221350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('890', 'test', '20191118221400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('891', 'test', '20191118221425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('892', 'test', '20191118221450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('893', 'test', '20191118221500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('894', 'test', '20191118221525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('895', 'test', '20191118221550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('896', 'test', '20191118221600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('897', 'test', '20191118221625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('898', 'test', '20191118221650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('899', 'test', '20191118221700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('900', 'test', '20191118221725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('901', 'test', '20191118221750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('902', 'test', '20191118221800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('903', 'test', '20191118221825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('904', 'test', '20191118221850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('905', 'test', '20191118221900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('906', 'test', '20191118221925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('907', 'test', '20191118221950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('908', 'test', '20191118222000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('909', 'test', '20191118222025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('910', 'test', '20191118222050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('911', 'test', '20191118222100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('912', 'test', '20191118222125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('913', 'test', '20191118222150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('914', 'test', '20191118222200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('915', 'test', '20191118222225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('916', 'test', '20191118222250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('917', 'test', '20191118222300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('918', 'test', '20191118222325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('919', 'test', '20191118222350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('920', 'test', '20191118222400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('921', 'test', '20191118222425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('922', 'test', '20191118222450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('923', 'test', '20191118222500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('924', 'test', '20191118222525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('925', 'test', '20191118222550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('926', 'test', '20191118222600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('927', 'test', '20191118222625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('928', 'test', '20191118222650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('929', 'test', '20191118222700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('930', 'test', '20191118222725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('931', 'test', '20191118222750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('932', 'test', '20191118222800', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('933', 'test', '20191118222825', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('934', 'test', '20191118222850', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('935', 'test', '20191118222900', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('936', 'test', '20191118222925', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('937', 'test', '20191118222950', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('938', 'test', '20191118223000', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('939', 'test', '20191118223025', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('940', 'test', '20191118223050', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('941', 'test', '20191118223100', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('942', 'test', '20191118223125', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('943', 'test', '20191118223150', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('944', 'test', '20191118223200', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('945', 'test', '20191118223225', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('946', 'test', '20191118223250', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('947', 'test', '20191118223300', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('948', 'test', '20191118223325', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('949', 'test', '20191118223350', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('950', 'test', '20191118223400', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('951', 'test', '20191118223425', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('952', 'test', '20191118223450', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('953', 'test', '20191118223500', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('954', 'test', '20191118223525', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('955', 'test', '20191118223550', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('956', 'test', '20191118223600', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('957', 'test', '20191118223625', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('958', 'test', '20191118223650', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('959', 'test', '20191118223700', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('960', 'test', '20191118223725', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('961', 'test', '20191118223750', '192.168.10.1', '1', null, null, null, null);
INSERT INTO `qtz_job_log` VALUES ('962', 'test', '20191118223800', '192.168.10.1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `group_id` varchar(4) NOT NULL COMMENT '组号',
  `group_name` varchar(100) DEFAULT NULL COMMENT '组名',
  `dict_value` varchar(30) NOT NULL COMMENT '数据字典值',
  `dict_name_cn` varchar(100) DEFAULT NULL COMMENT '数据字典中文名称',
  `dict_name_en` varchar(100) DEFAULT NULL COMMENT '数据字典英文名称',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `filler1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(500) DEFAULT NULL COMMENT '预留字段3',
  `filler4` varchar(500) DEFAULT NULL COMMENT '预留字段4',
  PRIMARY KEY (`group_id`,`dict_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('0001', '是否可用', '0', '否', 'False', '20191117215905', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0001', '是否可用', '1', '是', 'Ture', '20191117220752', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0002', '登录登出类型', '0', '登录', 'SignIn', '20191117215948', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0002', '登录登出类型', '1', '登出', 'SignOut', '20191117215958', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0003', '是否可删除', '0', '否', 'False', '20191117220247', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0003', '是否可删除', '1', '是', 'True', '20191117220801', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0004', '是否成功', '0', '否', 'False', '20191117222946', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0004', '是否成功', '1', '是', 'True', '20191117222953', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0005', '来源类型', '0', 'PC端', 'PC', '20191117223157', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0006', '是否叶节点', '0', '否', 'False', '20191117223234', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0006', '是否叶节点', '1', '是', 'True', '20191117223259', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'add', '新增', 'add', '20191118113225', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'delete', '删除', 'delete', '20191118113232', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'export', '导出', 'export', '20191118113238', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'query', '查询', 'query', '20191118113244', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'update', '修改', 'update', '20191118113250', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'upload', '上传', 'upload', '20191118113258', 'admin', null, null, null, null);

-- ----------------------------
-- Table structure for sys_login_audit
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_audit`;
CREATE TABLE `sys_login_audit` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `ip` varchar(32) DEFAULT NULL COMMENT 'ip地址',
  `session_id` varchar(64) DEFAULT NULL COMMENT '会话id',
  `create_time` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `audit_type` varchar(32) DEFAULT NULL COMMENT '日志类型:0-登录；1-登出',
  `message` longtext COMMENT '消息',
  `source_type` varchar(32) DEFAULT NULL COMMENT '来源类型',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12622 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_audit
-- ----------------------------
INSERT INTO `sys_login_audit` VALUES ('12597', 'admin', '0:0:0:0:0:0:0:1', 'CFA21B5E453525EB93F44867A8B8D107', '20191112135200', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12598', 'admin', '0:0:0:0:0:0:0:1', '921CEDEECFD169E7DCA0D9458AF4E583', '20191112143556', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12599', 'admin', '0:0:0:0:0:0:0:1', '921CEDEECFD169E7DCA0D9458AF4E583', '20191112144403', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12600', 'admin', '0:0:0:0:0:0:0:1', '8B5D1DF0A896F4DF3413DAF2B2C3AE08', '20191112151003', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12601', 'admin', '0:0:0:0:0:0:0:1', '8B5D1DF0A896F4DF3413DAF2B2C3AE08', '20191112151140', '1', '', null, '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12602', 'admin', '0:0:0:0:0:0:0:1', 'EADE056720DDF67193C1C35DCE104140', '20191112151148', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12603', 'admin', '0:0:0:0:0:0:0:1', 'AEE762F07A5C656CC1745C9716C55744', '20191112151308', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12604', 'admin', '0:0:0:0:0:0:0:1', '52F9BCA80932B7BCDB6C034ED8BBC108', '20191117215835', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12605', 'admin', '0:0:0:0:0:0:0:1', 'E4C9DEF970E69F4309D1D9DB87CF9562', '20191117223607', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12606', 'admin', '0:0:0:0:0:0:0:1', 'E4C9DEF970E69F4309D1D9DB87CF9562', '20191117224129', '1', '', null, '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12607', 'admin', '0:0:0:0:0:0:0:1', 'EDB8C6A1DAFC5A2D775FAD72205D8D09', '20191117224142', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12608', 'admin', '0:0:0:0:0:0:0:1', 'EDB8C6A1DAFC5A2D775FAD72205D8D09', '20191117224250', '1', '', null, '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12609', 'admin', '0:0:0:0:0:0:0:1', '66B59DD56CFBD3D9A9030D0BFF75938D', '20191117224302', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12610', 'admin', '0:0:0:0:0:0:0:1', '537A7289BF4923A18332C7A676A45CEF', '20191118112238', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12611', 'admin', '0:0:0:0:0:0:0:1', '537A7289BF4923A18332C7A676A45CEF', '20191118113559', '1', '', null, '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12612', 'admin', '0:0:0:0:0:0:0:1', '2B4E4C94BCE23DD17A9351B451B3E0A0', '20191118113603', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12613', 'admin', '0:0:0:0:0:0:0:1', 'B20248FA74AD231D473E552D262AF6B2', '20191118213310', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12614', 'admin', '0:0:0:0:0:0:0:1', '5259F390F243F7860808B0D875FA4DC9', '20191119114155', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12615', 'admin', '0:0:0:0:0:0:0:1', 'BAA560134F484FBB50D2474EB5E4C8B2', '20191119114753', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12616', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '20191119120025', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12617', 'admin', '0:0:0:0:0:0:0:1', '43C86090B99523D0CAA768F7A9BDB7D9', '20191119162812', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12618', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '20191119163305', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12619', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '20191119163934', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12620', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '20191119170128', '0', '', 'pc', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12621', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '20191119171012', '0', '', 'pc', '', '', '');

-- ----------------------------
-- Table structure for sys_operate_audit
-- ----------------------------
DROP TABLE IF EXISTS `sys_operate_audit`;
CREATE TABLE `sys_operate_audit` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '登录的用户id',
  `ip` varchar(32) DEFAULT NULL COMMENT '请求ip地址',
  `session_id` varchar(64) DEFAULT NULL COMMENT 'sessionid',
  `description` varchar(500) DEFAULT NULL COMMENT '方法描述',
  `request_url` varchar(500) DEFAULT NULL COMMENT '请求的url',
  `request_param` varchar(1000) DEFAULT NULL COMMENT '请求参数',
  `request_time` varchar(14) DEFAULT NULL COMMENT '请求发生时间',
  `result` varchar(2000) DEFAULT NULL COMMENT '返回结果',
  `return_time` varchar(14) DEFAULT NULL COMMENT '接口调用返回时间',
  `source_type` varchar(32) DEFAULT NULL COMMENT '来源类型',
  `operation_type` varchar(32) DEFAULT NULL COMMENT '操作类型',
  `filler1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(500) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=5008 DEFAULT CHARSET=utf8 COMMENT='操作记录表';

-- ----------------------------
-- Records of sys_operate_audit
-- ----------------------------
INSERT INTO `sys_operate_audit` VALUES ('4884', 'admin', '0:0:0:0:0:0:0:1', 'BAA560134F484FBB50D2474EB5E4C8B2', '查询数据字典信息', '/console/dict/query', '{_page=1, _operation=query, _sourceType=pc, _length=10}', '20191119114828', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119115209', null, null, '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4885', 'admin', '0:0:0:0:0:0:0:1', 'BAA560134F484FBB50D2474EB5E4C8B2', '查询数据字典信息', '/console/dict/query', '{_page=1, _operation=query, _sourceType=pc, _length=10}', '20191119115211', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119115211', null, null, '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4886', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '获取用户菜单', '/getUserDetail', '{length=10, source_type=pc, page=1, operation=query}', '20191119120025', '{\"data\":{\"dictList\":{\"0006\":[{\"pk_id\":\"0006|0\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"0\",\"dict_name_en\":\"False\",\"dict_name_cn\":\"否\"},{\"pk_id\":\"0006|1\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"1\",\"dict_name_en\":\"True\",\"dict_name_cn\":\"是\"}],\"0007\":[{\"pk_id\":\"0007|add\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"add\",\"dict_name_en\":\"add\",\"dict_name_cn\":\"新增\"},{\"pk_id\":\"0007|delete\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"delete\",\"dict_name_en\":\"delete\",\"dict_name_cn\":\"删除\"},{\"pk_id\":\"0007|export\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"export\",\"dict_name_en\":\"export\",\"dict_name_cn\":\"导出\"},{\"pk_id\":\"0007|query\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"query\",\"dict_name_en\":\"query\",\"dict_name_cn\":\"查询\"},{\"pk_id\":\"0007|update\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"update\",\"dict_name_en\":\"update\",\"dict_name_cn\":\"修改\"},{\"pk_id\":\"0007|upload\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"upload\",\"dict_name_en\":\"up', '20191119120025', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4887', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119120027', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119120027', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4888', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119120029', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119120029', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4889', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119120032', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119120032', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4890', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=2, operation=query}', '20191119120036', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223259\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifi', '20191119120036', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4891', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119120037', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119120037', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4892', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=2, operation=query}', '20191119120047', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223259\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifi', '20191119120047', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4893', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119120049', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119120049', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4894', 'admin', '0:0:0:0:0:0:0:1', 'C0F3B93F97807CE20783ED2CBF4AF8F7', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=2, operation=query}', '20191119120054', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223259\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifi', '20191119120054', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4895', 'admin', '0:0:0:0:0:0:0:1', '43C86090B99523D0CAA768F7A9BDB7D9', '获取用户菜单', '/getUserDetail', '{length=10, source_type=pc, page=1, operation=query}', '20191119162812', '{\"data\":{\"dictList\":{\"0006\":[{\"pk_id\":\"0006|0\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"0\",\"dict_name_en\":\"False\",\"dict_name_cn\":\"否\"},{\"pk_id\":\"0006|1\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"1\",\"dict_name_en\":\"True\",\"dict_name_cn\":\"是\"}],\"0007\":[{\"pk_id\":\"0007|add\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"add\",\"dict_name_en\":\"add\",\"dict_name_cn\":\"新增\"},{\"pk_id\":\"0007|delete\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"delete\",\"dict_name_en\":\"delete\",\"dict_name_cn\":\"删除\"},{\"pk_id\":\"0007|export\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"export\",\"dict_name_en\":\"export\",\"dict_name_cn\":\"导出\"},{\"pk_id\":\"0007|query\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"query\",\"dict_name_en\":\"query\",\"dict_name_cn\":\"查询\"},{\"pk_id\":\"0007|update\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"update\",\"dict_name_en\":\"update\",\"dict_name_cn\":\"修改\"},{\"pk_id\":\"0007|upload\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"upload\",\"dict_name_en\":\"up', '20191119162813', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4896', 'admin', '0:0:0:0:0:0:0:1', '43C86090B99523D0CAA768F7A9BDB7D9', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119162818', '{\"code\":\"500\",\"message\":\"Intertnal Server Error\",\"success\":true}', '20191119162856', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4897', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '获取用户菜单', '/getUserDetail', '{length=10, source_type=pc, page=1, operation=query}', '20191119163305', '{\"data\":{\"dictList\":{\"0006\":[{\"pk_id\":\"0006|0\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"0\",\"dict_name_en\":\"False\",\"dict_name_cn\":\"否\"},{\"pk_id\":\"0006|1\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"1\",\"dict_name_en\":\"True\",\"dict_name_cn\":\"是\"}],\"0007\":[{\"pk_id\":\"0007|add\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"add\",\"dict_name_en\":\"add\",\"dict_name_cn\":\"新增\"},{\"pk_id\":\"0007|delete\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"delete\",\"dict_name_en\":\"delete\",\"dict_name_cn\":\"删除\"},{\"pk_id\":\"0007|export\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"export\",\"dict_name_en\":\"export\",\"dict_name_cn\":\"导出\"},{\"pk_id\":\"0007|query\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"query\",\"dict_name_en\":\"query\",\"dict_name_cn\":\"查询\"},{\"pk_id\":\"0007|update\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"update\",\"dict_name_en\":\"update\",\"dict_name_cn\":\"修改\"},{\"pk_id\":\"0007|upload\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"upload\",\"dict_name_en\":\"up', '20191119163306', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4898', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119163308', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119163333', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4899', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=2, operation=query}', '20191119163337', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223259\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifi', '20191119163343', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4900', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119163507', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119163507', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4901', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119163659', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119163659', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4902', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=2, operation=query}', '20191119163700', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223259\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifi', '20191119163700', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4903', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119163702', '{\"code\":\"500\",\"message\":\"Intertnal Server Error\",\"success\":true}', '20191119163703', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4904', 'admin', '0:0:0:0:0:0:0:1', '894B3BC92BE23AB072219DFD1837A629', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119163805', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119163805', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4905', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '获取用户菜单', '/getUserDetail', '{length=10, source_type=pc, page=1, operation=query}', '20191119163934', '{\"data\":{\"dictList\":{\"0006\":[{\"pk_id\":\"0006|0\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"0\",\"dict_name_en\":\"False\",\"dict_name_cn\":\"否\"},{\"pk_id\":\"0006|1\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"1\",\"dict_name_en\":\"True\",\"dict_name_cn\":\"是\"}],\"0007\":[{\"pk_id\":\"0007|add\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"add\",\"dict_name_en\":\"add\",\"dict_name_cn\":\"新增\"},{\"pk_id\":\"0007|delete\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"delete\",\"dict_name_en\":\"delete\",\"dict_name_cn\":\"删除\"},{\"pk_id\":\"0007|export\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"export\",\"dict_name_en\":\"export\",\"dict_name_cn\":\"导出\"},{\"pk_id\":\"0007|query\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"query\",\"dict_name_en\":\"query\",\"dict_name_cn\":\"查询\"},{\"pk_id\":\"0007|update\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"update\",\"dict_name_en\":\"update\",\"dict_name_cn\":\"修改\"},{\"pk_id\":\"0007|upload\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"upload\",\"dict_name_en\":\"up', '20191119163935', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4906', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119163945', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119163945', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4907', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119163950', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119163956', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4908', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164001', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164002', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4909', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164006', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164006', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4910', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164008', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164008', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4911', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164010', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164010', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4912', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164011', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164011', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4913', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164012', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164012', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4914', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164012', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164012', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4915', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupName, operation=query, order=ascending}', '20191119164014', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modif', '20191119164014', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4916', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupName, operation=query, order=descending}', '20191119164015', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"PC端\",\"dictNameEn\":\"PC\",\"dictValue\":\"0\",\"groupId\":\"0005\",\"groupName\":\"来源类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223157\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":\"20191117222946\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":\"20191117222953\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223234\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"', '20191119164015', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4917', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupName, operation=query}', '20191119164016', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modif', '20191119164016', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4918', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupName, operation=query, order=ascending}', '20191119164017', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modif', '20191119164017', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4919', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupName, operation=query, order=descending}', '20191119164018', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"PC端\",\"dictNameEn\":\"PC\",\"dictValue\":\"0\",\"groupId\":\"0005\",\"groupName\":\"来源类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223157\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":\"20191117222946\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":\"20191117222953\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"20191117223234\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifier\":\"admin\",\"modifyTime\":\"', '20191119164018', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4920', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164020', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164020', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4921', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164021', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164021', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4922', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164022', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164022', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4923', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164022', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164022', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4924', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164023', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164023', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4925', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164024', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164024', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4926', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164024', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164024', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4927', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164025', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164025', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4928', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164025', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164025', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4929', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164032', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164032', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4930', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164037', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164037', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4931', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164038', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164038', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4932', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119164039', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119164039', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4933', 'admin', '0:0:0:0:0:0:0:1', 'F3DB3476116DD1B9CC964541699158FF', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119164041', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"上传\",\"dictNameEn\":\"upload\",\"dictValue\":\"upload\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113258\"},{\"dictNameCn\":\"修改\",\"dictNameEn\":\"update\",\"dictValue\":\"update\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113250\"},{\"dictNameCn\":\"查询\",\"dictNameEn\":\"query\",\"dictValue\":\"query\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113244\"},{\"dictNameCn\":\"导出\",\"dictNameEn\":\"export\",\"dictValue\":\"export\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113238\"},{\"dictNameCn\":\"删除\",\"dictNameEn\":\"delete\",\"dictValue\":\"delete\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113232\"},{\"dictNameCn\":\"新增\",\"dictNameEn\":\"add\",\"dictValue\":\"add\",\"groupId\":\"0007\",\"groupName\":\"操作类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191118113225\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0006\",\"groupName\":\"是否叶节点\",\"modifi', '20191119164041', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4934', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '获取用户菜单', '/getUserDetail', '{length=10, source_type=pc, page=1, operation=query}', '20191119170129', '{\"data\":{\"dictList\":{\"0006\":[{\"pk_id\":\"0006|0\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"0\",\"dict_name_en\":\"False\",\"dict_name_cn\":\"否\"},{\"pk_id\":\"0006|1\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"1\",\"dict_name_en\":\"True\",\"dict_name_cn\":\"是\"}],\"0007\":[{\"pk_id\":\"0007|add\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"add\",\"dict_name_en\":\"add\",\"dict_name_cn\":\"新增\"},{\"pk_id\":\"0007|delete\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"delete\",\"dict_name_en\":\"delete\",\"dict_name_cn\":\"删除\"},{\"pk_id\":\"0007|export\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"export\",\"dict_name_en\":\"export\",\"dict_name_cn\":\"导出\"},{\"pk_id\":\"0007|query\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"query\",\"dict_name_en\":\"query\",\"dict_name_cn\":\"查询\"},{\"pk_id\":\"0007|update\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"update\",\"dict_name_en\":\"update\",\"dict_name_cn\":\"修改\"},{\"pk_id\":\"0007|upload\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"upload\",\"dict_name_en\":\"up', '20191119170129', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4935', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119170131', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119170131', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4936', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119170133', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119170133', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4937', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119170332', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119170332', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4938', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119170336', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119170336', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4939', 'admin', '0:0:0:0:0:0:0:1', 'DE2429CD81C4441A0C082AC80591EF03', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119170344', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119170344', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4940', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '获取用户菜单', '/getUserDetail', '{length=10, source_type=pc, page=1, operation=query}', '20191119171012', '{\"data\":{\"dictList\":{\"0006\":[{\"pk_id\":\"0006|0\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"0\",\"dict_name_en\":\"False\",\"dict_name_cn\":\"否\"},{\"pk_id\":\"0006|1\",\"group_id\":\"0006\",\"group_name\":\"是否叶节点\",\"dict_value\":\"1\",\"dict_name_en\":\"True\",\"dict_name_cn\":\"是\"}],\"0007\":[{\"pk_id\":\"0007|add\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"add\",\"dict_name_en\":\"add\",\"dict_name_cn\":\"新增\"},{\"pk_id\":\"0007|delete\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"delete\",\"dict_name_en\":\"delete\",\"dict_name_cn\":\"删除\"},{\"pk_id\":\"0007|export\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"export\",\"dict_name_en\":\"export\",\"dict_name_cn\":\"导出\"},{\"pk_id\":\"0007|query\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"query\",\"dict_name_en\":\"query\",\"dict_name_cn\":\"查询\"},{\"pk_id\":\"0007|update\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"update\",\"dict_name_en\":\"update\",\"dict_name_cn\":\"修改\"},{\"pk_id\":\"0007|upload\",\"group_id\":\"0007\",\"group_name\":\"操作类型\",\"dict_value\":\"upload\",\"dict_name_en\":\"up', '20191119171012', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4941', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询用户信息', '/console/user/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171016', '{\"code\":\"200\",\"data\":[{\"modifier\":\"admin\",\"modifyTime\":\"20191106162048\",\"passWord\":\"3f2cf36a0963cf127ce8b5f1eb91a447\",\"userId\":\"124\",\"userName\":\"124124\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028105909\",\"passWord\":\"eac4108912af90ae96e858190f4d8af7\",\"userId\":\"admin\",\"userName\":\"管理员\"},{\"modifier\":\"admin\",\"modifyTime\":\"20191028101159\",\"passWord\":\"d74682ee47c3fffd5dcd749f840fcdd4\",\"userId\":\"qwer\",\"userName\":\"1qwrw\"}],\"message\":\"success\",\"success\":true,\"total\":3}', '20191119171016', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4942', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171027', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171027', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4943', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171143', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171143', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4944', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleId, operation=query, order=ascending}', '20191119171144', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171144', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4945', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleId, operation=query, order=descending}', '20191119171145', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171145', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4946', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleId, operation=query, order=ascending}', '20191119171145', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171145', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4947', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleName, operation=query, order=ascending}', '20191119171146', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171146', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4948', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleName, operation=query, order=descending}', '20191119171147', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171147', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4949', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleName, operation=query}', '20191119171148', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171148', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4950', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleName, operation=query, order=ascending}', '20191119171148', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171148', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4951', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询角色信息', '/console/role/query', '{length=10, source_type=pc, page=1, sort=roleName, operation=query, order=descending}', '20191119171149', '{\"code\":\"200\",\"data\":[{\"description\":\"1241\",\"modifier\":\"admin\",\"modifyTime\":\"20191104180727\",\"roleId\":\"admin\",\"roleName\":\"系统管理员\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171149', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4952', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询菜单信息', '/console/resource/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171151', '{\"code\":\"200\",\"data\":[{\"enabled\":\"1\",\"icon\":\"el-icon-s-home\",\"isLeaf\":\"0\",\"modifier\":\"admin\",\"modifyTime\":\"20191107144005\",\"morder\":0,\"parentResourceId\":\"Root\",\"resourceId\":\"Dashboard\",\"resourceName\":\"首页\",\"url\":\"/dashboard\"},{\"children\":[{\"enabled\":\"1\",\"isLeaf\":\"1\",\"modifier\":\"admin\",\"modifyTime\":\"20191112104058\",\"morder\":1,\"parentResourceId\":\"UserManage\",\"resourceId\":\"UserMaintain\",\"resourceName\":\"用户信息管理\",\"url\":\"/user\"},{\"enabled\":\"1\",\"isLeaf\":\"1\",\"morder\":2,\"parentResourceId\":\"UserManage\",\"resourceId\":\"RoleMaintain\",\"resourceName\":\"角色信息管理\",\"url\":\"/role\"},{\"enabled\":\"1\",\"isLeaf\":\"1\",\"morder\":3,\"parentResourceId\":\"UserManage\",\"resourceId\":\"ResourceMaintain\",\"resourceName\":\"菜单管理\",\"url\":\"/resource\"}],\"enabled\":\"1\",\"icon\":\"el-icon-user-solid\",\"isLeaf\":\"0\",\"modifier\":\"admin\",\"modifyTime\":\"20191107144230\",\"morder\":1,\"parentResourceId\":\"Root\",\"resourceId\":\"UserManage\",\"resourceName\":\"用户管理\",\"url\":\"\"},{\"children\":[{\"enabled\":\"1\",\"isLeaf\":\"1\",\"morder\":1,\"parentResourceId\":\"SystemManage\",\"resour', '20191119171151', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4953', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171158', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171158', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4954', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171248', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171248', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4955', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171250', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171251', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4956', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=ascending}', '20191119171252', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171252', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4957', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=groupId, operation=query, order=descending}', '20191119171253', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171253', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4958', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=paramId, operation=query, order=ascending}', '20191119171254', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171254', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4959', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=paramId, operation=query, order=descending}', '20191119171254', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171254', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4960', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=paramValue, operation=query, order=ascending}', '20191119171256', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171256', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4961', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=paramValue, operation=query, order=descending}', '20191119171257', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171257', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4962', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=paramId, operation=query, order=ascending}', '20191119171305', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171305', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4963', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询系统参数信息', '/console/param/query', '{length=10, source_type=pc, page=1, sort=paramId, operation=query, order=descending}', '20191119171305', '{\"code\":\"200\",\"data\":[{\"canDelete\":\"0\",\"groupId\":\"0001\",\"modifier\":\"admin\",\"modifyTime\":\"20191101170748\",\"paramId\":\"12\",\"paramName\":\"1221124\",\"paramValue\":\"12\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171305', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4964', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询数据字典信息', '/console/dict/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171309', '{\"code\":\"200\",\"data\":[{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215905\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"Ture\",\"dictValue\":\"1\",\"groupId\":\"0001\",\"groupName\":\"是否可用\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220752\"},{\"dictNameCn\":\"登录\",\"dictNameEn\":\"SignIn\",\"dictValue\":\"0\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215948\"},{\"dictNameCn\":\"登出\",\"dictNameEn\":\"SignOut\",\"dictValue\":\"1\",\"groupId\":\"0002\",\"groupName\":\"登录登出类型\",\"modifier\":\"admin\",\"modifyTime\":\"20191117215958\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220247\"},{\"dictNameCn\":\"是\",\"dictNameEn\":\"True\",\"dictValue\":\"1\",\"groupId\":\"0003\",\"groupName\":\"是否可删除\",\"modifier\":\"admin\",\"modifyTime\":\"20191117220801\"},{\"dictNameCn\":\"否\",\"dictNameEn\":\"False\",\"dictValue\":\"0\",\"groupId\":\"0004\",\"groupName\":\"是否成功\",\"modifier\":\"admin\",\"modifyTime\":', '20191119171309', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4965', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171312', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171312', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4966', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171349', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171350', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4967', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171417', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171417', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4968', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, sort=jobName, operation=query, order=ascending}', '20191119171421', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171421', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4969', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, sort=jobName, operation=query, order=descending}', '20191119171422', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171422', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4970', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171429', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171429', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4971', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, sort=jobId, operation=query, order=ascending}', '20191119171433', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171433', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4972', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, sort=jobId, operation=query, order=descending}', '20191119171433', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171433', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4973', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务信息', '/console/job/query', '{length=10, source_type=pc, page=1, sort=jobId, operation=query, order=ascending}', '20191119171434', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191119171434', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4974', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171530', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171530', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4975', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=code, operation=query, order=ascending}', '20191119171533', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171533', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4976', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=code, operation=query, order=descending}', '20191119171534', '{\"code\":\"200\",\"data\":[{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171534', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4977', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=code, operation=query, order=ascending}', '20191119171534', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171534', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4978', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=code, operation=query, order=descending}', '20191119171535', '{\"code\":\"200\",\"data\":[{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171535', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4979', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=code, operation=query, order=ascending}', '20191119171536', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171536', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4980', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, operation=query}', '20191119171542', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171542', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4981', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=modifyTime, operation=query, order=ascending}', '20191119171544', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171544', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4982', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=modifyTime, operation=query, order=descending}', '20191119171544', '{\"code\":\"200\",\"data\":[{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171544', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4983', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=modifyTime, operation=query, order=ascending}', '20191119171545', '{\"code\":\"200\",\"data\":[{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"},{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171545', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4984', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询返回码信息', '/console/returnCode/query', '{length=10, source_type=pc, page=1, sort=modifyTime, operation=query, order=descending}', '20191119171545', '{\"code\":\"200\",\"data\":[{\"code\":\"12421414\",\"message\":\"124\",\"modifier\":\"admin\",\"modifyTime\":\"20191112115838\",\"remark\":\"124124\"},{\"code\":\"24\",\"message\":\"24\",\"modifier\":\"admin\",\"modifyTime\":\"20191106103431\",\"remark\":\"42424\"},{\"code\":\"124\",\"message\":\"2411\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182256\",\"remark\":\"4141414\"},{\"code\":\"1\",\"message\":\"1231421\",\"modifier\":\"admin\",\"modifyTime\":\"20191104182133\",\"remark\":\"12414\"}],\"message\":\"success\",\"success\":true,\"total\":4}', '20191119171545', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4985', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询登录登出日志', '/console/loginAudit/query', '{createTimeList=20191119,20191119, createTime=20191119000000,20191119235959, length=10, source_type=pc, page=1, operation=query}', '20191119171547', '{\"code\":\"200\",\"data\":[{\"auditType\":\"0\",\"createTime\":\"20191119171012\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"F600D75C661BA1DF80B8C0225D4723A3\",\"sid\":12621,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119170128\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"DE2429CD81C4441A0C082AC80591EF03\",\"sid\":12620,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119163934\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"F3DB3476116DD1B9CC964541699158FF\",\"sid\":12619,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119163305\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"894B3BC92BE23AB072219DFD1837A629\",\"sid\":12618,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119162812\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"43C86090B99523D0CAA768F7A9BDB7D9\",\"sid\":', '20191119171547', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4986', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, operation=query}', '20191119171706', '{\"code\":\"200\",\"data\":[{\"description\":\"查询登录登出日志\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"operationType\":\"query\",\"requestParam\":\"{createTimeList=20191119,20191119, createTime=20191119000000,20191119235959, length=10, source_type=pc, page=1, operation=query}\",\"requestTime\":\"20191119171547\",\"requestUrl\":\"/console/loginAudit/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"auditType\\\":\\\"0\\\",\\\"createTime\\\":\\\"20191119171012\\\",\\\"filler1\\\":\\\"\\\",\\\"filler2\\\":\\\"\\\",\\\"filler3\\\":\\\"\\\",\\\"ip\\\":\\\"0:0:0:0:0:0:0:1\\\",\\\"sessionId\\\":\\\"F600D75C661BA1DF80B8C0225D4723A3\\\",\\\"sid\\\":12621,\\\"sourceType\\\":\\\"pc\\\",\\\"userId\\\":\\\"admin\\\"},{\\\"auditType\\\":\\\"0\\\",\\\"createTime\\\":\\\"20191119170128\\\",\\\"filler1\\\":\\\"\\\",\\\"filler2\\\":\\\"\\\",\\\"filler3\\\":\\\"\\\",\\\"ip\\\":\\\"0:0:0:0:0:0:0:1\\\",\\\"sessionId\\\":\\\"DE2429CD81C4441A0C082AC80591EF03\\\",\\\"sid\\\":12620,\\\"sourceType\\\":\\\"pc\\\",\\\"userId\\\":\\\"admin\\\"},{\\\"auditType\\\":\\\"0\\\",\\\"createTime\\\":\\\"20191119163934\\\",\\\"filler1\\\":\\\"\\\",\\\"filler2\\\":\\\"\\\",\\\"filler3\\\":\\\"\\\",\\\"ip\\\":\\\"0:0:0:0:0:0', '20191119171706', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4987', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, operation=query}', '20191119171745', '{\"code\":\"200\",\"data\":[{\"description\":\"查询操作日志\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"operationType\":\"query\",\"requestParam\":\"{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, operation=query}\",\"requestTime\":\"20191119171706\",\"requestUrl\":\"/console/operateAudit/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"description\\\":\\\"查询登录登出日志\\\",\\\"filler1\\\":\\\"\\\",\\\"filler2\\\":\\\"\\\",\\\"filler3\\\":\\\"\\\",\\\"ip\\\":\\\"0:0:0:0:0:0:0:1\\\",\\\"operationType\\\":\\\"query\\\",\\\"requestParam\\\":\\\"{createTimeList=20191119,20191119, createTime=20191119000000,20191119235959, length=10, source_type=pc, page=1, operation=query}\\\",\\\"requestTime\\\":\\\"20191119171547\\\",\\\"requestUrl\\\":\\\"/console/loginAudit/query\\\",\\\"result\\\":\\\"{\\\\\\\"code\\\\\\\":\\\\\\\"200\\\\\\\",\\\\\\\"data\\\\\\\":[{\\\\\\\"auditType\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"createTime\\\\\\\":\\\\\\\"20191119171012\\\\\\\",\\\\\\\"filler1\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"filler2\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"filler3\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"ip\\\\\\\":\\\\\\\"0:0:0:0:0:0:0:1\\\\\\\",\\\\\\\"sess', '20191119171745', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4988', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=ascending}', '20191119171747', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171747', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4989', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=descending}', '20191119171747', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171747', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4990', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query}', '20191119171748', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171748', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4991', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=descending}', '20191119171750', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171750', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4992', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=ascending}', '20191119171752', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171752', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4993', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=descending}', '20191119171757', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171757', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4994', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=ascending}', '20191119171758', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171758', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4995', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=descending}', '20191119171758', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171758', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4996', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=ascending}', '20191119171759', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171759', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4997', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=userId, operation=query, order=descending}', '20191119171800', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171800', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4998', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=requestTime, operation=query, order=ascending}', '20191119171802', '{\"code\":\"200\",\"data\":[{\"description\":\"查询数据字典信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{_page=1, _operation=query, _sourceType=pc, _length=10}\",\"requestTime\":\"20191119114828\",\"requestUrl\":\"/console/dict/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictNameEn\\\":\\\"False\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215905\\\"},{\\\"dictNameCn\\\":\\\"是\\\",\\\"dictNameEn\\\":\\\"Ture\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0001\\\",\\\"groupName\\\":\\\"是否可用\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117220752\\\"},{\\\"dictNameCn\\\":\\\"登录\\\",\\\"dictNameEn\\\":\\\"SignIn\\\",\\\"dictValue\\\":\\\"0\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215948\\\"},{\\\"dictNameCn\\\":\\\"登出\\\",\\\"dictNameEn\\\":\\\"SignOut\\\",\\\"dictValue\\\":\\\"1\\\",\\\"groupId\\\":\\\"0002\\\",\\\"groupName\\\":\\\"登录登出类型\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191117215958\\\"},{\\\"dictNameCn\\\":\\\"否\\\",\\\"dictN', '20191119171802', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('4999', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=requestTime, operation=query, order=descending}', '20191119171804', '{\"code\":\"200\",\"data\":[{\"description\":\"查询操作日志\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"operationType\":\"query\",\"requestParam\":\"{requestTime=20191119000000,20191119235959, requestTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=requestTime, operation=query, order=ascending}\",\"requestTime\":\"20191119171802\",\"requestUrl\":\"/console/operateAudit/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"description\\\":\\\"查询数据字典信息\\\",\\\"filler1\\\":\\\"\\\",\\\"filler2\\\":\\\"\\\",\\\"filler3\\\":\\\"\\\",\\\"ip\\\":\\\"0:0:0:0:0:0:0:1\\\",\\\"requestParam\\\":\\\"{_page=1, _operation=query, _sourceType=pc, _length=10}\\\",\\\"requestTime\\\":\\\"20191119114828\\\",\\\"requestUrl\\\":\\\"/console/dict/query\\\",\\\"result\\\":\\\"{\\\\\\\"code\\\\\\\":\\\\\\\"200\\\\\\\",\\\\\\\"data\\\\\\\":[{\\\\\\\"dictNameCn\\\\\\\":\\\\\\\"否\\\\\\\",\\\\\\\"dictNameEn\\\\\\\":\\\\\\\"False\\\\\\\",\\\\\\\"dictValue\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"groupId\\\\\\\":\\\\\\\"0001\\\\\\\",\\\\\\\"groupName\\\\\\\":\\\\\\\"是否可用\\\\\\\",\\\\\\\"modifier\\\\\\\":\\\\\\\"admin\\\\\\\",\\\\\\\"modifyTime\\\\\\\":\\\\\\\"20191117215905\\\\\\\"},{\\\\\\\"dictNameCn\\\\\\\":\\\\\\\"是\\\\\\\",\\\\\\\"di', '20191119171804', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5000', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, runTime=20191119000000,20191119235959, operation=query}', '20191119171828', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119171828', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5001', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, runTime=20191119000000,20191119235959, operation=query}', '20191119171912', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119171912', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5002', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询登录登出日志', '/console/loginAudit/query', '{createTimeList=20191119,20191119, createTime=20191119000000,20191119235959, length=10, source_type=pc, page=1, operation=query}', '20191119171915', '{\"code\":\"200\",\"data\":[{\"auditType\":\"0\",\"createTime\":\"20191119171012\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"F600D75C661BA1DF80B8C0225D4723A3\",\"sid\":12621,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119170128\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"DE2429CD81C4441A0C082AC80591EF03\",\"sid\":12620,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119163934\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"F3DB3476116DD1B9CC964541699158FF\",\"sid\":12619,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119163305\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"894B3BC92BE23AB072219DFD1837A629\",\"sid\":12618,\"sourceType\":\"pc\",\"userId\":\"admin\"},{\"auditType\":\"0\",\"createTime\":\"20191119162812\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"sessionId\":\"43C86090B99523D0CAA768F7A9BDB7D9\",\"sid\":', '20191119171915', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5003', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, runTime=20191119000000,20191119235959, operation=query}', '20191119172128', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119172128', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5004', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=jobId, runTime=20191119000000,20191119235959, operation=query, order=ascending}', '20191119172130', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119172130', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5005', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=jobId, runTime=20191119000000,20191119235959, operation=query, order=descending}', '20191119172131', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119172131', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5006', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=runTime, runTime=20191119000000,20191119235959, operation=query, order=ascending}', '20191119172132', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119172132', 'pc', 'query', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('5007', 'admin', '0:0:0:0:0:0:0:1', 'F600D75C661BA1DF80B8C0225D4723A3', '查询定时任务执行日志', '/console/jobLog/query', '{runTimeList=20191119,20191119, length=10, source_type=pc, page=1, sort=runTime, runTime=20191119000000,20191119235959, operation=query, order=descending}', '20191119172132', '{\"code\":\"200\",\"data\":[],\"message\":\"success\",\"success\":true,\"total\":0}', '20191119172133', 'pc', 'query', '', '', '');

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `group_id` varchar(4) NOT NULL COMMENT '组号',
  `param_id` varchar(10) NOT NULL COMMENT '参数id',
  `param_value` varchar(256) NOT NULL COMMENT '参数值',
  `param_name` varchar(100) NOT NULL COMMENT '参数名',
  `can_delete` varchar(1) NOT NULL COMMENT '是否可修改',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `filler1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(500) DEFAULT NULL COMMENT '预留字段3',
  `filler4` varchar(500) DEFAULT NULL COMMENT '预留字段4',
  PRIMARY KEY (`group_id`,`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('0001', '12', '12', '1221124', '0', null, 'admin', '20191101170748', null, null, null, null);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` varchar(32) NOT NULL COMMENT '菜单id',
  `resource_name` varchar(128) NOT NULL COMMENT '菜单名称',
  `url` varchar(128) DEFAULT NULL COMMENT '菜单链接',
  `parent_resource_id` varchar(32) DEFAULT NULL COMMENT '父节点id',
  `is_leaf` varchar(1) NOT NULL COMMENT '是否叶节点',
  `morder` int(5) DEFAULT NULL COMMENT '排序',
  `enabled` varchar(1) NOT NULL COMMENT '是否可用',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `icon` varchar(256) DEFAULT NULL COMMENT '小图标',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('Dashboard', '首页', '/dashboard', 'Root', '0', '0', '1', 'admin', '20191107144005', 'el-icon-s-home', null, null, null);
INSERT INTO `sys_resource` VALUES ('DictMaintain', '数据字典', '/dict', 'SystemManage', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('Icon', '图标', '/icon', 'Tools', '1', '1', '1', 'admin', '20191101175555', null, null, null, null);
INSERT INTO `sys_resource` VALUES ('JobLogMaintain', '定时任务日志', '/jobLog', 'LogManage', '1', '3', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('JobMaintain', '定时任务管理', '/job', 'SystemManage', '1', '3', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('LoginAuditMaintain', '登录登出日志', '/loginAudit', 'LogManage', '1', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('LogManage', '日志管理', '', 'Root', '0', '3', '1', 'admin', '20191107144137', 'el-icon-notebook-1', null, null, null);
INSERT INTO `sys_resource` VALUES ('OperateAuditMaintain', '操作日志', '/oprateAudit', 'LogManage', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('ParamMaintain', '系统参数', '/param', 'SystemManage', '1', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('ResourceMaintain', '菜单管理', '/resource', 'UserManage', '1', '3', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('ReturnCodeMaintain', '返回码', '/returnCode', 'SystemManage', '1', '4', '1', '', '', '', '', '', '');
INSERT INTO `sys_resource` VALUES ('RoleMaintain', '角色信息管理', '/role', 'UserManage', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('SystemManage', '系统管理', '', 'Root', '0', '2', '1', 'admin', '20191107144307', 'el-icon-set-up', null, null, null);
INSERT INTO `sys_resource` VALUES ('Tools', '工具', null, 'Root', '0', '4', '1', 'admin', '20191107143827', 'el-icon-s-tools', null, null, null);
INSERT INTO `sys_resource` VALUES ('UserMaintain', '用户信息管理', '/user', 'UserManage', '1', '1', '1', 'admin', '20191112104058', null, null, null, null);
INSERT INTO `sys_resource` VALUES ('UserManage', '用户管理', '', 'Root', '0', '1', '1', 'admin', '20191107144230', 'el-icon-user-solid', null, null, null);

-- ----------------------------
-- Table structure for sys_return_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_return_code`;
CREATE TABLE `sys_return_code` (
  `code` varchar(32) NOT NULL COMMENT '返回码',
  `message` varchar(1000) NOT NULL COMMENT '返回信息',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `filler1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(500) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_return_code
-- ----------------------------
INSERT INTO `sys_return_code` VALUES ('1', '1231421', '12414', '20191104182133', 'admin', null, null, null);
INSERT INTO `sys_return_code` VALUES ('124', '2411', '4141414', '20191104182256', 'admin', null, null, null);
INSERT INTO `sys_return_code` VALUES ('12421414', '124', '124124', '20191112115838', 'admin', null, null, null);
INSERT INTO `sys_return_code` VALUES ('24', '24', '42424', '20191106103431', 'admin', null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `enabled` varchar(1) DEFAULT NULL COMMENT '是否可用',
  `modifier` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('admin', '系统管理员', '1241', null, 'admin', '20191104180727', null, null, null);

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `resource_id` varchar(32) NOT NULL COMMENT '资源id',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源映射表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('admin', 'Dashboard', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'DictMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'Icon', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'JobLogMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'JobMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'LoginAuditMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'LogManage', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'OperateAuditMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'ParamMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'ResourceMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'ReturnCodeMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'RoleMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'SystemManage', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'Tools', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'UserMaintain', 'admin', '20191104180727', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', 'UserManage', 'admin', '20191104180727', null, null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户账号',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('124', '124124', '3f2cf36a0963cf127ce8b5f1eb91a447', 'admin', '20191106162048', null, null, null);
INSERT INTO `sys_user` VALUES ('admin', '管理员', 'eac4108912af90ae96e858190f4d8af7', 'admin', '20191028105909', null, null, null);
INSERT INTO `sys_user` VALUES ('qwer', '1qwrw', 'd74682ee47c3fffd5dcd749f840fcdd4', 'admin', '20191028101159', null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `modifier` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` varchar(14) DEFAULT NULL COMMENT '最后修改时间',
  `filler1` varchar(60) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('admin', 'admin', 'admin', '20191023112640', null, null, null);
INSERT INTO `sys_user_role` VALUES ('admin', 'test', 'admin', '20191023112640', null, null, null);
