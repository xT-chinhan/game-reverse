package com.byazt.hf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 210})
public final class k extends IOException {
    public final qg n;

    public k(qg qgVar) {
        super("stream was reset: ".concat(String.valueOf(qgVar)));
        this.n = qgVar;
    }
}
