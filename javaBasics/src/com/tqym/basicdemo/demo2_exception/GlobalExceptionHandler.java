package com.tqym.basicdemo.demo2_exception;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理器
 * @Author 洛城天使
 * @Date: 2021/9/21 16:16
 * @Version 1.0
 */
/*@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    *//**
     * 捕获并处理自定义异常
     *//*
    @ExceptionHandler(MyException.class)
    public String handleMyException(MyException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("message", e.getMessage());
        map.put("method", e.getMethod());
        map.put("description", e.getDescription());
        logger.error(e.getCode());
        logger.error(e.getMessage());
        logger.error(e.getMethod());
        logger.error(e.getDescription());
        return MsgUtil.errorMsg(map);
    }

    *//**
     * 处理所有异常
     *//*
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        e.printStackTrace();
        logger.error(e.toString());
    }
}*/
