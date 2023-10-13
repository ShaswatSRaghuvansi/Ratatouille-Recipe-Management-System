package com.masaischool.Ratatouille.RMS.dao;

import java.util.Date;

import com.masaischool.Ratatouille.RMS.Utility.EMUtils;

import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AdminDaoImp implements AdminDao {

    @Override
    public void addRecipe(Recipe recipe) throws SomeThingWentWrongException {
        EntityManager em = null;

        try {
            em = EMUtils.getEntityManager();

            // Check if a recipe with the same name exists
            Query query = em.createQuery("SELECT count(c) FROM Recipe c WHERE recipeName = :recipeName");
            query.setParameter("recipeName", recipe.getRecipeName());
            if ((Long) query.getSingleResult() > 0) {
                throw new SomeThingWentWrongException("Recipe already exists with name " + recipe.getRecipeName());
            }

            // Proceed with adding the recipe
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(recipe);
            et.commit();
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Not Able to Add recipe, Try Again");
        } finally {
            em.close();
        }
    }

    @Override
    public void updateRecipe(Recipe recipe) throws SomeThingWentWrongException, NoRecordFoundException {
        EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();
            Recipe recipeFromDB = em.find(Recipe.class, recipe.getRecipeId());

            if (recipeFromDB == null) {
                throw new NoRecordFoundException("No Recipe found with the given id " + recipe.getRecipeId());
            }

            // Check if the recipe is to be renamed
            if (!recipeFromDB.getRecipeName().equals(recipe.getRecipeName())) {
                Query query = em.createQuery("SELECT count(c) FROM Recipe c WHERE recipeName = :recName");
                query.setParameter("recName", recipe.getRecipeName());
                if ((Long) query.getSingleResult() > 0) {
                    throw new SomeThingWentWrongException("Recipe already exists with name " + recipe.getRecipeName());
                }
            }

            // Proceed with the update operation
            EntityTransaction et = em.getTransaction();
            et.begin();
            recipeFromDB.setRecipeName(recipe.getRecipeName());
            recipeFromDB.setIngredients(recipe.getIngredients());
            recipeFromDB.setPreparationSteps(recipe.getPreparationSteps());
            recipeFromDB.setUpdatedAt(new Date());
            et.commit();
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process the request, try again later");
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteRecipe(int id) throws SomeThingWentWrongException, NoRecordFoundException {
        EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();
            Recipe recipe = em.find(Recipe.class, id);

            if (recipe == null) {
                throw new NoRecordFoundException("Recipe with the given Id does not Exist");
            }

            EntityTransaction et = em.getTransaction();
            et.begin();
            recipe.setDeleted(true);
            et.commit();
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process the request, try again later");
        } finally {
            em.close();
        }
    }

    @Override
    public void viewNumberOfLikes() throws SomeThingWentWrongException, NoRecordFoundException {
        // This method is not yet implemented
    }
}
