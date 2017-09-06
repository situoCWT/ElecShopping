package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.User;
import org.lanqiao.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(User user) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_user values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUemail());
			ps.setString(3, user.getUloginid());
			ps.setString(4, user.getUpassword());
			ps.setString(5, user.getUsex());
			ps.setString(6, user.getUaddress());
			ps.setString(7, user.getUtel());
			ps.setString(8, user.getUstateid());
			ps.setString(9, user.getUroleid());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean checkLogin(String uloginid, String upassword) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select count(*) from t_user where uloginid = ? and upassword = ?";
		int checkresult =0;
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, uloginid);
			ps.setString(2, upassword);
			rs = ps.executeQuery();
			if(rs.next())
			{
				checkresult = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(checkresult ==0)
		{
			return false;
		}
		return true;
	}

	@Override
	public User getUser(String uloginid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_user where uloginid = ?";
		User user =null;
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, uloginid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				user = new User(rs.getString("userid"), rs.getString("uemail"), rs.getString("uloginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public void updateUser(User user) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_user set upassword=?,usex=?,uaddress=?,utel=?,ustateid=? where uloginid=?";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, user.getUpassword());
			ps.setString(2, user.getUsex());
			ps.setString(3, user.getUaddress());
			ps.setString(4, user.getUtel());
			ps.setString(5, user.getUstateid());
			ps.setString(6, user.getUloginid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public List<User> getList() {
		List<User> list = new ArrayList<User>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_user";
		User user =null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				user = new User(rs.getString("userid"), rs.getString("uemail"), rs.getString("uloginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void deleteUser(String userid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_user where userid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
