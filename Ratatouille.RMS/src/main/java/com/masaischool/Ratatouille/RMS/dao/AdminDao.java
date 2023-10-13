package com.masaischool.Ratatouille.RMS.dao;

import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface AdminDao {

    // Method to add a new recipe
    void addRecipe(Recipe recipe) throws SomeThingWentWrongException;

    // Method to update an existing recipe
    void updateRecipe(Recipe recipe) throws SomeThingWentWrongException, NoRecordFoundException;

    // Method to delete a recipe by its ID
    void deleteRecipe(int id) throws SomeThingWentWrongException, NoRecordFoundException;

    // Method to view the number of likes for a recipe (if needed)
    void viewNumberOfLikes() throws SomeThingWentWrongException, NoRecordFoundException;
}
