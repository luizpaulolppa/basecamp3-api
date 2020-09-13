package com.basecamp3api.service;

import com.basecamp3api.dto.UserDTO;
import com.basecamp3api.entity.UserEntity;
import com.basecamp3api.exception.BusinessException;
import com.basecamp3api.mapper.UserMapper;
import com.basecamp3api.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Autowired
    private UserMapper userMapper;

    public UserDTO createNewUser(UserDTO user) {
        user.setId(null);

        if (user == null) {
            throw new BusinessException("User not found");
        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new BusinessException("Name not found");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new BusinessException("Email not found");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new BusinessException("Password not found");
        }

        UserEntity userEntity = userRepositoty.findByEmail(user.getEmail());
        if (userEntity != null) {
            throw new BusinessException("Email already exists");
        }

        UserDTO newUserDTO = userMapper.mapperTo(userRepositoty.save(new UserEntity(null, user.getName(), user.getEmail(), user.getPassword())));
        newUserDTO.setPassword(null);
        return newUserDTO;
    }
}
