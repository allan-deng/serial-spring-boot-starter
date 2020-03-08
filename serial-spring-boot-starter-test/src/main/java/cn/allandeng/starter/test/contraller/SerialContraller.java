package cn.allandeng.starter.test.contraller;/**
 * @Auther: Allan
 * @Date: 2020/3/8 17:24
 * @Description:
 */

import cn.allandeng.starter.test.service.SerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SerialContraller
 * @Date:2020/3/8 17:24
 * @Description:
 * @Author: Allan Deng
 * @Version: 1.0
 **/
@Controller
public class SerialContraller {

    @Autowired
    SerialService service;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        byte[] data = {'o' , 'k'};
        service.getDefaultPort().send( data);
        return "hello";
    }
}
