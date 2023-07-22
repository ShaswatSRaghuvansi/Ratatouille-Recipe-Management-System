package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface AdminSer {
	void addRecipe(Recipe recipe) throws SomeThingWentWrongException;
	void updateRecipe(Recipe recipe) throws SomeThingWentWrongException,NoRecordFoundException;
	void deleteRecipe(int id) throws SomeThingWentWrongException, NoRecordFoundException;
	
	
}
