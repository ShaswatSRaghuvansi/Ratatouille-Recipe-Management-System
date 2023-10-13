package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.dao.CustomerDao;
import com.masaischool.Ratatouille.RMS.dao.CustomerDaoImp;
import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;
public class CustomerSerImp implements CustomerSer {

    CustomerDao cusDao = new CustomerDaoImp(); // Instantiate the CustomerDao implementation

    // Adds a new customer to the system
    @Override
    public void addCustomer(User user) throws SomeThingWentWrongException {
        cusDao.addCustomer(user); // Delegates the task to the CustomerDao
    }

    // Logs in a user with a given username and password
    @Override
    public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
        cusDao.login(username, password); // Delegates the task to the CustomerDao
    }

    // Finds a customer with a specified ID
    @Override
    public User findCustomerWithID(int id) throws SomeThingWentWrongException, NoRecordFoundException {
        return cusDao.findCustomerWithID(id); // Delegates the task to the CustomerDao and returns the result
    }
}
