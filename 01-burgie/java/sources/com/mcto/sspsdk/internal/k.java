package com.mcto.sspsdk.internal;

import com.mcto.cupid.Cupid;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Runnable {
    public final /* synthetic */ p a;

    public k(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Cupid.saveGlobalData(1, this.a.d());
        } catch (Throwable th) {
            r9.a("ssp_sdk", "saveGlobalData: ", th);
        }
    }
}
