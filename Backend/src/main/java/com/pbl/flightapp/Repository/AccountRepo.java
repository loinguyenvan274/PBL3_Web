package com.pbl.flightapp.Repository;

import com.pbl.flightapp.DTO.AccountDTO;
import com.pbl.flightapp.Model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
//    Account findByUsername(String username);
   @Query("SELECT new com.pbl.flightapp.DTO.AccountDTO(a.idAccount, a.email, a.password, a.createdAt, a.role) " +
       "FROM Account a " +
       "WHERE (:email IS NULL OR a.email = :email) " +
       "AND (:createdAt IS NULL OR a.createdAt = :createdAt)")
   List<AccountDTO> findAccountDTOs(@Param("email") String email,@Param("createdAt") Timestamp createdAt);
//
//    Account findByUsernameAndPassword(String username, String password);

//    Account findByCustomer(Customer customer);
}
