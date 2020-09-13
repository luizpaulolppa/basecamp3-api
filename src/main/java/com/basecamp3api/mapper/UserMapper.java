package com.basecamp3api.mapper;

import com.basecamp3api.dto.UserDTO;
import com.basecamp3api.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapperTo(UserEntity userEntity) {
        return new UserDTO(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getEmail(),
            userEntity.getPassword()
        );
    }
}
