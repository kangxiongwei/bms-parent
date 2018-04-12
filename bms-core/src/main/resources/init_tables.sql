DROP TABLE t_user;
CREATE TABLE t_user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(32) NOT NULL COMMENT '用户名称',
  password VARCHAR(64) NOT NULL COMMENT '用户密码',
  nickname VARCHAR(32) COMMENT '用户昵称',
  email VARCHAR(32) COMMENT '用户邮箱',
  phone VARCHAR(16) COMMENT '用户电话',
  status TINYINT(4) NOT NULL DEFAULT 0 COMMENT '状态 0无效 1有效',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  UNIQUE KEY idx_username_password(username, password)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;