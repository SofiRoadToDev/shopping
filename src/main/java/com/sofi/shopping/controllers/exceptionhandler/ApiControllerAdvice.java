package com.sofi.shopping.controllers.exceptionhandler;

import com.sofi.shopping.dto.ExceptionDTO;
import com.sofi.shopping.exceptions.ProductNotFoundException;
import com.sofi.shopping.exceptions.SaleNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
@Log4j2
public class ApiControllerAdvice {




    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ExceptionDTO> handleValidationErrors(MethodArgumentNotValidException ex){
         List<ExceptionDTO>errors=new ArrayList<>();
         ex.getBindingResult().getAllErrors().forEach((e)->{
             errors.add(new ExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getObjectName()));
         });
         errors.forEach(System.out::println);
         return errors;
    }


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO exceptionHandler(ProductNotFoundException ex){
       log.info("advice: "+ex.getMessage());
       return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO exceptionHandler(SaleNotFoundException ex){
        log.info("advice: "+ex.getMessage());
        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }

}
