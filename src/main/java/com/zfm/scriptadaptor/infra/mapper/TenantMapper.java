package com.zfm.scriptadaptor.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfm.scriptadaptor.domain.entity.Tenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: .
 * @Author: Z-FM.
 */
@Mapper
public interface TenantMapper extends BaseMapper<Tenant> {
}
