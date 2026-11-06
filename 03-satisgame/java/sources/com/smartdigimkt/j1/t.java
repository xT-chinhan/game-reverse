package com.smartdigimkt.j1;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.t4.d0;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements a, g, u {
    public static final /* synthetic */ int i = 0;
    public final com.smartdigimkt.e1.d a;
    public final com.smartdigimkt.b3.l b;
    public final com.smartdigimkt.f3.a c;
    public a g;
    public volatile boolean h;
    public int f = 0;
    public boolean d = false;
    public boolean e = false;

    public t(com.smartdigimkt.e1.d dVar, a aVar) {
        this.a = dVar;
        this.b = dVar.e;
        this.c = dVar.l;
        this.g = aVar;
    }

    public final void a(s sVar) {
        if (this.h) {
            return;
        }
        com.smartdigimkt.q3.f.a().a(new j(this, sVar));
    }

    public final void b(int i2) {
        com.smartdigimkt.e1.d dVar;
        com.smartdigimkt.a3.a aVar;
        if (this.c == null || (dVar = this.a) == null || this.b == null || (aVar = dVar.c) == null || aVar.c != 1) {
            return;
        }
        a();
        if (com.smartdigimkt.b3.h.a(this.c.l0)) {
            com.smartdigimkt.f3.a aVarA = this.c.a();
            aVarA.o0 = i2;
            com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(25, aVarA, -1L);
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:143:0x0203  */
    /* JADX WARN: Code duplicated, block: B:54:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f0 A[Catch: all -> 0x00f8, TRY_ENTER, TryCatch #2 {all -> 0x00f8, blocks: (B:57:0x00f0, B:58:0x00f3, B:59:0x00f6), top: B:252:0x00e9 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f3 A[Catch: all -> 0x00f8, TryCatch #2 {all -> 0x00f8, blocks: (B:57:0x00f0, B:58:0x00f3, B:59:0x00f6), top: B:252:0x00e9 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f6 A[Catch: all -> 0x00f8, TRY_LEAVE, TryCatch #2 {all -> 0x00f8, blocks: (B:57:0x00f0, B:58:0x00f3, B:59:0x00f6), top: B:252:0x00e9 }] */
    @Override // com.smartdigimkt.j1.a
    public final void onAdClick(w wVar) {
        com.smartdigimkt.e1.d dVar;
        com.smartdigimkt.a3.a aVar;
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar2;
        com.smartdigimkt.f3.a aVar2;
        com.smartdigimkt.e1.d dVar3;
        com.smartdigimkt.a3.a aVar3;
        int i2;
        int iC;
        int iB;
        int i3;
        String str;
        com.smartdigimkt.b3.l lVar;
        List list;
        int i4;
        int iA;
        this.f++;
        com.smartdigimkt.b3.l lVar2 = this.b;
        if (lVar2 instanceof com.smartdigimkt.b3.b) {
            com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) lVar2;
            if (bVar.j0 == 1 && this.c != null && !this.e) {
                this.e = true;
                com.smartdigimkt.t2.o oVarB = com.smartdigimkt.t2.o.b();
                String str2 = this.c.b;
                oVarB.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.n(oVarB, str2, bVar));
            }
        }
        com.smartdigimkt.b3.e eVar2 = this.b.w;
        boolean z = false;
        boolean z2 = eVar2 != null && this.f <= eVar2.r1;
        if (wVar != null) {
            int i5 = wVar.a;
            int i6 = wVar.b;
            Map map = this.a.h;
            if (map != null) {
                map.put(com.anythink.core.bridge.a.b.h, Integer.valueOf(i5));
                map.put(com.anythink.core.bridge.a.b.i, Integer.valueOf(i6));
                map.put(com.anythink.core.bridge.a.b.c, Integer.valueOf(wVar.e));
                if (z2) {
                    map.put(com.anythink.core.bridge.a.b.j, 28);
                } else {
                    map.put(com.anythink.core.bridge.a.b.j, 6);
                }
            }
            com.smartdigimkt.f3.a aVar4 = this.c;
            aVar4.z = i5;
            aVar4.A = i6;
            aVar4.y = wVar.e;
            if (z2) {
                aVar4.B = true;
            } else {
                aVar4.B = false;
            }
        }
        a();
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(6, this.c, -1L);
        if (wVar != null) {
            int i7 = wVar.a;
            com.smartdigimkt.o4.l lVarB = com.smartdigimkt.o4.l.b();
            lVarB.getClass();
            if (i7 == 4) {
                i4 = 1;
            } else if (i7 != 18) {
                i4 = i7 != 19 ? 0 : 3;
            } else {
                i4 = 2;
            }
            if (i4 > 0) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            if (i4 == 1) {
                                lVarB.e = jCurrentTimeMillis;
                            } else if (i4 != 2) {
                                if (i4 == 3) {
                                    lVarB.i = jCurrentTimeMillis;
                                }
                                iA = lVarB.a(i4) + 1;
                                if (i4 != 1) {
                                    lVarB.f = iA;
                                } else if (i4 != 2) {
                                    if (i4 == 3) {
                                        lVarB.j = iA;
                                    }
                                    lVarB.c = jCurrentTimeMillis;
                                    lVarB.d++;
                                    com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.o4.k(lVarB), 1);
                                } else {
                                    lVarB.h = iA;
                                }
                                lVarB.c = jCurrentTimeMillis;
                                lVarB.d++;
                                com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.o4.k(lVarB), 1);
                            } else {
                                lVarB.g = jCurrentTimeMillis;
                            }
                            if (i4 != 1) {
                                lVarB.f = iA;
                            } else if (i4 != 2) {
                                if (i4 == 3) {
                                    lVarB.j = iA;
                                }
                                lVarB.c = jCurrentTimeMillis;
                                lVarB.d++;
                                com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.o4.k(lVarB), 1);
                            } else {
                                lVarB.h = iA;
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                    }
                    iA = lVarB.a(i4) + 1;
                    lVarB.c = jCurrentTimeMillis;
                    lVarB.d++;
                    com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.o4.k(lVarB), 1);
                } catch (Throwable unused3) {
                }
            }
        }
        if (wVar != null && (dVar3 = this.a) != null && (aVar3 = dVar3.c) != null && this.b != null) {
            int iY = com.smartdigimkt.r4.h.y(SDKContext.getInstance().d());
            com.smartdigimkt.b3.l lVar3 = this.b;
            synchronized (lVar3) {
                i2 = lVar3.E;
            }
            if (i2 <= 0 || this.b.b() <= 0) {
                iC = 0;
                iB = 0;
            } else {
                iC = this.b.c();
                iB = this.b.b();
            }
            if (iC <= 0 || iB <= 0) {
                com.smartdigimkt.b3.l lVar4 = this.b;
                int i8 = lVar4.G;
                iB = lVar4.H;
                iC = i8;
            }
            char c = (iC <= 0 || iB <= 0 || iC <= iB) ? (char) 1 : (char) 2;
            int i9 = wVar.a;
            int i10 = wVar.b;
            boolean z3 = i9 == 5 || i9 == 6 || i9 == 7;
            int iB2 = com.smartdigimkt.i2.m.b(i9, i10);
            if (!z3 && (iB2 == 0 || iB2 == 1)) {
                z = true;
            }
            if (iB2 == 2) {
                i3 = 1;
            } else if (iB2 == 5) {
                i3 = 3;
            } else {
                i3 = iB2 == 1 ? 4 : 2;
            }
            com.smartdigimkt.b3.l lVar5 = this.b;
            if (lVar5 != null && aVar3.s != null) {
                com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(String.valueOf(aVar3.c), "66");
                cVar.a = "1004736";
                cVar.a(aVar3);
                cVar.l = String.valueOf(aVar3.c);
                if (lVar5 instanceof com.smartdigimkt.b3.b) {
                    cVar.m = lVar5.a;
                    cVar.n = ((com.smartdigimkt.b3.b) lVar5).c0;
                }
                cVar.o = 1 == lVar5.U ? "2" : "1";
                com.smartdigimkt.b3.e eVar3 = aVar3.s;
                if (eVar3 == null || SDKContext.getInstance().a("sensor_deny")) {
                    str = "2";
                } else if (eVar3.P1) {
                    com.smartdigimkt.b3.u uVar = eVar3.O1;
                    if (uVar == null) {
                        uVar = com.smartdigimkt.b3.u.i;
                    }
                    if (uVar.a()) {
                        int i11 = eVar3.Q1;
                        if (eVar3.P1) {
                            str = "2";
                        } else {
                            str = "2";
                        }
                    } else {
                        str = "2";
                    }
                } else {
                    int i12 = eVar3.Q1;
                    if (eVar3.P1 ? i12 != 1 : eVar3.K != 1) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                }
                cVar.p = str;
                cVar.q = iY == 1 ? "2" : "1";
                cVar.r = c == 1 ? "2" : "1";
                cVar.s = "";
                cVar.t = i3 + "";
                cVar.u = z ? "1" : "2";
                if (i3 != 1) {
                    lVar = lVar5;
                } else {
                    if (eVar3.P1) {
                        com.smartdigimkt.b3.u uVar2 = eVar3.O1;
                        if (uVar2 == null) {
                            uVar2 = com.smartdigimkt.b3.u.i;
                        }
                        int i13 = uVar2.a;
                        if (i13 != 0) {
                            cVar.w = String.valueOf(i13);
                            if (uVar2.a()) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    String str3 = uVar2.a == 2 ? "s_s_a_n" : "s_m_a_n";
                                    double d = uVar2.f;
                                    com.smartdigimkt.b3.u uVar3 = uVar2;
                                    long j = (long) d;
                                    lVar = lVar5;
                                    try {
                                        jSONObject.put(str3, d == ((double) j) ? String.valueOf(j) : String.valueOf(d));
                                        jSONObject.put("i_time", String.valueOf(uVar3.g));
                                        jSONObject.put("i_time_server", uVar3.c);
                                        jSONObject.put("shk_s_s", uVar3.d);
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(uVar3.a == 1 ? "multidirectional" : "unidirectional", jSONObject);
                                        JSONArray jSONArray = new JSONArray();
                                        jSONArray.put(jSONObject2);
                                        cVar.v = jSONArray.toString();
                                    } catch (Throwable unused4) {
                                    }
                                } catch (Throwable unused5) {
                                    lVar = lVar5;
                                }
                            }
                        }
                    } else {
                        int i14 = eVar3.K1;
                        cVar.w = String.valueOf(i14);
                        if (i14 == 1 && (list = eVar3.M1) != null && !list.isEmpty()) {
                            cVar.v = eVar3.M1.toString() + "," + eVar3.L1;
                        } else if (i14 == 2) {
                            cVar.v = String.valueOf(eVar3.N1);
                        }
                    }
                    lVar = lVar5;
                }
                if (i3 == 3) {
                    JSONArray jSONArray2 = new JSONArray();
                    float f = eVar3.U1;
                    float f2 = eVar3.V1;
                    float f3 = eVar3.W1;
                    try {
                        jSONArray2.put(f);
                        jSONArray2.put(f2);
                        jSONArray2.put(f3);
                    } catch (Throwable unused6) {
                    }
                    cVar.x = jSONArray2.toString();
                } else if (i3 == 4) {
                    cVar.y = com.smartdigimkt.c0.j.a(new StringBuilder(), eVar3.S1, "");
                }
                cVar.z = com.smartdigimkt.c0.j.a(new StringBuilder(), eVar3.T1, "");
                com.smartdigimkt.b3.l lVar6 = lVar;
                cVar.A = com.smartdigimkt.c0.j.a(new StringBuilder(), lVar6.o, "");
                cVar.B = lVar6.l;
                cVar.C = lVar6.k;
                cVar.E = aVar3.l;
                com.smartdigimkt.n3.k.a(cVar);
            }
        }
        if (wVar != null && (dVar = this.a) != null && (aVar = dVar.c) != null && this.b != null && (eVar = aVar.s) != null && ((dVar2 = eVar.R1) == null || !com.smartdigimkt.b3.h.a(dVar2.a) || (aVar2 = this.c) == null || !aVar2.n0)) {
            String str4 = wVar.h;
            if (str4 == null) {
                str4 = null;
            }
            com.smartdigimkt.n3.k.b(wVar.a, wVar.b, aVar, this.b, str4, false);
        }
        if ((!z2 || this.c.v) && !this.h) {
            a(new l(wVar));
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdClosed() {
        a(new q());
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdShow(w wVar) {
        com.smartdigimkt.e1.d dVar;
        com.smartdigimkt.d3.c cVar;
        com.smartdigimkt.b3.l lVar = this.b;
        int i2 = 1;
        if (lVar instanceof com.smartdigimkt.b3.b) {
            com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) lVar;
            if (bVar.j0 == 1) {
                com.smartdigimkt.t2.j jVarA = com.smartdigimkt.t2.j.a();
                jVarA.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.g(jVarA, bVar));
                if (this.c != null && !this.d) {
                    this.d = true;
                    com.smartdigimkt.t2.o oVarB = com.smartdigimkt.t2.o.b();
                    String str = this.c.b;
                    oVarB.getClass();
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.m(oVarB, str, bVar));
                }
            }
        }
        Map map = this.a.h;
        if (wVar != null) {
            int i3 = this.b.J;
            int i4 = wVar.e;
            if (map != null) {
                map.put(com.anythink.core.bridge.a.b.b, Integer.valueOf(i3));
                map.put(com.anythink.core.bridge.a.b.c, Integer.valueOf(wVar.e));
            }
            com.smartdigimkt.f3.a aVar = this.c;
            if (aVar != null) {
                aVar.x = i3;
                aVar.y = i4;
            }
        }
        if (wVar != null) {
            int i5 = this.a.c.c;
            if (i5 == 1) {
                if (map != null) {
                    map.put(com.anythink.core.bridge.a.b.d, Integer.valueOf(wVar.c));
                    map.put(com.anythink.core.bridge.a.b.e, Integer.valueOf(wVar.g));
                }
                com.smartdigimkt.f3.a aVar2 = this.c;
                aVar2.H = wVar.c;
                aVar2.G = wVar.g;
            } else if (i5 == 3 && map != null) {
                map.put(com.anythink.core.bridge.a.b.e, Integer.valueOf(wVar.g));
                map.put(com.anythink.core.bridge.a.b.f, Integer.valueOf(wVar.d));
                if (!wVar.f) {
                    i2 = wVar.d == 1 ? 4 : 2;
                } else if (wVar.d == 1) {
                    i2 = 3;
                }
                map.put(com.anythink.core.bridge.a.b.g, Integer.valueOf(i2));
                com.smartdigimkt.f3.a aVar3 = this.c;
                aVar3.I = wVar.d;
                aVar3.G = wVar.g;
                aVar3.F = i2;
            }
        }
        a();
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(4, this.c, -1L);
        com.smartdigimkt.f3.a aVar4 = this.c;
        if (aVar4 != null && !aVar4.v && (dVar = this.a) != null && (cVar = dVar.k) != null) {
            double d = cVar.B;
            String str2 = cVar.z;
            if (cVar.v) {
                double d2 = d > 0.0d ? cVar.d * d : cVar.d;
                if (TextUtils.isEmpty(str2)) {
                    str2 = cVar.i;
                }
                if (!TextUtils.isEmpty(str2)) {
                    new com.smartdigimkt.f4.h(str2.replace(com.anythink.core.c.d.c.b, d0.a(cVar, d2))).a(0, (com.smartdigimkt.a4.b) null);
                }
            } else {
                String strReplace = cVar.i;
                if (!TextUtils.isEmpty(strReplace)) {
                    SDMLossInfo sDMLossInfo = cVar.x;
                    if (sDMLossInfo != null) {
                        strReplace = strReplace.replace(com.anythink.core.c.d.c.d, String.valueOf(sDMLossInfo.getLossReasonCode()));
                    }
                    new com.smartdigimkt.f4.h(strReplace).a(0, (com.smartdigimkt.a4.b) null);
                }
            }
        }
        a(new k(wVar));
    }

    @Override // com.smartdigimkt.j1.a
    public final void onDeeplinkCallback(boolean z) {
        com.smartdigimkt.b3.e eVar = this.b.w;
        boolean z2 = eVar != null && this.f <= eVar.r1;
        if (this.c.v || z2) {
            return;
        }
        a(new r(z));
    }

    @Override // com.smartdigimkt.j1.g
    public final void onRewardTaskFirst() {
        b(1);
        a(new o());
    }

    @Override // com.smartdigimkt.j1.g
    public final void onRewarded() {
        b(2);
        if (this.h) {
            return;
        }
        a(new p());
    }

    @Override // com.smartdigimkt.j1.a
    public final void onShowFailed(com.smartdigimkt.h0.g gVar) {
        a(new h(gVar));
    }

    @Override // com.smartdigimkt.j1.g
    public final void onVideoAdPlayEnd() {
        a();
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(9, this.c, -1L);
        if (this.h) {
            return;
        }
        a(new n());
    }

    @Override // com.smartdigimkt.j1.g
    public final void onVideoAdPlayStart() {
        a();
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(8, this.c, -1L);
        if (this.h) {
            return;
        }
        a(new m());
    }

    public final void a() {
        com.smartdigimkt.b3.l lVar;
        com.smartdigimkt.b3.e eVar;
        Context contextD;
        com.smartdigimkt.f3.a aVar = this.c;
        if (aVar == null || (lVar = this.b) == null || (eVar = lVar.w) == null) {
            return;
        }
        com.smartdigimkt.b3.d dVar = eVar.R1;
        boolean zA = false;
        if (dVar != null) {
            long j = dVar.a;
            if (j > 0) {
                com.smartdigimkt.e1.d dVar2 = this.a;
                com.smartdigimkt.a3.a aVar2 = dVar2 != null ? dVar2.c : null;
                aVar.a(j, lVar, aVar2);
                long j2 = this.c.l0;
                com.smartdigimkt.e1.d dVar3 = this.a;
                boolean z = (dVar3 instanceof com.smartdigimkt.e1.h) && ((com.smartdigimkt.e1.h) dVar3).p;
                com.smartdigimkt.b3.l lVar2 = this.b;
                if (aVar2 != null && aVar2.c == 1 && com.smartdigimkt.b3.h.a(j2)) {
                    zA = (com.smartdigimkt.b3.q.a && com.smartdigimkt.b3.h.a(j2) && (contextD = SDKContext.getInstance().d()) != null && z) ? com.smartdigimkt.b2.k.a(contextD, lVar2) : true;
                }
                this.c.n0 = zA;
                return;
            }
        }
        aVar.n0 = false;
    }

    @Override // com.smartdigimkt.j1.u
    public final void a(int i2) {
        a(new i(i2));
    }
}
