/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : springbootmall

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-11-01 17:42:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `userid` int(25) NOT NULL,
  `pid` varchar(30) DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('15', '1', '75', '7');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `sup_category` varchar(30) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '服装', '女装');
INSERT INTO `category` VALUES ('2', '服装', '男装');
INSERT INTO `category` VALUES ('3', '服装', '内衣');
INSERT INTO `category` VALUES ('4', '服装', '鞋靴');
INSERT INTO `category` VALUES ('5', '服装', '箱包');
INSERT INTO `category` VALUES ('6', '服装', '配件');
INSERT INTO `category` VALUES ('7', '服装', '童装');
INSERT INTO `category` VALUES ('8', '儿童', '玩具');
INSERT INTO `category` VALUES ('9', '电子', '家电');
INSERT INTO `category` VALUES ('10', '电子', '数码');
INSERT INTO `category` VALUES ('11', '电子', '手机');
INSERT INTO `category` VALUES ('12', '保养品', '美妆');
INSERT INTO `category` VALUES ('13', '保养品', '洗护');
INSERT INTO `category` VALUES ('14', '保养品', '保健品');
INSERT INTO `category` VALUES ('15', '装饰', '珠宝');
INSERT INTO `category` VALUES ('16', '装饰', '眼镜');
INSERT INTO `category` VALUES ('17', '装饰', '手表');
INSERT INTO `category` VALUES ('18', '娱乐', '游戏');
INSERT INTO `category` VALUES ('19', '娱乐', '动漫');
INSERT INTO `category` VALUES ('20', '娱乐', '影视');
INSERT INTO `category` VALUES ('21', '食品', '美食');
INSERT INTO `category` VALUES ('22', '食品', '生鲜');
INSERT INTO `category` VALUES ('23', '食品', '零食');
INSERT INTO `category` VALUES ('24', '其它', '其他');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `pid` int(20) NOT NULL,
  `price` float(10,2) NOT NULL,
  `num` int(10) NOT NULL,
  `total_price` float(10,2) NOT NULL,
  `order_num` varchar(250) NOT NULL,
  `generation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('11', '1', '75', '10.50', '1', '10.50', '8f3d4223-2415-4164-a433-82b5f1ec060f', '2019-11-01 02:53:45');
INSERT INTO `order` VALUES ('12', '1', '75', '10.50', '1', '10.50', '1b262007-ca13-48b7-bde1-c8a0e83ff8be', '2019-11-01 02:55:54');
INSERT INTO `order` VALUES ('14', '1', '75', '10.50', '1', '10.50', '0011de6d-d9b8-4cfe-95f4-c2abc95b3d7b', '2019-11-01 11:23:37');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `pName` varchar(30) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `info` varchar(100) DEFAULT NULL,
  `price` float(11,2) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `details` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('75', '宣传海报', '其他', '装饰', '10.50', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p><img src=\"/images/20191022/1571731041380081156.jpeg\" title=\"1571731041380081156.jpeg\" alt=\"20160918101253_MHatL.thumb.224_0.jpeg\"/>宣传海报<br/></p>');
INSERT INTO `product` VALUES ('76', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<img src=\"/images/20191022/1571732507291015148.jpg\" title=\"1571732507291015148.jpg\" alt=\"u=4100311819,3282599566&amp;fm=26&amp;gp=0.jpg\"/></p>');
INSERT INTO `product` VALUES ('77', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p><img src=\"/images/20191022/1571732275986014701.png\" title=\"1571732275986014701.png\" alt=\"QQ截图20190908203140.png\"/>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('78', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p><img src=\"/images/20191022/1571732381175036985.jpg\" title=\"1571732381175036985.jpg\" alt=\"u=2747017581,3537919067&amp;fm=26&amp;gp=0.jpg\"/>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('79', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p><img src=\"/images/20191022/1571732614400074738.jpg\" title=\"1571732614400074738.jpg\" alt=\"u=2113236568,208146983&amp;fm=15&amp;gp=0.jpg\"/></p>');
INSERT INTO `product` VALUES ('80', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('81', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('82', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('83', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('84', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('85', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('86', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('87', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('88', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('89', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('90', '海报', '其他', '装饰', '20.00', '/images/59baf364-6ec5-4881-a0e7-06a8f852f409timg (2).jpg', '<p>为什么不显示呢<br/></p>');
INSERT INTO `product` VALUES ('91', '大氿歌', '影视', '歌曲-大氿歌', '2.00', '/images/a7142da4-4b2a-43b7-9b08-f78ee1902333QQ截图20190908203140.png', '<p>文痴武客三点血</p><p><img src=\"/images/20191022/1571727372616091993.png\" title=\"1571727372616091993.png\"/></p><p><img src=\"/images/20191022/1571727372616027471.png\" title=\"1571727372616027471.png\"/></p><p><br/></p>');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', '123456', '2019-10-22 16:58:29');
