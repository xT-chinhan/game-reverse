package com.smartdigimkt.b2;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.y2;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class p extends f {
    public com.smartdigimkt.m3.d i;
    public BaseIncentiveTaskView j;
    public long k;
    public long l;
    public boolean m;
    public int n;
    public int o = 3;
    public volatile boolean p;
    public long q;
    public long r;

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
    }

    public void b() {
        com.smartdigimkt.u1.d dVar;
        this.p = false;
        this.q = 0L;
        this.r = 0L;
        BaseIncentiveTaskView baseIncentiveTaskView = this.j;
        if (baseIncentiveTaskView != null) {
            com.smartdigimkt.o3.d.a(baseIncentiveTaskView);
            e eVar = this.h;
            if ((eVar instanceof y2) && (dVar = ((y2) eVar).a.n) != null) {
                dVar.s = true;
                dVar.d();
            }
            this.j.release();
            this.j = null;
        }
    }

    public final boolean c() {
        com.smartdigimkt.a3.a aVar;
        com.smartdigimkt.b3.e eVar;
        if (this.b == null || (aVar = this.c) == null || (eVar = aVar.s) == null) {
            return false;
        }
        com.smartdigimkt.b3.d dVar = eVar.R1;
        if (!com.smartdigimkt.b3.h.a(dVar)) {
            return false;
        }
        com.smartdigimkt.b3.c cVar = this.b;
        if (cVar.o != 3) {
            return false;
        }
        return !(TextUtils.isEmpty(cVar.k) && TextUtils.isEmpty(this.b.m)) && com.smartdigimkt.b3.p.b(dVar) >= 1;
    }

    public void d() {
        com.smartdigimkt.j2.d.c.set(0);
        this.p = false;
        this.q = 0L;
        this.r = 0L;
        com.smartdigimkt.m3.d dVar = this.i;
        if (dVar != null) {
            dVar.c();
            this.i = null;
        }
        b();
    }

    public long e() {
        com.smartdigimkt.b3.e eVar = this.c.s;
        com.smartdigimkt.b3.d dVar = eVar.R1;
        if (eVar == null) {
            return 0L;
        }
        return eVar.g1;
    }

    public boolean f() {
        return false;
    }

    @Override // com.smartdigimkt.b2.f
    public void a(int i, HashMap map) {
        com.smartdigimkt.a3.a aVar;
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.c cVar;
        Context context;
        com.smartdigimkt.a3.a aVar2;
        com.smartdigimkt.b3.e eVar2;
        com.smartdigimkt.b3.e eVar3;
        if (!f()) {
            if (i == 131 || i == 128) {
                if (this.p && (aVar = this.c) != null && (eVar = aVar.s) != null && com.smartdigimkt.b3.h.a(eVar.R1) && (!this.p || !c())) {
                    this.p = false;
                    this.q = 0L;
                    this.r = 0L;
                    BaseIncentiveTaskView baseIncentiveTaskView = this.j;
                    if (baseIncentiveTaskView != null && (baseIncentiveTaskView instanceof CountDownSkipIncentiveTaskView)) {
                        o oVar = new o(this, (CountDownSkipIncentiveTaskView) baseIncentiveTaskView);
                        com.smartdigimkt.q3.f.a().getClass();
                        if (com.smartdigimkt.q3.f.c()) {
                            oVar.run();
                        } else {
                            com.smartdigimkt.q3.f.a().a(oVar);
                        }
                    }
                }
            } else if (i == 111) {
                if (this.p && c() && this.r <= 0) {
                    this.r = SystemClock.elapsedRealtime();
                }
            } else if (i == 110) {
                if (this.r > 0) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - this.r;
                    this.r = 0L;
                    if (jElapsedRealtime >= 200 && this.p && c()) {
                        com.smartdigimkt.a3.a aVar3 = this.c;
                        int iB = (aVar3 == null || (eVar3 = aVar3.s) == null) ? 0 : com.smartdigimkt.b3.p.b(eVar3.R1);
                        if (iB >= 1) {
                            long j = this.q + jElapsedRealtime;
                            this.q = j;
                            if (j >= ((long) iB) * 1000) {
                                this.p = false;
                                this.q = 0L;
                                this.r = 0L;
                                BaseIncentiveTaskView baseIncentiveTaskView2 = this.j;
                                if (baseIncentiveTaskView2 != null && (baseIncentiveTaskView2 instanceof CountDownSkipIncentiveTaskView)) {
                                    o oVar2 = new o(this, (CountDownSkipIncentiveTaskView) baseIncentiveTaskView2);
                                    com.smartdigimkt.q3.f.a().getClass();
                                    if (com.smartdigimkt.q3.f.c()) {
                                        oVar2.run();
                                    } else {
                                        com.smartdigimkt.q3.f.a().a(oVar2);
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.p && ((!this.p || !c()) && (cVar = this.b) != null && !TextUtils.isEmpty(cVar.m) && (context = this.a) != null && com.smartdigimkt.r4.k.c(context, this.b.m) && (aVar2 = this.c) != null && (eVar2 = aVar2.s) != null && com.smartdigimkt.b3.h.a(eVar2.R1))) {
                    this.p = false;
                    this.q = 0L;
                    this.r = 0L;
                    BaseIncentiveTaskView baseIncentiveTaskView3 = this.j;
                    if (baseIncentiveTaskView3 != null && (baseIncentiveTaskView3 instanceof CountDownSkipIncentiveTaskView)) {
                        o oVar3 = new o(this, (CountDownSkipIncentiveTaskView) baseIncentiveTaskView3);
                        com.smartdigimkt.q3.f.a().getClass();
                        if (com.smartdigimkt.q3.f.c()) {
                            oVar3.run();
                        } else {
                            com.smartdigimkt.q3.f.a().a(oVar3);
                        }
                    }
                }
            }
        }
        if (i != 107 && i != 108) {
            if (i == 114) {
                if (this.i == null) {
                    this.i = new com.smartdigimkt.m3.d(e(), new l(this));
                }
                Object obj = map.get("video_length");
                if (obj != null && (obj instanceof Long)) {
                    this.k = ((Long) obj).longValue();
                }
                com.smartdigimkt.m3.d dVar = this.i;
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            if (i != 120) {
                switch (i) {
                    case 110:
                        com.smartdigimkt.j2.d.a();
                        com.smartdigimkt.m3.d dVar2 = this.i;
                        if (dVar2 != null) {
                            dVar2.b();
                        }
                        BaseIncentiveTaskView baseIncentiveTaskView4 = this.j;
                        if (baseIncentiveTaskView4 != null) {
                            baseIncentiveTaskView4.onResume();
                        }
                        break;
                    case 111:
                        com.smartdigimkt.m3.d dVar3 = this.i;
                        if (dVar3 != null) {
                            dVar3.a();
                        }
                        BaseIncentiveTaskView baseIncentiveTaskView5 = this.j;
                        if (baseIncentiveTaskView5 != null) {
                            baseIncentiveTaskView5.onPause();
                        }
                        break;
                }
            }
        }
        d();
    }

    public BaseIncentiveTaskView a() {
        int i = this.c.s.f1;
        this.n = i;
        if (i == 2) {
            return new QAIncentiveTaskView(this.a);
        }
        if (i != 3) {
            return null;
        }
        if (c()) {
            return new m(this, this.a);
        }
        return new CountDownSkipIncentiveTaskView(this.a);
    }
}
