package xyz.mxin.springaopjwt.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.mxin.springaopjwt.security.SecurityException;
import xyz.mxin.springaopjwt.until.AjaxResult;

/**
 * exception 统一处理
 * @author 油炸君
 * @date 2021年05月20日 13:46
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(SecurityException.class)
    public AjaxResult error(SecurityException s) {
        return AjaxResult.error(s.getDefaultMessage());
    }




}
