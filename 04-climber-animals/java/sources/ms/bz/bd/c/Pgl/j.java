package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes4.dex */
final class j extends pbly.pgla {
    j() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        Context contextXr = pblv.ms().xr();
        Signature[] signatureArr = contextXr.getPackageManager().getPackageInfo(contextXr.getPackageName(), 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }
}
