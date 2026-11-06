package com.smartdigimkt.f0;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final HashMap a = new HashMap();

    public final void a(JSONArray jSONArray) {
        this.a.clear();
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString("macro");
                    if (!TextUtils.isEmpty(strOptString)) {
                        f fVar = new f();
                        fVar.a = strOptString;
                        fVar.b = jSONObject.optInt("action", 1);
                        fVar.c = jSONObject.optString(com.anythink.core.common.f.e.a.d, "");
                        this.a.put(strOptString, fVar);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
