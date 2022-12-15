package com.zfm.scriptadaptor.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zfm.scriptadaptor.api.dto.ScriptExecuteDto;
import com.zfm.scriptadaptor.api.dto.ScriptResultDto;
import com.zfm.scriptadaptor.app.service.ScriptService;
import com.zfm.scriptadaptor.domain.entity.Script;
import com.zfm.scriptadaptor.domain.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 脚本接口.
 * @Author: Z-FM.
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

    @GetMapping("/page")
    public ResponseEntity<IPage<Script>> page(@PathVariable Script script, Integer pageNo, Integer pageSize) {
        Page<Script> page = new Page<>(pageNo, pageSize);
        return Results.success(this.scriptService.page(page, script));
    }

    @PostMapping("/execute")
    public ResponseEntity<String> execute(@RequestBody @Valid ScriptExecuteDto scriptExecuteDto) throws JsonProcessingException {
        ScriptResultDto resultDto = scriptService.execute(scriptExecuteDto);
        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(resultDto));
    }

}
