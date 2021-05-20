package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.Forum_Post;

public interface IForum_Post_Service {
	ArrayList<Forum_Post> getForum_Post();

	Forum_Post getForum_Post(int forum_post_Id);

	void createForum_Post(Forum_Post forum_Post);

	void deleteForum_Post(Forum_Post forum_Post);

	void updateForum_Post(Forum_Post forum_post);
}
