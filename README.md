# ALL Docs
:love_letter:一个文档检索和存储平台

管理员账号:admin123 密码：admin123456

在线地址：http://20.187.96.43

# bug和一些todu
<ul>
<li>ppt，pptx, doc 暂时没有想到更好的解决办法,预览的时候采用原始文件转成pdf文件,然后再进行预览操作 </li>
<li>记录用户上次阅读的页数</li> :stars:
<li>Third item</li>
<li>Fourth item</li>
</ul>



// 用户搜索内容进行采集； // 用户的搜索和评论必须经过防刷；违禁词过滤等。

// 存储用户经常搜索的内容

// 存储最热点击的文档

// 存储热搜榜单

// https://blog.csdn.net/weixin_41725792/article/details/110928066

启动mongodb

./mongod --dbpath=/data/mongo --logpath=/usr/local/mongodb4/db.log --fork

启动es

systemctl start elasticsearch
在macos上进行安装redis https://www.jianshu.com/p/3bdfda703552

在macos上安装es https://cloud.tencent.com/developer/article/2032233 注意版本适配

// 权限自适应设计 1、是否开启普通用户上传功能 2、是否开启管理员强制审核功能 3、是否开启违禁词提醒功能？

4、文档评审，等待，评审完成，评审失败

// 增加用户ip封禁 1、恶意ip检索 2、恶意ip下载 验证码 增加用户封禁功能

// 存储量统计 1、mongodb的统计接口 2、es的统计接口

// 评审页面，增加用户删除文档的提醒信息 // 可以进行删除 // 文档下载记录 // 某某人下载了某某文档

// 关闭管理员评审功能 // 设置日志保留时间，1个月，2个月，3个月，自动删除

备注：

删除文档的时候：

1、删除审核信息

2、删除评论信息

3、删除检索的内容信息
