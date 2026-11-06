package com.mar.sdk.manager;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MARPluginLinkManager {
    private static MARPluginLinkManager instance;
    private List<IPluginLink> pluginLinkList = new ArrayList();

    public interface IPluginLink {
        String link(String str, String str2);
    }

    public static MARPluginLinkManager getInstance() {
        if (instance == null) {
            instance = new MARPluginLinkManager();
        }
        return instance;
    }

    public void addPluginLink(IPluginLink pluginLink) {
        if (!this.pluginLinkList.contains(pluginLink)) {
            this.pluginLinkList.add(pluginLink);
        }
    }

    public String linkPlugin(String name, String params) {
        String callstr = null;
        for (IPluginLink pluginLink : this.pluginLinkList) {
            callstr = pluginLink.link(name, params);
        }
        return callstr;
    }
}
