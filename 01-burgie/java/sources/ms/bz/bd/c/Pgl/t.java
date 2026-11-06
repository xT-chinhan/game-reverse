package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class t extends pbls.pgla {
    t() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object pr(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextHw = pblp.pr().hw();
            if (contextHw != null) {
                return Boolean.valueOf((contextHw.getApplicationInfo() == null || (contextHw.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable th) {
            return Boolean.FALSE;
        }
    }
}
