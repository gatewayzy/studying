# Springboot-MVC

## Springboot与微服务
* Spring的“编码-编译-web容器-启动”，Springboot内置Web容器，可以简化为3步的普通工程形式，用于构建微服务。
* 为了避免使用xml配置，Spring4.x版本推荐java注解和注解配置。springboot推荐无xml配置。

## 构建项目结构的过程
1. 在IDEA中新建工程，勾选Spring initializr，然后next。
2. 设置项目名称等参数，然后next并按需选取web、sql等项目依赖。
3. Finish并等待依赖下载完成。可以查看main和test的示例。

## 发布方式
* IDEA设置对应的active profile，运行主Application.java
* 或者maven运行`mvn spring-boot:run -Dspring.profiles.active=prod`方式发布项目
* 或者maven打包、java运行：`mvn install`、`java -jar -Dspring.profiles.active=prod springboot-mvc-demo.jar`

### 技术架构
|Name   |description   |
|:---:   |:---:  |
|Spring Boot   |Spring Microservice |
|Thymeleaf   |Template  |