# 疫情数据可视化
### 持续关注B站up主：李飞飞stars
### 主页地址:[https://space.bilibili.com/394034901](https://space.bilibili.com/394034901)
一名热爱编程的在校男生，享受代码冲浪，尝试分享我眼中的世界，好玩的地方就有我李飞飞。
#### Description：
+ 敲纯粹的代码，在代码中冲浪 

## 实现功能：
~~~shell
根据用户注册信息所在省份，进行疫情监控，
如果检测到情况，会通过发邮箱的方式进行提醒用户
~~~


## 安装教程
+ Maven安装依赖
+ 修改application.yml中DB层的配置
+ 修改工具类SendmailUtil中的邮箱地址和密钥
+ 运行SQL文件初始化MySQL建表
+ 运行爬虫脚本spider.py更新数据，设置定时任务
+ 运行SpringBoot

## 技术栈
+ 架构:SpringBoot后台+echarts可视化
+ DB:Mysql8.0+Redis
+ 爬虫:Python脚本
