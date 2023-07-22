package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface CustomerSer {

	void addCustomer(User user) throws SomeThingWentWrongException;
	void login(String username, String password) 
			throws SomeThingWentWrongException, NoRecordFoundException;
	User findCustomerWithID(int id) throws SomeThingWentWrongException, NoRecordFoundException;
    
}
