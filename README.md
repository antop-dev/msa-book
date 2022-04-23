# msa-book

자바 기반의 마이크로서비스 이해와 아키텍처 구축하기

![](https://i.imgur.com/PZ4jtJ1.png)

책에서 나온 예제를 기반으로 아래 스택으로 재개발 해본다.

* [Microsoft OpenJDK 11.x](https://www.baeldung.com/java-11-new-features)
* [Spring Boot 2.6.7](https://spring.io/projects/spring-boot)
* [Spring Cloud 3.1.1](https://spring.io/projects/spring-cloud)

Spring Cloud 최신 버전에서는 [대부분의 Netflix 프로젝트를 사용하지 않게 됐다](https://spring.io/blog/2018/12/12/spring-cloud-greenwich-rc1-available-now).

| Current                     | Replacement                                       |
|:----------------------------|:--------------------------------------------------|
| Hystrix                     | Resilience4j                                      |
| Hystrix Dashboard / Turbine | Micrometer + Monitoring System                    |
| Ribbon                      | Spring Cloud Loadbalancer                         |
| Zuul 1                      | Spring Cloud Gateway                              |
| Archaius 1                  | Spring Boot external config + Spring Cloud Config |
