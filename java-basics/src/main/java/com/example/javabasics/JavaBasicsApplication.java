package com.example.javabasics;

public class JavaBasicsApplication {

    public static void main(String[] args) {

        // 1) System.out은 표준 출력 (System.in은 표준 입력)
        System.out.println("Hello World!"); // Hello World!

        // 2) 변수 선언시 일반적으로 자료형을 앞에 명시해줘야 함
        String normalWay = "abc";
        System.out.println(normalWay); // abc

        // 3) Local Variable Type Inference : Java 10부터 자료형 자동 추론 기능 추가
        var whatAmI = 10;
        var whoAmI = 10.0;
        var whereAmI = "Bye World!";
        System.out.println(whatAmI); // 10
        System.out.println(whoAmI); // 10.0
        System.out.println(whereAmI); // Bye World!

        // 4) 참조 자료형의 경우 동적 메모리에 생성한 인스턴스를 가리키고 있지 않으면 null이 디폴트 값
        DefaultRefType refsNotInitialized = new DefaultRefType();
        System.out.println(refsNotInitialized); // DefaultRefType{name='null', age=0, car=null}

        // 5) 원시 자료형은 null이 될 수가 없음.
        // refsNotInitialized.setAge(null) // 컴파일 에러.

        // 6) new 키워드로 생성자 사용하여 인스턴스 생성.
        JavaDeveloper baby1 = new JavaDeveloper("리하", 110);
        System.out.println(baby1);
        // JavaDeveloper{name='리하', age=110, message='응애! 나 애기 자바 개발자!'}

        // 7) setter를 통해 멤버변수 값 수정 (캡슐화)
        JavaDeveloper baby2 = new JavaDeveloper("지누", 1, "웅 아무것도 몰라요");
        System.out.println(baby2);
        // JavaDeveloper{name='지누', age=1, message='웅 아무것도 몰라요'}
        baby2.setAge(30);
        baby2.setMessage("사실 아직도 잘 몰라요");
        System.out.println(baby2);
        // JavaDeveloper{name='지누', age=30, message='사실 아직도 잘 몰라요'}
    }
}
