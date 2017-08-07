package com.ys.Dao;

import java.sql.SQLException;

import com.ys.entity.Guanliyuan;

/**
 * 
 * 管理员数据库访问层
 *
 * <pre>
 * 	@author 于伟光
 *
 *  创建时间: 2016年5月10日上午9:07:55
 *
 *  版权信息:榆槡导读
 * </pre>
 */
public class GuanliyuanDao extends BaseDao {

	/**
	 * 根据用户名和密码查询管理员信息
	 * @param dengluMing 用户名
	 * @param dengluMima 密码
	 * @return 管理员信息
	 */
	public Guanliyuan findByMingHeMima(String dengluMing,String dengluMima){
		
		String sql = "SELECT * FROM GUANLIYUAN WHERE DENGLUMING = ? AND DENGLUMIMA = ?";
		
		Guanliyuan guanliyuan = null;
		
		try {
			conn = this.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dengluMing);
			ps.setString(2, dengluMima);

			rs = ps.executeQuery();
			
			if(rs.next()){
				
				guanliyuan = new Guanliyuan();
				guanliyuan.setId(rs.getInt("GLY_ID"));
				guanliyuan.setDengluMing(dengluMing);
				guanliyuan.setDengluMima(dengluMima);
				guanliyuan.setMingzi(rs.getString("MINGZI"));
				guanliyuan.setQuanxian(rs.getInt("QUANXIAN"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		
		return guanliyuan;
		
	}
}
