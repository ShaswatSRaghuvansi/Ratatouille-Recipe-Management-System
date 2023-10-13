package com.masaischool.Ratatouille.RMS.dao;

import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface CustomerDao {

    /**
     * Adds a new customer to the system.
     *
     * @param user The user object representing the customer to be added.
     * @throws SomeThingWentWrongException If an error occurs while adding the customer.
     */
    void addCustomer(User user) throws SomeThingWentWrongException;

    /**
     * Logs in a customer with the given username and password.
     *
     * @param username The username of the customer.
     * @param password The password of the customer.
     * @throws SomeThingWentWrongException If an error occurs during the login process.
     * @throws NoRecordFoundException     If no customer with the provided username is found.
     */
    void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException;

    /**
     * Finds a customer with the specified ID.
     *
     * @param id The ID of the customer to retrieve.
     * @return The User object representing the customer with the specified ID.
     * @throws SomeThingWentWrongException If an error occurs while retrieving the customer.
     * @throws NoRecordFoundException     If no customer with the provided ID is found.
     */
    User findCustomerWithID(int id) throws SomeThingWentWrongException, NoRecordFoundException;
}
