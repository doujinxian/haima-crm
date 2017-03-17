CREATE TABLE `user` (
  `userId` INT (11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR (50) NOT NULL COMMENT '用户名',
  `userPassword` VARCHAR (100) DEFAULT NULL COMMENT '密码',
  `userEmail` VARCHAR (100) DEFAULT NULL COMMENT '邮箱',
  `userNickname` VARCHAR (100) DEFAULT NULL COMMENT '昵称',
  `userBirthday` DATETIME DEFAULT NULL COMMENT '生日',
  `userRemark` VARCHAR (100) DEFAULT NULL COMMENT '备注',
  `userPoints` INT (11) DEFAULT NULL COMMENT '分数',
  `sex` TINYINT (4) DEFAULT 0 COMMENT '性别 1:男 2：女',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE = INNODB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8 COMMENT = '系统用户' ;

INSERT INTO `user` (userId,userName,userPassword,userEmail,userNickname,userBirthday,userRemark,userPoints,sex) VALUES (1,'admin','123456','www.sina.com','tom','2010-10-10','男生',90,1);