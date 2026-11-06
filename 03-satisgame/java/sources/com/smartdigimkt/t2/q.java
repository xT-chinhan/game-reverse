package com.smartdigimkt.t2;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public final synchronized void a(p pVar) {
        pVar.toString();
        String str = TextUtils.isEmpty(pVar.b) ? "" : pVar.b;
        int i = pVar.d;
        if (i == 4) {
            b(str);
        } else if (i == 6) {
            a(str);
        }
    }

    public final synchronized void b(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap concurrentHashMap = this.a;
            this.a.put(str, Integer.valueOf(((concurrentHashMap == null || (num = (Integer) concurrentHashMap.get(str)) == null) ? 0 : num.intValue()) + 1));
        }
    }

    public final synchronized void a(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap concurrentHashMap = this.b;
            this.b.put(str, Integer.valueOf(((concurrentHashMap == null || (num = (Integer) concurrentHashMap.get(str)) == null) ? 0 : num.intValue()) + 1));
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        Integer num;
        Integer num2;
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                String str = (String) ((Map.Entry) it.next()).getKey();
                ConcurrentHashMap concurrentHashMap = this.a;
                int iIntValue = 0;
                int iIntValue2 = (concurrentHashMap == null || (num2 = (Integer) concurrentHashMap.get(str)) == null) ? 0 : num2.intValue();
                ConcurrentHashMap concurrentHashMap2 = this.b;
                if (concurrentHashMap2 != null && (num = (Integer) concurrentHashMap2.get(str)) != null) {
                    iIntValue = num.intValue();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dsp_id", str);
                jSONObject2.put("show_c", iIntValue2);
                jSONObject2.put("click_c", iIntValue);
                jSONArray.put(jSONObject2);
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("ad_fc", jSONArray);
            }
        } catch (Throwable unused) {
        }
    }
}
