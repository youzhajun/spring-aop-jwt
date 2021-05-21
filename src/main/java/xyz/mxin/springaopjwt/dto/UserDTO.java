package xyz.mxin.springaopjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 用户DTO
 * @author 油炸君
 * @date 2021年05月20日 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDTO {


    /**
     * 用户名
     */
    private String userNmae;


    /**
     * 登录密码
     */
    private String pwd;

}
