package com.ys.biz;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.ys.Dao.WenzhangDao;
import com.ys.common.Common;
import com.ys.entity.Biaoqian;
import com.ys.entity.Wenzhang;

public class WenzhangBiz {
	
	private WenzhangDao wenzhangDao = new WenzhangDao();
	
	public List<Wenzhang > findByTitle(String keyword){
		return wenzhangDao.findByTitle(keyword);
	}
	
	public void addWenzhang(Wenzhang wenzhang){
		wenzhangDao.addWenzhang(wenzhang);
	}
	
	public List<Biaoqian> findAllBiaoqian(){
		 return wenzhangDao.findAllBiaoqian();
	}
	
	public List<Wenzhang> findWenzhangByPage(int page){
		int begin  = (page-1)*Common.ADMIN_FENLEIPERPAGE_NUM;
		int end = page*Common.ADMIN_FENLEIPERPAGE_NUM;
		
		return wenzhangDao.findPerPage(begin, end);
	}
	
	public int findCount() {
		return wenzhangDao.findCount();
	}
	
	public Wenzhang findById(int id){
		return wenzhangDao.findById(id);
	}
	
}
