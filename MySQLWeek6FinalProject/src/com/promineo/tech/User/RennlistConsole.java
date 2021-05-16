package com.promineo.tech.User;


import java.util.Scanner;

import com.promineo.tech.Models.CrudChoice;
import com.promineo.tech.Models.MainMenuChoice;
import com.promineo.tech.Models.RennlistMenuModel;
import com.promineo.tech.Service.RennlistConsoleService;


public class RennlistConsole {
	private static RennlistMenuModel viewModel;
	private static Scanner scanner;
	public static void main(String[] args) {

		System.out.println("Welcome to Rennlist; where you'll be mocked for the Porsche you own because you're poor!");
		
		try
		{
			scanner = new Scanner(System.in);
			
			do
			{
				viewModel = new RennlistMenuModel();
				DisplayMainMenu();
				DisplayCrudMenu();
				DisplayDetailsScreen();
				
				if(viewModel.MainMenuChoice != MainMenuChoice.EXIT)
				{
					RennlistConsoleService rennlistconsoleservice = new RennlistConsoleService(viewModel);
				}
			}
			while(viewModel.MainMenuChoice != MainMenuChoice.EXIT);
			
			
			System.out.println("Thanks for stopping by!");
			scanner.close();
			
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			scanner.close();
		}
	}
	
	private static void DisplayMainMenu()
	{
		System.out.println("Please Choose from the Main Menu");
		System.out.println("1. Users");
		System.out.println("2. Forums");
		System.out.println("3. Forum Posts");
		System.out.println("4. Exit");
		
		if (scanner.hasNextInt())
		{
			viewModel.MainMenuChoice = MainMenuChoice.values()[scanner.nextInt() - 1];
			
		}
	}
	
	private static void DisplayCrudMenu()
	{
		System.out.println("Please choose from the Menu options available on this subject");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");				
		
		if(scanner.hasNextInt())
				{
					viewModel.CrudChoice = CrudChoice.values()[scanner.nextInt() - 1];
				}
	}		
private static void	DisplayDetailsScreen()
{
	switch (viewModel.MainMenuChoice)
	{
	case USER:
		switch (viewModel.CrudChoice)
		{
		case CREATE:
				System.out.println("Enter the User's First Name");
				viewModel.firstName = scanner.next();
				System.out.println("Enter the User's Last Name");
				viewModel.lastName = scanner.next();
				break;
		case READ:
			break;
		case UPDATE:
				System.out.println("Enter the User ID:");
				viewModel.UserId = scanner.nextInt();
				System.out.println("Enter the User's First Name");
				viewModel.firstName = scanner.next();
				System.out.println("Enter the User's Last Name");
				viewModel.lastName = scanner.next();
				break;
		case DELETE:
				System.out.println("Enter User ID");
				viewModel.UserId = scanner.nextInt();
				break;
				
		}
		break;
		case FORUM:
				switch (viewModel.CrudChoice)
				{
		case CREATE:
				System.out.println("Enter Forum Name: ");
				viewModel.forumName = scanner.next();
				System.out.println("Enter Forum Description: ");
				viewModel.forumDescript = scanner.next();
						break;
		case READ:
						break;
					case UPDATE:
						System.out.println("Enter Forum Id: ");
						viewModel.ForumID = scanner.nextInt();
						System.out.println("Enter Forum Name: ");
						viewModel.forumName = scanner.next();
						System.out.println("Enter Forum Description: ");
						viewModel.forumDescript = scanner.next();
						break;
					case DELETE:
						System.out.println("Enter Forum Id: ");
						viewModel.ForumID = scanner.nextInt();
						break;
				}
				break;
			case FORUM_POST:
				switch (viewModel.CrudChoice)
				{
					case CREATE:
						System.out.println("Enter the name of your post: ");
						viewModel.postTitle = scanner.next();
						System.out.println("What do you want to say in your post? ");
						viewModel.postBody = scanner.next();
						break;
					case READ:
						break;
					case UPDATE:
						System.out.println("Enter the Forum Post Id: ");
						viewModel.forum_post_ID = scanner.nextInt();
						System.out.println("Enter the name of your post: ");
						viewModel.postTitle = scanner.next();
						System.out.println("What do you want to say in your post?");
						viewModel.postBody = scanner.next();
						break;
					case DELETE:
						System.out.println("Enter the Forum Post Id: ");
						viewModel.forum_post_ID = scanner.nextInt();
						break;
				}
				break;
	case EXIT:
		break;
	default:
		break;
		}
	}
}