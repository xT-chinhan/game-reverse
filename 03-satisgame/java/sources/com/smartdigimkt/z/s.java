package com.smartdigimkt.z;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static boolean a(Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, com.smartdigimkt.h0.f fVar, String str, j0 j0Var) {
        try {
            com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
            String str2 = (fVar == null || TextUtils.isEmpty(fVar.b)) ? "" : fVar.b;
            if (bVarE != null && bVarE.a()) {
                Context applicationContext = context.getApplicationContext();
                bVarE.handleOfferClick(applicationContext, aVar, cVar, str, str2, new q(applicationContext, cVar), j0Var);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean b(Context context, com.smartdigimkt.b3.c cVar) {
        String str;
        if (cVar != null && !TextUtils.isEmpty(cVar.k) && !k.a(cVar.k)) {
            String str2 = cVar.k;
            String str3 = cVar.R;
            int i = cVar.o;
            if (i == 2 || i == 3) {
                str = !TextUtils.isEmpty(cVar.m) ? cVar.m : cVar.K;
            } else {
                str = "";
            }
            com.smartdigimkt.b3.e eVar = cVar.w;
            if (com.smartdigimkt.c0.h.a(context, str2, str3, str, eVar != null ? eVar.H1 : 2).a == 0) {
                return true;
            }
        }
        if (cVar == null || TextUtils.isEmpty(cVar.m)) {
            return false;
        }
        return com.smartdigimkt.c0.h.a(context, cVar.m);
    }

    public static void a(int i, com.smartdigimkt.b3.c cVar, com.smartdigimkt.h0.m mVar) {
        cVar.getClass();
        r rVar = new r(i, cVar, mVar);
        com.smartdigimkt.q3.f fVarA = com.smartdigimkt.q3.f.a();
        fVarA.getClass();
        String name = Thread.currentThread().getName();
        fVarA.a.getClass();
        if (TextUtils.equals(name, com.smartdigimkt.q3.b.a(19))) {
            rVar.run();
        } else {
            fVarA.a(rVar, 0L, 19);
        }
    }

    public static void a(Context context, com.smartdigimkt.b3.c cVar) {
        com.smartdigimkt.w2.b bVarE;
        if (context == null || cVar == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(cVar.m) || (bVarE = SDKContext.getInstance().e()) == null || !bVarE.a()) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (cVar instanceof com.smartdigimkt.b3.l) {
                g0.a(applicationContext).a();
                g0.a(applicationContext).b.put(cVar.a, cVar);
            }
            bVarE.registerMarketReceiver(cVar);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(com.smartdigimkt.b3.e eVar, int i) {
        if (i != 9 && i != 14) {
            if (eVar.E == 1) {
                return true;
            }
        } else if (eVar.F == 1) {
            return true;
        }
        return false;
    }
}
