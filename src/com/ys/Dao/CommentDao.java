package com.ys.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.jmx.snmp.tasks.ThreadService;
import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;
import com.ys.entity.Comment;
import com.ys.entity.Yonghu;

public class CommentDao extends BaseDao{
    
	
	public void add(Comment pinglun) {
			String sql = "INSERT INTO PINGLUN VALUES (SQ_PINGLUN.NEXTVAL,?,?,?,SYSDATE,0)";
	 	    
	      try {
			conn = this.getConnection();
			  
			  ps  = conn.prepareStatement(sql);
			  
			  ps.setString(1,pinglun.getNeirong() );
			  ps.setInt(2,pinglun.getYonghu().getId());
			  ps.setInt(3, pinglun.getWenzhang().getId());
			  
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
	
	public List<Comment> findHot(int num,int wzid){
		String sql = "SELECT S.*,ROWNUM FROM (SELECT P.*,Y.NICHENG FROM PINGLUN P ,YONGHU Y WHERE P.YH_ID = Y.YH_ID AND P.WZ_ID = ? ORDER BY P.ZAN DESC) S WHERE ROWNUM <= ?";
		List<Comment> list = new ArrayList<Comment>();
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,wzid );
			ps.setInt(2, num);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt("PL_ID"));
				comment.setNeirong(rs.getString("NEIRONG"));
				comment.setShijian(rs.getDate("SHIJIAN").toString());
				Yonghu yonghu = new Yonghu();
				yonghu.setNicheng(rs.getString("NICHENG"));
				comment.setYonghu(yonghu);
				comment.setZan(rs.getInt("ZAN"));
				
				list.add(comment);
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
		
		return list;
	}
	
	public List<Comment> findLatest(int num,int wzid){
		String sql = "SELECT S.*,ROWNUM FROM (SELECT P.*,Y.NICHENG FROM PINGLUN P ,YONGHU Y WHERE P.YH_ID = Y.YH_ID AND P.WZ_ID = ? ORDER BY P.SHIJIAN DESC) S WHERE ROWNUM <= ?";
		List<Comment> list = new ArrayList<Comment>();
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(2,num );
			ps.setInt(1,wzid );
			rs = ps.executeQuery();
			
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt("PL_ID"));
				comment.setNeirong(rs.getString("NEIRONG"));
				comment.setShijian(rs.getDate("SHIJIAN").toString());
				Yonghu yonghu = new Yonghu();
				yonghu.setNicheng(rs.getString("NICHENG"));
				comment.setYonghu(yonghu);
				comment.setZan(rs.getInt("ZAN"));
				
				list.add(comment);
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
		
		return list;
	}
	
	
	public void zan(int id){
		String sql = "UPDATE PINGLUN SET ZAN=ZAN+1 WHERE PL_ID = ?";
		
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id );
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
}
