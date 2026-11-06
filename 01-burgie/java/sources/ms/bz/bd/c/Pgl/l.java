package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
final class l extends pbls.pgla {
    l() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        Context contextHw = pblp.pr().hw();
        String[] strArr = (String[]) obj;
        if (contextHw == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(contextHw.getPackageName());
        for (int i = 0; i < strArr.length; i += 2) {
            intent.putExtra(strArr[i], strArr[i + 1]);
        }
        contextHw.sendBroadcast(intent);
        return null;
    }
}
