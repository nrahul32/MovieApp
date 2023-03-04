package com.nrahul32.movieapp.dao;

import com.nrahul32.movieapp.entities.Customer;

public interface CustomerDao {

    public Customer save(Customer customer);
    public Customer findById(int id);
    public Customer update(Customer customer);
    public void delete(Customer customer);
}
