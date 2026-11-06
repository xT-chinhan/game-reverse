package com.byazt.war;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 29})
public class cp extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "net_request";
    }

    @Override // com.byazt.war.rv
    public void n(final com.byazt.gxb.s sVar) {
        final com.byazt.gxb.w wVarPy = sVar.py();
        com.byazt.si.l lVarQ = wVarPy.q();
        sVar.n(false);
        try {
            com.byazt.si.x xVarCall = lVarQ.call(new com.byazt.tb.s(sVar.qg(), sVar.sz(), sVar.k(), sVar.m()));
            int iQg = xVarCall.qg();
            sVar.n(xVarCall.n());
            if (xVarCall.qg() == 200) {
                final byte[] bArr = (byte[]) xVarCall.s();
                sVar.n(new qg(bArr, xVarCall));
                final String strW = sVar.w();
                final com.byazt.si.qg qgVarOu = sVar.ou();
                if (qgVarOu.x()) {
                    wVarPy.qg(sVar.ou()).n(strW, bArr);
                }
                wVarPy.w().submit(new Runnable() { // from class: com.byazt.war.cp.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qgVarOu.q()) {
                            wVarPy.s(sVar.ou()).n(strW, bArr);
                        }
                    }
                });
                return;
            }
            wVarPy.fs();
            String.valueOf(xVarCall);
            Object objS = xVarCall.s();
            n(iQg, xVarCall.q(), objS instanceof Throwable ? (Throwable) objS : null, sVar);
        } catch (Throwable th) {
            n(1004, "net request failed!", th, sVar);
        }
    }

    private void n(int i, String str, Throwable th, com.byazt.gxb.s sVar) {
        sVar.n(new fs(i, str, th));
    }
}
