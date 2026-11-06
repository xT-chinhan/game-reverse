package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes3.dex */
final class pbly extends pbls.pgla {
    pbly() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        int iPr;
        d1 d1VarPr = d1.pr(pblp.pr().hw());
        d1VarPr.getClass();
        try {
            synchronized (d1VarPr) {
                iPr = d1VarPr.pr();
            }
        } catch (Exception e) {
            iPr = -1;
        }
        return "" + iPr;
    }
}
