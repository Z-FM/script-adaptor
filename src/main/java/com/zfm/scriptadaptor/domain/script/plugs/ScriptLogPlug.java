package com.zfm.scriptadaptor.domain.script.plugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 脚本日志打印功能.
 * @Author: feiming.zhang@going-link.com.
 */
public class ScriptLogPlug {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScriptLogPlug.class);

    public void inof(String log) {
        LOGGER.info(log);
    }

    public void inof(String log, Object... params) {
        LOGGER.info(log, params);
    }

    public void debug(String log) {
        LOGGER.debug(log);
    }

    public void debug(String log, Object... params) {
        LOGGER.debug(log, params);
    }

    public void warn(String log) {
        LOGGER.warn(log);
    }

    public void warn(String log, Object... params) {
        LOGGER.warn(log, params);
    }

    public void error(String log) {
        LOGGER.error(log);
    }

    public void error(String log, Object... params) {
        LOGGER.error(log, params);
    }

}
