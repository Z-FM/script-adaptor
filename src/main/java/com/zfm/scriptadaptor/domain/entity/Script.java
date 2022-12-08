package com.zfm.scriptadaptor.domain.entity;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 脚本领域模型.
 * @Author: feiming.zhang@going-link.com.
 */
@Data
public class Script implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long tenantId;
    private ScriptHeader scriptHeader;
    private ScriptLine scriptLine;
    private List<ScriptLine> scriptLines;

    public static final class Builder {
        private Script result;

        private Builder(Script script) {
            this.result = script;
        }

        public static Builder newBuilder() {
            return new Builder(new Script());
        }

        public Builder setScriptHeader(ScriptHeader scriptHeader) {
            this.result.scriptHeader = scriptHeader;
            return this;
        }

        public Script getScript() {
            return this.result;
        }

        public Builder setScriptLine(ScriptLine scriptLine) {
            this.result.scriptLine = scriptLine;
            if (CollectionUtils.isEmpty(this.result.scriptLines)) {
                this.result.scriptLines = new ArrayList<>();
            }
            this.result.scriptLines.add(scriptLine);
            return this;
        }

        public Builder setScriptLines(List<ScriptLine> scriptLines) {
            if (CollectionUtils.isEmpty(this.result.scriptLines)) {
                this.result.scriptLines = scriptLines;
            } else {
                scriptLines.addAll(this.result.scriptLines);
            }
            this.result.scriptLines = this.result.scriptLines.stream().distinct().collect(Collectors.toList());
            return this;
        }

    }

}
