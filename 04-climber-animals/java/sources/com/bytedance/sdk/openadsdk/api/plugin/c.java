package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private long ah;
    private Map<String, Long> d = new HashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1816ms;
    private long xr;

    private c(String str, long j) {
        this.f1816ms = str;
        this.xr = j;
        this.ah = j;
    }

    public static c ms(String str) {
        return new c(str, SystemClock.elapsedRealtime());
    }

    public long ms() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.xr;
        this.d.put(this.f1816ms, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long xr(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.ah;
        this.ah = SystemClock.elapsedRealtime();
        this.d.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void ms(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.d.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
