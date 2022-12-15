package com.zfm.scriptadaptor.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.app.service.ScriptHeaderService;
import com.zfm.scriptadaptor.domain.entity.ScriptHeader;
import com.zfm.scriptadaptor.domain.utils.Results;
import com.zfm.scriptadaptor.domain.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 脚本基本信息接口.
 * @Author: Z-FM.
 */
@RestController
@RequestMapping("/script-header")
public class ScriptHeaderController {

    @Autowired
    private ScriptHeaderService scriptHeaderService;

    @GetMapping
    public ResponseEntity<List<ScriptHeader>> list() {
        return Results.success(this.scriptHeaderService.list());
    }

    @GetMapping("/page")
    public ResponseEntity<IPage<ScriptHeader>> page(ScriptHeader scriptHeader, Integer pageNo, Integer pageSize) {
        Page<ScriptHeader> page = new Page<>(pageNo, pageSize);
        return Results.success(this.scriptHeaderService.page(page, new QueryWrapper<ScriptHeader>().lambda().
                eq(StringUtils.isNotEmpty(scriptHeader.getScriptCode()), ScriptHeader::getScriptCode, scriptHeader.getScriptCode()).
                eq(scriptHeader.getTenantId() != null, ScriptHeader::getTenantId, scriptHeader.getTenantId()).
                eq(StringUtils.isNotEmpty(scriptHeader.getRunningService()), ScriptHeader::getRunningService, scriptHeader.getRunningService())
        ));
    }

    @PostMapping
    public ResponseEntity<ScriptHeader> ScriptHeader(@RequestBody @Valid ScriptHeader scriptHeader) {
        this.scriptHeaderService.save(scriptHeader);
        return Results.success(scriptHeader);
    }

}
