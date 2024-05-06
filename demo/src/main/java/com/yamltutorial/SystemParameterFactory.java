package com.yamltutorial;

public class SystemParameterFactory {
    private String functionCode = "null";
    private SystemParameters funcParams;

    public SystemParameterFactory() {
        funcParams = new SystemParameters();
    }

    public SystemParameterFactory(SystemParameters funcParams, String functionCode) {
        this.funcParams = funcParams;
        this.functionCode = functionCode;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public SystemParameterFactory(SystemParameters funcParams) {
        this.funcParams = funcParams;
    }

    public SystemParameters getFuncParams() {
        return funcParams;
    }

    public void setFuncParams(SystemParameters funcParams) {
        this.funcParams = funcParams;
    }
}
