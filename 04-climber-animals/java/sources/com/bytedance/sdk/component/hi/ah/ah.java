package com.bytedance.sdk.component.hi.ah;

import android.text.TextUtils;
import com.umeng.analytics.pro.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private boolean ah;
    private JSONObject c;
    private final Map<String, ms> d = new HashMap();
    private ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1234ms;
    private String xr;

    public ah(JSONObject jSONObject) {
        this.ah = false;
        String next = jSONObject.keys().next();
        this.xr = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.f1234ms = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.ah = zOptBoolean;
        if (!zOptBoolean) {
            ms(jSONObjectOptJSONObject);
        } else {
            this.c = jSONObjectOptJSONObject;
        }
    }

    private void ms(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(g.ax);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            ms msVar = new ms(jSONArrayOptJSONArray.optJSONObject(i));
            this.d.put(msVar.ms(), msVar);
            if (msVar.ms().equals(jSONObject.optString("main"))) {
                this.ka = msVar;
            }
        }
    }

    public ms ms(String str) {
        if (this.ah) {
            ms(this.c);
        }
        return this.d.get(str);
    }

    public ms ms() {
        if (this.ah) {
            ms(this.c);
        }
        return this.ka;
    }

    public String xr() {
        return this.xr;
    }

    public List<ms> ms(ms msVar, JSONObject jSONObject, Map<String, Object> map) {
        return ms(jSONObject, map, msVar.ka());
    }

    public List<ms> xr(ms msVar, JSONObject jSONObject, Map<String, Object> map) {
        return ms(jSONObject, map, msVar.c());
    }

    private List<ms> ms(JSONObject jSONObject, Map<String, Object> map, List<ms.C0247ms> list) {
        ms msVarMs;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (ms.C0247ms c0247ms : list) {
            if (c0247ms != null && (msVarMs = ms(c0247ms.ms())) != null && ms(c0247ms.xr(), jSONObject, map)) {
                arrayList.add(msVarMs);
            }
        }
        return arrayList;
    }

    private static boolean ms(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.bytedance.adsdk.xr.xr.ms.ms(str.substring(2, str.length() - 1)).ms(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public List<ms> ah(ms msVar, JSONObject jSONObject, Map<String, Object> map) {
        List<ms.C0247ms> listD = msVar.d();
        ArrayList arrayList = new ArrayList();
        for (ms.C0247ms c0247ms : listD) {
            if (c0247ms != null && ms(c0247ms.xr(), jSONObject, map)) {
                arrayList.add(ms(c0247ms.ms()));
            }
        }
        return arrayList;
    }
}
