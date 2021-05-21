package xyz.mxin.springaopjwt.controller;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.mxin.springaopjwt.annotation.ChickUserLoginAnnotation;
import xyz.mxin.springaopjwt.bean.User;
import xyz.mxin.springaopjwt.dto.UserDTO;
import xyz.mxin.springaopjwt.security.JwtOperator;
import xyz.mxin.springaopjwt.until.AjaxResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户controller
 * @author 油炸君
 * @date 2021年05月20日 11:42
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginController {


    @Autowired
    private JwtOperator jwtOperator;

    /**
     * 模拟用户登录
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public AjaxResult userLogin(@RequestBody UserDTO userDTO) {
        if (StrUtil.isEmptyIfStr(userDTO.getUserNmae()) || StrUtil.isEmptyIfStr(userDTO.getPwd())) {
            return AjaxResult.error("用户名密码不能为空!");
        }
        if (!("1".equals(userDTO.getPwd()) && "1".equals(userDTO.getUserNmae()))) {
            return AjaxResult.error("用户名或密码错误");
        }
        // 模拟登录成功 返回token
        User user = User.builder().nickName("油炸小可爱").build();
        Map<String, Object> claims = new HashMap<>();
        claims.put("nickName",user.getNickName());
        String token = jwtOperator.generateToken(claims);
        return AjaxResult.success().put("data",token);
    }


    /**
     * 模拟操作，需要鉴权
     * @param userDTO
     * @return
     */
    @GetMapping("/info")
    @ChickUserLoginAnnotation
    public AjaxResult userInfo(UserDTO userDTO) {
        log.info("我进来了");
        return AjaxResult.success();
    }













}
