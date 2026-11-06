package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.f;
import com.anythink.core.common.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static int n = -1;
    private static volatile b o;
    private static SimpleDateFormat p;
    ConcurrentHashMap<String, f> b;
    ConcurrentHashMap<String, f> c;
    ConcurrentHashMap<String, f> d;
    ConcurrentHashMap<String, f> e;
    ConcurrentHashMap<String, f> f;
    ConcurrentHashMap<String, f> g;
    ConcurrentHashMap<String, Long> h;
    ConcurrentHashMap<String, Long> i;
    ConcurrentHashMap<String, Long> j;
    ConcurrentHashMap<String, Long> k;
    ConcurrentHashMap<String, Long> l;
    ConcurrentHashMap<String, Long> m;
    private final com.anythink.core.common.e.a q;
    private e s;
    private a t;
    private a u;
    private a v;
    private a w;
    final String a = "b";
    private final Object r = new Object();

    public static b a(Context context) {
        if (o == null) {
            synchronized (b.class) {
                if (o == null) {
                    o = new b(context);
                }
            }
        }
        return o;
    }

    private com.anythink.core.common.e.a a() {
        return this.q;
    }

    private b(Context context) {
        this.q = com.anythink.core.common.e.a.a(com.anythink.core.common.e.e.a(context));
        p = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            com.anythink.core.common.v.b.b.a().b(new AnonymousClass1(a(new Date()), b(new Date())), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b = new ConcurrentHashMap<>(3);
        this.c = new ConcurrentHashMap<>(3);
        this.d = new ConcurrentHashMap<>(3);
        this.e = new ConcurrentHashMap<>(3);
        this.f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>(3);
        this.h = new ConcurrentHashMap<>(3);
        this.j = new ConcurrentHashMap<>(3);
        this.i = new ConcurrentHashMap<>(3);
        this.k = new ConcurrentHashMap<>(3);
        this.m = new ConcurrentHashMap<>(3);
        this.l = new ConcurrentHashMap<>(3);
    }

    public static String a(Date date) {
        if (p == null) {
            p = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return p.format(date).substring(5, 7);
    }

    public static String b(Date date) {
        if (p == null) {
            p = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return p.format(date).substring(8, 10);
    }

    public static String c(Date date) {
        if (p == null) {
            p = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return p.format(date).substring(11, 13);
    }

    /* JADX INFO: renamed from: com.anythink.core.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass1(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.q != null) {
                b.this.q.e(this.a, this.b);
            }
        }
    }

    private void a(String str, String str2) {
        try {
            com.anythink.core.common.v.b.b.a().b(new AnonymousClass1(str, str2), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(k.A);
                if (jSONObjectOptJSONObject != null) {
                    this.t = b(jSONObjectOptJSONObject);
                } else if (this.t != null) {
                    this.t = null;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(k.B);
                if (jSONObjectOptJSONObject2 != null) {
                    this.u = b(jSONObjectOptJSONObject2);
                } else if (this.u != null) {
                    this.u = null;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("caps_s");
                if (jSONObjectOptJSONObject3 != null) {
                    this.v = b(jSONObjectOptJSONObject3);
                } else if (this.v != null) {
                    this.v = null;
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("req_pace");
                if (jSONObjectOptJSONObject4 != null) {
                    this.w = b(jSONObjectOptJSONObject4);
                    return;
                } else {
                    if (this.w != null) {
                        this.w = null;
                    }
                    return;
                }
            }
            if (this.t != null) {
                this.t = null;
            }
            if (this.u != null) {
                this.u = null;
            }
            if (this.v != null) {
                this.v = null;
            }
            if (this.w != null) {
                this.w = null;
            }
        } catch (Throwable unused) {
        }
    }

    private ConcurrentHashMap<String, f> b() {
        return this.c;
    }

    public final int a(String str) {
        Pair<Integer, Integer> pair;
        try {
            a aVar = this.w;
            if (aVar != null) {
                if (aVar.a() > 0 && this.w.b() > 0) {
                    String strP = t.b().p();
                    if (!TextUtils.isEmpty(strP)) {
                        f fVarD = this.b.get(strP);
                        if (fVarD == null && (fVarD = this.q.d(strP, com.anythink.core.common.e.a.C0080a.c)) != null) {
                            this.b.put(strP, fVarD);
                        }
                        if (fVarD != null && fVarD.a >= this.w.a() && System.currentTimeMillis() - fVarD.i() <= this.w.b()) {
                            int i = fVarD.a;
                            this.w.a();
                            return 9;
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.w.c();
                if (mapC != null && !mapC.isEmpty() && (pair = mapC.get(str)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0) {
                    f fVarD2 = this.d.get(str);
                    if (fVarD2 == null && (fVarD2 = this.q.d(str, "format")) != null) {
                        this.d.put(str, fVarD2);
                    }
                    if (fVarD2 != null && fVarD2.a >= ((Integer) pair.first).intValue() && System.currentTimeMillis() - fVarD2.i() <= ((Integer) pair.second).intValue()) {
                        new StringBuilder("placement req filter by format:").append(fVarD2.a).append(":").append(pair.first);
                        return 10;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public final int a(int i, long j, String str) {
        if (i > 0 && j > 0) {
            try {
                f fVarD = this.c.get(str);
                if (fVarD == null && (fVarD = this.q.d(str, "placement_id")) != null) {
                    this.c.put(str, fVarD);
                }
                if (fVarD != null && fVarD.a >= i && System.currentTimeMillis() - fVarD.i() <= j) {
                    int i2 = fVarD.a;
                    return 8;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return n;
    }

    public final void a(int i, long j, String str, int i2) {
        Pair<Integer, Integer> pair;
        try {
            a aVar = this.w;
            if (aVar != null) {
                if (aVar.a() > 0 && this.w.b() > 0) {
                    String strP = t.b().p();
                    if (!TextUtils.isEmpty(strP)) {
                        f fVar = this.b.get(strP);
                        if (fVar == null) {
                            f fVar2 = new f("1", strP, com.anythink.core.common.e.a.C0080a.c, System.currentTimeMillis(), 1);
                            this.b.put(strP, fVar2);
                            fVar = fVar2;
                        } else if (System.currentTimeMillis() - fVar.i() > this.w.b()) {
                            fVar.a(System.currentTimeMillis());
                            fVar.a = 1;
                        } else {
                            fVar.a++;
                        }
                        new StringBuilder("placement req save to global:").append(fVar);
                        this.q.b(strP, com.anythink.core.common.e.a.C0080a.c, fVar.a, fVar.i());
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.w.c();
                if (mapC != null && !mapC.isEmpty() && (pair = mapC.get(String.valueOf(i2))) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0) {
                    f fVar3 = this.d.get(String.valueOf(i2));
                    if (fVar3 == null) {
                        fVar3 = new f("1", String.valueOf(i2), "format", System.currentTimeMillis(), 1);
                        this.d.put(String.valueOf(i2), fVar3);
                    } else if (System.currentTimeMillis() - fVar3.i() > ((Integer) pair.second).intValue()) {
                        fVar3.a(System.currentTimeMillis());
                        fVar3.a = 1;
                    } else {
                        fVar3.a++;
                    }
                    new StringBuilder("placement req save to format:").append(fVar3);
                    this.q.b(String.valueOf(i2), "format", fVar3.a, fVar3.i());
                }
            }
            if (i <= 0 || j <= 0) {
                return;
            }
            f fVar4 = this.c.get(str);
            if (fVar4 == null) {
                fVar4 = new f("1", str, "placement_id", System.currentTimeMillis(), 1);
                this.c.put(str, fVar4);
            } else if (System.currentTimeMillis() - fVar4.i() > j) {
                fVar4.a(System.currentTimeMillis());
                fVar4.a = 1;
            } else {
                fVar4.a++;
            }
            new StringBuilder("placement req save to placementId:").append(fVar4);
            this.q.b(str, "placement_id", fVar4.a, fVar4.i());
        } catch (Throwable unused) {
        }
    }

    private ConcurrentHashMap<String, f> c() {
        return this.f;
    }

    public final int a(int i, long j, int i2, String str, String str2) {
        Pair<Integer, Integer> pair;
        Pair<Integer, Integer> pair2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                a aVar = this.w;
                if (aVar != null) {
                    Map<String, Pair<Integer, Integer>> mapD = aVar.d();
                    if (mapD != null && !mapD.isEmpty() && (pair2 = mapD.get(String.valueOf(i2))) != null && ((Integer) pair2.first).intValue() > 0 && ((Integer) pair2.second).intValue() > 0) {
                        f fVarD = this.e.get(String.valueOf(i2));
                        if (fVarD == null && (fVarD = this.q.d(String.valueOf(i2), "network_id")) != null) {
                            this.e.put(String.valueOf(i2), fVarD);
                        }
                        if (fVarD != null && fVarD.a >= ((Integer) pair2.first).intValue() && System.currentTimeMillis() - fVarD.i() <= ((Integer) pair2.second).intValue()) {
                            new StringBuilder("adSource req filter by network:").append(fVarD.a).append(":").append(pair2.first);
                            return 25;
                        }
                    }
                    Map<String, Pair<Integer, Integer>> mapE = this.w.e();
                    if (mapE != null && !mapE.isEmpty() && (pair = mapE.get(i2 + "_" + str2)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0) {
                        f fVarD2 = this.g.get(i2 + "_" + str2);
                        if (fVarD2 == null && (fVarD2 = this.q.d(i2 + "_" + str2, com.anythink.core.common.e.a.C0080a.f)) != null) {
                            this.g.put(i2 + "_" + str2, fVarD2);
                        }
                        if (fVarD2 != null && fVarD2.a >= ((Integer) pair.first).intValue() && System.currentTimeMillis() - fVarD2.i() <= ((Integer) pair.second).intValue()) {
                            new StringBuilder("adSource req filter by network_format:").append(fVarD2.a).append(":").append(pair.first);
                            return 26;
                        }
                    }
                }
                if (i > 0 && j > 0) {
                    f fVarD3 = this.f.get(str);
                    if (fVarD3 == null && (fVarD3 = this.q.d(str, com.anythink.core.common.e.a.C0080a.h)) != null) {
                        this.f.put(str, fVarD3);
                    }
                    if (fVarD3 != null && fVarD3.a >= i && System.currentTimeMillis() - fVarD3.i() <= j) {
                        int i3 = fVarD3.a;
                        return 18;
                    }
                }
                return n;
            }
            return n;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(int i, long j, int i2, String str, String str2) {
        Pair<Integer, Integer> pair;
        Pair<Integer, Integer> pair2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(String.valueOf(i2))) {
                a aVar = this.w;
                if (aVar != null) {
                    Map<String, Pair<Integer, Integer>> mapD = aVar.d();
                    if (mapD != null && !mapD.isEmpty() && (pair2 = mapD.get(String.valueOf(i2))) != null && ((Integer) pair2.first).intValue() > 0 && ((Integer) pair2.second).intValue() > 0) {
                        f fVar = this.e.get(String.valueOf(i2));
                        if (fVar == null) {
                            fVar = new f("1", String.valueOf(i2), "network_id", System.currentTimeMillis(), 1);
                            this.e.put(String.valueOf(i2), fVar);
                        } else if (System.currentTimeMillis() - fVar.i() > ((Integer) pair2.second).intValue()) {
                            fVar.a(System.currentTimeMillis());
                            fVar.a = 1;
                        } else {
                            fVar.a++;
                        }
                        new StringBuilder("adSource req save to network:").append(fVar);
                        this.q.b(String.valueOf(i2), "network_id", fVar.a, fVar.i());
                    }
                    Map<String, Pair<Integer, Integer>> mapE = this.w.e();
                    if (mapE != null && !mapE.isEmpty() && (pair = mapE.get(i2 + "_" + str2)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0) {
                        f fVar2 = this.g.get(i2 + "_" + str2);
                        if (fVar2 == null) {
                            fVar2 = new f("1", i2 + "_" + str2, com.anythink.core.common.e.a.C0080a.f, System.currentTimeMillis(), 1);
                            this.g.put(i2 + "_" + str2, fVar2);
                        } else if (System.currentTimeMillis() - fVar2.i() > ((Integer) pair.second).intValue()) {
                            fVar2.a(System.currentTimeMillis());
                            fVar2.a = 1;
                        } else {
                            fVar2.a++;
                        }
                        new StringBuilder("adSource req save to network_format:").append(fVar2);
                        this.q.b(i2 + "_" + str2, com.anythink.core.common.e.a.C0080a.f, fVar2.a, fVar2.i());
                    }
                }
                if (i <= 0 || j <= 0) {
                    return;
                }
                f fVar3 = this.f.get(str);
                if (fVar3 == null) {
                    fVar3 = new f("1", str, com.anythink.core.common.e.a.C0080a.h, System.currentTimeMillis(), 1);
                    this.f.put(str, fVar3);
                } else if (System.currentTimeMillis() - fVar3.i() > j) {
                    fVar3.a(System.currentTimeMillis());
                    fVar3.a = 1;
                } else {
                    fVar3.a++;
                }
                this.q.b(str, com.anythink.core.common.e.a.C0080a.h, fVar3.a, fVar3.i());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConcurrentHashMap<String, Long> d() {
        return this.j;
    }

    private ConcurrentHashMap<String, Long> e() {
        return this.m;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0212  */
    public final int a(String str, String str2, long j, long j2) {
        List<f> listB;
        Pair<Integer, Integer> pair;
        List<f> listB2;
        List<f> listB3;
        List<f> listA;
        Pair<Integer, Integer> pair2;
        List<f> listA2;
        List<f> listA3;
        try {
            Date date = new Date();
            int i = Integer.parseInt(b(date));
            int i2 = Integer.parseInt(c(date));
            a aVar = this.t;
            if (aVar != null) {
                if (aVar.a() > 0) {
                    String strP = t.b().p();
                    if (!TextUtils.isEmpty(strP)) {
                        Long lValueOf = this.h.get("day_".concat(String.valueOf(i)));
                        if (lValueOf == null && (listA3 = this.q.a(strP, com.anythink.core.common.e.a.C0080a.c)) != null && !listA3.isEmpty()) {
                            lValueOf = Long.valueOf(listA3.size());
                            this.h.put("day_".concat(String.valueOf(i)), lValueOf);
                        }
                        if (lValueOf != null && lValueOf.longValue() >= this.t.a()) {
                            new StringBuilder("placement imp filter day by global:").append(lValueOf);
                            this.t.a();
                            return 7;
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.t.c();
                if (mapC != null && !mapC.isEmpty() && (pair2 = mapC.get(str2)) != null && ((Integer) pair2.first).intValue() > 0) {
                    Long lValueOf2 = this.i.get("day_" + i + "_" + str2);
                    if (lValueOf2 == null && (listA2 = this.q.a(str2, "format")) != null && !listA2.isEmpty()) {
                        lValueOf2 = Long.valueOf(listA2.size());
                        this.i.put("day_" + i + "_" + str2, lValueOf2);
                    }
                    if (lValueOf2 != null && lValueOf2.longValue() >= ((Integer) pair2.first).intValue()) {
                        new StringBuilder("placement imp filter day by format:").append(lValueOf2).append(":").append(pair2.first);
                        return 8;
                    }
                }
            }
            String str3 = "placement_id";
            if (j > 0) {
                Long lValueOf3 = this.j.get("day_" + i + "_" + str);
                if (lValueOf3 == null && (listA = this.q.a(str, "placement_id")) != null && !listA.isEmpty()) {
                    lValueOf3 = Long.valueOf(listA.size());
                    this.j.put("day_" + i + "_" + str, lValueOf3);
                }
                if (lValueOf3 != null && lValueOf3.longValue() >= j) {
                    new StringBuilder("placement imp filter day by placementId:").append(lValueOf3);
                    return 2;
                }
            }
            a aVar2 = this.u;
            if (aVar2 != null) {
                if (aVar2.a() > 0) {
                    String strP2 = t.b().p();
                    if (!TextUtils.isEmpty(strP2)) {
                        Long lValueOf4 = this.h.get("hour_".concat(String.valueOf(i2)));
                        if (lValueOf4 == null && (listB3 = this.q.b(strP2, com.anythink.core.common.e.a.C0080a.c)) != null && !listB3.isEmpty()) {
                            lValueOf4 = Long.valueOf(listB3.size());
                            this.h.put("hour_".concat(String.valueOf(i2)), lValueOf4);
                        }
                        if (lValueOf4 != null) {
                            if (lValueOf4.longValue() >= this.u.a()) {
                                new StringBuilder("placement imp filter hour by global:").append(lValueOf4);
                                this.u.a();
                                return 9;
                            }
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC2 = this.u.c();
                if (mapC2 != null && !mapC2.isEmpty() && (pair = mapC2.get(str2)) != null && ((Integer) pair.first).intValue() > 0) {
                    Long lValueOf5 = this.i.get("hour_" + i2 + "_" + str2);
                    if (lValueOf5 == null && (listB2 = this.q.b(str2, "format")) != null && !listB2.isEmpty()) {
                        lValueOf5 = Long.valueOf(listB2.size());
                        this.i.put("hour_" + i2 + "_" + str2, lValueOf5);
                    }
                    if (lValueOf5 != null && lValueOf5.longValue() >= ((Integer) pair.first).intValue()) {
                        new StringBuilder("placement imp filter hour by format:").append(lValueOf5).append(":").append(pair.first);
                        return 10;
                    }
                }
            } else {
                str3 = "placement_id";
            }
            if (j2 > 0) {
                Long lValueOf6 = this.j.get("hour_" + i2 + "_" + str);
                if (lValueOf6 == null && (listB = this.q.b(str, str3)) != null && !listB.isEmpty()) {
                    lValueOf6 = Long.valueOf(listB.size());
                    this.j.put("hour_" + i2 + "_" + str, lValueOf6);
                }
                if (lValueOf6 != null && lValueOf6.longValue() >= j2) {
                    new StringBuilder("placement imp filter hour by placementId:").append(lValueOf6);
                    return 2;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final int a(String str, String str2, long j) {
        f fVarC;
        Pair<Integer, Integer> pair;
        f fVarC2;
        f fVarC3;
        try {
            a aVar = this.v;
            if (aVar != null) {
                if (aVar.b() > 0) {
                    String strP = t.b().p();
                    if (!TextUtils.isEmpty(strP)) {
                        Long lValueOf = this.h.get(com.anythink.core.common.e.a.C0080a.m);
                        if (lValueOf == null && (fVarC3 = this.q.c(strP, com.anythink.core.common.e.a.C0080a.c)) != null) {
                            lValueOf = Long.valueOf(fVarC3.i());
                            this.h.put(com.anythink.core.common.e.a.C0080a.m, lValueOf);
                        }
                        if (lValueOf != null && System.currentTimeMillis() - lValueOf.longValue() < this.v.b()) {
                            this.v.b();
                            return 11;
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.v.c();
                if (mapC != null && !mapC.isEmpty() && (pair = mapC.get(str2)) != null && ((Integer) pair.second).intValue() > 0) {
                    Long lValueOf2 = this.i.get("time_stamp_".concat(String.valueOf(str2)));
                    if (lValueOf2 == null && (fVarC2 = this.q.c(str2, "format")) != null) {
                        lValueOf2 = Long.valueOf(fVarC2.i());
                        this.i.put("time_stamp_".concat(String.valueOf(str2)), lValueOf2);
                    }
                    if (lValueOf2 != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - lValueOf2.longValue();
                        if (jCurrentTimeMillis < ((Integer) pair.second).intValue()) {
                            new StringBuilder("placement imp filter second by format:").append(jCurrentTimeMillis).append(":").append(pair.second);
                            return 12;
                        }
                    }
                }
            }
            if (j > 0) {
                Long lValueOf3 = this.j.get("time_stamp_".concat(String.valueOf(str)));
                if (lValueOf3 == null && (fVarC = this.q.c(str, "placement_id")) != null) {
                    lValueOf3 = Long.valueOf(fVarC.i());
                    this.j.put("time_stamp_".concat(String.valueOf(str)), lValueOf3);
                }
                if (lValueOf3 != null && System.currentTimeMillis() - lValueOf3.longValue() < j) {
                    return 3;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0392  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c7  */
    public final int a(String str, String str2, String str3, long j, long j2) {
        String str4;
        long j3;
        List<f> listB;
        Pair<Integer, Integer> pair;
        List<f> listB2;
        Pair<Integer, Integer> pair2;
        List<f> listB3;
        List<f> listA;
        Pair<Integer, Integer> pair3;
        String str5;
        Pair<Integer, Integer> pair4;
        List<f> listA2;
        try {
            Date date = new Date();
            int i = Integer.parseInt(b(date));
            int i2 = Integer.parseInt(c(date));
            a aVar = this.t;
            String str6 = "network_id";
            if (aVar != null) {
                Map<String, Pair<Integer, Integer>> mapD = aVar.d();
                if (mapD != null && !mapD.isEmpty() && (pair4 = mapD.get(str)) != null && ((Integer) pair4.first).intValue() > 0) {
                    Long lValueOf = this.k.get("day_" + i + "_" + str);
                    if (lValueOf == null && (listA2 = this.q.a(str, "network_id")) != null && !listA2.isEmpty()) {
                        lValueOf = Long.valueOf(listA2.size());
                        this.k.put("day_" + i + "_" + str, lValueOf);
                    }
                    if (lValueOf != null) {
                        if (lValueOf.longValue() >= ((Integer) pair4.first).intValue()) {
                            new StringBuilder("adSource imp filter day by network:").append(lValueOf).append(":").append(pair4.first);
                            return 8;
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE = this.t.e();
                if (mapE != null && !mapE.isEmpty() && (pair3 = mapE.get(str + "_" + str3)) != null && ((Integer) pair3.first).intValue() > 0) {
                    Long lValueOf2 = this.l.get("day_" + i + "_" + str + "_" + str3);
                    if (lValueOf2 == null) {
                        str5 = com.anythink.core.common.e.a.C0080a.f;
                        List<f> listA3 = this.q.a(str + "_" + str3, str5);
                        if (listA3 != null && !listA3.isEmpty()) {
                            lValueOf2 = Long.valueOf(listA3.size());
                            this.l.put("day_" + i + "_" + str + "_" + str3, lValueOf2);
                        }
                    } else {
                        str5 = str4;
                    }
                    if (lValueOf2 != null) {
                        str4 = str5;
                        if (lValueOf2.longValue() >= ((Integer) pair3.first).intValue()) {
                            new StringBuilder("adSource imp filter day by network_format:").append(lValueOf2).append(":").append(pair3.first);
                            return 9;
                        }
                    } else {
                        str4 = str5;
                    }
                }
            } else {
                str4 = com.anythink.core.common.e.a.C0080a.f;
                str6 = "network_id";
            }
            String str7 = com.anythink.core.common.e.a.C0080a.h;
            if (j > 0) {
                Long lValueOf3 = this.m.get("day_" + i + "_" + str2);
                if (lValueOf3 == null && (listA = this.q.a(str2, com.anythink.core.common.e.a.C0080a.h)) != null && !listA.isEmpty()) {
                    lValueOf3 = Long.valueOf(listA.size());
                    this.m.put("day_" + i + "_" + str2, lValueOf3);
                }
                if (lValueOf3 != null && lValueOf3.longValue() >= j) {
                    new StringBuilder("adSource imp filter day by adSourceId:").append(lValueOf3);
                    return 2;
                }
            }
            a aVar2 = this.u;
            if (aVar2 != null) {
                Map<String, Pair<Integer, Integer>> mapD2 = aVar2.d();
                if (mapD2 != null && !mapD2.isEmpty() && (pair2 = mapD2.get(str)) != null && ((Integer) pair2.first).intValue() > 0) {
                    Long lValueOf4 = this.k.get("hour_" + i2 + "_" + str);
                    if (lValueOf4 == null && (listB3 = this.q.b(str, str6)) != null && !listB3.isEmpty()) {
                        lValueOf4 = Long.valueOf(listB3.size());
                        this.k.put("hour_" + i2 + "_" + str, lValueOf4);
                    }
                    if (lValueOf4 != null && lValueOf4.longValue() >= ((Integer) pair2.first).intValue()) {
                        new StringBuilder("adSource imp filter hour by network:").append(lValueOf4).append(":").append(pair2.first);
                        return 10;
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE2 = this.u.e();
                if (mapE2 != null && !mapE2.isEmpty() && (pair = mapE2.get(str + "_" + str3)) != null && ((Integer) pair.first).intValue() > 0) {
                    Long lValueOf5 = this.l.get("hour_" + i2 + "_" + str + "_" + str3);
                    if (lValueOf5 == null && (listB2 = this.q.b(str + "_" + str3, str4)) != null && !listB2.isEmpty()) {
                        lValueOf5 = Long.valueOf(listB2.size());
                        this.l.put("hour_" + i2 + "_" + str + "_" + str3, lValueOf5);
                    }
                    if (lValueOf5 != null) {
                        if (lValueOf5.longValue() >= ((Integer) pair.first).intValue()) {
                            new StringBuilder("adSource imp filter hour by network_format:").append(lValueOf5).append(":").append(pair.first);
                            return 11;
                        }
                    }
                }
                j3 = 0;
            } else {
                str7 = com.anythink.core.common.e.a.C0080a.h;
                j3 = 0;
            }
            if (j2 > j3) {
                Long lValueOf6 = this.m.get("hour_" + i2 + "_" + str2);
                if (lValueOf6 == null && (listB = this.q.b(str2, str7)) != null && !listB.isEmpty()) {
                    lValueOf6 = Long.valueOf(listB.size());
                    this.m.put("hour_" + i2 + "_" + str2, lValueOf6);
                }
                if (lValueOf6 != null && lValueOf6.longValue() >= j2) {
                    new StringBuilder("adSource imp filter hour by adSourceId:").append(lValueOf6);
                    return 2;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final int a(String str, String str2, String str3, long j) {
        f fVarC;
        Pair<Integer, Integer> pair;
        f fVarC2;
        Pair<Integer, Integer> pair2;
        f fVarC3;
        try {
            a aVar = this.v;
            if (aVar != null) {
                Map<String, Pair<Integer, Integer>> mapD = aVar.d();
                if (mapD != null && !mapD.isEmpty() && (pair2 = mapD.get(str)) != null && ((Integer) pair2.second).intValue() > 0) {
                    Long lValueOf = this.k.get("time_stamp_".concat(String.valueOf(str)));
                    if (lValueOf == null && (fVarC3 = this.q.c(str, "network_id")) != null) {
                        lValueOf = Long.valueOf(fVarC3.i());
                        this.k.put("time_stamp_".concat(String.valueOf(str)), lValueOf);
                    }
                    if (lValueOf != null && System.currentTimeMillis() - lValueOf.longValue() < ((Integer) pair2.second).intValue()) {
                        new StringBuilder("adSource imp filter second by network:").append(lValueOf).append(":").append(pair2.second);
                        return 12;
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE = this.v.e();
                if (mapE != null && !mapE.isEmpty() && (pair = mapE.get(str + "_" + str3)) != null && ((Integer) pair.second).intValue() > 0) {
                    Long lValueOf2 = this.l.get("time_stamp_" + str + "_" + str3);
                    if (lValueOf2 == null && (fVarC2 = this.q.c(str + "_" + str3, com.anythink.core.common.e.a.C0080a.f)) != null) {
                        lValueOf2 = Long.valueOf(fVarC2.i());
                        this.l.put("time_stamp_" + str + "_" + str3, lValueOf2);
                    }
                    if (lValueOf2 != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - lValueOf2.longValue();
                        if (jCurrentTimeMillis < ((Integer) pair.second).intValue()) {
                            new StringBuilder("adSource imp filter second by network_format:").append(jCurrentTimeMillis).append(":").append(pair.second);
                            return 13;
                        }
                    }
                }
            }
            if (j > 0) {
                Long lValueOf3 = this.m.get("time_stamp_".concat(String.valueOf(str2)));
                if (lValueOf3 == null && (fVarC = this.q.c(str2, com.anythink.core.common.e.a.C0080a.h)) != null) {
                    lValueOf3 = Long.valueOf(fVarC.i());
                    this.j.put("time_stamp_".concat(String.valueOf(str2)), lValueOf3);
                }
                if (lValueOf3 != null && System.currentTimeMillis() - lValueOf3.longValue() < j) {
                    return 3;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final void a(int i, String str, String str2, String str3) {
        try {
            String strP = t.b().p();
            Date date = new Date();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i2 = Integer.parseInt(a(date));
            int i3 = Integer.parseInt(b(date));
            int i4 = Integer.parseInt(c(date));
            this.q.a(new f("2", strP, String.valueOf(i), str, i + "_" + str, str2, str3, i2, i3, i4, jCurrentTimeMillis));
            a(1, this.t, this.h, "day_".concat(String.valueOf(i3)), jCurrentTimeMillis);
            a(1, this.t, this.i, "day_" + i3 + "_" + str, jCurrentTimeMillis);
            a(1, this.t, this.k, "day_" + i3 + "_" + i, jCurrentTimeMillis);
            a(1, this.t, this.l, "day_" + i3 + "_" + i + "_" + str, jCurrentTimeMillis);
            a(1, this.j, "day_" + i3 + "_" + str2, jCurrentTimeMillis);
            a(1, this.m, "day_" + i3 + "_" + str3, jCurrentTimeMillis);
            a(1, this.u, this.h, "hour_".concat(String.valueOf(i4)), jCurrentTimeMillis);
            a(1, this.u, this.i, "hour_" + i4 + "_" + str, jCurrentTimeMillis);
            a(1, this.u, this.k, "hour_" + i4 + "_" + i, jCurrentTimeMillis);
            a(1, this.u, this.l, "hour_" + i4 + "_" + i + "_" + str, jCurrentTimeMillis);
            a(1, this.j, "hour_" + i4 + "_" + str2, jCurrentTimeMillis);
            a(1, this.m, "hour_" + i4 + "_" + str3, jCurrentTimeMillis);
            a(2, this.v, this.h, com.anythink.core.common.e.a.C0080a.m, jCurrentTimeMillis);
            a(2, this.v, this.i, "time_stamp_".concat(String.valueOf(str)), jCurrentTimeMillis);
            a(2, this.v, this.k, "time_stamp_".concat(String.valueOf(i)), jCurrentTimeMillis);
            a(2, this.v, this.l, "time_stamp_" + i + "_" + str, jCurrentTimeMillis);
            a(2, this.j, "time_stamp_".concat(String.valueOf(str2)), jCurrentTimeMillis);
            a(2, this.m, "time_stamp_".concat(String.valueOf(str3)), jCurrentTimeMillis);
        } catch (Throwable unused) {
        }
    }

    private static void a(int i, a aVar, ConcurrentHashMap<String, Long> concurrentHashMap, String str, long j) {
        long jValueOf;
        new StringBuilder("memory saveGlobalOrFormatOrNetwork:").append(i).append(":").append(str).append(":").append(j).append(":").append(aVar);
        if (concurrentHashMap != null) {
            if (i == 2) {
                concurrentHashMap.put(str, Long.valueOf(j));
                return;
            }
            Long l = concurrentHashMap.get(str);
            if (l == null) {
                jValueOf = 1L;
            } else {
                jValueOf = Long.valueOf(l.longValue() + 1);
            }
            concurrentHashMap.put(str, jValueOf);
        }
    }

    private static void a(int i, ConcurrentHashMap<String, Long> concurrentHashMap, String str, long j) {
        long jValueOf;
        new StringBuilder("memory savePlacementOrAdSource:").append(i).append(":").append(str).append(":").append(j).append(":").append(concurrentHashMap);
        if (concurrentHashMap != null) {
            if (i == 2) {
                concurrentHashMap.put(str, Long.valueOf(j));
                return;
            }
            Long l = concurrentHashMap.get(str);
            if (l == null) {
                jValueOf = 1L;
            } else {
                jValueOf = Long.valueOf(l.longValue() + 1);
            }
            concurrentHashMap.put(str, jValueOf);
        }
    }

    private e f() {
        if (this.s == null) {
            synchronized (this.r) {
                this.s = new e(this.q);
            }
        }
        return this.s;
    }

    public final void a(bv bvVar) {
        if (bvVar.bv() == null || this.q == null) {
            return;
        }
        f().d(bvVar);
    }

    public final com.anythink.core.common.h.k b(bv bvVar) {
        if (bvVar.bv() == null || this.q == null) {
            return null;
        }
        return f().b(bvVar);
    }

    public final void c(bv bvVar) {
        if (bvVar.bv() == null || this.q == null) {
            return;
        }
        f().c(bvVar);
    }

    public final void d(bv bvVar) {
        if (bvVar.bv() == null || this.q == null) {
            return;
        }
        f().a(bvVar);
    }

    public static class a {
        private int a;
        private int b;
        private Map<String, Pair<Integer, Integer>> c;
        private Map<String, Pair<Integer, Integer>> d;
        private Map<String, Pair<Integer, Integer>> e;

        public final void a(int i) {
            this.a = i;
        }

        public final void b(int i) {
            this.b = i;
        }

        public final void a(Map<String, Pair<Integer, Integer>> map) {
            this.c = map;
        }

        public final void b(Map<String, Pair<Integer, Integer>> map) {
            this.d = map;
        }

        public final void c(Map<String, Pair<Integer, Integer>> map) {
            this.e = map;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final Map<String, Pair<Integer, Integer>> c() {
            return this.c;
        }

        public final Map<String, Pair<Integer, Integer>> d() {
            return this.d;
        }

        public final Map<String, Pair<Integer, Integer>> e() {
            return this.e;
        }
    }

    private static a b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        if (jSONObject == null) {
            return null;
        }
        try {
            a aVar = new a();
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("format");
            if (jSONObjectOptJSONObject5 != null) {
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObjectOptJSONObject5.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject4 = jSONObjectOptJSONObject5.optJSONObject(next)) != null) {
                        int iOptInt = jSONObjectOptJSONObject4.optInt("max_num");
                        int iOptInt2 = jSONObjectOptJSONObject4.optInt("per_second");
                        if (iOptInt != 0 || iOptInt2 != 0) {
                            map.put(next, new Pair<>(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2)));
                        }
                    }
                }
                if (!map.isEmpty()) {
                    aVar.a(map);
                }
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("nw");
            if (jSONObjectOptJSONObject6 != null) {
                HashMap map2 = new HashMap();
                Iterator<String> itKeys2 = jSONObjectOptJSONObject6.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (!TextUtils.isEmpty(next2) && (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject6.optJSONObject(next2)) != null) {
                        int iOptInt3 = jSONObjectOptJSONObject3.optInt("max_num");
                        int iOptInt4 = jSONObjectOptJSONObject3.optInt("per_second");
                        if (iOptInt3 != 0 || iOptInt4 != 0) {
                            map2.put(next2, new Pair<>(Integer.valueOf(iOptInt3), Integer.valueOf(iOptInt4)));
                        }
                    }
                }
                if (!map2.isEmpty()) {
                    aVar.b(map2);
                }
            }
            JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("nw_format");
            if (jSONObjectOptJSONObject7 != null) {
                HashMap map3 = new HashMap();
                Iterator<String> itKeys3 = jSONObjectOptJSONObject7.keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    if (!TextUtils.isEmpty(next3) && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject7.optJSONObject(next3)) != null) {
                        int iOptInt5 = jSONObjectOptJSONObject2.optInt("max_num");
                        int iOptInt6 = jSONObjectOptJSONObject2.optInt("per_second");
                        if (iOptInt5 != 0 || iOptInt6 != 0) {
                            map3.put(next3, new Pair<>(Integer.valueOf(iOptInt5), Integer.valueOf(iOptInt6)));
                        }
                    }
                }
                if (!map3.isEmpty()) {
                    aVar.c(map3);
                }
            }
            JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("global");
            if (jSONObjectOptJSONObject8 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject8.optJSONObject("global")) != null) {
                int iOptInt7 = jSONObjectOptJSONObject.optInt("max_num");
                if (iOptInt7 != 0) {
                    aVar.a(iOptInt7);
                }
                int iOptInt8 = jSONObjectOptJSONObject.optInt("per_second");
                if (iOptInt8 != 0) {
                    aVar.b(iOptInt8);
                }
            }
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
