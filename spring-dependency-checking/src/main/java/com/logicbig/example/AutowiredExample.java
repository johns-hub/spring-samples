package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/dependency-check.html
 */
@Configuration
public class AutowiredExample {

    @Bean
    public ClientBean clientBean() {
        return new ClientBean();
    }

    // remove following comment to fix java.lang.IllegalArgumentException: ServiceBean not set
    /* @Bean
    public ServiceBean serviceBean() {
        return new ServiceBean();
    }*/

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredExample.class);
        ClientBean bean = context.getBean(ClientBean.class);
        bean.work();
    }

    public static class ClientBean {
        private InitializingBeanExample.ServiceBean serviceBean;

        @Autowired
        public void setServiceBean(InitializingBeanExample.ServiceBean serviceBean) {
            this.serviceBean = serviceBean;
        }

        public void work() {
            System.out.println("service bean instance: " + serviceBean);
        }
    }

    public static class ServiceBean {
    }
}
