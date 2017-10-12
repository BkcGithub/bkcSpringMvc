package com.bkc.listenner;

import com.bkc.thrift.proxy.ThriftServerProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ThriftServerStartListener  implements ServletContextListener {


    @Override public void contextInitialized(ServletContextEvent sce) {
        //启动SETUP SEERVER
        try {
            ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());

            List<ThriftServerProxy> list = ((List<ThriftServerProxy>) context.getBean("thriftServerList"));
            if(list!=null&&list.size()>0){
                for(ThriftServerProxy userProxy:list){
                    userProxy.start();
                }
            }

            System.out.println("Thrift Server监听接口启动。。。。。。。。。。。");
        } catch (Exception e) {
            System.out.println("Thrift Server监听接口启动错误");
            e.printStackTrace();
        }
    }

    @Override public void contextDestroyed(ServletContextEvent sce) {

    }
}
