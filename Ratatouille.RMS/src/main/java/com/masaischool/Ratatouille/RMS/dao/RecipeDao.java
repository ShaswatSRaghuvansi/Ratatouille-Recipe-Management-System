package com.masaischool.Ratatouille.RMS.dao;

import java.util.List;

import com.masaischool.Ratatouille.RMS.entity.Recipe;

import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface RecipeDao {

	List<Recipe> viewAllRecipe() throws SomeThingWentWrongException,NoRecordFoundException;
	List<Recipe> viewRecipesWithGivenIngredients(String ingredients) throws SomeThingWentWrongException,NoRecordFoundException;
	Recipe getRecipeByID(int id) throws SomeThingWentWrongException,NoRecordFoundException;
}
