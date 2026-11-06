package com.byazt.hg;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 505})
public class j {
    public String c;
    public String hn;
    public String hw;
    public String pr;
    public String uc;
    public String x;

    public j(String str, String str2, String str3, String str4) {
        this.pr = str3;
        this.hw = str2;
        this.x = str;
        this.hn = str4;
    }

    public void pr(String str, String str2, String str3, String str4) {
        this.pr = str3;
        this.hw = str2;
        this.x = str;
        this.hn = str4;
    }

    public String pr() {
        return this.hw;
    }

    public String hw() {
        return this.pr;
    }

    public String toString() {
        JSONObject jSONObjectHn = hn();
        return jSONObjectHn.length() > 0 ? jSONObjectHn.toString() : "";
    }

    public JSONObject hn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.pr).put("vd", this.x).put("cr", this.hn).put(NotificationCompat.CATEGORY_ERROR, this.hw);
            if (!TextUtils.isEmpty(this.hn) && this.hn.equals("2")) {
                if (!TextUtils.isEmpty(this.c)) {
                    jSONObject.put("i6", this.c);
                }
                if (!TextUtils.isEmpty(this.uc)) {
                    jSONObject.put("prov", this.uc);
                }
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public void pr(String str) {
        this.c = str;
    }

    public void hw(String str) {
        this.uc = str;
    }
}
