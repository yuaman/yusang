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
	 * �޸ķ�����Ϣ
	 * @param fenlei
	 */
	public void modifyFenlei(Fenlei fenlei){
		fenleiDao.modifyFenlei(fenlei);
	}
	//ǰ̨��ҳ���������ӷ����ѭ�����
	public Map<Fenlei, List<Fenlei>> findIndexAll(){
		return fenleiDao.findIndexAll();
	}
	/**
	 * ��ӷ���
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
	 * ��ѯ���ж�������
	 * @return
	 */
	public List<Fenlei> findAllShownRoot() {
		return fenleiDao.findAllShownRoot();
	}
	/**
	 * ����ʾ����
	 * @param fid
	 */
	public void buShowFenlei(int fid){
		fenleiDao.modifyShowFlag(fid, BUSHOWFLAG);
	}
	
	public void showFenlei(int fid){
		fenleiDao.modifyShowFlag(fid, SHOWSHOWFLAG);
	}
}
