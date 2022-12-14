package com.zfm.scriptadaptor.domain.script.executor;

import com.zfm.scriptadaptor.domain.utils.StringUtils;

/**
 * @Description: .
 * @Author: feiming.zhang@going-link.com.
 */
public class ScriptExecutorManager {

    public static AbstractExecutor getExecutorInstance(String scriptType) {
        //todo 应该判断类型，返回不同的执行器
        if (StringUtils.equals(scriptType, "PROCESS")) {
            BuriedPointExecutor buriedPointExecutor = new BuriedPointExecutor();
            buriedPointExecutor.defineSandbox();
            buriedPointExecutor.initPlugs();
            return buriedPointExecutor;
        }
        return null;
    }

}
