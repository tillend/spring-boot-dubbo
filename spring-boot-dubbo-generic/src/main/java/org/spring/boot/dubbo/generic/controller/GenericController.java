package org.spring.boot.dubbo.generic.controller;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import org.spring.boot.dubbo.generic.model.GenericReqModel;
import org.spring.boot.dubbo.generic.utils.DubboUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class GenericController {

    @RequestMapping(value = "/generic", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object call(@ModelAttribute("reqModel") GenericReqModel reqModel) throws ClassNotFoundException {
        Object result = null;

        // 1.获取泛化服务接口
        GenericService service = DubboUtils.fetchGenericService(reqModel);

        // 2.组装调用参数
        String method = reqModel.getMethod();

        String[] parameterTypes = DubboUtils.getMethodParamType(reqModel.getService(), reqModel.getMethod());

        Object[] args = JSON.parseArray(reqModel.getParamValues()).toArray(new Object[]{});

        // 3.调用接口
        return JSON.toJSONString(service.$invoke(method, parameterTypes, args));

    }

}
