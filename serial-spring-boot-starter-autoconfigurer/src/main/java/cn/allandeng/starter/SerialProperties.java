package cn.allandeng.starter;/**
 * @Auther: Allan
 * @Date: 2020/3/8 16:34
 * @Description:
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SerialProperties
 * @Date:2020/3/8 16:34
 * @Description:
 * @Author: Allan Deng
 * @Version: 1.0
 **/
@ConfigurationProperties(prefix = "allan.serial")
public class SerialProperties {

    private String portName;

    private int baudrate;

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public int getBaudrate() {
        return baudrate;
    }

    public void setBaudrate(int baudrate) {
        this.baudrate = baudrate;
    }
}
