package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class m extends le {
    private final pc c;
    private final Context ka;

    m(Context context, pc pcVar) {
        super(true, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        String strMs = ms.sl() != null ? ms.sl().g().ms() : "";
        if (TextUtils.isEmpty(strMs)) {
            return true;
        }
        jSONObject.put(bv.A, strMs);
        return true;
    }
}
