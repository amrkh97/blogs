package com.c3s.blogs.Controller;

import com.c3s.blogs.Entity.ResponseModel;
import com.c3s.blogs.Entity.UserModel;
import com.c3s.blogs.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class UserController {
    @Autowired
    private UserService service;


    @GetMapping("/user/all")
    public ResponseEntity<List<UserModel>> findAllUsers() {
        return ResponseEntity.ok()
                .body(service.getUsers());
    }

    @PostMapping("/user/add")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok()
                .body(service.addUser(userModel));
    }

    @PutMapping("/user/update")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok()
                .body(service.addUser(userModel));
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    public ResponseEntity<UserModel> getUserByUserName(@PathVariable(name = "username") String userName){
        return ResponseEntity.ok()
                .body(service.getUserByUserName(userName));
    }

    @GetMapping("/user/find")
    @ResponseBody
    public ResponseEntity<List<UserModel>> getUserByFirstNameOrLastName(@RequestParam(name = "firstname") String firstName,
                                                                        @RequestParam(name = "lastname") String lastName){
        if(firstName != null) {
            return ResponseEntity.ok()
                    .body(service.getUserByFirstName(firstName));
        }
        if(lastName != null) {
            return ResponseEntity.ok()
                    .body(service.getUserByLastName(lastName));
        }

        return ResponseEntity.ok()
                .body(null);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<ResponseModel> deleteUserByID(@PathVariable("id") Long id){
        int responseCode = -1;
        String responseMessage = "";
        try{
            service.deleteUserById(id);
            responseCode = 200;
            responseMessage = String.format("User With ID: %d Deleted Successfully", id);
            return ResponseEntity.ok()
                    .body(new ResponseModel(responseCode, responseMessage));
        }catch(Exception e){
            responseCode = 404;
            responseMessage = String.format("User With ID: %d Does Not Exist", id);
            return ResponseEntity.status(responseCode)
                    .body(new ResponseModel(responseCode, responseMessage));
        }
    }

}
