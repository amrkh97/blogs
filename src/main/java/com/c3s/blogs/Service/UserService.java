package com.c3s.blogs.Service;

import com.c3s.blogs.Entity.UserModel;
import com.c3s.blogs.Repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepo repository;

    public List<UserModel> getUsers() {

        return repository.findAll();
    }

    public UserModel addUser(UserModel userModel){
        UserModel model = repository.findByUserName(userModel.getUserName());
        if(model != null)
            return model;
        else
            return repository.save(userModel);
    }

    public List<UserModel> getUserByFirstName(String firstName){
        return repository.findAllByFirstName(firstName);
    }

    public List<UserModel> getUserByLastName(String lastName){
        return repository.findAllByLastName(lastName);
    }

    public UserModel getUserByUserName(String UserName){
        return repository.findByUserName(UserName);
    }

    public Boolean deleteUserById(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
