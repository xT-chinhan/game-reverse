package com.byazt.nz;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 684, 13})
public class hw {
    public int hn;
    public int hw;
    public int pr;
    public boolean x;

    public int pr() {
        return this.pr;
    }

    public void pr(int i) {
        this.pr = i;
    }

    public int hw() {
        return this.hw;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public int hn() {
        return this.hn;
    }

    public void hn(int i) {
        this.hn = i;
    }

    public static hw pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public static hw pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hw hwVar = new hw();
        hwVar.hw(jSONObject.optInt("expire_days"));
        hwVar.pr(jSONObject.optInt("log_level"));
        hwVar.hn(jSONObject.optInt("max_size"));
        hwVar.pr(jSONObject.optBoolean("is_open"));
        return hwVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", hw());
            jSONObject.put("log_level", pr());
            jSONObject.put("max_size", hn());
            jSONObject.put("is_open", x());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public boolean x() {
        return this.x;
    }

    public void pr(boolean z) {
        this.x = z;
    }
}
