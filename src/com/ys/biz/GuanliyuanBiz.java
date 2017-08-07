package com.ys.biz;

import com.ys.Dao.GuanliyuanDao;
import com.ys.entity.Guanliyuan;

public class GuanliyuanBiz {

	private GuanliyuanDao glyDao = new GuanliyuanDao();
	
	public Guanliyuan findByMingHeMima(String dengluMing,String dengluMima){
		
		return glyDao.findByMingHeMima(dengluMing, dengluMima);
	}
	
	
	
	
}
