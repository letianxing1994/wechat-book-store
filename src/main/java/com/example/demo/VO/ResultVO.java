package com.example.demo.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * http request most outer layer object
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /** status code */
    private Integer code;

    /** message */
    private String msg = "";

    /** data */
    private T data;

}
