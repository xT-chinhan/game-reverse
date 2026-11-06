package com.byazt.so;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 427, 21})
public class x {
    public String l;
    public final Map<String, List<String>> n;
    public final String q;
    public final String qg;
    public final JSONObject s;
    public String w;

    public x(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.qg = str;
        this.q = str2;
        this.n = map;
        this.s = jSONObject;
    }

    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.n.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.n.put(str, arrayList);
            return;
        }
        list.add(str2);
    }

    public Map<String, List<String>> n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public void n(String str) {
        this.l = str;
    }

    public void qg(String str) {
        this.w = str;
    }

    public String s() {
        try {
            String strOptString = this.s.optString("expandParams");
            String str = "apppackage=" + this.l + "|appsign=" + this.w;
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString + "|" + str;
            }
            this.s.put("expandParams", str);
        } catch (Exception unused) {
        }
        JSONObject jSONObject = this.s;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String q() {
        return this.q;
    }
}
