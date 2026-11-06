package com.byazt.pv;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1010, 13})
public class hw extends com.byazt.ewt.pr {
    public List<String> c;
    public boolean hn;
    public boolean hw;
    public com.byazt.qe.hw pr;
    public com.byazt.xn.hn x;

    public hw(String str, String str2) {
        super(str, str2);
        this.c = new CopyOnWriteArrayList();
    }

    public int pr() {
        if (!this.c.isEmpty()) {
            return this.c.size();
        }
        return 1;
    }
}
