package com.zfm.scriptadaptor.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.domain.entity.Tenant;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
public interface TenantRepository {

    IPage<Tenant> selectByName(Page<Tenant> page, QueryWrapper<Tenant> tenant);

}
