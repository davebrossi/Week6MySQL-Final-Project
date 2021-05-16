package com.promineo.tech.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.promineo.tech.Models.User;

public class UserRepository extends MySqlRepository implements IUserRepository {
	private Connection connection;
	public UserRepository()
	{
		connection = super.getConnection("rennlist");
	}
	
	@Override
	public ArrayList<User> getUser() {
		ArrayList<User> user = new ArrayList<User>();

		try
		{
			CallableStatement st = connection.prepareCall("{call getUser()}");
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					user.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return user;
		}
		
		return user;
	}
	@Override
	public User getUser(int userId) {
		try
		{
			CallableStatement st = connection.prepareCall("{call getUserById(?)}");
			st.setInt(1, userId);
			
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
		return null;
	}
	
	@Override
	public void createUser(User user) {
		try
		{
			CallableStatement st = connection.prepareCall("{call createUser(?, ?)}");
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void deleteUser(User user) {
		try
		{
			CallableStatement st = connection.prepareCall("{call deleteUser(?)}");
			st.setInt(1, user.getId());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	@Override
	public void updateUser(User user) {
		try
		{
			CallableStatement st = connection.prepareCall("{call updateUser(?, ?, ?)}");
			st.setInt(1, user.getId());
			st.setString(2, user.getFirstName());
			st.setString(3, user.getLastName());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
	}
}
