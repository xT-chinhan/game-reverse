package com.byazt.fe;

import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1390, 13})
public class hw extends x {
    public void pr(int i) {
        pr((byte) (i & 255));
        pr((byte) ((i >> 8) & 255));
        pr((byte) ((i >> 16) & 255));
        pr((byte) ((i >> 24) & 255));
    }

    public void hw(int i) {
        pr((byte) ((i >> 24) & 255));
        pr((byte) ((i >> 16) & 255));
        pr((byte) ((i >> 8) & 255));
        pr((byte) (i & 255));
    }

    @Override // com.byazt.fe.x
    public void hn(int i) {
        super.hn(i);
        this.pr.order(ByteOrder.BIG_ENDIAN);
    }
}
