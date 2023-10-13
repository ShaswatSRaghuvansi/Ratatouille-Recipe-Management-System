package com.masaischool.Ratatouille.RMS.ui;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.masaischool.Ratatouille.RMS.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class RecipeReport {
    
	// Generates a report of the top liked recipes.
    public static void generateTopLikedRecipesReport() {
        // Retrieves and displays the top liked recipes by counting likes and ordering by likes count.
    
		
		EntityManager entityManager = EMUtils.getEntityManager();
	    String jpql = "SELECT r.recipeId, r.recipeName, COUNT(rl.likeId) AS likesCount " +
	                  "FROM Recipe r " +
	                  "LEFT JOIN r.recipeLikes rl " +
	                  "GROUP BY r.recipeId, r.recipeName " +
	                  "ORDER BY likesCount DESC"+
	                  "LIMIT 2";

	    List<Object[]> results = entityManager.createQuery(jpql, Object[].class)
	            .setMaxResults(10)
	            .getResultList();

	    for (Object[] result : results) {
	        int recipeId = (int) result[0];
	        String recipeName = (String) result[1];
	        Long likesCount = (Long) result[2];

	        // Process the results as needed
	        System.out.println("Recipe ID: " + recipeId + ", Recipe Name: " + recipeName + ", Likes Count: " + likesCount);
	    }
	}
	
	
 // Views trending recipes for the last 7 days based on likes.
    public static void viewTrendingRecipesForLast7Days() {
        // Retrieves and displays recipes that have gained the most likes in the last 7 days.
    
		
		EntityManager entityManager = EMUtils.getEntityManager();
		String jpql = "SELECT r.recipeId, r.recipeName, COUNT(rl.likeId) AS likesCount " +
                "FROM Recipe r " +
                "LEFT JOIN r.likes rl " +
                "WHERE rl.createdAt >= :startDate " +
                "GROUP BY r.recipeId, r.recipeName " +
                "ORDER BY likesCount DESC";

			  Date startDate = calculateStartDate(); 
			  // Calculate the start date (e.g., 7 days ago)
			
			  Query query = entityManager.createQuery(jpql);
			  query.setParameter("startDate", startDate);
			
			  List<Object[]> results = query.getResultList();
			
			  for (Object[] result : results) {
			      Long recipeId = (Long) result[0];
			      String recipeName = (String) result[1];
			      Long likesCount = (Long) result[2];
			
			      // Process the results as needed
			      System.out.println("Recipe ID: " + recipeId + ", Recipe Name: " + recipeName + ", Likes Count: " + likesCount);
				}
}
	
    // Generates a report of overall likes for recipes.
    public static void overAllLikes() {
        // Not yet implemented, you can add functionality to generate overall likes here.
   
		
	}
	
 // Generates a report of likes for recipes with specific ingredients.
    public static void generateLikesByIngredient() {
        // Not yet implemented, you can add functionality to generate likes by ingredient here.
   
	   
	}
	
 // Generates a report of likes for recipes over a specified time period.
    public static void generateLikesOverTime() {
        // Not yet implemented, you can add functionality to generate likes over time here.
   
	
	}

	
	
 // Calculates the start date for a specified time period (e.g., 7 days ago).
    private static Date calculateStartDate() {
        // Calculates and returns the start date for a specified time period (e.g., 7 days ago).
    
	    // Get the current date
	    Date currentDate = new Date();

	    // Create a calendar instance and set it to the current date
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(currentDate);

	    // Subtract 7 days from the current date
	    calendar.add(Calendar.DAY_OF_MONTH, -7);

	    // Get the resulting date as the start date
	    Date startDate = calendar.getTime();

	    return startDate;
	}


}
