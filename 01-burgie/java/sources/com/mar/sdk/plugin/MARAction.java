package com.mar.sdk.plugin;

import com.mar.sdk.IAction;
import com.mar.sdk.SDKParams;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARAction {
    private static MARAction instance;
    private List<IAction> actionPlugins = new ArrayList();

    public static MARAction getInstance() {
        if (instance == null) {
            instance = new MARAction();
        }
        return instance;
    }

    private MARAction() {
    }

    public void init() {
        try {
            Map<String, Object> plugins = PluginFactory.getInstance().initPlugins(8);
            if (plugins != null && plugins.size() != 0) {
                for (String key : plugins.keySet()) {
                    Object plugin = plugins.get(key);
                    if (plugin instanceof IAction) {
                        this.actionPlugins.add((IAction) plugin);
                        Log.d("MARSDK", "init ad action plugin . add a new plugin:" + key);
                    } else {
                        Log.w("MARSDK", "init ad action plugin failed. an invalid plugin type for plugin:" + key);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void register(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("register")) {
                action.register(params);
            }
        }
    }

    public void login(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("login")) {
                action.login(params);
            }
        }
    }

    public void buy(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("buy")) {
                action.buy(params);
            }
        }
    }

    public void purchase(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("purchase")) {
                action.purchase(params);
            }
        }
    }

    public void createRole(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("createRole")) {
                action.createRole(params);
            }
        }
    }

    public void enterGame(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("enterGame")) {
                action.enterGame(params);
            }
        }
    }

    public void levelUp(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("levelUp")) {
                action.levelUp(params);
            }
        }
    }

    public void task(SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("task")) {
                action.task(params);
            }
        }
    }

    public void customEvent(String name, SDKParams params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("customEvent")) {
                action.customEvent(name, params);
            }
        }
    }

    public void reportEvent(String name, JSONObject json) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("reportEvent")) {
                action.reportEvent(name, json);
            }
        }
    }

    public void setUserProperty(String params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("setUserProperty")) {
                action.setUserProperty(params);
            }
        }
    }

    public void setUserSetOnce(String params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("setUserSetOnce")) {
                action.setUserSetOnce(params);
            }
        }
    }

    public void setTrackUserAdd(String params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("setTrackUserAdd")) {
                action.setTrackUserAdd(params);
            }
        }
    }

    public void setSuperProperties(String params) {
        for (IAction action : this.actionPlugins) {
            if (action.isSupportMethod("setSuperProperties")) {
                action.setSuperProperties(params);
            }
        }
    }
}
