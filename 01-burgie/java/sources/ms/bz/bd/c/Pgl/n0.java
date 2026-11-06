package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes3.dex */
final class n0 extends pbls.pgla {
    n0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        boolean zHw;
        try {
            zHw = r0.hw(pblp.pr().hw(), str, obj.toString());
        } catch (Throwable th) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5b9291", new byte[]{35, 97, 76});
            zHw = false;
        }
        if (zHw) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5a2557", new byte[]{11, 72});
        }
        return null;
    }
}
