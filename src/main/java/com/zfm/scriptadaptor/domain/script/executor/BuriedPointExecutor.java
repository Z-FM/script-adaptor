package com.zfm.scriptadaptor.domain.script.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

/**
 * @Description: 埋点脚本执行器.
 * @Author: Z-FM.
 */
public class BuriedPointExecutor extends AbstractExecutor {

    private static final String FUNCTION_NAME = "process";

    private static final Logger log = LoggerFactory.getLogger(BuriedPointExecutor.class);

    @Override
    void defineSandbox() {
        // 设置脚本执行允许的最大CPU时间（以毫秒为单位），超过则会报异常,防止死循环脚本
        scriptActuator.nashornSandbox.setMaxCPUTime(100);
        //设置JS执行程序线程可以分配的最大内存（以字节为单位），超过会报ScriptMemoryAbuseException错误
        scriptActuator.nashornSandbox.setMaxMemory(10 * 1024 * 1024);
        // 是否允许使用大括号
        scriptActuator.nashornSandbox.allowNoBraces(false);
        // 是否允许nashorn加载全局函数
        scriptActuator.nashornSandbox.allowLoadFunctions(true);
        // because preparing scripts for execution is expensive // LRU初缓存的初始化大小，默认为0
        scriptActuator.nashornSandbox.setMaxPreparedStatements(30);
        // 指定执行程序服务，该服务用于在CPU时间运行脚本
        scriptActuator.nashornSandbox.setExecutor(Executors.newSingleThreadExecutor());
    }

    @Override
    void initPlugs() {
        extension("src/main/resources/script/plugs/commonPlug.js", "common_log", log);
    }

    public Object executeProcess(Object... args) {
        return super.execute(FUNCTION_NAME, args);
    }

}
