package org.spring.boot.dubbo.generic.controller;

import org.spring.boot.dubbo.generic.model.GenericReqModel;
import org.spring.boot.dubbo.generic.utils.DubboUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping(value = "/")
public class GenericController {

    @RequestMapping(value = "/generic", consumes = "application/json; charset=UTF-8",
        method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object call(@ModelAttribute("reqModel") GenericReqModel reqModel) throws ClassNotFoundException {
        Object result = null;

        // 1.获取泛化服务接口
        GenericService service = DubboUtils.fetchGenericService(reqModel);

        // 2.组装调用参数
        String method = reqModel.getMethod();

        String[] parameterTypes = DubboUtils.getMethodParamType(reqModel.getService(), reqModel.getMethod());

        Object[] args = JSON.parseArray(reqModel.getParamValues()).toArray(new Object[] {});

        // 3.调用接口
        result = JSON.toJSONString(service.$invoke(method, parameterTypes, args));

        return result;
    }

}
