# Java to Kotlin

### 목표

- Spring 어플리케이션들이 Java에서 Kotlin으로 넘어가고 있는 최신 트렌드에 대한 최소한의 이해
- Java와 Kotlin 문법 비교
- Kotlin에 관심이 있는 입문자들에게 도움이 되도록 만든 최소한의 예제 코드 제공
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

- Java : 참조 자료형 멤버변수들은 null이 디폴트 값. 주로 Optional을 활용. 모든 자료형이 null이 될 수는 있음. @Nullable도 지원됨.
- Kotlin : 모든 자료형에 대해 nullable 설정 가능. 때문에 safe call 등 null 값 체크 관련 기능이 많음.

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

1. Kotlin이라고 하면 안드로이드 개발, 함수형 프로그래밍만 생각하는 것이 일반적일 것이다. 하지만 Kotlin은 기본적으로 Java와 동일한 JVM 언어이므로 Java로 작성된 모든 코드들은 Kotlin으로 작성될 수 있다. 실제로 IntelliJ에서 Java 코드를 .kt 파일에 붙여넣을 경우 Kotlin 코드로 자동 변환되며, Kotlin 코드도 자바로 변환하여 볼 수 있다(Tools > Kotlin > Show Kotlin Bytecode > Decompile).
2. 현재 실무에서는 Java + Lombok 조합을 통해 코드 가독성과 생산성을 크게 개선하였다고는 하지만 이는 근본적인 해결책이 된다고 보기는 어려우며, 오히려 각 클래스의 구조에 대한 이해 없이 @Data를 남발하는 것은 지양해야 한다고 생각한다.

3. 이에 반해 Kotlin은 다양한 측면에서 Java의 단점을 해결해준다고 볼 수 있다. 실제로 [SpringInitializr](https://start.spring.io/)은 Java와 Kotlin으로 Spring 프로젝트를 셋업해주며, Java 코드를 Kotlin 코드로 리팩토링하는 작업은 전세계적인 흐름으로 보인다.

4. 본격적으로 Kotlin에 입문하고 싶다면 [Kotlin 공식문서](https://kotlinlang.org/docs/home.html)와 [Kotlin in Action](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791161750712&orderClick=LEa&Kc=) 추천한다.
