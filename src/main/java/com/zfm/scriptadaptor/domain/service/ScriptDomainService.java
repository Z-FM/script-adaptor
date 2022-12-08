package com.zfm.scriptadaptor.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.domain.entity.Script;

import java.util.List;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
public interface ScriptDomainService {

    List<Script> scripts();

    IPage<Script> page(Page<Script> page, Script script);

}
