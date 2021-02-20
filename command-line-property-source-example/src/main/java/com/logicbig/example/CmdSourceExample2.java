package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.util.Arrays;

@Configuration
public class CmdSourceExample2 {

    @Bean
    public MyBean myBean1() {
        return new MyBean();
    }

    /**
     * mvn -q clean compile exec:java -Dexec.mainClass="com.logicbig.example.CmdSourceExample2" -Dexec.args="--myProp=testval1 --myProp2=testVal2"
     */
    public static void main(String[] args) {

        PropertySource theSource = new SimpleCommandLinePropertySource(args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CmdSourceExample2.class);

        context.getEnvironment().getPropertySources().addFirst(theSource);

        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();
    }

    public class MyBean {
        @Autowired
        private Environment environment;

        public void doSomething() {
            String value = environment.getProperty("myProp");
            System.out.println("the value of myProp: " + value);
        }
    }
}
