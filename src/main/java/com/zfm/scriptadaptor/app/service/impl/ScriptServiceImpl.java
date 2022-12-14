package com.zfm.scriptadaptor.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.api.dto.ScriptExecuteDto;
import com.zfm.scriptadaptor.api.dto.ScriptResultDto;
import com.zfm.scriptadaptor.app.service.ScriptService;
import com.zfm.scriptadaptor.domain.entity.Script;
import com.zfm.scriptadaptor.domain.service.ScriptDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 脚本服务类.
 * @Author: feiming.zhang@going-link.com.
 */
@Service
public class ScriptServiceImpl implements ScriptService {

    @Autowired
    private ScriptDomainService scriptDomainService;

    @Override
    public List<Script> scripts() {
        return this.scriptDomainService.scripts();
    }

    @Override
    public IPage<Script> page(Page<Script> page, Script script) {
        return this.scriptDomainService.page(page, script);
    }

    @Override
    public ScriptResultDto execute(ScriptExecuteDto scriptExecuteDto) {
        return this.scriptDomainService.execute(scriptExecuteDto);
    }
}
