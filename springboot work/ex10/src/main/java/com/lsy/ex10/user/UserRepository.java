package com.lsy.ex10.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where email = ?;
    Optional<User> findByEmail(String email);
//    Optional<User> findByEmail(String email);
//    @Query()
    //save(), findById(), findAll(), deleteById(), deleteAll()


}
