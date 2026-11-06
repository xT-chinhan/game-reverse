package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class yu extends le {
    private final pc c;
    private final Context ka;

    yu(Context context, pc pcVar) {
        super(true, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(this.c.jw())) {
            jSONObject.put("ab_client", this.c.jw());
        }
        if (!TextUtils.isEmpty(this.c.y())) {
            if (oh.xr) {
                oh.ms("init config has abversion:" + this.c.y(), null);
            }
            jSONObject.put("ab_version", this.c.y());
        }
        if (!TextUtils.isEmpty(this.c.f())) {
            jSONObject.put("ab_group", this.c.f());
        }
        if (TextUtils.isEmpty(this.c.ul())) {
            return true;
        }
        jSONObject.put("ab_feature", this.c.ul());
        return true;
    }
}
