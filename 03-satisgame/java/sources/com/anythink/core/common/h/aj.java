package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aj extends ai {
    private int a;
    private long b;
    private int c;
    private String d;
    private Map<Integer, al> e;
    private List<ak> f;
    private List<ak> g;

    private aj() {
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00eb  */
    public static aj a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArrayOptJSONArray;
        aj ajVar = new aj();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("e_cwf");
            if (jSONObjectOptJSONObject != null) {
                ajVar.d = jSONObjectOptJSONObject.optString("oe_ids");
                ajVar.a = jSONObjectOptJSONObject.optInt("ss_sw");
                ajVar.c = jSONObjectOptJSONObject.optInt("sd_sw");
                ajVar.b = jSONObjectOptJSONObject.optLong("dt");
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("oe");
                if (jSONObjectOptJSONObject2 != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        al alVar = new al();
                        String next = itKeys.next();
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                        if (jSONObjectOptJSONObject3 != null) {
                            alVar.a(jSONObjectOptJSONObject3.optLong("t"));
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("c");
                            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("c_m");
                            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                                jSONObject2 = jSONObjectOptJSONObject2;
                            } else {
                                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                                HashMap map = new HashMap();
                                int i = 0;
                                while (i < jSONArrayOptJSONArray2.length()) {
                                    String strOptString = jSONArrayOptJSONArray2.optString(i);
                                    copyOnWriteArrayList.add(strOptString);
                                    if (TextUtils.isEmpty(strOptString) || jSONObjectOptJSONObject4 == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray(strOptString)) == null || jSONArrayOptJSONArray.length() <= 0) {
                                        jSONObject3 = jSONObjectOptJSONObject2;
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        int i2 = 0;
                                        while (i2 < jSONArrayOptJSONArray.length()) {
                                            Object obj = jSONArrayOptJSONArray.get(i2);
                                            JSONObject jSONObject4 = jSONObjectOptJSONObject2;
                                            if ((obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
                                                arrayList.add((String) obj);
                                            }
                                            i2++;
                                            jSONObjectOptJSONObject2 = jSONObject4;
                                        }
                                        jSONObject3 = jSONObjectOptJSONObject2;
                                        if (!arrayList.isEmpty()) {
                                            map.put(strOptString, arrayList);
                                        }
                                    }
                                    i++;
                                    jSONObjectOptJSONObject2 = jSONObject3;
                                }
                                jSONObject2 = jSONObjectOptJSONObject2;
                                alVar.a(copyOnWriteArrayList);
                                if (!map.isEmpty()) {
                                    alVar.a(map);
                                }
                            }
                        } else {
                            jSONObject2 = jSONObjectOptJSONObject2;
                        }
                        int i3 = Integer.parseInt(next);
                        alVar.a(i3);
                        concurrentHashMap.put(Integer.valueOf(i3), alVar);
                        jSONObjectOptJSONObject2 = jSONObject2;
                    }
                }
                ajVar.e = concurrentHashMap;
            }
        } catch (Throwable unused) {
        }
        return ajVar;
    }

    public final boolean a() {
        return TextUtils.isEmpty(this.d);
    }

    public final boolean b() {
        return this.a == 1;
    }

    public final boolean a(long j) {
        return j > 0 && System.currentTimeMillis() - j < this.b;
    }

    public final boolean c() {
        return this.c == 1;
    }

    public final List<ak> d() {
        return this.f;
    }

    public final Map<Integer, al> e() {
        return this.e;
    }

    public final void a(List<ak> list) {
        this.f = list;
    }

    public final void b(List<ak> list) {
        this.g = list;
    }

    public final List<ak> f() {
        return this.g;
    }

    public final String g() {
        return this.d;
    }
}
