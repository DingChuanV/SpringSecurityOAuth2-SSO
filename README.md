# SpringSecurityOAuth2-SSO
SpringSecurity+JWT+OAuth2整合实现单点登陆SSO。

![image](https://user-images.githubusercontent.com/74408716/162967937-e83fcda9-fc33-4669-b5b4-0576ad81823b.png)


用户认证：这一环节主要是用户向认证服务器发起认证请求，认证服务器给用户返回一个成功的令牌token， 主要在认证服务器中完成。

身份校验：这一环节是用户携带token去访问其他服务器时，在其他服务器中要对token的真伪进行检验，主要在资源服务器中完成。

## 项目背景

https://developer.aliyun.com/article/636281

在企业发展初期，企业使用的系统很少，通常一个或者两个，每个系统都有自己的登录模块，运营人员每天用自己的账号登录，很方便。但随着企业的发展，用到的系统随之增多，运营人员在操作不同的系统时，需要多次登录，而且每个系统的账号都不一样，这对于运营人员来说，很不方便。于是，就想到是不是可以在一个系统登录，其他系统就不用登录了呢？

这就是单点登录要解决的问题。

单点登录英文全称Single Sign On，简称就是SSO，在多个应用系统中，只需要登录一次，就可以访问其他相互信任的应用系统。


## 📖项目结构

![image-20220412210112778](https://bearbrick0.oss-cn-qingdao.aliyuncs.com/images/img/202204122101946.png)


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




