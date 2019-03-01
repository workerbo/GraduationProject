/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : guns

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-02-22 13:10:40
*/

DROP DATABASE IF EXISTS `guns`;
CREATE DATABASE IF NOT EXISTS  `guns` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE  `guns`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `sys_dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `sys_dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `sys_dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `code` varchar(255) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('50', '0', '0', '性别', null, 'sys_sex');
INSERT INTO `sys_dict` VALUES ('51', '1', '50', '男', null, '1');
INSERT INTO `sys_dict` VALUES ('52', '2', '50', '女', null, '2');
INSERT INTO `sys_dict` VALUES ('53', '0', '0', '状态', null, 'sys_state');
INSERT INTO `sys_dict` VALUES ('54', '1', '53', '启用', null, '1');
INSERT INTO `sys_dict` VALUES ('55', '2', '53', '禁用', null, '2');
INSERT INTO `sys_dict` VALUES ('56', '0', '0', '账号状态', null, 'account_state');
INSERT INTO `sys_dict` VALUES ('57', '1', '56', '启用', null, '1');
INSERT INTO `sys_dict` VALUES ('58', '2', '56', '冻结', null, '2');
INSERT INTO `sys_dict` VALUES ('59', '3', '56', '已删除', null, '3');



-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('105', 'system', '0', '[0],', '系统管理', 'fa-user', '#', '4', '1', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('106', 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('107', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('108', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('109', 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('110', 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('111', 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('112', 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('113', 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('114', 'role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('115', 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('116', 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('117', 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('118', 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('119', 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('120', 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('121', 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('122', 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('128', 'log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('130', 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('131', 'dept', 'system', '[0],[system],', '部门管理', null, '/dept', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('132', 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('133', 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('134', 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('135', 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('136', 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('137', 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('138', 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('139', 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('140', 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('141', 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('142', 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('143', 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('144', 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('145', 'hello', '0', '[0],', '通知', 'fa-rocket', '/notice/hello', '1', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('148', 'code', '0', '[0],', '代码生成', 'fa-code', '/code', '3', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('149', 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/swagger-ui.html', '2', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('150', 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('151', 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('152', 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('153', 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('154', 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('155', 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('156', 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('157', 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('158', 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('159', 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('160', 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('161', 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('162', 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('163', 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('164', 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('165', 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('166', 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('167', 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('6', '你好', '10', '欢迎使用客户关系管理系统', '2019-01-11 08:53:20', '1');
INSERT INTO `sys_notice` VALUES ('8', '你好', null, '世界！', '2019-02-10 19:28:57', '1');


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
   -- , constraint `role_dept_fk` foreign key(`deptid`) references `sys_dept`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('5', '2', '1', '一般管理员', '26', 'saledept', null);

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
  -- .constraint `relation_menu_fk` foreign key(`menuid`) references `sys_menu`(`id`),
  -- constraint `relation_role_fk` foreign key(`roleid`) references `sys_role`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3792 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('3377', '105', '5');
INSERT INTO `sys_relation` VALUES ('3378', '106', '5');
INSERT INTO `sys_relation` VALUES ('3379', '107', '5');
INSERT INTO `sys_relation` VALUES ('3380', '108', '5');
INSERT INTO `sys_relation` VALUES ('3381', '109', '5');
INSERT INTO `sys_relation` VALUES ('3382', '110', '5');
INSERT INTO `sys_relation` VALUES ('3383', '111', '5');
INSERT INTO `sys_relation` VALUES ('3384', '112', '5');
INSERT INTO `sys_relation` VALUES ('3385', '113', '5');
INSERT INTO `sys_relation` VALUES ('3386', '114', '5');
INSERT INTO `sys_relation` VALUES ('3387', '115', '5');
INSERT INTO `sys_relation` VALUES ('3388', '116', '5');
INSERT INTO `sys_relation` VALUES ('3389', '117', '5');
INSERT INTO `sys_relation` VALUES ('3390', '118', '5');
INSERT INTO `sys_relation` VALUES ('3391', '119', '5');
INSERT INTO `sys_relation` VALUES ('3392', '120', '5');
INSERT INTO `sys_relation` VALUES ('3393', '121', '5');
INSERT INTO `sys_relation` VALUES ('3394', '122', '5');
INSERT INTO `sys_relation` VALUES ('3395', '150', '5');
INSERT INTO `sys_relation` VALUES ('3396', '151', '5');
INSERT INTO `sys_relation` VALUES ('3737', '105', '1');
INSERT INTO `sys_relation` VALUES ('3738', '106', '1');
INSERT INTO `sys_relation` VALUES ('3739', '107', '1');
INSERT INTO `sys_relation` VALUES ('3740', '108', '1');
INSERT INTO `sys_relation` VALUES ('3741', '109', '1');
INSERT INTO `sys_relation` VALUES ('3742', '110', '1');
INSERT INTO `sys_relation` VALUES ('3743', '111', '1');
INSERT INTO `sys_relation` VALUES ('3744', '112', '1');
INSERT INTO `sys_relation` VALUES ('3745', '113', '1');
INSERT INTO `sys_relation` VALUES ('3746', '165', '1');
INSERT INTO `sys_relation` VALUES ('3747', '166', '1');
INSERT INTO `sys_relation` VALUES ('3748', '167', '1');
INSERT INTO `sys_relation` VALUES ('3749', '114', '1');
INSERT INTO `sys_relation` VALUES ('3750', '115', '1');
INSERT INTO `sys_relation` VALUES ('3751', '116', '1');
INSERT INTO `sys_relation` VALUES ('3752', '117', '1');
INSERT INTO `sys_relation` VALUES ('3753', '118', '1');
INSERT INTO `sys_relation` VALUES ('3754', '162', '1');
INSERT INTO `sys_relation` VALUES ('3755', '163', '1');
INSERT INTO `sys_relation` VALUES ('3756', '164', '1');
INSERT INTO `sys_relation` VALUES ('3757', '119', '1');
INSERT INTO `sys_relation` VALUES ('3758', '120', '1');
INSERT INTO `sys_relation` VALUES ('3759', '121', '1');
INSERT INTO `sys_relation` VALUES ('3760', '122', '1');
INSERT INTO `sys_relation` VALUES ('3761', '150', '1');
INSERT INTO `sys_relation` VALUES ('3762', '151', '1');
INSERT INTO `sys_relation` VALUES ('3763', '128', '1');
INSERT INTO `sys_relation` VALUES ('3764', '134', '1');
INSERT INTO `sys_relation` VALUES ('3765', '158', '1');
INSERT INTO `sys_relation` VALUES ('3766', '159', '1');
INSERT INTO `sys_relation` VALUES ('3767', '130', '1');
INSERT INTO `sys_relation` VALUES ('3768', '131', '1');
INSERT INTO `sys_relation` VALUES ('3769', '135', '1');
INSERT INTO `sys_relation` VALUES ('3770', '136', '1');
INSERT INTO `sys_relation` VALUES ('3771', '137', '1');
INSERT INTO `sys_relation` VALUES ('3772', '152', '1');
INSERT INTO `sys_relation` VALUES ('3773', '153', '1');
INSERT INTO `sys_relation` VALUES ('3774', '154', '1');
INSERT INTO `sys_relation` VALUES ('3775', '132', '1');
INSERT INTO `sys_relation` VALUES ('3776', '138', '1');
INSERT INTO `sys_relation` VALUES ('3777', '139', '1');
INSERT INTO `sys_relation` VALUES ('3778', '140', '1');
INSERT INTO `sys_relation` VALUES ('3779', '155', '1');
INSERT INTO `sys_relation` VALUES ('3780', '156', '1');
INSERT INTO `sys_relation` VALUES ('3781', '157', '1');
INSERT INTO `sys_relation` VALUES ('3782', '133', '1');
INSERT INTO `sys_relation` VALUES ('3783', '160', '1');
INSERT INTO `sys_relation` VALUES ('3784', '161', '1');
INSERT INTO `sys_relation` VALUES ('3785', '141', '1');
INSERT INTO `sys_relation` VALUES ('3786', '142', '1');
INSERT INTO `sys_relation` VALUES ('3787', '143', '1');
INSERT INTO `sys_relation` VALUES ('3788', '144', '1');
INSERT INTO `sys_relation` VALUES ('3789', '145', '1');
INSERT INTO `sys_relation` VALUES ('3790', '148', '1');
INSERT INTO `sys_relation` VALUES ('3791', '149', '1');


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` char(1) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
  -- ,constraint `user_dept_fk` foreign key(`deptid`) references `sys_dept`(`id`)
  

) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'girl.gif', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', '何波', '2017-05-05 00:00:00', '2', 'sn93@qq.com', '18200000000', '1', '27', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `sys_user` VALUES ('44', null, 'test', '45abb7879f6a8268f1ef600e6038ac73', 'ssts3', 'test', '2017-05-01 00:00:00', '1', 'abc@123.com', '', '5', '26', '3', '2017-05-16 20:33:37', null);
INSERT INTO `sys_user` VALUES ('45', null, 'boss', '71887a5ad666a18f709e1d4e693d5a35', '1f7bf', '老板', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:02', null);
INSERT INTO `sys_user` VALUES ('46', null, 'manager', 'b53cac62e7175637d4beb3b16b2f7915', 'j3cs9', '经理', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:24', null);

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
  -- ,constraint `operation_user_fk` foreign key(`userid`) references `sys_user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=554 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
  -- ,constraint `loginlog_user_fk` foreign key(`userid`) references `sys_user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for cst_customer
-- ----------------------------
DROP TABLE IF EXISTS `cst_customer`;
CREATE TABLE `cst_customer` (
  `cust_no` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cust_name` varchar(100) NOT NULL COMMENT '客户名称',
  `cust_region` varchar(50) DEFAULT NULL COMMENT '地区',
  `cust_manager_id` int(11) DEFAULT NULL COMMENT '客户经理编号',
  `cust_level` int(11) DEFAULT NULL COMMENT '客户等级',
  `cust_satisfy` int(11) DEFAULT 3 COMMENT '满意度（1-5），默认为3',
  `cust_credit` int(11) DEFAULT 3 COMMENT '信用度（1-5），默认为3',
  `cust_addr` varchar(300) DEFAULT NULL COMMENT '地址',
  `cust_zip` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码',
  `cust_tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `cust_website` varchar(50) DEFAULT NULL COMMENT '网址',
  `cust_licence_no` varchar(50) DEFAULT NULL COMMENT '营业执照注册号',
  `cust_chieftain` varchar(50) DEFAULT NULL COMMENT '法人',
  `cust_bankroll` bigint(20) DEFAULT NULL COMMENT '注册资金',
  `cust_turnover` bigint(20) DEFAULT NULL COMMENT '营业额',
  `cust_status` char(1) DEFAULT NULL COMMENT '客户状态：1--正常；2--流失；3--删除。',
  PRIMARY KEY (`cust_no`),
  UNIQUE KEY `cust_name_UNIQUE` (`cust_name`)
  -- ,CONSTRAINT `customer_user_fk` FOREIGN KEY (`cust_manager_id`) REFERENCES `guns`.`sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户信息表';




DROP TABLE IF EXISTS `biz_order`;
CREATE TABLE `biz_order` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
`place` varchar(255) DEFAULT NULL COMMENT '下单地点',
`create_time` datetime DEFAULT NULL COMMENT '下单时间',
`user_name` varchar(255) DEFAULT NULL COMMENT '下单用户名称',
`user_phone` varchar(255) DEFAULT NULL COMMENT '下单用户电话',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';
 

DROP TABLE IF EXISTS `guns`.`sal_chance`;
CREATE TABLE `guns`.`sal_chance` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chc_source` VARCHAR(45) NOT NULL COMMENT '机会来源',
  `chc_cust_name` VARCHAR(45) NULL COMMENT '客户名称',
  `chc_title` VARCHAR(45) NOT NULL COMMENT '概要',
  `chc_rate` INT NOT NULL COMMENT '成功机率',
  `chc_linkman` VARCHAR(45) NULL COMMENT '联系人',
  `chc_tel` VARCHAR(45) NULL COMMENT '联系电话',
  `chc_create_id` int(65) NOT NULL COMMENT '创建人编号',
  `chc_create_date` DATETIME NULL COMMENT '创建时间',
  `chc_due_id` BIGINT NULL COMMENT '指派的客户经理编号',
  `chc_due_date` DATETIME NULL COMMENT '指派时间',
  `chc_status` CHAR(1) NULL COMMENT '状态：1--未指派；2--已指派3--开发成功；4--终止开发(开发失败)。',
  PRIMARY KEY (`id`))
COMMENT = '机会销售表';

DROP TABLE IF EXISTS `guns`.`cst_activity` ;
CREATE TABLE `guns`.`cst_activity` (
`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键' ,
 `atv_cust_no` INT(65) NULL COMMENT '客户编号' ,
 `atv_date` DATETIME NOT NULL COMMENT '交往日期' ,
 `atv_place` VARCHAR(45) NOT NULL COMMENT '交往地点' ,
  `atv_title` VARCHAR(200) NULL COMMENT '交往概要' ,
  `atv_desc` VARCHAR(2000) NULL DEFAULT NULL COMMENT '详细信息' , 
 PRIMARY KEY (`id`))COMMENT = '交往记录表';
 
DROP TABLE IF EXISTS `guns`.`cst_linkman` ;
CREATE TABLE `guns`.`cst_linkman` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '联系人编号（主键自动增长）',
  `lkm_cust_no` INT(65) NOT NULL COMMENT '客户编号',
  `lkm_name` VARCHAR(45) NULL COMMENT '联系人名称',
  `lkm_sex` VARCHAR(5) NULL COMMENT '性别',
  `lkm_postion` VARCHAR(45) NULL COMMENT '职位',
  `lkm_tel` VARCHAR(45) NOT NULL COMMENT '办公室电话',
  `lkm_mobile` VARCHAR(45) NULL COMMENT '手机',
  `lkm_memo` VARCHAR(444) NULL COMMENT '备注',
  PRIMARY KEY (`id`))
COMMENT = '客户联系人表';




DROP TABLE IF EXISTS `guns`.`cst_lost` ;
CREATE TABLE `guns`.`cst_lost` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT  '编号（主键自动增长1）',
  `lst_cust_no` INT(65) NOT NULL COMMENT '客户编号',
  `lst_cust_manager_id` INT(65) NOT NULL COMMENT '客户经理编号',
  `lst_last_order_date` DATETIME NULL COMMENT '上次下单时间',
  `lst_lost_date` DATETIME NULL COMMENT '确认流失时间',
  `lst_delay` VARCHAR(4000) NULL COMMENT '暂缓措施',
  `lst_reason` VARCHAR(2000) NULL COMMENT '流失原因',
  `lst_status` CHAR(1) NOT NULL COMMENT '流失状态 1-警告，2-暂缓流失，3-已流失',
  PRIMARY KEY (`id`))
COMMENT = '客户流失表';



DROP TABLE IF EXISTS `guns`.` cst_customerservice` ;
CREATE TABLE `guns`.`cst_customerservice` (
  `id` INT NOT NULL  AUTO_INCREMENT COMMENT '服务编号',
  `svr_type` VARCHAR(45) NOT NULL COMMENT '服务类型',
  `svr_title` VARCHAR(450) NOT NULL COMMENT '服务概要',
  `svr_cust_no` INT(65) NULL COMMENT '客户编号',
  `svr_status` VARCHAR(45) NOT NULL COMMENT '服务状态',
  `svr_request` VARCHAR(4000) NOT NULL COMMENT '服务请求',
  `svr_create_id` VARCHAR(45) NOT NULL COMMENT '创建人编号',
  `svr_create_date` DATETIME NULL COMMENT '创建日期',
  `svr_due_id` INT(65) NULL COMMENT '分配给某人的编号',
  `svr_due_date` DATETIME NULL COMMENT '分配时间',
  `svr_deal` VARCHAR(45) NULL COMMENT '服务处理',
  `svr_deal_date` DATETIME NULL COMMENT '处理日期',
  `svr_result` VARCHAR(450) NULL COMMENT '处理结果',
  `svr_satisfy` INT NULL COMMENT '满意度',
  PRIMARY KEY (`id`))
COMMENT = '客户服务表';sal_plan


DROP TABLE IF EXISTS `guns`.`sal_plan`;
CREATE TABLE `guns`.`sal_plan` (
  `id` INT NOT  NULL AUTO_INCREMENT COMMENT '计划编号',
  `pla_date` DATETIME NOT NULL COMMENT '日期',
  `pla_todo` VARCHAR(655) NOT NULL COMMENT '计划项',
  `pla_result` VARCHAR(495) NULL COMMENT '执行结果',
  PRIMARY KEY (`id`))
COMMENT = '客户开发计划表';



DROP TABLE IF EXISTS `guns`.`orders`;
CREATE TABLE `guns`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '订单编号（自动增长1，1）',
  `odr_customer_no` INT(67) NOT NULL COMMENT '订单客户公司编号',
  `odr_date` DATETIME NOT NULL COMMENT '订单日期',
  `odr_addr` VARCHAR(450) NULL COMMENT '地址',
  `odr_status` CHAR(1) NULL COMMENT '状态(5:已发货  6:已回款)',
  PRIMARY KEY (`id`))
COMMENT = '订单表';

DROP TABLE IF EXISTS `guns`.`orders_line`;
CREATE TABLE `guns`.`orders_line` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '明细编号',
  `odd_order_id` BIGINT NOT NULL COMMENT '订单编号',
  `odd_prod_id` BIGINT NOT NULL COMMENT '商品编号',
  `odd_count` INT NULL COMMENT '数量',
  `odd_unit` VARCHAR(45) NULL COMMENT '单位',
  PRIMARY KEY (`id`))
COMMENT = '订单明细表';

DROP TABLE IF EXISTS `guns`.`product`;
CREATE TABLE `guns`.`product` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '商品编号（自动增长1，1）',
    `prod_name` VARCHAR(45) NOT NULL COMMENT '商品名称',
    `prod_type` VARCHAR(45) NOT NULL,
    `prod_batch` VARCHAR(100) NULL COMMENT '批号',
    `prod_unit` VARCHAR(45) NULL COMMENT '单位',
    `prod_price` INT NULL COMMENT '价格',
    `prod_memo` VARCHAR(450) NULL COMMENT '备注',
    PRIMARY KEY (`id`)
)  COMMENT='商品表';

DROP TABLE IF EXISTS `guns`.`storage`;
CREATE TABLE `guns`.`storage` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '仓库编号自动增长1，1',
  `stk_prod_id` INT NOT NULL COMMENT '商品编号',
  `stk_warehouse` VARCHAR(45) NOT NULL COMMENT '仓库名称',
  `stk_ware` VARCHAR(45) NOT NULL COMMENT '货位',
  `stk_count` INT NOT NULL COMMENT '数量',
  `stk_memo` VARCHAR(450) NULL COMMENT '备注',
  PRIMARY KEY (`id`))
COMMENT = '仓库表';

SET FOREIGN_KEY_CHECKS = 1;