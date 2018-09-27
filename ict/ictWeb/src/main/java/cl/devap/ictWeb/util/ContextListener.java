package cl.devap.ictWeb.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

@WebListener("application context listener")
public class ContextListener implements ServletContextListener {
 
    /**
     * Initialize log4j when the application is being started
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // initialize log4j here
        ServletContext context = event.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
         
        PropertyConfigurator.configure(fullPath);
        
        
//        XmlWebApplicationContext contextSpring = new XmlWebApplicationContext();
//        contextSpring.setConfigLocation("/META-INF/spring/webApplicationContextRiesal.xml");
//        contextSpring.setServletContext(event.getServletContext());
//        contextSpring.refresh();
        
         
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
//        ApplicationContext contextSpring = new FileSystemXmlApplicationContext("F:\\desarrollo\\java\\workspaceFlowMonitor\\ict\\ictLogic\\src\\main\\resources\\META-INF\\webApplicationContext.xml");
      
        System.out.println(ctx.getBeanDefinitionNames());
//        UserDAO dao = null;
//        try {
//        	dao = (UserDAO) ctx.getBean("userDAO");
//        	if ( dao== null ){
//        		ApplicationContext contextSpring = new FileSystemXmlApplicationContext("F:\\desarrollo\\java\\workspaceFlowMonitor\\ict\\ictWeb\\src\\main\\resources\\META-INF\\spring\\applicationContext.xml");
//        		ConfigurableListableBeanFactory beanFactory = null;
//        		
//        		WebApplicationContextUtils.registerEnvironmentBeans(beanFactory, context);
//        } 
//        	
//		} catch (Exception e) {
//			if ( dao== null ){
//        		ApplicationContext contextSpring = new FileSystemXmlApplicationContext("F:\\desarrollo\\java\\workspaceFlowMonitor\\ict\\ictWeb\\src\\main\\resources\\META-INF\\spring\\applicationContext.xml");
//        		ConfigurableListableBeanFactory beanFactory = null;
//        		
//        		WebApplicationContextUtils.registerEnvironmentBeans(beanFactory, context);
//        } 
//		}
       
        
//        
        
        
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }  
}