package com.zfm.scriptadaptor.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.app.service.ScriptLineService;
import com.zfm.scriptadaptor.domain.entity.ScriptLine;
import com.zfm.scriptadaptor.domain.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 脚本详情接口.
 * @Author: feiming.zhang@going-link.com.
 */
@RestController
@RequestMapping("/script-line")
public class ScriptLineController {

    @Autowired
    private ScriptLineService scriptLineService;

    @GetMapping
    public ResponseEntity<List<ScriptLine>> list() {
        return Results.success(this.scriptLineService.list());
    }

    @GetMapping("/page")
    public ResponseEntity<IPage<ScriptLine>> page(ScriptLine scriptLine, Integer pageNo, Integer pageSize) {
        Page<ScriptLine> page = new Page<>(pageNo, pageSize);
        return Results.success(this.scriptLineService.page(page, new QueryWrapper<ScriptLine>().lambda().
                eq(scriptLine.getTenantId() != null, ScriptLine::getTenantId, scriptLine.getTenantId()).
                eq(scriptLine.getScriptHeaderId() != null, ScriptLine::getScriptHeaderId, scriptLine.getScriptHeaderId())
        ));
    }

    @PostMapping
    public ResponseEntity<ScriptLine> ScriptLine(@RequestBody @Valid ScriptLine scriptLine) {
        this.scriptLineService.save(scriptLine);
        return Results.success(scriptLine);
    }

}
