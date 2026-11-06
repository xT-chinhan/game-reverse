package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes4.dex */
final class e extends pbly.pgla {
    e() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        int iMs;
        l1 l1VarMs = l1.ms(pblv.ms().xr());
        l1VarMs.getClass();
        try {
            synchronized (l1VarMs) {
                iMs = l1VarMs.ms();
            }
        } catch (Exception unused) {
            iMs = -1;
        }
        return "" + iMs;
    }
}
