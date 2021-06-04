## SpringBoot启动

springboot是通过main方法下的SpringApplication.run方法启动的,启动的时候他会调用refshContext方法,先刷新容器,然后根据解析注解或者解析配置文件的形式注册bean,而它是通过启动类的SpringBootApplication注解进行开始解析的,他会根据EnableAutoConfiguration开启自动化配置,里面有个核心方法ImportSelect选择性的导入,根据loadFanctoryNames根据classpash路径以MATA-INF/spring.factorces下面以什么什么EnableAutoConfiguration开头的key去加载里面所有对应的自动化配置,他并不是把这一百二十多个自动化配置全部导入,在他每个自动化配置里面都有条件判断注解,先判断是否引入相互的jar包,再判断容器是否有bean再进行注入到bean容器

##### SpringBoot通过配置文件自动装配所属依赖的类，再用动态代理的方式，注入Spring里边

## Mybatis的二级缓存

在MyBatis的配置文件里开启二级缓存，并在mapper.xml里打上cache标签

## MySQL数据库底层索引结构

索引是帮助数据库高效获取数据的一种数据结构，myisam 和 innodb两种存储引擎 支持hash 和 B+Tree，

hash对于范围是不支持的，牺牲插入删除等性能，每次数据变更都会重新维护索引结构，带来大量的IO开销，生成一个索引文件

# Servlet 生命周期

Servlet 生命周期可被定义为从创建直到毁灭的整个过程。以下是 Servlet 遵循的过程：

- Servlet 初始化后调用 **init ()** 方法。
- Servlet 调用 **service()** 方法来处理客户端的请求。
- Servlet 销毁前调用 **destroy()** 方法。
- 最后，Servlet 是由 JVM 的垃圾回收器进行垃圾回收的。

## HashMap的实现原理

* HashMap概述：HashMap是基于哈希表的Map接口的非同步实现，此实现提供所有可选的映射操作，并允许使用NUll值和Null键；
* HashMap的数据结构：在java语言中，最基本的结构就只有两种，一个是数组，一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造，HashMap也不例外，其实际上是一个 链表散列 的数据结构，即数组和链表的结合体；
* 当我们往HashMap中put元素时，首先根据Key的hashcode重新计算hash值，根据hash值得到这个元素在数组中的位置。如果该数组的位置已经被占用，则将该位置上的元素以链表的形式存放，新加入的放在链头，最先加入的放在链尾；
* jdk1.8之后对HashMap 的实现做了优化，当链表中的节点数超过8个，该链表会转为红黑树来提高效率；

## 页面加载状态码

3开头重定向问题

4开头客户端问题

5开头服务端问题

## SpringSecurity

![image-20210602114326327](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210602114326327.png)

## 数据库设计

![image-20210602182036635](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210602182036635.png)

![image-20210602182056828](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210602182056828.png)

## Nginx三大功能点

1. 反向代理
2. 负载均衡
3. 动静分离

## Redis

* **缓存穿透**：Redis主要职责是分担数据库压力，将数据库数据放到Redis上，方便用户从缓存中快速查找数据，如果查询的是一条不存在的数据，则会跳过Redis直接查询数据库，数据库不能返回对应的值，但是前端仍旧一直访问，这样会导致一个恶意访问的问题，解决办法可以考虑为该条数据设置一个NUll值，当查询不到时，将改数据设置为null 存放到Redis上，或者记录该条IP，锁定IP进行相关操作；

* **缓存雪崩**：Redis存放数据的方式是 key-value 的形式，拿数据时我们通过key去请求数据，此时如果请求的key大量过期，会导致跳过Redis 直接查询数据库，此时如果查询数量过多，会给数据库造成一个压力，解决方式可以考虑为key设置一个随机数的Random的过期时间，如果某一个key经常性的被频繁访问，可以考虑将该条key设置为热点key，永不过期；
* **缓存击穿**：跟穿透的区别在于，击穿是Redis上没有该条key的数据，但是数据库中存在，此时如果大量访问请求该条数据会将查询下沉到数据库层，数据库层的负载压力会骤增；

## 负载均衡

策略：轮询、权重分配、随机。哈希、用户自定义