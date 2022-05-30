package com.shulil.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zangdongyun
 * @Desc 顶层 dto
 */
@JacksonXmlRootElement(localName = "request")
@Data
@NoArgsConstructor
public class BaseDto<T> implements Serializable {

    @JacksonXmlProperty(localName = "time_stamp")
    private String timestamp;

    @NotNull
    @JacksonXmlElementWrapper(localName = "input")
    private T input;

}
