## BookManage

早期做的一个基于SSH框架的图书管理系统，作为学习了Struts2，Spring4，Hibernate的初学者第一个开发的整合项目来说，应该具备的一些技能。

## 项目介绍：

- 在图书管理系统中，系统数据库存有每个学生的账户信息，每个学生的信息主要由借书证号(学号)和姓名等构成，读者可以根据的借书证在图书馆进行图书的借，还，查询等工作。
- 借阅图书时，由管理员录入读者的借书卡号，系统先验证该卡号是否有效，若无效，则提示卡号无效的原因；若有效，则显示卡号，以及该卡号下当前借阅图书的信息，借阅成功后该学生的已借图书量+1，借的图书剩余量-1，若图书剩余为0，则无法借阅。
- 归还图书时，由管理员录入读者的借书卡号，系统先验证该卡号是否有效，若无效，则提示卡号无效的原因；若有效，则显示卡号，以及该卡号下当前借阅图书的信息，输入已借阅的图书的ISBN点击还书，则消除该读者已借阅的这图书，若ISBN错误或者没有借这本书，则提示相关错误信息。
- 图书管理员能够不定期地对图书信息进行添加，修改，查询，删除操作，在图书尚未归还的状况下，管理员无法对图书进行删除。

## 系统结构图：

![Alt text](https://github.com/Csh090501/BookManage/raw/master/img/系统结构图.png)


## 功能模块介绍：
- 读者信息管理：可以对所有读者信息进行管理，包括增添，删除，修改，查讯。
- 图书信息管理：由管理员不定期地对图书信息进行维护，图书的添加，修改和删除，需要时进行图书信息的查询。
- 图书借阅管理：由管理员对读者的借阅和归还图书进行管理，借阅和归还主要通过读者的借书证号和需借阅（归还）的图书的ISBN来进行操作，借阅时在该读者的信息中添加一条借阅信息，归还图书时消除该条借阅信息。
- 综合管理：读者借书超过规定借阅时间进行处罚以及图书遗失的赔偿处理等等(当时课程设计紧迫未实现该模块，后来也就忘了没做这个)。

## 运用技术：

运用Struts2 + Spring4 + Hibernate框架.

## 准备：
- 导入第三方jar包，使用的包就是支持SSH的jar包，jdbc等等。
- 建立包文件：action , dao , db , model , service , tool , util, 感觉有些包和在一起可能好点，当时学的时候没有管太多建包的事，怎么想的就怎么去建了，现在看来很不合理。

## 环境搭建： 

Eclipse + Tomcat + MySQL

## 项目截图：

### 借书还书界面:

![Alt text](https://github.com/Csh090501/BookManage/raw/master/img/借书还书.png)

### 图书管理:

![Alt text](https://github.com/Csh090501/BookManage/raw/master/img/图书管理.png)

### 图书查询:

![Alt text](https://github.com/Csh090501/BookManage/raw/master/img/图书查询.png)
