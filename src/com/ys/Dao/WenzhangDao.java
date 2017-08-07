package com.ys.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ys.entity.Biaoqian;
import com.ys.entity.Fenlei;
import com.ys.entity.Wenzhang;

public class WenzhangDao extends BaseDao{
	Wenzhang wenzhang = new Wenzhang();
	   
	public List<Wenzhang> findByTitle(String keyword){
		String sql = "SELECT * FROM WENZHANG WHERE TITLE LIKE ? ";
		List<Wenzhang> list = new ArrayList<Wenzhang>();

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, "%"+keyword+"%");
			
			rs=ps.executeQuery();
			while (rs.next()) {

				Wenzhang wenzhang = new Wenzhang();
			
				wenzhang.setTitle(rs.getString("TITLE"));
				wenzhang.setZaiyao(rs.getString("ZHAIYAO"));
				wenzhang.setZuozhe(rs.getString("ZUOZHE"));
				wenzhang.setLiulanshu(rs.getInt("LIULANSHU"));
				wenzhang.setPinglunshu(rs.getInt("PINGLUNSHU"));
				wenzhang.setFenlei(rs.getInt("FL_ID"));
				wenzhang.setBiaoqian(rs.getString("BIAOQIAN"));
				list.add(wenzhang);
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
		
	
	
	
	public void addWenzhang(Wenzhang wenzhang){
		String sql="INSERT INTO WENZHANG VALUES(SQ_WZ_ID.NEXTVAL,?,?,'',?,'¡ÿ∏Á',SYSDATE,0,0,?,?)";
		try {
			conn = this.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, wenzhang.getTitle());
			ps.setString(2, wenzhang.getNeirong());
			ps.setString(3, wenzhang.getZaiyao());
			ps.setInt(4, wenzhang.getFenlei());
			ps.setString(5, wenzhang.getBiaoqian());
			
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, ps, rs);
		}
	}

	public List<Biaoqian> findAllBiaoqian() {
		String sql="SELECT * FROM BIAOQIAN WHERE XIANSHI_FLAG = 0";
		
		List<Biaoqian> list= new ArrayList<Biaoqian>();
		try {
			conn = this.getConnection();
			
			ps = conn.prepareStatement(sql);
		
			rs = ps.executeQuery();
			
			while  (rs.next()) {
				Biaoqian biaoqian1 = new Biaoqian();
				biaoqian1.setBq_id(rs.getInt("bq_id"));
				biaoqian1.setTitle(rs.getString("title"));
				biaoqian1.setXianshi_flag(rs.getInt("xianshi_flag"));
			list.add(biaoqian1);
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

	public List<Wenzhang> findPerPage(int begin ,int end) {

		String sql = "SELECT * FROM (SELECT T.* , ROWNUM  R FROM WENZHANG T WHERE ROWNUM  < ?)WHERE  R > ?";

		List<Wenzhang> list = new ArrayList<Wenzhang>();

		try {
			conn = this.getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, end+1);
			ps.setInt(2, begin);
			
			rs=ps.executeQuery();
			while (rs.next()) {

				Wenzhang wenzhang = new Wenzhang();
			
				wenzhang.setTitle(rs.getString("TITLE"));
				wenzhang.setZaiyao(rs.getString("ZHAIYAO"));
				wenzhang.setZuozhe(rs.getString("ZUOZHE"));
				wenzhang.setLiulanshu(rs.getInt("LIULANSHU"));
				wenzhang.setPinglunshu(rs.getInt("PINGLUNSHU"));
				wenzhang.setFenlei(rs.getInt("FL_ID"));
				wenzhang.setBiaoqian(rs.getString("BIAOQIAN"));
				list.add(wenzhang);
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

	public int findCount() {
		
			String sql = "SELECT COUNT(*) FROM WENZHANG";

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
	
	public Wenzhang findById(int id){
		String sql = "SELECT * FROM WENZHANG WHERE WZ_ID = ?";
		Wenzhang wenzhang = null;
		try {
			conn = this.getConnection();
			ps= conn.prepareStatement(sql);
			 ps.setInt(1,id );
			rs=ps.executeQuery();
			
			if (rs.next()) {
				 wenzhang= new Wenzhang();
				 wenzhang.setId(rs.getInt("WZ_ID"));
				wenzhang.setTitle(rs.getString("TITLE"));
				wenzhang.setNeirong(rs.getString("NETRONG"));
				wenzhang.setSuoluetu(rs.getString("SUOLUETU"));
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
		return wenzhang;
	}

	
}
