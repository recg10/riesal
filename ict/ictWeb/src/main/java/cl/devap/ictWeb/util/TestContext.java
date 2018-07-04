package cl.devap.ictWeb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cl.devap.ict.exception.IctException;
import cl.devap.ictLogic.service.UserService;

public class TestContext {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("F:\\desarrollo\\java\\workspaceFlowMonitor\\ict\\ictWeb\\src\\main\\resources\\META-INF\\spring\\webApplicationContext.xml");
        System.out.println(context.getBeanDefinitionNames());
        UserService someBean = (UserService) context.getBean("userServiceImpl");
        try {
			someBean.login("1", "riesal");
		} catch (IctException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
