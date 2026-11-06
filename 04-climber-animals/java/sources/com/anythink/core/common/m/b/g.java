package com.anythink.core.common.m.b;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final String a = "placement_strategy";
    public static final String b = "app_strategy";
    public static final String c = "eu_traffic";
    public static final String d = "get_area";
    public static final String e = "get_plugin";
    public static final String f = "get_cdn_domain";
    public static final String g = "tracking";
    public static final String h = "agent";
    public static final String i = "bid";
    public static final String j = "request";
    public static final String k = "smart_wf";
    public static final String l = "s2s_reward";

    public static int a(String str) {
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
