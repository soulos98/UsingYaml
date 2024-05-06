package com.yamltutorial;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        while(true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String prompt = "What configuration file would you like to deserialize?"
                            + "\t\n0: Exit"
                            + "\t\n1: Object,"
                            + "\t\n2: FunctionCode object,"
                            + "\t\n3: List of FunctionCode objects";
            System.out.println(prompt);

            try {
                    System.out.print("Selection: ");
                    String result = reader.readLine();

                    int res = Integer.parseInt(result);
                    switch (res) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            basicOne(SystemParameters.class, "input1.yaml");
                            break;
                        case 2:
                            objectTwo(SystemParameterFactory.class, "input2.yaml");
                            break;
                        case 3:
                            objectListThree(Configuration.class, "input3.yaml");
                            break;
                        default:
                            System.out.println("Error selection not defined");
                            break;
                    }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void basicOne(Class type, String fileName) throws Exception{
        Yaml yaml = new Yaml(new Constructor(type, new LoaderOptions()));
        InputStream inputStream = new FileInputStream(fileName);

        SystemParameters singleSimpleObject = yaml.load(inputStream);

        System.out.println("\tPort: " + singleSimpleObject.getPort());
        System.out.println("\tHost: " + singleSimpleObject.getHost());
        System.out.println("\tParam1: " + singleSimpleObject.getParam1());
        System.out.println("\tParam2: " + singleSimpleObject.getParam2());
        System.out.println("\tParam3: " + singleSimpleObject.getParam3());

    }

    public static void objectTwo(Class type, String fileName) throws Exception{
        Yaml yaml = new Yaml(new Constructor(type, new LoaderOptions()));
        InputStream inputStream = new FileInputStream(fileName);
        
        SystemParameterFactory singleFunctionCodeObject = yaml.load(inputStream);

        System.out.println("\tFunction Code: " + singleFunctionCodeObject.getFunctionCode());        
        System.out.println("\tPort: " + singleFunctionCodeObject.getFuncParams().getPort());
        System.out.println("\tHost: " + singleFunctionCodeObject.getFuncParams().getHost());
        System.out.println("\tParam1: " + singleFunctionCodeObject.getFuncParams().getParam1());
        System.out.println("\tParam2: " + singleFunctionCodeObject.getFuncParams().getParam2());
        System.out.println("\tParam3: " + singleFunctionCodeObject.getFuncParams().getParam3());


    }

    public static void objectListThree(Class type, String fileName) throws Exception{
        Yaml yaml = new Yaml(new Constructor(type, new LoaderOptions()));
        InputStream inputStream = new FileInputStream(fileName);

        Configuration config = yaml.load(inputStream);

        List<SystemParameterFactory> codes = config.getFactories();

        for (SystemParameterFactory code : codes) {
            System.out.println("\tFunction Code: " + code.getFunctionCode());        
            System.out.println("\tPort: " + code.getFuncParams().getPort());
            System.out.println("\tHost: " + code.getFuncParams().getHost());
            System.out.println("\tParam1: " + code.getFuncParams().getParam1());
            System.out.println("\tParam2: " + code.getFuncParams().getParam2());
            System.out.println("\tParam3: " + code.getFuncParams().getParam3());
            System.out.println();

        }
    }

}
