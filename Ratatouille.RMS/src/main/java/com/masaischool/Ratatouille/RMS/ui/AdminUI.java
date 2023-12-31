package com.masaischool.Ratatouille.RMS.ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;
import com.masaischool.Ratatouille.RMS.service.AdminSer;
import com.masaischool.Ratatouille.RMS.service.AdminSerImp;
import com.masaischool.Ratatouille.RMS.service.RecipeLikeSer;
import com.masaischool.Ratatouille.RMS.service.RecipeLikeSerImp;
import com.masaischool.Ratatouille.RMS.service.RecipeSer;
import com.masaischool.Ratatouille.RMS.service.RecipeSerImp;



public class AdminUI {

    public static void addRecipe(Scanner sc) {
    	System.out.println();
    	System.out.println();
    	System.out.println("=====================================");
    	System.out.println();
        System.out.println("Enter Recipe Name");
        sc.nextLine();
        String recipeName = sc.nextLine().trim();  // Read the recipe name
        
        System.out.println("Enter Ingredients");
        String ingredients = sc.nextLine().trim();

        System.out.println("Enter Preparation Steps");
        String preparationStep = sc.nextLine().trim();

        Recipe recipe = new Recipe(recipeName, ingredients, preparationStep, new Date(), new Date());

        System.out.println(recipe);
        AdminSer adminSer = new AdminSerImp();

        try {
            adminSer.addRecipe(recipe);
        	System.out.println();
        	System.out.println();
            System.out.println("Recipe Added To Ratatouille's Successfully 🫰");
        	System.out.println();
            System.out.println("=====================================");
        	System.out.println();
        	System.out.println();
        } catch (SomeThingWentWrongException ex) {
            System.out.println(ex.getMessage());
        }
    }



	
	public static void updateRecipe(Scanner sc) {
		
		
			//code to take company details input
		System.out.println();
		System.out.println();
			System.out.println("=====================================");
			System.out.println();
			System.out.print("Enter id ");
			int id = sc.nextInt();
			System.out.println("Enter Recipe Name");
			sc.nextLine();
			String recipeName = sc.nextLine();
			
//			sc.nextLine();
			
			System.out.println("Enter Ingredients");
			String ingredients = sc.nextLine();
			
//			sc.nextLine();
			
			System.out.println("Enter Preparation Steps");
			String preparationStep = sc.nextLine();
			
			
			//code to create Company Entity object
			Recipe recipe = new Recipe(recipeName, ingredients, preparationStep, new Date(), new Date());
			recipe.setRecipeId(id);
			
			//Create an object of Service Layer here
			AdminSer adminSer = new AdminSerImp();
			try {
				adminSer.updateRecipe(recipe);;
				System.out.println();
				System.out.println();
				System.out.println("Recipe updated to Ratatouille's successfully 🫰");
				System.out.println();
				System.out.println("=====================================");
				System.out.println();
				System.out.println();
			}catch(SomeThingWentWrongException | NoRecordFoundException ex) {
				System.out.println(ex.getMessage());
			}
		
		
	}
	
	public static void deleteRecipe(Scanner sc) {
		System.out.println();
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
			System.out.print("Are you sure you want to delete your account?[y/n] ");
			char choice = sc.next().toLowerCase().charAt(0);
			if(choice == 'y') {
				System.out.println("======================================");
				System.out.println();System.out.println();
				System.out.println("Enter the Recipe Id you want To delete");
				int id  = sc.nextInt();
				System.out.println();
				System.out.println();
				AdminSer adminSer = new AdminSerImp();
				try {
					adminSer.deleteRecipe(id);
					System.out.println();
					System.out.println();
					System.out.println("===========================");
					System.out.println();
					System.out.println("Recipe Deleted successfully");
					System.out.println();
					System.out.println("===========================");
					System.out.println();
					System.out.println();
				}catch(SomeThingWentWrongException | NoRecordFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}
	}
	
	public static void viewLikes() {
		RecipeSer recipeSer = new RecipeSerImp();
	    try {
	        List<Recipe> recipeList = recipeSer.viewAllRecipe();
	        RecipeLikeSer recipeLikeSer = new RecipeLikeSerImp();

	        for (Recipe recipe : recipeList) {
	            int recipeId = recipe.getRecipeId();
	            int likeCount = recipeLikeSer.getLikesCountByRecipeId(recipeId);
	            System.out.println("Recipe: " + recipe.getRecipeName());
	            System.out.println("Likes: " + likeCount);
	            System.out.println();
	        }
	    } catch (NoRecordFoundException | SomeThingWentWrongException ex) {
	        System.out.println(ex.getMessage());
	    }
	}
	
	
	public static void showReports(Scanner sc) {
		
		    int choice = 0;
		    do {
		    	System.out.println();
		    	System.out.println();
		    	System.out.println("==================================");
		    	System.out.println();
		    	System.out.println("1. Top 5 Recipes");
		    	System.out.println("2. Trending Recipes");
		    	System.out.println("3. Comprehensive Likes and Recipes");
		    	System.out.println();
		    	System.out.println("==================================");
		    	System.out.println();
		    	System.out.println();
		    	
		        System.out.print("Enter selection: ");
		        choice = sc.nextInt();
		        switch (choice) {
		            case 1:
		            	RecipeReport.generateTopLikedRecipesReport();
		                break;
		            case 2:
		            	RecipeReport.viewTrendingRecipesForLast7Days();
		                break;
		            case 3:
		            	RecipeReport.overAllLikes();
		                break;
//		            case 4:
//		            	
//		                break;
//		            case 5:
//		            	
//		                break;
//		            case 6:
//		               
//		                break;
		            
		            case -1:
		                MainRunner.main(new String[0]);
		                break;
		            case 0:
		            	System.out.println();
		                System.out.println("Have a Great Day 🫰");
		                System.out.println();
		                System.out.println("=================");
		                System.out.println();
		                System.out.println();
		                break;
		            default:
		            	System.out.println();
		                System.out.println("🚫 Invalid Selection 🚫, try again");
		                System.out.println();
		                System.out.println();
		        }
		    } while (choice != 0);
	

	}
}
