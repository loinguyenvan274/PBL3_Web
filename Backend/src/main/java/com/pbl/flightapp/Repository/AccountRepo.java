package com.pbl.flightapp.Repository;

import com.pbl.flightapp.DTO.AccountDTO;
import com.pbl.flightapp.Model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
//    Account findByUsername(String username);
   @Query("SELECT new com.example.demo.DTO.AccountDTO(a.idAccount, a.email, a.password, a.createdAt, new com.example.demo.DTO.CustomerDTO(a.customer.idCustomer, a.customer.fullName, a.customer.phone, a.customer.address, a.customer.email, a.customer.dateOfBirth), a.role) FROM Account a WHERE a.email = :email OR '' = :email ")
   List<AccountDTO> findAccountDTOs(@Param("email") String email);
//
//    Account findByUsernameAndPassword(String username, String password);

//    Account findByCustomer(Customer customer);
}
