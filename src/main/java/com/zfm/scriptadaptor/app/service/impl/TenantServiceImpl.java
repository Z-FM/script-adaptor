package com.zfm.scriptadaptor.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfm.scriptadaptor.app.service.TenantService;
import com.zfm.scriptadaptor.domain.entity.Tenant;
import com.zfm.scriptadaptor.infra.mapper.TenantMapper;
import org.springframework.stereotype.Service;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements TenantService {
}
