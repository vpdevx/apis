/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kurt_financial.api.security.services;

import com.kurt_financial.api.models.Bill;
import com.kurt_financial.api.repository.BillRepository;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author 52215553
 */
@Service @AllArgsConstructor
public class BillService {
    private BillRepository billRepo;
    
    public Bill save(Bill bill){
    
        return billRepo.save(bill);
    }
    
    public Optional<List<Bill>> getByUserId(Long id){
    
        return billRepo.findByUserId(id);
    }

    public void deleteById(Long id){
        billRepo.deleteById(id);
    }

    public Bill update(Bill bill){

        return billRepo.save(bill);
    }
    
}
