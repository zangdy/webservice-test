package com.shulil.webservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.shulil.model.dto.BaseDto;
import com.shulil.model.dto.TestDto;
import com.shulil.model.vo.BaseVo;
import com.shulil.model.vo.TestVo;
import com.shulil.webservice.TestWebservice;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.io.IOException;


/**
 * @author zangdongyun
 * @Desc webservice 测试类
 */
@Slf4j
@Component
@WebService(serviceName = "testWebservice",  // 对外发布服务名
        endpointInterface = "com.shulil.webservice.TestWebservice", // 所实现接口的路径
        targetNamespace = "http://test.webservice.shuli.com" // 指定想要的名称空间，一般是该路径的反写方式
)
public class TestWebServiceImpl implements TestWebservice {

  /**
   * 测试
   *
   * @param requestData 业务入参
   * @return
   */
  @Override
  public String test(String requestData) {
    log.info("请求入参为{}", requestData);
    if (StringUtils.isBlank(requestData)) {
      log.error("入参不能为空！");
      return "入参不能为空!";
    }
    //解析his传入的字符串
    XmlMapper xmlMapper = new XmlMapper();
    // 忽略多余节点
    xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    BaseDto<TestDto> baseDto = null;
    try {
      baseDto = xmlMapper.readValue(requestData, new TypeReference<BaseDto<TestDto>>(){});
    } catch (IOException e) {
      log.error("入参转换异常，失败原因：", e);
      return "入参转换异常!";
    }
    if(baseDto == null){
      log.error("入参格式有误，baseDto不能为空！");
      return "入参格式有误!";
    }
    // 请求入参的具体内容
    TestDto input = baseDto.getInput();
    // TODO: 这里面写具体的逻辑
    log.info(JSONObject.toJSONString(input));

    // 模拟出参
    TestVo testVo = input==null?null:new TestVo();
    BaseVo<TestVo> hisBaseVo = new BaseVo<>();
    if (testVo == null) {
      hisBaseVo.setRetCode("-1");
      hisBaseVo.setRetMsg("处理失败");
    } else {
      hisBaseVo.setRetCode("0");
      hisBaseVo.setRetMsg("处理成功");
      hisBaseVo.setOutput(testVo);
    }
    try {
      return xmlMapper.writeValueAsString(hisBaseVo);
    } catch (JsonProcessingException e) {
      log.error("出参转换异常，失败原因：",e);
      return "预出参转换异常!";
    }
  }

}



