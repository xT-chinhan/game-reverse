package com.smartdigimkt.j;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byazt.gc.AbsServerManager;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.k.a0;
import com.smartdigimkt.k.b0;
import com.smartdigimkt.k.d0;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.j0;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements b0 {
    public static volatile u s;
    public final Context a;
    public ConcurrentHashMap f;
    public ConcurrentHashMap g;
    public ConcurrentHashMap h;
    public ConcurrentHashMap i;
    public final ConcurrentHashMap j;
    public final CopyOnWriteArrayList k;
    public v l;
    public com.smartdigimkt.o.b m;
    public final com.smartdigimkt.k.o o;
    public final com.smartdigimkt.k.q p;
    public final com.smartdigimkt.k.p q;
    public a0 r;
    public final k n = new k(this);
    public final List b = Collections.synchronizedList(new ArrayList());
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();
    public final ConcurrentHashMap e = new ConcurrentHashMap();

    public u(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.o = new com.smartdigimkt.k.o(applicationContext, com.smartdigimkt.z2.g.a(context));
        this.p = new com.smartdigimkt.k.q();
        this.q = new com.smartdigimkt.k.p(this);
        this.j = new ConcurrentHashMap();
        this.k = new CopyOnWriteArrayList();
        String strB = com.smartdigimkt.n.c.b();
        if (!TextUtils.isEmpty(strB)) {
            File file = new File(strB);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        try {
            m mVar = new m(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            applicationContext.registerReceiver(mVar, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public static void a(u uVar) {
        uVar.getClass();
        try {
            if (uVar.l != null) {
                return;
            }
            uVar.l = new v();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
            uVar.a.registerReceiver(uVar.l, intentFilter);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    public final synchronized void b() {
        com.smartdigimkt.k.r rVar;
        if (this.b.size() == 0) {
            return;
        }
        int size = this.c.size();
        if (size > 0) {
            Iterator it = this.c.keySet().iterator();
            if (it.hasNext()) {
                rVar = (com.smartdigimkt.k.r) this.c.get((String) it.next());
            } else {
                rVar = null;
            }
        } else {
            rVar = null;
        }
        this.b.size();
        com.smartdigimkt.k.r rVar2 = (com.smartdigimkt.k.r) this.b.remove(0);
        long j = rVar2.h;
        if (size >= 2) {
            g(rVar2);
            return;
        }
        if (rVar != null) {
            long j2 = j - rVar2.g;
            long j3 = rVar.h - rVar.g;
            if (j == 0) {
                this.o.a(rVar2, new p(this, j3, rVar2));
            } else if (j2 <= j3) {
                b(rVar2);
            } else {
                g(rVar2);
            }
        } else {
            b(rVar2);
            b();
        }
    }

    public final synchronized void c(com.smartdigimkt.k.r rVar) {
        com.smartdigimkt.k.r rVar2;
        com.smartdigimkt.b3.e eVar;
        if (rVar == null) {
            return;
        }
        try {
            if (a(rVar.o)) {
                com.smartdigimkt.b3.c cVar = rVar.j;
                if (cVar != null) {
                    cVar.D = 5;
                }
                rVar.s = com.smartdigimkt.k.c.FINISH;
                int i = SDKContext.getInstance().l ? 1 : 2;
                com.smartdigimkt.k.p pVar = this.q;
                if (pVar != null) {
                    pVar.a(rVar, i);
                }
                com.smartdigimkt.k.o oVar = this.o;
                if (oVar != null) {
                    oVar.c.b(new com.smartdigimkt.k.e(oVar, rVar));
                }
                return;
            }
            ConcurrentHashMap concurrentHashMap = this.c;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(rVar.o)) {
                com.smartdigimkt.b3.c cVar2 = rVar.j;
                if (cVar2 != null) {
                    cVar2.D = 4;
                }
                rVar.s = com.smartdigimkt.k.c.LOADING;
                com.smartdigimkt.q3.f.a().a(new t(this, "正在下载中： " + rVar.c));
                return;
            }
            ConcurrentHashMap concurrentHashMap2 = this.d;
            if (concurrentHashMap2 == null || (rVar2 = (com.smartdigimkt.k.r) concurrentHashMap2.remove(rVar.o)) == null) {
                a(rVar, -1);
                b();
                return;
            }
            com.smartdigimkt.b3.c cVar3 = rVar2.j;
            if (cVar3 != null && (eVar = cVar3.w) != null) {
                long j = rVar2.A;
                long j2 = eVar.q;
                if (j2 > 0 && j + j2 < System.currentTimeMillis()) {
                    com.smartdigimkt.q3.f.a().a(new t(this, "广告已失效，请刷新"));
                    com.smartdigimkt.m.j.a(this.a).a(rVar);
                    return;
                }
            }
            a(rVar2, 0);
            b();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void e(com.smartdigimkt.k.r rVar) {
        a0 a0Var = this.r;
        if (a0Var != null) {
            a0Var.onStatusChanged(rVar);
        }
    }

    public final void f(com.smartdigimkt.k.r rVar) {
        com.smartdigimkt.k.o oVar = this.o;
        if (oVar != null) {
            oVar.getClass();
            if (rVar == null) {
                return;
            }
            oVar.c.b(new com.smartdigimkt.k.f(oVar, rVar));
        }
    }

    public final void g(com.smartdigimkt.k.r rVar) {
        try {
            rVar.s = com.smartdigimkt.k.c.IDLE;
            a(rVar, -1);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void d(com.smartdigimkt.k.r rVar) {
        String strA = rVar != null ? rVar.a() : "";
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        String str = rVar.a;
        String str2 = rVar.t;
        String str3 = rVar.v;
        String str4 = rVar.u;
        com.smartdigimkt.b3.c cVar = rVar.j;
        String str5 = cVar instanceof com.smartdigimkt.b3.l ? ((com.smartdigimkt.b3.l) cVar).c0 : "";
        String str6 = rVar.f;
        String str7 = rVar.e;
        int i = rVar.y;
        Uri uriForFile = null;
        String str8 = cVar != null ? cVar.L : null;
        String str9 = cVar != null ? cVar.M : null;
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, str3);
        cVar2.a = "1004712";
        cVar2.b = str;
        cVar2.Q = str8;
        cVar2.R = str9;
        cVar2.c = str2;
        cVar2.h = String.valueOf(System.currentTimeMillis());
        cVar2.l = str3;
        cVar2.m = str4;
        cVar2.n = str5;
        cVar2.o = str6;
        cVar2.p = str7;
        cVar2.q = String.valueOf(i);
        com.smartdigimkt.n3.k.a(cVar2);
        File file = new File(strA);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            intent.addFlags(1);
            try {
                uriForFile = FileProvider.getUriForFile(this.a, this.a.getPackageName() + ".sdm.fileProvider", file);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
            this.a.startActivity(intent);
            com.smartdigimkt.n3.k.a(rVar.a, rVar.f, rVar.b, 4, (String) null, 0L, file.length(), rVar.j, 0, 0L);
        } catch (Throwable th2) {
            com.smartdigimkt.n3.k.a(rVar.a, rVar.f, rVar.b, 10, th2.getMessage(), 0L, file.length(), rVar.j, 0, 0L);
            th2.getMessage();
        }
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String strA = com.smartdigimkt.n.c.a(str);
            if (!TextUtils.isEmpty(strA)) {
                return new File(strA).exists();
            }
        }
        return false;
    }

    public static u a(Context context) {
        if (s == null) {
            synchronized (u.class) {
                if (s == null) {
                    s = new u(context);
                }
            }
        }
        return s;
    }

    public final synchronized void a(com.smartdigimkt.k.r rVar, int i) {
        if (rVar == null) {
            return;
        }
        try {
            List list = this.b;
            if (list != null) {
                synchronized (list) {
                    int i2 = 0;
                    while (true) {
                        try {
                            if (i2 >= this.b.size()) {
                                i2 = -1;
                                break;
                            }
                            com.smartdigimkt.k.r rVar2 = (com.smartdigimkt.k.r) this.b.get(i2);
                            if (rVar2 != null && rVar2.o.equals(rVar.o)) {
                                break;
                            } else {
                                i2++;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (i2 >= 0) {
                        this.b.remove(i2);
                    }
                    if (i >= 0 && i <= this.b.size()) {
                        this.b.add(i, rVar);
                    } else {
                        this.b.add(rVar);
                    }
                }
                com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a);
                jVarA.getClass();
                com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.e(jVarA, rVar));
            }
        } catch (Throwable unused) {
        }
    }

    public final void c() {
        ConcurrentHashMap concurrentHashMap = this.i;
        if (concurrentHashMap != null) {
            Iterator it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                com.smartdigimkt.k.r rVar = (com.smartdigimkt.k.r) ((Map.Entry) it.next()).getValue();
                rVar.D = 1;
                c(rVar);
                it.remove();
            }
        }
    }

    public final void a(com.smartdigimkt.k.r rVar) {
        if (this.g == null) {
            this.g = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(rVar.e)) {
            String strA = rVar.a();
            if (!TextUtils.isEmpty(strA)) {
                Context context = this.a;
                File file = new File(strA);
                String str = "";
                if (context != null) {
                    try {
                        str = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1).packageName;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                rVar.e = str;
            }
        }
        this.g.put(rVar.e, rVar);
        com.smartdigimkt.q3.f.a().a(new s(this, rVar));
    }

    public final void b(com.smartdigimkt.k.r rVar) {
        if (a(rVar.o)) {
            com.smartdigimkt.b3.c cVar = rVar.j;
            if (cVar != null) {
                cVar.D = 5;
            }
            rVar.s = com.smartdigimkt.k.c.FINISH;
            int i = SDKContext.getInstance().l ? 1 : 2;
            com.smartdigimkt.k.p pVar = this.q;
            if (pVar != null) {
                pVar.a(rVar, i);
            }
            com.smartdigimkt.k.o oVar = this.o;
            if (oVar != null) {
                oVar.c.b(new com.smartdigimkt.k.e(oVar, rVar));
                return;
            }
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.c;
        if (concurrentHashMap == null) {
            return;
        }
        String str = rVar.o;
        if (concurrentHashMap.containsKey(str)) {
            return;
        }
        this.c.put(str, rVar);
        this.e.put(str, new q(this));
        com.smartdigimkt.q3.f.a().a(new r(this, rVar, str));
    }

    public final void a(String str, String str2, int i, boolean z) {
        com.smartdigimkt.k.r rVar;
        com.smartdigimkt.k.r rVar2;
        com.smartdigimkt.k.r rVar3;
        com.smartdigimkt.k.r rVar4;
        try {
            if (str2.equals("FAIL")) {
                ConcurrentHashMap concurrentHashMap = this.i;
                if (concurrentHashMap == null || (rVar4 = (com.smartdigimkt.k.r) concurrentHashMap.remove(str)) == null) {
                    return;
                }
                c(rVar4);
                return;
            }
            int i2 = 1;
            if (str2.equals("FINISH")) {
                ConcurrentHashMap concurrentHashMap2 = this.f;
                if (concurrentHashMap2 == null || (rVar3 = (com.smartdigimkt.k.r) concurrentHashMap2.get(str)) == null) {
                    return;
                }
                com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(this.a);
                jVarA.getClass();
                com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.d(jVarA, rVar3));
                if (!SDKContext.getInstance().l) {
                    i2 = 2;
                }
                com.smartdigimkt.k.p pVar = this.q;
                if (pVar != null) {
                    pVar.a(rVar3, i2);
                    return;
                }
                return;
            }
            if (str2.equals("INSTALLED")) {
                ConcurrentHashMap concurrentHashMap3 = this.h;
                if (concurrentHashMap3 == null || (rVar2 = (com.smartdigimkt.k.r) concurrentHashMap3.get(str)) == null) {
                    return;
                }
                com.smartdigimkt.m.j.a(this.a).a(rVar2);
                b(rVar2, 2);
                return;
            }
            if (str2.equals("LOADING")) {
                ConcurrentHashMap concurrentHashMap4 = this.c;
                com.smartdigimkt.k.r rVar5 = concurrentHashMap4 != null ? (com.smartdigimkt.k.r) concurrentHashMap4.remove(str) : null;
                if (rVar5 == null || rVar5.s != com.smartdigimkt.k.c.LOADING) {
                    return;
                }
                rVar5.toString();
                if (rVar5.r == 2) {
                    return;
                }
                com.smartdigimkt.n3.k.a(rVar5.a, rVar5.f, rVar5.b, 11, (String) null, 0L, 0L, rVar5.j, z ? 1 : 2, 0L);
                com.smartdigimkt.o.b bVar = this.m;
                if (bVar != null) {
                    com.smartdigimkt.k.b bVar2 = (com.smartdigimkt.k.b) bVar.a.a.get(rVar5.o);
                    if (bVar2 != null) {
                        ((d0) bVar2).c.i = 4;
                        return;
                    }
                    return;
                }
                return;
            }
            if (str2.equals("PAUSE")) {
                com.smartdigimkt.k.r rVar6 = (com.smartdigimkt.k.r) this.d.get(str);
                if (rVar6 != null) {
                    rVar6.toString();
                    c(rVar6);
                    return;
                }
                return;
            }
            if (str2.equals("IDLE")) {
                this.b.size();
                synchronized (this.b) {
                    Iterator it = this.b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            rVar = null;
                            break;
                        }
                        com.smartdigimkt.k.r rVar7 = (com.smartdigimkt.k.r) it.next();
                        if (rVar7.o.equals(str)) {
                            if (rVar7.r != 2) {
                                rVar = rVar7;
                                break;
                            }
                            return;
                        }
                    }
                    if (rVar != null) {
                        com.smartdigimkt.b3.c cVar = rVar.j;
                        if (cVar != null) {
                            cVar.D = 7;
                        }
                        rVar.s = com.smartdigimkt.k.c.PAUSE;
                        this.c.remove(str);
                        this.b.remove(rVar);
                        this.d.put(rVar.o, rVar);
                        com.smartdigimkt.m.j.a(this.a).a(rVar);
                        if (rVar.h > 0) {
                            com.smartdigimkt.m.j.a(this.a).a(rVar, rVar.g, rVar.h, true);
                            return;
                        } else {
                            com.smartdigimkt.m.j.a(this.a).a(rVar, 0L, 100L, true);
                            return;
                        }
                    }
                    com.smartdigimkt.m.j jVarA2 = com.smartdigimkt.m.j.a(this.a);
                    jVarA2.getClass();
                    if (i < 0) {
                        return;
                    }
                    com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.h(jVarA2, i));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        com.smartdigimkt.k.r rVar;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        try {
            if (str2.equals("FAIL") && (concurrentHashMap3 = this.i) != null && concurrentHashMap3.containsKey(str)) {
                com.smartdigimkt.k.r rVar2 = (com.smartdigimkt.k.r) this.i.get(str);
                String str3 = rVar2.c;
                com.smartdigimkt.m.j.a(this.a).a(rVar2);
                this.i.remove(str);
            }
            if (str2.equals("FINISH") && (concurrentHashMap2 = this.f) != null && concurrentHashMap2.containsKey(str)) {
                com.smartdigimkt.k.r rVar3 = (com.smartdigimkt.k.r) this.f.get(str);
                String str4 = rVar3.c;
                com.smartdigimkt.m.j.a(this.a).a(rVar3);
                this.f.remove(str);
            }
            if (str2.equals("INSTALLED") && (concurrentHashMap = this.h) != null && concurrentHashMap.containsKey(str)) {
                com.smartdigimkt.k.r rVar4 = (com.smartdigimkt.k.r) this.h.get(str);
                String str5 = rVar4.c;
                com.smartdigimkt.m.j.a(this.a).a(rVar4);
                this.h.remove(str);
            }
            if (!str2.equals("PAUSE") || (rVar = (com.smartdigimkt.k.r) this.d.get(str)) == null) {
                return;
            }
            com.smartdigimkt.o.b bVar = this.m;
            if (bVar != null) {
                com.smartdigimkt.k.b bVar2 = (com.smartdigimkt.k.b) bVar.a.a.get(rVar.o);
                if (bVar2 != null) {
                    ((d0) bVar2).c.i = 5;
                }
            }
            this.d.remove(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(com.smartdigimkt.k.r rVar, int i) {
        if (this.p != null) {
            g gVar = new g();
            com.smartdigimkt.g3.b bVar = rVar.m;
            if (bVar != null) {
                ((j0) bVar).a(rVar.j, rVar.a, rVar.b, i == 2, gVar, rVar.A);
            }
        }
    }

    public final void a() {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = this.g;
        boolean z = concurrentHashMap2 == null || concurrentHashMap2.isEmpty();
        if ((!z || (concurrentHashMap = this.j) == null || concurrentHashMap.isEmpty()) && z) {
            try {
                v vVar = this.l;
                if (vVar != null) {
                    this.a.unregisterReceiver(vVar);
                    this.l = null;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
