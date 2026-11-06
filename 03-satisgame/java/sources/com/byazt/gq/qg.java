package com.byazt.gq;

import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1959, 26})
public class qg extends q {
    public void n(int i) {
        n((byte) (i & 255));
        n((byte) ((i >> 8) & 255));
        n((byte) ((i >> 16) & 255));
        n((byte) ((i >> 24) & 255));
    }

    public void qg(int i) {
        n((byte) ((i >> 24) & 255));
        n((byte) ((i >> 16) & 255));
        n((byte) ((i >> 8) & 255));
        n((byte) (i & 255));
    }

    @Override // com.byazt.gq.q
    public void s(int i) {
        super.s(i);
        this.n.order(ByteOrder.BIG_ENDIAN);
    }
}
