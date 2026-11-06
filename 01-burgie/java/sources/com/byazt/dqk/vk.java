package com.byazt.dqk;

import com.byazt.jv.cz;
import com.byazt.jv.nl;
import com.byazt.nzn.yb;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 50})
public class vk extends yb {
    public nl pr;

    public vk(nl nlVar) {
        this.pr = nlVar;
    }

    @Override // com.byazt.nzn.yb
    public long pr() {
        nl nlVar = this.pr;
        if (nlVar != null) {
            return nlVar.hw();
        }
        return -1L;
    }

    @Override // com.byazt.nzn.yb
    public String hw() {
        try {
            return this.pr.uc();
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.byazt.nzn.yb, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nl nlVar = this.pr;
        if (nlVar != null) {
            nlVar.close();
        }
    }

    @Override // com.byazt.nzn.yb
    public InputStream hn() {
        nl nlVar = this.pr;
        if (nlVar != null) {
            return nlVar.x();
        }
        return null;
    }

    @Override // com.byazt.nzn.yb
    public byte[] x() {
        try {
            return this.pr.c();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @Override // com.byazt.nzn.yb
    public com.byazt.nzn.vk c() {
        cz czVarPr;
        nl nlVar = this.pr;
        if (nlVar == null || (czVarPr = nlVar.pr()) == null) {
            return null;
        }
        return new com.byazt.nzn.vk(czVarPr.toString(), czVarPr.pr(), czVarPr.hw(), czVarPr.hn() != null ? czVarPr.hn().name() : null);
    }
}
