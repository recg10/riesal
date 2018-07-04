package cl.devap.ictWeb.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean (name="themeBean")
public class ThemeBean {

    public String getApplicationTheme() {
//        return "dark-hive";bootstrap
    	return "bootstrap";
    }

}