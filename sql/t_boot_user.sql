CREATE TABLE `t_boot_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `gender` varchar(4) NOT NULL COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `email` varchar(64) not NULL COMMENT '注册邮箱',
  `state` int(1) not NULL DEFAULT 0 COMMENT '0:未激活，1:已激活；未激活用户不允许登录',
  `birthday` date NOT NULL COMMENT '出生日期',
  PRIMARY KEY (`id`)
);
INSERT INTO t_boot_user (`id`, `name`, `password`, `gender`, `age`, `email`, `state`, `birthday`) VALUES ('1', 'admin', '703f98fddf99e32c85f9435081081ea2', '男', '12', '431103832@qq.com', '1', '2020-04-24');

