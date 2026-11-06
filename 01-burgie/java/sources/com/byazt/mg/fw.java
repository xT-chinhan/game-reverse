package com.byazt.mg;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 62})
public class fw {
    public long hn;
    public long hw;
    public String pr;
    public Map<String, Long> x = new HashMap();

    private fw(String str, long j) {
        this.pr = str;
        this.hw = j;
        this.hn = j;
    }

    public static fw pr(String str) {
        return new fw(str, SystemClock.elapsedRealtime());
    }

    public long pr() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.hw;
        this.x.put(this.pr, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long hw(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.hn;
        this.hn = SystemClock.elapsedRealtime();
        this.x.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void pr(JSONObject jSONObject) {
        pr(jSONObject, 0L);
    }

    public void pr(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.x.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException e) {
                }
            }
        }
    }
}
