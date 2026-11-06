package com.mcto.sspsdk.ssp.taskpage;

import com.mcto.sspsdk.internal.vh;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {
    public final /* synthetic */ vh a;
    public final /* synthetic */ e b;

    public c(e eVar, vh vhVar) {
        this.b = eVar;
        this.a = vhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.v.setVisibility(8);
        QyTaskPageActivity.a(this.b.a, this.a);
        QyTaskPageActivity.a(this.b.a, this.a.b);
    }
}
