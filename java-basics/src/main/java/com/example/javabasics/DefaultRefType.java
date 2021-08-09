package com.example.javabasics;

public class DefaultRefType {

    public String name; // String도 참조 자료형이므로 null로 초기화
    public int age; // int는 0으로 초기화
    public Car car; // 참조 자료형이므로 null로 초기화

    public class Car {
        public int price = 10;
    }

    // 별도의 생성자가 없으므로 컴파일러에 의해 자동으로 디폴트 생성자 추가됨
    // public DefaultRefType() {}

    // Alt + Insert를 통해 게터/세터, 생성자, toString 등 전부 코드 자동 생성 가능
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // DefaultRefType 인스턴스를 가리키는 참조변수를 콘솔에 출력하면 toString 메서드가 호출됨
    // 원래는 참조값(메모리 주소 값)이 출력되지만 해당 형식으로 출력되도록 override하는 것이 일반적
    @Override
    public String toString() {
        return "DefaultRefType{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
