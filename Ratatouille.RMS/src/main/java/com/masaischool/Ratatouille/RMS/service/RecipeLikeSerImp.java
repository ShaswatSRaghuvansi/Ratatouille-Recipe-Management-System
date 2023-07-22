package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.dao.RecipeLikeDao;
import com.masaischool.Ratatouille.RMS.dao.RecipeLikeDaoImp;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public class RecipeLikeSerImp implements RecipeLikeSer{

	RecipeLikeDao recipeDao = new RecipeLikeDaoImp();
	@Override
	public int getLikesCountByRecipeId(int recipeId) throws SomeThingWentWrongException, NoRecordFoundException {
		
		return recipeDao.getLikesCountByRecipeId(recipeId);
	}

}
