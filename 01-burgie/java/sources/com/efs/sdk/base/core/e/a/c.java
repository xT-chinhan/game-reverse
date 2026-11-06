package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        if (c(bVar)) {
            b(bVar);
            return;
        }
        byte[] bArrA = com.efs.sdk.base.core.util.c.a(bVar.c);
        if (bArrA == null) {
            Log.w("efs.base", "gzip error");
            b(bVar);
        } else {
            bVar.a(bArrA);
            bVar.a(Constants.CP_GZIP);
            b(bVar);
        }
    }

    private static boolean c(com.efs.sdk.base.core.d.b bVar) {
        return bVar.b() || (1 == bVar.a.b && !bVar.b.a) || 1 == bVar.a.c;
    }
}
