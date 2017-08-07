package com.ys.common;

public class Common {
	
	private static final String STANDARD_NUMBER = "0123456789";
	public static final int ADMIN_FENLEIPERPAGE_NUM = 2;
	public static final int ADMIN_WenzhangPERPAGE_NUM=2;
	public static final int ADMIN_PERPAGE_NUM=1;
	public static final int HOT_COMMENT = 5;
	public static final int Latest_COMMENT = 5;
	
	public static final String CHARSET = "UTF-8";
	
	public static String createPageLinkContent(int curPage ,double tempPageAmount,String href){
		StringBuffer stringBuffer = new StringBuffer();
		
		if (curPage!=1) {
			stringBuffer.append("<li><a href=\""+href+"?p="+(curPage-1)+"\">上一页</a></li>");
		}
		
		for(int i = 1; i <= tempPageAmount; i ++ ){
			stringBuffer.append("<li><a href=\"" + href + "?p=" + i + "\"" + (i==curPage?" style=\"background:#000;color:#fff;\"":"") + ">" + i + "</a></li>");
		}
		
		if(curPage != tempPageAmount){
			stringBuffer.append("<li><a href=\"" + href + "?p=\""+ (curPage + 1) + ">下一页</a></li>");
		}
	
		
		return stringBuffer.toString();
	}
	
	
	/**
	 * 把指定数组按指定分隔符分隔组成字符串
	 * @param objs 数组名
	 * @param split 分隔符
	 * @return 字符串
	 */
	
	
	public static String toString(Object[] objs,String split){
		
		StringBuffer sBuffer = new StringBuffer();
		
		for(Object obj:objs){
			sBuffer.append(obj);
			sBuffer.append(split);
		}
		
		if(sBuffer.length() > 1){
			sBuffer.deleteCharAt(sBuffer.length() - 1);
		}
		
		return sBuffer.toString();
		
	}
	
	public static boolean isEmpty(String str) {

		if (str == null) {
			return true;
		}

		if ("".equals(str.trim())) {
			return true;
		}

		return false;
	}

	public static boolean isNotANumber(String number) {

		if (isEmpty(number)) {
			return true;
		}

		for (int i = 0; i < number.length(); i++) {
			if (STANDARD_NUMBER.indexOf(number.charAt(i)) == -1) {
				return true;
			}
		}

		return false;

	}

}
