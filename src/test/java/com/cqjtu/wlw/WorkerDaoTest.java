package com.cqjtu.wlw;

import java.util.List;
import java.util.Set;

import com.cqjtu.wlw.dao.WorkerDao;
import com.cqjtu.wlw.pojo.WorkerInfo;
import com.cqjtu.wlw.pojo.RepairInfo;
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
	@Test
	public void test21(){
		WorkerInfo workerInfo = new WorkerInfo();
		workerInfo.setWorkerId("10000");//worker_id="1"对应的全部repair记录（1对多）
		workerInfo = workerDao.getWorkerInfoById(workerInfo);
		System.out.println("workerInfo.name = " + workerInfo.getWorkerName()+"\n---------");

		Set<RepairInfo> repairInfos = workerInfo.getRepairInfos();
		for(RepairInfo r : repairInfos){
			System.out.println("repair_id = " + r.getRepairId());
		}
	}
	@Test
	public void test22(){
		List<WorkerInfo> workers = workerDao.getWorkers();//按户主号依次查找(返回集合)
		for(WorkerInfo worker : workers){
			System.out.println("----------------");
			System.out.println("worker.name = " + worker.getWorkerName());

			Set<RepairInfo> repairInfos = worker.getRepairInfos();
			for(RepairInfo s : repairInfos){
				System.out.println("repair.id = " + s.getRepairId());
			}
			System.out.println("----------------");
		}
	}
}




