package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes3.dex */
final class o extends pbls.pgla {
    o() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        Context contextHw = pblp.pr().hw();
        ApplicationInfo applicationInfo = contextHw.getPackageManager().getApplicationInfo(contextHw.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        return str2 == null ? applicationInfo.publicSourceDir : str2;
    }
}
