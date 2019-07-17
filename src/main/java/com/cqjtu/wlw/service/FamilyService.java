package com.cqjtu.wlw.service;

import com.cqjtu.wlw.pojo.FamilyInfo;

import java.util.List;

public interface FamilyService {
    /**
     * menber注册
     * @param familyInfo
     */
    void regFamilyInfo(FamilyInfo familyInfo);

    /**
     * 学生注销
     * @param familyInfo
     */
    void delFamilyInfo(FamilyInfo familyInfo);

    /**
     * 学生信息更新
     * @param familyInfo
     */
    void updateFamilyInfo(FamilyInfo familyInfo);

    /**
     * 根据条件查询学生信息
     * @param FamilyInfo
     * @return
     */
    List<FamilyInfo> getFamilyInfos(FamilyInfo FamilyInfo);
}
