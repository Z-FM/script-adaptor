package com.zfm.scriptadaptor.infra.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class BaseEntityInitHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "creationDate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createdBy", Long.class, 1L);
        this.strictInsertFill(metaObject, "lastUpdateDate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "lastUpdatedBy", Long.class, 1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "lastUpdateDate", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "lastUpdatedBy", Long.class, 1L);
    }
}