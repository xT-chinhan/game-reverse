package com.mcto.sspsdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class ch extends dh {
    @Override // com.mcto.sspsdk.internal.xg
    public final void a() {
        this.a = 1;
        this.b = 1;
        this.c = 0L;
        this.f = new yg("single", 5);
        this.h = false;
        this.d = new LinkedBlockingQueue((int) Math.pow(2.0d, 7.0d));
        this.e = new ThreadPoolExecutor.DiscardOldestPolicy();
        this.f = new yg("ssp_player", 5);
    }
}
