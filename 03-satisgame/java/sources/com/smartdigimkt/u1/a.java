package com.smartdigimkt.u1;

import android.text.TextUtils;
import com.smartdigimkt.b2.f;
import com.smartdigimkt.b2.j0;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.b3.n;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.q1.k;
import com.smartdigimkt.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements k {
    public final /* synthetic */ d a;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // com.smartdigimkt.q1.k
    public final void a() {
        this.a.c();
        d dVar = this.a;
        String str = dVar.a;
        dVar.a(107);
        d dVar2 = this.a;
        c cVar = dVar2.j;
        if (cVar != null) {
            m mVarA = cVar.a();
            s.a(5, dVar2.d, mVarA);
            s.a(31, dVar2.d, mVarA);
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void b(long j) {
        n nVar;
        HashMap map;
        if (this.a.g != null) {
            HashMap map2 = new HashMap();
            map2.put("video_progress", Long.valueOf(j));
            this.a.g.a(map2);
        }
        this.a.a(125);
        d dVar = this.a;
        com.smartdigimkt.b3.c cVar = dVar.d;
        if ((cVar instanceof l) && (nVar = ((l) cVar).W) != null && (map = nVar.G) != null && map.size() > 0) {
            if (dVar.t == null) {
                dVar.t = new ConcurrentHashMap();
            }
            long j2 = j / 1000;
            for (Integer num : map.keySet()) {
                if (dVar.t.get(num) == null || !((Boolean) dVar.t.get(num)).booleanValue()) {
                    if (j2 >= num.intValue() && dVar.j != null) {
                        dVar.t.put(num, Boolean.TRUE);
                        m mVarA = dVar.j.a();
                        mVarA.h.g = num.intValue();
                        s.a(32, dVar.d, mVarA);
                    }
                }
            }
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.b(j);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void c() {
        this.a.c();
        d dVar = this.a;
        String str = dVar.a;
        k kVar = dVar.i;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void d() {
        d dVar = this.a;
        String str = dVar.a;
        c cVar = dVar.j;
        if (cVar != null) {
            m mVarA = cVar.a();
            mVarA.g = dVar.j.b();
            s.a(13, dVar.d, mVarA);
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.d();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void e() {
        com.smartdigimkt.l3.b bVar;
        String str = this.a.a;
        com.smartdigimkt.l3.d dVarA = com.smartdigimkt.l3.d.a();
        String str2 = this.a.d.i;
        dVarA.getClass();
        if (!TextUtils.isEmpty(str2) && (bVar = (com.smartdigimkt.l3.b) dVarA.a.get(str2)) != null) {
            synchronized (bVar) {
                boolean zD = bVar.d();
                bVar.u = true;
                if (zD) {
                    bVar.f();
                } else if (bVar.n == 1 && bVar.v) {
                    bVar.w = true;
                }
            }
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.e();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void f() {
        j0 j0Var;
        com.smartdigimkt.a3.a aVar;
        d dVar = this.a;
        String str = dVar.a;
        dVar.a(101);
        d dVar2 = this.a;
        com.smartdigimkt.b2.c cVar = dVar2.g;
        if (cVar != null) {
            long videoLength = dVar2.h.getVideoLength();
            ArrayList arrayList = cVar.e;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = cVar.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        j0Var = null;
                        break;
                    }
                    f fVar = (f) it.next();
                    if (fVar instanceof j0) {
                        j0Var = (j0) fVar;
                        break;
                    }
                }
            } else {
                j0Var = null;
                break;
            }
            if (j0Var != null && (aVar = j0Var.c) != null && !TextUtils.equals(String.valueOf(aVar.c), "4")) {
                j0Var.j = videoLength;
            }
        }
        d dVar3 = this.a;
        System.currentTimeMillis();
        dVar3.getClass();
        d dVar4 = this.a;
        c cVar2 = dVar4.j;
        if (cVar2 != null) {
            s.a(1, dVar4.d, cVar2.a());
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.f();
            this.a.i.b(0L);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void g() {
        d dVar = this.a;
        String str = dVar.a;
        c cVar = dVar.j;
        if (cVar != null) {
            m mVarA = cVar.a();
            mVarA.g = dVar.j.b();
            s.a(14, dVar.d, mVarA);
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.g();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(g gVar) {
        this.a.c();
        String str = this.a.a;
        gVar.a();
        if (this.a.g != null) {
            HashMap map = new HashMap();
            map.put("video_play_fail_message", gVar.a());
            this.a.g.a(map);
        }
        this.a.a(108);
        d dVar = this.a;
        c cVar = dVar.j;
        if (cVar != null) {
            m mVarA = cVar.a();
            mVarA.h = dVar.a(false);
            s.a(17, dVar.d, mVarA);
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.a(gVar);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void b() {
        d dVar = this.a;
        String str = dVar.a;
        c cVar = dVar.j;
        if (cVar != null) {
            m mVarA = cVar.a();
            mVarA.g = dVar.j.b();
            s.a(12, dVar.d, mVarA);
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(int i) {
        d dVar = this.a;
        c cVar = dVar.j;
        if (cVar != null) {
            m mVarA = cVar.a();
            if (i == 25) {
                s.a(2, dVar.d, mVarA);
            } else if (i == 50) {
                s.a(3, dVar.d, mVarA);
            } else if (i == 75) {
                s.a(4, dVar.d, mVarA);
            }
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(long j) {
        d dVar = this.a;
        String str = dVar.a;
        if (dVar.g != null) {
            HashMap map = new HashMap();
            map.put("video_length", Long.valueOf(j));
            this.a.g.a(map);
        }
        this.a.a(123);
        d dVar2 = this.a;
        c cVar = dVar2.j;
        if (cVar != null) {
            s.a(35, dVar2.d, cVar.a());
        }
        k kVar = this.a.i;
        if (kVar != null) {
            kVar.a(j);
        }
    }
}
