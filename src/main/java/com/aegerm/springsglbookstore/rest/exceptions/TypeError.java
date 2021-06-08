package com.aegerm.springsglbookstore.rest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TypeError {

    private Long timestamp;
    private Integer status;
    private String error;
}
