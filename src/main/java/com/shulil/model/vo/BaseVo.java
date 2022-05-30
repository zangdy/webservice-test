package com.shulil.model.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zangdongyun
 * @Desc: 顶层 vo
 */
@JacksonXmlRootElement(localName = "response")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class BaseVo<T> implements Serializable {

    @NotBlank
    @JacksonXmlProperty(localName = "ret_code")
    private String retCode;

    @JacksonXmlProperty(localName = "ret_msg")
    private String retMsg;

    @JacksonXmlElementWrapper(localName = "output")
    private T output;
}
