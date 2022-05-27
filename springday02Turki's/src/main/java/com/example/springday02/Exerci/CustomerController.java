package com.example.springday02.Exerci;


import com.example.springday02.model.Deposit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    ArrayList<String> customers = new ArrayList<>();


    @GetMapping("customer")
    public ResponseEntity getCustomer() {
        return ResponseEntity.status(HttpStatus.OK).body(customers);

    }

    @PostMapping("customer")
    public ResponseEntity<String> addCustomer(@RequestBody String custname) {
        customers.add(custname);
        return ResponseEntity.status(HttpStatus.CREATED).body("The Customer" + custname + "added");

    }

    @PutMapping("customer/{index}")
    public ResponseEntity<String> updateCustomer(@RequestBody Integer index, String upcustname) {
        customers.set(index, upcustname);
        return ResponseEntity.status(HttpStatus.CREATED).body("The Customer" + upcustname + "updated");



    }
//
    @DeleteMapping("customer/{index}")
    public ResponseEntity<ArrayList<String>> removeCustomer(@PathVariable int index ){
        customers.remove(index);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body( customers);
    }



    @PostMapping("customer/{index}")
    public ResponseEntity depositToCust(@RequestBody String customerDe , int index , Deposit deposit){
        if(index > customers.size()-1){
            System.out.println("invalid index!!");

        }
        return ResponseEntity.status(HttpStatus.OK).body(deposit.getID());


         //return ResponseEntity.status(HttpStatus.ACCEPTED).body( customers);
    }
//
//    @PutMapping("customer")
//    public ResponseEntity withdraw(){
//
//    }
//
//
//    @PostMapping("customer")
//    public ResponseEntity transferMoney(String ID1 , String ID2){
//
//
//
//
//    }






}
