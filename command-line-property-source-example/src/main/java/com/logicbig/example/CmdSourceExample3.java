package com.logicbig.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@Configuration
public class CmdSourceExample3 {

    @Bean
    public MyBean myBean1() {
        return new MyBean();
    }

    /**
     * mvn -q clean compile exec:java -Dexec.mainClass="com.logicbig.example.CmdSourceExample3" -Dexec.args="--myProp=testval1 --myProp2=testVal2"
     */
    public static void main(String[] args) {

        PropertySource theSource = new SimpleCommandLinePropertySource(args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.getEnvironment().getPropertySources().addFirst(theSource);

        context.register(CmdSourceExample3.class);
        context.refresh();

        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();
    }

    public class MyBean {
        @Value("${myProp}")
        private String myPropValue;

        public void doSomething() {
            System.out.println("the value of myProp: " + myPropValue);
        }
    }
}
