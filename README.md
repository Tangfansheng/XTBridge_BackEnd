##### XTBridge WEB后端

###### 架构

​	考虑到同时使用的人数不会很多，后端架构采用单体SSM框架

###### 功能说明

​	项目的第一阶段主要是以安卓端为主，因此现在只提供了安卓端需要的数据接口

​	1.传感器的数据接口：吊杆锚杆的力传感器、桁架的应力传感器、环境监控如温湿度噪声风力数据，挂篮同步相关传感器

​	2.配合安卓端需求做了用户相关的数据接口
###### debug

1. User模块，前端提交表单，后台用RequestBody接收并封装成实体类报500错误。后经过错误排查，实体类中没有无参构造导致的。
2. 跨域请求问题，之前没有接触过前后端分离的情况，因此不了解。跨域的意思就是ip和端口号不一致。前端调试的时候会报No Access-Control-Allow-Origin header...的错。这种情况需要在Controller上加@CrossOrigin注解。
3. Date格式转换问题，这个是我犯蠢，需要在实体类的Date属性加@JsonFormat注解，注意要让日期格式化，是要封装这个对象到json数据中才会生效。我的错误在于将数据再封装之后，再@ResponseBody， 这个时候JsonFormat怎么可能生效呢。以后要从原理上思考问题，而不仅仅是看表象。
