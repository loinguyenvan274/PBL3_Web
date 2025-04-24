package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Model.Customer;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

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

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void updateCustomer(Customer customer) {
        if (customerRepo.existsById(customer.getIdCard())) {
            Customer exist = customerRepo.findByIdCard(customer.getIdCard());
            exist.Copy(customer);
            customerRepo.save(exist);
        } else {
            addCustomer(customer);
        }
    }

}
