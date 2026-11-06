package com.smartdigimkt.o4;

import com.smartdigimkt.r4.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;
    public final /* synthetic */ u c;

    public t(u uVar, JSONObject jSONObject, String str) {
        this.c = uVar;
        this.a = jSONObject;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject jSONObject = this.a;
        y.a(this.c.a, "sdm_adx_rp_sdk", this.b + "_PL_SY", jSONObject == null ? "" : jSONObject.toString());
    }
}
