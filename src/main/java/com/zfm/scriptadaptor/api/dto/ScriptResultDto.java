package com.zfm.scriptadaptor.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 执行请求对象.
 * @Author: feiming.zhang@going-link.com.
 */
@Data
public class ScriptResultDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rawInputJsonStr;

    private String rawResultJsonStr;

}
