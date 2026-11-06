package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes3.dex */
final class d extends pbls.pgla {
    d() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        Context contextHw = pblp.pr().hw();
        Signature[] signatureArr = contextHw.getPackageManager().getPackageInfo(contextHw.getPackageName(), 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }
}
