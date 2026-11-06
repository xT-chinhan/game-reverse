package com.anythink.basead.b.e;

import android.text.TextUtils;
import com.anythink.core.common.e.f;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private Map<String, a> a = new HashMap();

    public final void a(JSONArray jSONArray) {
        this.a.clear();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("macro");
                if (!TextUtils.isEmpty(strOptString)) {
                    a aVar = new a();
                    aVar.a = strOptString;
                    aVar.b = jSONObject.optInt(com.umeng.ccg.a.z, 1);
                    aVar.c = jSONObject.optString(f.a.d, "");
                    this.a.put(strOptString, aVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final String a(String str, String str2) {
        a aVar;
        Map<String, a> map = this.a;
        if (map == null || (aVar = map.get(str)) == null) {
            return str2;
        }
        int i = aVar.b;
        if (i == 2) {
            return "";
        }
        if (i == 3) {
            return Matcher.quoteReplacement(aVar.c);
        }
        return aVar.a;
    }

    static class a {
        private static final int d = 1;
        private static final int e = 2;
        private static final int f = 3;
        public String a;
        public int b;
        public String c;

        a() {
        }

        private String a() {
            int i = this.b;
            if (i == 2) {
                return "";
            }
            if (i == 3) {
                return Matcher.quoteReplacement(this.c);
            }
            return this.a;
        }
    }
}
