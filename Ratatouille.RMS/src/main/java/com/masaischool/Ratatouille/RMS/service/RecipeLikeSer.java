package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

public interface RecipeLikeSer {
	int getLikesCountByRecipeId(int recipeId) throws SomeThingWentWrongException,NoRecordFoundException;
}
