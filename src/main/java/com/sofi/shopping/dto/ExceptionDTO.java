package com.sofi.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@ToString
public class ExceptionDTO {

    private int status;
    private String message;


}
