package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
final class z extends pbly.pgla {
    z() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object ms(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextXr = pblv.ms().xr();
            if (contextXr != null) {
                return Boolean.valueOf((contextXr.getApplicationInfo() == null || (contextXr.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
