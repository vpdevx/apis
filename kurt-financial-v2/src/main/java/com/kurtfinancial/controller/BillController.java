package com.kurtfinancial.controller;

import com.kurtfinancial.model.Bill;
import com.kurtfinancial.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/bill")
@AllArgsConstructor @CrossOrigin(origins = "*")
public class BillController {
    private final BillService billService;

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getById(@PathVariable("id") Long id) {
        Bill bill = billService.getById(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Bill>> getAll() {
        List<Bill> bills = billService.getAll();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Bill> save(@RequestBody Bill bill) {

        Bill newBill = billService.save(bill);
        return new ResponseEntity<>(newBill, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Bill> update(@RequestBody Bill bill) {
        Bill newBill = billService.update(bill);
        return new ResponseEntity<>(newBill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Bill> delete(@PathVariable("id") Long id) {
        billService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
