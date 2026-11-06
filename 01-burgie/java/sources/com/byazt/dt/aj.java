package com.byazt.dt;

import android.text.TextUtils;
import com.byazt.sd.a;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1167, 61})
public class aj {
    public static volatile aj pr = null;
    public boolean hw;
    public boolean uc;
    public int x;
    public final Set<String> hn = new CopyOnWriteArraySet();
    public final Map<String, Long> c = new ConcurrentHashMap();

    private aj() {
    }

    public static aj pr() {
        if (pr == null) {
            synchronized (aj.class) {
                if (pr == null) {
                    pr = new aj();
                }
            }
        }
        return pr;
    }

    private void hn() {
        if (!this.uc) {
            this.uc = true;
            a.hw().yb();
        }
    }

    public void pr(String str, int i, int i2, String str2) {
        String str3;
        if (!hw() || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        String strValueOf = String.valueOf(i);
        if (i2 == 0) {
            str3 = strValueOf;
        } else {
            str3 = (strValueOf + "_") + String.valueOf(i2);
        }
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(str2, "req_exemption_error_code");
        if (this.hn.contains(strValueOf) || this.hn.contains(str3)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            hnVarPr.pr(str, jCurrentTimeMillis);
            this.c.put(str, Long.valueOf(jCurrentTimeMillis));
        }
    }

    public void pr(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        pr(jSONObject);
    }

    public void pr(JSONObject jSONObject) {
        this.hn.clear();
        if (jSONObject != null) {
            this.hw = jSONObject.optBoolean("enable", false);
            int iOptInt = jSONObject.optInt("duration", 0) * 1000;
            this.x = iOptInt;
            if (iOptInt <= 0) {
                this.hw = false;
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("error_codes");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.hn.add(strOptString);
                    }
                }
            }
            if (this.hn.isEmpty()) {
                this.hw = false;
                return;
            }
            return;
        }
        this.hw = false;
    }

    public hn pr(String str, String str2) {
        hn hnVar = new hn();
        if (!hw() || TextUtils.isEmpty(str)) {
            return hnVar;
        }
        Long lValueOf = this.c.get(str);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(com.byazt.qn.x.pr(str2, "req_exemption_error_code").getLong(str, -1L));
            if (lValueOf.longValue() != -1) {
                this.c.put(str, lValueOf);
            } else {
                lValueOf = null;
            }
        }
        if (lValueOf == null) {
            hnVar.pr(true);
            return hnVar;
        }
        if (System.currentTimeMillis() - lValueOf.longValue() > this.x) {
            this.c.remove(str);
            com.byazt.qn.x.pr(str2, "req_exemption_error_code").pr(str);
            hnVar.pr(true);
            return hnVar;
        }
        return hnVar;
    }

    public boolean hw() {
        hn();
        return this.hw;
    }
}
