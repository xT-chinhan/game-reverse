package com.bytedance.sdk.component.ms;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ub {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<String, Object> f1269ms = new ConcurrentHashMap();

    public static ub ms() {
        return new ub();
    }

    private ub() {
    }

    public ub ms(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f1269ms.put(str, obj);
        }
        return this;
    }

    public String xr() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.f1269ms.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
