# spring-aop-jwt
使用spring aop与jwt做用户鉴权Demo


鉴权部分采用流行的无状态鉴权，用户登录成功后颁发token，每次请求携带token，服务器端对token进行校验是否合法，是否过期等，进行用户鉴权。