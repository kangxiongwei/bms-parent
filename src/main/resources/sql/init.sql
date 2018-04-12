#创建数据库
CREATE DATABASE IF NOT EXISTS bms DEFAULT CHARSET UTF8;

#创建订单表
CREATE TABLE IF NOT EXISTS bms_order (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
  order_id VARCHAR(64) NOT NULL COMMENT '订单号，全局唯一',
  status INT NOT NULL COMMENT '0 删除 1未支付 2已支付 3退款中 4已退款',
  business_id INT NOT NULL COMMENT '接入方ID，和公司组织结构有关',
  order_type INT NOT NULL COMMENT '订单类型 0未知',
  pay_type INT NOT NULL COMMENT '支付方式 0未知 1支付宝 2微信等',
  account_id VARCHAR(64) COMMENT '收款账号，对账用',
  original_price BIGINT NOT NULL COMMENT '订单原始金额，单位分',
  real_price BIGINT NOT NULL COMMENT '订单实际支付金额，单位分',
  cash_code INT NOT NULL COMMENT '币种 1人民币 2美元等',
  tax_code INT NOT NULL DEFAULT 0 COMMENT '税率',
  user_id VARCHAR(32) NOT NULL COMMENT '用户ID',
  user_ip VARCHAR(64) COMMENT '用户的IP地址',
  product_id BIGINT NOT NULL COMMENT '购买的商品ID',
  product_name VARCHAR(256) COMMENT '商品名称，冗余',
  product_count INT NOT NULL COMMENT '购买的商品数量',
  submit_time DATETIME NOT NULL COMMENT '订单提交时间',
  pay_time DATETIME COMMENT '订单支付时间',
  ext LONGTEXT COMMENT '扩展字段，JSON格式，便于水平扩展'
) COMMENT '支付系统订单表';

#创建流水表
CREATE TABLE IF NOT EXISTS bms_payment (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
  payment_id VARCHAR(64) NOT NULL COMMENT '流水号，全局唯一',
  order_id VARCHAR(64) NOT NULL COMMENT '订单号，和订单表关联',
  status INT NOT NULL COMMENT '0 删除 1未支付 2已支付 3退款中 4已退款',
  price BIGINT NOT NULL COMMENT '流水金额',
  cash_code INT NOT NULL COMMENT '币种',
  pay_channel INT NOT NULL COMMENT '支付渠道，每种支付方式可以有多个渠道',
  payment_time DATETIME COMMENT '流水生成时间',
  ext LONGTEXT COMMENT '扩展字段，JSON格式，便于水平扩展'
) COMMENT '支付系统流水表';