## Spring Boot 
### 简介
* 项目地址：[Github: spring-projects/spring-boot](https://github.com/spring-projects/spring-boot)，以下内容也参考自github。
* spring boot在Spring生态中的位置属于spring之上，对spring进行了封装和简化。
* 特点：
    * 支持java -jar方式或传统war发布的方式部署独立的java应用
    * 大量使用默认配置，开发工作更加轻便
    * 提供大量非功能性特性，如嵌入式服务器、安全、运行状态检查、外部配置等
    * 不生成代码，完全无需XML配置
* 常用模块简介
    1. spring-boot  核心代码
        * 核心部分，是其他模块的基础。
        * 提供SpringApplication类，支持用程序发布应用，该类最主要功能就是创建和刷新合适的spring上下文（ApplicationContext）。
        * 内置web应用容器，暂时支持tomcat和jetty。一般Spring Boot默认用tomcat。
        * first class 外部化配置支持
        * 便捷的上下文initializers，比如支持显示的日志配置
    2. spring-boot-autoconfigure  自动配置
        * Spring Boot可以根据类路径下的内容来配置常用应用的大部分内容。常用@EnableAutoConfiguration注解自动配置上下文。
        * autoconfigure自动配置会推断用户可能需要的bean是什么。比如，用户没有配置任何数据库链接，但是classpath里有HSQLDB，那么自动配置会推断用户可能希望定义HSQLDB内存数据库。
        * 当然，如果用户已经定义bean了，自动配置就会退后了。
    3. spring-boot-starters  快速使用
        * 该模块提供方便的依赖描述符供应用程序引用。
        * starters像是一个一站式商店，打包了各种spring和相关技术套餐，而不需要写清各种依赖。比如一个spring-boot-starter-data-jpa直接包括了spring和jpa各种依赖。
    4. spring-boot-cli  命令行
        * cli是command line命令行应用模块，它编译和运行Groovy代码，编写一个应用程序的代码量可以很小（参见github中的spring-boot-cli/samples）。
        * cli还可以监控文件，在文件变动时自动重新编译和重启。
    5. spring-boot-actuator  执行器
        * actuator执行器提供额外的自动配置功能，比如可以为一个JSON web服务提供服务器、安全、日志、外部配置、管理端点、审计抽象等功能。
        * actuator提供方便快捷的功能开关、扩展、替换
    6. spring-boot-loader  加载器
        * loader加载器可以帮助构建以java -jar方式运行的jar文件。通常并不需要使用loader，而是使用maven或者gradle进行构建。
* Github中的示例代码：
    * 除了cli使用的是Groovy语言，所以示例代码在其内部外，其他模块都是java代码，示例代码都在spring-boot-samples文件夹中
    * java示例代码使用方法：使用maven build，然后运行`java -jar target/<sample>.jar`进行调用
* Github中给出的推荐教学
    * [Building an Application with Spring Boot](http://spring.io/guides/gs/spring-boot/) ：创建简单的应用并运行，添加一些管理服务。
    * [Building a RESTful Web Service with Spring Boot Actuator](http://spring.io/guides/gs/actuator-service/)：创建REST web服务，配置server。
    * [Converting a Spring Boot JAR Application to a WAR](http://spring.io/guides/gs/convert-jar-to-war/)：将应用以war方式运行到web容器。
    
        