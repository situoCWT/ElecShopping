package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lanqiao.entity.Order;
import org.lanqiao.util.DBUtil;

public class OrderDaoImpl implements OrderDao {
	List<Order> list = new ArrayList<Order>();

	@Override
	public List<Order> getOrderList() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_order";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Order order =null;
			while(rs.next())
			{
				order = new Order(rs.getString("orderid"), rs.getString("userid"), rs.getString("gid"), rs.getDouble("totalprice"), this.getDate(rs.getDate("orderdate")), rs.getString("state"));
				list.add(order);
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
	public void insertOrderList(Order order) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_order values(?,?,?,?,sysdate,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, order.getOrderid());
			ps.setString(2, order.getUserid());
			ps.setString(3, order.getGid());
			ps.setDouble(4, order.getTotalprice());
//			ps.setString(5, "sysdate");
			ps.setString(5, order.getState());
			
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
	public void updateTatolPrice(double totalprice,String orderid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_order set totalprice=? where orderid=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, totalprice);
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
	public void deleteOrder(String gid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_order where gid = ?";
		
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
	public Order getOrder(String gid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_order where gid =?";
		Order order =null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				order = new Order(rs.getString("orderid"), rs.getString("userid"), rs.getString("gid"), rs.getDouble("totalprice"), rs.getDate("orderdate"), rs.getString("state"));
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
		return order;
	}

	@Override
	public void deleteOrderByUserid(String userid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_order where userid = ?";
		
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

	@Override
	public List<Order> getOrderList(String userid) {
		List<Order> orderlist = new ArrayList<Order>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_order where userid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			Order order =null;
			while(rs.next())
			{
				order = new Order(rs.getString("orderid"), rs.getString("userid"), rs.getString("gid"), rs.getDouble("totalprice"), rs.getDate("orderdate"), rs.getString("state"));
				orderlist.add(order);
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
		return orderlist;
	}

	@Override
	public void deleteOrderByOrderid(String orderid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_order where orderid = ?";
		
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
	public void updateOrderByOrder(Order order) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_order set gid=?,totalprice=?,orderdate=?,state=? where orderid=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getGid());
			ps.setDouble(2, order.getTotalprice());
			java.sql.Date sqlDate = new java.sql.Date(order.getOrderdate().getTime());
			ps.setDate(3, sqlDate);
			ps.setString(4, order.getState());
			ps.setString(5, order.getOrderid());
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
	public Order getOrderByOrderid(String orderid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_order where orderid =?";
		Order order =null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				order = new Order(rs.getString("orderid"), rs.getString("userid"), rs.getString("gid"), rs.getDouble("totalprice"), rs.getDate("orderdate"), rs.getString("state"));
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
		return order;
	}
public Date getDate(java.sql.Date date) {
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	String s = format.format(date);
	Date d =null;
	try {
		d = format.parse(s);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return d;
}

@Override
public void insertOrderListByGetDate(Order order) {
	Connection conn = DBUtil.getConnection();
	PreparedStatement ps = null;
	String sql ="insert into t_order values(?,?,?,?,?,?)";
	try {
		ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, order.getOrderid());
		ps.setString(2, order.getUserid());
		ps.setString(3, order.getGid());
		ps.setDouble(4, order.getTotalprice());
		ps.setDate(5, getSqlDate(order.getOrderdate()));
		ps.setString(6, order.getState());
		
		ps.executeUpdate();
		System.out.println("123");
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
public java.sql.Date getSqlDate(Date date) {
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	String s = format.format(date);
	java.sql.Date d =   java.sql.Date.valueOf(s);
	return d;
}

@Override
public void updateState() {
	// TODO Auto-generated method stub
	Connection conn = DBUtil.getConnection();
	PreparedStatement ps = null;
	String sql ="update t_order set state=1 where state=0";
	
	try {
		ps = conn.prepareStatement(sql);
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
