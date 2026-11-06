package com.smartdigimkt.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.smartdigimkt.china.formatbusiness.ui.RvDoubleTaskIncentiveTaskView;
import com.smartdigimkt.n1.y2;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 extends com.smartdigimkt.b2.p {
    public volatile boolean s;
    public long t;
    public long u;

    @Override // com.smartdigimkt.b2.p, com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        com.smartdigimkt.a3.a aVar;
        com.smartdigimkt.b3.e eVar;
        Context context;
        com.smartdigimkt.a3.a aVar2;
        com.smartdigimkt.b3.e eVar2;
        if (i == 131 || i == 128) {
            boolean z = this.h instanceof y2;
            if (this.s && (aVar = this.c) != null && (eVar = aVar.s) != null && com.smartdigimkt.b3.h.a(eVar.R1) && !g()) {
                this.s = false;
                this.t = 0L;
                this.u = 0L;
                BaseIncentiveTaskView baseIncentiveTaskView = this.j;
                if (baseIncentiveTaskView != null && (baseIncentiveTaskView instanceof CountDownSkipIncentiveTaskView)) {
                    com.smartdigimkt.b2.o oVar = new com.smartdigimkt.b2.o(this, (CountDownSkipIncentiveTaskView) baseIncentiveTaskView);
                    com.smartdigimkt.q3.f.a().getClass();
                    if (com.smartdigimkt.q3.f.c()) {
                        oVar.run();
                    } else {
                        com.smartdigimkt.q3.f.a().a(oVar);
                    }
                }
            }
        }
        if (i == 111) {
            if (this.s && g() && !com.smartdigimkt.j2.d.b && com.smartdigimkt.j2.d.a.get() <= 0 && com.smartdigimkt.j2.d.c.get() <= 0 && this.u <= 0) {
                this.u = SystemClock.elapsedRealtime();
                h();
            }
        } else if (i == 110) {
            if (this.u > 0) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.u;
                this.u = 0L;
                if (jElapsedRealtime >= 200 && this.s && g()) {
                    this.t += jElapsedRealtime;
                    int iH = h();
                    if (iH >= 1 && this.t >= ((long) iH) * 1000) {
                        this.s = false;
                        this.t = 0L;
                        this.u = 0L;
                        BaseIncentiveTaskView baseIncentiveTaskView2 = this.j;
                        if (baseIncentiveTaskView2 != null && (baseIncentiveTaskView2 instanceof CountDownSkipIncentiveTaskView)) {
                            com.smartdigimkt.b2.o oVar2 = new com.smartdigimkt.b2.o(this, (CountDownSkipIncentiveTaskView) baseIncentiveTaskView2);
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
            if (this.s) {
                com.smartdigimkt.b3.c cVar = this.b;
                String str = cVar != null ? cVar.m : null;
                if (!TextUtils.isEmpty(str) && (context = this.a) != null && com.smartdigimkt.r4.k.c(context, str) && (aVar2 = this.c) != null && (eVar2 = aVar2.s) != null && com.smartdigimkt.b3.h.a(eVar2.R1) && !g()) {
                    this.s = false;
                    this.t = 0L;
                    this.u = 0L;
                    BaseIncentiveTaskView baseIncentiveTaskView3 = this.j;
                    if (baseIncentiveTaskView3 != null && (baseIncentiveTaskView3 instanceof CountDownSkipIncentiveTaskView)) {
                        com.smartdigimkt.b2.o oVar3 = new com.smartdigimkt.b2.o(this, (CountDownSkipIncentiveTaskView) baseIncentiveTaskView3);
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
        super.a(i, map);
    }

    @Override // com.smartdigimkt.b2.p
    public final void b() {
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        super.b();
    }

    @Override // com.smartdigimkt.b2.p
    public final void d() {
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        super.d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
    
        r0 = r0.s;
     */
    @Override // com.smartdigimkt.b2.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long e() {
        /*
            r4 = this;
            com.smartdigimkt.a3.a r0 = r4.c
            if (r0 == 0) goto L4b
            com.smartdigimkt.b3.e r0 = r0.s
            if (r0 != 0) goto L9
            goto L4b
        L9:
            com.smartdigimkt.b3.d r1 = r0.R1
            if (r1 == 0) goto L48
            boolean r2 = com.smartdigimkt.b3.h.a(r1)
            if (r2 != 0) goto L14
            goto L48
        L14:
            java.lang.String r2 = r1.a()
            boolean r3 = com.smartdigimkt.b3.p.a(r2)
            if (r3 == 0) goto L25
            com.smartdigimkt.b3.o r0 = com.smartdigimkt.b3.p.a(r1)
            int r0 = r0.a
            goto L3c
        L25:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L41
            java.lang.String r2 = r2.trim()     // Catch: org.json.JSONException -> L41
            r3.<init>(r2)     // Catch: org.json.JSONException -> L41
            java.lang.String r2 = "t_c_s"
            boolean r2 = r3.has(r2)     // Catch: org.json.JSONException -> L41
            if (r2 == 0) goto L45
            com.smartdigimkt.b3.o r1 = com.smartdigimkt.b3.p.a(r1)     // Catch: org.json.JSONException -> L41
            int r0 = r1.a     // Catch: org.json.JSONException -> L41
        L3c:
            long r0 = (long) r0
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            goto L4a
        L41:
            r1 = move-exception
            r1.getMessage()
        L45:
            long r0 = r0.g1
            goto L4a
        L48:
            long r0 = r0.g1
        L4a:
            return r0
        L4b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.e.i0.e():long");
    }

    @Override // com.smartdigimkt.b2.p
    public final boolean f() {
        return true;
    }

    public final boolean g() {
        com.smartdigimkt.a3.a aVar;
        com.smartdigimkt.b3.e eVar;
        if (!this.s || this.b == null || (aVar = this.c) == null || (eVar = aVar.s) == null || !com.smartdigimkt.b3.h.a(eVar.R1)) {
            return false;
        }
        com.smartdigimkt.b3.c cVar = this.b;
        int i = cVar.o;
        if (i == 3) {
            if (TextUtils.isEmpty(cVar.k) && TextUtils.isEmpty(this.b.m)) {
                return false;
            }
        } else if (i != 6 || TextUtils.isEmpty(cVar.A)) {
            return false;
        }
        return h() >= 1;
    }

    public final int h() {
        com.smartdigimkt.b3.e eVar;
        int iC;
        com.smartdigimkt.a3.a aVar = this.c;
        if (aVar == null || (eVar = aVar.s) == null || (iC = com.smartdigimkt.b3.p.c(eVar.R1)) < 1 || iC > 15) {
            return 0;
        }
        return iC;
    }

    @Override // com.smartdigimkt.b2.p
    public final BaseIncentiveTaskView a() {
        if (com.smartdigimkt.b3.h.a(this.c.s.R1)) {
            this.n = 3;
            return new RvDoubleTaskIncentiveTaskView(this.a, this);
        }
        return super.a();
    }
}
