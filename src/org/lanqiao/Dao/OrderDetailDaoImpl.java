package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.OrderDetail;
import org.lanqiao.util.DBUtil;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public void insertOrderList(OrderDetail orderdetail) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_orderdetail values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, orderdetail.getOrderdetailid());
			ps.setString(2, orderdetail.getGtitle());
			ps.setDouble(3, orderdetail.getGsaleprice());
			ps.setInt(4, orderdetail.getGnumber());
			ps.setString(5, orderdetail.getOrderid());

			
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
	public List<OrderDetail> getOrderDetailList() {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_orderdetail";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			OrderDetail orderdetail =null;
			while(rs.next())
			{
				orderdetail = new OrderDetail(rs.getString("orderdetailid"), rs.getString("gtitle"), rs.getDouble("gsaleprice"), rs.getInt("gnumber"), rs.getString("orderid"));
				list.add(orderdetail);
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
	public void updateNumber(int gnumber,String orderid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_orderdetail set gnumber=? where orderid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gnumber);
			ps.setString(2, orderid);
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
	public void deleteOrderDetail(String orderid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_orderdetail where orderid =?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, orderid);
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
	public void deleteOrderDetailByOrderid(String orderid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_orderdetail where orderid =?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, orderid);
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
	public void updateOrderDetail(OrderDetail orderdetail) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_orderdetail set gtitle=?,gsaleprice=?,gnumber=? where orderdetailid=?";
			
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,orderdetail.getGtitle());
			ps.setDouble(2,orderdetail.getGsaleprice());
			ps.setInt(3,orderdetail.getGnumber());
			ps.setString(4,orderdetail.getOrderdetailid());
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
	public void deleteOrderDetailByOrderDetailid(String orderdetailid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_orderdetail where orderdetailid =?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, orderdetailid);
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
	public OrderDetail getOrderDetail(String orderdetailid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_orderdetail where orderdetailid=?";
		OrderDetail orderdetail =null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderdetailid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				orderdetail = new OrderDetail(rs.getString("orderdetailid"), rs.getString("gtitle"), rs.getDouble("gsaleprice"), rs.getInt("gnumber"), rs.getString("orderid"));
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
		return orderdetail;
	}

}
