package com.owner.springcloud.provider.commom;


/**
 * @Description:公共异常编码,各模块异常放在各自common，后续将不在使用
 * Author	Version		Date		Changes
 * zhuangjianfa 1.0  2018年2月1日 Created
 */
public enum ResultCode {
    
    SERVICE_EXCEPTION(1,"servcie exception."),
    
    CONFIG_EXCEPTION(2,"config exception.");
    /**
     * 异常编码
     */
    private Integer code;
    
    private String message;

    
    /**
     * Returns this code object.
     * @return this code
     */
    public Integer getCode() {
        return code;
    }


    
    /**
     * Returns this message object.
     * @return this message
     */
    public String getMessage() {
        return message;
    }



    /**
     * Class constructors.
     * @param code
     * @param message
     */
    private ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    
    public String getMessage(final Object... args) {
        return String.format(this.message, args);
    }
    
}
