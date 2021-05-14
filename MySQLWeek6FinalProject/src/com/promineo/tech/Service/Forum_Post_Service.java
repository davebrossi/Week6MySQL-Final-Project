package com.promineo.tech.Service;
import java.util.ArrayList;

import com.promineo.tech.Models.Forum_Post;
import com.promineo.tech.Repository.Forum_Post_Repository;

public class Forum_Post_Service implements IForum_Post_Service {
private Forum_Post_Repository forum_Post_Repository;
	
	public Forum_Post_Service()
	{
		forum_Post_Repository = new Forum_Post_Repository();
	}
	
	@Override
	public ArrayList<Forum_Post> getForum_Post()
	{
		return forum_Post_Repository.getForum_Post();
	}

	@Override
	public Forum_Post getForum_Post(int forum_post_Id) {
		return forum_Post_Repository.getForum_Post(forum_post_Id);
	}

	@Override
	public void createForum_Post(Forum_Post forum_post) {
		forum_Post_Repository.createForum_Post(forum_post);
	}
	@Override
	public void deleteForum_Post(Forum_Post forum_Post) {
		forum_Post_Repository.deleteForum_Post(forum_Post);

	
}
}
