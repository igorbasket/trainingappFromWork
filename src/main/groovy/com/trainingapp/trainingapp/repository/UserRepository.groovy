package com.trainingapp.trainingapp.repository

import com.trainingapp.trainingapp.domain.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll()

    Optional<User> findByEmail(String email)

    Optional<User> findByName(String name)

    User findUserByEmail(String s)

    void delete(User user)

}