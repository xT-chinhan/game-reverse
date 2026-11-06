package com.smartdigimkt.t4;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.a;
        fVar.e = false;
        WeakReference weakReference = fVar.b;
        h hVar = weakReference != null ? (h) weakReference.get() : null;
        if (hVar != null) {
            hVar.timeUpRefreshView();
        } else {
            fVar.a();
        }
    }
}
