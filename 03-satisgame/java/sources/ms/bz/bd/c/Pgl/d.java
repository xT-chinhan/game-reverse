package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes3.dex */
final class d extends pbls.pgla {
    d() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        Context contextQg = pblp.n().qg();
        Signature[] signatureArr = contextQg.getPackageManager().getPackageInfo(contextQg.getPackageName(), 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }
}
