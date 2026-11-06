package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.mcto.sspsdk.QyAdSlot;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 {
    public static volatile h1 e;
    public final ConcurrentHashMap a;
    public Object b;
    public long c;
    public HashMap d;

    public h1() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
        this.b = new CopyOnWriteArrayList();
        this.c = 0L;
        Context context = jd.a;
        "AppAttribution constructor: onCreate: ".concat("first");
        try {
            concurrentHashMap.putAll(a(new JSONObject(jd.a.getSharedPreferences("iifn", 0).getString("iif", "{}"))));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static h1 a() {
        if (e == null) {
            synchronized (h1.class) {
                if (e == null) {
                    e = new h1();
                }
            }
        }
        return e;
    }

    public final void b(String str, long j) {
        String str2 = "aifn=" + str + "&aift=" + j;
        QyAdSlot qyAdSlotBuild = QyAdSlot.newQyAdSlot().codeId(rd.a() ? "773" : "1781259627413891").build();
        HashMap map = c0.k;
        b0 b0Var = new b0();
        b0Var.d = 10;
        b0Var.h = false;
        b0Var.a = qyAdSlotBuild;
        b0Var.c = gj.a(qyAdSlotBuild.h());
        b0Var.e = str2;
        b0Var.b = new g1();
        new c0(b0Var).b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    public final void a(HashMap map) {
        try {
            this.b.size();
            for (String str : this.b) {
                if (map != null && map.containsKey(str)) {
                    xa xaVar = (xa) map.get(str);
                    if (xaVar != null) {
                        a(str, gj.a(xaVar.c, System.currentTimeMillis()));
                    }
                } else if (map == null || !map.containsKey(str)) {
                    a(str);
                }
            }
        } catch (Exception e2) {
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            PackageInfo packageInfoA = e1.a(str);
            if (packageInfoA == null) {
                return;
            }
            long j = packageInfoA.firstInstallTime;
            Map map = (Map) this.a.get(str);
            if (!(map != null && map.containsKey("installTime") && j == gj.a(map.get("installTime"), 0L)) && Math.abs((System.currentTimeMillis() - j) / 1000) <= this.c) {
                b(str, j);
                a(str, j);
            }
        } catch (Exception e2) {
            e2.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    public final void a(String str, long j) {
        try {
            if (this.b.contains(str)) {
                Map map = (Map) this.a.get(str);
                if (map == null) {
                    map = new HashMap();
                }
                map.put("installTime", Long.valueOf(j));
                this.a.put(str, map);
                ConcurrentHashMap concurrentHashMap = this.a;
                try {
                    SharedPreferences.Editor editorEdit = jd.a.getSharedPreferences("iifn", 0).edit();
                    editorEdit.putString("iif", new JSONObject(concurrentHashMap).toString());
                    editorEdit.apply();
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        } catch (Exception e3) {
        }
    }

    public static HashMap a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    HashMap map2 = new HashMap();
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        map2.put(next2, jSONObjectOptJSONObject.opt(next2));
                    }
                    map.put(next, map2);
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return map;
    }
}
