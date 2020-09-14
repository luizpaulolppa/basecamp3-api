package com.basecamp3api.service;

import com.basecamp3api.dto.UserAuthDTO;
import com.basecamp3api.dto.UserDTO;
import com.basecamp3api.entity.UserEntity;
import com.basecamp3api.exception.BusinessException;
import com.basecamp3api.mapper.UserMapper;
import com.basecamp3api.repository.UserRepositoty;
import com.basecamp3api.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserAuthDTO authUser(UserDTO userDTO) {
        if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
            throw new BusinessException("Email not found");
        }

        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            throw new BusinessException("Password not found");
        }

        UserEntity userEntity = userRepositoty.findByEmail(userDTO.getEmail());
        if (userEntity == null) {
            throw new BusinessException("Email or Password don't exist");
        }

        User userDetails = new User(userEntity.getEmail(), "", new ArrayList());
        String token = jwtTokenUtil.generateToken(userDetails);

        UserDTO userDTOMapped = userMapper.mapperTo(userEntity);
        userDTOMapped.setPassword(null);
        return new UserAuthDTO(userDTOMapped, token);
    }
}
