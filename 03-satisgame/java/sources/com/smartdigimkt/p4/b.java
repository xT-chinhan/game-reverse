package com.smartdigimkt.p4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public JSONObject a;
    public HashMap b;
    public HashMap c;
    public HashMap d;

    public final void a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(com.anythink.core.common.l.f.aq);
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.optString(next));
                }
            } catch (Throwable unused) {
            }
        }
        this.c = map;
    }

    public final void b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("cached");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.optString(next));
                }
            } catch (Throwable unused) {
            }
        }
        this.b = map;
    }
}
