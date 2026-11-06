package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes4.dex */
final class u extends pbly.pgla {
    u() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        Context contextXr = pblv.ms().xr();
        ApplicationInfo applicationInfo = contextXr.getPackageManager().getApplicationInfo(contextXr.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        return str2 == null ? applicationInfo.publicSourceDir : str2;
    }
}
