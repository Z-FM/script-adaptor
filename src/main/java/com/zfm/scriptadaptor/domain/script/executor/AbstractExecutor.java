package com.zfm.scriptadaptor.domain.script.executor;

import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;

import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description: 执行器，封装执行方法.
 * @Author: feiming.zhang@going-link.com.
 */
public abstract class AbstractExecutor {

    protected static final ScriptActuator scriptActuator = new ScriptActuator();

    /**
     * 脚本扩展.
     *
     * @param scriptFileName  扩展脚本文件名.
     * @param extensionName   扩展变量名，对应脚本文件中调用的Java对象变量名.
     * @param extensionObject 扩展Java对象变量.
     */
    public void extension(String scriptFileName, String extensionName, Object extensionObject) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(scriptFileName));
            String s;
            StringBuffer buffer = new StringBuffer();
            while ((s = bf.readLine()) != null) {
                buffer.append(s.trim());
            }
            scriptActuator.start(buffer.toString());
        } catch (ScriptException | IOException e) {
            throw new RuntimeException(e);
        }
        scriptActuator.bindJavaObject(extensionName, extensionObject);
    }

    public Object execute(String methodName, Object... args) {
        return scriptActuator.invokeFunction(methodName, args);
    }

    public CompiledScript compliled(String scriptContent) throws ScriptException {
        return scriptActuator.compliled(scriptContent);
    }

    public void start(String scriptContent) throws ScriptException, FileNotFoundException {
        scriptActuator.start(scriptContent);
    }

    /**
     * 定义沙盒参数.
     */
    abstract void defineSandbox();

    /**
     * 初始化扩展插件.
     */
    abstract void initPlugs();

    abstract Object executeProcess(Object... args);

    /**
     * @Description: 脚本执行器.
     * @Author: feiming.zhang@going-link.com.
     */
    protected static class ScriptActuator {
        protected final NashornSandbox nashornSandbox = NashornSandboxes.create();

        /**
         * 绑定Java类.
         */
        private void bindJavaObject(String javaObject, Object obj) {
            nashornSandbox.inject(javaObject, obj);
        }

        /**
         * 执行脚本.
         */
        private void start(String scriptContent) throws FileNotFoundException, ScriptException {
            nashornSandbox.eval(scriptContent);
        }

        /**
         * 预编译.
         *
         * @param scriptContent 脚本.
         * @return 编译结果.
         * @throws ScriptException 脚本编译异常.
         */
        private CompiledScript compliled(String scriptContent) throws ScriptException {
            return nashornSandbox.compile(scriptContent);
        }

        /**
         * 动态调用脚本语言执行方法.
         *
         * @param function 方法名称.
         * @param args     参数.
         * @return 执行结果.
         */
        private Object invokeFunction(String function, Object... args) {
            Invocable inv = nashornSandbox.getSandboxedInvocable();
            try {
                return inv.invokeFunction(function, args);
            } catch (ScriptException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
