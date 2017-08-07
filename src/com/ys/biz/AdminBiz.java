package com.ys.biz;

import java.util.List;

import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

import com.ys.Dao.AdminDao;
import com.ys.common.Common;
import com.ys.entity.Admin;
import com.ys.entity.BaseBean;

public class AdminBiz extends BaseBean{
	AdminDao adminDao = new  AdminDao();

	public void addAdmin(Admin admin){
		  adminDao.addAdmin(admin);
	 }
	
	public List<Admin> findAdminByPage(int page){
		int begin  = (page-1)*Common.ADMIN_FENLEIPERPAGE_NUM;
		int end = page*Common.ADMIN_FENLEIPERPAGE_NUM;
		
		return adminDao.findAdminByPage(begin, end);
		
	}

	public int findCount() {
		// TODO Auto-generated method stub
		return new AdminDao().findAll();
	}
}
