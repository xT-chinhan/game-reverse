package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class gl {
    public static volatile gl c;
    public static final dl d = new dl();
    public static final el e = new el();
    public HashMap a;
    public String b;

    public gl() {
        int iIndexOf;
        String strA = nh.a(jd.a).a("wadnc");
        if (strA == null || strA.length() < 3 || (iIndexOf = strA.indexOf("||")) < 0) {
            return;
        }
        this.b = strA.substring(0, iIndexOf);
        HashMap mapA = a(gj.e(strA.substring(iIndexOf + 2)));
        synchronized (this) {
            this.a = mapA;
        }
    }

    public static gl a() {
        if (c == null) {
            synchronized (gl.class) {
                if (c == null) {
                    c = new gl();
                }
            }
        }
        return c;
    }

    public static HashMap a(String str) {
        int length;
        int length2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(strValueOf);
                if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            int iOptInt = jSONObjectOptJSONObject.optInt("priority", i);
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("cids");
                            int iOptInt2 = jSONObjectOptJSONObject.optInt("timeout", 5000);
                            if (jSONArrayOptJSONArray2 != null && (length2 = jSONArrayOptJSONArray2.length()) > 0) {
                                for (int i2 = 0; i2 < length2; i2++) {
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                    if (jSONObjectOptJSONObject2 != null) {
                                        cl clVar = new cl(iOptInt, jSONObjectOptJSONObject2);
                                        clVar.g = strValueOf;
                                        if (!TextUtils.isEmpty(clVar.f)) {
                                            clVar.e = iOptInt2;
                                            arrayList2.add(clVar);
                                        }
                                    }
                                }
                                Collections.sort(arrayList2, e);
                                arrayList.add(new fl(iOptInt, arrayList2));
                            }
                        }
                    }
                    Collections.sort(arrayList, d);
                    map.put(strValueOf, arrayList);
                }
            }
            return map;
        } catch (Exception e2) {
            r9.a("ssp_water", "parseConfig json error", e2);
            return null;
        }
    }
}
