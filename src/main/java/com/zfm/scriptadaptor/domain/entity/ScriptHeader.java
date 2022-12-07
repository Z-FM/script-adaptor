package com.zfm.scriptadaptor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@TableName("script_header")
@Data
public class ScriptHeader extends BaseDomain {
    /**
     * 脚本主键
     */
    @TableId
    private Integer scriptHeaderId;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 所属服务
     */
    private String runningService;

    /**
     * 脚本编码
     */
    private String scriptCode;

    /**
     * 启用
     */
    private String enableFlag;

    /**
     * 描述
     */
    private String description;
}
