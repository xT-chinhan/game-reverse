package com.byazt.gr;

import com.byazt.du.k;
import com.byazt.du.lb;
import com.byazt.du.qa;
import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.gz;
import com.byazt.jv.nl;
import com.byazt.jv.rc;
import com.byazt.osx.zo;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 691, 37})
public final class pr implements a {
    public final uc pr;

    public pr(uc ucVar) {
        this.pr = ucVar;
    }

    @Override // com.byazt.jv.a
    public gz pr(a.pr prVar) throws IOException {
        uc ucVar = this.pr;
        gz gzVarPr = ucVar != null ? ucVar.pr(prVar.pr()) : null;
        hn hnVarPr = new hn.pr(System.currentTimeMillis(), prVar.pr(), gzVarPr).pr();
        b bVar = hnVarPr.pr;
        gz gzVar = hnVarPr.hw;
        if (gzVarPr != null && gzVar == null) {
            com.byazt.xx.hn.pr(gzVarPr.aj());
        }
        if (bVar == null && gzVar == null) {
            return new gz.pr().pr(prVar.pr()).pr(rc.HTTP_1_1).pr(504).pr("Unsatisfiable Request (only-if-cached)").pr(com.byazt.xx.hn.hn).pr(-1L).hw(System.currentTimeMillis()).pr();
        }
        if (bVar == null) {
            return gzVar.vk().hw(pr(gzVar)).pr();
        }
        try {
            gz gzVarPr2 = prVar.pr(bVar);
            if (gzVarPr2 == null && gzVarPr != null) {
                com.byazt.xx.hn.pr(gzVarPr.aj());
            }
            if (gzVar != null) {
                if (gzVarPr2.x() == 304) {
                    gz gzVarPr3 = gzVar.vk().pr(pr(gzVar.zo(), gzVarPr2.zo())).pr(gzVarPr2.g()).hw(gzVarPr2.ho()).hw(pr(gzVar)).pr(pr(gzVarPr2)).pr();
                    gzVarPr2.aj().close();
                    this.pr.update(gzVar, gzVarPr3);
                    return gzVarPr3;
                }
                com.byazt.xx.hn.pr(gzVar.aj());
            }
            gz gzVarPr4 = gzVarPr2.vk().hw(pr(gzVar)).pr(pr(gzVarPr2)).pr();
            if (this.pr != null) {
                if (com.byazt.osx.c.hn(gzVarPr4) && hn.pr(gzVarPr4, bVar)) {
                    return pr(this.pr.pr(gzVarPr4), gzVarPr4);
                }
                com.byazt.osx.uc.pr(bVar.hw());
            }
            return gzVarPr4;
        } catch (Throwable th) {
            if (gzVarPr != null) {
                com.byazt.xx.hn.pr(gzVarPr.aj());
            }
            throw th;
        }
    }

    private static gz pr(gz gzVar) {
        if (gzVar == null || gzVar.aj() == null) {
            return gzVar;
        }
        return gzVar.vk().pr((nl) null).pr();
    }

    private gz pr(final hw hwVar, gz gzVar) throws IOException {
        lb lbVarPr;
        if (hwVar == null || (lbVarPr = hwVar.pr()) == null) {
            return gzVar;
        }
        final com.byazt.du.c cVarHn = gzVar.aj().hn();
        final com.byazt.du.x xVarPr = k.pr(lbVarPr);
        return gzVar.vk().pr(new zo(gzVar.hw("Content-Type"), gzVar.aj().hw(), k.pr(new qa() { // from class: com.byazt.gr.pr.1
            public boolean pr;

            @Override // com.byazt.du.qa
            public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
                try {
                    long jPr = cVarHn.pr(hnVar, j);
                    if (jPr == -1) {
                        if (!this.pr) {
                            this.pr = true;
                            xVarPr.close();
                        }
                        return -1L;
                    }
                    hnVar.pr(xVarPr.hn(), hnVar.hw() - jPr, jPr);
                    xVarPr.cz();
                    return jPr;
                } catch (IOException e) {
                    if (!this.pr) {
                        this.pr = true;
                    }
                    throw e;
                }
            }

            @Override // com.byazt.du.qa
            public com.byazt.du.a pr() {
                return cVarHn.pr();
            }

            @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.pr && !com.byazt.xx.hn.pr(this, 100, TimeUnit.MILLISECONDS)) {
                    this.pr = true;
                }
                cVarHn.close();
            }
        }))).pr();
    }

    private static com.byazt.jv.lb pr(com.byazt.jv.lb lbVar, com.byazt.jv.lb lbVar2) {
        com.byazt.jv.lb.pr prVar = new com.byazt.jv.lb.pr();
        int iPr = lbVar.pr();
        for (int i = 0; i < iPr; i++) {
            String strPr = lbVar.pr(i);
            String strHw = lbVar.hw(i);
            if ((!"Warning".equalsIgnoreCase(strPr) || !strHw.startsWith("1")) && (!pr(strPr) || lbVar2.pr(strPr) == null)) {
                com.byazt.xx.pr.pr.pr(prVar, strPr, strHw);
            }
        }
        int iPr2 = lbVar2.pr();
        for (int i2 = 0; i2 < iPr2; i2++) {
            String strPr2 = lbVar2.pr(i2);
            if (!Util.CONTENT_LENGTH.equalsIgnoreCase(strPr2) && pr(strPr2)) {
                com.byazt.xx.pr.pr.pr(prVar, strPr2, lbVar2.hw(i2));
            }
        }
        return prVar.pr();
    }

    public static boolean pr(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || Util.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
