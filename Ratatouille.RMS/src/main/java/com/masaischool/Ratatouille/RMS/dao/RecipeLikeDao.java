package com.masaischool.Ratatouille.RMS.dao;

import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface RecipeLikeDao {

    /**
     * Get the number of likes (count) for a recipe based on its recipe ID.
     *
     * @param recipeId The unique identifier of the recipe.
     * @return The count of likes for the specified recipe.
     * @throws SomeThingWentWrongException If there is an issue with the database or the request processing.
     * @throws NoRecordFoundException     If the recipe with the provided recipe ID is not found in the database.
     */
    int getLikesCountByRecipeId(int recipeId) throws SomeThingWentWrongException, NoRecordFoundException;
}
