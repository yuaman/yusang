package com.ys.biz;

import com.ys.Dao.YonghuDao;
import com.ys.entity.Yonghu;

public class YonghuBiz {

	
		
		private YonghuDao yonghuDao = new YonghuDao();
		
		public Yonghu login(String ming,String mima){
		   	 return yonghuDao.login(ming, mima);
		}

		public boolean reg(Yonghu yonghu){
			
			//1.�ж��û����Ϸ���
			if(yonghuDao.youDengluMing(yonghu.getDengluMing())){
				return false;
			}	
			//2.ע���������
			yonghu.setTouxiang("/upload/thumb20150116114550533.jpg");
			yonghuDao.addYonghu(yonghu);
			
			return true;
		}

		public boolean checkUname(String dengluming) {
			new YonghuDao().youDengluMing(dengluming);
			return true;
		}
}
