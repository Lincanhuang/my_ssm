-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.3.11-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test 的数据库结构
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.sys_resource 结构
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE IF NOT EXISTS `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  `external` bit(1) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa81scu9ofyxjsx2kwrwnxrpyc` (`parentId`),
  CONSTRAINT `FKa81scu9ofyxjsx2kwrwnxrpyc` FOREIGN KEY (`parentId`) REFERENCES `sys_resource` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_resource 的数据：~0 rows (大约)
DELETE FROM `sys_resource`;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
INSERT INTO `sys_resource` (`id`, `createDate`, `updateDate`, `available`, `external`, `icon`, `name`, `permission`, `sort`, `type`, `url`, `parentId`) VALUES
	(1, NULL, NULL, NULL, NULL, 'dfd', '途径', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;

-- 导出  表 test.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_role 的数据：~0 rows (大约)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `createDate`, `updateDate`, `available`, `description`, `name`) VALUES
	(1, NULL, NULL, b'1', NULL, '管理员'),
	(2, NULL, NULL, b'1', NULL, '客户');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 test.sys_role_resource 结构
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE IF NOT EXISTS `sys_role_resource` (
  `roleId` bigint(20) NOT NULL,
  `resourceId` bigint(20) NOT NULL,
  PRIMARY KEY (`resourceId`,`roleId`),
  KEY `FKstvjsbjkq8y0uis6n959nbrfj` (`roleId`),
  CONSTRAINT `FKstvjsbjkq8y0uis6n959nbrfj` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKtdwj921rojf281g6o2ldlleqv` FOREIGN KEY (`resourceId`) REFERENCES `sys_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_role_resource 的数据：~0 rows (大约)
DELETE FROM `sys_role_resource`;
/*!40000 ALTER TABLE `sys_role_resource` DISABLE KEYS */;
INSERT INTO `sys_role_resource` (`roleId`, `resourceId`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_role_resource` ENABLE KEYS */;

-- 导出  表 test.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `lastLoginIp` varchar(255) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `loginCount` int(11) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `regIp` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_user 的数据：~2 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `createDate`, `updateDate`, `avatar`, `birthday`, `email`, `gender`, `lastLoginIp`, `lastLoginTime`, `loginCount`, `mobile`, `nickname`, `password`, `qq`, `regIp`, `remark`, `salt`, `status`, `userType`, `username`) VALUES
	(1, '2019-01-03 20:35:50', '2019-01-03 20:35:50', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '7dc0694264b0f68699d174b7fa0f94e3fc7b3da28de55b871088212ab6af6f30', NULL, NULL, NULL, 'ad', 1, NULL, 'admin'),
	(2, '2019-01-03 20:36:30', '2019-01-03 20:36:30', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'f0b9e99b3dc3ae1bfc576fc13dce4c3d55702216dc84008382f54b36c12de5af', NULL, NULL, NULL, 't', 1, NULL, 'test');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 test.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`roleId`,`userId`),
  KEY `FK8rsekkvn91inc4bkn6jxsayv4` (`userId`),
  CONSTRAINT `FK8rsekkvn91inc4bkn6jxsayv4` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKjh0u12g42rt4md78ptxxnlpmu` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_user_role 的数据：~0 rows (大约)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`userId`, `roleId`) VALUES
	(1, 1),
	(1, 2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
