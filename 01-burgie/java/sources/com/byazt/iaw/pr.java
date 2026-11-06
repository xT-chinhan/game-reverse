package com.byazt.iaw;

import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, 37})
public final class pr implements a {
    public final fo pr;

    public pr(fo foVar) {
        this.pr = foVar;
    }

    @Override // com.byazt.jv.a
    public gz pr(a.pr prVar) throws IOException {
        com.byazt.osx.fw fwVar = (com.byazt.osx.fw) prVar;
        b bVarPr = fwVar.pr();
        if (bVarPr != null && bVarPr.uc != null) {
            bVarPr.uc.hw();
        }
        fw fwVarUc = fwVar.uc();
        com.byazt.osx.hn hnVarPr = fwVarUc.pr(this.pr, prVar, !bVarPr.hw().equals(TapHttp.METHOD_GET));
        hn hnVarHw = fwVarUc.hw();
        if (bVarPr != null && bVarPr.uc != null) {
            bVarPr.uc.hn();
        }
        return fwVar.pr(bVarPr, fwVarUc, hnVarPr, hnVarHw);
    }
}
