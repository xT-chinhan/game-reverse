package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
final class l extends pbls.pgla {
    l() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        Context contextQg = pblp.n().qg();
        String[] strArr = (String[]) obj;
        if (contextQg == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(contextQg.getPackageName());
        for (int i = 0; i < strArr.length; i += 2) {
            intent.putExtra(strArr[i], strArr[i + 1]);
        }
        contextQg.sendBroadcast(intent);
        return null;
    }
}
