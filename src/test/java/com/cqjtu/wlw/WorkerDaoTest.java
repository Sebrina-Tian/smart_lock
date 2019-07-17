package com.cqjtu.wlw;

import java.util.List;

import com.cqjtu.wlw.dao.WorkerDao;
import com.cqjtu.wlw.pojo.WorkerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class WorkerDaoTest {
	@Autowired
	private WorkerDao workerDao;
	@Test
	public void test1(){
		WorkerInfo WorkerInfo = new WorkerInfo();
		WorkerInfo.setWorkerId("10000");
		
		WorkerInfo = workerDao.getWorkerInfoById(WorkerInfo);
		System.out.println(WorkerInfo.getWorkerName());
		System.out.println(WorkerInfo.getWorkerPhone());
	}
	
	@Test
	public void test2(){
		WorkerInfo WorkerInfo = new WorkerInfo();
		WorkerInfo.setWorkerId("44565545");
		WorkerInfo.setWorkerName("王五");
		WorkerInfo.setWorkerPassword("123456");
		WorkerInfo.setWorkerSex("1");
		WorkerInfo.setWorkerPhone("1852345678");
		WorkerInfo.setWorkerAddr("慧园711");
		WorkerInfo.setWorkerArea("重庆南岸区");
		WorkerInfo.setWorkerGrade((float) 5.0);
		workerDao.addWorkerInfo(WorkerInfo);
	}
	
//	@Test
//	public void test3(){
//		List<WorkerInfo> list = WorkerDao.getWorkerInfos();
//		for(WorkerInfo s : list){
//			System.out.println("s.name = " + s.getWorkerName());
//			System.out.println("s.number = " + s.getWorkerNumber());
//		}
//	}
	
	@Test
	public void test4(){
		WorkerInfo WorkerInfo = new WorkerInfo();
		WorkerInfo.setWorkerName("%张%");
		WorkerInfo.setWorkerPhone("10%");
		List<WorkerInfo> list = workerDao.getWorkerInfos(WorkerInfo);
		for(WorkerInfo s : list){
			System.out.println("s.name = " + s.getWorkerName());
			System.out.println("s.number = " + s.getWorkerPhone());
		}
	}
}




