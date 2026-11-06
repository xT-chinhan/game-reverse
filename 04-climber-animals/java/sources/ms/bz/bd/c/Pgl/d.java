package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
final class d extends pbly.pgla {
    d() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        Context contextXr = pblv.ms().xr();
        return contextXr != null ? contextXr.getPackageName() : "";
    }
}
