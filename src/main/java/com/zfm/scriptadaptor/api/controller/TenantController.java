package com.zfm.scriptadaptor.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.app.service.TenantService;
import com.zfm.scriptadaptor.domain.entity.Tenant;
import com.zfm.scriptadaptor.domain.utils.Results;
import com.zfm.scriptadaptor.domain.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping
    public ResponseEntity<List<Tenant>> list() {
        return Results.success(this.tenantService.list());
    }

    @GetMapping("/page")
    public ResponseEntity<IPage<Tenant>> page(Tenant tenant, Integer pageNo, Integer pageSize) {
        Page<Tenant> page = new Page<>(pageNo, pageSize);
        return Results.success(this.tenantService.page(page, new QueryWrapper<Tenant>().lambda().
                like(StringUtils.isNotEmpty(tenant.getTenantName()), Tenant::getTenantName, tenant.getTenantName())
        ));
    }

    @PostMapping
    public ResponseEntity<Tenant> tenant(@RequestBody @Valid Tenant tenant) {
        this.tenantService.save(tenant);
        return Results.success(tenant);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(Long tenantId) {
        return Results.success(this.tenantService.removeById(tenantId));
    }

}
