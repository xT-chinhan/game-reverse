package com.byazt.vyf;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 13})
public class w {
    public String n;
    public Map<String, Long> q = new HashMap();
    public long qg;
    public long s;

    private w(String str, long j) {
        this.n = str;
        this.qg = j;
        this.s = j;
    }

    public static w n(String str) {
        return new w(str, SystemClock.elapsedRealtime());
    }

    public long n() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.qg;
        this.q.put(this.n, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long qg(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.s;
        this.s = jElapsedRealtime;
        this.q.put(str, Long.valueOf(j));
        return j;
    }

    public void n(String str, long j) {
        this.q.put(str, Long.valueOf(j));
    }

    public long qg() {
        return SystemClock.elapsedRealtime() - this.qg;
    }

    public void n(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.q.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value.longValue() > j || key.equals("armor_load_cost"))) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public JSONObject n(long j) {
        JSONObject jSONObject = new JSONObject();
        n(jSONObject, j);
        return jSONObject;
    }
}
