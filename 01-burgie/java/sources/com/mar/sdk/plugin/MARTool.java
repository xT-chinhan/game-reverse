package com.mar.sdk.plugin;

import com.mar.sdk.ITool;
import com.mar.sdk.base.PluginFactory;

/* JADX INFO: loaded from: classes2.dex */
public class MARTool {
    private static MARTool instance;
    private ITool toolPlugin;

    private MARTool() {
    }

    public void init() {
        this.toolPlugin = (ITool) PluginFactory.getInstance().initPlugin(14);
    }

    public static MARTool getInstance() {
        if (instance == null) {
            instance = new MARTool();
        }
        return instance;
    }

    public ITool getPlug() {
        return this.toolPlugin;
    }

    public void setPlug(ITool plug) {
        this.toolPlugin = plug;
    }

    public boolean isSupport(String method) {
        if (this.toolPlugin == null) {
            return false;
        }
        return this.toolPlugin.isSupportMethod(method);
    }
}
