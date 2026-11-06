package com.anythink.core.common.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    final String a = "h";
    Map<String, Integer> b = new ConcurrentHashMap();
    Map<String, Integer> c = new ConcurrentHashMap();
    int d = 0;
    int e = 0;

    public final synchronized void a(g gVar) {
        if (gVar != null) {
            gVar.toString();
            String strB = gVar.b();
            int iD = gVar.d();
            if (iD == 4) {
                a(strB);
            } else if (iD == 6) {
                b(strB);
            }
        }
    }

    public final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d++;
            this.b.put(str, Integer.valueOf(a(this.b, str) + 1));
        }
    }

    public final synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e++;
            this.c.put(str, Integer.valueOf(a(this.c, str) + 1));
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<Map.Entry<String, Integer>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    int iA = a(this.b, key);
                    int iA2 = a(this.c, key);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("dsp_id", key);
                    jSONObject2.put("show_c", iA);
                    jSONObject2.put("click_c", iA2);
                    jSONArray.put(jSONObject2);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("ad_fc", jSONArray);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static int a(Map<String, Integer> map, String str) {
        Integer num;
        if (map == null || (num = map.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
