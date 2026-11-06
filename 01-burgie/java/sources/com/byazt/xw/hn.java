package com.byazt.xw;

import com.byazt.ld.a;
import com.byazt.ld.uc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1525, 20})
public class hn implements uc {
    public boolean hn;
    public boolean hw;
    public String pr;
    public a x;

    public hn(String str, boolean z, boolean z2, a aVar) {
        this.pr = str;
        this.hw = z;
        this.hn = z2;
        this.x = aVar;
    }

    @Override // com.byazt.ld.uc
    public String pr() {
        return this.pr;
    }

    @Override // com.byazt.ld.uc
    public boolean hw() {
        return this.hw;
    }

    @Override // com.byazt.ld.uc
    public boolean hn() {
        return this.hn;
    }

    @Override // com.byazt.ld.uc
    public a x() {
        return this.x;
    }
}
