package com.byazt.dqk;

import com.byazt.jv.gz;
import com.byazt.nzn.nt;
import com.byazt.nzn.w;
import com.byazt.nzn.yb;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 61})
public class aj extends nt {
    public gz pr;

    public aj(gz gzVar) {
        this.pr = gzVar;
    }

    @Override // com.byazt.nzn.nt
    public long pr() {
        return this.pr.ho();
    }

    @Override // com.byazt.nzn.nt
    public long hw() {
        return this.pr.g();
    }

    @Override // com.byazt.nzn.nt
    public int hn() {
        gz gzVar = this.pr;
        if (gzVar != null) {
            return gzVar.x();
        }
        return 0;
    }

    @Override // com.byazt.nzn.nt
    public boolean x() {
        return this.pr.c();
    }

    @Override // com.byazt.nzn.nt
    public String c() {
        return this.pr.uc();
    }

    @Override // com.byazt.nzn.nt
    public yb uc() {
        return new vk(this.pr.aj());
    }

    @Override // com.byazt.nzn.nt
    public com.byazt.nzn.uc fw() {
        return new com.byazt.nzn.uc(this.pr.zo().pr);
    }

    @Override // com.byazt.nzn.nt
    public String pr(String str) {
        return this.pr.hw(str);
    }

    @Override // com.byazt.nzn.nt
    public String pr(String str, String str2) {
        return this.pr.pr(str, str2);
    }

    @Override // com.byazt.nzn.nt, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pr.close();
    }

    public String toString() {
        return this.pr.toString();
    }

    @Override // com.byazt.nzn.nt
    public w zo() {
        gz gzVar = this.pr;
        if (gzVar == null) {
            return null;
        }
        return new w(gzVar.nt());
    }

    @Override // com.byazt.nzn.nt
    public String aj() {
        gz gzVar = this.pr;
        if (gzVar == null) {
            return null;
        }
        return gzVar.pr();
    }
}
