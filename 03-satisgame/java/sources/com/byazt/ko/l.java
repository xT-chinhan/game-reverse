package com.byazt.ko;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 18})
public final class l extends s {
    public final fs l;

    public l(Context context, fs fsVar) {
        super(true, false);
        this.l = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException, SecurityException {
        String strN = com.byazt.yb.x.n(this.l.l());
        if (TextUtils.isEmpty(strN)) {
            return false;
        }
        jSONObject.put("cdid", strN);
        return true;
    }
}
