package com.byazt.ji;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 115, 19})
public class n {
    public final int fs;
    public final int l;
    public final boolean n;
    public final int q;
    public final float qg;
    public final Set<String> s;
    public final int w;
    public final int x;

    public n(boolean z, float f, Set<String> set, int i, int i2, int i3, int i4, int i5) {
        this.n = z;
        this.qg = Math.max(0.0f, Math.min(1.0f, f));
        this.s = set == null ? new HashSet<>() : set;
        this.q = i;
        this.l = Math.max(1, i2);
        this.w = Math.max(1, i3);
        this.x = Math.max(1000, i4);
        this.fs = Math.max(1, i5);
    }

    public static n n() {
        return new n(false, 1.0f, new HashSet(), 80, 200, 64, 30000, 3);
    }

    public static n n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("ats_chain_metrics");
        if (jSONObjectOptJSONObject == null) {
            return n();
        }
        return new n(jSONObjectOptJSONObject.optBoolean("enable", false), (float) jSONObjectOptJSONObject.optDouble(f.V, 1.0d), n(jSONObjectOptJSONObject.optJSONArray("blacklist")), jSONObjectOptJSONObject.optInt("health_threshold", 80), jSONObjectOptJSONObject.optInt("max_entries", 200), jSONObjectOptJSONObject.optInt("max_payload_kb", 64), jSONObjectOptJSONObject.optInt("flush_interval_ms", 30000), jSONObjectOptJSONObject.optInt("max_snapshot_per_session", 3));
    }

    public boolean n(String str) {
        return !TextUtils.isEmpty(str) && this.s.contains(str);
    }

    private static Set<String> n(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(strOptString)) {
                hashSet.add(strOptString);
            }
        }
        return hashSet;
    }
}
