package com.zfm.scriptadaptor.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.api.dto.ScriptExecuteDto;
import com.zfm.scriptadaptor.api.dto.ScriptResultDto;
import com.zfm.scriptadaptor.domain.entity.Script;

import java.util.List;

/**
 * @Description: .
 * @Author: Z-FM.
 */
public interface ScriptDomainService {

    List<Script> scripts();

    IPage<Script> page(Page<Script> page, Script script);

    ScriptResultDto execute(ScriptExecuteDto scriptExecuteDto);

}
