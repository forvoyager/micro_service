# 项目简介
此项目主要是微服务研究过程中的项目实践内容。  

功能：
> 简化版的用户购买商品过程，包括账户中心、订单、商品库存模块，主要业务流程：   
用户发起购买行为->商品减库存->生成订单->扣费。   

注册中心：
> Eureka   

微服务调用方式：
> Feign 

# 主要工具/开源库
- JDK1.8
- Spring Boot 2.1.1.RELEASE
- Spring Cloud Finchley.SR1
- Maven
- IntelliJ IDEA

# 项目模块划分
| 模块 | 功能 |
| :------| ------ |
| ms-account | 账户中心 |
| ms-account-common | 通用Model及REST API定义 |
| ms-account-service | 账户中心相关服务实现 |
| ms-account-client-starter | 账户中心服务请求客户端，其他模块需要调用本模块的功能时，引入此starter即可。 |
| |  |
| ms-order | 订单中心 |
| ms-order-common | 通用Model及REST API定义 |
| ms-order-service | 订单中心相关服务实现 |
| ms-order-client-starter | 订单中心服务请求客户端，其他模块需要调用本模块的功能时，引入此starter即可。 |
| |  |
| ms-storage | 商品库存中心 |
| ms-storage-common | 通用Model及REST API定义 |
| ms-storage-service | 商品库存中心相关服务实现 |
| ms-storage-client-starter | 商品库存中心服务请求客户端，其他模块需要调用本模块的功能时，引入此starter即可。 |
| |  |

# 启动服务
账户服务：com.xr.account.AccountServiceApplication

订单服务：com.xr.order.OrderServiceApplication

库存服务：com.xr.storage.StorageServiceApplication

API：com.xr.api.ApiApplication

# 访问api
```
http://localhost:9999/purchase?user_id=100&commodity_id=1&count=1
```
处理过程如下：
1 减少库存
2 创建订单
2.1 从账户扣款
2.2 创建订单
注：
1. 调用过程这么拆开，可能与实际处理过程不一样，此处的场景仅作为研究用，目的是模拟微服务化之后，应用之间的调用场景。
2. 项目中仅仅演示了spring boot/cloud及其相关组建的使用，还有很多功能没有实现，很多问题没有解决，如：分布式事务问题。

后续逐步完善，未完待续……