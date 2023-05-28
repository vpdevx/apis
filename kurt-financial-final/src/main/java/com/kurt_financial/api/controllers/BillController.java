/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kurt_financial.api.controllers;


import com.kurt_financial.api.models.Bill;
import com.kurt_financial.api.models.User;
import com.kurt_financial.api.repository.UserRepository;
import com.kurt_financial.api.security.services.BillService;

import javax.persistence.EntityNotFoundException;

import com.kurt_financial.api.security.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@PreAuthorize("#username == authentication.principal.username && hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class BillController {

    private UserRepository userRepo;

    private final BillService billService;


    @PostMapping("/{username}/bill/save")
    public ResponseEntity<Bill> addBill(@PathVariable("username") String username, @RequestBody Bill bill) {

        Bill newBill = userRepo.findByUsername(username).map(user -> {
            bill.setUser(user);
            return billService.save(bill);
        }).orElseThrow(() -> new RuntimeException("Not found Tutorial with id = "));
        
        return new ResponseEntity<>(newBill, HttpStatus.OK);
    }

    @PostMapping("/{username}/bill/all")
    public ResponseEntity<List<Bill>> getAll(@PathVariable("username") String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Bill> bills = billService.getByUserId(user.getId()).orElseThrow(() -> new EntityNotFoundException("The user don't have any bills"));
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @PostMapping("/{username}/bill/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable("username") String username, @PathVariable("id") Long id) {
        try {
            User user = userRepo.findByUsername(username)
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

            List<Bill> bills = billService.getByUserId(user.getId())
                    .orElseThrow(() -> new EntityNotFoundException("The user doesn't have any bills"));

            Bill bill = bills.stream()
                    .filter(b -> b.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundException("Bill not found for the current user"));

            billService.deleteById(bill.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{username}/bill/update")
    public ResponseEntity<?> updateBill(@PathVariable("username") String username, @RequestBody Bill bill) {
        try {
            User user = userRepo.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found"));
            bill.setUser(user);
            List<Bill> bills = billService.getByUserId(user.getId()).orElseThrow(() -> new EntityNotFoundException("The user doesn't have any bills"));

            Optional<Bill> optionalBill = bills.stream()
                    .filter(b -> b.getId().equals(bill.getId()))
                    .findFirst();


            if (!optionalBill.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Bill does not exists or not found for the current user");
            }


            return new ResponseEntity<>(billService.update(bill), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error" + e.getMessage());
        }
    }

}
