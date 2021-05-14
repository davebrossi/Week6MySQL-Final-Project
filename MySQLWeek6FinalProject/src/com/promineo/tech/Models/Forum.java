package com.promineo.tech.Models;

public class Forum {
	private int Id;
	private String ForumName;
	private String ForumDescript;
	
	public Forum(int id, String forumName, String forumDescript)
	{
		Id = id;
		ForumName = forumName;
		ForumDescript = forumDescript;
	}
	
	public int getId()
	{
		return Id;
	}
	
	public String getForumName()
	{
		return ForumName;
	}
	
	public String getForumDescript()
	{
		return ForumDescript;
	}
	
			
	@Override
	public String toString()
	{
		return "ForumId: " + Id + ", ForumName: " + ForumName + ", ForumDescript: " + ForumDescript;
	}
}
