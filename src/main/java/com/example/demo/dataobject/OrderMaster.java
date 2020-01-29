package com.example.demo.dataobject;

import com.example.demo.Enum.OrderStatusEnum;
import com.example.demo.Enum.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** order id. */
    @Id
    private String orderId;

    /** buyer name .*/
    private String buyerName;

    /** buyer's phone number .*/
    private String buyerPhone;

    /** buyer's address .*/
    private String buyerAddress;

    /** buyer's wechat id .*/
    private String buyerOpenid;

    /** order amount .*/
    private BigDecimal orderAmount;

    /** order status .*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** payment status .*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** create time .*/
    private Date createTime;

    /** update time .*/
    private Date updateTime;
}
