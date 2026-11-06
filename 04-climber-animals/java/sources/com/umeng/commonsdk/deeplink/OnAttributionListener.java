package com.umeng.commonsdk.deeplink;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface OnAttributionListener {
    void onAttributionFail(int i);

    void onAttributionSuccess(JSONObject jSONObject);
}
