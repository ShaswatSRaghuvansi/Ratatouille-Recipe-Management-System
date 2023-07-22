package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.dao.CustomerDao;
import com.masaischool.Ratatouille.RMS.dao.CustomerDaoImp;
import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public class CustomerSerImp implements CustomerSer{

	CustomerDao cusDao = new CustomerDaoImp();
	@Override
	public void addCustomer(User user) throws SomeThingWentWrongException {
		cusDao.addCustomer(user);
		
	}
	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		
		cusDao.login(username, password);
	}
	@Override
	public User findCustomerWithID(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		return cusDao.findCustomerWithID(id);
	}
	
}
