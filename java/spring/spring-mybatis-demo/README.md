# README
使用IDEA构建基本的Maven+Spring+Mybatis项目。

## 运行
* 运行环境
    * Maven3.2.5
    * jdk8
* 运行方法
    * IDE -> run on jetty.
    * OR mvn package -> tomcat.

## 构建项目结构的过程
1. 在idea新建工程，使用maven的maven-archetype-webapp架构，注意设置maven时添加参数archetypeCatalog=internal，否则创建之后要等很久才能得到完整的maven项目结构。
2. 对maven项目添加框架支持，如选用“SpringMVC”，下载的jar包使用pom.xml重新下载，包括添加私有仓库、查询http://mvnrepository.com/坐标。
3. 手工完善maven结构，一般有src/main/java+resources+webapp、src/test/java+resources。
4. 配置Spring，进行开发工作。

注意：
1. 如果jsp无法正常显示，可能是web.xml版本使用的是2.3太低，从其他文件拷贝3.0就可以了。
2. 如果jsp乱码，可以首行设置jsp的pageEncoding。
3. 如果显示java level为1.5，在pom.xml的build中指定maven-compiler-plugin-1.8。

## 配置Mybatis
* 配置数据库连接池，使用mybatis管理数据库session，并指定mapper配置文件。see <http://www.mybatis.org/mybatis-3/configuration.html>
* 编写mapper配置文件，代码中调用session的管理数据库。
* 配置ehcache缓存，启用ehcache的bean，指定ehcache配置文件。see <http://www.ehcache.org/ehcache.xsd>
* 编写ehcache配置文件，指定默认缓存策略和HashMap规则，在代码中根据name区分缓存策略。

## Spring事务管理
* 对数据库连接池使用spring的tx管理，避免手动编写getTransaction以及transaction.commit。
 
## Spring多线程
* ThreadLocal 虽然共享同一个bean对象，但是使用ThreadLocal避免线程冲突。

