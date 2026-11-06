package com.byazt.cpq;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 19})
public final class ho extends IOException {
    public final hw pr;

    public ho(hw hwVar) {
        super("stream was reset: ".concat(String.valueOf(hwVar)));
        this.pr = hwVar;
    }
}
