package com.example.springday02.controllers;

import com.example.springday02.model.ResponseApi;
import com.example.springday02.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {


    private ArrayList<User> users=new ArrayList<>();


    @GetMapping("user")
    public ResponseEntity<ArrayList<User>> getUsers(){
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("user/{index}")
    public ResponseEntity<User> getOneUser(@PathVariable int index){
        return ResponseEntity.status(200).body(users.get(index));
    }

    @PostMapping("user")
    public ResponseEntity<ResponseApi> addUser(@RequestBody User user){
        if(user.getPassword().length()<6){
            return ResponseEntity
                    .status(400)
                    .body(new
                            ResponseApi( "Your password length must be more than 6 char",400));
        }
        users.add(user);
        return ResponseEntity.status(201).body(new ResponseApi( "User "+user.getUsername()+" Added to the list",200));
    }

    @PutMapping("user/{index}")
    public ResponseEntity<ResponseApi> updateUser(@RequestBody User user, @PathVariable Integer index){
        if(index>users.size()-1){
            return ResponseEntity.status(400).body(
                    new ResponseApi("The index "+index+" is more than array length "+users.size(),200));
        }
        users.set(index,user);
        return ResponseEntity.status(200).body(
                new ResponseApi("User "+user.getUsername()+" updated",200));
    }

    @DeleteMapping("user/{index}")
    public ResponseEntity<ResponseApi> deleteUsers(@PathVariable Integer index){
        if(index>users.size()-1){
            return ResponseEntity.status(400).body(
                    new ResponseApi("The index "+index+" is more than array length "+users.size(),200));
        }
        users.remove((int)index);
        return ResponseEntity.status(200).body(new ResponseApi("User with index "+index+" deleted",200));
    }
}
