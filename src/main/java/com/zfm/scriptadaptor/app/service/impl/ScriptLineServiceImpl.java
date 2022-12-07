package com.zfm.scriptadaptor.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfm.scriptadaptor.domain.entity.ScriptLine;
import com.zfm.scriptadaptor.app.service.ScriptLineService;
import com.zfm.scriptadaptor.infra.mapper.ScripLineMapper;
import org.springframework.stereotype.Service;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
@Service
public class ScriptLineServiceImpl extends ServiceImpl<ScripLineMapper, ScriptLine> implements ScriptLineService {
}
