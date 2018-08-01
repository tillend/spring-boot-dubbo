package org.spring.boot.dubbo.generic.utils;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.dubbo.generic.model.GenericReqModel;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.google.common.collect.Maps;

public class DubboUtils {

    private static Logger logger = LoggerFactory.getLogger(DubboUtils.class);

    private static ApplicationConfig application = new ApplicationConfig("generic-reference");

    private static Map<String, GenericService> serviceCache = Maps.newConcurrentMap();

    /**
     * 获取泛化服务接口(如有缓存, 则从缓存取)
     * 
     * @param reqModel
     * @return
     */
    public static GenericService fetchGenericService(GenericReqModel reqModel) {
        // 参数设置
        String serviceInterface = reqModel.getService();
        String serviceGroup = reqModel.getGroup();
        String serviceVersion = reqModel.getVersion();

        // 从缓存中获取服务
        String serviceCacheKey = serviceInterface + "-" + serviceGroup + "-" + serviceVersion;
        GenericService service = serviceCache.get(serviceCacheKey);
        if (service != null) {
            logger.info("fetched generic service from cache");
            return service;
        }

        // 配置调用信息
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(application);
        reference.setInterface(serviceInterface);
        reference.setGroup(serviceGroup);
        reference.setVersion(serviceVersion);
        reference.setGeneric(true); // 声明为泛化接口

        // 获取对应服务
        service = reference.get();

        // 缓存
        serviceCache.put(serviceCacheKey, service);

        return service;
    }

    /**
     * 根据接口类名及方法名通过反射获取参数类型
     * 
     * @param interfaceName 接口名
     * @param methodName 方法名
     * @return
     * @throws ClassNotFoundException
     */
    public static String[] getMethodParamType(String interfaceName, String methodName) throws ClassNotFoundException {
        String[] paramTypeList = null;

        // 创建类
        Class<?> clazz = Class.forName(interfaceName);
        // 获取所有的公共的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {

                Class<?>[] paramClassList = method.getParameterTypes();
                paramTypeList = new String[paramClassList.length];

                int i = 0;
                for (Class<?> className : paramClassList) {
                    paramTypeList[i] = className.getTypeName();
                    i++;
                }
                break;
            }
        }

        return paramTypeList;
    }
}