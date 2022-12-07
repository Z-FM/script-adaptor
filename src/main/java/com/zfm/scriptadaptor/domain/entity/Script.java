package com.zfm.scriptadaptor.domain.entity;

import lombok.Data;

/**
 * @Description: 脚本领域模型.
 * @Author: feiming.zhang@going-link.com.
 */
@Data
public class Script {

    private ScriptHeader scriptHeader;
    private ScriptLine scriptLine;

    public static class Builder {
        Script builder() {
            return new Script();
        }
    }

}
