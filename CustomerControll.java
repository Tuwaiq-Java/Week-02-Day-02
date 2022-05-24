package model.springex.controll;

import model.springex.Customer;
import model.springex.ResponsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerControll {

    public ArrayList<Customer> users=new ArrayList();

    @GetMapping( "customer")
    public ResponseEntity<ArrayList<Customer>> getUser(){
        return ResponseEntity.status(200).body(users);
    }

    @PutMapping( "customer/deposit/{id}")
    public ResponseEntity editDeposit(@PathVariable int id, @RequestBody int amount ){
        if(id> users.size()-1 || id<0){
            return ResponseEntity.status(400).body(new ResponsApi("something wrong"));
        }
        users.get(id).setBalance(users.get(id).getBalance()+amount);
        return ResponseEntity.status(201).body(new ResponsApi(" money added."));
    }

    @PutMapping( "customer/withdraw/{id}")
    public ResponseEntity editWithdraw(@PathVariable int id, @RequestBody int amount ){
        if(users.get(id).getBalance()<amount){
            return ResponseEntity.status(400).body(new ResponsApi("your balance is less "));
        }
        users.get(id).setBalance(users.get(id).getBalance()-amount);
        return ResponseEntity.status(201).body(new ResponsApi(" withdraw done . your balance now = "+(users.get(id).getBalance())));
    }

    @PutMapping( "customer/transfer/{id1}/{id2}")
    public ResponseEntity transfer(@PathVariable int id1,@PathVariable int id2, @RequestBody int from ){
        users.get(id1).setBalance(users.get(id1).getBalance() - from);
        users.get(id2).setBalance(users.get(id2).getBalance()+ from);
        return ResponseEntity.status(201).body(new ResponsApi(" transfer done ."));
    }


    @PostMapping( "customer")
    public ResponseEntity<ResponsApi> addCustomer(@RequestBody Customer user){
        users.add(user);
        return ResponseEntity.status(201).body(new ResponsApi("User "+ user.getUsername()+" added "));
    }

    @PutMapping( "customer/{index}")
    public ResponseEntity<ResponsApi> editCustomer(@PathVariable Integer index ,@RequestBody Customer user){
        users.set(index,user);
        if(index> users.size()-1 || index<0){
            return ResponseEntity.status(400).body(new ResponsApi(" index not found "));
        }
        return ResponseEntity.status(201).body(new ResponsApi("User "+ user.getUsername()+" update to list."));
    }
    @DeleteMapping ( "customer/{index}") //danger
    public ResponseEntity<ResponsApi> deleteCustomer(@PathVariable Integer index){ // should have same name
        if(index> users.size()-1 || index<0){
            return ResponseEntity.status(400).body(new ResponsApi(" index not found "));
        }
        users.remove((int)index);
        return ResponseEntity.status(201).body(new ResponsApi("User deleted."));
    }



}
