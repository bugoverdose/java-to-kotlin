package com.example.javaspring.db;

import com.example.javaspring.util.GetColor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

@Data // Lombok 어노테이션. getter/setter, toString 등의 메서드 자동 생성
public class UserModel { // model은 Front로 보낼 응답에 사용될 객체의 형식

    Long id;
    String name;
    Long age;
    String favColor; // 실제 DB 테이블에 저장된 User 엔티티의 형식과 달라도 됨

    public UserModel(UserEntity e){
        this(e, null, null); // this() : 내부의 다른 생성자 호출
    }

    public UserModel(
            UserEntity e,
            String colorInput,
            String randomColor
    ) {
        if (colorInput == null) {
            if (randomColor == null)
                randomColor = GetColor.randomColor(new ArrayList<String>(Collections.emptyList()));
            colorInput = randomColor;
        }
        this.id = e.id;
        this.name = e.name;
        this.age = e.age;
        this.favColor = colorInput;
    }
}