package com.zfm.scriptadaptor.domain.script.plugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 数据库执行插件.
 * @Author: Z-FM.
 * @Date: 2022/12/16.
 */
public class DatabasePlug {

    private static final Logger logger = LoggerFactory.getLogger(DatabasePlug.class);

    public Object selectById(String tableName, String id) {
        logger.info("selectById,tableName:{},id:{}", tableName, id);
        return "{\"id\":" + id + ",\"tableName\":" + tableName + "}";
    }

}
