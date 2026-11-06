package com.smartdigimkt.a0;

import com.smartdigimkt.z.z;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z zVar = this.a.a;
        if (zVar != null) {
            zVar.b();
        }
    }
}
