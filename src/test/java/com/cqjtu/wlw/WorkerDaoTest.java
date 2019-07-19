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
		WorkerInfo.setWorkerId("12345");//不为空
		WorkerInfo.setWorkerName("addtest");
		WorkerInfo.setWorkerPassword("123456");//不为空
		WorkerInfo.setWorkerSex("1");
		WorkerInfo.setWorkerPhone("1852345678");//等于id
		WorkerInfo.setWorkerAddr("慧园711");
		WorkerInfo.setWorkerArea("重庆南岸区");//默认是："重庆南岸区"
		WorkerInfo.setWorkerGrade((float) 5.0);//默认5.0不为空，后面可更新
		workerDao.addWorkerInfo(WorkerInfo);
	}
	@Test
	public void WorkerupdateTest(){
		WorkerInfo workerInfo = new WorkerInfo();
		workerInfo.setWorkerId("12345");//不为空//worker_id="10000"对应的全部repair记录（1对多）
		workerInfo = workerDao.getWorkerInfoById(workerInfo);

		System.out.println("更新前"+workerInfo.getWorkerGrade());

		workerInfo.setWorkerName("addtest");
		workerInfo.setWorkerPassword("123456");//不为空
		workerInfo.setWorkerSex("1");
		workerInfo.setWorkerPhone("1852345678");//等于id
		workerInfo.setWorkerAddr("慧园711");
		workerInfo.setWorkerArea("重庆南岸区");//默认是："重庆南岸区"
		workerInfo.setWorkerGrade((float) 3);//默认5.0不为空，后面可更新

		workerDao.updateWorkerInfo(workerInfo);
		System.out.println("更新后"+workerInfo.getWorkerGrade());
	}

	
	@Test
	public void test4(){
		WorkerInfo WorkerInfo = new WorkerInfo();
		WorkerInfo.setWorkerName("%张%");//从前端获取
		WorkerInfo.setWorkerPhone("10%");
		/**如果是Area地区要对字符串进行裁剪：示例sql = sql.substring(0,sql.length()-1) + ")";//删去sql句末多余的“,”
		 * 这里模糊查询不用裁剪，前端显示时，可裁剪
		 */
		List<WorkerInfo> list = workerDao.getWorkerInfos(WorkerInfo);
		for(WorkerInfo s : list){
			System.out.println("s.name = " + s.getWorkerName());
			System.out.println("s.number = " + s.getWorkerPhone());
		}
	}
	@Test
	public void test21(){
		WorkerInfo workerInfo = new WorkerInfo();
		workerInfo.setWorkerId("10000");//worker_id="10000"对应的全部repair记录（1对多）
		workerInfo = workerDao.getWorkerInfoById(workerInfo);
		System.out.println("workerInfo.name = " + workerInfo.getWorkerName()+"\n---------");

		Set<RepairInfo> repairInfos = workerInfo.getRepairInfos();
		for(RepairInfo r : repairInfos){
			System.out.println("repair_id = " + r.getRepairId());
		}
	}
	@Test
	public void test22(){//controller中：worker/show.d?workerId=...
		List<WorkerInfo> workers = workerDao.getWorkers();//按worker_id号依次查找(返回集合)
		for(WorkerInfo worker : workers){
			System.out.println("----------------");
			System.out.println("worker.name = " + worker.getWorkerName());

			Set<RepairInfo> repairInfos = worker.getRepairInfos();
			for(RepairInfo s : repairInfos){
				System.out.println("repair.id = " + s.getRepairId());
				System.out.println("repair.grade = " + s.getRepairGrade());
			}
			System.out.println("----------------");
		}
	}
}




