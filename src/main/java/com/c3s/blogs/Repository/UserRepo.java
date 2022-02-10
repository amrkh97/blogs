package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
    UserModel findByUserName(String name);
    List<UserModel> findAllByFirstName(String firstName);
    List<UserModel> findAllByLastName(String lastName);
}