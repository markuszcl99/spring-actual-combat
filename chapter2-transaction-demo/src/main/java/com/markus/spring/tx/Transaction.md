# 一、事务传播特性？
> Spring共提供7中事务传播特性，分别为以下几种：

- Propagation.REQUIRED
  - 当前有事务 就用当前的，没有就用新的
- Propagation.SUPPORT
  - 事务可有可无，不是必须的
- Propagation.MANDATORY
  - 必须要求有事务，不然就抛异常
- Propagation.REQUIRED_NEW
  - 无论是否有事务，都创建一个新的事务
- Propagation.NOT_SUPPORT
  - 不支持事务，按非事务方式执行
- Propagation.NEVER
  - 不支持事务，如果有事务则抛出异常
- Propagation.NESTED
  - 当前有事务就在当前事务里再起一个事务

# 二、事务隔离特性？
> 在事务隔离特性上，分为以下几种：

- ISOLATION.DEFAULT
  - 默认的隔离级别，和JDBC事务隔离级别保持一致
- ISOLATION.READ_UNCOMMITTED
  - 读未提交，可能会造成脏读、不可重复读、幻读的情况
- ISOLATION.READ_COMMITTED
  - 读已提交，能解决脏读问题，还是会造成不可重复读、幻读的情况
- ISOLATION.REPEATABLE_READ
  - 可重复读，能解决脏读、不可重复读问题，解决不了幻读问题
- ISOLATION.SERIALIZABLE
  - 可串行读，能解决脏读、不可重复读、幻读问题

# 三、什么是脏读、不可重复读、幻读？
## 1、脏读
A事务读取B事务尚未提交的数据，此时如果B事务发生错误并执行回滚操作，那么A事务读取到的数据就是脏数据
## 2、不可重复读
A事务多次读取同一条数据，但在上一次读取后下一次读取前，B事务提交了该数据的修改操作，则会造成A事务前后读取不一致的情况
## 3、幻读
事务A在执行读取操作，需要两次统计数据的总量，前一次查询数据总量后，此时事务B执行了新增数据的操作并提交后，这个时候事务A读取的数据总量和之前统计的不一样，就像产生了幻觉一样，平白无故的多了几条数据，成为幻读。
## 4、如何解决？
通过事务隔离特性解决上述问题，对于读未提交、读已提交事务隔离级别实现比较简单，在事务级别即可保证，对于可重复读、可串行读都是通过对数据加锁实现