package com.ys.biz;

import java.util.List;
import java.util.Map;

import com.ys.Dao.FenleiDao;
import com.ys.common.Common;
import com.ys.entity.Fenlei;

public class FenleiBiz {

	private FenleiDao fenleiDao = new FenleiDao();
	
	private static final int BUSHOWFLAG = 1;
	private static final int SHOWSHOWFLAG = 0;
	
	public Fenlei findById(int id) {
		
		return fenleiDao.findById(id);
	}
	
	/**
	 * 修改分类信息
	 * @param fenlei
	 */
	public void modifyFenlei(Fenlei fenlei){
		fenleiDao.modifyFenlei(fenlei);
	}
	//前台首页父分类与子分类的循环输出
	public Map<Fenlei, List<Fenlei>> findIndexAll(){
		return fenleiDao.findIndexAll();
	}
	/**
	 * 添加分类
	 * @param fenlei
	 */
	public void addFenlei(Fenlei fenlei){
		fenleiDao.addFenlei(fenlei);
	}
	
	public int findCount() {
		return fenleiDao.findCount();
	}
	
	public List<Fenlei> findFenleiByPage(int page){
		int begin  = (page-1)*Common.ADMIN_FENLEIPERPAGE_NUM;
		int end = page*Common.ADMIN_FENLEIPERPAGE_NUM;
		
		return fenleiDao.findPerPage(begin, end);
	}
	
	public List<Fenlei> findAllShown(){
		
		return fenleiDao.findAllShown();
	}
	
	/**
	 * 查询所有顶级分类
	 * @return
	 */
	public List<Fenlei> findAllShownRoot() {
		return fenleiDao.findAllShownRoot();
	}
	/**
	 * 不显示分类
	 * @param fid
	 */
	public void buShowFenlei(int fid){
		fenleiDao.modifyShowFlag(fid, BUSHOWFLAG);
	}
	
	public void showFenlei(int fid){
		fenleiDao.modifyShowFlag(fid, SHOWSHOWFLAG);
	}
}
