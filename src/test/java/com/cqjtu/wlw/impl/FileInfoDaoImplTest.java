package com.cqjtu.wlw.impl;

import java.sql.SQLException;
import java.util.List;

import com.cqjtu.wlw.pojo.FileInfo;
import com.cqjtu.wlw.service.impl.FileInfoDaoImpl;
import org.junit.Test;


public class FileInfoDaoImplTest {
	@Test
	public void testCase1(){
		FileInfoDaoImpl dao = new FileInfoDaoImpl();
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName("我的文件");
		fileInfo.setFileUrl("d:\\a\\b\\c.txt");
		try {
			dao.addFileInfo(fileInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCase2(){
		FileInfoDaoImpl dao = new FileInfoDaoImpl();
		try {
			FileInfo fileInfo = dao.findFileById(1);
			System.out.println("fileName = " + fileInfo.getFileName());
			System.out.println("fileUrl = " + fileInfo.getFileUrl());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCase3(){
		FileInfoDaoImpl dao = new FileInfoDaoImpl();
		try {
			List<FileInfo> files = dao.findFiles();
			for(FileInfo fileInfo : files){
				System.out.println("fileName = " + fileInfo.getFileName());
				System.out.println("fileUrl = " + fileInfo.getFileUrl());
				System.out.println("---------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}