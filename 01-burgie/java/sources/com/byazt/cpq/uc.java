package com.byazt.cpq;

import com.byazt.du.lb;
import com.byazt.du.qa;
import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.byazt.jv.nl;
import com.byazt.jv.rc;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 5})
public final class uc implements com.byazt.osx.hn {
    public static final com.byazt.du.uc aj;
    public static final com.byazt.du.uc c;
    public static final com.byazt.du.uc fw;
    public static final com.byazt.du.uc hn;
    public static final com.byazt.du.uc hw;
    public static final com.byazt.du.uc uc;
    public static final List<com.byazt.du.uc> vk;
    public static final List<com.byazt.du.uc> w;
    public static final com.byazt.du.uc x;
    public static final com.byazt.du.uc zo;
    public final fw g;
    public aj ho;
    public final fo k;
    public final a.pr m;
    public final com.byazt.iaw.fw pr;

    static {
        com.byazt.du.uc ucVarPr = com.byazt.du.uc.pr("connection");
        hw = ucVarPr;
        com.byazt.du.uc ucVarPr2 = com.byazt.du.uc.pr("host");
        hn = ucVarPr2;
        com.byazt.du.uc ucVarPr3 = com.byazt.du.uc.pr("keep-alive");
        x = ucVarPr3;
        com.byazt.du.uc ucVarPr4 = com.byazt.du.uc.pr("proxy-connection");
        c = ucVarPr4;
        com.byazt.du.uc ucVarPr5 = com.byazt.du.uc.pr("transfer-encoding");
        uc = ucVarPr5;
        com.byazt.du.uc ucVarPr6 = com.byazt.du.uc.pr("te");
        fw = ucVarPr6;
        com.byazt.du.uc ucVarPr7 = com.byazt.du.uc.pr("encoding");
        zo = ucVarPr7;
        com.byazt.du.uc ucVarPr8 = com.byazt.du.uc.pr("upgrade");
        aj = ucVarPr8;
        vk = com.byazt.xx.hn.pr(ucVarPr, ucVarPr2, ucVarPr3, ucVarPr4, ucVarPr6, ucVarPr5, ucVarPr7, ucVarPr8, hn.hn, hn.x, hn.c, hn.uc);
        w = com.byazt.xx.hn.pr(ucVarPr, ucVarPr2, ucVarPr3, ucVarPr4, ucVarPr6, ucVarPr5, ucVarPr7, ucVarPr8);
    }

    public uc(fo foVar, a.pr prVar, com.byazt.iaw.fw fwVar, fw fwVar2) {
        this.k = foVar;
        this.m = prVar;
        this.pr = fwVar;
        this.g = fwVar2;
    }

    @Override // com.byazt.osx.hn
    public lb pr(b bVar, long j) {
        return this.ho.zo();
    }

    @Override // com.byazt.osx.hn
    public void pr(b bVar) throws IOException {
        if (this.ho != null) {
            return;
        }
        aj ajVarPr = this.g.pr(hw(bVar), bVar.x() != null);
        this.ho = ajVarPr;
        ajVarPr.c().pr(this.m.hn(), TimeUnit.MILLISECONDS);
        this.ho.uc().pr(this.m.x(), TimeUnit.MILLISECONDS);
    }

    @Override // com.byazt.osx.hn
    public void pr() throws IOException {
        this.g.hw();
    }

    @Override // com.byazt.osx.hn
    public void hw() throws IOException {
        this.ho.zo().close();
    }

    @Override // com.byazt.osx.hn
    public gz.pr pr(boolean z) throws IOException {
        gz.pr prVarPr = pr(this.ho.x());
        if (z && com.byazt.xx.pr.pr.pr(prVarPr) == 100) {
            return null;
        }
        return prVarPr;
    }

    public static List<hn> hw(b bVar) {
        com.byazt.jv.lb lbVarHn = bVar.hn();
        ArrayList arrayList = new ArrayList(lbVarHn.pr() + 4);
        arrayList.add(new hn(hn.hn, bVar.hw()));
        arrayList.add(new hn(hn.x, com.byazt.osx.aj.pr(bVar.pr())));
        String strPr = bVar.pr("Host");
        if (strPr != null) {
            arrayList.add(new hn(hn.uc, strPr));
        }
        arrayList.add(new hn(hn.c, bVar.pr().hw()));
        int iPr = lbVarHn.pr();
        for (int i = 0; i < iPr; i++) {
            com.byazt.du.uc ucVarPr = com.byazt.du.uc.pr(lbVarHn.pr(i).toLowerCase(Locale.US));
            if (!vk.contains(ucVarPr)) {
                arrayList.add(new hn(ucVarPr, lbVarHn.hw(i)));
            }
        }
        return arrayList;
    }

    public static gz.pr pr(List<hn> list) throws IOException {
        com.byazt.jv.lb.pr prVar = new com.byazt.jv.lb.pr();
        int size = list.size();
        com.byazt.osx.w wVarPr = null;
        for (int i = 0; i < size; i++) {
            hn hnVar = list.get(i);
            if (hnVar == null) {
                if (wVarPr != null && wVarPr.hw == 100) {
                    prVar = new com.byazt.jv.lb.pr();
                    wVarPr = null;
                }
            } else {
                com.byazt.du.uc ucVar = hnVar.fw;
                String strPr = hnVar.zo.pr();
                if (ucVar.equals(hn.hw)) {
                    wVarPr = com.byazt.osx.w.pr("HTTP/1.1 ".concat(String.valueOf(strPr)));
                } else if (!w.contains(ucVar)) {
                    com.byazt.xx.pr.pr.pr(prVar, ucVar.pr(), strPr);
                }
            }
        }
        if (wVarPr == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new gz.pr().pr(rc.HTTP_2).pr(wVarPr.hw).pr(wVarPr.hn).pr(prVar.pr());
    }

    @Override // com.byazt.osx.hn
    public nl pr(gz gzVar) throws IOException {
        return new com.byazt.osx.zo(gzVar.hw("Content-Type"), com.byazt.osx.c.pr(gzVar), com.byazt.du.k.pr(new pr(this.ho.fw())));
    }

    @Override // com.byazt.osx.hn
    public void hn() {
        aj ajVar = this.ho;
        if (ajVar != null) {
            ajVar.hw(hw.CANCEL);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 129})
    class pr extends com.byazt.du.zo {
        public long hw;
        public boolean pr;

        public pr(qa qaVar) {
            super(qaVar);
            this.pr = false;
            this.hw = 0L;
        }

        @Override // com.byazt.du.zo, com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            try {
                long jPr = hw().pr(hnVar, j);
                if (jPr > 0) {
                    this.hw += jPr;
                }
                return jPr;
            } catch (IOException e) {
                pr(e);
                throw e;
            }
        }

        @Override // com.byazt.du.zo, com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            pr(null);
        }

        private void pr(IOException iOException) {
            if (this.pr) {
                return;
            }
            this.pr = true;
            uc.this.pr.pr(false, (com.byazt.osx.hn) uc.this, this.hw, iOException);
        }
    }
}
