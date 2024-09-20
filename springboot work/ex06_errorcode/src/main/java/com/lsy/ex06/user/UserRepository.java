package com.lsy.ex06.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where email = ?;
    Optional<User> findByEmail(String email);
//    @Query()
    //save(), findById(), findAll(), deleteById(), deleteAll()


}
