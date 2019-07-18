package com.cqjtu.wlw.dao;

import com.cqjtu.wlw.pojo.FileInfo;

import java.util.List;
import java.sql.SQLException;


/**
 * DataAccessObject数据访问对象
 * @author Administrator
 *
 */
public interface FileInfoDao {
	/**
	 * 添加文件
	 * @param fileInfo
	 */
    void addFileInfo(FileInfo fileInfo) throws SQLException;
	/**
	 * 查询所有的文件
	 * @return
	 */
    List<FileInfo> findFiles() throws SQLException;
	/**
	 * 根据id查询文件
	 * @param fileId
	 * @return
	 */
    FileInfo findFileById(Integer fileId) throws SQLException;
}
