package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class l0 extends pbls.pgla {
    l0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        Context contextHw = pblp.pr().hw();
        return contextHw != null ? contextHw.getPackageName() : "";
    }
}
