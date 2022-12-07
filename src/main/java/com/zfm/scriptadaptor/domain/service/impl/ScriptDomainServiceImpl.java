package com.zfm.scriptadaptor.domain.service.impl;

import com.zfm.scriptadaptor.app.service.ScriptHeaderService;
import com.zfm.scriptadaptor.app.service.ScriptLineService;
import com.zfm.scriptadaptor.domain.entity.Script;
import com.zfm.scriptadaptor.domain.entity.ScriptHeader;
import com.zfm.scriptadaptor.domain.entity.ScriptLine;
import com.zfm.scriptadaptor.domain.service.ScriptDomainService;
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
        Map<Integer, List<ScriptLine>> scriptLineMap = scriptLines.stream()
                .sorted(Comparator.comparing(ScriptLine::getScriptLineId))
                .collect(Collectors.groupingBy(ScriptLine::getScriptHeaderId));
        List<Script> scripts = new ArrayList<>();
        scriptHeaders.forEach(scriptHeader -> {
            List<ScriptLine> scriptLineList = scriptLineMap.get(scriptHeader.getScriptHeaderId());
            scripts.add(Script.Builder.newBuilder().setScriptHeader(scriptHeader).setScriptLines(scriptLineList).getScript());
        });
        return scripts;
    }
}
