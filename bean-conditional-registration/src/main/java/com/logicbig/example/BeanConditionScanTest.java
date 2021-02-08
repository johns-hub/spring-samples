package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Configuration
@ComponentScan(basePackageClasses = BeanConditionScanTest.class,
                    useDefaultFilters = false,
                    includeFilters = {@ComponentScan.Filter(
                                type = FilterType.ASSIGNABLE_TYPE,
                                value = {BeanConditionScanTest.MyClientBean.class,
                                        BeanConditionScanTest.ServiceBeanImpl1.class,
                                        BeanConditionScanTest.ServiceBeanImpl2.class})})
public class BeanConditionScanTest {
    public static void main(String[] args) {
        runApp(Locale.US);
        System.out.println("----------");
        runApp(Locale.CANADA);
    }

    public static void runApp(Locale locale) {
        /**
         * In real application, Locale will be set with your machine
         * depending on your location. Here we are setting it manually
         * to test our example
         */
        System.out.printf("setting default locale: %s\n", locale);
        Locale.setDefault(locale);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConditionScanTest.class);

        MyClientBean bean = context.getBean(MyClientBean.class);
        System.out.printf("Injected ServiceBean instance in MyClientBean: %s\n", bean.getServiceBean()
                .getClass()
                .getSimpleName());
    }

    @Component
    public static class  MyClientBean {
        @Autowired
        private ServiceBean serviceBean;

        public ServiceBean getServiceBean() {
            return serviceBean;
        }
    }

    public interface ServiceBean {
    }

    @Component
    @Conditional(LocaleConditionUSA.class)
    public static class ServiceBeanImpl1 implements ServiceBean {
    }

    @Component
    @Conditional(LocaleConditionCanada.class)
    public static class ServiceBeanImpl2 implements ServiceBean {
    }
}
