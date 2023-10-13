package com.masaischool.Ratatouille.RMS.dao;

import java.util.List;

import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface RecipeDao {

    // Method to retrieve a list of all recipes
    List<Recipe> viewAllRecipe() throws SomeThingWentWrongException, NoRecordFoundException;

    // Method to retrieve a list of recipes containing specific ingredients
    List<Recipe> viewRecipesWithGivenIngredients(String ingredients) throws SomeThingWentWrongException, NoRecordFoundException;

    // Method to retrieve a specific recipe by its ID
    Recipe getRecipeByID(int id) throws SomeThingWentWrongException, NoRecordFoundException;
}
