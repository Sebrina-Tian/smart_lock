package com.cqjtu.wlw.service;


import com.cqjtu.wlw.pojo.FamilyInfo;

import java.util.List;

public interface FamilyService {

    /**
     * member添加
     * @param familyInfo
     */
    void regFamilyInfo(FamilyInfo familyInfo);

    /**
     * 家庭成员信息注销
     * @param familyInfo
     */
    void delFamilyInfo(FamilyInfo familyInfo);

    /**
     * 家庭成员信息更新
     * @param familyInfo
     */
    void updateFamilyInfo(FamilyInfo familyInfo);

    /**
     * 根据条件查询家庭成员信息
     * @param FamilyInfo
     * @return
     */
    List<FamilyInfo> getFamilyInfos(FamilyInfo FamilyInfo);
}
