package com.smartdigimkt.z;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public static volatile e0 a;

    public static e0 a() {
        if (a == null) {
            synchronized (e0.class) {
                if (a == null) {
                    a = new e0();
                }
            }
        }
        return a;
    }

    public static void a(String str, boolean z, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.d0.p pVar) {
        boolean z2;
        int iMin;
        ArrayList<String> arrayList;
        com.smartdigimkt.d0.q qVar = new com.smartdigimkt.d0.q(str, z, cVar, aVar);
        com.smartdigimkt.b3.c cVar2 = qVar.f;
        if (cVar2 != null && qVar.i != null) {
            qVar.c = cVar2.a;
            qVar.e = pVar;
            com.smartdigimkt.m3.g.a().a.a(qVar.u, qVar.b);
            boolean z3 = (!String.valueOf(qVar.h.c).equals("0") || qVar.h.w || TextUtils.isEmpty(qVar.f.f)) ? false : true;
            qVar.w = z3;
            int i = z3 ? 2 : 1;
            if (qVar.f.h() && String.valueOf(qVar.h.c).equals("0") && !qVar.h.w) {
                com.smartdigimkt.d0.s.a(qVar.f, qVar.g);
                z2 = true;
            } else {
                z2 = false;
            }
            qVar.x = z2;
            if (z2) {
                i++;
            }
            int iD = qVar.f.d();
            int i2 = qVar.h.c;
            if (iD == 3 && (i2 == 1 || i2 == 3 || i2 == 4)) {
                com.smartdigimkt.b3.e eVar = qVar.g;
                if (eVar == null || eVar.V != 1) {
                    i++;
                }
                int i3 = i;
                com.smartdigimkt.b3.e eVar2 = qVar.f.w;
                String str2 = eVar2 != null ? eVar2.t1 : "";
                if (TextUtils.isEmpty(str2)) {
                    qVar.a(5);
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = qVar.g.z1;
                    Context contextD = SDKContext.getInstance().d();
                    if (com.smartdigimkt.j3.f.e == null) {
                        synchronized (com.smartdigimkt.j3.f.class) {
                            if (com.smartdigimkt.j3.f.e == null) {
                                com.smartdigimkt.j3.f.e = new com.smartdigimkt.j3.f(contextD);
                            }
                        }
                    }
                    com.smartdigimkt.j3.f.e.a(str2, qVar.y, new com.smartdigimkt.d0.n(qVar, j, jCurrentTimeMillis));
                }
                i = i3;
            }
            qVar.i.b.set(i);
            qVar.c();
            com.smartdigimkt.a3.a aVar2 = qVar.h;
            if (aVar2 != null && aVar2.s != null) {
                Context contextD2 = SDKContext.getInstance().d();
                try {
                    iMin = Math.min(contextD2.getResources().getDisplayMetrics().widthPixels, contextD2.getResources().getDisplayMetrics().heightPixels) / 2;
                } catch (Throwable unused) {
                    iMin = 0;
                }
                if (String.valueOf(qVar.h.c).equals("1") && !qVar.f.h() && qVar.h.s.i0 != 1) {
                    com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
                    int i4 = qVar.h.s.j0;
                    if (i4 == 2) {
                        arrayList = aVarA.V;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                    } else if (i4 == 3) {
                        arrayList = aVarA.W;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                    } else if (i4 != 5) {
                        arrayList = null;
                    } else {
                        arrayList = aVarA.X;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        for (String str3 : arrayList) {
                            if (!TextUtils.isEmpty(str3) && !com.smartdigimkt.d0.s.a(3, str3)) {
                                com.smartdigimkt.i3.m.a(contextD2).a(new com.smartdigimkt.i3.o(3, str3), iMin, iMin, (com.smartdigimkt.i3.l) null);
                            }
                        }
                    }
                }
                com.smartdigimkt.b3.e eVar3 = qVar.h.s;
                if (eVar3.K == 1 && !TextUtils.isEmpty(eVar3.s0)) {
                    com.smartdigimkt.i3.m.a(contextD2).a(new com.smartdigimkt.i3.o(3, qVar.h.s.s0), iMin, iMin, new com.smartdigimkt.d0.h(qVar, System.currentTimeMillis()));
                }
                com.smartdigimkt.b3.e eVar4 = qVar.h.s;
                if (eVar4.K0 == 4 && !TextUtils.isEmpty(eVar4.V0)) {
                    com.smartdigimkt.i3.n nVarA = com.smartdigimkt.i3.n.a();
                    String strB = com.smartdigimkt.r4.i.b(qVar.h.s.V0);
                    nVarA.getClass();
                    if (TextUtils.isEmpty(strB) || !new File(nVarA.b(3, strB)).exists()) {
                        com.smartdigimkt.d0.a aVar3 = new com.smartdigimkt.d0.a(qVar.h.s.V0);
                        aVar3.i = qVar.y;
                        aVar3.j = "internal";
                        aVar3.c();
                    }
                }
                if (String.valueOf(qVar.h.c).equals("4")) {
                    com.smartdigimkt.a3.a aVar4 = qVar.h;
                    if (aVar4.k != 67 && (qVar.f instanceof com.smartdigimkt.b3.b) && com.smartdigimkt.b3.h.a(1, aVar4.s.R1)) {
                        String str4 = qVar.f.e;
                        if (!TextUtils.isEmpty(str4) && !com.smartdigimkt.d0.s.a(1, str4)) {
                            int iMax = Math.max(iMin, 1);
                            com.smartdigimkt.i3.m.a(contextD2).a(new com.smartdigimkt.i3.o(1, str4), iMax, iMax, new com.smartdigimkt.d0.i());
                        }
                    }
                }
            }
            com.smartdigimkt.b3.c cVar3 = qVar.f;
            com.smartdigimkt.b3.e eVar5 = qVar.g;
            boolean z4 = qVar.h.w;
            cVar3.getClass();
            HashSet hashSet = new HashSet();
            if (eVar5.n0 == 1) {
                com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
            if (eVar5.a == 1) {
                if (eVar5.K0 == 3) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.a);
                }
                if (eVar5.K0 == 2) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
                }
                if (eVar5.K0 == 4) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.p);
                }
                if (eVar5.n0 == 1) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.f);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.g);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.h);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.k);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.l);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.m);
                }
                if (TextUtils.isEmpty(cVar3.i) && eVar5.j0 == 2) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
                }
                if (eVar5.Q == 1) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
                }
                if (eVar5.f1 == 3) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.k);
                }
                if (eVar5.f1 == 2) {
                    if (com.smartdigimkt.r4.k.a()) {
                        com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.o);
                    } else {
                        com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.n);
                    }
                }
            }
            if (eVar5.a == 3) {
                if (eVar5.K0 == 3) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.a);
                }
                if (eVar5.K0 == 2) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
                }
                if (eVar5.K0 == 4) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.p);
                }
                if (eVar5.j1 == 2) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.b);
                }
                if (eVar5.m0 == 1) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.c);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.d);
                }
                if (eVar5.Q == 1) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
                }
            }
            if (eVar5.a == 4) {
                if (eVar5.j1 == 2) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.b);
                }
                if (eVar5.j1 == 3) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.q);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.s);
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.r);
                }
                if (eVar5.B0 > 0) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.e);
                }
                if (eVar5.Q == 1) {
                    com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.i);
                }
                boolean z5 = (cVar3.e() == 1 && (eVar5 instanceof com.smartdigimkt.e3.b) && 2 != ((com.smartdigimkt.e3.b) eVar5).X1) ? false : true;
                if ((cVar3.e() == 2 || cVar3.e() == 4) && (cVar3 instanceof com.smartdigimkt.b3.l) ? 1 != ((com.smartdigimkt.b3.l) cVar3).U : !z5) {
                    if (eVar5.k1 == 2) {
                        com.smartdigimkt.m1.d.a().a(hashSet, com.anythink.core.common.a.b.d.j);
                    }
                }
            }
            ArrayList<String> arrayList2 = new ArrayList(hashSet);
            if (arrayList2.isEmpty()) {
                return;
            }
            for (String str5 : arrayList2) {
                if (!TextUtils.isEmpty(str5)) {
                    com.smartdigimkt.d0.s.a(3, str5);
                    if (!com.smartdigimkt.d0.s.a(3, str5)) {
                        d0.a().a(new com.smartdigimkt.i3.o(3, str5), -1, -1, new com.smartdigimkt.d0.j(qVar, System.currentTimeMillis()));
                    }
                }
            }
            return;
        }
        qVar.a(new com.smartdigimkt.h0.g("-9999", com.anythink.core.common.inner.b.b.A));
    }

    public static String a(int i, String str) {
        return com.smartdigimkt.i3.n.a().b(i, com.smartdigimkt.r4.i.b(str));
    }
}
