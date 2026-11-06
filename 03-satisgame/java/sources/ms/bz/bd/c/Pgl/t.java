package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class t extends pbls.pgla {
    t() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object n(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextQg = pblp.n().qg();
            if (contextQg != null) {
                return Boolean.valueOf((contextQg.getApplicationInfo() == null || (contextQg.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
