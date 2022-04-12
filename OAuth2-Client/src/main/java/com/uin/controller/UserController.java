package com.uin.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @author wanglufei
 * @description: 获取当前用户的信息
 * @date 2022/4/12/5:35 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取当前user
     *
     * @param authentication
     * @return java.lang.Object
     * @author wanglufei
     * @date 2022/4/12 5:37 PM
     */
    @RequestMapping("/getCurrentUser")
    //authentication 认证
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

}
