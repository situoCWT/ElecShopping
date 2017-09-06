package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.util.DBUtil;

public class PageInfoDaoImpl implements PageInfoDao {

	PageInfo<Goods> pageinfo = new PageInfo<Goods>();
	List<Goods> list = new ArrayList<Goods>();
	@Override
	public PageInfo<Goods> goodslist(String cid, int pagesize, int pageindex) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =null;
		if(cid.equals("15"))
		{
			sql ="select * from (select t1.*,rownum rn from (select * from t_goods) t1 where rownum<=?) t2 where rn>=?";
		}
		else{
			
			sql ="select * from (select t1.*,rownum rn from (select * from t_goods where cid=?) t1 where rownum<=?) t2 where rn>=?";
		}
		Goods goods = null;
		try {
			ps = conn.prepareStatement(sql);
			int startindex = (pageindex-1)*pagesize+1;
			int endindex = pageindex*pagesize;
			if(cid.equals("15")){
				ps.setInt(1, endindex);
				ps.setInt(2, startindex);
			}
			else{
				ps.setString(1, cid);
				ps.setInt(2, endindex);
				ps.setInt(3, startindex);
			}
			rs = ps.executeQuery();
			while(rs.next())
			{
				goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
				list.add(goods);
			}
			pageinfo.setList(list);
			pageinfo.setPageindex(pageindex);
			pageinfo.setPagesize(pagesize);
			int totalnumber = gettotalnumber(cid);
			pageinfo.setTotalnumber(totalnumber);
			int totalpages = totalnumber%pagesize==0?totalnumber/pagesize:totalnumber/pagesize+1;
			pageinfo.setTotalpages(totalpages);
			pageinfo.setIsfirstpage(pageindex==1);
			pageinfo.setIslastpage(pageindex==totalpages);
			
			
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
		return pageinfo;
	}
	@Override
	public int gettotalnumber(String s) {
		int totalnumber=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		if(s.equals("15"))
		{
			sql = "select count(*) from t_goods";
		}
		else{
			sql ="select count(*) from t_goods where cid=?";
		}
		try {
			ps = conn.prepareStatement(sql);
			if(s.equals("15")){
				
			}
			else{				
				ps.setString(1,s);
			}
			rs = ps.executeQuery();
			if(rs.next())
			{
				totalnumber = rs.getInt(1);
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
		return totalnumber;
	}
	@Override
	public PageInfo<Goods> getgoodslistbylike(String value, String cid,
			int pagesize, int pageindex) {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql =null;
			if(cid.equals("15"))
			{
				sql ="select * from (select t1.*,rownum rn from (select * from t_goods) t1 where rownum<=?) t2 where rn>=?";
			}
			else{
				
				sql ="select * from (select t1.*,rownum rn from (select * from t_goods where (gtitle like ? or gdesc like ?) and cid = ?) t1 where rownum<=?) t2 where rn>=?";
			}
			Goods goods = null;
			try {
				ps = conn.prepareStatement(sql);
				int startindex = (pageindex-1)*pagesize+1;
				int endindex = pageindex*pagesize;
				if(cid.equals("15")){
					ps.setInt(1, endindex);
					ps.setInt(2, startindex);
				}
				else{
					String s = "%"+value+"%";
					ps.setString(1, s);
					ps.setString(2, s);
					ps.setString(3, cid);
					ps.setInt(4, endindex);
					ps.setInt(5, startindex);
				}
				rs = ps.executeQuery();
				while(rs.next())
				{
					goods = new Goods(rs.getString("gid"),rs.getString("gtitle"),rs.getString("gauthor"),rs.getDouble("gsaleprice"),rs.getDouble("ginprice"),rs.getString("gdesc"),rs.getString("gimg"),rs.getInt("gclick"),rs.getString("cid"),rs.getString("pid"));
					list.add(goods);
				}
				pageinfo.setList(list);
				pageinfo.setPageindex(pageindex);
				pageinfo.setPagesize(pagesize);
				int totalnumber = gettotalnumber(cid);
				pageinfo.setTotalnumber(totalnumber);
				int totalpages = totalnumber%pagesize==0?totalnumber/pagesize:totalnumber/pagesize+1;
				pageinfo.setTotalpages(totalpages);
				pageinfo.setIsfirstpage(pageindex==1);
				pageinfo.setIslastpage(pageindex==totalpages);
				
				
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
			return pageinfo;
	}
	
}
