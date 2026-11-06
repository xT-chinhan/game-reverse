package com.smartdigimkt.m3;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ f b;

    public e(f fVar, b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.run();
        } finally {
            this.b.c.remove(this.a);
        }
    }
}
