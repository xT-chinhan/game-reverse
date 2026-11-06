package com.byazt.dqk;

import com.byazt.jv.gz;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 121})
public class x implements com.byazt.nzn.hw {
    public com.byazt.jv.c pr;

    public x(com.byazt.jv.c cVar) {
        this.pr = cVar;
    }

    @Override // com.byazt.nzn.hw
    public g pr() {
        return new zo(this.pr.pr());
    }

    @Override // com.byazt.nzn.hw
    public nt hw() throws IOException {
        return new aj(this.pr.hw());
    }

    @Override // com.byazt.nzn.hw
    public void pr(final com.byazt.nzn.hn hnVar) {
        this.pr.pr(new com.byazt.jv.uc() { // from class: com.byazt.dqk.x.1
            @Override // com.byazt.jv.uc
            public void pr(com.byazt.jv.c cVar, IOException iOException) {
                hnVar.onFailure(new x(cVar), iOException);
            }

            @Override // com.byazt.jv.uc
            public void pr(com.byazt.jv.c cVar, gz gzVar) throws IOException {
                hnVar.onResponse(new x(cVar), new aj(gzVar));
            }
        });
    }

    @Override // com.byazt.nzn.hw
    public void hn() {
        this.pr.hn();
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.nzn.hw clone() {
        return new x(this.pr.clone());
    }

    @Override // com.byazt.nzn.hw
    public boolean x() {
        return this.pr.x();
    }
}
