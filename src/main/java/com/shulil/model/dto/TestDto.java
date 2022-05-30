package com.shulil.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zangdongyun
 * @Desc 测试dto
 */
@Data
public class TestDto {
    /**
     *code  测试入参字段名不一致问题
     */
    @JacksonXmlProperty(localName = "test_code")
    private String code;

    /**
     * 描述
     */
    @JacksonXmlProperty(localName = "desc")
    private String desc;

}
