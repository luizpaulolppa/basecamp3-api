package com.basecamp3api.repository;

import com.basecamp3api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoty extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String email);
}
