package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    private long ah;
    private Map<String, Long> d = new HashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3675ms;
    private long xr;

    private w(String str, long j) {
        this.f3675ms = str;
        this.xr = j;
        this.ah = j;
    }

    public static w ms(String str) {
        return new w(str, SystemClock.elapsedRealtime());
    }

    public long ms() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.xr;
        this.d.put(this.f3675ms, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long xr(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.ah;
        this.ah = jElapsedRealtime;
        this.d.put(str, Long.valueOf(j));
        return j;
    }

    public void ms(String str, long j) {
        this.d.put(str, Long.valueOf(j));
    }

    public long xr() {
        return SystemClock.elapsedRealtime() - this.xr;
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

    public JSONObject ms(long j) {
        JSONObject jSONObject = new JSONObject();
        ms(jSONObject, j);
        return jSONObject;
    }
}
