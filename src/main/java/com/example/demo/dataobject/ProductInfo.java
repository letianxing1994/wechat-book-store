package com.example.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** name. */
    private String productName;

    /** price. */
    private BigDecimal productPrice;

    /** stock. */
    private Integer productStock;

    /** description. */
    private String productDescription;

    /** picture. */
    private String productIcon;

    /** status. 0 normal 1 out of sale*/
    private Integer productStatus;

    /** category type */
    private Integer categoryType;
}
