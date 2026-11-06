package com.byazt.ko;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 19})
public class n extends s {
    public final Context l;
    public final fs w;

    public n(Context context, fs fsVar) {
        super(true, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException, SecurityException {
        if (!TextUtils.isEmpty(this.w.an())) {
            jSONObject.put("ab_client", this.w.an());
        }
        if (!TextUtils.isEmpty(this.w.um())) {
            if (com.byazt.km.cp.qg) {
                com.byazt.km.cp.n("init config has abversion:" + this.w.um(), null);
            }
            jSONObject.put("ab_version", this.w.um());
        }
        if (!TextUtils.isEmpty(this.w.ae())) {
            jSONObject.put("ab_group", this.w.ae());
        }
        if (TextUtils.isEmpty(this.w.f())) {
            return true;
        }
        jSONObject.put("ab_feature", this.w.f());
        return true;
    }
}
