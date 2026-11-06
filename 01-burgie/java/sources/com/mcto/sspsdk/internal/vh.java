package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes2.dex */
public final class vh {
    public final mh a;
    public final int d;
    public int g;
    public int l;
    public int n;
    public JSONObject o;
    public String p;
    public ArrayList b = null;
    public ArrayList c = null;
    public int e = 0;
    public int f = 0;
    public int h = 0;
    public String i = null;
    public final HashMap j = new HashMap();
    public int k = 0;
    public int m = -1;

    public vh(mh mhVar, JSONObject jSONObject) {
        this.d = 0;
        this.a = mhVar;
        int i = mhVar.d;
        AtomicInteger atomicInteger = gj.a;
        this.d = i;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adSlots");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        int[] iArrA = gj.a(jSONObject.optJSONArray("trackingTimeouts"));
        if (!j.b(3, mhVar.a) || mhVar.c) {
            a(jSONArrayOptJSONArray.optJSONObject(0), iArrA);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            long jOptLong = jSONObjectOptJSONObject.optLong("orderItemStartTime");
            long jOptLong2 = jSONObjectOptJSONObject.optLong("orderItemEndTime");
            if (0 != jOptLong && 0 != jOptLong2 && jOptLong < jOptLong2 && jOptLong < jCurrentTimeMillis && jCurrentTimeMillis < jOptLong2) {
                a(jSONObjectOptJSONObject, iArrA);
                return;
            }
        }
    }

    public final void a(JSONObject jSONObject, int[] iArr) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        this.i = jSONObject.optString("adZoneId");
        this.g = jSONObject.optInt("type", 0);
        this.m = jSONObject.optInt("dasdk", -1);
        this.o = jSONObject.optJSONObject("extAdsInfo");
        this.p = jSONObject.optString("sdkt");
        this.l = jSONObject.optInt("emptyStrategy", -1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("emptyTracking");
        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("timeSlices")) != null && jSONArrayOptJSONArray.length() >= 0) {
            this.c = new ArrayList();
            HashMap mapA = gj.a(jSONObjectOptJSONObject.optJSONObject("params"));
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("trackingTimeouts");
            int[] iArrA = (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) ? iArr : gj.a(jSONArrayOptJSONArray2);
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    int i2 = this.d;
                    int i3 = this.f + 1;
                    this.f = i3;
                    p pVar = new p(i2 | i3, this, true, iArrA);
                    pVar.x = jSONObjectOptJSONObject2.optString("w");
                    HashMap map = pVar.F;
                    q4 q4Var = new q4();
                    q4Var.b.add("0");
                    HashMap mapA2 = gj.a(jSONObjectOptJSONObject2);
                    q4Var.c = mapA2;
                    mapA2.putAll(mapA);
                    map.put("cupidTracking", q4Var);
                    this.c.add(pVar);
                }
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("ads");
        if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() < 0) {
            return;
        }
        this.b = new ArrayList();
        int length2 = jSONArrayOptJSONArray3.length();
        for (int i4 = 0; i4 < length2; i4++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i4);
            if (jSONObjectOptJSONObject3 != null) {
                this.k++;
                int i5 = this.d;
                int i6 = this.f + 1;
                this.f = i6;
                AtomicInteger atomicInteger = gj.a;
                p pVar2 = new p(i5 | i6, this, false, iArr);
                pVar2.a(jSONObjectOptJSONObject3);
                if (TextUtils.isEmpty(pVar2.S)) {
                    this.b.add(pVar2);
                    this.e++;
                    pVar2.l();
                    pVar2.a();
                } else {
                    String str = pVar2.S;
                    Integer num = (Integer) this.j.get(str);
                    if (num == null) {
                        this.j.put(str, 1);
                    } else {
                        this.j.put(str, Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
        }
        Collections.sort(this.b, new uh());
        int i7 = this.e;
        if (i7 > 0) {
            this.h = ((p) this.b.get(i7 - 1)).f;
        }
    }

    public static void a(JSONObject jSONObject, JSONStringer jSONStringer) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONStringer.key(next).value(jSONObject.opt(next));
            } catch (Exception e) {
                r9.a("ssp_sdk", "mergeAdDetailInfo: skip key " + next + " due to exception", e);
            }
        }
    }
}
