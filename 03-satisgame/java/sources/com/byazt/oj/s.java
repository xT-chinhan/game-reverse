package com.byazt.oj;

import android.text.TextUtils;
import com.byazt.fvm.w;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1642, 8})
public class s extends w {
    public boolean l;
    public String n;
    public List<w> q;
    public String qg;
    public boolean s;

    public s(String str, String str2) {
        super(null);
        this.n = str;
        this.qg = str2;
    }

    public s() {
        super(null);
    }

    @Override // com.byazt.fvm.w
    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    @Override // com.byazt.fvm.w
    public String qg() {
        return this.qg;
    }

    public void qg(String str) {
        this.qg = str;
    }

    @Override // com.byazt.fvm.w
    public boolean s() {
        return this.s;
    }

    @Override // com.byazt.fvm.w
    public void n(boolean z) {
        this.s = z;
    }

    @Override // com.byazt.fvm.w
    public List<w> q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }

    public void qg(boolean z) {
        this.l = z;
    }

    @Override // com.byazt.fvm.w
    public void n(w wVar) {
        if (wVar == null) {
            return;
        }
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(wVar);
    }

    @Override // com.byazt.fvm.w
    public boolean w() {
        return (TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.qg)) ? false : true;
    }

    @Override // com.byazt.fvm.w
    public boolean x() {
        List<w> list = this.q;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static s n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            s sVar = new s();
            sVar.n(jSONObject.optString("id"));
            sVar.qg(jSONObject.optString(TapEventParamConstants.PARAM_NAME));
            sVar.n(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    s sVarN = n(jSONArrayOptJSONArray.optJSONObject(i));
                    if (sVarN != null && sVarN.w()) {
                        sVar.n(sVarN);
                    }
                }
            }
            return sVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject fs() {
        try {
            if (!w()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", n());
            jSONObject.put(TapEventParamConstants.PARAM_NAME, qg());
            jSONObject.put("is_selected", s());
            jSONObject.put("new_ui", this.l);
            if (x()) {
                JSONArray jSONArray = new JSONArray();
                for (w wVar : q()) {
                    if (wVar instanceof s) {
                        jSONArray.put(((s) wVar).fs());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("options", jSONArray);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
