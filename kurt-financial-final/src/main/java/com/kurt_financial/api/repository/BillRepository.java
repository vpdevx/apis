
package com.kurt_financial.api.repository;

import com.kurt_financial.api.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
    Optional<List<Bill>> findByUserId(Long id);

}
