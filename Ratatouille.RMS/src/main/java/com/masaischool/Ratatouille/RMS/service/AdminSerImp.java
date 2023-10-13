package com.masaischool.Ratatouille.RMS.service;

import com.masaischool.Ratatouille.RMS.dao.AdminDao;
import com.masaischool.Ratatouille.RMS.dao.AdminDaoImp;
import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;
public class AdminSerImp implements AdminSer {

    AdminDao adminDao = new AdminDaoImp(); // Instantiate the AdminDao implementation

    // Adds a new recipe to the system
    @Override
    public void addRecipe(Recipe recipe) throws SomeThingWentWrongException {
        adminDao.addRecipe(recipe); // Delegates the task to the AdminDao
    }

    // Updates an existing recipe in the system
    @Override
    public void updateRecipe(Recipe recipe) throws SomeThingWentWrongException, NoRecordFoundException {
        adminDao.updateRecipe(recipe); // Delegates the task to the AdminDao
    }

    // Deletes a recipe from the system by its ID
    @Override
    public void deleteRecipe(int id) throws SomeThingWentWrongException, NoRecordFoundException {
        adminDao.deleteRecipe(id); // Delegates the task to the AdminDao
    }
}
