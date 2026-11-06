package com.smartdigimkt.k;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final /* synthetic */ int e = 0;
    public final Context a;
    public final com.smartdigimkt.z2.g b;
    public final com.smartdigimkt.q3.f c = com.smartdigimkt.q3.f.a();
    public final ConcurrentHashMap d = new ConcurrentHashMap();

    public o(Context context, com.smartdigimkt.z2.g gVar) {
        this.a = context;
        this.b = gVar;
    }

    public static com.smartdigimkt.b3.f a(o oVar, r rVar) {
        oVar.getClass();
        com.smartdigimkt.b3.f fVar = new com.smartdigimkt.b3.f();
        fVar.a = rVar.o;
        fVar.b = rVar.n;
        fVar.c = rVar.a;
        fVar.d = rVar.f;
        fVar.e = rVar.b;
        fVar.f = rVar.e;
        fVar.g = rVar.c;
        com.smartdigimkt.g3.b bVar = rVar.m;
        if (bVar != null) {
            fVar.h = bVar.getClass().getName();
        }
        fVar.i = rVar.p ? 1 : 0;
        fVar.j = rVar.r;
        fVar.k = rVar.q;
        com.smartdigimkt.b3.c cVar = rVar.j;
        if (cVar != null) {
            fVar.q = cVar.e;
            fVar.s = cVar.e();
            fVar.B = cVar.D;
            if (cVar instanceof com.smartdigimkt.b3.l) {
                com.smartdigimkt.b3.l lVar = (com.smartdigimkt.b3.l) cVar;
                fVar.t = lVar.X;
                fVar.u = lVar.c0;
            }
            fVar.v = cVar.d;
            com.smartdigimkt.b3.e eVar = cVar.w;
            if (eVar != null) {
                fVar.l = eVar.B;
                fVar.m = eVar.C;
                fVar.n = eVar.w0;
                fVar.o = eVar.x0;
                fVar.p = eVar.y0;
                fVar.M = eVar.q;
            }
        }
        fVar.r = rVar.l;
        fVar.w = rVar.a();
        fVar.x = rVar.x;
        fVar.y = rVar.b();
        fVar.z = rVar.A;
        fVar.A = rVar.B;
        fVar.H = rVar.t;
        fVar.I = rVar.u;
        fVar.J = rVar.v;
        fVar.K = rVar.g;
        fVar.L = rVar.h;
        fVar.D = rVar.C;
        fVar.E = rVar.D;
        if (TextUtils.isEmpty(rVar.E)) {
            rVar.E = "1";
        }
        fVar.F = rVar.E;
        fVar.G = rVar.F;
        fVar.C = rVar.G;
        return fVar;
    }

    public static r a(o oVar, com.smartdigimkt.b3.f fVar) {
        oVar.getClass();
        r rVar = new r();
        m mVar = new m(fVar);
        d dVar = new d();
        rVar.o = fVar.a;
        rVar.n = fVar.b;
        rVar.a = fVar.c;
        rVar.f = fVar.d;
        rVar.b = fVar.e;
        rVar.e = fVar.f;
        rVar.c = fVar.g;
        rVar.p = fVar.i == 1;
        rVar.r = fVar.j;
        rVar.q = fVar.k;
        rVar.l = fVar.r;
        rVar.g = fVar.K;
        rVar.h = fVar.L;
        rVar.w = fVar.w;
        rVar.x = fVar.x;
        rVar.z = fVar.y;
        rVar.t = fVar.H;
        rVar.u = fVar.I;
        rVar.v = fVar.J;
        rVar.C = fVar.D;
        rVar.D = fVar.E;
        rVar.E = fVar.F;
        rVar.F = fVar.G;
        rVar.G = fVar.C;
        long j = fVar.z;
        if (j > 0) {
            rVar.A = j;
        }
        long j2 = fVar.A;
        if (j2 > 0) {
            rVar.B = j2;
        }
        long j3 = j2 - j;
        if (j3 > 0) {
            rVar.i = j3;
        }
        dVar.B = fVar.l;
        dVar.C = fVar.m;
        dVar.w0 = fVar.n;
        dVar.x0 = fVar.o;
        dVar.y0 = fVar.p;
        dVar.q = fVar.M;
        mVar.w = dVar;
        String str = fVar.q;
        mVar.e = str;
        mVar.X = fVar.t;
        mVar.m = fVar.f;
        mVar.a = fVar.d;
        mVar.c0 = fVar.u;
        mVar.d = fVar.v;
        rVar.j = mVar;
        try {
            if (!TextUtils.isEmpty(str)) {
                int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, oVar.a.getResources().getDisplayMetrics());
                rVar.d = com.smartdigimkt.i3.m.a(oVar.a).b(new com.smartdigimkt.i3.o(1, mVar.e), iApplyDimension, iApplyDimension);
            }
            String str2 = fVar.h;
            if (!TextUtils.isEmpty(str2)) {
                rVar.m = (com.smartdigimkt.g3.b) Class.forName(str2).newInstance();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        int i = fVar.B;
        if (i == 4) {
            com.smartdigimkt.b3.c cVar = rVar.j;
            if (cVar != null) {
                cVar.D = 4;
            }
            rVar.s = c.LOADING;
        } else if (i == 5) {
            com.smartdigimkt.b3.c cVar2 = rVar.j;
            if (cVar2 != null) {
                cVar2.D = 5;
            }
            rVar.s = c.FINISH;
        } else if (i == 6) {
            com.smartdigimkt.b3.c cVar3 = rVar.j;
            if (cVar3 != null) {
                cVar3.D = 6;
            }
            rVar.s = c.FAIL;
        } else if (i == 2) {
            com.smartdigimkt.b3.c cVar4 = rVar.j;
            if (cVar4 != null) {
                cVar4.D = 2;
            }
            rVar.s = c.INSTALLED;
        } else if (i == 7) {
            com.smartdigimkt.b3.c cVar5 = rVar.j;
            if (cVar5 != null) {
                cVar5.D = 7;
            }
            rVar.s = c.PAUSE;
        }
        return rVar;
    }

    public final void a(String str, int i, boolean z) {
        ConcurrentHashMap concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, new Pair(Integer.valueOf(i), Boolean.valueOf(z)));
        }
    }

    public final void a(r rVar, com.smartdigimkt.j.p pVar) {
        ConcurrentHashMap concurrentHashMap;
        String str = rVar.b;
        if (TextUtils.isEmpty(str)) {
            pVar.onCallback(rVar);
            return;
        }
        Pair pair = (TextUtils.isEmpty(str) || (concurrentHashMap = this.d) == null) ? null : (Pair) concurrentHashMap.get(str);
        if (pair != null) {
            rVar.h = ((Integer) pair.first).intValue();
            rVar.z = ((Boolean) pair.second).booleanValue();
            pVar.onCallback(rVar);
            return;
        }
        this.c.b(new i(this, str, rVar, pVar));
    }

    public final void a(r rVar, String str) {
        if (rVar == null || this.a == null) {
            return;
        }
        rVar.F = str;
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.a.getPackageName());
        intent.putExtra("receiver_extra_offer_id", rVar.f);
        intent.putExtra("receiver_extra_click_id", rVar.n);
        com.smartdigimkt.x2.d.a(this.a).a(intent);
    }

    public final void a(String str) {
        if (this.a == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("at_offer_action_5");
        intent.setPackage(this.a.getPackageName());
        intent.putExtra("receiver_extra_offer_id", str);
        intent.putExtra("receiver_extra_click_id", "");
        com.smartdigimkt.x2.d.a(this.a).a(intent);
    }
}
