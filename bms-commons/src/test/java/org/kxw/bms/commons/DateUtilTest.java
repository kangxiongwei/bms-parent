package org.kxw.bms.commons;

import org.junit.Assert;
import org.junit.Test;
import org.kxw.bms.commons.util.DateUtil;

import java.util.Date;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:24
 */
public class DateUtilTest {

    @Test
    public void testStringToDate() {
        String date = "2018-07-17 12:22:35";
        Date d = DateUtil.stringToDate(date);
        String s = DateUtil.dateToString(d);
        Assert.assertEquals(s, date);
    }


}
