package com.zfm.scriptadaptor.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfm.scriptadaptor.app.service.ScriptHeaderService;
import com.zfm.scriptadaptor.app.service.ScriptLineService;
import com.zfm.scriptadaptor.domain.entity.Script;
import com.zfm.scriptadaptor.domain.entity.ScriptHeader;
import com.zfm.scriptadaptor.domain.entity.ScriptLine;
import com.zfm.scriptadaptor.domain.service.ScriptDomainService;
import com.zfm.scriptadaptor.domain.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@Service
public class ScriptDomainServiceImpl implements ScriptDomainService {

    @Autowired
    private ScriptHeaderService scriptHeaderService;
    @Autowired
    private ScriptLineService scriptLineService;


    @Override
    public List<Script> scripts() {
        List<ScriptHeader> scriptHeaders = this.scriptHeaderService.list();
        if (CollectionUtils.isEmpty(scriptHeaders)) {
            return new ArrayList<>();
        }
        List<ScriptLine> scriptLines = this.scriptLineService.list();
        Map<Long, List<ScriptLine>> scriptLineMap = scriptLines.stream()
                .sorted(Comparator.comparing(ScriptLine::getScriptLineId))
                .collect(Collectors.groupingBy(ScriptLine::getScriptHeaderId));
        List<Script> scripts = new ArrayList<>();
        scriptHeaders.forEach(scriptHeader -> {
            List<ScriptLine> scriptLineList = scriptLineMap.get(scriptHeader.getScriptHeaderId());
            scripts.add(Script.Builder.newBuilder().setScriptHeader(scriptHeader).setScriptLines(scriptLineList).getScript());
        });
        return scripts;
    }

    @Override
    public IPage<Script> page(Page<Script> page, Script script) {
        Page<Script> result = new Page<>();
        ScriptHeader scriptHeader = script.getScriptHeader();
        if (scriptHeader == null) {
            BeanUtils.copyProperties(page, result);
            return result;
        }
        IPage<ScriptHeader> scriptHeaderIPage = this.scriptHeaderService.page(new Page<>(page.getCurrent(), page.getSize()), new QueryWrapper<ScriptHeader>().lambda().
                eq(StringUtils.isNotEmpty(scriptHeader.getRunningService()), ScriptHeader::getRunningService, scriptHeader.getRunningService()).
                eq(StringUtils.isNotEmpty(scriptHeader.getScriptCode()), ScriptHeader::getScriptCode, scriptHeader.getScriptCode()).
                eq(scriptHeader.getTenantId() != null, ScriptHeader::getTenantId, scriptHeader.getTenantId())
        );
        if (CollectionUtils.isEmpty(scriptHeaderIPage.getRecords())) {
            return result;
        }
        BeanUtils.copyProperties(scriptHeaderIPage, result);
        List<ScriptHeader> scriptHeaders = scriptHeaderIPage.getRecords();
        List<ScriptLine> scriptLines = this.scriptLineService.list(new QueryWrapper<ScriptLine>().lambda()
                .in(ScriptLine::getScriptHeaderId, scriptHeaders.stream().map(ScriptHeader::getScriptHeaderId).collect(Collectors.toList()))
        );
        Map<Long, List<ScriptLine>> lineMap = scriptLines.stream().collect(Collectors.groupingBy(ScriptLine::getScriptHeaderId));
        List<Script> scripts = new ArrayList<>();
        scriptHeaders.forEach(item -> scripts.add(
                Script.Builder.newBuilder().setScriptHeader(item).setScriptLines(lineMap.get(item.getScriptHeaderId()))
                        .getScript()));
        result.setRecords(scripts);
        return result;
    }

}
