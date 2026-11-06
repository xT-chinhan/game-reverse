package com.anythink.basead.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.m.q;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int J = 36;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;
    public static final int w = 23;
    public static final int x = 24;
    public static final int y = 25;
    public static final int z = 26;

    public static boolean a(Context context, x xVar, final w wVar, com.anythink.basead.d.e eVar, String str, com.anythink.core.common.k.b bVar) {
        try {
            s sVarC = t.b().c();
            String str2 = (eVar == null || TextUtils.isEmpty(eVar.c)) ? "" : eVar.c;
            if (sVarC != null && sVarC.a()) {
                final Context applicationContext = context.getApplicationContext();
                sVarC.handleOfferClick(applicationContext, xVar, wVar, str, str2, new Runnable() { // from class: com.anythink.basead.b.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (wVar instanceof bj) {
                            h.a(applicationContext).a();
                            h.a(applicationContext).a(wVar.v(), wVar);
                        }
                    }
                }, bVar);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void a(final int i2, final w wVar, final com.anythink.basead.d.j jVar) {
        if (wVar.c()) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.b.b.2
            @Override // java.lang.Runnable
            public final void run() {
                Thread.currentThread().getName();
                w wVar2 = wVar;
                if (wVar2 instanceof ay) {
                    ay ayVar = (ay) wVar2;
                    boolean zA = wVar2.r() != null ? b.a(i2, wVar.r()) : false;
                    if (i2 == 8) {
                        String strE = ayVar.e();
                        if (!TextUtils.isEmpty(strE)) {
                            new com.anythink.basead.i.c(strE, jVar.b, zA).a(0, (q) null);
                        }
                    }
                    com.anythink.basead.i.b bVar = new com.anythink.basead.i.b(i2, ayVar, jVar.b);
                    if (!TextUtils.isEmpty(bVar.n())) {
                        bVar.a(jVar.d);
                        bVar.a(0, (q) null);
                    }
                } else {
                    j.a(i2, (bj) wVar2, jVar);
                }
                if (i2 == 21) {
                    w wVar3 = wVar;
                    if (wVar3 instanceof r) {
                        r rVar = (r) wVar3;
                        if (rVar.f() == 1) {
                            if (com.anythink.core.common.v.q.a(t.b().g().getApplicationContext(), rVar.I())) {
                                rVar.aD();
                                rVar.I();
                                com.anythink.core.common.a.d.a().c(rVar);
                            } else {
                                rVar.aD();
                                rVar.I();
                            }
                        }
                    }
                }
            }
        }, 2);
    }

    public static boolean a(int i2, y yVar) {
        if (i2 == 9 || i2 == 14) {
            if (yVar.n() != 1) {
                return false;
            }
        } else if (yVar.m() != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    private static boolean a(w wVar, y yVar) {
        boolean z2 = true;
        if (wVar instanceof r) {
            if (!(yVar instanceof bk)) {
                return false;
            }
            if (((bk) yVar).b() != 1) {
                z2 = false;
            }
        } else {
            if (!(wVar instanceof ay)) {
                return false;
            }
            if (((ay) wVar).d() != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, w wVar) {
        if (!TextUtils.isEmpty(wVar.G())) {
            if (com.anythink.core.basead.a.e.a(context, wVar.G(), wVar != null ? wVar.aw() : "")) {
                return true;
            }
        }
        if (TextUtils.isEmpty(wVar.I())) {
            return false;
        }
        return com.anythink.core.basead.a.e.b(context, wVar.I());
    }

    private static void a(w wVar) {
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            if (rVar.f() == 1) {
                if (com.anythink.core.common.v.q.a(t.b().g().getApplicationContext(), rVar.I())) {
                    rVar.aD();
                    rVar.I();
                    com.anythink.core.common.a.d.a().c(rVar);
                } else {
                    rVar.aD();
                    rVar.I();
                }
            }
        }
    }
}
