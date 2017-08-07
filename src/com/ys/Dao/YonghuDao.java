package com.ys.Dao;

import java.sql.SQLException;

import com.ys.entity.Yonghu;

public class YonghuDao extends BaseDao{

	

		/**
		 * 判断用户名存在
		 * @param dengluMing
		 * @return
		 */
		public boolean youDengluMing(String dengluMing){
			
			String sql = "SELECT * FROM YONGHU WHERE DENGLUMING = ?";
			
			try {
				conn = this.getConnection();
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, dengluMing);

				rs = ps.executeQuery();
				
				if(rs.next()){
					return true;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
			
			return false;
		}
		
		
	public Yonghu login(String ming,String mima){
			Yonghu yonghu = null;
			
        String sql = "SELECT * FROM YONGHU WHERE DENGLUMING = ? AND DENGLUMIMA = ?"; 			
			
        try {
			conn = this.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			
			
			ps.setString(1, ming);
			ps.setString(2, mima);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				yonghu = new Yonghu();
				yonghu.setNicheng(rs.getString("NICHENG"));
				yonghu.setId(rs.getInt("YH_ID"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
			
        return yonghu;
		}
		
		
		/**
		 * 添加用户
		 * @param yonghu
		 */
		public void addYonghu(Yonghu yonghu){
			
			String sql = "INSERT INTO YONGHU VALUES(SQ_YONGHU.NEXTVAL,?,?,0,?,?,0,?,?)";
			
			
			try {
				conn = this.getConnection();
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, yonghu.getDengluMing());
				ps.setString(2, yonghu.getDengluMima());
				ps.setString(3, yonghu.getNicheng());
				ps.setInt(4, yonghu.getXingbie());
				ps.setString(5, yonghu.getAihao());
				ps.setString(6, yonghu.getTouxiang());

				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}

		
		public void findByMing(String dengluming) {
			Yonghu yonghu = new Yonghu();
			
          String sql = "SELECT * FROM YONGHU WHERE DENGLUMING ='?')";
			
			
			try {
				conn = this.getConnection();
				
				ps = conn.prepareStatement(sql);
				
			
			rs=	ps.executeQuery();
			if (rs.next()) {
				
			}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}

}
