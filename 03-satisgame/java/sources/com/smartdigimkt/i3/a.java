package com.smartdigimkt.i3;

import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Callable {
    public final /* synthetic */ f a;

    public a(f fVar) {
        this.a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.a) {
            f fVar = this.a;
            if (fVar.h == null) {
                return null;
            }
            while (fVar.g > fVar.e) {
                fVar.d((String) ((Map.Entry) fVar.i.entrySet().iterator().next()).getKey());
            }
            if (this.a.a()) {
                this.a.d();
                this.a.j = 0;
            }
            return null;
        }
    }
}
