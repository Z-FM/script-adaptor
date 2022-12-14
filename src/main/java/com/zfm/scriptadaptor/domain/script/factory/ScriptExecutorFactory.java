package com.zfm.scriptadaptor.domain.script.factory;

import com.zfm.scriptadaptor.domain.script.executor.AbstractExecutor;
import com.zfm.scriptadaptor.domain.script.executor.ScriptExecutorManager;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 脚本工厂.
 * @Author: feiming.zhang@going-link.com.
 */
@Component
public class ScriptExecutorFactory {

    private final ConcurrentHashMap<String, AbstractExecutor> executorMap = new ConcurrentHashMap<>();

    public AbstractExecutor getScriptExecutor(String scriptCode, String scriptType) {
        AbstractExecutor executor = executorMap.get(scriptCode);
        if (executor == null) {
            AbstractExecutor executorInstance = ScriptExecutorManager.getExecutorInstance(scriptType);
            executorMap.put(scriptCode, executorInstance);
            return executorInstance;
        }
        return executorMap.get(scriptCode);
    }

}
