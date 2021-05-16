package com.promineo.tech.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.tech.Models.Forum;

public class ForumRepository extends MySqlRepository implements IForumRepository {
	private Connection connection;
	public ForumRepository()
	{
		connection = super.getConnection("rennlist");
	}
	
	@Override
	public ArrayList<Forum> getForum() {
		ArrayList<Forum> forum = new ArrayList<Forum>();

		try
		{
			CallableStatement st = connection.prepareCall("{call getForum()}");
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					forum.add(new Forum(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return forum;
		}
		
		return forum;
	}
	@Override
	public Forum getForum(int forumId) {
		try
		{
			CallableStatement st = connection.prepareCall("{call getForumById(?)}");
			st.setInt(1, forumId);
			
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					return new Forum(rs.getInt(1), rs.getString(2), rs.getString(3));
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
	public void createForum(Forum forum) {
		try
		{
			CallableStatement st = connection.prepareCall("{call createForum(?, ?)}");
			st.setString(1, forum.getForumName());
			st.setString(2, forum.getForumDescript());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void deleteForum(Forum forum) {
		try
		{
			CallableStatement st = connection.prepareCall("{call deleteForum(?)}");
			st.setInt(1, forum.getId());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void updateForum(Forum forum) {
		try
		{
			CallableStatement st = connection.prepareCall("{call updateForum(?, ?, ?)}");
			st.setInt(1, forum.getId());
			st.setString(1, forum.getForumName());
			st.setString(2, forum.getForumDescript());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
}
	}
}
