package com.promineo.tech.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.tech.Models.Forum_Post;

public class Forum_Post_Repository extends MySqlRepository implements IForum_Post_Repository {
	private Connection connection;

	public Forum_Post_Repository() {
		connection = super.getConnection("rennlist");
	}

	@Override
	public ArrayList<Forum_Post> getForum_Post() {
		ArrayList<Forum_Post> forum_Post = new ArrayList<Forum_Post>();

		try {
			CallableStatement st = connection.prepareCall("{call getForum_Post()}");
			boolean hasResult = st.execute();
			if (hasResult) {
				ResultSet rs = st.getResultSet();

				while (rs.next()) {
					forum_Post.add(new Forum_Post(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return forum_Post;
		}

		return forum_Post;
	}

	@Override
	public Forum_Post getForum_Post(int forum_post_Id) {
		try {
			CallableStatement st = connection.prepareCall("{call getForum_postById(?)}");
			st.setInt(1, forum_post_Id);

			boolean hasResult = st.execute();
			if (hasResult) {
				ResultSet rs = st.getResultSet();

				while (rs.next()) {
					return new Forum_Post(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}

		return null;
	}

	@Override
	public void createForum_Post(Forum_Post forum_post) {
		try {
			CallableStatement st = connection.prepareCall("{call createForumPost(?, ?)}");
			st.setString(1, forum_post.getForum_Post_Name());
			st.setString(2, forum_post.getForum_Post_Body());
			st.execute();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void deleteForum_Post(Forum_Post forum_post) {
		try {
			CallableStatement st = connection.prepareCall("{call deleteForumPost(?)}");
			st.setInt(1, forum_post.getId());
			st.execute();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void updateForum_Post(Forum_Post forum_post) {
		try {
			CallableStatement st = connection.prepareCall("{call updateForum_Post(?, ?, ?)}");
			st.setInt(1, forum_post.getId());
			st.setString(2, forum_post.getForum_Post_Name());
			st.setString(3, forum_post.getForum_Post_Body());
			st.execute();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		}
	}
}
