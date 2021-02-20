package com.logicbig.example;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class CmdSourceExample4 {

    /**
     * mvn -q clean compile exec:java -Dexec.mainClass="com.logicbig.example.CmdSourceExample4" -Dexec.args="-myProp testval1"
     */
    public static void main(String[] args) {
        OptionParser parser = new OptionParser();
        parser.accepts("myProp").withRequiredArg();
        OptionSet options = parser.parse(args);

        boolean myProp = options.hasArgument("myProp");
        System.out.println(myProp);
        Object myProp1 = options.valueOf("myProp");
        System.out.println(myProp1);
    }
}
