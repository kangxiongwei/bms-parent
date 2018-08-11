CREATE TABLE bms_auth_user (
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  username VARCHAR(64) NOT NULL DEFAULT '' COMMENT '用户名称',
  nickname VARCHAR(64) COMMENT '用户昵称',
  password VARCHAR(128) COMMENT '用户密码',
  mobile VARCHAR(64) COMMENT '手机号码',
  email VARCHAR(64) COMMENT '用户邮箱',
  head_img VARCHAR(1000) COMMENT '用户头像',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL COMMENT '修改时间'
) ENGINE = InnoDB DEFAULT CHARSET = UTF8 COMMENT '用户信息表';



