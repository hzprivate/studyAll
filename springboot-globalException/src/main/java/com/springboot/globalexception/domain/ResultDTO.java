package com.springboot.globalexception.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.globalexception.common.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <p>内部接口返回类.</p>
 *
 * @author hz
 * @since 2020/6/2 15:59
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class ResultDTO {
    /**
     * 接口ID
     */
    @JsonProperty("ID")
    private String Id;
    /**
     * 业务码
     */
    @JsonProperty("Code")
    private String Code;
    /**
     * 业务信息
     */
    @JsonProperty("Message")
    private String Message;
    /**
     * 业务数据
     */
    @JsonProperty("Data")
    private Object Data;

    public String toJson() {
        return Util.objToJson(this);
    }

}

