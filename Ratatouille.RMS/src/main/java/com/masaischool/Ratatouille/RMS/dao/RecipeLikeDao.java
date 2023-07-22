package com.masaischool.Ratatouille.RMS.dao;

import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface RecipeLikeDao {

	int getLikesCountByRecipeId(int recipeId) throws SomeThingWentWrongException,NoRecordFoundException;
}
