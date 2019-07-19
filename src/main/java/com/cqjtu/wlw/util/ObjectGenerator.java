package com.cqjtu.wlw.util;

import com.cqjtu.wlw.pojo.FileInfo;
import com.cqjtu.wlw.pojo.UserInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 对象生成器
 * @author Administrator
 *
 */
public class ObjectGenerator {
	
	/**
	 * generate(""),generate("",1),generate("",1,2,3,...)
	 * @param className	"com.chinasofti.ssm01.bean.UserInfo"/com.chinasofti.ssm01.bean.FileInfo
	 * @param parameters new Integer(10001),"张三","abc123"/new Integer(1001),"文件名","d:\a.txt"
	 * @return 对象
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static Object generate(String className,Object...parameters) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class c = Class.forName(className);
		Object o = c.newInstance();
		
		if(parameters != null && parameters.length > 0){//判断paramters不为空且长度>0
			//找到类上所有的方法
			Method[] methods = c.getDeclaredMethods();
			//set方法的集合 
			Method[] setMethods = new Method[parameters.length];
			int j = 0;
			for(int i = 0 ; i < methods.length; i++){
				if(methods[i].getName().startsWith("set")){
					setMethods[j] = methods[i];
					j++;
				}
			}
			
			for(int i = 0 ; i < setMethods.length ; i++){
				setMethods[i].invoke(o, parameters[i]);
			}
		}
		
		return o;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object o = ObjectGenerator
				.generate("com.cqjtu.wlw.pojo.UserInfo",new Integer(10001),"张三","abc123");
		if(o instanceof UserInfo){
			UserInfo userInfo = (UserInfo)o;
			System.out.println("userInfo.getUserId = " + userInfo.getUserId());
			System.out.println("userInfo.getUserIdentity = " + userInfo.getUserIdentity());
			System.out.println("userInfo.getUserPassword = " + userInfo.getUserPassword());
		}
		
		Object o1 = ObjectGenerator
				.generate("com.cqjtu.wlw.pojo.FileInfo", new Integer(2000),"a.txt","D:\\a.txt");
		if(o1 instanceof FileInfo){
			FileInfo fileInfo = (FileInfo)o1;
			System.out.println("fileInfo.getFileId = " + fileInfo.getFileId());
			System.out.println("fileInfo.getFileName = " + fileInfo.getFileName());
			System.out.println("fileInfo.getFileUrl = " + fileInfo.getFileUrl());
		}
	}
}




