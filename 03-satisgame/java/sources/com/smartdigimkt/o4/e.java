package com.smartdigimkt.o4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.t2.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static volatile e d;
    public final Object a = new Object();
    public volatile com.smartdigimkt.p4.a b;
    public volatile boolean c;

    public static com.smartdigimkt.p4.a b() {
        com.smartdigimkt.a3.c cVar;
        try {
            ArrayList arrayListB = com.smartdigimkt.z2.e.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).b(SDKContext.getInstance().a());
            if (arrayListB != null && !arrayListB.isEmpty() && (cVar = (com.smartdigimkt.a3.c) arrayListB.get(0)) != null) {
                com.smartdigimkt.p4.a aVarC = com.smartdigimkt.p4.a.c(new JSONObject(cVar.a));
                if (aVarC != null) {
                    aVarC.i = Long.parseLong(cVar.b);
                }
                return aVarC;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static e c() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e();
                }
            }
        }
        return d;
    }

    public static com.smartdigimkt.p4.a d() {
        com.smartdigimkt.p4.a aVar = new com.smartdigimkt.p4.a();
        aVar.g = true;
        aVar.h = com.anythink.core.common.d.i.l.a;
        aVar.i = 0L;
        aVar.k = 1;
        aVar.l = 0L;
        aVar.j = "";
        aVar.n = 1;
        aVar.o = 0L;
        aVar.m = "";
        aVar.p = 30000L;
        aVar.q = 51200L;
        aVar.y = "[\"com.smartdigimkt\"]";
        aVar.x = 1;
        return aVar;
    }

    public static void e() {
        z zVarA = z.a();
        zVarA.getClass();
        com.smartdigimkt.i3.n.a().getClass();
        zVarA.e = com.smartdigimkt.i3.n.a(4);
        com.smartdigimkt.v2.p.c().getClass();
        com.smartdigimkt.p4.a aVarA = c().a();
        if (aVarA.g) {
            return;
        }
        com.smartdigimkt.v2.p pVarC = com.smartdigimkt.v2.p.c();
        long j = aVarA.Q * 1000;
        if (j > 0) {
            pVarC.r = j;
        } else {
            pVarC.getClass();
        }
        com.smartdigimkt.v2.p.c().a(aVarA.G, aVarA.H, aVarA.I, aVarA.a0, false);
    }

    public final com.smartdigimkt.p4.a a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = b();
                }
                if (this.b == null) {
                    this.b = d();
                }
            }
        }
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002c A[Catch: all -> 0x0032, TryCatch #0 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0012, B:15:0x001f, B:17:0x0030, B:16:0x002c), top: B:22:0x0008 }] */
    public final void a(com.smartdigimkt.h3.b bVar) {
        if (this.c) {
            return;
        }
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            if (this.b == null) {
                com.smartdigimkt.q3.f.a().getClass();
                if (com.smartdigimkt.q3.f.c()) {
                    com.smartdigimkt.q3.f.a().c(new a(this, bVar));
                } else {
                    a(false, bVar);
                }
            } else {
                a(false, bVar);
            }
        }
    }

    public final com.smartdigimkt.p4.a a(JSONObject jSONObject) {
        HashMap map;
        com.smartdigimkt.p4.a aVar = this.b;
        if (aVar != null && !aVar.g) {
            String strOptString = jSONObject.optString("cached");
            synchronized (aVar) {
                if (aVar.d == null) {
                    HashMap map2 = new HashMap();
                    aVar.d = map2;
                    HashMap map3 = aVar.b;
                    if (map3 != null) {
                        map2.putAll(map3);
                    }
                    HashMap map4 = aVar.c;
                    if (map4 != null) {
                        aVar.d.putAll(map4);
                    }
                }
                map = aVar.d;
            }
            if (!TextUtils.isEmpty(strOptString) && aVar.a != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString2 = jSONObject2.optString(next);
                        String str = (String) map.get(next);
                        jSONObject.put(next, aVar.a.opt(next));
                        if (!TextUtils.equals(strOptString2, str)) {
                            com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
                            cVar.a = "3000007";
                            if (!TextUtils.isEmpty(null)) {
                                cVar.c = null;
                            }
                            cVar.l = "1";
                            cVar.m = next;
                            cVar.n = strOptString2;
                            cVar.o = str;
                            com.smartdigimkt.n3.k.a(cVar);
                            jSONObject2.put(next, str);
                        }
                    }
                    jSONObject.put("cached", jSONObject2.toString());
                } catch (Throwable unused) {
                }
            }
            try {
                if (!TextUtils.isEmpty(aVar.S)) {
                    if (aVar.V == null) {
                        new ArrayList();
                    }
                    ArrayList arrayList = aVar.V;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (arrayList.size() > 0 && !TextUtils.equals(aVar.S, jSONObject.optString("at_a_cg", ""))) {
                        ArrayList arrayList2 = aVar.V;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            com.smartdigimkt.i3.n.a().a(com.smartdigimkt.r4.i.b((String) it.next()));
                        }
                    }
                }
                if (!TextUtils.isEmpty(aVar.T)) {
                    if (aVar.W == null) {
                        new ArrayList();
                    }
                    ArrayList arrayList3 = aVar.W;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    if (arrayList3.size() > 0 && !TextUtils.equals(aVar.T, jSONObject.optString("at_a_re", ""))) {
                        ArrayList arrayList4 = aVar.W;
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        Iterator it2 = arrayList4.iterator();
                        while (it2.hasNext()) {
                            com.smartdigimkt.i3.n.a().a(com.smartdigimkt.r4.i.b((String) it2.next()));
                        }
                    }
                }
                if (!TextUtils.isEmpty(aVar.U)) {
                    if (aVar.X == null) {
                        new ArrayList();
                    }
                    ArrayList arrayList5 = aVar.X;
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    if (arrayList5.size() > 0 && !TextUtils.equals(aVar.U, jSONObject.optString("at_a_rc", ""))) {
                        ArrayList arrayList6 = aVar.X;
                        if (arrayList6 == null) {
                            arrayList6 = new ArrayList();
                        }
                        Iterator it3 = arrayList6.iterator();
                        while (it3.hasNext()) {
                            com.smartdigimkt.i3.n.a().a(com.smartdigimkt.r4.i.b((String) it3.next()));
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        com.smartdigimkt.p4.a aVarC = com.smartdigimkt.p4.a.c(jSONObject);
        if (aVarC != null) {
            aVarC.i = System.currentTimeMillis();
        }
        com.smartdigimkt.q3.f.a().c(new d(this, jSONObject));
        return aVarC;
    }

    public final void a(boolean z, com.smartdigimkt.h3.b bVar) {
        com.smartdigimkt.p4.a aVarA;
        if (!z && (aVarA = a()) != null && !aVarA.g) {
            if (aVarA.i + aVarA.h > System.currentTimeMillis()) {
                return;
            }
        }
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            this.c = true;
            com.smartdigimkt.v2.p.c().a(new b(this, z), bVar, "strategy");
        }
    }
}
