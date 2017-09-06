package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DBUtil;

public class PublisherDaoImpl implements PublisherDao {

	@Override
	public Publisher getPublisher(String pid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_publisher where pid =?";
		org.lanqiao.entity.Publisher publisher = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				publisher = new Publisher(rs.getString("pid"), rs.getString("pname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return publisher;
	}

	@Override
	public List<Publisher> getPublisher() {
		List<Publisher> list = new ArrayList<Publisher>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_publisher";
		org.lanqiao.entity.Publisher publisher = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				publisher = new Publisher(rs.getString("pid"), rs.getString("pname"));
				list.add(publisher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null)
					rs.close();
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
	public void deletePublisher(String pid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_publisher where pid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
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
	public void insertPublisher(Publisher publisher) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_publisher values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, publisher.getPid());
			ps.setString(2, publisher.getPname());
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
	public void updatePublisher(Publisher publisher) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_publisher  set pname=? where pid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, publisher.getPname());
			ps.setString(2, publisher.getPid());
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
