package com.promineo.tech.Models;

public class Forum_Post {
	private int Id;
	private String Forum_Post_Name;
	private String Forum_Post_Body;

	public Forum_Post(int id, String forum_post_name, String forum_post_body) {
		Id = id;
		Forum_Post_Name = forum_post_name;
		Forum_Post_Body = forum_post_body;
	}

	public int getId() {
		return Id;
	}

	public void setForum_Post_Name(String forum_post_name) {
		Forum_Post_Name = forum_post_name;
	}

	public String getForum_Post_Name() {
		return Forum_Post_Name;
	}

	public String getForum_Post_Body() {
		return Forum_Post_Body;
	}

	public void setForum_Post_Body(String forum_post_body) {
		Forum_Post_Body = forum_post_body;
	}

	@Override
	public String toString() {
		return "ForumId: " + Id + ", Forum_Post_Name: " + Forum_Post_Name + ", Forum_Post_Body: " + Forum_Post_Body;
	}
}
