package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class p extends pbls.pgla {
    p() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object n(long j, String str, Object obj) throws Throwable {
        Throwable thQg = j1.n().qg();
        return thQg != null ? Arrays.toString(thQg.getStackTrace()) : "";
    }
}
