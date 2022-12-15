package com.zfm.scriptadaptor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: .
 * @Author: Z-FM.
 */
@Data
@TableName("tenant")
public class Tenant extends BaseDomain {

    /**
     * tenant_id
     */
    @TableId
    private Long tenantId;

    /**
     * 租户编码
     */
    private String tenantNum;

    /**
     * 租户名
     */
    private String tenantName;

    /**
     * 是否启用。1启用，0未启用
     */
    private int enabledFlag;

    /**
     * 租户下的有效用户数，null表示不限制
     */
    private Integer limitUserQty;

    /**
     * 1自费，0供应商缴费
     */
    private int ownExpense;

    /**
     * 租户消息拦截阈值-默认100
     */
    private Integer messageThreshold;

    /**
     * 租户管理员邮箱
     */
    private String adminEmail;

    /**
     * 租户管理员手机
     */
    private String adminPhone;

    /**
     * 租户管理员
     */
    private String tenantAdmin;


}
