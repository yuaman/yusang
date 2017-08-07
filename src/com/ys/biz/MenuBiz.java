package com.ys.biz;


import java.util.ArrayList;
import java.util.List;

import com.ys.Dao.MenuDao;
import com.ys.entity.Menu;


public class MenuBiz {

	MenuDao mDao = new MenuDao();
	
	
	public List<Menu> findMenu(){
		List<Menu> list = new ArrayList<Menu>();
		
		
		return mDao.findMenu();
		
	}
}
