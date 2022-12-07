package com.zfm.scriptadaptor.api.controller;

import com.zfm.scriptadaptor.app.service.ScriptService;
import com.zfm.scriptadaptor.domain.entity.Script;
import com.zfm.scriptadaptor.domain.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 脚本接口.
 * @Author: feiming.zhang@going-link.com.
 */
@RestController
@RequestMapping("/script")
public class ScriptController {

    @Autowired
    private ScriptService scriptService;

    @GetMapping
    public ResponseEntity<List<Script>> list() {
        return Results.success(this.scriptService.scripts());
    }

//    @GetMapping("/page")
//    public ResponseEntity<IPage<Tenant>> page(Tenant tenant, Integer pageNo, Integer pageSize) {
//        Page<Tenant> page = new Page<>(pageNo, pageSize);
//        return Results.success(this.tenantService.page(page, new QueryWrapper<Tenant>().lambda().
//                like(StringUtils.isNotEmpty(tenant.getTenantName()), Tenant::getTenantName, tenant.getTenantName())
//        ));
//    }
//
//    @PostMapping
//    public ResponseEntity<Boolean> tenant(@RequestBody Tenant tenant) {
//        return Results.success(this.tenantService.save(tenant));
//    }

}
