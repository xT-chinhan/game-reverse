package com.byazt.ry;

import com.byazt.nzn.aj;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 21, 5})
public class uc implements aj {
    public int pr;

    public void pr(int i) {
        this.pr = i;
    }

    @Override // com.byazt.nzn.aj
    public nt pr(aj.pr prVar) throws IOException {
        IOException iOException;
        g gVarPr = prVar.pr();
        if (fw.pr().pr(this.pr).hw() != null) {
            fw.pr().pr(this.pr).hw().c();
        }
        String string = gVarPr.hw().toString();
        String strPr = fw.pr().pr(this.pr).pr(string);
        if (!string.equals(strPr)) {
            gVarPr = gVarPr.fw().pr(strPr).hw();
        }
        nt ntVarPr = null;
        try {
            iOException = null;
            ntVarPr = prVar.pr(gVarPr);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            fw.pr().pr(this.pr).pr(gVarPr, e);
        }
        fw.pr().pr(this.pr).pr(gVarPr, ntVarPr);
        if (iOException == null) {
            return ntVarPr == null ? prVar.pr(gVarPr) : ntVarPr;
        }
        throw iOException;
    }
}
