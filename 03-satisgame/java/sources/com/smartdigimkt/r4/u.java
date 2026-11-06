package com.smartdigimkt.r4;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.sdk.core.SDKContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public u(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("placementId", this.a);
            jSONObject.put("adtype", this.b);
            jSONObject.put("api", this.c);
            jSONObject.put("result", this.d);
            jSONObject.put(MediationConstant.KEY_REASON, this.e);
            SDKContext.getInstance().i();
            jSONObject.toString();
        } catch (Throwable unused) {
        }
    }
}
