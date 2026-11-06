package com.byazt.aj;

import com.byazt.nzn.nt;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 61, 5})
public class uc extends pr {
    public nt hn;

    public uc(nt ntVar, c cVar) {
        com.byazt.nzn.uc ucVarFw;
        this.hn = ntVar;
        this.pr = new ArrayList();
        if (ntVar != null && (ucVarFw = ntVar.fw()) != null) {
            for (int i = 0; i < ucVarFw.pr(); i++) {
                this.pr.add(new com.byazt.i.uc.hw(ucVarFw.pr(i), ucVarFw.hw(i)));
            }
        }
        this.hw = cVar;
    }

    @Override // com.byazt.aj.pr
    public int pr() {
        return this.hn.hn();
    }

    @Override // com.byazt.aj.pr
    public boolean hw() {
        return this.hn.hn() >= 200 && this.hn.hn() < 300;
    }

    @Override // com.byazt.aj.pr
    public String pr(String str, String str2) {
        if (pr(str) != null) {
            return pr(str).hw;
        }
        return str2;
    }

    @Override // com.byazt.aj.pr
    public List<com.byazt.i.uc.hw> hn() {
        return this.pr;
    }

    @Override // com.byazt.aj.pr
    public InputStream x() {
        return this.hn.uc().hn();
    }
}
