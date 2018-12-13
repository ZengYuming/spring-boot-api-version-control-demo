# spring-boot-api-version-control-demo
spring-boot restful api version control demo (Restful Api 版本控制)


需要升级api，但是旧的api又不能取掉，所以可以做一个版本控制，来分流不同版本api

1.请求默认（无版本api）http://localhost:8080/hello/world，将会路由到，没有打ApiVersion注解的api

2.请求版本1api = http://localhost:8080/v1/hello/world

3.请求版本2api = http://localhost:8080/v2/hello/world

4.请求一个不存在的版本api = http://localhost:8080/v3/hello/world ，将会路由到最新的版本api

需要处理的问题：
问题：当版本不存在时，往旧版本找，直到找到一个版本
状态：已经解决，比如：http://localhost:8080/v2/hello/martin 只在v1中有，v2中没有，然后会降级找到，具体逻辑参考ApiVersionCondition



存在的缺陷：
版本变多时，对于某个接口，可能需要很久，才能确定这个api在哪个版本有升级

版本控制参考博文：
https://blog.csdn.net/j903829182/article/details/81836551 
https://blog.csdn.net/u010598360/article/details/81275291
