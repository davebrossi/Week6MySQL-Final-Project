package com.promineo.tech.Service;



import java.util.ArrayList;

import com.promineo.tech.Models.Forum;

public interface IForumService {
	ArrayList<Forum> getForum();
	Forum getForum(int forumId);
	void createForum(Forum forum);
	void deleteForum(Forum forum);
}
