package com.ys.Dao;

import java.sql.SQLException;

import com.ys.entity.Guanliyuan;

/**
 * 
 * ����Ա���ݿ���ʲ�
 *
 * <pre>
 * 	@author ��ΰ��
 *
 *  ����ʱ��: 2016��5��10������9:07:55
 *
 *  ��Ȩ��Ϣ:�ܘ�����
 * </pre>
 */
public class GuanliyuanDao extends BaseDao {

	/**
	 * �����û����������ѯ����Ա��Ϣ
	 * @param dengluMing �û���
	 * @param dengluMima ����
	 * @return ����Ա��Ϣ
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
