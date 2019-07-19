# smart_lock

每天下午下班之前请将自己改动的部分上传

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

7.19   上午11:40

chen:

修改了homepage和css文件
主页加载更快

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


