package com.yamltutorial;

public class SystemParameters {
    private int port = 0;
    private String host = "";
    private int param1 = 0;  // Default value set here
    private int param2 = 1;
    private int param3 = 2;  // Default value set here

    // Adjusted constructor to match YAML fields
    public SystemParameters() {}


    // Getters and setters are necessary for SnakeYAML to work properly
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public int getParam1() { return param1; }
    public void setParam1(int param1) { this.param1 = param1; }
    public int getParam2() { return param2; }
    public void setParam2(int param2) { this.param2 = param2; }
    public int getParam3() { return param3; }
    public void setParam3(int param3) { this.param3 = param3; }
}
