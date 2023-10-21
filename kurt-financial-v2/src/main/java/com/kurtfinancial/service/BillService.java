package com.kurtfinancial.service;

import com.kurtfinancial.model.Bill;
import com.kurtfinancial.repo.BillRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public Bill getById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill update(Bill bill) {
        return billRepository.save(bill);
    }

    public void delete(Long id) {
        billRepository.deleteById(id);
    }


}
