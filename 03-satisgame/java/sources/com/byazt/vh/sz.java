package com.byazt.vh;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, 110})
public class sz {
    public Set<String> cp;
    public boolean fs;
    public JSONObject l;
    public Context n;
    public Map<String, Object> q;
    public JSONObject qg;
    public com.byazt.xz.cy rv;
    public JSONObject s;
    public String tj;
    public final JSONObject w = new JSONObject();
    public final JSONObject x = new JSONObject();

    public Context getContext() {
        return this.n;
    }

    public void n(Context context) {
        this.n = context;
    }

    public void n(JSONObject jSONObject) {
        this.qg = jSONObject;
    }

    public JSONObject n() {
        return this.s;
    }

    public void qg(JSONObject jSONObject) {
        this.s = jSONObject;
    }

    public void s(JSONObject jSONObject) {
        if (this.fs) {
            return;
        }
        this.l = jSONObject;
    }

    public void q(JSONObject jSONObject) {
        if (this.fs || jSONObject == null) {
            return;
        }
        this.s = jSONObject;
        JSONObject jSONObject2 = this.l;
        if (jSONObject2 != null) {
            n(jSONObject2.optJSONObject("ugen_const_store"), jSONObject);
            qg(this.l.optJSONObject("ugen_state_store"), jSONObject);
            this.fs = true;
        }
    }

    public Set<String> n(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (!this.x.has(key) || !Objects.equals(this.x.opt(key), value))) {
                try {
                    this.x.put(key, value);
                    linkedHashSet.add(key);
                } catch (JSONException unused) {
                }
            }
        }
        return linkedHashSet;
    }

    public void n(Set<String> set) {
        if (set == null || set.isEmpty() || this.rv == null) {
            return;
        }
        for (String str : set) {
            HashMap map = new HashMap();
            map.put(e.a.b, str);
            this.rv.n(this.tj, "stateChange", map);
        }
    }

    public JSONObject l(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ugen_const_store", this.w);
            jSONObject.put("ugen_state_store", this.x);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (!TextUtils.isEmpty(next)) {
                n(this.w, next, objOpt, jSONObject2);
            }
        }
    }

    private void qg(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (!TextUtils.isEmpty(next) && !n(objOpt)) {
                n(this.x, next, objOpt, jSONObject2);
            }
        }
    }

    private boolean n(JSONObject jSONObject, String str, Object obj, JSONObject jSONObject2) {
        if (obj != null && obj != JSONObject.NULL) {
            try {
                jSONObject.put(str, com.byazt.mcb.qg.n(String.valueOf(obj), l(jSONObject2)));
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private boolean n(Object obj) {
        return String.valueOf(obj).contains("ugen_state_store.");
    }

    public Map<String, Object> qg() {
        return this.q;
    }

    public void qg(Map<String, Object> map) {
        this.q = map;
    }

    public void n(com.byazt.xz.cy cyVar) {
        this.rv = cyVar;
    }

    public void n(String str) {
        this.tj = str;
    }

    public void qg(Set<String> set) {
        this.cp = set;
    }

    public com.byazt.xz.cy s() {
        return this.rv;
    }

    public String q() {
        return this.tj;
    }

    public Set<String> l() {
        return this.cp;
    }
}
