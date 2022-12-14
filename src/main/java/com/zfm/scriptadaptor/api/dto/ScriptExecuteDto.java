package com.zfm.scriptadaptor.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 执行请求对象.
 * @Author: feiming.zhang@going-link.com.
 */
@Data
public class ScriptExecuteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "参数不能为空")
    private String rawInputJsonStr;

    private Long scriptId;

    @NotNull(message = "租户不能为空")
    private Long tenantId;

    @NotBlank(message = "请选择要执行的脚本")
    private String scriptCode;

}
