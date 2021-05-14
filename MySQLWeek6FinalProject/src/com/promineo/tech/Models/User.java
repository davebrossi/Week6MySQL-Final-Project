package com.promineo.tech.Models;

public class User {
	private int Id;
	private String FirstName;
	private String LastName;
	
	public User(int id, String firstName, String lastName)
	{
		Id = id;
		FirstName = firstName;
		LastName = lastName;
	}
	
	public int getId()
	{
		return Id;
	}
	
	public String getFirstName()
	{
		return FirstName;
	}
	
	public String getLastName()
	{
		return LastName;
	}
	
			
	@Override
	public String toString()
	{
		return "UserId: " + Id + ", FirstName: " + FirstName + ", LastName: " + LastName;
	}
}
