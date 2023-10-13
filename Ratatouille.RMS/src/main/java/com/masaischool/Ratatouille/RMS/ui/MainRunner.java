package com.masaischool.Ratatouille.RMS.ui;

import java.util.Scanner;

public class MainRunner {

	// Displays the admin menu options
    static void displayAdminMenu() {
        // ... (output menu options)


		System.out.println();
		System.out.println("+===========================+");
		System.out.println();
		System.out.println("1. Add Recipes");
		System.out.println("2. Update the Recipes");
		System.out.println("3. Delete Recipes");
		System.out.println("4. View All Recipe Likes");
		System.out.println("5. View Recipe Review");
		System.out.println("-1. Previous Menu");
		System.out.println("0. Logout");
		System.out.println();
		System.out.println("+===========================+");
		System.out.println();
		System.out.println();
	}
//  <===============================MENU PORTAL STARTS HERE====================================>
 // Main logic for the admin menu
    static void adminMenu(Scanner sc) {
        // ... (loops through menu options and calls appropriate methods)
    
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch (choice) {
    			case 1:
    				AdminUI.addRecipe(sc);
    				break;
    			case 2:
    				AdminUI.updateRecipe(sc);
    				break;
    			case 3:
    				AdminUI.deleteRecipe(sc);
    				break;
    			case 4:
    				AdminUI.viewLikes();
    				break;
    			case 5:
    				RecipeReport.viewTrendingRecipesForLast7Days();
    				break;
//    			case 7:
//    				AdminUI.updatePremiumAndSurcharge(sc);
//    				break;
//    			case 8:
//    				AdminUI.viewAllCustomers();
//    				break;
//    			case 9:
//    				AdminUI.viewPolicyReport();
//    				break;
//    			case 10:
//    				AdminUI.makePoliciesDiscontinued();
//    				break;
    			case -1:
    				MainRunner.main(new String[0]);
    				break;
			case 0:
				System.out.println();
				System.out.println("Good Bye Admin 👋");
				System.out.println();
				System.out.println("============================");
				System.out.println();
				System.out.println();
				break;
			default:
				System.out.println();
				System.out.println("🚫 Invalid Selection 🚫, try again");
				System.out.println();
				System.out.println("==================================");
				System.out.println();
				System.out.println();
			}
		} while (choice != 0);
	}

	
	
//  <===============================ADMIN PORTAL STARTS HERE====================================>
	
 // Handles admin login and navigation to the admin menu
    static void adminLogin(Scanner sc) {
        // ... (asks for username and password, validates, and calls adminMenu)
  
		System.out.println();
		System.out.println("===============");
		System.out.println();
		System.out.print("Enter username 👨‍💻");
		String username = sc.next();
		System.out.print("Enter password 🔑");
		String password = sc.next();
		
		if (username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		} else {
			System.out.println();
			System.out.println();
			System.out.println("===============================");
			System.out.println();
			System.out.println("🚫 Invalid Username of Password");
			System.out.println();
			System.out.println("===============================");
			System.out.println();
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			
			// Displays the main menu for selecting user roles
			System.out.println();
			System.out.println("===========================================");
			System.out.println("🧀 RATATOUILLE RECIPE MANAGEMENT SYSTEM 🧀");
			System.out.println("===========================================");
			System.out.println();
			System.out.println("============================");
			System.out.println();
			System.out.println("1. 👨‍💻 Admin Login ");
			System.out.println("2. 🔑 Customer Login ");
			System.out.println("3. 👤 Customer Registration ");
			System.out.println("0. ❌ Exit");
			System.out.println();
			System.out.println("============================");
			System.out.println();
			System.out.println();
			System.out.print("Enter Selection ");
			
			// ... (prompts user for input and navigates to respective logic)
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				adminLogin(sc);
				break;
    			case 2:
    				CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				CustomerUI.customerRegistration(sc);
    				break;
			case 0:
				System.out.println("================================");
				System.out.println("Thanks for using the services 🫰");
				System.out.println("================================");
				break;
			default:

				System.out.println("🚫 Invalid Selection 🚫, try again");
			}
		} while (choice != 0);
		
		sc.close();
	}
}
