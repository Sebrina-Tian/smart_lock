package com.cqjtu.wlw.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cqjtu.wlw.dao.FileInfoDao;
import com.cqjtu.wlw.pojo.FileInfo;
import com.cqjtu.wlw.util.DBManager;



public class FileInfoDaoImpl implements FileInfoDao {

	@Override
	public void addFileInfo(FileInfo fileInfo) throws SQLException {
		String sql = "insert into file_info(file_name,file_url) values(?,?)";
		//获得连接
		Connection con = DBManager.getConnection();
		//获得PreparedStatement
		PreparedStatement pstm = con.prepareStatement(sql);
		//给问号赋值
		pstm.setString(1, fileInfo.getFileName());
		pstm.setString(2, fileInfo.getFileUrl());
		//执行sql
		pstm.executeUpdate();
		//关闭连接
		pstm.close();
		con.close();
	}

	@Override
	public List<FileInfo> findFiles() throws SQLException {
		String sql = "select * from file_info";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		//执行查询，返回结果集
		ResultSet rs = pstm.executeQuery();
		List<FileInfo> files = new ArrayList<>();
		while(rs.next()){//循环遍历结果集
			//file_id
			Integer fileId = rs.getInt(1);
			//file_name
			String fileName = rs.getString(2);
			//file_url
			String fileUrl = rs.getString(3);
			//每一条记录封装到一个FileInfo对象中
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFileId(fileId);
			fileInfo.setFileName(fileName);
			fileInfo.setFileUrl(fileUrl);
			//将fileInfo对象放入集合中
			files.add(fileInfo);
		}
		pstm.close();
		con.close();
		return files;
	}

	@Override
	public FileInfo findFileById(Integer fileId) throws SQLException {
		String sql = "select * from file_info where file_id = ?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, fileId);
		//执行查询，返回结果集
		ResultSet rs = pstm.executeQuery();
		FileInfo fileInfo = null;
		if(rs.next()){//如果结果集中有下一条记录
			fileInfo = new FileInfo();
			//file_id
			fileId = rs.getInt(1);
			//file_name
			String fileName = rs.getString(2);
			//file_url
			String fileUrl = rs.getString(3);
			fileInfo.setFileId(fileId);
			fileInfo.setFileName(fileName);
			fileInfo.setFileUrl(fileUrl);
		}
		pstm.close();
		con.close();
		return fileInfo;
	}
	
	
	public FileInfo findFileById1(Integer fileId) throws SQLException {
		String sql = "select * from file_info where file_id = ?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, fileId);
		//执行查询，返回结果集
		ResultSet rs = pstm.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();//获取到结果集的元数据
		System.out.println("columnCount = " + rsmd.getColumnCount());
		for(int i = 0 ; i < rsmd.getColumnCount(); i++){
			System.out.println("columnName = " + rsmd.getColumnName(i+1));
			String[] strs = rsmd.getColumnName(i+1).split("_");
			String fieldName = strs[0];//"file";
			for(int j = 1 ; j < strs.length; j++){//"id"/"name"/"url"
				fieldName = fieldName + strs[j].substring(0, 1).toUpperCase()
						+ strs[j].substring(1);
			}
			System.out.println("fieldName = " + fieldName);
		}
		
		FileInfo fileInfo = null;
		if(rs.next()){//如果结果集中有下一条记录
			fileInfo = new FileInfo();
			//file_id
			fileId = rs.getInt(1);
			//file_name
			String fileName = rs.getString(2);
			//file_url
			String fileUrl = rs.getString(3);
			fileInfo.setFileId(fileId);
			fileInfo.setFileName(fileName);
			fileInfo.setFileUrl(fileUrl);
		}
		pstm.close();
		con.close();
		return fileInfo;
	}

}

