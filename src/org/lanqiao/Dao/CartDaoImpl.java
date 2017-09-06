package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Cart;
import org.lanqiao.util.DBUtil;

public class CartDaoImpl implements CartDao {

	@Override
	public List<Cart> getCartList() {
		List<Cart> list = new ArrayList<Cart>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_order t1 left join t_orderdetail t2 on t1.orderid = t2.ORDERID where state=0";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Cart cart =null;
			while(rs.next())
			{
				cart = new Cart(rs.getString("orderid"), rs.getString("userid"),rs.getString("gid"), rs.getDouble("totalprice"), rs.getDate("orderdate"), rs.getString("state"), rs.getString("orderdetailid"), rs.getString("gtitle"), rs.getDouble("gsaleprice"), rs.getInt("gnumber"));
				list.add(cart);
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



}
