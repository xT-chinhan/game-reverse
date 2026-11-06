package com.byazt.ko;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 113})
public class d extends s {
    public final Context l;
    public final fs w;

    public d(Context context, fs fsVar) {
        super(true, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        String strQg = com.byazt.km.n.qg();
        if (TextUtils.isEmpty(strQg)) {
            return true;
        }
        jSONObject.put("mc", strQg);
        return true;
    }
}
