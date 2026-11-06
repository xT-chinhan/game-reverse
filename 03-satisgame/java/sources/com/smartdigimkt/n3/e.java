package com.smartdigimkt.n3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends w {
    public static volatile e g;

    public e(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.n3.w
    public final void a(com.smartdigimkt.f3.e eVar) {
        com.smartdigimkt.f3.b bVar = (com.smartdigimkt.f3.b) eVar;
        com.smartdigimkt.p3.e eVar2 = bVar.b.a;
        if (eVar2 != null) {
            int i = bVar.a;
            com.smartdigimkt.p3.g gVar = eVar2.e;
            if (i == 30) {
                gVar.f = true;
            } else if (i == 4) {
                gVar.g = true;
            } else {
                gVar.getClass();
            }
        }
    }

    public final d b(int i, com.smartdigimkt.f3.a aVar, long j) {
        boolean z;
        com.smartdigimkt.p3.e eVar = (i == 4 || i == 30) ? aVar.a : null;
        if (eVar != null) {
            synchronized (eVar) {
                z = (eVar.k || eVar.e()) ? false : true;
            }
            if (!z) {
                return null;
            }
        }
        return new d(this, i, aVar, j, eVar);
    }

    public static e a(Context context) {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e(context);
                }
            }
        }
        return g;
    }

    @Override // com.smartdigimkt.n3.w
    public final void a(ArrayList arrayList) {
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA != null) {
            int i = aVarA.z;
            if (i == 1) {
                com.smartdigimkt.h4.f fVar = new com.smartdigimkt.h4.f(arrayList);
                String str = aVarA.C;
                fVar.a = 1;
                fVar.b = str;
                fVar.a((com.smartdigimkt.h4.c) null);
                return;
            }
            if (i != 2) {
                new com.smartdigimkt.f4.q(i, arrayList).a(0, (com.smartdigimkt.a4.b) null);
                return;
            }
            new com.smartdigimkt.f4.q(i, arrayList).a(0, (com.smartdigimkt.a4.b) null);
            com.smartdigimkt.h4.f fVar2 = new com.smartdigimkt.h4.f(arrayList);
            String str2 = aVarA.C;
            fVar2.a = 2;
            fVar2.b = str2;
            fVar2.a((com.smartdigimkt.h4.c) null);
            return;
        }
        new com.smartdigimkt.f4.q(0, arrayList).a(0, (com.smartdigimkt.a4.b) null);
    }

    public static void a(int i, com.smartdigimkt.f3.a aVar) {
        if (i != 4) {
            if (i == 6 && aVar.g != 1) {
                aVar.f = 1;
            }
        } else {
            aVar.g = 1;
        }
        b.a().getClass();
        if (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(null)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i != 4) {
            if (i != 6) {
                return;
            }
            aVar.k0 = jCurrentTimeMillis;
        } else {
            try {
                String str = aVar.d;
                if (!TextUtils.isEmpty(str)) {
                    str.equals("0");
                }
            } catch (Throwable th) {
                th.getMessage();
            }
            aVar.j0 = jCurrentTimeMillis;
        }
    }

    public final void a(int i, com.smartdigimkt.f3.a aVar, long j) {
        d dVarB;
        if (aVar == null) {
            return;
        }
        if ((aVar.P == 66 || i == 13 || i == 30 || i == 4) && (dVarB = b(i, aVar, j)) != null) {
            synchronized (aVar) {
                a(i, aVar);
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.post(dVarB);
            }
        }
    }
}
