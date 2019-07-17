package com.cqjtu.wlw.pojo;
/*
 * 文件类，对应数据库文件file_Info
 * file_id
 * file_name
 * file_url
 * */
public class FileInfo {
	private Integer fileId;
	private String fileName;
	private String fileUrl;
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


}
