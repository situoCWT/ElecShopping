package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Category;
import org.lanqiao.util.DBUtil;

public class CategoryDaoImpl implements CategoryDao{

	List<Category> list = null;
	public CategoryDaoImpl(){
		list = new ArrayList<Category>();
	}
	@Override
	public List<Category> list() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_category where cid!=15 order by corder asc";
		org.lanqiao.entity.Category cate = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				cate = new org.lanqiao.entity.Category(rs.getString("cid"),rs.getString("cname"),rs.getInt("corder"));
				list.add(cate);
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

	public Category getCategory(String cid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_category where cid=?";
		org.lanqiao.entity.Category cate = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				cate = new org.lanqiao.entity.Category(rs.getString("cid"),rs.getString("cname"),rs.getInt("corder"));
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
		return cate;
	}
	@Override
	public void deleteCategoryByCid(String cid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_category where cid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
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
	public void insertCategory(Category category) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_category values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCid());
			ps.setString(2, category.getCname());
			ps.setString(3, category.getCid());
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
	public void updateCategory(String cid,String cname) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_category  set cname=? where cid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, cid);
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
