package com.mar.sdk.plugin;

import com.mar.sdk.base.PluginFactory;

/* JADX INFO: loaded from: classes2.dex */
public class MARCommonPlugin {
    private static MARCommonPlugin instance;

    public static MARCommonPlugin getInstance() {
        if (instance == null) {
            instance = new MARCommonPlugin();
        }
        return instance;
    }

    private MARCommonPlugin() {
    }

    public void init() {
        try {
            PluginFactory.getInstance().initPlugins(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
