# Spring

## Folder (MVC)
```
src/main/java
└── com.example.project
    ├── config
    │   └── SecurityConfig.java
    ├── aop
    │   └── ControllerLogging.java
    ├── controller
    │   └── UserController.java
    ├── service
    │   └── UserService.java
    ├── vo
    │   └── UserVO.java
    ├── entity
    │   └── User.java
    ├── repository
    │   └── UserRepository.java
    └── util
        └── DateUtils.java
```
   - Config
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

  
## DI
- IOC (Inversion of Control - 제어역전)

  객체 생성 및 생명 주기 관리를 개발자가 아닌 Spring IoC Container가 대신 수행
  개발자는 객체 생성에 신경 쓰지 않고, 필요한 의존성을 주입 받아 사용.

- DI (Dependency Injection - 의존성 주입)

  객체가 자신의 의존성을 스스로 생성하는 대신, 외부에서 주입 받음
  객체간의 강한 결합도 낮춤

    - Construct Injection (Spring 4.3 이후)
    - Field Injection
    - Setter Injection
 
- 작동원리
    1. Bean 정의 및 등록 - @Component, @Service, @Repository, @Configuration 등 클래스 스캔 Bean 등록
    2. 의존성 검색 및 주입 - IoC Container 의존성 확인 및 객체 주입
    3. 런타임시 의존성 사용 - 런타임시 서비스 수행
- DI Anotaition
  
    @Autowired: 자동 의존성 주입.
  
    @Qualifier: 특정 빈 이름을 명시해 주입.
  
    @Primary: 같은 타입의 여러 빈이 있을 때 우선순위를 지정.
  
    @Component, @Service, @Repository, @Controller: 빈으로 등록할 클래스를 표시.
  
    @Bean: Java Config에서 빈을 정의.

## AOP (Aspect-Oriented Programming - 관점 지향 프로그래밍)
  Cross-Cutting Concern (횡단 관심사)

  재사용성, 유지보수성, 가독성
    
- @Aspect
- Join Point (목표)
- @Pointcut (조건)
    - execution
    - within
    - @annotation ...
- Advice (실행)
    - @Before
    - @After
    - @Around
- Weaving
    - Apect와 비즈니스 로직 결확하는 과정

ex_) 로깅, 트랜잭션, 보안, 캐싱, 예외처리 ...

## Scheduling (Task)
  - @EnableScheduling
  - @Scheduled(cron = "0 0/1 * * * ?")  //초 분 시 일 월 요일 [년]

## Security
## Testing
  - Given-When-Then
      - assertEquals(a, b);
      - assertSame(a, b);
      - assertNotNull(a);
      - assertTrue(boolean);
  - Unit Test (단위 테스트) -> JUnit, Mockito .. 
  - Integration Test (통합 테스트) -> @SpringBootTest
