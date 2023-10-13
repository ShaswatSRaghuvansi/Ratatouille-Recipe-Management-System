package com.masaischool.Ratatouille.RMS.service;

import java.util.List;

import com.masaischool.Ratatouille.RMS.dao.RecipeDao;
import com.masaischool.Ratatouille.RMS.dao.RecipeDaoImp;
import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public class RecipeSerImp implements RecipeSer {

    RecipeDao recipeDao = new RecipeDaoImp(); // Instantiate the RecipeDao implementation

    // Retrieves a list of all recipes in the system
    @Override
    public List<Recipe> viewAllRecipe() throws SomeThingWentWrongException, NoRecordFoundException {
        return recipeDao.viewAllRecipe(); // Delegates the task to the RecipeDao and returns the list of recipes
    }

    // Retrieves a list of recipes that contain specific ingredients
    @Override
    public List<Recipe> viewRecipesWithGivenIngredients(String ingredients) throws SomeThingWentWrongException, NoRecordFoundException {
        return recipeDao.viewRecipesWithGivenIngredients(ingredients); // Delegates the task to the RecipeDao and returns the list of recipes
    }

    // Retrieves a recipe with a specified ID
    @Override
    public Recipe getRecipeByID(int id) throws SomeThingWentWrongException, NoRecordFoundException {
        return recipeDao.getRecipeByID(id); // Delegates the task to the RecipeDao and returns the recipe
    }
}
