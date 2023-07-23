package com.masaischool.Ratatouille.RMS.service;

import java.util.List;

import com.masaischool.Ratatouille.RMS.dao.RecipeDao;
import com.masaischool.Ratatouille.RMS.dao.RecipeDaoImp;
import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public class RecipeSerImp implements RecipeSer{

	RecipeDao recipeDao = new RecipeDaoImp();
	@Override
	public List<Recipe> viewAllRecipe() throws SomeThingWentWrongException, NoRecordFoundException {
		
		return recipeDao.viewAllRecipe();
	}
	@Override
	public List<Recipe> viewRecipesWithGivenIngredients(String ingredients) throws SomeThingWentWrongException, NoRecordFoundException {
		return recipeDao.viewRecipesWithGivenIngredients(ingredients);
		 
	}
	@Override
	public Recipe getRecipeByID(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		
		return recipeDao.getRecipeByID(id);
	}

	

}
