/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : cofire

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-10-28 11:01:59
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
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 COMMENT='批任务日志表';

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

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `group_id` varchar(4) NOT NULL COMMENT '组号',
  `group_name` varchar(100) DEFAULT NULL COMMENT '组名',
  `dict_value` varchar(30) NOT NULL COMMENT '数据字典值',
  `dict_name` varchar(100) DEFAULT NULL COMMENT '数据字典名称',
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
INSERT INTO `sys_dict` VALUES ('0001', '是否可用', '0', '否', '20191022134010', 'admin', '', '', '', '');
INSERT INTO `sys_dict` VALUES ('0001', '是否可用', '1', '是12', '20191024165306', 'admin', '', '', '', '');
INSERT INTO `sys_dict` VALUES ('0002', '登录登出类型', '0', '登录', '20191022132511', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0002', '登录登出类型', '1', '登出', '20191022132536', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0003', '是否可删除', '0', '否', '20191024164638', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0003', '是否可删除', '1', '是', '20191024165352', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0004', '是否成功', '0', '否', '20191024171418', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0004', '是否成功', '1', '是', '20191024171440', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0005', '来源类型', '0', 'PC端', '20191024173017', 'admin', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=12545 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_audit
-- ----------------------------
INSERT INTO `sys_login_audit` VALUES ('123', '12', null, null, null, null, null, '2', null, null, null);
INSERT INTO `sys_login_audit` VALUES ('124', '13', null, null, null, null, null, '1', null, null, null);
INSERT INTO `sys_login_audit` VALUES ('1214', '12', null, null, null, null, null, '1', null, null, null);
INSERT INTO `sys_login_audit` VALUES ('12414', '13', null, null, null, null, null, '2', null, null, null);
INSERT INTO `sys_login_audit` VALUES ('12415', 'admin', '0:0:0:0:0:0:0:1', '09F9A907FBD50F8E4736F6E24031560D', '20191012162508', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12416', 'admin', '0:0:0:0:0:0:0:1', '2C4F0D5EB2E2C92F7EAB092A8FF00486', '20191012164533', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12417', 'admin', '0:0:0:0:0:0:0:1', '2DEABFA86E99AF6BE9F64557173644ED', '20191012170946', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12418', 'admin', '0:0:0:0:0:0:0:1', '80137522A8A53E864ACC7C355A84BEAF', '20191012171306', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12419', 'admin', '0:0:0:0:0:0:0:1', 'F06E7CA005B62BBEE6FA7F2C159833D7', '20191012171531', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12420', 'admin', '0:0:0:0:0:0:0:1', 'D030929B990C95ACF1BDF928D84993B4', '20191012172343', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12421', 'admin', '0:0:0:0:0:0:0:1', '3F08939A7DA53822E88838F6BE445CCF', '20191012173450', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12422', 'admin', '0:0:0:0:0:0:0:1', '3F08939A7DA53822E88838F6BE445CCF', '20191012174244', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12423', 'admin', '0:0:0:0:0:0:0:1', '3C1D6104A0D502EFB787CA51604B7E5F', '20191012174255', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12424', 'admin', '0:0:0:0:0:0:0:1', '6675A7E6B8FBC3946A27D1CB53100BAC', '20191013203946', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12425', 'admin', '0:0:0:0:0:0:0:1', 'B26985B85C524DD0B4F023760EE4E818', '20191013205650', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12426', 'admin', '0:0:0:0:0:0:0:1', 'D9AA760F94EFA23C8766868F219A8D53', '20191013211816', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12427', 'admin', '0:0:0:0:0:0:0:1', 'CEA95B9585038741FC05D7E0882B0514', '20191014110458', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12428', 'admin', '0:0:0:0:0:0:0:1', '3B95BD6779EAE21F1066B0AEFE59CEA0', '20191014110658', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12429', 'admin', '0:0:0:0:0:0:0:1', '6F810FC42546C24AA737F22E96FCBE3F', '20191014111311', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12430', 'admin', '0:0:0:0:0:0:0:1', 'CA5D50EBD8C46AD3D7CF664842221C96', '20191014111505', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12431', 'admin', '0:0:0:0:0:0:0:1', '2263DBE17DF37CB8B3F6E1FD999DC789', '20191015104956', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12432', 'admin', '0:0:0:0:0:0:0:1', '51A26CC910674CA7CAC43583B5493BD7', '20191015110241', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12433', 'admin', '0:0:0:0:0:0:0:1', '7F436198B410872B7BE16F885AAB9AB9', '20191015111951', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12434', 'admin', '0:0:0:0:0:0:0:1', 'BC678538FC44FB1627233007111D49E7', '20191015115121', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12435', 'admin', '0:0:0:0:0:0:0:1', 'BC678538FC44FB1627233007111D49E7', '20191015120528', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12436', 'admin', '0:0:0:0:0:0:0:1', 'ED4BE6C36D2FD5B242A2479F9A10E010', '20191015120537', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12437', 'admin', '0:0:0:0:0:0:0:1', '9016243CBFBBE7C167D099BC139EABE4', '20191015133416', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12438', 'admin', '0:0:0:0:0:0:0:1', '04E8A85BEB114E6683FB002448B489A3', '20191015211748', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12439', 'admin', '0:0:0:0:0:0:0:1', 'EA169384059AD976D545E76C30BE70FF', '20191015213815', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12440', 'admin', '0:0:0:0:0:0:0:1', '5C3D8C299E0324BED1CA4F4173D670FD', '20191016114422', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12441', 'admin', '0:0:0:0:0:0:0:1', '97CA54F23D8B2EF0A20A43E1A2300920', '20191016150105', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12442', 'admin', '0:0:0:0:0:0:0:1', 'F74953951F0E500EBF1F0DECE8339F23', '20191016154216', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12443', 'admin', '0:0:0:0:0:0:0:1', 'F74953951F0E500EBF1F0DECE8339F23', '20191016164110', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12444', 'admin', '0:0:0:0:0:0:0:1', '0868628C6B49067731D68A58A08E1DB3', '20191017103406', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12445', 'admin', '0:0:0:0:0:0:0:1', '0868628C6B49067731D68A58A08E1DB3', '20191017103615', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12446', 'admin', '0:0:0:0:0:0:0:1', '5FEE9D0984FD82EB8C723460B7DC4386', '20191017113739', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12447', 'admin', '0:0:0:0:0:0:0:1', '5FEE9D0984FD82EB8C723460B7DC4386', '20191017113920', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12448', 'admin', '0:0:0:0:0:0:0:1', '9C806823217A23C0278C8FAAF72B1725', '20191017113925', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12449', 'admin', '0:0:0:0:0:0:0:1', '9C806823217A23C0278C8FAAF72B1725', '20191017114133', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12450', 'admin', '0:0:0:0:0:0:0:1', 'F0E1D919AE50CD6718A0345243E15D20', '20191017114138', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12451', 'admin', '0:0:0:0:0:0:0:1', 'F0E1D919AE50CD6718A0345243E15D20', '20191017114252', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12452', 'admin', '0:0:0:0:0:0:0:1', 'B0337C7C3E0367917935E92EF5B5F1D7', '20191017114257', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12453', 'admin', '0:0:0:0:0:0:0:1', '85EEE6C03B65ABC95C45FCE5778A1190', '20191017131656', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12454', 'admin', '0:0:0:0:0:0:0:1', '34222970BFF9A59DA4406D7C9D3AA5CB', '20191017135603', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12455', 'admin', '0:0:0:0:0:0:0:1', '8787915AB1970296858D06B1E79A1151', '20191017152217', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12456', 'admin', '0:0:0:0:0:0:0:1', 'E22E5A35A007583A480CC3016F2FF0B3', '20191017153526', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12457', 'admin', '0:0:0:0:0:0:0:1', '8298B446A6A79CCA76D7CA7CA04A3BA0', '20191017154625', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12458', 'admin', '0:0:0:0:0:0:0:1', '299BE3F886AAFDCE527E5014363E54CA', '20191017154931', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12459', 'admin', '0:0:0:0:0:0:0:1', '85DD9A99901A2AA427B9BBB35374707E', '20191017155107', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12460', 'admin', '0:0:0:0:0:0:0:1', 'E3018CF79CE512797695CEE651EADA21', '20191017155330', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12461', 'admin', '0:0:0:0:0:0:0:1', '8921460E5A337783F62224989295923A', '20191017161909', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12462', 'admin', '0:0:0:0:0:0:0:1', 'AAF2E06891CE74E87592CD8AFF90F06B', '20191017174017', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12463', 'admin', '0:0:0:0:0:0:0:1', 'AAF2E06891CE74E87592CD8AFF90F06B', '20191017175231', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12464', 'test', '0:0:0:0:0:0:0:1', '608A52E10C53EDAB9E00993674CACE3B', '20191017175317', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12465', 'test', '0:0:0:0:0:0:0:1', '608A52E10C53EDAB9E00993674CACE3B', '20191017175328', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12466', 'admin', '0:0:0:0:0:0:0:1', 'D85306C1B172EC77F0EE5D15C801CDCC', '20191017175333', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12467', 'admin', '0:0:0:0:0:0:0:1', '039E144ED94CC038BB62F5A7D7F7C56A', '20191017175712', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12468', 'admin', '0:0:0:0:0:0:0:1', 'B1112DB4B3BC1D6D77FF55AB3ACB9783', '20191017180220', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12469', 'admin', '0:0:0:0:0:0:0:1', 'D2203D815D70CC078EEA63D7D11764B5', '20191018110648', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12470', 'admin', '0:0:0:0:0:0:0:1', 'EA509A098DEA0FF6875EA2C554861A8C', '20191018114736', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12471', 'admin', '0:0:0:0:0:0:0:1', 'EA509A098DEA0FF6875EA2C554861A8C', '20191018114923', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12472', 'admin', '0:0:0:0:0:0:0:1', '23F44F1CDAB8E5255CEFD1B991C55C1A', '20191018114938', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12473', 'admin', '0:0:0:0:0:0:0:1', '53A817FB3F9AEE99BB84BC8C3F9BDBAF', '20191018115852', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12474', 'admin', '0:0:0:0:0:0:0:1', '1DE905F168CEAEBA667A06DC86DB21CC', '20191018122002', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12475', 'admin', '0:0:0:0:0:0:0:1', '1DE905F168CEAEBA667A06DC86DB21CC', '20191018122038', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12476', 'admin', '0:0:0:0:0:0:0:1', '1DE905F168CEAEBA667A06DC86DB21CC', '20191018122117', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12477', 'admin', '0:0:0:0:0:0:0:1', '1DE905F168CEAEBA667A06DC86DB21CC', '20191018122151', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12478', 'admin', '0:0:0:0:0:0:0:1', '1DE905F168CEAEBA667A06DC86DB21CC', '20191018122158', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12479', 'admin', '0:0:0:0:0:0:0:1', '2ED8A5CA59AF422E6C8DDA0DF6D748BB', '20191018122203', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12480', 'admin', '0:0:0:0:0:0:0:1', '2ED8A5CA59AF422E6C8DDA0DF6D748BB', '20191018122314', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12481', 'admin', '0:0:0:0:0:0:0:1', '783E9EB21BA3B2E05965BB32A792B379', '20191018122321', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12482', 'admin', '0:0:0:0:0:0:0:1', '783E9EB21BA3B2E05965BB32A792B379', '20191018122414', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12483', 'admin', '0:0:0:0:0:0:0:1', '46B8A938B38E10CB9E14B93C69AF7731', '20191018122419', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12484', 'admin', '0:0:0:0:0:0:0:1', '46B8A938B38E10CB9E14B93C69AF7731', '20191018122427', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12485', 'admin', '0:0:0:0:0:0:0:1', 'B7576DEC9FC4E2C372AE5060ABD6CE63', '20191018122433', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12486', 'admin', '0:0:0:0:0:0:0:1', 'B7576DEC9FC4E2C372AE5060ABD6CE63', '20191018122932', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12487', 'admin', '0:0:0:0:0:0:0:1', '0007BEFA343BC4D1E0D09B9614F24F7E', '20191018122938', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12488', 'admin', '0:0:0:0:0:0:0:1', '0007BEFA343BC4D1E0D09B9614F24F7E', '20191018123223', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12489', 'admin', '0:0:0:0:0:0:0:1', '0007BEFA343BC4D1E0D09B9614F24F7E', '20191018123235', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12490', 'admin', '0:0:0:0:0:0:0:1', '855FF7BA12B22CD85D7D1E039FEF3A93', '20191018125543', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12491', 'admin', '0:0:0:0:0:0:0:1', '855FF7BA12B22CD85D7D1E039FEF3A93', '20191018125625', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12492', 'admin', '0:0:0:0:0:0:0:1', '0AA38B962C0E5B35F2743A2C223C4EEF', '20191018125631', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12493', 'admin', '0:0:0:0:0:0:0:1', '0AA38B962C0E5B35F2743A2C223C4EEF', '20191018125652', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12494', 'admin', '0:0:0:0:0:0:0:1', 'DD06512F592E41EFD6493EE15183C51F', '20191018125814', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12495', 'admin', '0:0:0:0:0:0:0:1', '93ADEE8BE1E3CF8114003C7543576053', '20191018143239', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12496', 'admin', '0:0:0:0:0:0:0:1', '93ADEE8BE1E3CF8114003C7543576053', '20191018143421', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12497', 'admin', '0:0:0:0:0:0:0:1', '3638A1F131187ED3BEE47760CFF3E460', '20191018143441', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12498', 'admin', '0:0:0:0:0:0:0:1', 'FC817809115ABB5CA0A1F670BF001B48', '20191018143705', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12499', 'admin', '0:0:0:0:0:0:0:1', 'FC817809115ABB5CA0A1F670BF001B48', '20191018143724', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12500', 'test', '0:0:0:0:0:0:0:1', '1A130C54372D01EDAD3D5BB760CEC4BE', '20191018144215', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12501', 'test', '0:0:0:0:0:0:0:1', '1A130C54372D01EDAD3D5BB760CEC4BE', '20191018144352', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12502', 'admin', '0:0:0:0:0:0:0:1', '9B0197E0DC1D3029DBABB9AB74342916', '20191018144914', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12503', 'admin', '0:0:0:0:0:0:0:1', '3A2542D11970CBBD876C806C9ADD4418', '20191021093351', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12504', 'admin', '0:0:0:0:0:0:0:1', '007CB14390064EEFD82B2F215EF4974C', '20191021095814', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12505', 'admin', '0:0:0:0:0:0:0:1', 'E01E07FB284F2707D8703C24FA5F000D', '20191021100804', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12506', 'admin', '0:0:0:0:0:0:0:1', 'E4D9432CA5499F5E4CF6CB377B0E719F', '20191021103847', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12507', 'admin', '0:0:0:0:0:0:0:1', '5F7D7281E8B616199F8DF3FACB3474DF', '20191021104211', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12508', 'admin', '0:0:0:0:0:0:0:1', '5ABD57360F1B46A2BC3CC21E981268C6', '20191021104753', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12509', 'admin', '0:0:0:0:0:0:0:1', '9A4F37BD547C0007BC82C24BD0AF0174', '20191021113615', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12510', 'admin', '0:0:0:0:0:0:0:1', '7D56C284204009162A83A48EE70364BE', '20191021114138', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12511', 'admin', '0:0:0:0:0:0:0:1', '96B2333D1231A7E0E48CBD83D9ABA0A4', '20191021142753', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12512', 'admin', '0:0:0:0:0:0:0:1', 'E69249E7A2F1E5E8BC1B52349C0FD6B4', '20191021144609', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12513', 'admin', '0:0:0:0:0:0:0:1', 'A71585901A9316E5FB1D4EB4AC5AD6C5', '20191021150447', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12514', 'admin', '0:0:0:0:0:0:0:1', 'C09E8C3682B0EE2D5E3C6AA82506C307', '20191021151128', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12515', 'admin', '0:0:0:0:0:0:0:1', '5A13C4CD151BC111AD5B472F6FA60777', '20191021153150', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12516', 'admin', '0:0:0:0:0:0:0:1', '48144BA02E9DA8BA9C0120D1CCE3DF52', '20191021153524', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12517', 'admin', '0:0:0:0:0:0:0:1', '48144BA02E9DA8BA9C0120D1CCE3DF52', '20191021153916', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12518', 'admin', '0:0:0:0:0:0:0:1', 'BF9B5C831309AF8F07D9E3D8111BA1D5', '20191021153922', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12519', 'admin', '0:0:0:0:0:0:0:1', 'A84C9C0CB027EF14632B121C74B7F3D4', '20191021155446', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12520', 'admin', '0:0:0:0:0:0:0:1', 'C66AFA7E8278575C702724F127F70CBB', '20191021162625', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12521', 'admin', '0:0:0:0:0:0:0:1', 'C9C2264334B3BBC47F131E16FCBB9EC9', '20191021164421', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12522', 'admin', '0:0:0:0:0:0:0:1', '61C78F135D0A01632F1E2F4B6B3D8189', '20191021171819', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12523', 'admin', '0:0:0:0:0:0:0:1', '1A197670C5353860C9FC06A19DFDF941', '20191021181642', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12524', 'admin', '0:0:0:0:0:0:0:1', '0C84355AD22B4C14CAE7F43386EBBB6B', '20191021205404', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12525', 'admin', '0:0:0:0:0:0:0:1', '226964CF33774D510847AF542C57BAA2', '20191022114316', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12526', 'admin', '0:0:0:0:0:0:0:1', 'ED4CD47CAEA186EB5AA31B4654905710', '20191022131234', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12527', 'admin', '0:0:0:0:0:0:0:1', 'ED4CD47CAEA186EB5AA31B4654905710', '20191022132429', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12528', 'admin', '0:0:0:0:0:0:0:1', '9423042CCF709E2313A91377DEBD06FC', '20191022132435', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12529', 'admin', '0:0:0:0:0:0:0:1', 'EBFE4B3F61D4696EF4DF4B74C36AD777', '20191022134058', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12530', 'admin', '0:0:0:0:0:0:0:1', 'B9E9B2F2D48DACDDD75EB644B5437517', '20191022142419', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12531', 'admin', '0:0:0:0:0:0:0:1', 'B9E9B2F2D48DACDDD75EB644B5437517', '20191022175937', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12532', 'admin', '0:0:0:0:0:0:0:1', 'D7644B5D177EDD28B80D8C1FC135A455', '20191023093533', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12533', 'admin', '0:0:0:0:0:0:0:1', 'D7644B5D177EDD28B80D8C1FC135A455', '20191023094702', '1', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12534', 'admin', '0:0:0:0:0:0:0:1', '6422DD7EED178813585A33E8F19C80A3', '20191023094709', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12535', 'admin', '0:0:0:0:0:0:0:1', 'D8C08F3AEEC33D45FA455B2F5019E309', '20191023101501', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12536', 'admin', '0:0:0:0:0:0:0:1', 'D60ABD246CCF1413049F2C2733683229', '20191023104702', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12537', 'admin', '0:0:0:0:0:0:0:1', 'D60ABD246CCF1413049F2C2733683229', '20191023111758', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12538', 'admin', '0:0:0:0:0:0:0:1', '0E74B07E0A7C371F8BBACF12B8D53FD3', '20191024140034', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12539', 'admin', '0:0:0:0:0:0:0:1', 'E0A25D5B0E830EC5596839FD71967859', '20191024163938', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12540', 'admin', '0:0:0:0:0:0:0:1', 'C8AFD477EF40B3D5E732DD468942003E', '20191024165640', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12541', 'admin', '0:0:0:0:0:0:0:1', 'BAC2424A586389BA98C42978E31696A3', '20191025165245', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12542', 'admin', '0:0:0:0:0:0:0:1', '323AE579E00598DBC9E3F037D1A7ECE7', '20191025173142', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12543', 'admin', '0:0:0:0:0:0:0:1', '6FB14B681FA12A53C5B105FB10D11FCD', '20191028094334', '0', '', '0', '', '', '');
INSERT INTO `sys_login_audit` VALUES ('12544', 'admin', '0:0:0:0:0:0:0:1', 'F96AFF46E7794954BDD18BB2285C5997', '20191028105853', '0', '', '0', '', '', '');

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
  `filler1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `filler2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `filler3` varchar(500) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3310 DEFAULT CHARSET=utf8 COMMENT='操作记录表';

-- ----------------------------
-- Records of sys_operate_audit
-- ----------------------------
INSERT INTO `sys_operate_audit` VALUES ('3308', 'admin', '0:0:0:0:0:0:0:1', 'F96AFF46E7794954BDD18BB2285C5997', '查询定时任务信息', '/console/job/query', '{length=10, page=1}', '20191028110017', '{\"code\":\"200\",\"data\":[{\"day\":\"*\",\"hour\":\"*\",\"isDel\":\"1\",\"jobDesc\":\"测试一下\",\"jobId\":\"test\",\"jobName\":\"test\",\"minute\":\"*\",\"modifier\":\"admin\",\"modifyTime\":\"20191028104144\",\"month\":\"*\",\"second\":\"0/25\",\"week\":\"*\",\"year\":\"*\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191028110017', '', '', '');
INSERT INTO `sys_operate_audit` VALUES ('3309', 'admin', '0:0:0:0:0:0:0:1', 'F96AFF46E7794954BDD18BB2285C5997', '查询操作日志', '/console/operateAudit/query', '{requestTime=20191028000000,20191028235959, requestTimeList=20191028,20191028, length=10, page=1}', '20191028110020', '{\"code\":\"200\",\"data\":[{\"description\":\"查询定时任务信息\",\"filler1\":\"\",\"filler2\":\"\",\"filler3\":\"\",\"ip\":\"0:0:0:0:0:0:0:1\",\"requestParam\":\"{length=10, page=1}\",\"requestTime\":\"20191028110017\",\"requestUrl\":\"/console/job/query\",\"result\":\"{\\\"code\\\":\\\"200\\\",\\\"data\\\":[{\\\"day\\\":\\\"*\\\",\\\"hour\\\":\\\"*\\\",\\\"isDel\\\":\\\"1\\\",\\\"jobDesc\\\":\\\"测试一下\\\",\\\"jobId\\\":\\\"test\\\",\\\"jobName\\\":\\\"test\\\",\\\"minute\\\":\\\"*\\\",\\\"modifier\\\":\\\"admin\\\",\\\"modifyTime\\\":\\\"20191028104144\\\",\\\"month\\\":\\\"*\\\",\\\"second\\\":\\\"0/25\\\",\\\"week\\\":\\\"*\\\",\\\"year\\\":\\\"*\\\"}],\\\"message\\\":\\\"success\\\",\\\"success\\\":true,\\\"total\\\":1}\",\"returnTime\":\"20191028110017\",\"sessionId\":\"F96AFF46E7794954BDD18BB2285C5997\",\"sid\":3308,\"userId\":\"admin\"}],\"message\":\"success\",\"success\":true,\"total\":1}', '20191028110020', '', '', '');

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
INSERT INTO `sys_param` VALUES ('0001', '12', '12', '12211244234', '0', null, 'admin', '20191028102112', null, null, null, null);

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
INSERT INTO `sys_resource` VALUES ('0', '首页', '/dashboard', 'root', '0', '0', '1', null, null, 'el-icon-lx-home', null, null, null);
INSERT INTO `sys_resource` VALUES ('1', '用户管理', '1', 'root', '0', '1', '1', null, null, 'el-icon-lx-cascades', null, null, null);
INSERT INTO `sys_resource` VALUES ('11', '用户信息管理', '/user', '1', '1', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('12', '角色信息管理', '/role', '1', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('13', '菜单管理', '/resource', '1', '1', '3', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('2', '系统管理', '2', 'root', '0', '2', '1', null, null, 'el-icon-lx-cascades', null, null, null);
INSERT INTO `sys_resource` VALUES ('21', '系统参数', '/param', '2', '1', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('22', '数据字典', '/dict', '2', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('23', '定时任务管理', '/job', '2', '1', '3', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('3', '日志管理', '3', 'root', '0', '3', '1', null, null, 'el-icon-lx-cascades', null, null, null);
INSERT INTO `sys_resource` VALUES ('31', '登录登出日志', '/loginAudit', '3', '1', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('32', '操作日志', '/oprateAudit', '3', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('33', '定时任务日志', '/jobLog', '3', '1', '3', '1', null, null, null, null, null, null);

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
INSERT INTO `sys_role` VALUES ('2414', '141124', '41414142', null, 'admin', '20191028101743', null, null, null);
INSERT INTO `sys_role` VALUES ('admin', '系统管理员', '1241', null, 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role` VALUES ('test', '测试', '测试', null, 'admin', '20191021150553', null, null, null);
INSERT INTO `sys_role` VALUES ('test2', '12414', 'test231', null, 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role` VALUES ('test3', 'test3', 'test3', null, 'admin', '20191025165918', null, null, null);

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
INSERT INTO `sys_role_resource` VALUES ('2414', '1', 'admin', '20191028101743', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('2414', '11', 'admin', '20191028101743', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('2414', '12', 'admin', '20191028101743', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('2414', '13', 'admin', '20191028101743', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '0', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '1', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '11', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '12', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '13', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '2', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '21', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '22', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '23', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '3', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '31', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '32', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('admin', '33', 'admin', '20191021163507', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test', '1', 'admin', '20191021150553', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test', '11', 'admin', '20191021150553', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test', '12', 'admin', '20191021150553', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test', '13', 'admin', '20191021150553', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '0', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '1', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '11', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '12', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '13', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '2', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '21', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '22', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '23', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '3', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '31', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '32', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test2', '33', 'admin', '20191024145856', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test3', '0', 'admin', '20191025165918', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test3', '1', 'admin', '20191025165918', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test3', '11', 'admin', '20191025165918', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test3', '12', 'admin', '20191025165918', null, null, null);
INSERT INTO `sys_role_resource` VALUES ('test3', '13', 'admin', '20191025165918', null, null, null);

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
