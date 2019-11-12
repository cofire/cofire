/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : cofire

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-12 13:35:40
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
INSERT INTO `sys_dict` VALUES ('0001', '是否可用', '1', '是', '20191029170959', 'admin', '', '', '', '');
INSERT INTO `sys_dict` VALUES ('0002', '登录登出类型', '0', '登录', '20191022132511', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0002', '登录登出类型', '1', '登出', '20191022132536', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0003', '是否可删除', '0', '否', '20191024164638', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0003', '是否可删除', '1', '是', '20191024165352', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0004', '是否成功', '0', '否', '20191024171418', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0004', '是否成功', '1', '是', '20191024171440', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0005', '来源类型', '0', 'PC端', '20191024173017', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0006', '是否叶节点', '0', '否', '20191029170212', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0006', '是否叶节点', '1', '是', '20191029170231', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'add', '新增', '20191112132210', 'admin', '', '', '', '');
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'delete', '删除', '20191112132210', 'admin', '', '', '', '');
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'export', '导出', '20191112132210', 'admin', '', '', '', '');
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'query', '查询', '20191112132210', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'update', '修改', '20191112132408', 'admin', null, null, null, null);
INSERT INTO `sys_dict` VALUES ('0007', '操作类型', 'upload', '上传', '20191112132210', 'admin', '', '', '', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=12597 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_audit
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=4280 DEFAULT CHARSET=utf8 COMMENT='操作记录表';

-- ----------------------------
-- Records of sys_operate_audit
-- ----------------------------

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
