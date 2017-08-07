package com.ys.biz;

import java.util.List;

import com.ys.Dao.CommentDao;
import com.ys.common.Common;
import com.ys.entity.Comment;

public class CommentBiz {
	        private CommentDao commentDao = new CommentDao();
	        
            public void add(Comment pinglun) {
				commentDao.add(pinglun);
			}
            
            public List<Comment> findHot(int wzid){
            	return commentDao.findHot(Common.HOT_COMMENT, wzid);
            }

            public List<Comment> findLatest(int wzid){
            	return commentDao.findHot(Common.Latest_COMMENT, wzid);
            }
            
			public void zan(int id) {
				commentDao.zan(id);
			}
}
