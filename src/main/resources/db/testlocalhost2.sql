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


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.sys_menu 结构
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdDate` datetime NOT NULL,
  `createdIp` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `createdUser` varchar(50) CHARACTER SET utf8 NOT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `lastModifiedIp` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `lastModifiedUser` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `menuName` varchar(255) DEFAULT NULL,
  `menuType` int(11) DEFAULT NULL,
  `orderNum` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `perms` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `visible` bit(1) NOT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKon6ax23cdghjmhc9un3oxc9sc` (`parentId`),
  CONSTRAINT `FKon6ax23cdghjmhc9un3oxc9sc` FOREIGN KEY (`parentId`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test.sys_menu 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`id`, `createdDate`, `createdIp`, `createdUser`, `lastModifiedDate`, `lastModifiedIp`, `lastModifiedUser`, `icon`, `menuName`, `menuType`, `orderNum`, `perms`, `url`, `visible`, `parentId`) VALUES
	(1, '2019-01-29 14:59:25', NULL, 'an', NULL, NULL, NULL, NULL, 'fds', 2, NULL, NULL, 'admin/test', b'1', NULL),
	(2, '2019-01-29 14:59:25', NULL, 'an', NULL, NULL, NULL, NULL, 'fds', 2, NULL, NULL, 'test', b'1', NULL),
	(3, '2019-01-29 14:59:25', NULL, 'an', NULL, NULL, NULL, NULL, 'fds', 2, NULL, 'view', 'role/list', b'1', NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;

-- 导出  表 test.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdDate` datetime NOT NULL,
  `createdIp` varchar(100) DEFAULT NULL,
  `createdUser` varchar(50) NOT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `lastModifiedIp` varchar(100) DEFAULT NULL,
  `lastModifiedUser` varchar(50) DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `createdDate`, `createdIp`, `createdUser`, `lastModifiedDate`, `lastModifiedIp`, `lastModifiedUser`, `available`, `description`, `name`) VALUES
	(1, '2019-01-29 09:59:54', NULL, '45', NULL, NULL, NULL, NULL, '管理员', 'admin');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 test.sys_role_menu 结构
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `roleId` bigint(20) NOT NULL,
  `menuId` bigint(20) NOT NULL,
  PRIMARY KEY (`menuId`,`roleId`),
  KEY `FK8g1xowau8dd5gqrdjhkgell1u` (`roleId`),
  CONSTRAINT `FK2lagreeeq77rb54mx3lwlhux4` FOREIGN KEY (`menuId`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `FK8g1xowau8dd5gqrdjhkgell1u` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_role_menu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`roleId`, `menuId`) VALUES
	(1, 3);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;

-- 导出  表 test.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdDate` datetime NOT NULL,
  `createdIp` varchar(100) DEFAULT NULL,
  `createdUser` varchar(50) NOT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `lastModifiedIp` varchar(100) DEFAULT NULL,
  `lastModifiedUser` varchar(50) DEFAULT NULL,
  `UserStatus` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `createdDate`, `createdIp`, `createdUser`, `lastModifiedDate`, `lastModifiedIp`, `lastModifiedUser`, `UserStatus`, `password`, `salt`, `username`) VALUES
	(1, '2019-01-29 09:57:13', NULL, 'an', NULL, NULL, NULL, 1, 'b0c2731da6026f70c5a5b199b1725395cc91d99da4e8b16ea160f398f43030d0', 'e7b6a17a', 'admin');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 test.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`roleId`,`userId`),
  KEY `FK8rsekkvn91inc4bkn6jxsayv4` (`userId`),
  CONSTRAINT `FK8rsekkvn91inc4bkn6jxsayv4` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKjh0u12g42rt4md78ptxxnlpmu` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.sys_user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`userId`, `roleId`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
