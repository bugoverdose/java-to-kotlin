package com.example.javaspring.service;

import com.example.javaspring.config.BadRequestException;
import com.example.javaspring.config.DataNotFoundException;
import com.example.javaspring.db.UserEntity;
import com.example.javaspring.db.UserModel;
import com.example.javaspring.db.UserRepository;
import com.example.javaspring.service.command.CreateUser;
import com.example.javaspring.service.command.EditUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getMe(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(()->new DataNotFoundException());
        return new UserModel(user);
    }

    public UserModel getByName(String name) {
        UserEntity user = userRepository.findByName(name).orElseThrow(DataNotFoundException::new); // 위의 람다식과 동일
        return new UserModel(user);
    }

    public Page<UserModel> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserModel::new); // .map((user) -> new UserModel(user))과 동일
    }

    public UserModel createUser(CreateUser command){
        if (userRepository.findByName(command.getName()).isPresent())
            throw new BadRequestException("이미 사용되는 이름입니다.");
        UserEntity user = userRepository.save(command.toEntity());
        return new UserModel(user);
    }

    public UserModel editUser(EditUser command, Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow(DataNotFoundException::new);
        if (command.getName() == null && command.getAge() == null) // 방어로직. 불필요한 트랜잭션 작업 방지
            throw new BadRequestException("수정 사항이 없습니다.");
        if (command.getName() != null) // 수정하기 위해 값을 입력받은 필드만 변경되어 저장됨
            user.setName(command.getName());
        if(command.getAge() != null) // 일일이 null 값 여부 체크 필요
            user.setAge(command.getAge());
        // JPA 영속성 컨텍스트에 의해 값을 수정하면 최종적으로 해당 값에 부합하도록 트랜잭션 보내짐
        return new UserModel(user);
    }
}

