package com.anythink.core.common.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private int[] a;
    private int b;
    private int c;
    private h d;
    private String e;

    public final int[] a() {
        return this.a;
    }

    private void a(int[] iArr) {
        this.a = iArr;
    }

    private int e() {
        return this.b;
    }

    private void a(int i) {
        this.b = i;
    }

    public final int b() {
        return this.c;
    }

    private void b(int i) {
        this.c = i;
    }

    public final h c() {
        return this.d;
    }

    private void a(h hVar) {
        this.d = hVar;
    }

    private static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.e = jSONObject.toString();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("range");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() >= 2) {
            aVar.a = new int[]{jSONArrayOptJSONArray.optInt(0, 0), jSONArrayOptJSONArray.optInt(1, 0)};
        }
        aVar.b = jSONObject.optInt("max_req_thread", 0);
        aVar.c = jSONObject.optInt("share_pl_sw", 2);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.e.b.a.ad);
        if (jSONObjectOptJSONObject != null) {
            aVar.d = h.a(jSONObjectOptJSONObject);
        }
        return aVar;
    }

    public static List<a> a(JSONArray jSONArray) {
        a aVar;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                aVar = null;
            } else {
                aVar = new a();
                aVar.e = jSONObjectOptJSONObject.toString();
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("range");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() >= 2) {
                    aVar.a = new int[]{jSONArrayOptJSONArray.optInt(0, 0), jSONArrayOptJSONArray.optInt(1, 0)};
                }
                aVar.b = jSONObjectOptJSONObject.optInt("max_req_thread", 0);
                aVar.c = jSONObjectOptJSONObject.optInt("share_pl_sw", 2);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(com.anythink.core.e.b.a.ad);
                if (jSONObjectOptJSONObject2 != null) {
                    aVar.d = h.a(jSONObjectOptJSONObject2);
                }
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final String d() {
        String str = this.e;
        return str != null ? str : "";
    }

    public final String toString() {
        return d();
    }
}
