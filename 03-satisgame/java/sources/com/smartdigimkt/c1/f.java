package com.smartdigimkt.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.dismiss();
        } catch (Throwable unused) {
        }
    }
}
