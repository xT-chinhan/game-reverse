package com.bytedance.sdk.openadsdk.core.nw;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public int ah;
    public long ch;
    public int d;
    public long hi;
    public long ny;
    public Bundle ub;
    public String xr;
    private String ao = com.bytedance.sdk.openadsdk.core.jw.f.ny();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f3048ms = -1;
    public JSONArray ka = null;
    public int c = 1;
    public long ab = System.currentTimeMillis();
    public long x = System.currentTimeMillis();
    public JSONObject sl = null;
    public int zb = -1;
    public com.bytedance.sdk.openadsdk.core.w u = com.bytedance.sdk.openadsdk.core.w.ms("");

    public e ms() {
        e eVar = new e();
        eVar.f3048ms = this.f3048ms;
        eVar.ka = this.ka;
        eVar.c = this.c;
        eVar.ab = this.ab;
        eVar.ny = this.ny;
        eVar.ch = this.ch;
        eVar.hi = this.hi;
        eVar.zb = this.zb;
        return eVar;
    }

    public void ms(String str) {
        this.ao = str;
    }

    public String xr() {
        return this.ao;
    }

    public void ms(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.w wVar;
        if (!z || (wVar = this.u) == null || str == null) {
            return;
        }
        wVar.xr("cst_".concat(String.valueOf(str)));
    }

    public void ms(String str, long j, boolean z) {
        com.bytedance.sdk.openadsdk.core.w wVar;
        if (!z || (wVar = this.u) == null || str == null) {
            return;
        }
        wVar.ms("cst_".concat(String.valueOf(str)), j);
    }
}
