# smart_lock

每天下午下班之前请将自己改动的部分上传

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
7.20

chen    14：20

* client页面修改了引入css的<link
* css文件中的"tooplate-style.css" 请替换css01中新上传的版本

## 
chen    10：55

* client页面添加了共6个警示弹窗、2个修改信息弹窗
* manager页面添加了一个点击查看详情弹窗

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
7.19

chen    22：15

* client页面添加了修改信息弹窗与警示弹窗
## 

chen    20：25

* 修改了前端页面
* css文件请替换css01中内容；js文件也需要替换
* img图片请替换img01中内容
## 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

7.18
wang：

>参考学习ajax： https://www.cnblogs.com/baijinqiang/p/8594041.html

## (1)Test调试完毕
## (2)用ajax和后端连接
* 模板里目前能对manager页面
    第一个模块维修申请处理`manager/repairlist.d`
    能够输入员工号查询
* ==接下来看懂原理，复现==

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


7.17
wang：

## （1）增加

增添BaseController.java、BaseBean.java——翻页用（在后面的controller和Info类会继承Base方法）

增添【Repair】Info、Dao、xml、controller、service

## （2）测试
### 调试完毕
* FamilyTest和LockTest完全调试完毕
（增删改查、id查询外键连锁查询client_id）

* clientTest和workerTest
(add、id查询单个client信息、每个client_id查询返回对应的familyInfos集合、每个client_id查询返回对应的locks集合)
worker同理

### 正在调试
* 

* 其余各个Test还在调试中


