package com.byazt.mv;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 701, 5})
public class q {
    public String[] l;
    public final String n;
    public final String q;
    public final String qg;
    public final Map<String, Float> s = new ConcurrentHashMap();
    public final Map<String, l> w = new ConcurrentHashMap();

    public q(String str, String str2, JSONObject jSONObject) {
        this.n = str;
        this.qg = str2;
        this.q = jSONObject.optString("symbol");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("score_fit_type");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            this.l = new String[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    this.l[i] = strOptString;
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("range");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(e.a.d);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0 && jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                            this.w.put(strOptString, new l(strOptString, jSONArrayOptJSONArray2, jSONArrayOptJSONArray3));
                        }
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_exc_mode");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            return;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.s.put(next, Float.valueOf((float) jSONObjectOptJSONObject2.optDouble(next, 0.0d)));
        }
    }

    public String n() {
        return this.n;
    }

    public Map<String, Float> qg() {
        return this.s;
    }

    public String[] s() {
        return this.l;
    }

    public String q() {
        return this.q;
    }

    public Map<String, l> l() {
        return this.w;
    }
}
