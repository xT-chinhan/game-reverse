package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class l0 extends pbls.pgla {
    l0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        Context contextQg = pblp.n().qg();
        return contextQg != null ? contextQg.getPackageName() : "";
    }
}
