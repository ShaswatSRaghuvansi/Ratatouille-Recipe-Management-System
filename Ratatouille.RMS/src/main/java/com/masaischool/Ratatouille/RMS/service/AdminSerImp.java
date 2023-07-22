package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.dao.AdminDao;
import com.masaischool.Ratatouille.RMS.dao.AdminDaoImp;
import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public class AdminSerImp implements AdminSer{
	
	AdminDao adminDao = new AdminDaoImp();
	
	@Override
	public void addRecipe(Recipe recipe) throws SomeThingWentWrongException {
		adminDao.addRecipe(recipe);
		
	}

	@Override
	public void updateRecipe(Recipe recipe) throws SomeThingWentWrongException,NoRecordFoundException {
		adminDao.updateRecipe(recipe);
		
	}

	@Override
	public void deleteRecipe(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		adminDao.deleteRecipe(id);
		
	}

	
	
	
}
