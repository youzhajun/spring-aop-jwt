package xyz.mxin.springaopjwt.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 油炸君
 * @date 2021年05月20日 13:41
 */
public class SecurityException  extends RuntimeException{

    private static final long serialVersionUID = 1L;
    /**
     * 错误码
     */
    private String code;



    /**
     * 错误消息
     */
    private String defaultMessage;


    public SecurityException(String code) {
        this.code = code;
    }

    public SecurityException(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
