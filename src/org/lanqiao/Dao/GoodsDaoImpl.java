package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Goods;
import org.lanqiao.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao {

	public List<Goods> goodslist(String gid) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_goods where gid=?";
		Goods goods = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
				list.add(goods);
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
	public List<Goods> allgoodslist() {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_goods";
		Goods goods = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
				list.add(goods);
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
	public List<Goods> getgoodslistbycid(String cid) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_goods where cid=?";
		Goods goods = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
				list.add(goods);
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
	public void delectgoodsbygid(String gid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_goods where gid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
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
	public void insertgood(Goods good) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_goods values(?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, good.getGid());
			ps.setString(2, good.getGtitle());
			ps.setString(3, good.getGauthor());
			ps.setDouble(4, good.getGsaleprice());
			ps.setDouble(5, good.getGinprice());
			ps.setString(6, good.getGdesc());
			ps.setString(7, good.getGimg());
			ps.setInt(8, good.getGclick());
			ps.setString(9, good.getCid());
			ps.setString(10, good.getPid());
			
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
	public Goods getgoods(String gid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_goods where gid=?";
		Goods goods = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
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
		return goods;
	}

	@Override
	public void updategood(Goods good) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_goods set gtitle=?,gauthor=?,gsaleprice=?,ginprice=?,gdesc=?,gimg=?,gclick=?,cid=?,pid=? where gid=?";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, good.getGtitle());
			ps.setString(2, good.getGauthor());
			ps.setDouble(3, good.getGsaleprice());
			ps.setDouble(4, good.getGinprice());
			ps.setString(5, good.getGdesc());
			ps.setString(6, good.getGimg());
			ps.setInt(7, good.getGclick());
			ps.setString(8, good.getCid());
			ps.setString(9, good.getPid());
			ps.setString(10, good.getGid());
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
	public List<Goods> getgoodslistbylike(String value, String cid) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from (select t1.*,rownum rn from (select * from t_goods where (gtitle like ? or gdesc like ?) and cid = ?) t1 where rownum<=5) t2 where rn>=1";
		Goods goods = null;
		try {
			ps = conn.prepareStatement(sql);
			String s = "%"+value+"%";
			ps.setString(1, s);
			ps.setString(2, s);
			ps.setString(3, cid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
				list.add(goods);
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

}
