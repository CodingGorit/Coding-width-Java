# Coding-with-Java  

Java项目整合 

# 一、Java 从入门到精通学习笔记  
@see [Java 从入门到精通](https://www.yuque.com/u300253/learnjava)

### 1.1 Java SE篇 (已更新完毕)
1. [JavaSE 基础语法篇](https://www.yuque.com/u300253/learnjava/java_se_01)

2. [JavaSE 面向对象篇（类的基本结构）](https://www.yuque.com/u300253/learnjava/java_se_02)

3. [Java SE （面向对象篇 ——封装、继承、多态、抽象）](https://www.yuque.com/u300253/learnjava/java_se_03)

4. [Java 内置 API 学习](https://www.yuque.com/u300253/learnjava/java_se_04)

5. [Java 修饰符](https://www.yuque.com/u300253/learnjava/java_se_05)

6. [Java 中异常处理](https://www.yuque.com/u300253/learnjava/java_se_06)

7. [泛型与集合](https://www.yuque.com/u300253/learnjava/java_se_07)

8. [Java 的 IO 编程](https://www.yuque.com/u300253/learnjava/java_se_08)

9. [多线程编程](https://www.yuque.com/u300253/learnjava/java_se_09)

10. [Java 网络编程](https://www.yuque.com/u300253/learnjava/java_se_10)

11. [Java SE 高级特性](https://www.yuque.com/u300253/learnjava/java_se_11)

12. [Java JDBC 讲解【更新中~】]()  

### 1.2 Java EE篇
1. [Servlet 篇](https://www.yuque.com/u300253/learnjava/java_ee_01)  

2. [过滤器 与 监听器](https://www.yuque.com/u300253/learnjava/java_ee_02) 

3. [JSP ](https://www.yuque.com/u300253/learnjava/java_ee_03)  

# 二、项目预览   
### 2.1 Java SE 篇章
#### 2.1.1 基于 Java 实现简单的注册登录系统   
注意：   
1. 非数据库实现  
2. 使用 ArrayList 实现用户注册信息存储    

#### 2.1.2 基于 Java SE 的简单学生管理系统 Java SE 版  
1. 使用了数据库实现登录注册的功能   
2. 封装了 JDBC 实现简单的 BaseDao    
3. 使用 mysql 为数据库作为数据持久化  

### 2.2 Java EE 篇章  
#### 2.2.1 实现验证码的生成以及验证  (Java With CAPTCHA )  
verify code 由 servlet 生成  

#### 2.2.2 学生管理系统 Java EE 版本    
(StudentManagementAdvance  )  
> 此版本是在 JavaSE 的基础上进行了升级， 数据库不变，有三张表。可以进行简单的数据添加，修改，和删除的功能  

#### 2.2.3 Java EE 之简易购物车项目  (ShoppingMall)
项目简介： 
> 此项目为一个简单的 Java EE 小小购物车的项目，它具有最简单的登录，购物车页面展示（分页），添加购物车，下单，付款（使用支付宝沙箱完成此操作）  

#### 2.2.4 新增 Struct2 实现权限管理  （2020 5 19更新）  
> 使用 maven 构建 Java EE 项目，并导入 Struct2 依赖，使用 Struct2 的类拦截器实现简易的权限管理功能
