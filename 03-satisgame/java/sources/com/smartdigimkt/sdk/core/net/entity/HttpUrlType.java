package com.smartdigimkt.sdk.core.net.entity;

/* JADX INFO: loaded from: classes3.dex */
public class HttpUrlType {
    public static final String AGENT = "agent";
    public static final String APP_STRATEGY = "app_strategy";
    public static final String BID = "bid";
    public static final String GET_PLUGIN = "get_plugin";
    public static final String PLACEMENT_STRATEGY = "placement_strategy";
    public static final String REQUEST = "request";
    public static final String S2S_REWARD = "s2s_reward";
    public static final String SMART_WF = "smart_wf";
    public static final String TRACKING = "tracking";

    public static int map2int(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "s2s_reward":
                return 4;
            case "bid":
                return 3;
            case "placement_strategy":
                return 2;
            case "request":
                return 5;
            case "app_strategy":
                return 1;
            default:
                return 0;
        }
    }
}
