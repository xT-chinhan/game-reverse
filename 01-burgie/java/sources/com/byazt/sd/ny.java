package com.byazt.sd;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 36})
public class ny {
    public long hn;
    public long hw;
    public String pr;
    public Map<String, Long> x = new HashMap();

    private ny(String str, long j) {
        this.pr = str;
        this.hw = j;
        this.hn = j;
    }

    public static ny pr(String str) {
        return new ny(str, SystemClock.elapsedRealtime());
    }

    public long pr() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.hw;
        this.x.put(this.pr, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long hw(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.hn;
        this.hn = jElapsedRealtime;
        this.x.put(str, Long.valueOf(j));
        return j;
    }

    public void pr(String str, long j) {
        this.x.put(str, Long.valueOf(j));
    }

    public long hw() {
        return SystemClock.elapsedRealtime() - this.hw;
    }

    public void pr(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.x.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value.longValue() > j || key.equals("armor_load_cost"))) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException e) {
                }
            }
        }
    }

    public JSONObject pr(long j) {
        JSONObject jSONObject = new JSONObject();
        pr(jSONObject, j);
        return jSONObject;
    }
}
