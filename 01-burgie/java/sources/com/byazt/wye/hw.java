package com.byazt.wye;

import com.byazt.nzn.aj;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1008, 13})
public class hw implements aj.pr {
    public int hn = 0;
    public g hw;
    public List<aj> pr;

    public hw(List<aj> list, g gVar) {
        this.pr = list;
        this.hw = gVar;
    }

    @Override // com.byazt.nzn.aj.pr
    public g pr() {
        return this.hw;
    }

    @Override // com.byazt.nzn.aj.pr
    public nt pr(g gVar) throws IOException {
        this.hw = gVar;
        int i = this.hn + 1;
        this.hn = i;
        return this.pr.get(i).pr(this);
    }
}
