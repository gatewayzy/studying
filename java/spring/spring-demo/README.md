# README
使用IDEA构建基本的Maven+Spring项目。

## 运行
* IDE -> run on jetty.
* or mvn package -> tomcat.

## 构建项目结构的过程
1. 在idea新建工程，使用maven的maven-archetype-webapp架构，注意设置maven时添加参数archetypeCatalog=internal，否则创建之后要等很久才能得到完整的maven项目结构。
2. 对maven项目添加框架支持，如选用“SpringMVC”，下载的jar包使用pom.xml重新下载，包括添加私有仓库、查询http://mvnrepository.com/坐标。
3. 手工完善maven结构，一般有src/main/java+resources+webapp、src/test/java+resources。
4. 配置Spring，进行开发工作。

注意：
1. 如果jsp无法正常显示，可能是web.xml版本使用的是2.3太低，从其他文件拷贝3.0就可以了。
2. 如果jsp乱码，可以首行设置jsp的pageEncoding。
3. 如果显示java level为1.5，在pom.xml的build中指定maven-compiler-plugin-1.8。

## Spring的核心
* Spring的核心主要是AOP和IOC。此外，提供文件资源管理、定时任务、事务管理等高级功能。
* IOC, inverse of controll，控制反转
    * 原来的对象散落在代码中，难以管理，Spring可以用context统一管理
    * 比如xml中分别定义了一个user和role，然后在代码中@Autowired自动调用。
* AOP 面向切面编程
    * 有@Around、@Before、@After等方法。