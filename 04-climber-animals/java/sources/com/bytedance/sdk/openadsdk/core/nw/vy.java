package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class vy {
    private String ah;
    private String c;
    private String d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3108ms;
    private String xr;

    public vy(String str, String str2, String str3, String str4) {
        this.f3108ms = str3;
        this.xr = str2;
        this.d = str;
        this.ah = str4;
    }

    public void ms(String str, String str2, String str3, String str4) {
        this.f3108ms = str3;
        this.xr = str2;
        this.d = str;
        this.ah = str4;
    }

    public String ms() {
        return this.xr;
    }

    public String xr() {
        return this.f3108ms;
    }

    public String toString() {
        JSONObject jSONObjectAh = ah();
        return jSONObjectAh.length() > 0 ? jSONObjectAh.toString() : "";
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.f3108ms).put("vd", this.d).put("cr", this.ah).put(NotificationCompat.CATEGORY_ERROR, this.xr);
            if (!TextUtils.isEmpty(this.ah) && this.ah.equals("2")) {
                if (!TextUtils.isEmpty(this.ka)) {
                    jSONObject.put("i6", this.ka);
                }
                if (!TextUtils.isEmpty(this.c)) {
                    jSONObject.put("prov", this.c);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void ms(String str) {
        this.ka = str;
    }

    public void xr(String str) {
        this.c = str;
    }
}
