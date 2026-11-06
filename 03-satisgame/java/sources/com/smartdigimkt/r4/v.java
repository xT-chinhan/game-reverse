package com.smartdigimkt.r4;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.sdk.api.SDMSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {
    public final /* synthetic */ com.smartdigimkt.f3.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public v(com.smartdigimkt.f3.a aVar, String str, String str2, String str3) {
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a == null) {
                jSONObject.put("action", this.b);
                jSONObject.put("result", this.c);
                jSONObject.put("isHB", 1);
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.d);
            } else {
                if (TextUtils.equals(this.b, "click") && this.a.B) {
                    return;
                }
                com.smartdigimkt.f3.a aVar = this.a;
                int i = aVar.P;
                jSONObject.put("placementId", aVar.b);
                String str2 = this.a.d;
                str2.getClass();
                str2.hashCode();
                switch (str2) {
                    case "0":
                        str = "native";
                        break;
                    case "1":
                        str = "reward";
                        break;
                    case "2":
                        str = MediationConstant.RIT_TYPE_BANNER;
                        break;
                    case "3":
                        str = "inter";
                        break;
                    case "4":
                        str = MediationConstant.RIT_TYPE_SPLASH;
                        break;
                    case "50":
                        str = "media_video";
                        break;
                    default:
                        str = LiveConfigKey.NONE;
                        break;
                }
                jSONObject.put("adType", str);
                jSONObject.put("action", this.b);
                jSONObject.put("result", this.c);
                jSONObject.put("adSourceId", this.a.Q);
                jSONObject.put("networkFirmId", i);
                jSONObject.put("networkName", this.a.M);
                jSONObject.put("networkVersion", this.a.L);
                jSONObject.put("networkUnit", this.a.O);
                jSONObject.put("isHB", 1);
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.d);
            }
        } catch (Throwable unused) {
        }
        String string = jSONObject.toString();
        if (SDMSDK.getInstance().isNetworkLogDebug()) {
            w.a(string);
        }
    }
}
