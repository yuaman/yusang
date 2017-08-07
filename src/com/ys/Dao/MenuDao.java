package com.ys.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ys.entity.Menu;

public class MenuDao extends BaseDao {
	
	public List<Menu> findMenu() {
		
		String sql = "select * from menu";

		List<Menu> list = new ArrayList<Menu>();

		try {
			conn = this.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Menu menu = new Menu(rs.getInt("MID"), rs.getString("TITLE"), rs.getString("URL"));
				
				list.add(menu);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(conn, ps, rs);
		}
		

		return list;
	}
}
