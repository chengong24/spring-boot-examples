package com.neo.listener;

/**
 * @author chengong
 * @date 2021/3/29 3:28 PM
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class PmsServletContextListener implements ServletContextListener{
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        logger.info("liting: contextDestroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        logger.info("liting: contextInitialized");
    }

}