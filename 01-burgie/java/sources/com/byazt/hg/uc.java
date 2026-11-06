package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 5})
public class uc {
    public JSONArray aj;
    public String c;
    public String fw;
    public HashMap<String, String> g = new HashMap<>();
    public String hn;
    public String hw;
    public float k;
    public JSONArray m;
    public String pr;
    public String uc;
    public String vk;
    public String w;
    public String x;
    public String zo;

    public uc() {
    }

    public uc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        x(jSONObject.optString("developer_name"));
        hw(jSONObject.optString("app_version"));
        hw(jSONObject.optJSONArray("permissions"));
        c(jSONObject.optString("privacy_policy_url"));
        aj(jSONObject.optString("package_name"));
        vk(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        pr((float) jSONObject.optDouble("score", 0.0d));
        pr(jSONObject.optJSONArray("creative_tags"));
        pr(jSONObject.optString("permissions_url"));
        uc(jSONObject.optString("desc_url"));
        fw(jSONObject.optString("reg_number"));
        zo(jSONObject.optString("reg_url"));
    }

    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, str2);
    }

    public HashMap<String, String> pr() {
        return this.g;
    }

    public String hw() {
        return this.c;
    }

    public void pr(String str) {
        this.c = str;
    }

    public float hn() {
        return this.k;
    }

    public void pr(float f) {
        this.k = f;
    }

    public JSONArray x() {
        return this.m;
    }

    public void pr(JSONArray jSONArray) {
        this.m = jSONArray;
    }

    public String c() {
        return this.pr;
    }

    public void hw(String str) {
        this.pr = str;
    }

    public String uc() {
        return this.hw;
    }

    public void hn(String str) {
        this.hw = str;
    }

    public String fw() {
        return this.hn;
    }

    public void x(String str) {
        this.hn = str;
    }

    public String zo() {
        return this.x;
    }

    public void c(String str) {
        this.x = str;
    }

    public String aj() {
        return this.uc;
    }

    public void uc(String str) {
        this.uc = str;
    }

    public String vk() {
        return this.fw;
    }

    public void fw(String str) {
        this.fw = str;
    }

    public String w() {
        return this.zo;
    }

    public void zo(String str) {
        this.zo = str;
    }

    public JSONArray k() {
        return this.aj;
    }

    public void hw(JSONArray jSONArray) {
        this.aj = jSONArray;
    }

    public String m() {
        return this.vk;
    }

    public void aj(String str) {
        this.vk = str;
    }

    public String g() {
        return this.w;
    }

    public void vk(String str) {
        this.w = str;
    }
}
