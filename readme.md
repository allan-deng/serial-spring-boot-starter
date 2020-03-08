# serial-spring-boot-starter

Serial  Spring Boot Starter

RXTX串口通讯的Spring Boot Starter

## 使用前准备

在maven中安装[SerialConnect项目](https://github.com/allandengcn/SerialConnect)

在maven中安装serial-spring-boot-starter 和 serial-spring-boot-starter-autoconfigurer

## 如何使用

* 添加依赖

  ```xml
  <dependency>
      <groupId>cn.allandeng.starter</groupId>
      <artifactId>serial-spring-boot-starter</artifactId>
      <version>1.0-SNAPSHOT</version>
  </dependency>
  ```

* 修改配置文件

  ```properties
  allan.serial.portName = COM6 
  allan.serial.baudrate = 9600
  ```

* 注入SerialPortFactory和默认Port

  ``` java
  @Autowired
  SerialPortFactory serialPortFactory;
  
  @Autowired
  Port defaultPort;
  ```

## 文件目录

* serial-spring-boot-starter  ----serial的start

* serial-spring-boot-starter-autoconfigurer  ----serial的autoconfigurer

* serial-spring-boot-starter-test   ----测试start功能的SpringBoot项目