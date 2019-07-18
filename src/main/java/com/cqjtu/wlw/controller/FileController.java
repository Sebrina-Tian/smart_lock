package com.cqjtu.wlw.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cqjtu.wlw.dao.FileInfoDao;
import com.cqjtu.wlw.pojo.FileInfo;
import com.cqjtu.wlw.service.impl.FileInfoDaoImpl;
import com.cqjtu.wlw.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;



/**
 * 处理文件的类
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/uploadtest")
	public String upload(MultipartFile uploadFile) throws IOException {
		System.out.println("uploadFile = " + uploadFile);
		// 获得上传字节数
		byte[] buf = uploadFile.getBytes();
		System.out.println("上传文件大小：" + buf.length);
		// 获得上传文件名称
		System.out.println("上传文件名称getName = " + uploadFile.getName());
		System.out.println("上传文件名称getOriginalFilename = " + uploadFile.getOriginalFilename());
		return "index";
	}

	@RequestMapping("/upload")
	public String toUpload() {
		return "upload";
	}

	@RequestMapping("/files")
	public String files(HttpSession session) {
		FileInfoDao dao = new FileInfoDaoImpl();
		try {
			List<FileInfo> files = dao.findFiles();// 查找数据库全部内容
			session.setAttribute("list", files);// 全部文件显示页面，用list可以调出数据库表
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "files";
	}

	@RequestMapping("/doUpload")
	public String upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
		System.out.println("uploadFile = " + uploadFile);
		// 获得文件
		byte[] buf = uploadFile.getBytes();
		System.out.println("文件长度" + buf.length);
		// 文件名
		System.out.println("文件名getName = " + uploadFile.getName());
		System.out.println("文件名getOriginalFilename = " + uploadFile.getOriginalFilename());

		// 文件名 a.txt
		String originalFileName = uploadFile.getOriginalFilename();
		// 时间戳
		String time = FileUtil.createFileTimestamp();
		// 文件url /upload/1231231231231a.txt
		String fileUrl = "/upload/" + time + originalFileName;
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("fileUrl = " + fileUrl);
		// 向url地址存储文件
		FileUtil.writeFileToUrl(uploadFile, fileUrl);

		// 向数据库中保存文件信息
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(originalFileName);
		fileInfo.setFileUrl(fileUrl);

		FileInfoDao dao = new FileInfoDaoImpl();
		try {
			dao.addFileInfo(fileInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "user";
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(Integer fileId,HttpServletRequest request) {
		FileInfoDao dao = new FileInfoDaoImpl();
		try {
			FileInfo fileInfo = dao.findFileById(fileId);// 按学号查找文件记录类
			String fileUrl = fileInfo.getFileUrl();
			String fileName = fileInfo.getFileName();
			HttpHeaders headers = new HttpHeaders();// http协议
			String userAgent = request.getHeader("User-Agent");//获取浏览器名称
			if(userAgent.contains("MSIE")||userAgent.contains("Trident")) {//IE及IE内核浏览器
				fileName=java.net.URLEncoder.encode(fileName,"UTF-8");
			}else {//谷歌chome浏览器
				fileName=new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
			}
			headers.setContentDispositionFormData("attachment", fileName);// 默认下载文件名为原始文件名
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);// 媒体流下载

			ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)),
					headers, HttpStatus.CREATED);// 二进制转换为实体类型
			return entity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
