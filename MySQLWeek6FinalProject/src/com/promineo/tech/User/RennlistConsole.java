package com.promineo.tech.User;


import java.util.Scanner;


import com.promineo.tech.Models.RennlistMenuModel;

import com.promineo.tech.Service.RennlistConsoleService;


public class RennlistConsole {
	private static RennlistMenuModel viewModel;
	private static Scanner scanner;
	public static void main(String[] args) {

		System.out.println("Welcome to Rennlist; where you'll be mocked for the Porsche you own!");
		
		try
		{
			scanner = new Scanner(System.in);
			
			do
			{
				viewModel = new RennlistMenuModel();
				DisplayMainMenu();
				if(scanner.hasNextInt())
				{
					viewModel.mainMenuChoice = scanner.nextInt();
				}
				DisplayCrudMenu();
				if(scanner.hasNextInt())
				{
					viewModel.crudChoice = scanner.nextInt();
				}
				DisplayDetailsScreen();
				
				RennlistConsoleService rennlistService = new RennlistConsoleService(viewModel);
				rennlistService.StartRennlistService();
				
			} 
			while(viewModel.mainMenuChoice != 4);	
			
			scanner.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			scanner.close();
		}
	}

	private static void DisplayMainMenu()
	{
		System.out.println("Main Menu");
		System.out.println("1. Users");
		System.out.println("2. Forums");
		System.out.println("3. Forum Posts");
		System.out.println("4. Exit");
	}
	
	private static void DisplayCrudMenu()
	{
		System.out.println("Please choose from the Menu options available on this subject");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
	}
	
	private static void DisplayDetailsScreen()
	{
		switch (viewModel.mainMenuChoice) 
		{
			case 1:
				switch (viewModel.crudChoice)
				{
					case 1:
						System.out.println("Enter User First Name: ");
						viewModel.firstName = scanner.next();
						System.out.println("Enter User Last Name: ");
						viewModel.lastName = scanner.next();
						break;
					case 3:
						System.out.println("Enter User Id: ");
						viewModel.UserId = scanner.nextInt();
						System.out.println("Enter User's First Name: ");
						viewModel.firstName = scanner.next();
						System.out.println("Enter User's Last Name: ");
						viewModel.lastName = scanner.next();
						break;
					case 4:
						System.out.println("Enter User Id: ");
						viewModel.UserId = scanner.nextInt();
						break;
				}
				break;
			case 2:
				switch (viewModel.crudChoice)
				{
					case 1:
						System.out.println("Enter Forum Name: ");
						viewModel.forumName = scanner.next();
						System.out.println("Enter Forum Description: ");
						viewModel.forumDescript = scanner.next();
						break;
					case 3:
						System.out.println("Enter Forum Id: ");
						viewModel.ForumID = scanner.nextInt();
						System.out.println("Enter Forum Name: ");
						viewModel.forumName = scanner.next();
						System.out.println("Enter Forum Description: ");
						viewModel.forumDescript = scanner.next();
						break;
					case 4:
						System.out.println("Enter Forum Id: ");
						viewModel.ForumID = scanner.nextInt();
						break;
				}
				break;
			case 3:
				switch (viewModel.crudChoice)
				{
					case 1:
						System.out.println("Enter the name of your post: ");
						viewModel.postTitle = scanner.next();
						System.out.println("What do you want to say in your post? ");
						viewModel.postBody = scanner.next();
						break;
					case 3:
						System.out.println("Enter the Forum Post Id: ");
						viewModel.forum_post_ID = scanner.nextInt();
						System.out.println("Enter the name of your post: ");
						viewModel.postTitle = scanner.next();
						System.out.println("What do you want to say in your post?");
						viewModel.postBody = scanner.next();
						break;
					case 4:
						System.out.println("Enter the Forum Post Id: ");
						viewModel.forum_post_ID = scanner.nextInt();
						break;
				}
				break;
		}
	}
}