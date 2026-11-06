package com.byazt.pw;

import android.text.TextUtils;
import com.byazt.sd.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 420, 121})
public class x {
    public String hn;
    public String hw;
    public boolean pr;
    public com.byazt.dw.hn x;

    public static x pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public static x pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        x xVar = new x();
        xVar.pr = jSONObject.optBoolean("enable");
        xVar.hw = jSONObject.optString("upload_api");
        xVar.hn = jSONObject.optString("alert_text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter_word");
        if (jSONObjectOptJSONObject != null) {
            com.byazt.dw.hn hnVarPr = com.byazt.dw.hn.pr(jSONObjectOptJSONObject);
            if (hnVarPr != null) {
                if (TextUtils.isEmpty(hnVarPr.pr())) {
                    hnVarPr.pr("99:1");
                }
                if (TextUtils.isEmpty(hnVarPr.hw())) {
                    hnVarPr.hw("素材反馈");
                }
                hnVarPr.hw(false);
            }
            xVar.x = hnVarPr;
        }
        return xVar;
    }

    public static com.byazt.dw.hn pr() {
        x xVarSx = a.hw().sx();
        if (xVarSx == null || TextUtils.isEmpty(xVarSx.hw)) {
            return null;
        }
        if (a.hw().gp()) {
            com.byazt.dw.hn hnVar = new com.byazt.dw.hn();
            hnVar.pr("99:1");
            hnVar.hw(true);
            hnVar.hw("其他问题");
            return hnVar;
        }
        return xVarSx.c();
    }

    public boolean hw() {
        return this.pr;
    }

    public String hn() {
        return this.hw;
    }

    public String x() {
        return this.hn;
    }

    public com.byazt.dw.hn c() {
        return this.x;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.pr));
            jSONObject.putOpt("upload_api", this.hw);
            jSONObject.putOpt("alert_text", this.hn);
            com.byazt.dw.hn hnVar = this.x;
            if (hnVar != null) {
                jSONObject.putOpt("filter_word", hnVar.zo());
            }
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
