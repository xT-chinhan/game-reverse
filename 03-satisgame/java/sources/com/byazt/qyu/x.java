package com.byazt.qyu;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, 21})
public class x {
    public String n;
    public Map<String, Long> q = new HashMap();
    public long qg;
    public long s;

    private x(String str, long j) {
        this.n = str;
        this.qg = j;
        this.s = j;
    }

    public static x n(String str) {
        return new x(str, SystemClock.elapsedRealtime());
    }

    public long n() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.qg;
        this.q.put(this.n, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long qg(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.s;
        this.s = SystemClock.elapsedRealtime();
        this.q.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void n(JSONObject jSONObject) {
        n(jSONObject, 0L);
    }

    public void n(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.q.entrySet()) {
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
