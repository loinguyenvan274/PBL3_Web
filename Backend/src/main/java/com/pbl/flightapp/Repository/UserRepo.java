package com.pbl.flightapp.Repository;
    
import com.pbl.flightapp.DTO.UserDTO;
import com.pbl.flightapp.Model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * Id_Card string [primary key]
  Full_Name string
  Tel string
  Email string
  Country string
  Day_Of_Birth string
  Sex boolean 0:woman 1:man
  created_at timestamp
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
//    Customer findByIdCard(int idCustomer);
//
//    List<Customer> findByFullName(String nameCustomer);
//
//    List<Customer> findByTel(String teleplone);

    @Query("SELECT new com.pbl.flightapp.DTO.UserDTO(u) FROM User u WHERE u.email = :email OR :email IS NULL")
    List<UserDTO> findUser(@Param("email") String email);
//
   User findByEmail(String email);
   User findByCardNumber(String cardNumber);
   User findByPhone(String phone);
   
//
//    List<Customer> findByCountry(String address);
}
