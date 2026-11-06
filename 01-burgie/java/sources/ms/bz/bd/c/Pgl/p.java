package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class p extends pbls.pgla {
    p() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object pr(long j, String str, Object obj) throws Throwable {
        Throwable thHw = j1.pr().hw();
        return thHw != null ? Arrays.toString(thHw.getStackTrace()) : "";
    }
}
