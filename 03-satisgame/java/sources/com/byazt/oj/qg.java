package com.byazt.oj;

import android.text.TextUtils;
import com.byazt.fvm.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1642, 26})
public class qg {
    public boolean fs;
    public final String l;
    public final int n;
    public final boolean q;
    public final List<w> qg = new ArrayList();
    public String s;
    public final String w;
    public String x;

    /* JADX WARN: Code duplicated, block: B:21:0x0064  */
    public qg(JSONObject jSONObject, s sVar) {
        boolean z = false;
        this.n = jSONObject.optInt("dislike_control", 0);
        this.q = jSONObject.optBoolean("close_on_dislike", false);
        String strN = sVar != null ? sVar.n() : "";
        this.fs = sVar != null ? sVar.l() : false;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                s sVarN = s.n(jSONArrayOptJSONArray.optJSONObject(i));
                sVarN.qg(this.fs);
                if (this.fs && sVarN != null) {
                    String strN2 = sVarN.n();
                    if (!"8:1".equals(strN2) && !"99:1".equals(strN2)) {
                        if (sVarN == null) {
                        }
                    }
                } else if (sVarN == null && sVarN.w()) {
                    this.qg.add(sVarN);
                    if (!zEquals) {
                        zEquals = TextUtils.equals(sVarN.n(), strN);
                    }
                }
            }
            z = zEquals;
        }
        if (sVar != null && !z) {
            this.qg.add(sVar);
        }
        this.l = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.w = jSONObject.optString("ext");
    }

    public void n(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.n);
        jSONObject.put("filter_words", x());
        jSONObject.put("close_on_dislike", rv());
    }

    public List<w> n() {
        return this.qg;
    }

    public boolean qg() {
        return this.fs;
    }

    public void n(String str) {
        this.s = str;
    }

    public String s() {
        return this.s;
    }

    public String q() {
        return this.l;
    }

    public String l() {
        return this.w;
    }

    public boolean w() {
        return this.n == 1;
    }

    public JSONArray x() {
        JSONObject jSONObjectFs;
        JSONArray jSONArray = new JSONArray();
        List<w> list = this.qg;
        if (list != null) {
            for (w wVar : list) {
                if ((wVar instanceof s) && (jSONObjectFs = ((s) wVar).fs()) != null) {
                    jSONArray.put(jSONObjectFs);
                }
            }
        }
        return jSONArray;
    }

    public void qg(String str) {
        this.x = str;
    }

    public String fs() {
        return this.x;
    }

    public boolean rv() {
        return this.q;
    }
}
