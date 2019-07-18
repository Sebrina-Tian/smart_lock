package com.cqjtu.wlw.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * 翻页pager.offset
 * @author Administrator
 *
 */
public class BaseController {
	
	private int start;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	/**
	 * 翻页pager.offset
	 * @param request
	 */
	protected void handleOffset(HttpServletRequest request){
		String s = request.getParameter("pager.offset");
		if(s != null && !s.equals("")){
			int start = Integer.parseInt(s);
			this.start = start;
		}
	}
	
}
