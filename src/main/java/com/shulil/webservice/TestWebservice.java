package com.shulil.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * @author zangdongyun
 * @Desc webservice 测试类
 */
@WebService
public interface TestWebservice {


    /**
     * 测试
     * @param requestData 业务入参
     * @return
     */
    @WebMethod
    String test(@WebParam(name = "requestData") String requestData);

}
