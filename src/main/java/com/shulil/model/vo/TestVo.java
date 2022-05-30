package com.shulil.model.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author zangdongyun
 * @Desc 测试出参 vo
 */
@Data
public class TestVo {
    /**
     *code  测试出参字段名不一致问题
     */
    @JacksonXmlProperty(localName = "test_code")
    private String code;

    /**
     * 描述
     */
    @JacksonXmlProperty(localName = "desc")
    private String desc;
}
