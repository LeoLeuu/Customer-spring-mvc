package com.example.service;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImplement implements CustomerService{

    private static Map<Integer,Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"Vinh1","vinhdepjai112@gmail.com","HN"));
        customers.put(2, new Customer(2,"Vinh2","vinhdepjai122@gmail.com","HN"));
        customers.put(3, new Customer(3,"Vinh3","vinhdepjai132@gmail.com","HN"));
        customers.put(4, new Customer(4,"Vinh4","vinhdepjai142@gmail.com","HN"));
        customers.put(5, new Customer(5,"Vinh5","vinhdepjai152@gmail.com","HN"));
        customers.put(6, new Customer(6,"Vinh6","vinhdepjai162@gmail.com","HN"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id,Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
