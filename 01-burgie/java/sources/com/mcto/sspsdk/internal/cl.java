package com.mcto.sspsdk.internal;

import com.byazt.fi.BaseConstants;
import com.mar.sdk.IAction;
import com.umeng.analytics.AnalyticsConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class cl {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public int e;
    public final String f;
    public String g;

    public cl(int i, JSONObject jSONObject) {
        this.a = i;
        this.b = jSONObject.optInt(IAction.PurchaseKey.Price, 0);
        this.c = jSONObject.optInt("adnType", 0);
        this.d = jSONObject.optInt(AnalyticsConfig.RTD_PERIOD, BaseConstants.Time.HOUR);
        this.f = jSONObject.optString("codeId");
    }
}
