## Spring study

```
src/main/java
└── com.example.project
    ├── aop
    │   └── ControllerLogging.java
    ├── controller
    │   └── UserController.java
    ├── service
    │   └── UserService.java
    ├── repository
    │   └── UserRepository.java
    ├── entity
    │   └── User.java
    ├── vo
    │   └── UserVO.java
    ├── config
    │   └── SecurityConfig.java
    └── util
        └── DateUtils.java

```

 - ### Folder (MVC)
   - Configuration
     - Project Setting
   - Aop
     - AOP Setting
   - Controller
     - RESTful API
     - Client Request / Response Service Connect
   - Service
     - Controller And Repository Connect
   - Vo
     - Client And Data Connect
     - 민감한 정보 X
   - Entity (JPA)
     - Data Table Mapping
     - 민감한 정보 O
   - Repository (JPA)
     - DataBase Connect
   - Util
     - Public Util Code
    
  
 - ### DI (Dependency Injection)

    Construct Injection (Spring 4.3 이후)

    Field Injection

    Setter Injection

   - AOP
   - DI
   - IOC
