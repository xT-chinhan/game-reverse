package com.mar.sdk.rule;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IPluginListener {
    public static final int APP_CLICK = 5;
    public static final int APP_CRASH = 6;
    public static final int APP_END = 3;
    public static final int APP_INSTALL = 1;
    public static final int APP_START = 2;
    public static final int APP_VIEW_SCREEN = 4;

    JSONObject onAutoCollect(int i, JSONObject jSONObject);
}
