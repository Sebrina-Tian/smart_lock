package com.cqjtu.wlw.dao;

import com.cqjtu.wlw.pojo.FamilyInfo;

import java.util.List;

public interface FamilyDao {
    /**
     * 添加一条学生信息
     * @param familyInfo {member_id,member_name,member_photo,client_id}
     */
    void addFamilyInfo(FamilyInfo familyInfo);
    /**
     * 删除一条学生信息
     * @param familyInfo{memberId }
     */
    void deleteFamilyInfo(FamilyInfo familyInfo);
    /**
     * 更新学生信息
     * @param familyInfo {member_id,member_name,member_photo,client_id}
     */
    void updateFamilyInfo(FamilyInfo familyInfo);

    /**
     * 根据id查询用户信息
     * @param familyInfo{memberId }
     * @return FamilyInfo类型的对象
     */
    FamilyInfo getFamilyInfoById(FamilyInfo familyInfo);

//	/**
//	 * 查询所有学生信息
//	 * @return
//	 */
//	public List<StudentInfo> getStudentInfos();

    /**
     * 根据条件查询学生记录
     * @param familyInfo {studentName 可能为空，可能不为空 studentNumber可能为空，可能不为空}
     * 1.studentName studentNumber都为空 ——> select * from student_info
     * 2.studentName != null --> select * from student_info where student_name like ?
     * 3.studentNumber != null --> select * from student_info where student_number like ?
     * 4.studentName && studentNumber != null
     * 	-->select * from student_info where student_name = ? and student_number = ?
     * @return
     */
    List<FamilyInfo> getFamilyInfos(FamilyInfo familyInfo);
}
