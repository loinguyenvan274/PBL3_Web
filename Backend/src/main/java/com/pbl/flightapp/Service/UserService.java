package com.pbl.flightapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pbl.flightapp.Repository.UserRepo;
import com.pbl.flightapp.Model.User;
import java.util.List;
import com.pbl.flightapp.appExc.UserException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserService() {
    }

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }
    @Transactional
    public User updateUser(int id, User updatedUser) throws UserException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserException("User not found", "USER_NOT_FOUND");
        }
        validateUser(updatedUser);
        user.copyFromNotCopyType(updatedUser);
        return user;
    }
    static void validateUser(User user) throws UserException {
        if (user.getFullName() == null || user.getFullName().isEmpty())
            throw new UserException("Full name is required", "FULL_NAME_REQUIRED");
    }
/*

    public Customer getCustomerById(int idCustomer) {
        return customerRepo.findByIdCard(idCustomer);
    }

    public List<Customer> getCustomerByName(String nameCustomer) {
        return customerRepo.findByFullName(nameCustomer);
    }

    public List<Customer> getCustomerByPhoneNumber(String phoneNumber) {
        return customerRepo.findByTel(phoneNumber);
    }

    public List<Customer> getCustomerByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

    public List<Customer> getCustomerByCountry(String country) {
        return customerRepo.findByCountry(country);
    }

    public void deleteCustomer(int idCustomer) {
        customerRepo.deleteById(idCustomer);
    }

    public void addCustomer(Customer customer) { // Nếu tồn tài thì không add
        if (!customerRepo.existsById(customer.getIdCustomer())) {
            customerRepo.save(customer);
        }
    }
*/

//    public void updateCustomer(Customer customer) {
//        if (customerRepo.existsById(customer.getIdCustomer())) {
//            Customer exist = customerRepo.findByIdCard(customer.getIdCustomer());
//            exist.Copy(customer);
//            customerRepo.save(exist);
//        } else {
//            addCustomer(customer);
//        }
//    }

    public void addUserToTicket(User user) {
        // Thêm vào vé
        // nếu id đã tồn tại, tức là có thể đã ở trước đó
    }
}
