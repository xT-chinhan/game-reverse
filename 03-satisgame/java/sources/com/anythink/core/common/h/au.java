package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class au {
    public static final String a = "au";
    public static final int b = 1;
    public static final int c = 0;
    String d;
    int e;
    List<String> f;
    Set<String> g;
    int h = 0;

    public static class b {
        public static final String a = "token";
        public static final String b = "code";
        public static final String c = "pl_ids";
        public static final String d = "status";
    }

    public static class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final List<Integer> f = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));

        public static boolean a(int i) {
            return f.contains(Integer.valueOf(i));
        }
    }

    public final boolean a() {
        return this.h == 1;
    }

    private au() {
    }

    public static au a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = null;
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("code", 0);
        String strOptString = jSONObject.optString(b.a);
        if (!a.a(iOptInt) || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        if ((iOptInt == 1 || iOptInt == 2) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(b.c)) != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                String strOptString2 = jSONArrayOptJSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(strOptString2);
                }
            }
        }
        int iOptInt2 = jSONObject.optInt("status", 0);
        au auVar = new au();
        auVar.d = strOptString;
        auVar.e = iOptInt;
        auVar.f = arrayList;
        auVar.h = iOptInt2;
        return auVar;
    }

    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.e);
            jSONObject.put(b.a, this.d);
            if (this.f != null) {
                jSONObject.put(b.c, new JSONArray((Collection) this.f));
            }
            jSONObject.put("status", this.h);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void b(JSONObject jSONObject) {
        try {
            jSONObject.put("code", this.e);
            jSONObject.put(b.a, this.d);
            int i = this.e;
            if ((i == 1 || i == 2) && this.f != null) {
                jSONObject.put(b.c, new JSONArray((Collection) this.f));
            }
        } catch (Throwable unused) {
        }
    }

    public final String c() {
        return this.d;
    }

    private void a(String str) {
        this.d = str;
    }

    public final int d() {
        return this.e;
    }

    private void a(int i) {
        this.e = i;
    }

    public final List<String> e() {
        return this.f;
    }

    private void a(List<String> list) {
        this.f = list;
    }

    public final Set<String> f() {
        return this.g;
    }

    public final void a(Set<String> set) {
        this.g = set;
    }

    public final int g() {
        return this.h;
    }

    public final void h() {
        this.h = 1;
    }

    public final boolean a(au auVar) {
        return this.e == auVar.e && TextUtils.equals(this.d, auVar.d);
    }

    public String toString() {
        return "HeartBeatActionInfo{token='" + this.d + "', actionCode=" + this.e + (this.f != null ? ", placementIdList=" + this.f : "") + ", status=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }
}
