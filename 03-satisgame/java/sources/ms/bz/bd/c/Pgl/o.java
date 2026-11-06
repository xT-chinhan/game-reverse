package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes3.dex */
final class o extends pbls.pgla {
    o() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        Context contextQg = pblp.n().qg();
        ApplicationInfo applicationInfo = contextQg.getPackageManager().getApplicationInfo(contextQg.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        return str2 == null ? applicationInfo.publicSourceDir : str2;
    }
}
