package com.cqjtu.wlw.dao;

import com.cqjtu.wlw.pojo.RepairInfo;

import java.util.List;

public interface RepairDao {
    /**
     * 添加一条维修记录信息
     * @param repairInfo {repair_id,request_time,client_id,start_time,re_detail,re_review,repair_grade,worker_id}
     */
    void addRepairInfo(RepairInfo repairInfo);
    /**
     * 删除一条维修记录信息
     * @param repairInfo{repairId }
     */
    void deleteRepairInfo(RepairInfo repairInfo);
    /**
     * 更新维修记录信息
     * @param repairInfo {start_time,re_detail,re_review,repair_grade,worker_id}
     */
    void updateRepairInfo(RepairInfo repairInfo);

    /**
     * 根据id查询 一条 维修记录信息
     * @param repairInfo{repair_id }
     * @return repairInfo类型的对象
     */
    RepairInfo getRepairInfoById(RepairInfo repairInfo);

    /**
     * 根据条件查询维修记录、返回集合client_id、repair_id、worker_id
     * @param repairInfo {studentName 可能为空，可能不为空 studentNumber可能为空，可能不为空}
     * 1.studentName studentNumber都为空 ——> select * from student_info
     * 2.studentName != null --> select * from student_info where student_name like ?
     * 3.studentNumber != null --> select * from student_info where student_number like ?
     * 4.studentName && studentNumber != null
     * 	-->select * from student_info where student_name = ? and student_number = ?
     * @return 全部集合
     */
    List<RepairInfo> getRepairInfos(RepairInfo repairInfo);

    Long getRepairCount(RepairInfo repairInfo);

}
