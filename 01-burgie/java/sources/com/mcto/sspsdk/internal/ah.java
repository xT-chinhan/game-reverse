package com.mcto.sspsdk.internal;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class ah extends xg {
    @Override // com.mcto.sspsdk.internal.xg
    public final void a() {
        this.a = 4;
        this.b = 20;
        this.f = new yg("io", 5);
        this.e = new ThreadPoolExecutor.DiscardOldestPolicy();
    }
}
