package com.lu.handler;

import com.lu.pojo.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, Exception e) {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Some Data");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }
}
