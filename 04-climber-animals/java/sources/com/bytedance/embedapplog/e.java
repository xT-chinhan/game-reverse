package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class e extends le {
    private final pc c;
    private final Context ka;

    e(Context context, pc pcVar) {
        super(true, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) {
        Map<String, String> mapMs = vf.ms(this.ka, this.c.d());
        if (mapMs == null) {
            return !ms.xr;
        }
        jSONObject.put("oaid", new JSONObject(mapMs));
        return true;
    }
}
