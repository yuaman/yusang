 package com.ys.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.apache.coyote.http11.filters.VoidInputFilter;

import com.ys.entity.Fenlei;

/**
 * �������ݷ��ʲ�
 *
 *
 * <pre>
 * 	@author ������
 *
 *  ����ʱ��: 2016��5��11������1:06:44
 *
 *  ��Ȩ��Ϣ:�ܘ�����
 * </pre>
 */
public class FenleiDao extends BaseDao {
	
	/**
	 * ǰ̨��ҳ���������ӷ����ѭ�����
	 * @return map��ֵ�ԣ�����keyֵΪ�����࣬valueֵΪ�ӷ���ļ���
	 */
	public Map<Fenlei, List<Fenlei>> findIndexAll(){
		Map<Fenlei, List<Fenlei>> map = new HashMap<Fenlei, List<Fenlei>>();
		
		String sql = "SELECT * FROM FENLEI WHERE XIANSHI_FLAG = 0 ORDER BY FU_FL_ID";
		
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs  = ps.executeQuery();
			List<Fenlei> list = null;
			
			//�����ж��������ѯ������ӽ�map��ֵ�Ե���
			while(rs.next()){
				if (rs.getInt("FU_FL_ID")==-1) {
					Fenlei fenlei = new Fenlei();
					fenlei.setId(rs.getInt("FL_ID"));
					fenlei.setTitle(rs.getString("TITLE"));
					fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
					fenlei.setMiaoshu(rs.getString("MIAOSHU"));
					fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
					map.put(fenlei, new ArrayList<Fenlei>());
				}
			
			}
			//�����з��඼���в�ѯ����װ��ʵ������
			Fenlei fenlei = new Fenlei();
			fenlei.setId(rs.getInt("FL_ID"));
			fenlei.setTitle(rs.getString("TITLE"));
			fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
			fenlei.setMiaoshu(rs.getString("MIAOSHU"));
			fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
			
			//ȡ������keyֵ�������ж������࣬����id�����з���ĸ�id����ƥ�䣬
			//������ȣ��˷��༴Ϊ�÷�����ӷ��࣬������ӽ�value����
			Set<Fenlei> keys = map.keySet();
			for(Fenlei key:keys){
				if (key.getId()==fenlei.getFuFlId()) {
					map.get(key).add(fenlei);
					break;
				}
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
		
		
		return map;
	}
	
	/**
	 * ��ӷ�����Ϣ
	 * @param fenlei
	 */
	public void addFenlei(Fenlei fenlei){
		
		String sql = "INSERT INTO FENLEI VALUES(FL_ID.NEXTVAL,?,?,0,?)";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			//����ʺ�
			ps.setString(1, fenlei.getTitle());
			ps.setInt(2, fenlei.getFuFlId());
			ps.setString(3, fenlei.getMiaoshu());
			
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
	}
	
	public int findCount(){
		String sql = "SELECT COUNT(*) FROM FENLEI";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {

				return rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}

		return 0;
	}

	public List<Fenlei> findPerPage(int begin ,int end) {

		String sql = "SELECT * FROM (SELECT T.* , ROWNUM  R FROM FENLEI T WHERE ROWNUM  < ?)WHERE  R > ?";

		List<Fenlei> list = new ArrayList<Fenlei>();

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, end+1);
			ps.setInt(2, begin);
			
			rs=ps.executeQuery();
			while (rs.next()) {

				Fenlei fenlei = new Fenlei();
				fenlei.setId(rs.getInt("FL_ID"));
				fenlei.setTitle(rs.getString("TITLE"));
				fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
				fenlei.setMiaoshu(rs.getString("MIAOSHU"));
				fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
				list.add(fenlei);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}

		return list;
	}
	
	
	public List<Fenlei> findAllShown() {

		String sql = "SELECT * FROM FENLEI WHERE XIANSHI_FLAG = 0";

		List<Fenlei> list = new ArrayList<Fenlei>();

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Fenlei fenlei = new Fenlei();
				fenlei.setId(rs.getInt("FL_ID"));
				fenlei.setTitle(rs.getString("TITLE"));
				fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
				fenlei.setMiaoshu(rs.getString("MIAOSHU"));
				fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
				list.add(fenlei);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}

		return list;
	}
	
	/**
	 * ��ѯ���ж�������
	 * @return
	 */
	public List<Fenlei> findAllShownRoot() {

		String sql = "SELECT * FROM FENLEI WHERE FU_FL_ID = -1 AND XIANSHI_FLAG = 0";

		List<Fenlei> list = new ArrayList<Fenlei>();

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Fenlei fenlei = new Fenlei();
				fenlei.setId(rs.getInt("FL_ID"));
				fenlei.setTitle(rs.getString("TITLE"));
				fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
				fenlei.setMiaoshu(rs.getString("MIAOSHU"));
				fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
				list.add(fenlei);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}

		return list;
	}

	/**
	 * ����ID��ѯ������Ϣ
	 * @param id
	 * @return
	 */
	public Fenlei findById(int id) {

		String sql = "SELECT * FROM FENLEI WHERE FL_ID = ?";

		Fenlei fenlei = null;

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				fenlei = new Fenlei();
				fenlei.setId(rs.getInt("FL_ID"));
				fenlei.setTitle(rs.getString("TITLE"));
				fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
				fenlei.setMiaoshu(rs.getString("MIAOSHU"));
				fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}

		return fenlei;
	}
	
	/**
	 * �޸ķ�����Ϣ
	 * @param fenlei
	 */
	public void modifyFenlei(Fenlei fenlei){
		String sql = "UPDATE FENLEI SET TITLE = ?,FU_FL_ID = ?,MIAOSHU = ? WHERE FL_ID = ?";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			//��ֵ
			ps.setString(1, fenlei.getTitle());
			ps.setInt(2, fenlei.getFuFlId());
			ps.setString(3, fenlei.getMiaoshu());
			ps.setInt(4, fenlei.getId());
			
			//ǧ�������ִ��sql
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
	}
	
	/**
	 * �޸��Ƿ���ʾ����
	 * 
	 * @param fid
	 * @param flag
	 */
	public void modifyShowFlag(int fid, int flag) {

		String sql = "UPDATE FENLEI SET XIANSHI_FLAG = ? WHERE FL_ID = ?";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			//��ֵ
			ps.setInt(1, flag);
			ps.setInt(2, fid);
			
			//ǧ�������ִ��sql
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
	}
}
