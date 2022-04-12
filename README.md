# SpringSecurityOAuth2-SSO
SpringSecurity+JWT+OAuth2整合实现单线登陆SSO

## 📖项目结构

![](https://bearbrick0.oss-cn-qingdao.aliyuncs.com/images/img/202204121805269.png)

## 🧪实现效果

1. 启动项目。

认证的客户端的地址是：http://localhost:8081/user/getCurrentUser

授权服务器的地址是：http://localhost:8080

当然要先启动授权服务器，因为客户端有授权服务的路径配置。

2. 客户端发起请求，想要获取资源

被重定向到 http://localhost:8080/login 页面要求授权，输入在授权服务器自定义的登陆的逻辑中的username和password。
实现授权。

授权服务器完成授权，会给客户端签发JwtToken，客户端拿着这个token，就可以去资源服务器（资源服务器也在授权服务器中配置）
就可以获取到相关的资源。

<img src="https://bearbrick0.oss-cn-qingdao.aliyuncs.com/images/img/202204121813080.png" alt="image-20220412181353839" style="zoom:50%;" />

## 🦶实验步骤

- 分为两部分配置，首先是授权服务器的配置

1. 自定义登陆逻辑
具体请看pojo层、service层

3. 授权服务器的配置，包括

- 授权服务器本身的配置
- jwtToken配置
- 配置token内容增强器
- SpringSecurity配置
- 资源服务器的配置

具体配置详细请看config配置类


- 客户端的配置

1. 导入依赖
具体见pom.xml文件。
2. 开启注解

```java
//开启单点登陆的注解
@EnableOAuth2Sso
```

3. 编写请求资源的controller

```java
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
```

同时需要注意的SpringBoot和SpringCloud的版本对应。




