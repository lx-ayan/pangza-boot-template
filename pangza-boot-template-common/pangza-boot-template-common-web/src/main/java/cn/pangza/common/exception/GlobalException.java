package cn.pangza.common.exception;

import cn.pangza.common.utils.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BusinessException.class)
    ResponseData<Object> businessException(String message) {
        return ResponseData.error(message);
    }
}
