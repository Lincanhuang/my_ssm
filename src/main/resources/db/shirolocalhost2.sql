-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.11-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 shiro 的数据库结构
DROP DATABASE IF EXISTS `shiro`;
CREATE DATABASE IF NOT EXISTS `shiro` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `shiro`;

-- 导出  表 shiro.sys_resources 结构
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) unsigned DEFAULT 0,
  `sort` int(10) unsigned DEFAULT NULL,
  `external` tinyint(1) unsigned DEFAULT NULL COMMENT '是否外部链接',
  `available` tinyint(1) unsigned DEFAULT 0,
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '添加时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_sys_resource_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 正在导出表  shiro.sys_resources 的数据：~21 rows (大约)
DELETE FROM `sys_resources`;
/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `name`, `type`, `url`, `permission`, `parent_id`, `sort`, `external`, `available`, `icon`, `create_time`, `update_time`) VALUES
	(1, '用户管理', 'menu', NULL, NULL, 0, 1, 0, 1, 'fa fa-users', '2018-05-16 17:02:54', '2018-05-16 17:02:54'),
	(2, '用户列表', 'menu', '/users', 'users', 1, 1, 0, 1, NULL, '2017-12-22 13:56:15', '2018-05-16 14:44:20'),
	(3, '新增用户', 'button', NULL, 'user:add', 2, 2, 0, 1, NULL, '2018-05-16 14:07:43', '2018-05-16 14:16:23'),
	(4, '批量删除用户', 'button', NULL, 'user:batchDelete', 2, 3, 0, 1, NULL, '2018-05-16 14:12:23', '2018-05-16 14:16:35'),
	(5, '编辑用户', 'button', NULL, 'user:edit', 2, 4, 0, 1, NULL, '2018-05-16 14:12:50', '2018-05-16 14:16:43'),
	(6, '删除用户', 'button', NULL, 'user:delete', 2, 5, 0, 1, NULL, '2018-05-16 14:13:09', '2018-05-16 14:51:50'),
	(7, '分配用户角色', 'button', NULL, 'user:allotRole', 2, 6, 0, 1, NULL, '2018-05-16 14:15:28', '2018-05-16 14:16:54'),
	(8, '系统配置', 'menu', NULL, NULL, 0, 2, 0, 1, 'fa fa-cogs', '2017-12-20 16:40:06', '2017-12-20 16:40:08'),
	(9, '资源管理', 'menu', '/resources', 'resources', 8, 1, 0, 1, NULL, '2017-12-22 15:31:05', '2017-12-22 15:31:05'),
	(10, '新增资源', 'button', NULL, 'resource:add', 9, 2, 0, 1, NULL, '2018-05-16 14:07:43', '2018-05-16 14:16:23'),
	(11, '批量删除资源', 'button', NULL, 'resource:batchDelete', 9, 3, 0, 1, NULL, '2018-05-16 14:12:23', '2018-05-16 14:16:35'),
	(12, '编辑资源', 'button', NULL, 'resource:edit', 9, 4, 0, 1, NULL, '2018-05-16 14:12:50', '2018-05-16 14:16:43'),
	(13, '删除资源', 'button', NULL, 'resource:delete', 9, 5, 0, 1, NULL, '2018-05-16 14:13:09', '2018-05-16 14:51:50'),
	(14, '角色管理', 'menu', '/roles', 'roles', 8, 2, 0, 1, '', '2017-12-22 15:31:27', '2018-05-17 12:51:06'),
	(15, '新增角色', 'button', NULL, 'role:add', 14, 2, 0, 1, NULL, '2018-05-16 14:07:43', '2018-05-16 14:16:23'),
	(16, '批量删除角色', 'button', NULL, 'role:batchDelete', 14, 3, 0, 1, NULL, '2018-05-16 14:12:23', '2018-05-16 14:16:35'),
	(17, '编辑角色', 'button', NULL, 'role:edit', 14, 4, 0, 1, NULL, '2018-05-16 14:12:50', '2018-05-16 14:16:43'),
	(18, '删除角色', 'button', NULL, 'role:delete', 14, 5, 0, 1, NULL, '2018-05-16 14:13:09', '2018-05-16 14:51:50'),
	(19, '分配角色资源', 'button', NULL, 'role:allotResource', 14, 6, 0, 1, NULL, '2018-05-17 10:04:21', '2018-05-17 10:04:21'),
	(20, '数据监控', 'menu', '', '', NULL, 3, 0, 1, 'fa fa-heartbeat', '2018-05-17 12:38:20', '2018-05-17 12:53:06'),
	(21, 'Druid监控', 'menu', '/druid/index.html', 'druid', 20, 1, 1, 1, '', '2018-05-17 12:46:37', '2018-05-17 12:52:33');
/*!40000 ALTER TABLE `sys_resources` ENABLE KEYS */;

-- 导出  表 shiro.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT 0,
  `create_time` datetime DEFAULT current_timestamp() COMMENT '添加时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 正在导出表  shiro.sys_role 的数据：~2 rows (大约)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `name`, `description`, `available`, `create_time`, `update_time`) VALUES
	(1, 'role:root', '超级管理员', 1, '2017-12-20 16:40:24', '2017-12-20 16:40:26'),
	(2, 'role:admin', '管理员', 1, '2017-12-22 13:56:39', '2017-12-22 13:56:39');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 shiro.sys_role_resources 结构
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE IF NOT EXISTS `sys_role_resources` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `resources_id` bigint(20) unsigned NOT NULL,
  `create_time` datetime DEFAULT current_timestamp() COMMENT '添加时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 正在导出表  shiro.sys_role_resources 的数据：~31 rows (大约)
DELETE FROM `sys_role_resources`;
/*!40000 ALTER TABLE `sys_role_resources` DISABLE KEYS */;
INSERT INTO `sys_role_resources` (`id`, `role_id`, `resources_id`, `create_time`, `update_time`) VALUES
	(27, 1, 20, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(28, 1, 21, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(29, 1, 1, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(30, 1, 2, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(31, 1, 3, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(32, 1, 4, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(33, 1, 5, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(34, 1, 6, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(35, 1, 7, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(36, 1, 8, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(37, 1, 9, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(38, 1, 10, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(39, 1, 11, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(40, 1, 12, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(41, 1, 13, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(42, 1, 14, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(43, 1, 15, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(44, 1, 16, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(45, 1, 17, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(46, 1, 18, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(47, 1, 19, '2018-05-17 12:52:41', '2018-05-17 12:52:41'),
	(48, 2, 20, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(49, 2, 21, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(50, 2, 2, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(51, 2, 3, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(52, 2, 8, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(53, 2, 9, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(54, 2, 10, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(55, 2, 14, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(56, 2, 15, '2018-05-17 12:52:51', '2018-05-17 12:52:51'),
	(57, 2, 1, '2018-05-17 12:52:51', '2018-05-17 12:52:51');
/*!40000 ALTER TABLE `sys_role_resources` ENABLE KEYS */;

-- 导出  表 shiro.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `nickname` varchar(30) DEFAULT '' COMMENT '昵称',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` tinyint(2) unsigned DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `user_type` enum('ROOT','ADMIN','USER') DEFAULT 'ADMIN' COMMENT '超级管理员、管理员、普通用户',
  `reg_ip` varchar(30) DEFAULT NULL COMMENT '注册IP',
  `last_login_ip` varchar(30) DEFAULT NULL COMMENT '最近登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  `login_count` int(10) unsigned DEFAULT 0 COMMENT '登录次数',
  `remark` varchar(100) DEFAULT NULL COMMENT '用户备注',
  `status` int(1) unsigned DEFAULT NULL COMMENT '用户状态',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '注册时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  shiro.sys_user 的数据：2 rows
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `mobile`, `email`, `qq`, `birthday`, `gender`, `avatar`, `user_type`, `reg_ip`, `last_login_ip`, `last_login_time`, `login_count`, `remark`, `status`, `create_time`, `update_time`) VALUES
	(1, 'root', 'CGUx1FN++xS+4wNDFeN6DA==', '超级管理员', '15151551516', '843977358@qq.com', '843977358', NULL, NULL, 'https://static.zhyd.me/static/img/favicon.ico', 'ROOT', NULL, '127.0.0.1', '2018-05-29 17:41:06', 229, NULL, 1, '2018-01-02 09:32:15', '2018-05-29 17:41:06'),
	(2, 'admin', 'gXp2EbyZ+sB/A6QUMhiUJQ==', '管理员', '15151551516', '843977358@qq.com', '843977358', NULL, NULL, NULL, 'ADMIN', '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '2018-05-17 13:08:30', 13, NULL, 1, '2018-01-02 15:56:34', '2018-05-17 13:08:30');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 shiro.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL,
  `create_time` datetime DEFAULT current_timestamp() COMMENT '添加时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 正在导出表  shiro.sys_user_role 的数据：~2 rows (大约)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`, `create_time`, `update_time`) VALUES
	(1, 1, 1, '2018-01-02 10:47:27', '2018-01-02 10:47:27'),
	(2, 2, 2, '2018-01-05 18:21:02', '2018-01-05 18:21:02');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
