package com.example.banksystem.controllers;

import com.example.banksystem.model.Customer;
import com.example.banksystem.model.Response;
import com.example.banksystem.model.Transfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
public class BankController {


    private final ArrayList<Customer> customers = new ArrayList();


    @GetMapping
    public ResponseEntity<ArrayList<Customer>> getCustomers() {
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping
    public ResponseEntity<Response> addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(201).body(new Response("New customer added", 201));
    }

    @PutMapping("/{index}")
    public ResponseEntity<Response> updateCustomer(@RequestBody Customer customer,
                                                   @PathVariable Integer index) {
        if (index >= customers.size() || index < 0) {
            return ResponseEntity.status(400).body(new Response("Invalid index", 400));
        }
        customers.set(index, customer);
        return ResponseEntity.status(200).body(new Response("Customer updated", 200));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable Integer index) {
        if (index >= customers.size() || index < 0) {
            return ResponseEntity.status(400).body(new Response("Invalid index", 400));
        }
        customers.remove((int) index);
        return ResponseEntity.status(200).body(new Response("Customer deleted", 200));
    }


    @PutMapping("/deposit")
    public ResponseEntity<Response> deposit(@RequestBody Transfer transfer) {
        if (transfer.getAmount() < 0) {
            return ResponseEntity.status(400).body(new Response("Invalid amount", 400));
        }
        Customer currentCustomer = getCustomerFromId(transfer.getId());
        if (currentCustomer == null) {
            return ResponseEntity.status(400).body(new Response("Invalid id", 400));
        }
        Integer oldBalance = currentCustomer.getBalance();
        currentCustomer.setBalance(oldBalance + transfer.getAmount());
        return ResponseEntity.status(200).body(new Response("Deposit completed", 200));
    }

    @PutMapping("/withdraw")
    public ResponseEntity<Response> withdraw(@RequestBody Transfer transfer) {
        if (transfer.getAmount() <= 0) {
            return ResponseEntity.status(400).body(new Response("Invalid amount", 400));
        }

        Customer currentCustomer = getCustomerFromId(transfer.getId());
        if (currentCustomer == null) {
            return ResponseEntity.status(400).body(new Response("Invalid id", 400));
        }
        if (currentCustomer.getBalance() < transfer.getAmount()) {
            return ResponseEntity.status(400).body(new Response(
                    "You don't have enough balance to complete the withdraw", 400));
        }
        Integer oldBalance = currentCustomer.getBalance();
        currentCustomer.setBalance(oldBalance - transfer.getAmount());
        return ResponseEntity.status(200).body(new Response("Withdraw completed", 200));

    }

    @PutMapping("/transfer/{fromId}/{toId}/{amount}")
    public ResponseEntity<Response> transfer(@PathVariable String fromId,
                                             @PathVariable String toId, @PathVariable Integer amount) {

        Customer fromCustomer=getCustomerFromId(fromId);
        Customer toCustomer=getCustomerFromId(toId);

        if(fromCustomer==null || toCustomer==null){
            return ResponseEntity.status(400).body(new Response("Invalid id", 400));
        }

        if(fromCustomer.getBalance()<amount){
            return ResponseEntity.status(400).body(new Response(
                    "You don't have enough balance to complete the transfer", 400));
        }

        withdraw(new Transfer(fromCustomer.getId(),amount));
        deposit(new Transfer(toCustomer.getId(),amount));

        return ResponseEntity.status(200).body(new Response("Transfer completed", 200));
    }


    public Customer getCustomerFromId(String id) {
        for (int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = customers.get(i);
            if (currentCustomer.getId().equals(id)) {
                return currentCustomer;
            }
        }
        return null;
    }


}
