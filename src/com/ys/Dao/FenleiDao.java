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
 * 分类数据访问层
 *
 *
 * <pre>
 * 	@author 于霆霖
 *
 *  创建时间: 2016年5月11日下午1:06:44
 *
 *  版权信息:榆槡导读
 * </pre>
 */
public class FenleiDao extends BaseDao {
	
	/**
	 * 前台首页父分类与子分类的循环输出
	 * @return map键值对，其中key值为父分类，value值为子分类的集合
	 */
	public Map<Fenlei, List<Fenlei>> findIndexAll(){
		Map<Fenlei, List<Fenlei>> map = new HashMap<Fenlei, List<Fenlei>>();
		
		String sql = "SELECT * FROM FENLEI WHERE XIANSHI_FLAG = 0 ORDER BY FU_FL_ID";
		
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs  = ps.executeQuery();
			List<Fenlei> list = null;
			
			//将所有顶级分类查询出并添加进map键值对当中
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
			//将所有分类都进行查询并封装进实体类中
			Fenlei fenlei = new Fenlei();
			fenlei.setId(rs.getInt("FL_ID"));
			fenlei.setTitle(rs.getString("TITLE"));
			fenlei.setFuFlId(rs.getInt("FU_FL_ID"));
			fenlei.setMiaoshu(rs.getString("MIAOSHU"));
			fenlei.setXianshiFlag(rs.getInt("XIANSHI_FLAG"));
			
			//取得所有key值，即所有顶级分类，将其id与所有分类的父id进行匹配，
			//如若相等，此分类即为该分类的子分类，将其添加进value当中
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
	 * 添加分类信息
	 * @param fenlei
	 */
	public void addFenlei(Fenlei fenlei){
		
		String sql = "INSERT INTO FENLEI VALUES(FL_ID.NEXTVAL,?,?,0,?)";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			//填充问号
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
	 * 查询所有顶级分类
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
	 * 根据ID查询分类信息
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
	 * 修改分类信息
	 * @param fenlei
	 */
	public void modifyFenlei(Fenlei fenlei){
		String sql = "UPDATE FENLEI SET TITLE = ?,FU_FL_ID = ?,MIAOSHU = ? WHERE FL_ID = ?";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			//赋值
			ps.setString(1, fenlei.getTitle());
			ps.setInt(2, fenlei.getFuFlId());
			ps.setString(3, fenlei.getMiaoshu());
			ps.setInt(4, fenlei.getId());
			
			//千万别忘了执行sql
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
	 * 修改是否显示分类
	 * 
	 * @param fid
	 * @param flag
	 */
	public void modifyShowFlag(int fid, int flag) {

		String sql = "UPDATE FENLEI SET XIANSHI_FLAG = ? WHERE FL_ID = ?";

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);
			//赋值
			ps.setInt(1, flag);
			ps.setInt(2, fid);
			
			//千万别忘了执行sql
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
