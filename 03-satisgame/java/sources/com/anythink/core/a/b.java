package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.f;
import com.anythink.core.common.k;
import com.anythink.core.e.l;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b o;
    private volatile a A;
    private volatile a B;
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
    private final com.anythink.core.common.f.a q;
    private volatile e x;
    private volatile a y;
    private volatile a z;
    private static final ThreadLocal<SimpleDateFormat> p = new ThreadLocal<SimpleDateFormat>() { // from class: com.anythink.core.a.b.1
        private static SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static int n = -1;
    final String a = "b";
    private volatile int r = -1;
    private volatile int s = -1;
    private volatile String t = "";
    private volatile long u = 0;
    private volatile long v = 0;
    private final Object w = new Object();

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

    private com.anythink.core.common.f.a a() {
        return this.q;
    }

    private b(Context context) {
        this.q = com.anythink.core.common.f.a.a(com.anythink.core.common.f.d.a(context));
        b();
        try {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.q, new AnonymousClass2(a(new Date()), b(new Date()))));
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
        return p.get().format(date).substring(5, 7);
    }

    public static String b(Date date) {
        return p.get().format(date).substring(8, 10);
    }

    public static String c(Date date) {
        return p.get().format(date).substring(11, 13);
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis >= this.v || jCurrentTimeMillis - this.u > 60000) {
            synchronized (this.w) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 >= this.v || jCurrentTimeMillis2 - this.u > 60000) {
                    Date date = new Date(jCurrentTimeMillis2);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(jCurrentTimeMillis2);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    calendar.set(14, 0);
                    calendar.add(11, 1);
                    this.r = Integer.parseInt(b(date));
                    this.s = Integer.parseInt(c(date));
                    this.t = a(date);
                    this.u = jCurrentTimeMillis2;
                    this.v = calendar.getTimeInMillis();
                }
            }
        }
    }

    private int c() {
        b();
        return this.r;
    }

    private int d() {
        b();
        return this.s;
    }

    /* JADX INFO: renamed from: com.anythink.core.a.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass2(String str, String str2) {
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
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.q, new AnonymousClass2(str, str2)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(k.B);
                if (jSONObjectOptJSONObject != null) {
                    this.y = b(jSONObjectOptJSONObject);
                } else if (this.y != null) {
                    this.y = null;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(k.C);
                if (jSONObjectOptJSONObject2 != null) {
                    this.z = b(jSONObjectOptJSONObject2);
                } else if (this.z != null) {
                    this.z = null;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("caps_s");
                if (jSONObjectOptJSONObject3 != null) {
                    this.A = b(jSONObjectOptJSONObject3);
                } else if (this.A != null) {
                    this.A = null;
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("req_pace");
                if (jSONObjectOptJSONObject4 != null) {
                    this.B = b(jSONObjectOptJSONObject4);
                    return;
                } else {
                    if (this.B != null) {
                        this.B = null;
                    }
                    return;
                }
            }
            if (this.y != null) {
                this.y = null;
            }
            if (this.z != null) {
                this.z = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.B != null) {
                this.B = null;
            }
        } catch (Throwable unused) {
        }
    }

    private ConcurrentHashMap<String, f> e() {
        return this.c;
    }

    public final int a(String str) {
        Pair<Integer, Integer> pair;
        f fVar;
        f fVar2;
        try {
            if (this.B != null) {
                if (this.B.a() > 0 && this.B.b() > 0) {
                    String strP = s.b().p();
                    if (!TextUtils.isEmpty(strP) && (fVar2 = this.b.get(strP)) != null && fVar2.a >= this.B.a() && System.currentTimeMillis() - fVar2.i() <= this.B.b()) {
                        return 9;
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.B.c();
                if (mapC != null && !mapC.isEmpty() && (pair = mapC.get(str)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0 && (fVar = this.d.get(str)) != null && fVar.a >= ((Integer) pair.first).intValue() && System.currentTimeMillis() - fVar.i() <= ((Integer) pair.second).intValue()) {
                    return 10;
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
                f fVar = this.c.get(str);
                if (fVar != null && fVar.a >= i && System.currentTimeMillis() - fVar.i() <= j) {
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
            if (this.B != null) {
                if (this.B.a() > 0 && this.B.b() > 0) {
                    String strP = s.b().p();
                    if (!TextUtils.isEmpty(strP)) {
                        f fVar = this.b.get(strP);
                        if (fVar != null) {
                            synchronized (fVar) {
                                if (System.currentTimeMillis() - fVar.i() > this.B.b()) {
                                    fVar.a(System.currentTimeMillis());
                                    fVar.a = 1;
                                } else {
                                    fVar.a++;
                                }
                            }
                        } else {
                            f fVar2 = new f("1", strP, com.anythink.core.common.f.a.C0017a.c, System.currentTimeMillis(), 1);
                            this.b.put(strP, fVar2);
                            fVar = fVar2;
                        }
                        this.q.b(strP, com.anythink.core.common.f.a.C0017a.c, fVar.a, fVar.i());
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.B.c();
                if (mapC != null && !mapC.isEmpty() && (pair = mapC.get(String.valueOf(i2))) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0) {
                    f fVar3 = this.d.get(String.valueOf(i2));
                    if (fVar3 != null) {
                        synchronized (fVar3) {
                            if (System.currentTimeMillis() - fVar3.i() > ((Integer) pair.second).intValue()) {
                                fVar3.a(System.currentTimeMillis());
                                fVar3.a = 1;
                            } else {
                                fVar3.a++;
                            }
                        }
                    } else {
                        fVar3 = new f("1", String.valueOf(i2), com.anythink.core.common.f.a.C0017a.d, System.currentTimeMillis(), 1);
                        this.d.put(String.valueOf(i2), fVar3);
                    }
                    this.q.b(String.valueOf(i2), com.anythink.core.common.f.a.C0017a.d, fVar3.a, fVar3.i());
                }
            }
            if (i <= 0 || j <= 0) {
                return;
            }
            f fVar4 = this.c.get(str);
            if (fVar4 != null) {
                synchronized (fVar4) {
                    if (System.currentTimeMillis() - fVar4.i() > j) {
                        fVar4.a(System.currentTimeMillis());
                        fVar4.a = 1;
                    } else {
                        fVar4.a++;
                    }
                }
            } else {
                fVar4 = new f("1", str, "placement_id", System.currentTimeMillis(), 1);
                this.c.put(str, fVar4);
            }
            this.q.b(str, "placement_id", fVar4.a, fVar4.i());
        } catch (Throwable unused) {
        }
    }

    private ConcurrentHashMap<String, f> f() {
        return this.f;
    }

    public final int a(int i, long j, int i2, String str, String str2) {
        f fVar;
        Pair<Integer, Integer> pair;
        f fVar2;
        Pair<Integer, Integer> pair2;
        f fVar3;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.B != null) {
                    Map<String, Pair<Integer, Integer>> mapD = this.B.d();
                    if (mapD != null && !mapD.isEmpty() && (pair2 = mapD.get(String.valueOf(i2))) != null && ((Integer) pair2.first).intValue() > 0 && ((Integer) pair2.second).intValue() > 0 && (fVar3 = this.e.get(String.valueOf(i2))) != null && fVar3.a >= ((Integer) pair2.first).intValue() && System.currentTimeMillis() - fVar3.i() <= ((Integer) pair2.second).intValue()) {
                        return 25;
                    }
                    Map<String, Pair<Integer, Integer>> mapE = this.B.e();
                    if (mapE != null && !mapE.isEmpty() && (pair = mapE.get(i2 + "_" + str2)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0 && (fVar2 = this.g.get(i2 + "_" + str2)) != null && fVar2.a >= ((Integer) pair.first).intValue() && System.currentTimeMillis() - fVar2.i() <= ((Integer) pair.second).intValue()) {
                        return 26;
                    }
                }
                if (i > 0 && j > 0 && (fVar = this.f.get(str)) != null && fVar.a >= i && System.currentTimeMillis() - fVar.i() <= j) {
                    return 18;
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
                if (this.B != null) {
                    Map<String, Pair<Integer, Integer>> mapD = this.B.d();
                    if (mapD != null && !mapD.isEmpty() && (pair2 = mapD.get(String.valueOf(i2))) != null && ((Integer) pair2.first).intValue() > 0 && ((Integer) pair2.second).intValue() > 0) {
                        f fVar = this.e.get(String.valueOf(i2));
                        if (fVar != null) {
                            synchronized (fVar) {
                                if (System.currentTimeMillis() - fVar.i() > ((Integer) pair2.second).intValue()) {
                                    fVar.a(System.currentTimeMillis());
                                    fVar.a = 1;
                                } else {
                                    fVar.a++;
                                }
                            }
                        } else {
                            f fVar2 = new f("1", String.valueOf(i2), "network_id", System.currentTimeMillis(), 1);
                            this.e.put(String.valueOf(i2), fVar2);
                            fVar = fVar2;
                        }
                        this.q.b(String.valueOf(i2), "network_id", fVar.a, fVar.i());
                    }
                    Map<String, Pair<Integer, Integer>> mapE = this.B.e();
                    if (mapE != null && !mapE.isEmpty() && (pair = mapE.get(i2 + "_" + str2)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0) {
                        f fVar3 = this.g.get(i2 + "_" + str2);
                        if (fVar3 != null) {
                            synchronized (fVar3) {
                                if (System.currentTimeMillis() - fVar3.i() > ((Integer) pair.second).intValue()) {
                                    fVar3.a(System.currentTimeMillis());
                                    fVar3.a = 1;
                                } else {
                                    fVar3.a++;
                                }
                            }
                        } else {
                            f fVar4 = new f("1", i2 + "_" + str2, com.anythink.core.common.f.a.C0017a.f, System.currentTimeMillis(), 1);
                            this.g.put(i2 + "_" + str2, fVar4);
                            fVar3 = fVar4;
                        }
                        this.q.b(i2 + "_" + str2, com.anythink.core.common.f.a.C0017a.f, fVar3.a, fVar3.i());
                    }
                }
                if (i <= 0 || j <= 0) {
                    return;
                }
                f fVar5 = this.f.get(str);
                if (fVar5 != null) {
                    synchronized (fVar5) {
                        if (System.currentTimeMillis() - fVar5.i() > j) {
                            fVar5.a(System.currentTimeMillis());
                            fVar5.a = 1;
                        } else {
                            fVar5.a++;
                        }
                    }
                } else {
                    fVar5 = new f("1", str, com.anythink.core.common.f.a.C0017a.h, System.currentTimeMillis(), 1);
                    this.f.put(str, fVar5);
                }
                this.q.b(str, com.anythink.core.common.f.a.C0017a.h, fVar5.a, fVar5.i());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConcurrentHashMap<String, Long> g() {
        return this.j;
    }

    private ConcurrentHashMap<String, Long> h() {
        return this.m;
    }

    public final int a(String str, String str2, long j, long j2) {
        Long l;
        Pair<Integer, Integer> pair;
        Long l2;
        Long l3;
        Long l4;
        Pair<Integer, Integer> pair2;
        Long l5;
        Long l6;
        try {
            int iC = c();
            int iD = d();
            if (this.y != null) {
                if (this.y.a() > 0 && (l6 = this.h.get("day_".concat(String.valueOf(iC)))) != null && l6.longValue() > 0 && l6.longValue() >= this.y.a()) {
                    return 7;
                }
                Map<String, Pair<Integer, Integer>> mapC = this.y.c();
                if (mapC != null && !mapC.isEmpty() && (pair2 = mapC.get(str2)) != null && ((Integer) pair2.first).intValue() > 0 && (l5 = this.i.get("day_" + iC + "_" + str2)) != null && l5.longValue() > 0 && l5.longValue() >= ((Integer) pair2.first).intValue()) {
                    return 8;
                }
            }
            if (j > 0 && (l4 = this.j.get("day_" + iC + "_" + str)) != null && l4.longValue() > 0 && l4.longValue() >= j) {
                return 2;
            }
            if (this.z != null) {
                if (this.z.a() > 0 && (l3 = this.h.get("hour_".concat(String.valueOf(iD)))) != null && l3.longValue() > 0 && l3.longValue() >= this.z.a()) {
                    return 9;
                }
                Map<String, Pair<Integer, Integer>> mapC2 = this.z.c();
                if (mapC2 != null && !mapC2.isEmpty() && (pair = mapC2.get(str2)) != null && ((Integer) pair.first).intValue() > 0 && (l2 = this.i.get("hour_" + iD + "_" + str2)) != null && l2.longValue() > 0 && l2.longValue() >= ((Integer) pair.first).intValue()) {
                    return 10;
                }
            }
            if (j2 > 0 && (l = this.j.get("hour_" + iD + "_" + str)) != null && l.longValue() > 0 && l.longValue() >= j2) {
                return 2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final int a(String str, String str2, long j) {
        Long l;
        Pair<Integer, Integer> pair;
        Long l2;
        Long l3;
        try {
            if (this.A != null) {
                if (this.A.b() > 0 && (l3 = this.h.get(com.anythink.core.common.f.a.C0017a.m)) != null && System.currentTimeMillis() - l3.longValue() < this.A.b()) {
                    return 11;
                }
                Map<String, Pair<Integer, Integer>> mapC = this.A.c();
                if (mapC != null && !mapC.isEmpty() && (pair = mapC.get(str2)) != null && ((Integer) pair.second).intValue() > 0 && (l2 = this.i.get("time_stamp_".concat(String.valueOf(str2)))) != null && System.currentTimeMillis() - l2.longValue() < ((Integer) pair.second).intValue()) {
                    return 12;
                }
            }
            if (j > 0 && (l = this.j.get("time_stamp_".concat(String.valueOf(str)))) != null && System.currentTimeMillis() - l.longValue() < j) {
                return 3;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final int a(String str, String str2, String str3, long j, long j2) {
        Long l;
        Pair<Integer, Integer> pair;
        Long l2;
        Pair<Integer, Integer> pair2;
        Long l3;
        Long l4;
        Pair<Integer, Integer> pair3;
        Long l5;
        Pair<Integer, Integer> pair4;
        Long l6;
        try {
            int iC = c();
            int iD = d();
            if (this.y != null) {
                Map<String, Pair<Integer, Integer>> mapD = this.y.d();
                if (mapD != null && !mapD.isEmpty() && (pair4 = mapD.get(str)) != null && ((Integer) pair4.first).intValue() > 0 && (l6 = this.k.get("day_" + iC + "_" + str)) != null && l6.longValue() > 0 && l6.longValue() >= ((Integer) pair4.first).intValue()) {
                    return 8;
                }
                Map<String, Pair<Integer, Integer>> mapE = this.y.e();
                if (mapE != null && !mapE.isEmpty() && (pair3 = mapE.get(str + "_" + str3)) != null && ((Integer) pair3.first).intValue() > 0 && (l5 = this.l.get("day_" + iC + "_" + str + "_" + str3)) != null && l5.longValue() > 0 && l5.longValue() >= ((Integer) pair3.first).intValue()) {
                    return 9;
                }
            }
            if (j > 0 && (l4 = this.m.get("day_" + iC + "_" + str2)) != null && l4.longValue() > 0 && l4.longValue() >= j) {
                return 2;
            }
            if (this.z != null) {
                Map<String, Pair<Integer, Integer>> mapD2 = this.z.d();
                if (mapD2 != null && !mapD2.isEmpty() && (pair2 = mapD2.get(str)) != null && ((Integer) pair2.first).intValue() > 0 && (l3 = this.k.get("hour_" + iD + "_" + str)) != null && l3.longValue() > 0 && l3.longValue() >= ((Integer) pair2.first).intValue()) {
                    return 10;
                }
                Map<String, Pair<Integer, Integer>> mapE2 = this.z.e();
                if (mapE2 != null && !mapE2.isEmpty() && (pair = mapE2.get(str + "_" + str3)) != null && ((Integer) pair.first).intValue() > 0 && (l2 = this.l.get("hour_" + iD + "_" + str + "_" + str3)) != null && l2.longValue() > 0 && l2.longValue() >= ((Integer) pair.first).intValue()) {
                    return 11;
                }
            }
            if (j2 > 0 && (l = this.m.get("hour_" + iD + "_" + str2)) != null && l.longValue() > 0 && l.longValue() >= j2) {
                return 2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final int a(String str, String str2, String str3, long j) {
        Long l;
        Pair<Integer, Integer> pair;
        Long l2;
        Pair<Integer, Integer> pair2;
        Long l3;
        try {
            if (this.A != null) {
                Map<String, Pair<Integer, Integer>> mapD = this.A.d();
                if (mapD != null && !mapD.isEmpty() && (pair2 = mapD.get(str)) != null && ((Integer) pair2.second).intValue() > 0 && (l3 = this.k.get("time_stamp_".concat(String.valueOf(str)))) != null && System.currentTimeMillis() - l3.longValue() < ((Integer) pair2.second).intValue()) {
                    return 12;
                }
                Map<String, Pair<Integer, Integer>> mapE = this.A.e();
                if (mapE != null && !mapE.isEmpty() && (pair = mapE.get(str + "_" + str3)) != null && ((Integer) pair.second).intValue() > 0 && (l2 = this.l.get("time_stamp_" + str + "_" + str3)) != null && System.currentTimeMillis() - l2.longValue() < ((Integer) pair.second).intValue()) {
                    return 13;
                }
            }
            if (j > 0 && (l = this.m.get("time_stamp_".concat(String.valueOf(str2)))) != null && System.currentTimeMillis() - l.longValue() < j) {
                return 3;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return n;
    }

    public final void a(String str, l lVar) {
        long j;
        f fVarC;
        Pair<Integer, Integer> pair;
        f fVarC2;
        f fVarC3;
        Pair<Integer, Integer> pair2;
        Pair<Integer, Integer> pair3;
        f fVarD;
        Pair<Integer, Integer> pair4;
        f fVarD2;
        f fVarD3;
        if (lVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strValueOf = String.valueOf(lVar.ap());
        int iAD = lVar.aD();
        long jAE = lVar.aE();
        try {
            if (this.B != null) {
                if (this.B.a() > 0 && this.B.b() > 0) {
                    String strP = s.b().p();
                    if (!TextUtils.isEmpty(strP) && !this.b.containsKey(strP) && (fVarD3 = this.q.d(strP, com.anythink.core.common.f.a.C0017a.c)) != null) {
                        this.b.put(strP, fVarD3);
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.B.c();
                if (mapC != null && (pair4 = mapC.get(strValueOf)) != null && ((Integer) pair4.first).intValue() > 0 && ((Integer) pair4.second).intValue() > 0 && !this.d.containsKey(strValueOf) && (fVarD2 = this.q.d(strValueOf, com.anythink.core.common.f.a.C0017a.d)) != null) {
                    this.d.put(strValueOf, fVarD2);
                }
            }
            if (iAD > 0 && jAE > 0 && !this.c.containsKey(str) && (fVarD = this.q.d(str, "placement_id")) != null) {
                this.c.put(str, fVarD);
            }
        } catch (Throwable unused) {
        }
        long jAu = lVar.au();
        long jAv = lVar.av();
        long jAw = lVar.aw();
        try {
            int iC = c();
            int iD = d();
            String strP2 = s.b().p();
            if (this.y != null) {
                if (this.y.a() <= 0 || TextUtils.isEmpty(strP2)) {
                    j = jAv;
                } else {
                    String strConcat = "day_".concat(String.valueOf(iC));
                    j = jAv;
                    if (!this.h.containsKey(strConcat)) {
                        Long lValueOf = Long.valueOf(this.q.a(strP2, com.anythink.core.common.f.a.C0017a.c));
                        if (lValueOf.longValue() > 0) {
                            this.h.put(strConcat, lValueOf);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC2 = this.y.c();
                if (mapC2 != null && (pair3 = mapC2.get(strValueOf)) != null && ((Integer) pair3.first).intValue() > 0) {
                    String str2 = "day_" + iC + "_" + strValueOf;
                    if (!this.i.containsKey(str2)) {
                        Long lValueOf2 = Long.valueOf(this.q.a(strValueOf, com.anythink.core.common.f.a.C0017a.d));
                        if (lValueOf2.longValue() > 0) {
                            this.i.put(str2, lValueOf2);
                        }
                    }
                }
            } else {
                j = jAv;
            }
            if (jAu > 0) {
                String str3 = "day_" + iC + "_" + str;
                if (!this.j.containsKey(str3)) {
                    Long lValueOf3 = Long.valueOf(this.q.a(str, "placement_id"));
                    if (lValueOf3.longValue() > 0) {
                        this.j.put(str3, lValueOf3);
                    }
                }
            }
            if (this.z != null) {
                if (this.z.a() > 0 && !TextUtils.isEmpty(strP2)) {
                    String strConcat2 = "hour_".concat(String.valueOf(iD));
                    if (!this.h.containsKey(strConcat2)) {
                        Long lValueOf4 = Long.valueOf(this.q.b(strP2, com.anythink.core.common.f.a.C0017a.c));
                        if (lValueOf4.longValue() > 0) {
                            this.h.put(strConcat2, lValueOf4);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC3 = this.z.c();
                if (mapC3 != null && (pair2 = mapC3.get(strValueOf)) != null && ((Integer) pair2.first).intValue() > 0) {
                    String str4 = "hour_" + iD + "_" + strValueOf;
                    if (!this.i.containsKey(str4)) {
                        Long lValueOf5 = Long.valueOf(this.q.b(strValueOf, com.anythink.core.common.f.a.C0017a.d));
                        if (lValueOf5.longValue() > 0) {
                            this.i.put(str4, lValueOf5);
                        }
                    }
                }
            }
            if (j > 0) {
                String str5 = "hour_" + iD + "_" + str;
                if (!this.j.containsKey(str5)) {
                    Long lValueOf6 = Long.valueOf(this.q.b(str, "placement_id"));
                    if (lValueOf6.longValue() > 0) {
                        this.j.put(str5, lValueOf6);
                    }
                }
            }
            if (this.A != null) {
                if (this.A.b() > 0 && !TextUtils.isEmpty(strP2) && !this.h.containsKey(com.anythink.core.common.f.a.C0017a.m) && (fVarC3 = this.q.c(strP2, com.anythink.core.common.f.a.C0017a.c)) != null) {
                    this.h.put(com.anythink.core.common.f.a.C0017a.m, Long.valueOf(fVarC3.i()));
                }
                Map<String, Pair<Integer, Integer>> mapC4 = this.A.c();
                if (mapC4 != null && (pair = mapC4.get(strValueOf)) != null && ((Integer) pair.second).intValue() > 0) {
                    String strConcat3 = "time_stamp_".concat(String.valueOf(strValueOf));
                    if (!this.i.containsKey(strConcat3) && (fVarC2 = this.q.c(strValueOf, com.anythink.core.common.f.a.C0017a.d)) != null) {
                        this.i.put(strConcat3, Long.valueOf(fVarC2.i()));
                    }
                }
            }
            if (jAw > 0) {
                String strConcat4 = "time_stamp_".concat(String.valueOf(str));
                if (this.j.containsKey(strConcat4) || (fVarC = this.q.c(str, "placement_id")) == null) {
                    return;
                }
                this.j.put(strConcat4, Long.valueOf(fVarC.i()));
            }
        } catch (Throwable unused2) {
        }
    }

    public final void a(by byVar, String str) {
        long j;
        f fVarC;
        Pair<Integer, Integer> pair;
        f fVarC2;
        Pair<Integer, Integer> pair2;
        f fVarC3;
        Pair<Integer, Integer> pair3;
        Pair<Integer, Integer> pair4;
        Pair<Integer, Integer> pair5;
        Pair<Integer, Integer> pair6;
        f fVarD;
        Pair<Integer, Integer> pair7;
        f fVarD2;
        Pair<Integer, Integer> pair8;
        f fVarD3;
        if (byVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strG = byVar.G();
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        int iN = byVar.n();
        int iBv = byVar.bv();
        long jBw = byVar.bw();
        try {
            if (!TextUtils.isEmpty(strG) && !TextUtils.isEmpty(str)) {
                String strValueOf = String.valueOf(iN);
                String str2 = iN + "_" + str;
                if (this.B != null) {
                    Map<String, Pair<Integer, Integer>> mapD = this.B.d();
                    if (mapD != null && (pair8 = mapD.get(strValueOf)) != null && ((Integer) pair8.first).intValue() > 0 && ((Integer) pair8.second).intValue() > 0 && !this.e.containsKey(strValueOf) && (fVarD3 = this.q.d(strValueOf, "network_id")) != null) {
                        this.e.put(strValueOf, fVarD3);
                    }
                    Map<String, Pair<Integer, Integer>> mapE = this.B.e();
                    if (mapE != null && (pair7 = mapE.get(str2)) != null && ((Integer) pair7.first).intValue() > 0 && ((Integer) pair7.second).intValue() > 0 && !this.g.containsKey(str2) && (fVarD2 = this.q.d(str2, com.anythink.core.common.f.a.C0017a.f)) != null) {
                        this.g.put(str2, fVarD2);
                    }
                }
                if (iBv > 0 && jBw > 0 && !this.f.containsKey(strG) && (fVarD = this.q.d(strG, com.anythink.core.common.f.a.C0017a.h)) != null) {
                    this.f.put(strG, fVarD);
                }
            }
        } catch (Throwable unused) {
        }
        String strValueOf2 = String.valueOf(iN);
        long jP = byVar.p();
        long jQ = byVar.q();
        long jF = byVar.F();
        try {
            int iC = c();
            int iD = d();
            String str3 = strValueOf2 + "_" + str;
            if (this.y != null) {
                Map<String, Pair<Integer, Integer>> mapD2 = this.y.d();
                if (mapD2 == null || (pair6 = mapD2.get(strValueOf2)) == null || ((Integer) pair6.first).intValue() <= 0) {
                    j = jQ;
                } else {
                    String str4 = "day_" + iC + "_" + strValueOf2;
                    j = jQ;
                    if (!this.k.containsKey(str4)) {
                        Long lValueOf = Long.valueOf(this.q.a(strValueOf2, "network_id"));
                        if (lValueOf.longValue() > 0) {
                            this.k.put(str4, lValueOf);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE2 = this.y.e();
                if (mapE2 != null && (pair5 = mapE2.get(str3)) != null && ((Integer) pair5.first).intValue() > 0) {
                    String str5 = "day_" + iC + "_" + str3;
                    if (!this.l.containsKey(str5)) {
                        Long lValueOf2 = Long.valueOf(this.q.a(str3, com.anythink.core.common.f.a.C0017a.f));
                        if (lValueOf2.longValue() > 0) {
                            this.l.put(str5, lValueOf2);
                        }
                    }
                }
            } else {
                j = jQ;
            }
            if (jP > 0) {
                String str6 = "day_" + iC + "_" + strG;
                if (!this.m.containsKey(str6)) {
                    Long lValueOf3 = Long.valueOf(this.q.a(strG, com.anythink.core.common.f.a.C0017a.h));
                    if (lValueOf3.longValue() > 0) {
                        this.m.put(str6, lValueOf3);
                    }
                }
            }
            if (this.z != null) {
                Map<String, Pair<Integer, Integer>> mapD3 = this.z.d();
                if (mapD3 != null && (pair4 = mapD3.get(strValueOf2)) != null && ((Integer) pair4.first).intValue() > 0) {
                    String str7 = "hour_" + iD + "_" + strValueOf2;
                    if (!this.k.containsKey(str7)) {
                        Long lValueOf4 = Long.valueOf(this.q.b(strValueOf2, "network_id"));
                        if (lValueOf4.longValue() > 0) {
                            this.k.put(str7, lValueOf4);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE3 = this.z.e();
                if (mapE3 != null && (pair3 = mapE3.get(str3)) != null && ((Integer) pair3.first).intValue() > 0) {
                    String str8 = "hour_" + iD + "_" + str3;
                    if (!this.l.containsKey(str8)) {
                        Long lValueOf5 = Long.valueOf(this.q.b(str3, com.anythink.core.common.f.a.C0017a.f));
                        if (lValueOf5.longValue() > 0) {
                            this.l.put(str8, lValueOf5);
                        }
                    }
                }
            }
            if (j > 0) {
                String str9 = "hour_" + iD + "_" + strG;
                if (!this.m.containsKey(str9)) {
                    Long lValueOf6 = Long.valueOf(this.q.b(strG, com.anythink.core.common.f.a.C0017a.h));
                    if (lValueOf6.longValue() > 0) {
                        this.m.put(str9, lValueOf6);
                    }
                }
            }
            if (this.A != null) {
                Map<String, Pair<Integer, Integer>> mapD4 = this.A.d();
                if (mapD4 != null && (pair2 = mapD4.get(strValueOf2)) != null && ((Integer) pair2.second).intValue() > 0) {
                    String strConcat = "time_stamp_".concat(String.valueOf(strValueOf2));
                    if (!this.k.containsKey(strConcat) && (fVarC3 = this.q.c(strValueOf2, "network_id")) != null) {
                        this.k.put(strConcat, Long.valueOf(fVarC3.i()));
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE4 = this.A.e();
                if (mapE4 != null && (pair = mapE4.get(str3)) != null && ((Integer) pair.second).intValue() > 0) {
                    String strConcat2 = "time_stamp_".concat(String.valueOf(str3));
                    if (!this.l.containsKey(strConcat2) && (fVarC2 = this.q.c(str3, com.anythink.core.common.f.a.C0017a.f)) != null) {
                        this.l.put(strConcat2, Long.valueOf(fVarC2.i()));
                    }
                }
            }
            if (jF > 0) {
                String strConcat3 = "time_stamp_".concat(String.valueOf(strG));
                if (this.m.containsKey(strConcat3) || (fVarC = this.q.c(strG, com.anythink.core.common.f.a.C0017a.h)) == null) {
                    return;
                }
                this.m.put(strConcat3, Long.valueOf(fVarC.i()));
            }
        } catch (Throwable unused2) {
        }
    }

    private void a(String str, String str2, int i, long j) {
        f fVarD;
        Pair<Integer, Integer> pair;
        f fVarD2;
        f fVarD3;
        try {
            if (this.B != null) {
                if (this.B.a() > 0 && this.B.b() > 0) {
                    String strP = s.b().p();
                    if (!TextUtils.isEmpty(strP) && !this.b.containsKey(strP) && (fVarD3 = this.q.d(strP, com.anythink.core.common.f.a.C0017a.c)) != null) {
                        this.b.put(strP, fVarD3);
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.B.c();
                if (mapC != null && (pair = mapC.get(str2)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0 && !this.d.containsKey(str2) && (fVarD2 = this.q.d(str2, com.anythink.core.common.f.a.C0017a.d)) != null) {
                    this.d.put(str2, fVarD2);
                }
            }
            if (i <= 0 || j <= 0 || this.c.containsKey(str) || (fVarD = this.q.d(str, "placement_id")) == null) {
                return;
            }
            this.c.put(str, fVarD);
        } catch (Throwable unused) {
        }
    }

    private void a(int i, String str, String str2, int i2, long j) {
        f fVarD;
        Pair<Integer, Integer> pair;
        f fVarD2;
        Pair<Integer, Integer> pair2;
        f fVarD3;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String strValueOf = String.valueOf(i);
                String str3 = i + "_" + str2;
                if (this.B != null) {
                    Map<String, Pair<Integer, Integer>> mapD = this.B.d();
                    if (mapD != null && (pair2 = mapD.get(strValueOf)) != null && ((Integer) pair2.first).intValue() > 0 && ((Integer) pair2.second).intValue() > 0 && !this.e.containsKey(strValueOf) && (fVarD3 = this.q.d(strValueOf, "network_id")) != null) {
                        this.e.put(strValueOf, fVarD3);
                    }
                    Map<String, Pair<Integer, Integer>> mapE = this.B.e();
                    if (mapE != null && (pair = mapE.get(str3)) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) pair.second).intValue() > 0 && !this.g.containsKey(str3) && (fVarD2 = this.q.d(str3, com.anythink.core.common.f.a.C0017a.f)) != null) {
                        this.g.put(str3, fVarD2);
                    }
                }
                if (i2 <= 0 || j <= 0 || this.f.containsKey(str) || (fVarD = this.q.d(str, com.anythink.core.common.f.a.C0017a.h)) == null) {
                    return;
                }
                this.f.put(str, fVarD);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(String str, String str2, long j, long j2, long j3) {
        f fVarC;
        Pair<Integer, Integer> pair;
        f fVarC2;
        f fVarC3;
        Pair<Integer, Integer> pair2;
        Pair<Integer, Integer> pair3;
        try {
            int iC = c();
            int iD = d();
            String strP = s.b().p();
            if (this.y != null) {
                if (this.y.a() > 0 && !TextUtils.isEmpty(strP)) {
                    String strConcat = "day_".concat(String.valueOf(iC));
                    if (!this.h.containsKey(strConcat)) {
                        Long lValueOf = Long.valueOf(this.q.a(strP, com.anythink.core.common.f.a.C0017a.c));
                        if (lValueOf.longValue() > 0) {
                            this.h.put(strConcat, lValueOf);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC = this.y.c();
                if (mapC != null && (pair3 = mapC.get(str2)) != null && ((Integer) pair3.first).intValue() > 0) {
                    String str3 = "day_" + iC + "_" + str2;
                    if (!this.i.containsKey(str3)) {
                        Long lValueOf2 = Long.valueOf(this.q.a(str2, com.anythink.core.common.f.a.C0017a.d));
                        if (lValueOf2.longValue() > 0) {
                            this.i.put(str3, lValueOf2);
                        }
                    }
                }
            }
            if (j > 0) {
                String str4 = "day_" + iC + "_" + str;
                if (!this.j.containsKey(str4)) {
                    Long lValueOf3 = Long.valueOf(this.q.a(str, "placement_id"));
                    if (lValueOf3.longValue() > 0) {
                        this.j.put(str4, lValueOf3);
                    }
                }
            }
            if (this.z != null) {
                if (this.z.a() > 0 && !TextUtils.isEmpty(strP)) {
                    String strConcat2 = "hour_".concat(String.valueOf(iD));
                    if (!this.h.containsKey(strConcat2)) {
                        Long lValueOf4 = Long.valueOf(this.q.b(strP, com.anythink.core.common.f.a.C0017a.c));
                        if (lValueOf4.longValue() > 0) {
                            this.h.put(strConcat2, lValueOf4);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapC2 = this.z.c();
                if (mapC2 != null && (pair2 = mapC2.get(str2)) != null && ((Integer) pair2.first).intValue() > 0) {
                    String str5 = "hour_" + iD + "_" + str2;
                    if (!this.i.containsKey(str5)) {
                        Long lValueOf5 = Long.valueOf(this.q.b(str2, com.anythink.core.common.f.a.C0017a.d));
                        if (lValueOf5.longValue() > 0) {
                            this.i.put(str5, lValueOf5);
                        }
                    }
                }
            }
            if (j2 > 0) {
                String str6 = "hour_" + iD + "_" + str;
                if (!this.j.containsKey(str6)) {
                    Long lValueOf6 = Long.valueOf(this.q.b(str, "placement_id"));
                    if (lValueOf6.longValue() > 0) {
                        this.j.put(str6, lValueOf6);
                    }
                }
            }
            if (this.A != null) {
                if (this.A.b() > 0 && !TextUtils.isEmpty(strP) && !this.h.containsKey(com.anythink.core.common.f.a.C0017a.m) && (fVarC3 = this.q.c(strP, com.anythink.core.common.f.a.C0017a.c)) != null) {
                    this.h.put(com.anythink.core.common.f.a.C0017a.m, Long.valueOf(fVarC3.i()));
                }
                Map<String, Pair<Integer, Integer>> mapC3 = this.A.c();
                if (mapC3 != null && (pair = mapC3.get(str2)) != null && ((Integer) pair.second).intValue() > 0) {
                    String strConcat3 = "time_stamp_".concat(String.valueOf(str2));
                    if (!this.i.containsKey(strConcat3) && (fVarC2 = this.q.c(str2, com.anythink.core.common.f.a.C0017a.d)) != null) {
                        this.i.put(strConcat3, Long.valueOf(fVarC2.i()));
                    }
                }
            }
            if (j3 > 0) {
                String strConcat4 = "time_stamp_".concat(String.valueOf(str));
                if (this.j.containsKey(strConcat4) || (fVarC = this.q.c(str, "placement_id")) == null) {
                    return;
                }
                this.j.put(strConcat4, Long.valueOf(fVarC.i()));
            }
        } catch (Throwable unused) {
        }
    }

    private void a(String str, String str2, String str3, long j, long j2, long j3) {
        f fVarC;
        Pair<Integer, Integer> pair;
        f fVarC2;
        Pair<Integer, Integer> pair2;
        f fVarC3;
        Pair<Integer, Integer> pair3;
        Pair<Integer, Integer> pair4;
        Pair<Integer, Integer> pair5;
        Pair<Integer, Integer> pair6;
        try {
            int iC = c();
            int iD = d();
            String str4 = str + "_" + str3;
            if (this.y != null) {
                Map<String, Pair<Integer, Integer>> mapD = this.y.d();
                if (mapD != null && (pair6 = mapD.get(str)) != null && ((Integer) pair6.first).intValue() > 0) {
                    String str5 = "day_" + iC + "_" + str;
                    if (!this.k.containsKey(str5)) {
                        Long lValueOf = Long.valueOf(this.q.a(str, "network_id"));
                        if (lValueOf.longValue() > 0) {
                            this.k.put(str5, lValueOf);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE = this.y.e();
                if (mapE != null && (pair5 = mapE.get(str4)) != null && ((Integer) pair5.first).intValue() > 0) {
                    String str6 = "day_" + iC + "_" + str4;
                    if (!this.l.containsKey(str6)) {
                        Long lValueOf2 = Long.valueOf(this.q.a(str4, com.anythink.core.common.f.a.C0017a.f));
                        if (lValueOf2.longValue() > 0) {
                            this.l.put(str6, lValueOf2);
                        }
                    }
                }
            }
            if (j > 0) {
                String str7 = "day_" + iC + "_" + str2;
                if (!this.m.containsKey(str7)) {
                    Long lValueOf3 = Long.valueOf(this.q.a(str2, com.anythink.core.common.f.a.C0017a.h));
                    if (lValueOf3.longValue() > 0) {
                        this.m.put(str7, lValueOf3);
                    }
                }
            }
            if (this.z != null) {
                Map<String, Pair<Integer, Integer>> mapD2 = this.z.d();
                if (mapD2 != null && (pair4 = mapD2.get(str)) != null && ((Integer) pair4.first).intValue() > 0) {
                    String str8 = "hour_" + iD + "_" + str;
                    if (!this.k.containsKey(str8)) {
                        Long lValueOf4 = Long.valueOf(this.q.b(str, "network_id"));
                        if (lValueOf4.longValue() > 0) {
                            this.k.put(str8, lValueOf4);
                        }
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE2 = this.z.e();
                if (mapE2 != null && (pair3 = mapE2.get(str4)) != null && ((Integer) pair3.first).intValue() > 0) {
                    String str9 = "hour_" + iD + "_" + str4;
                    if (!this.l.containsKey(str9)) {
                        Long lValueOf5 = Long.valueOf(this.q.b(str4, com.anythink.core.common.f.a.C0017a.f));
                        if (lValueOf5.longValue() > 0) {
                            this.l.put(str9, lValueOf5);
                        }
                    }
                }
            }
            if (j2 > 0) {
                String str10 = "hour_" + iD + "_" + str2;
                if (!this.m.containsKey(str10)) {
                    Long lValueOf6 = Long.valueOf(this.q.b(str2, com.anythink.core.common.f.a.C0017a.h));
                    if (lValueOf6.longValue() > 0) {
                        this.m.put(str10, lValueOf6);
                    }
                }
            }
            if (this.A != null) {
                Map<String, Pair<Integer, Integer>> mapD3 = this.A.d();
                if (mapD3 != null && (pair2 = mapD3.get(str)) != null && ((Integer) pair2.second).intValue() > 0) {
                    String strConcat = "time_stamp_".concat(String.valueOf(str));
                    if (!this.k.containsKey(strConcat) && (fVarC3 = this.q.c(str, "network_id")) != null) {
                        this.k.put(strConcat, Long.valueOf(fVarC3.i()));
                    }
                }
                Map<String, Pair<Integer, Integer>> mapE3 = this.A.e();
                if (mapE3 != null && (pair = mapE3.get(str4)) != null && ((Integer) pair.second).intValue() > 0) {
                    String strConcat2 = "time_stamp_".concat(String.valueOf(str4));
                    if (!this.l.containsKey(strConcat2) && (fVarC2 = this.q.c(str4, com.anythink.core.common.f.a.C0017a.f)) != null) {
                        this.l.put(strConcat2, Long.valueOf(fVarC2.i()));
                    }
                }
            }
            if (j3 > 0) {
                String strConcat3 = "time_stamp_".concat(String.valueOf(str2));
                if (this.m.containsKey(strConcat3) || (fVarC = this.q.c(str2, com.anythink.core.common.f.a.C0017a.h)) == null) {
                    return;
                }
                this.m.put(strConcat3, Long.valueOf(fVarC.i()));
            }
        } catch (Throwable unused) {
        }
    }

    private long a(String str, String str2, ConcurrentHashMap<String, Long> concurrentHashMap) {
        String str3 = "day_" + c() + "_" + str;
        Long lValueOf = concurrentHashMap.get(str3);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(this.q.a(str, str2));
            if (lValueOf.longValue() > 0) {
                concurrentHashMap.put(str3, lValueOf);
            }
        }
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    private long b(String str, String str2, ConcurrentHashMap<String, Long> concurrentHashMap) {
        String str3 = "hour_" + d() + "_" + str;
        Long lValueOf = concurrentHashMap.get(str3);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(this.q.b(str, str2));
            if (lValueOf.longValue() > 0) {
                concurrentHashMap.put(str3, lValueOf);
            }
        }
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    public final long b(String str) {
        return a(str, "placement_id", this.j);
    }

    public final long c(String str) {
        return b(str, "placement_id", this.j);
    }

    public final long d(String str) {
        return a(str, com.anythink.core.common.f.a.C0017a.h, this.m);
    }

    public final long e(String str) {
        return b(str, com.anythink.core.common.f.a.C0017a.h, this.m);
    }

    public final long f(String str) {
        return a(str, com.anythink.core.common.f.a.C0017a.d, this.i);
    }

    public final long g(String str) {
        return b(str, com.anythink.core.common.f.a.C0017a.d, this.i);
    }

    public final void a(int i, String str, String str2, String str3) {
        try {
            String strP = s.b().p();
            long jCurrentTimeMillis = System.currentTimeMillis();
            b();
            int i2 = Integer.parseInt(this.t);
            int i3 = this.r;
            int i4 = this.s;
            this.q.a(new f("2", strP, String.valueOf(i), str, i + "_" + str, str2, str3, i2, i3, i4, jCurrentTimeMillis));
            a(1, this.h, "day_".concat(String.valueOf(i3)), jCurrentTimeMillis);
            a(1, this.i, "day_" + i3 + "_" + str, jCurrentTimeMillis);
            a(1, this.k, "day_" + i3 + "_" + i, jCurrentTimeMillis);
            a(1, this.l, "day_" + i3 + "_" + i + "_" + str, jCurrentTimeMillis);
            b(1, this.j, "day_" + i3 + "_" + str2, jCurrentTimeMillis);
            b(1, this.m, "day_" + i3 + "_" + str3, jCurrentTimeMillis);
            a(1, this.h, "hour_".concat(String.valueOf(i4)), jCurrentTimeMillis);
            a(1, this.i, "hour_" + i4 + "_" + str, jCurrentTimeMillis);
            a(1, this.k, "hour_" + i4 + "_" + i, jCurrentTimeMillis);
            a(1, this.l, "hour_" + i4 + "_" + i + "_" + str, jCurrentTimeMillis);
            b(1, this.j, "hour_" + i4 + "_" + str2, jCurrentTimeMillis);
            b(1, this.m, "hour_" + i4 + "_" + str3, jCurrentTimeMillis);
            a(2, this.h, com.anythink.core.common.f.a.C0017a.m, jCurrentTimeMillis);
            a(2, this.i, "time_stamp_".concat(String.valueOf(str)), jCurrentTimeMillis);
            a(2, this.k, "time_stamp_".concat(String.valueOf(i)), jCurrentTimeMillis);
            a(2, this.l, "time_stamp_" + i + "_" + str, jCurrentTimeMillis);
            b(2, this.j, "time_stamp_".concat(String.valueOf(str2)), jCurrentTimeMillis);
            b(2, this.m, "time_stamp_".concat(String.valueOf(str3)), jCurrentTimeMillis);
        } catch (Throwable unused) {
        }
    }

    private static void a(int i, ConcurrentHashMap<String, Long> concurrentHashMap, String str, long j) {
        long jValueOf;
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

    private static void b(int i, ConcurrentHashMap<String, Long> concurrentHashMap, String str, long j) {
        long jValueOf;
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

    private e i() {
        if (this.x == null) {
            synchronized (this.w) {
                if (this.x == null) {
                    this.x = new e(this.q);
                }
            }
        }
        return this.x;
    }

    public final void a(by byVar) {
        if (byVar.bH() == null || this.q == null) {
            return;
        }
        i().d(byVar);
    }

    public final com.anythink.core.common.h.k b(by byVar) {
        if (byVar.bH() == null || this.q == null) {
            return null;
        }
        return i().b(byVar);
    }

    public final void c(by byVar) {
        if (byVar.bH() == null || this.q == null) {
            return;
        }
        i().c(byVar);
    }

    public final void d(by byVar) {
        if (byVar.bH() == null || this.q == null) {
            return;
        }
        i().a(byVar);
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
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject(com.anythink.core.common.f.a.C0017a.d);
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
