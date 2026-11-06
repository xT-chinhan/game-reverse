package com.smartdigimkt.d0;

import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.smartdigimkt.z.e0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements t {
    public static final /* synthetic */ int z = 0;
    public final boolean a;
    public final int b;
    public String c;
    public ArrayList d;
    public p e;
    public final com.smartdigimkt.b3.c f;
    public final com.smartdigimkt.b3.e g;
    public final com.smartdigimkt.a3.a h;
    public final b i;
    public volatile com.smartdigimkt.h3.b j;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public volatile boolean t;
    public final String y;
    public final d k = new d(this);
    public final HashSet l = new HashSet();
    public final int m = -1;
    public final int n = -1;
    public final int o = -1;
    public final e u = new e(this);
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;

    public q(String str, boolean z2, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        this.a = z2;
        this.f = cVar;
        this.h = aVar;
        this.j = aVar != null ? aVar.z : null;
        com.smartdigimkt.b3.e eVar = cVar.w;
        if (eVar != null) {
            this.g = eVar;
        } else {
            this.g = aVar.s;
        }
        this.b = this.g.p;
        try {
            com.smartdigimkt.n3.b.a().getClass();
            this.y = aVar.g + "_ " + aVar.f;
        } catch (Throwable unused) {
            this.y = null;
        }
        b bVar = new b();
        this.i = bVar;
        bVar.d = new o(this);
    }

    public static void b(q qVar) {
        qVar.getClass();
        String strB = com.smartdigimkt.i3.n.a().b(4, com.smartdigimkt.r4.i.b(qVar.f.i));
        if (new File(strB).exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(strB);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                qVar.f.G = Integer.parseInt(strExtractMetadata);
                qVar.f.H = Integer.parseInt(strExtractMetadata2);
                qVar.f.I = Long.parseLong(strExtractMetadata3);
                com.smartdigimkt.n3.b bVarA = com.smartdigimkt.n3.b.a();
                com.smartdigimkt.a3.a aVar = qVar.h;
                bVarA.getClass();
                String str = aVar.g + "_ " + aVar.f;
                com.smartdigimkt.n3.b.a().a(str).e = System.currentTimeMillis();
                com.smartdigimkt.n3.b.a().a(str);
            } finally {
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }

    public final void a() {
        int[] iArrA;
        int i;
        com.smartdigimkt.b3.c cVar = this.f;
        synchronized (cVar) {
            int i2 = cVar.E;
            if ((i2 > 0 && cVar.F <= 0) || (i2 <= 0 && cVar.F > 0)) {
                cVar.E = 0;
                cVar.F = 0;
            }
        }
        if (this.f.f()) {
            this.f.c();
            this.f.b();
            a(3);
            return;
        }
        SystemClock.elapsedRealtime();
        String str = this.f.f;
        if (!TextUtils.isEmpty(str)) {
            e0.a().getClass();
            String strA = e0.a(1, str);
            if (!TextUtils.isEmpty(strA) && (iArrA = com.smartdigimkt.s4.d.a(strA)) != null && iArrA.length == 2 && (i = iArrA[0]) > 0 && iArrA[1] > 0) {
                this.f.b(i);
                this.f.a(iArrA[1]);
            }
        }
        a(3);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x017b A[Catch: all -> 0x01f5, TryCatch #1 {, blocks: (B:84:0x0137, B:86:0x0148, B:88:0x015a, B:100:0x017b, B:113:0x01e7, B:103:0x018d, B:102:0x0185, B:91:0x0161, B:94:0x016a, B:104:0x01a1, B:106:0x01ab, B:109:0x01b2, B:111:0x01b8, B:112:0x01ce, B:114:0x01eb), top: B:124:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0185 A[Catch: all -> 0x01f5, TryCatch #1 {, blocks: (B:84:0x0137, B:86:0x0148, B:88:0x015a, B:100:0x017b, B:113:0x01e7, B:103:0x018d, B:102:0x0185, B:91:0x0161, B:94:0x016a, B:104:0x01a1, B:106:0x01ab, B:109:0x01b2, B:111:0x01b8, B:112:0x01ce, B:114:0x01eb), top: B:124:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x018d A[Catch: all -> 0x01f5, TryCatch #1 {, blocks: (B:84:0x0137, B:86:0x0148, B:88:0x015a, B:100:0x017b, B:113:0x01e7, B:103:0x018d, B:102:0x0185, B:91:0x0161, B:94:0x016a, B:104:0x01a1, B:106:0x01ab, B:109:0x01b2, B:111:0x01b8, B:112:0x01ce, B:114:0x01eb), top: B:124:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:99:0x0179 A[DONT_INVERT] */
    public final void c() {
        boolean z2;
        boolean z3;
        com.smartdigimkt.b3.e eVar = this.g;
        boolean z4 = eVar != null && eVar.V == 1;
        if (z4) {
            this.q = true;
            if (eVar != null) {
                eVar.U = 1;
            }
        }
        ArrayList arrayListA = this.f.a(eVar, this.h.w);
        if (arrayListA == null) {
            a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.m, "Incomplete resource allocation! MissResource: " + this.f.a()));
            return;
        }
        int size = arrayListA.size();
        if (size == 0) {
            synchronized (this) {
                this.d = new ArrayList();
                b();
                if (this.d.isEmpty()) {
                    a(1);
                } else {
                    u.a().a(this);
                    if (z4) {
                        a(1);
                    }
                }
            }
            return;
        }
        this.d = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) arrayListA.get(i);
            if (!TextUtils.isEmpty(str)) {
                if (this.f.a(str)) {
                    com.smartdigimkt.b3.c cVar = this.f;
                    HashMap map = s.a;
                    if (cVar == null) {
                        z3 = false;
                    } else {
                        String str2 = cVar.i;
                        if (!TextUtils.isEmpty(str2) && com.smartdigimkt.t2.z.a().a(str2) >= 100) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                    s.a(this.f, this.g);
                    if (z4) {
                        if (!z3) {
                            if (!this.d.contains(str)) {
                                int i2 = this.g.S;
                                this.d.add(str);
                            }
                        }
                    } else if (!z3) {
                        if (!this.d.contains(str)) {
                            int i3 = this.g.S;
                            this.d.add(str);
                        }
                    }
                } else if (!s.a(1, str) && !this.d.contains(str)) {
                    this.d.add(str);
                }
            }
        }
        if (com.smartdigimkt.z.c0.f(this.f, this.h) && this.f.h() && s.a(this.f, this.g) && !TextUtils.isEmpty(this.f.f)) {
            this.d.remove(this.f.f);
        }
        int size2 = this.d.size();
        if (size2 == 0) {
            synchronized (this) {
                b();
                if (this.d.isEmpty()) {
                    a(1);
                } else {
                    u.a().a(this);
                }
            }
            return;
        }
        synchronized (this) {
            u.a().a(this);
            ArrayList arrayList = new ArrayList(this.d);
            for (int i4 = 0; i4 < size2; i4++) {
                String str3 = (String) arrayList.get(i4);
                boolean zA = this.f.a(str3);
                int i5 = this.g.S;
                if (zA) {
                    com.smartdigimkt.b3.c cVar2 = this.f;
                    HashMap map2 = s.a;
                    if (cVar2 != null) {
                        String str4 = cVar2.i;
                        z2 = !TextUtils.isEmpty(str4) && com.smartdigimkt.t2.z.a().a(str4) >= 100;
                        if (z4) {
                            if (z2) {
                                u.a().a(100, str3);
                            } else {
                                y yVar = new y(this.f, this.g, this.h, !this.t);
                                this.p = true;
                                yVar.a();
                            }
                        } else if (z2) {
                            u.a().a(i5, str3);
                        } else {
                            y yVar2 = new y(this.f, this.g, this.h, !this.t);
                            this.p = true;
                            yVar2.a();
                        }
                    }
                    if (z4) {
                        if (z2) {
                            u.a().a(100, str3);
                        } else {
                            y yVar3 = new y(this.f, this.g, this.h, !this.t);
                            this.p = true;
                            yVar3.a();
                        }
                    } else if (z2) {
                        u.a().a(i5, str3);
                    } else {
                        y yVar4 = new y(this.f, this.g, this.h, !this.t);
                        this.p = true;
                        yVar4.a();
                    }
                } else {
                    Integer num = (Integer) s.a.get(str3);
                    if (num == null || num.intValue() != 0) {
                        if (s.a(1, str3)) {
                            com.smartdigimkt.n3.b.a().a(this.y, "img");
                            s.b(100, str3);
                            u.a().a(100, str3);
                        } else {
                            s.b(0, str3);
                            this.p = true;
                            v vVar = new v(this.a, this.f, str3);
                            vVar.i = this.y;
                            vVar.j = "img";
                            vVar.c();
                        }
                    }
                }
            }
        }
        if (z4) {
            a(1);
        }
        b();
    }

    public final void d() {
        this.t = true;
        this.j = null;
        synchronized (this) {
            this.l.clear();
        }
    }

    public final void a(int i) {
        boolean z2 = this.w;
        if (i == 1 && !this.v) {
            this.v = true;
            if (z2) {
                try {
                    a();
                    SystemClock.elapsedRealtime();
                } catch (Throwable th) {
                    SystemClock.elapsedRealtime();
                    throw th;
                }
            } else {
                com.smartdigimkt.q3.f.a().a(new c(this), 0L, 4);
            }
            if (this.x) {
                if (!s.a(this.f, this.g)) {
                    SystemClock.elapsedRealtime();
                    a(4);
                } else {
                    com.smartdigimkt.b3.c cVar = this.f;
                    if (cVar.G > 0 && cVar.H > 0) {
                        SystemClock.elapsedRealtime();
                        a(4);
                    } else {
                        com.smartdigimkt.n3.b bVarA = com.smartdigimkt.n3.b.a();
                        com.smartdigimkt.a3.a aVar = this.h;
                        bVarA.getClass();
                        com.smartdigimkt.n3.b.a().a(aVar.g + "_ " + aVar.f).d = System.currentTimeMillis();
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        com.smartdigimkt.q3.f.a().a(new g(this, atomicBoolean, com.smartdigimkt.q3.f.a().b().schedule(new f(this, atomicBoolean), 2000L, TimeUnit.MILLISECONDS)), 0L, 20);
                    }
                }
            }
        }
        b bVar = this.i;
        if (bVar == null || bVar.a.get() || bVar.c.contains(Integer.valueOf(i))) {
            return;
        }
        bVar.c.add(Integer.valueOf(i));
        bVar.b.get();
        if (bVar.b.decrementAndGet() == 0) {
            bVar.a.set(true);
            o oVar = bVar.d;
            if (oVar != null) {
                q qVar = oVar.a;
                if (!qVar.s && !qVar.r && !qVar.q && qVar.m != 0 && qVar.p && qVar.n >= 0) {
                    int i2 = qVar.o;
                }
                p pVar = qVar.e;
                if (pVar != null) {
                    pVar.a();
                }
                a(oVar.a);
            }
        }
    }

    public final void b() {
        com.smartdigimkt.b3.c cVar = this.f;
        com.smartdigimkt.b3.e eVar = this.g;
        boolean z2 = this.h.w;
        ArrayList arrayListB = cVar.b(eVar);
        arrayListB.size();
        if (arrayListB.size() > 0) {
            for (int i = 0; i < arrayListB.size(); i++) {
                String str = (String) arrayListB.get(i);
                if (!s.a(1, str)) {
                    synchronized (this) {
                        this.d.add(str);
                    }
                    v vVar = new v(this.a, this.f, str);
                    vVar.i = this.y;
                    vVar.j = "minor";
                    vVar.c();
                } else {
                    com.smartdigimkt.n3.b.a().a(this.y, "minor");
                }
            }
        }
    }

    public final void a(com.smartdigimkt.h0.g gVar) {
        gVar.a();
        if (!this.s) {
            this.r = true;
        }
        b bVar = this.i;
        if (bVar == null || bVar.a.get()) {
            return;
        }
        bVar.a.set(true);
        o oVar = bVar.d;
        if (oVar != null) {
            q qVar = oVar.a;
            boolean z2 = qVar.s;
            p pVar = qVar.e;
            if (pVar != null) {
                pVar.a(gVar);
            }
            a(oVar.a);
        }
    }

    public static void a(q qVar) {
        com.smartdigimkt.h3.b bVar = qVar.j;
        if (bVar != null) {
            d dVar = qVar.k;
            synchronized (bVar) {
                bVar.j.remove(dVar);
            }
        }
        qVar.d();
        u.a().b(qVar);
        com.smartdigimkt.m3.g.a().a(qVar.u);
    }
}
