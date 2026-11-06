package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class s3 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ v3 b;

    public s3(v3 v3Var, boolean z) {
        this.b = v3Var;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            this.b.e.b();
        } else {
            this.b.e.a();
        }
    }
}
