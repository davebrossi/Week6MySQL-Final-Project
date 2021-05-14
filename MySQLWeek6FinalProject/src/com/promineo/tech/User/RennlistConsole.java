package com.promineo.tech.User;

import java.util.ArrayList;

import com.promineo.tech.Models.Forum_Post;
import com.promineo.tech.Models.Forum;
import com.promineo.tech.Models.User;
import com.promineo.tech.Service.UserService;
import com.promineo.tech.Service.ForumService;
import com.promineo.tech.Service.Forum_Post_Service;


public class RennlistConsole {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Application for CRUD system, User, Forum, Forum Post (Console)
		try
		{
			UserService userService = new UserService();
			
			//Create 3 Users
			System.out.println("Creating 3 new users...");
			userService.createUser(new User(0, "Manish", "Narayan"));
			userService.createUser(new User(0, "Elizabeth", "Rossi"));
			userService.createUser(new User(0, "Adam", "Brown"));
			
			//Get All Users
			System.out.println("Reading all Users...");
			ArrayList<User> user = userService.getUser();
			for (User users : user)
			{
				System.out.println(user);
			}
			
			//Get User by Id = 2
			System.out.println("Getting User with Id = 2...");
			User users = userService.getUser(2);
			if(user != null)
			{
				System.out.println(user);
			}
			else
			{
				System.out.println("User does not exist");
			}
			
			//Delete User by Id = 3
			System.out.println("Deleting User With Id = 3...");
			User user3 = userService.getUser(3);
			if(user3 != null)
			{
				userService.deleteUser(user3);
			}
			else
			{
				System.out.println("User does not exist");
			}
			

		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		try
		{
			ForumService forumService = new ForumService();
			
			//Create 3 forums
			System.out.println("Creating 3 new forums...");
			forumService.createForum(new Forum(0, "Air Cooled", "911/912/914 Porsches"));
			forumService.createForum(new Forum(0, "Early Water Cooled", "924/944/968 Porsches"));
			forumService.createForum(new Forum(0, "Cayennes", "955/957/958 Cayennes"));
			
			//Get All forums
			System.out.println("Reading all forums...");
			ArrayList<Forum> forum = forumService.getForum();
			for (Forum forums : forum)
			{
				System.out.println(forum);
			}
			
			//Get forum by Id = 2
			System.out.println("Getting forum with forum Id = 2...");
			Forum forums = forumService.getForum(2);
			if(forum != null)
			{
				System.out.println(forum);
			}
			else
			{
				System.out.println("Forum does not exist");
			}
			
			//Delete forum by Id = 3
			System.out.println("Deleting forum with forum Id = 3...");
			Forum forum3 = forumService.getForum(3);
			if(forum3 != null)
			{
				forumService.deleteForum(forum3);
			}
			else
			{
				System.out.println("Forum does not exist");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		try
		{
			Forum_Post_Service forum_Post_Service = new Forum_Post_Service();
			
			//Create 3 Forum Posts
			System.out.println("Creating 3 new Forum Posts...");
			forum_Post_Service.createForum_Post(new Forum_Post(0, "914s are cool", "Seriously if they were not rusted they rock"));
			forum_Post_Service.createForum_Post(new Forum_Post(0, "957 bore scoring is bad", "everything because Porsche cannot line cylinders"));
			forum_Post_Service.createForum_Post(new Forum_Post(0, "924 turbos need more love", "their warmup regulators suck but 931s are great"));
			
			//Get All Forum Posts
			System.out.println("Reading all Forum Posts...");
			ArrayList<Forum_Post> forum_post = forum_Post_Service.getForum_Post();
			for (Forum_Post forum_posts : forum_post)
			{
				System.out.println(forum_post);
			}
			
			//Get Forum Posts by Id = 2
			System.out.println("Getting the Forum Post with Id = 2...");
			Forum_Post forum_posts = forum_Post_Service.getForum_Post(2);
			if(forum_post != null)
			{
				System.out.println(forum_post);
			}
			else
			{
				System.out.println("That Forum Post does not exist");
			}
			
			//Delete Forum Post by Id = 3
			System.out.println("Deleting the Forum Post with Id = 3...");
			Forum_Post forum_post3 = forum_Post_Service.getForum_Post(3);
			if(forum_post3 != null)
			{
				forum_Post_Service.deleteForum_Post(forum_post3);
			}
			else
			{
				System.out.println("Forum Post does not exist");

		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
