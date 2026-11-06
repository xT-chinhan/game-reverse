package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class g extends le {
    private final pc ka;

    g(Context context, pc pcVar) {
        super(true, false);
        this.ka = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        String strMs = vf.ms(this.ka.d());
        if (TextUtils.isEmpty(strMs)) {
            return false;
        }
        jSONObject.put("cdid", strMs);
        return true;
    }
}
