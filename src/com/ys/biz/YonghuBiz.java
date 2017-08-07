package com.ys.biz;

import com.ys.Dao.YonghuDao;
import com.ys.entity.Yonghu;

public class YonghuBiz {

	
		
		private YonghuDao yonghuDao = new YonghuDao();
		
		public Yonghu login(String ming,String mima){
		   	 return yonghuDao.login(ming, mima);
		}

		public boolean reg(Yonghu yonghu){
			
			//1.判断用户名合法性
			if(yonghuDao.youDengluMing(yonghu.getDengluMing())){
				return false;
			}	
			//2.注册添加数据
			yonghu.setTouxiang("/upload/thumb20150116114550533.jpg");
			yonghuDao.addYonghu(yonghu);
			
			return true;
		}

		public boolean checkUname(String dengluming) {
			new YonghuDao().youDengluMing(dengluming);
			return true;
		}
}
