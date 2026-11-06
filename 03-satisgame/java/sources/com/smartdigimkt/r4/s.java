package com.smartdigimkt.r4;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.smartdigimkt.p4.g d;

    public s(String str, String str2, String str3, com.smartdigimkt.p4.g gVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "bidding");
            jSONObject.put("result", this.a);
            jSONObject.put("placementId", this.b);
            jSONObject.put("adtype", this.c);
            jSONObject.put("adsourceId", this.d.r);
            jSONObject.put("networkFirmId", this.d.b);
            jSONObject.put(com.anythink.core.common.k.D, this.d.d);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.d.p);
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
