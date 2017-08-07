package com.ys.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ys.entity.Admin;

public class AdminDao extends BaseDao{

	
	public void addAdmin(Admin admin){
		String sql = "INSERT INTO GUANLIYUAN VALUES(SQ_GLY.NEXTVAL,?,?,?,?)";
		
		try {
			conn = this.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, admin.getDENGLUMING());
			ps.setString(2, admin.getDENGLUMIMA());
			ps.setInt(3, admin.getQUANXIAN());
			ps.setString(4, admin.getMINGZI());
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		
	}

	public List<Admin> findAdminByPage(int begin ,int end) {
		String sql = "SELECT * FROM (SELECT T.* , ROWNUM  R FROM GUANLIYUAN T WHERE ROWNUM  < ?)WHERE  R > ?";
		
		List<Admin> list = new ArrayList<Admin>();
		
		try {
			conn  = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, end+1);
			ps.setInt(2, begin);
			rs = ps.executeQuery();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setDENGLUMING(rs.getString("DENGLUMING"));
				admin.setDENGLUMIMA(rs.getString("DENGLUMIMA"));
				admin.setQUANXIAN(rs.getInt("QUANXIAN"));
				admin.setMINGZI(rs.getString("MINGZI"));
				list.add(admin);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, ps, rs);
		}
		
		return list;
	}

	public int findAll() {
		String sql = "SELECT COUNT(*) FROM  GUANLIYUAN";
		
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return 0;
	}

	
}
