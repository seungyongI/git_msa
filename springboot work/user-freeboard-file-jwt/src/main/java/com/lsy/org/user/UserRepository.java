package com.lsy.org.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where email = ?;
    Optional<User> findByEmail(String email);
//    Optional<User> findByEmail(String email);
//    @Query()
    //save(), findById(), findAll(), deleteById(), deleteAll()


}
