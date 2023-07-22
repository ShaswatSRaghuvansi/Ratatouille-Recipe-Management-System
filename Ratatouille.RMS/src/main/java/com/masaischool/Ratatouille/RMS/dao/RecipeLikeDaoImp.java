package com.masaischool.Ratatouille.RMS.dao;

import com.masaischool.Ratatouille.RMS.Utility.EMUtils;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class RecipeLikeDaoImp implements RecipeLikeDao{

	@Override
	public int getLikesCountByRecipeId(int recipeId) throws SomeThingWentWrongException, NoRecordFoundException {
		
		EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();
            Query query = em.createQuery("SELECT COUNT(rl) FROM RecipeLike rl WHERE rl.recipe.recipeId = :recipeId");
            query.setParameter("recipeId", recipeId);
            return ((Number) query.getSingleResult()).intValue();
        } catch (IllegalArgumentException ex) {
            throw new SomeThingWentWrongException("Unable to process request, try again later");
        } finally {
            if (em != null) {
                em.close();
            }
        }
	}

}
