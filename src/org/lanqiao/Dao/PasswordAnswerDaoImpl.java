package org.lanqiao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.util.DBUtil;

public class PasswordAnswerDaoImpl implements PasswordAnswerDao {

	@Override
	public void insertPasswordAnswer(PasswordAnswer passwordanswer) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="insert into t_passwordanswer values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, passwordanswer.getAnswerid());
			ps.setString(2, passwordanswer.getAquestion());
			ps.setString(3, passwordanswer.getAnswer());
			ps.setString(4, passwordanswer.getEmail());
			ps.setString(5, passwordanswer.getUserid());
			
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
	public void updatePasswordAnswer(PasswordAnswer passwordanswer) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="update t_passwordanswer set aquestion=?,answer=?,email=? where userid=?";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, passwordanswer.getAquestion());
			ps.setString(2, passwordanswer.getAnswer());
			ps.setString(3, passwordanswer.getEmail());
			ps.setString(4, passwordanswer.getUserid());
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
	public PasswordAnswer getPasswordAnswer(String userid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_passwordanswer where userid = ?";
		PasswordAnswer passwordanswer =null;
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				passwordanswer = new PasswordAnswer(rs.getString("answerid"), rs.getString("aquestion"), rs.getString("answer"), rs.getString("email"), rs.getString("userid"));
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
		return passwordanswer;
	}

	@Override
	public void deletePasswordAnswerByUserid(String userid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql ="delete from t_passwordanswer where userid = ?";
		
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
