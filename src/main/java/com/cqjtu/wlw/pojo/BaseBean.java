package com.cqjtu.wlw.pojo;

/**
 * 所有实体的父类，提供分页信息
 * @author Administrator
 *
 */
public class BaseBean {
	/**
	 * 起始记录位置
	 */
	private int start;
	/**
	 * 每页显示多少条记录
	 */
	private int length = 2;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
