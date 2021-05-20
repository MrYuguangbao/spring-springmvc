package com.springtest.loadproperties;

import com.springtest.t.DataSourceBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 18:21
 */
public class PropertiesMainTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig1.class);
        DataSourceBean bean = context.getBean(DataSourceBean.class);
        bean.show();
    }
}
