package com.promineo.tech.Repository;

import java.util.ArrayList;

import com.promineo.tech.Models.Forum;

public interface IForumRepository {
	ArrayList<Forum> getForum();
	Forum getForum(int ForumId);
	void createForum(Forum forum);
	void deleteForum(Forum forum);
	void updateForum(Forum forum);
}

