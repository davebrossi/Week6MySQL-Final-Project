package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.Forum;
import com.promineo.tech.Repository.ForumRepository;

public class ForumService implements IForumService {
	private ForumRepository forumRepository;

	public ForumService() {
		forumRepository = new ForumRepository();
	}

	@Override
	public ArrayList<Forum> getForum() {
		return forumRepository.getForum();
	}

	@Override
	public Forum getForum(int forumId) {
		return forumRepository.getForum(forumId);
	}

	@Override
	public void createForum(Forum forum) {
		forumRepository.createForum(forum);
	}

	@Override
	public void deleteForum(Forum forum) {
		forumRepository.deleteForum(forum);
	}

	@Override
	public void updateForum(Forum forum) {
		forumRepository.updateForum(forum);
	}
}
