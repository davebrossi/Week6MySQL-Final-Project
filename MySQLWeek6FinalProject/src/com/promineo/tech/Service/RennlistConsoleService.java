package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.Forum_Post;
import com.promineo.tech.Models.User;
import com.promineo.tech.Models.Forum;
import com.promineo.tech.Models.RennlistMenuModel;

public class RennlistConsoleService implements IRennlistConsoleService{
	private RennlistMenuModel viewModel;
	private UserService userService;
	private ForumService forumService;
	private Forum_Post_Service forum_postService;
	
	public RennlistConsoleService(RennlistMenuModel model)
	{
		viewModel = model;
		userService = new UserService();
		forumService = new ForumService();
		forum_postService = new Forum_Post_Service();
	}
	@Override
	public void StartRennlistConsoleService() 
	{
		User user;
		Forum forum;
		Forum_Post forum_post;
		
		switch (viewModel.MainMenuChoice)
		{
			case USER:
				switch (viewModel.CrudChoice) 
				{
					case CREATE:
						userService.createUser(new User(0, viewModel.firstName, viewModel.lastName));
						System.out.println("User has been created");
						break;
					case READ :
						System.out.println("Current Users on file");
						ArrayList<User> users = userService.getUser();
						for (User s : users)
						{
							System.out.println(s);
						}
						break;
					case UPDATE :
						user = userService.getUser(viewModel.UserId);
						if(user != null)
						{
							user.setFirstName(viewModel.firstName);
							user.setLastName(viewModel.lastName);
							userService.updateUser(user);
							System.out.println("User has been updated!");
						}
						else
						{
							System.out.println("User not found");
						}
						break;
					case DELETE :
						user = userService.getUser(viewModel.UserId);
						if(user != null)
						{
							userService.deleteUser(user);
							System.out.println("User deleted.");
						}
						else
						{
							System.out.println("User not found.");
						}
						break;
					default:
						System.out.println("Invalid Menu Selection");
						break;
				}
				break;
			case FORUM :
				switch (viewModel.CrudChoice) 
				{
					case CREATE:
						forumService.createForum(new Forum(0, viewModel.forumName, viewModel.forumDescript));
						System.out.println("Forum has been established");
						break;
					case READ:
						System.out.println("Current Forums Operational");
						ArrayList<Forum> forums = forumService.getForum();
						for (Forum t : forums)
						{
							System.out.println(t);
						}
						break;
					case UPDATE:
						forum = forumService.getForum(viewModel.ForumID);
						if(forum != null)
						{
							forum.setForumName(viewModel.forumName);
							forum.setForumDescript(viewModel.forumDescript);
							forumService.updateForum(forum);
							System.out.println("Forum updated.");
						}
						else
						{
							System.out.println("Forum not found.");
						}
						break;
					case DELETE:
						forum = forumService.getForum(viewModel.ForumID);
						if(forum != null)
						{
							forumService.deleteForum(forum);
							System.out.println("Forum has been deleted.");
						}
						else
						{
							System.out.println("Forum not found.");
						}
						break;
					default:
						System.out.println("Invalid Menu Selection");
						break;
				}
				break;
			case FORUM_POST:
				switch (viewModel.CrudChoice) 
				{
					case CREATE:
						forum_postService.createForum_Post(new Forum_Post(0, viewModel.postTitle, viewModel.postBody));
						System.out.println("Your Forum Post has been submitted.");
						break;
					case READ:
						System.out.println("List of active forum threads.");
						ArrayList<Forum_Post> forum_posts = forum_postService.getForum_Post();
						for (Forum_Post c : forum_posts)
						{
							System.out.println(c);
						}
						break;
					case UPDATE:
						forum_post = forum_postService.getForum_Post(viewModel.forum_post_ID);
						if(forum_post != null)
						{
							forum_post.setForum_Post_Name(viewModel.postTitle);
							forum_post.setForum_Post_Body(viewModel.postBody);
							forum_postService.updateForum_Post(forum_post);
							System.out.println("Your post has been updated.");
						}
						else
						{
							System.out.println("Forum Post not found.");
						}
						break;
					case DELETE:
						forum_post = forum_postService.getForum_Post(viewModel.forum_post_ID);
						if(forum_post != null)
						{
							forum_postService.deleteForum_Post(forum_post);
							System.out.println("Your forum thread has been deleted");
						}
						else
						{
							System.out.println("Forum Post not found.");
						}
						break;
					default:
						System.out.println("Invalid Menu Selection.");
						break;
				}
				break;
			default:
				System.out.println("Invalid Main Menu selection.");
				break;
		}
		
	}
		
	}
