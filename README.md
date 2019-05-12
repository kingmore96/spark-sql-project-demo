# spark-sql-project-demo
Spark sql 使用案例，通过数据清洗，数据处理，数据入库，数据可视化操作实现业务目标

### 数据源：
#### [慕课网](https://www.imooc.com/)nginx访问日志，使用access_20161111.log作为初始数据，大小为5g，本地测试时，需要把数据拆分成小文件
如何拆分
* windows用户
  * 使用win10自带的powershell处理数据  
  ``` cat access_20161111.log -TotalCount 10000 >> access_20161111_simple.log ```
* linux用户
  * 先使用解压命令,解压到用户家目录  
  ``` tar -zxvf access_20161111.log.gz ``` 
  * 使用下面命令，提取前10000条数据  
  ``` head 10000 access_20161111.log >> ~/access_20161111_simple.log  ```
 
数据源下载地址  
链接：https://pan.baidu.com/s/1pVrQPNwTQ1HKNGMqgXRkKA  
提取码：fnpu 

<hr>

### 业务目标:
* 需求一：统计主站最受欢迎的视频（每一个课程有很多vedio，每一个vedio有编号）/手记（手记的url叫article，也有编号） TopN的访问次数    
（实际业务延伸思考：统计所有网点中最受欢迎的网点访问次数）  

* 需求二：按照地市（根据ip地址提取）统计最受欢迎课程TopN (还需要使用spark sql的窗口函数)
（实际业务延伸思考：统计按照行政区，每个行政区最受欢迎的网点访问次数）

<hr>

## 未完待续......
