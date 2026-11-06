package com.smartdigimkt.r4;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {
    public final /* synthetic */ String a = "fail";
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public t(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "strategy");
            jSONObject.put("result", this.a);
            jSONObject.put("placementId", this.b);
            jSONObject.put("adtype", this.c);
            jSONObject.put(MediationConstant.KEY_ERROR_MSG, this.d);
            String string = jSONObject.toString();
            if (TextUtils.equals("fail", this.a)) {
                w.a(string);
            } else {
                w.a(string);
            }
        } catch (Throwable unused) {
        }
    }
}
