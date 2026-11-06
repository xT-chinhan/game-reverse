package com.byazt.ko;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 110})
public final class sz extends s {
    public final Context l;
    public final fs w;

    public sz(Context context, fs fsVar) {
        super(true, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException, SecurityException {
        Map<String, String> mapN = com.byazt.yb.x.n(this.l, this.w.l());
        if (mapN == null) {
            return !com.byazt.wv.n.qg;
        }
        jSONObject.put("oaid", new JSONObject(mapN));
        return true;
    }
}
