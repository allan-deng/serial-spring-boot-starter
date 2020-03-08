package cn.allandeng.starter.test.service;/**
 * @Auther: Allan
 * @Date: 2020/3/8 17:19
 * @Description:
 */

import cn.allandeng.serial.factory.SerialPortFactory;
import cn.allandeng.serial.port.Port;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SerialService
 * @Date:2020/3/8 17:19
 * @Description:
 * @Author: Allan Deng
 * @Version: 1.0
 **/
@Service
public class SerialService {

    @Autowired
    SerialPortFactory serialPortFactory;

    @Autowired
    Port defaultPort;

    public SerialPortFactory getSerialPortFactory() {
        return serialPortFactory;
    }

    public Port getDefaultPort() {
        return defaultPort;
    }
}
