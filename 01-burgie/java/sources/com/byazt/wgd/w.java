package com.byazt.wgd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 109})
public class w extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(final com.byazt.sl.hn hnVar) {
        final com.byazt.sl.uc ucVarCz = hnVar.cz();
        com.byazt.ld.c cVarX = ucVarCz.x();
        hnVar.pr(false);
        try {
            com.byazt.ld.fw fwVarCall = cVarX.call(new com.byazt.xw.hn(hnVar.hw(), hnVar.g(), hnVar.ho(), hnVar.rc()));
            int iHw = fwVarCall.hw();
            hnVar.pr(fwVarCall.pr());
            if (fwVarCall.hw() == 200) {
                final byte[] bArr = (byte[]) fwVarCall.hn();
                hnVar.pr(new hw(bArr, fwVarCall));
                final String strUc = hnVar.uc();
                final com.byazt.ld.hw hwVarNy = hnVar.ny();
                if (hwVarNy.fw()) {
                    ucVarCz.hw(hnVar.ny()).pr(strUc, bArr);
                }
                ucVarCz.uc().submit(new Runnable() { // from class: com.byazt.wgd.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hwVarNy.x()) {
                            ucVarCz.hn(hnVar.ny()).pr(strUc, bArr);
                        }
                    }
                });
                return;
            }
            ucVarCz.zo();
            String.valueOf(fwVarCall);
            Throwable th = null;
            Object objHn = fwVarCall.hn();
            if (objHn instanceof Throwable) {
                th = (Throwable) objHn;
            }
            pr(iHw, fwVarCall.x(), th, hnVar);
        } catch (Throwable th2) {
            pr(1004, "net request failed!", th2, hnVar);
        }
    }

    private void pr(int i, String str, Throwable th, com.byazt.sl.hn hnVar) {
        hnVar.pr(new zo(i, str, th));
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "net_request";
    }
}
