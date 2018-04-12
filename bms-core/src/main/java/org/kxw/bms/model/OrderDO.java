package org.kxw.bms.model;

import java.util.Date;

/**
 * Create by kangxiongwei on 2017/11/26 上午11:02
 */
public class OrderDO {

    private Long id;
    private String orderId;
    private Integer status;
    private Integer businessId;
    private Integer orderType;
    private Integer payType;
    private String accountId;
    private Long originalPrice;
    private Long realPrice;
    private Integer cashCode;
    private Integer taxCode;
    private String userId;
    private String userIp;
    private Long productId;
    private String productName;
    private Integer productCount;
    private Date submitTime;
    private Date payTime;
    private String ext;

}
