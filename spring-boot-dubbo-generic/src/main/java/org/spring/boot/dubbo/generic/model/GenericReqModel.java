package org.spring.boot.dubbo.generic.model;

import java.io.Serializable;

public class GenericReqModel implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = 3548457701031525454L;

    private String registry; // 注册中心地址
    private String service; // 服务包下类名
    private String version; // 版本
    private String group; // 服务组
    private String method; // 方法名
    private String paramTypes; // 参数类型
    private String paramValues; // 参数值

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(String paramTypes) {
        this.paramTypes = paramTypes;
    }

    public String getParamValues() {
        return paramValues;
    }

    public void setParamValues(String paramValues) {
        this.paramValues = paramValues;
    }

}
