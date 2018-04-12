package org.kxw.bms.dao;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.Rename;
import org.jfaster.mango.annotation.SQL;
import org.kxw.bms.model.PaymentDO;

/**
 * Create by kangxiongwei on 2017/11/26 上午11:00
 */
@DB(name = "bms", table = "bms_payment")
public interface IPaymentDao {

    /**
     * 插入一条记录
     *
     * @param entity
     * @return
     */
    @SQL("insert into #table" +
            " (payment_id, order_id, status, price, cash_code, pay_channel, payment_time, ext)" +
            " values(:pay.paymentId, :pay.orderId, :pay.status, :pay.price, :pay.cashCode, :pay.payChannel, now(), :pay.ext)")
    int insert(@Rename("pay") PaymentDO entity);


}
