package com.zfm.scriptadaptor.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfm.scriptadaptor.domain.entity.ScriptHeader;
import com.zfm.scriptadaptor.app.service.ScriptHeaderService;
import com.zfm.scriptadaptor.infra.mapper.ScriptHeaderMapper;
import org.springframework.stereotype.Service;

/**
 * @Description: .
 * @Author: Z-FM.
 */
@Service
public class ScriptHeaderServiceImpl extends ServiceImpl<ScriptHeaderMapper, ScriptHeader> implements ScriptHeaderService {
}
