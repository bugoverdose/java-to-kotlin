# Java to Kotlin

### 목표

- Java와 Kotlin 문법 비교
- 왜 Spring 서버 개발을 코틀린으로 하는가에 대한 이해
- Kotlin 입문에 도움이 되도록 만든 최소한의 예제 코드 제공
- 소스 코드만으로도 어느정도 내용 이해되도록 주석으로 설명 달기
  <br></br>

### 1부: 코틀린 입문

- 예제 코드: [java-basics](https://github.com/bugoverdose/java-to-kotlin/blob/master/java-basics/src/main/java/com/example/javabasics/JavaBasicsApplication.java), [kotlin-basics](https://github.com/bugoverdose/java-to-kotlin/blob/master/kotlin-basics/src/main/kotlin/com/example/kotlinbasics/KotlinBasicsApplication.kt)

#### 표준 출력 문법과 중괄호 여부

- Java : System.out.println("Hello World!");
- Kotlin : println("Hello World!")

#### var의 차이

- Java : 지역 변수 자료형 추론 (JS의 let과 유사)
- Kotlin : 수정 가능한 변수로 선언 (Java의 디폴트 자료 선언 방식; val vs var)

#### nullable 타입

- Java : 참조 자료형 멤버변수들은 null이 디폴트 값. 주로 Optional을 활용. 모든 자료형이 null이 될 수는 있음. @Nullable도 지원되기는 함.
- Kotlin : 모든 자료형에 대해 nullable 설정 가능. 때문에 safe call 등 null 값 체크 관련 기능이 많음

#### 생성자

- Java : {} 내부에 멤버변수들 선언 => {} 내부에 선언한 멤버변수들을 매개변수로 받는 생성자 정의하여 사용. => new 키워드 필요.
- Kotlin : 클래스 정의 첫 줄에 ()에 생성자로 사용할 매개변수들 지정. 해당 변수들은 {} 내부에 별도로 작성 불필요. => new 키워드 불필요. 가독성 증가

#### 클래스

- Java : getter, setter, toString 등 전부 {} 내부에 구현 필요
- Kotlin : getter, setter 불필요. data class로 선언하면 toString 등의 메서드 전부 자동 생성됨

#### 스코프 함수(let, also 등)

- Kotlin 문법의 꽃. 간단한 작업들을 체이닝하는 데 용이.
  <br></br>

### 2부: Spring 프로젝트 코드 비교 예제

- 예제 코드: [java-spring](https://github.com/bugoverdose/java-to-kotlin/blob/master/java-spring/src/main/java/com/example/javaspring/JavaSpringApplication.java), [kotlin-spring](https://github.com/bugoverdose/java-to-kotlin/blob/master/kotlin-spring/src/main/kotlin/com/example/kotlinspring/KotlinSpringApplication.kt)

#### 코드 내용 요약

- Spring Boot + JPA를 통한 CRUD 기초
- Controller - Service - Repository 구조.
- Request DTO, command, model, entity를 통한 객체 유형 세분화
- @PostContruct를 통한 앱 구동 시점에 작업 실행하는 방법.
- ExceptionHandler를 통한 요청에 대한 예외 처리 방식 설정. 커스텀 Exception Type 정의 방법.
  <br></br>

### 정리

1. Kotlin이라고 하면 안드로이드 개발, 함수형 프로그래밍만 생각하는 것이 일반적일 것. 하지만 Kotlin은 기본적으로 Java와 동일한 JVM 언어이므로 Java로 작성된 모든 코드들은 Kotlin으로 작성될 수 있다. 또한 높은 코드 가독성, null 값에 대한 다양한 처리 기능 등 다양한 기능을 통해 Java가 지닌 가장 큰 단점인 verbosity를 보완한다고 볼 수 있다.

2. 현재 실무에서는 Java + Lombok 조합을 통해 생산성을 크게 개선하였다고는 하지만 이는 근본적인 해결책이 되지 않는다고 보인다. 오히려 각종 클래스의 구조에 대한 이해 없이 @Data를 남발하게 되면 프로그램의 안정성이 감소할 것으로 생각됨. 또한 게터/세터를 무분별하게 자동생성하면 객체지향의 핵심요소 중 하나인 캡슐화를 어길 위험이 증가한다고 생각됨(final 키워드로 예방은 가능).

3. 서비스 로직 개발의 측면에서 Kotlin은 조건문에서 활용하기 용이한 각종 기능을 제공하기 때문에 높은 코드 가독성으로 안정성 높은 코드를 개발할 수 있도록 지원한다고 볼 수 있다. (물론 불필요한 scope function의 남발은 depth를 증가시키는 등 올바르지 못한 코틀린 코드는 오히려 자바 코드 이하의 코드 가독성을 지니게 될 수도 있다.) 실제로 Java 코드를 Kotlin 코드로 리팩토링하는 작업은 전세계적인 흐름으로 보임.
