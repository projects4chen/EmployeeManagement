## 员工信息管理系统
实现工具：HTML + Servlet + JDBC（Druid）  
支持的功能：
- 登录（带验证码）
- 员工信息的删改查（只有管理员可以）

Web使用流程：  
（1）员工登录 -> 欢迎页面  
（2）管理员登录 -> 员工信息页面 -> 可删改  

### 总结
1、用Druid管理数据库连接，以及事务（begin(); commit(); rollback();）  
2、用对象封装数据库中的记录  
3、写代码的顺序（自底向上）：Dao -> Service -> Servlet  
- 在Dao层用QueryRunner执行SQL语句  
- 在Service层用事务执行Dao层定义的行为
- 在Servlet层接收参数，调用Service层的服务，然后返回结果

4、逻辑和展示分离  
5、用Filter实现权限认证和乱码处理

