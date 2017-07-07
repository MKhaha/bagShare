
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;


USE bagshare;

-- ----------------------------
--  Table structure for `bag_collect`
-- ----------------------------
DROP TABLE IF EXISTS `bag_collect`;
CREATE TABLE `bag_collect` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '包包id',
  `name` VARCHAR(100) NOT NULL COMMENT '名称',
  `price` VARCHAR(100) NOT NULL COMMENT '价格',
  `title` VARCHAR(1000) NOT NULL COMMENT '标题',
  `address` VARCHAR(200) DEFAULT NULL COMMENT '包包网址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `name_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `bag_information`
-- ----------------------------
DROP TABLE IF EXISTS `bag_information`;
CREATE TABLE `bag_information` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '包包id',
  `name` VARCHAR(100) NOT NULL COMMENT '名称',
  `brand` VARCHAR(100) NOT NULL COMMENT '品牌',
  `price` DECIMAL(15,2) DEFAULT NULL COMMENT '价格',
  `major_picture_address` VARCHAR(200) DEFAULT NULL COMMENT '主图地址',
  `minor_picture_address` VARCHAR(5000) DEFAULT NULL COMMENT '辅图地址，一般为多个',
  `bag_information` VARCHAR(10000) DEFAULT NULL COMMENT '包包的产品信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `asset_id_index` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS = 1;