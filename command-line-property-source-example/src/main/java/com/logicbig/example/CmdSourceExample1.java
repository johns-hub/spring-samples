package com.logicbig.example;

import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.util.Arrays;

/**
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/command-line-property-source.html
 */
public class CmdSourceExample1 {

    /**
     * mvn -q clean compile exec:java -Dexec.mainClass="com.logicbig.example.CmdSourceExample1" -Dexec.args="--myProp=testval1 --myProp2=testVal2"
     */
    public static void main(String[] args) {
        SimpleCommandLinePropertySource ps = new SimpleCommandLinePropertySource(args);
        Arrays.stream(ps.getPropertyNames()).forEach(s ->
                System.out.printf("%s => %s%n", s, ps.getProperty(s)));
    }
}
