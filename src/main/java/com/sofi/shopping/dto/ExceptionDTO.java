package com.sofi.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {

    private int status;
    private String message;
}
