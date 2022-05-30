package com.shulil.config;

import com.shulil.webservice.TestWebservice;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

/**
 * @author zangdongyun
 * @Desc webservice配置类
 */
@Configuration
public class WebServiceConfg {

    @Autowired
    private Bus bus;

    @Autowired
    private TestWebservice testWebservice;

    /**
     * 可以通过配置该bean修改默认服务地址，如果不配置该bean，则默认服务是在host:port/services/发布地址 下
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");
    }

    /**
     * 配置CXF服务发布，默认服务是在host:port/services/发布地址
     * 1、默认访问地址 http://127.0.0.1:8080/services/examine?wsdl
     * 2、配置了ServletRegistrationBean后访问地址：http://127.0.0.1:8080/webservice/examine?wsdl
      */
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,testWebservice);
        //  发布地址
        endpoint.publish("/examine");
        return endpoint;
    }

}
