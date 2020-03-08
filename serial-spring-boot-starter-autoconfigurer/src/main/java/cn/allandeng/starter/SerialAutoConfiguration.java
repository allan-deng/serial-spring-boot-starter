package cn.allandeng.starter;/**
 * @Auther: Allan
 * @Date: 2020/3/8 16:32
 * @Description:
 */

import cn.allandeng.serial.factory.SerialPortFactory;
import cn.allandeng.serial.listener.DataAvailableListener;
import cn.allandeng.serial.listener.DefaultListener;
import cn.allandeng.serial.port.Port;
import gnu.io.PortInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @ClassName SerialAutoConfiguration
 * @Date:2020/3/8 16:32
 * @Description:
 * @Author: Allan Deng
 * @Version: 1.0
 **/
@Configuration
@EnableConfigurationProperties(SerialProperties.class)
public class SerialAutoConfiguration {

    @Autowired
    SerialProperties serialProperties;

    SerialPortFactory serialPortFactory;

    @Bean
    @ConditionalOnMissingBean(SerialPortFactory.class)
    public SerialPortFactory getFactory() {
        serialPortFactory = new SerialPortFactory();
        return serialPortFactory;
    }

    @Bean
    public Port getDefualtPort() {
        //把配置的端口添加到容器绑定默认的监听器
        Port serialPort = serialPortFactory.getSerialPort(serialProperties.getPortName());
        try {
            serialPort.openPort(serialProperties.getBaudrate());
        } catch (PortInUseException e) {
            e.printStackTrace();

        }
        serialPort.addListener(new DefaultListener(new DataAvailableListener() {
            @Override
            public void dataAvailable() {
                byte[] data = null;
                try {
                    data = serialPort.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (byte b : data) {
                    System.out.printf("%x" + " ", b);
                }
                System.out.println();
            }
        }));
        return serialPort;
    }
}
