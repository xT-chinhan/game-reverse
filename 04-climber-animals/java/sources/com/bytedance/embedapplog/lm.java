package com.bytedance.embedapplog;

import android.content.Context;
import com.umeng.analytics.pro.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class lm extends le {
    private final Context ka;

    lm(Context context) {
        super(true, true);
        this.ka = context;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        jw.ms(jSONObject, bv.Q, jm.ms(this.ka));
        return true;
    }
}
