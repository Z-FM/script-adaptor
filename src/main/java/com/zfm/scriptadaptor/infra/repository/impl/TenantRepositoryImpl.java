package com.zfm.scriptadaptor.infra.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.domain.entity.Tenant;
import com.zfm.scriptadaptor.domain.repository.TenantRepository;
import com.zfm.scriptadaptor.infra.mapper.TenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@Component
public class TenantRepositoryImpl implements TenantRepository {

    @Autowired
    private TenantMapper tenantMapper;

    @Override
    public IPage<Tenant> selectByName(Page<Tenant> page, QueryWrapper<Tenant> tenant) {
        return this.tenantMapper.selectPage(page, tenant);
    }
}
