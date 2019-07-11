
整体框架  springboot + springsecurity + mybatis +redis（redisson）+themleaf+bootstraps+vue
springboot， pom里边配置的都是基于springcloud的，稍微调整就可以加入到springcloud体系里边。
springsecurity，详细配置看config包里边的源码

使用前准备：
框架里边的js css，都放到了nginx服务器（172.16.14.104）里边，所以在自己hosts里边追加：
172.16.14.104 test.mystaticdomain.com

待处理的：
1. 追加swagger
2. 移除程序框架里的activiti
3. 更换mysql为postgresql
