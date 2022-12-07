package com.zfm.scriptadaptor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@TableName("script_line")
@Data
public class ScriptLine extends BaseDomain {
    /**
     * 主键
     */
    @TableId
    private Integer scriptLineId;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 脚本头id
     */
    private Integer scriptHeaderId;

    /**
     * 脚本内容
     */
    private String scriptContent;

    /**
     * 脚本类型
     */
    private String scriptType;
}
