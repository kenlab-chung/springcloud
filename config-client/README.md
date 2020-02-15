启动client端，访问链接：http://localhost:8085/hello， 返回：hello dev update，说明已经正确的从server端获取到了参数。
但再次修改springcloud-config-dev.properties中的内容为：hello dev update1，后，再访问http://localhost:8085/hello.
返回的内容还是hello dev update，因为springboot项目只有在启动的时候才会获取配置文件的值.
修改信息后，client端并没有在次去获取，所以导致这个问题。如何去解决这个问题呢,答案是Spring Cloud Bus 消息总线.