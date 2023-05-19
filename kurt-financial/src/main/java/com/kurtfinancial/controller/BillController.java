package com.kurtfinancial.controller;

import com.kurtfinancial.model.Bill;
import com.kurtfinancial.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/bill")
@AllArgsConstructor @CrossOrigin
public class BillController {
    private final BillService billService;

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getById(Long id) {
        Bill bill = billService.getById(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @GetMapping("/all") 
    public ResponseEntity<List<Bill>> getAll() {
        List<Bill> bills = billService.getAll();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<Bill> save(Bill bill) {

        Bill newBill = billService.save(bill);
        return new ResponseEntity<>(newBill, HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<Bill> update(Bill bill) {
        Bill newBill = billService.update(bill);
        return new ResponseEntity<>(newBill, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<Bill> delete(Long id) {
        billService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
