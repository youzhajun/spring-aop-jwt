# spring-aop-jwt
使用spring aop与jwt做用户鉴权Demo
博客地址:http://bblog.mxin.xyz/archives/springaopjwt%E5%81%9A%E7%94%A8%E6%88%B7%E9%89%B4%E6%9D%83
鉴权部分采用无状态鉴权，用户登录成功后颁发token，客户端每次请求携带token，服务器端对token进行校验是否合法，是否过期等进行用户鉴权。