package org.kxw.bms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kxw.bms.model.PaymentDO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Create by kangxiongwei on 2017/11/27 下午11:04
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/bms-core.xml")
public class PaymentDaoTest {

    @Resource
    private IPaymentDao paymentDao;

    @Test
    public void testInsert() {
        PaymentDO entity = new PaymentDO();
        entity.setPaymentId("xxxxxxxxxx");
        entity.setOrderId("yyyyyyyyy");
        entity.setStatus(1);
        entity.setCashCode(112);
        entity.setPayChannel(35);
        entity.setPrice(100L);
        entity.setExt("测试以下");
        this.paymentDao.insert(entity);
    }

    @Test
    public void testDriver() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kxw_test";
        Connection connection = DriverManager.getConnection(url, "root", "kxw672015");
        PreparedStatement ps = connection.prepareStatement("update xx set x = y WHERE xxx");
        ps.executeBatch();
    }


}
