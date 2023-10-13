package com.masaischool.Ratatouille.RMS.ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.masaischool.Ratatouille.RMS.Utility.EMUtils;
import com.masaischool.Ratatouille.RMS.entity.LoggedInUserId;
import com.masaischool.Ratatouille.RMS.entity.Recipe;
import com.masaischool.Ratatouille.RMS.entity.RecipeLike;
import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;
import com.masaischool.Ratatouille.RMS.service.CustomerSer;
import com.masaischool.Ratatouille.RMS.service.CustomerSerImp;
import com.masaischool.Ratatouille.RMS.service.RecipeSer;
import com.masaischool.Ratatouille.RMS.service.RecipeSerImp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerUI {

	// Registers a new customer with the system.
    public static void customerRegistration(Scanner sc) {
        // Collects customer registration details, creates a User object, and registers the user with the CustomerSer service.
    
		System.out.println();
		System.out.println();
		System.out.println("=================================");
		System.out.println("Enter UserName 👤");
		String userName = sc.next();

		System.out.println("Enter Email 📧");
		String email = sc.next();

		System.out.println("Password 🔑");
		String password = sc.next();

		User user = new User(userName, email, password, new Date(), new Date());

		CustomerSer customerSer = new CustomerSerImp();

		try {
			customerSer.addCustomer(user);
			System.out.println();
			System.out.println();
			System.out.println("=================================");
			System.out.println();
			System.out.println("User Added Successfully 👍");
			System.out.println();
			System.out.println("=================================");
			System.out.println();
			System.out.println();
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}

	}

 // Logs in a customer to access their account.
    static void userLogin(Scanner sc) {
        // Prompts the user to enter their username and password for login.
        // Checks the credentials with the CustomerSer service, and if successful, allows access to the user menu.
   
		
		System.out.println();
		System.out.println();
		System.out.println("=================================");
		System.out.println();
		System.out.print("Enter username 👤");
		String username = sc.next();
		System.out.print("Enter password 🔑");
		String password = sc.next();
		System.out.println();
		try {
			CustomerSer customerService = new CustomerSerImp();
			customerService.login(username, password);
			userMenu(sc);
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

 // Displays the user menu options.
    static void displayUserMenu() {
        // Displays a menu with options for customers, such as viewing recipes, searching for recipes, liking recipes, and logging out.
    
		System.out.println();
		System.out.println();
		System.out.println("=====================================");
		System.out.println();
		System.out.println("1. View All Recipe");
		System.out.println("2. Find Recipe With Given Ingredients");
		System.out.println("3. Like Or Bookmark 🔖");
		System.out.println("0. Logout");
		System.out.println("-1. Previous Menu");
		System.out.println();
		System.out.println("=====================================");
		System.out.println();
		System.out.println();
	}

 // Manages the user menu and user interactions.
    public static void userMenu(Scanner sc) {
        // Handles user menu options and performs corresponding actions based on user choices.
    
		int choice = 0;
		do {
			displayUserMenu();
			System.out.println();
			System.out.println();
			System.out.println("=====================================");
			System.out.println();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			System.out.println();
			System.out.println();
			switch (choice) {
			case 1:
				// this code is same as we have used on the admin side
				// so we are using here as it is
				viewAllRecipe();
				break;
			case 2:
				findRecipeWithGivenIngredients(sc);

				break;
			case 3:
				//code to purchase a new policy
				showRecipeOptions(sc);
				break;
//			case 4:
//				//code to view policies purchased by logged in user
//				
//				break;
//			case 5:
//				deleteAccount(sc);
//				System.out.println("Logging you out");
//				choice = 0;
			case -1:
				MainRunner.main(new String[0]);
				break;
			case 0:
				LoggedInUserId.loggedInUserId = -1; // -1 id cannot belong to any customer
				System.out.println("Have a Great Day User 👋");
				System.out.println();
				System.out.println("=====================================");
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

 // Searches for recipes with given ingredients and allows users to like/unlike recipes.
    private static void findRecipeWithGivenIngredients(Scanner sc) {
        // Prompts the user to enter ingredients and searches for recipes with those ingredients.
        // Allows users to like or unlike recipes.
    
		
		System.out.println("=====================================");
		System.out.println();
		System.out.println("Enter the Ingrident ");
		String ingridents = sc.next();
		System.out.println();
		System.out.println();
		RecipeSer recipeSer = new RecipeSerImp();
		try {
			List<Recipe> recipeList = recipeSer.viewRecipesWithGivenIngredients( ingridents);
			recipeList.forEach(t -> System.out.println(t));
			likeOrUnlike();
			
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

 // Views all available recipes.
    public static void viewAllRecipe() {
        // Retrieves and displays a list of all available recipes.
   
		RecipeSer recipeSer = new RecipeSerImp();
		try {
			List<Recipe> recipeList = recipeSer.viewAllRecipe();
			recipeList.forEach(t -> System.out.println(t));
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}

	}
	
 // Handles the liking or unliking of recipes by customers.
    public static void likeOrUnlike() {
        // Provides options for customers to like or unlike recipes.
        // Allows customers to navigate between menus and make their choices.
    
		
		Scanner scanner = new Scanner(System.in);
	    
	    int choice ;
	    do {
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("=====================================");
	    	System.out.println();
	    	System.out.println("You Want to Like or Save Recipe 🔖?" );
			System.out.println("1. Yes");
			System.out.println("0. No");
			System.out.println();
			System.out.println("=====================================");
			System.out.println();
			System.out.println();
		    
		    choice =  scanner.nextInt();
		    switch (choice) {
		        case 1:
		        	showRecipeOptions(scanner);
		            break;
		        case 0:
		        	userMenu(scanner);
		            break;
		        default:
		        	System.out.println();
		        	System.out.println();
		            System.out.println("🚫 Invalid choice! 🚫");
		            System.out.println();
		            System.out.println();
		    }
	    }while(choice != 0);
		
		
				
		
	}
	
 // Displays options for adding or removing likes on recipes.
    public static void showRecipeOptions(Scanner scanner) {
        // Displays a menu with options for adding or removing likes on recipes.
    

	    
	    int choice ;
	    do {
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("=====================================");
	    	System.out.println();
		    System.out.println("1. Add Like 👍");
		    System.out.println("2. Remove Like 👎");
		    System.out.println("0. Go back to the previous menu");
		    System.out.println();
		    System.out.println("=====================================");
		    System.out.println();
		    System.out.println();
		    choice =  scanner.nextInt();
		    switch (choice) {
		        case 1:
		            addLike();
		            break;
		        case 2:
		        	System.out.println();
		        	System.out.println("❌ We are presently engaged in the task ❌");
		        	System.out.println();
		            removeLike();
		            break;
		        case 0:
		            
		        	likeOrUnlike();
		            break;
		        default:
		        	System.out.println();
		        	System.out.println();
		            System.out.println("🚫 Invalid choice! 🚫");
		            System.out.println();
		            System.out.println();
		    }
	    }while(choice != 0);
	    
	}

 // Removes a like from a recipe.
    private static void removeLike() {
        // Prompts the user to enter a recipe ID and removes the like association from the database.
    
//	    Scanner scanner = new Scanner(System.in);
//	    System.out.println("Enter the recipe ID you want to remove the like from: ");
//	    int recipeId = scanner.nextInt();
//	    User user = null;
//	    CustomerSer customerSer = new CustomerSerImp();
//
//	    // Retrieve the User entity for the current logged-in user
//	    try {
//	        user = customerSer.findCustomerWithID((int) LoggedInUserId.loggedInUserId);
//	    } catch (SomeThingWentWrongException | NoRecordFoundException e) {
//	        System.out.println(e.getMessage());
//	    }
//
//	    RecipeSer recipeSer = new RecipeSerImp();
//	    EntityManager em = null;
//	    try {
//	        em = EMUtils.getEntityManager();
//	        Recipe recipe = recipeSer.getRecipeByID(recipeId);
//
//	        // Find the RecipeLike associated with the User and Recipe
//	        RecipeLike recipeLike = user.getLikeByRecipe(recipe);
//
//	        if (recipeLike != null) {
//	            EntityTransaction et = em.getTransaction();
//	            et.begin();
//
//	            // Remove the RecipeLike entity to remove the like association
//	            em.remove(recipeLike);
//	            et.commit();
//	            System.out.println("Like Removed Successfully");
//	        } else {
//	            System.out.println("You haven't liked this recipe before.");
//	        }
//	    } catch (NoRecordFoundException | SomeThingWentWrongException ex) {
//	        System.out.println(ex.getMessage());
//	    } finally {
//	        em.close();
//	    }
	}


	// Adds a like to a recipe.
    private static void addLike() {
        // Prompts the user to enter a recipe ID and associates a like with the user and the recipe.
        // Adds the like association to the database.
   
	    Scanner scanner = new Scanner(System.in);
	    scanner.close(); // to stop the resource leak
	    System.out.println();
	    System.out.println();
	    System.out.println("====================================");
	    System.out.println();
	    System.out.println("Enter the recipe ID you want to like: ");
	    int recipeId = scanner.nextInt();
	    System.out.println();
	    System.out.println();
	    User user = null;
	    CustomerSer customerSer = new CustomerSerImp();

	    // Retrieve the User entity for the current logged-in user
	    try {
	        user = customerSer.findCustomerWithID((int) LoggedInUserId.loggedInUserId);
	    } catch (SomeThingWentWrongException | NoRecordFoundException e) {
	        System.out.println(e.getMessage());
	    }

	    RecipeSer recipeSer = new RecipeSerImp();
	    EntityManager em = null;
	    try {
	        em = EMUtils.getEntityManager();
	        Recipe recipe = recipeSer.getRecipeByID(recipeId);

	        // Create a new RecipeLike and associate it with the User and Recipe
	        RecipeLike recipeLike = new RecipeLike(user, recipe, new Date());
	        user.addLike(recipeLike);
	        recipe.getLikes().add(recipeLike);

	        EntityTransaction et = em.getTransaction();
	        et.begin();

// Since the User and Recipe entities are already retrieved and managed, you don't need to persist them again.
// However, you need to update the RecipeLike entity to persist the like association.

	        em.persist(recipeLike);
	        et.commit();
	        System.out.println();
	        System.out.println();
	        System.out.println("Like Added Successfully 👍");
	        System.out.println();
	        System.out.println();
	        System.out.println("=====================================");
	        System.out.println();
	        System.out.println();
	    } catch (NoRecordFoundException | SomeThingWentWrongException ex) {
	        System.out.println(ex.getMessage());
	    } finally {
	        em.close();
	    }
	}



}
