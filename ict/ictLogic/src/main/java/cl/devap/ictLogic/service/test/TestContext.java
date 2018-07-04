package cl.devap.ictLogic.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestContext {

	public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("F:\\desarrollo\\java\\workspaceFlowMonitor\\ict\\ictLogic\\src\\main\\resources\\META-INF\\webApplicationContext.xml");
        System.out.println(context.getBeanDefinitionNames());
    }

}
