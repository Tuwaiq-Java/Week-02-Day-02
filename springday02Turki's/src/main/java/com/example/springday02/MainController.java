package com.example.springday02;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MainController {

    ArrayList<String> user = new ArrayList<>();




    @GetMapping("npuser")
    public ResponseEntity getUser(){
        return ResponseEntity.status(HttpStatus.OK).body(user);

    }


    @PostMapping("npuser")
    public ResponseEntity<String > addUser(@RequestBody String username){
        user.add(username);
        return ResponseEntity.status(HttpStatus.CREATED).body("user " + username + " added");
                //"user " + username + " added";

    }


    @PutMapping("npuser/{index}")
    public String updateUser(@RequestBody String upUs , int index){
        user.set(index , upUs);
        return "user updated";
    }



    @DeleteMapping("npuser/{index}")
    public ArrayList<String> removeUser(@PathVariable int index){
        user.remove(index);
        return user;

    }








}
