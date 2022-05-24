# huang-typora-upload

用于Markdown笔记工具Typora中图片插入自动上传服务器

注：目前只集成Minio，如果需要整合上传其他类型文件系统或本地文件系统，需要对应修改com/huang/service/impl/DefaultUploadServiceImpl.java的上传方法

## 使用方法

- 拉取项目

  ```shell
  git clone https://github.com/InsaneLighter/huang-typora-upload.git
  ```

- 使用idea打开项目，修改app.properties中Minio配置

  ```properties
  #endpoint：MinIO 的 API 通信地址
  endpoint=ip:port
  #用户名
  accessKey=username
  #密码
  secretKey=password
  #生成上传文件的访问路径
  nginxHost=nginx配置映射
  ```

- 执行`mvn clean packge`,将打包好的文件移动至固定文件夹中，eg. H:\personal\md_file_upload\huang-typora-upload.jar

- 将命令`java -jar H:\personal\md_file_upload\huang-typora-upload.jar `复制进Typora对应设置框中

  ![image-20220524184624833](http://150.158.169.154:9003/typora/typora_1653389187351_2022-05-24_72.png)



- 执行完上图中第6个步骤应显示如下图，整个配置过程就结束~~~

  ![image-20220524184749097](http://150.158.169.154:9003/typora/typora_1653389271639_2022-05-24_453.png)
