package cl.devap.ictModel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestContext {

	public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("F:\\desarrollo\\java\\workspaceFlowMonitor\\ict\\ictModel\\src\\main\\resources\\META-INF\\applicationContext.xml");
        System.out.println(context.getBeanDefinitionNames());
    }

}
