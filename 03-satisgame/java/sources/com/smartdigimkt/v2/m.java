package com.smartdigimkt.v2;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ com.smartdigimkt.h3.b b;
    public final /* synthetic */ String c;
    public final /* synthetic */ p d;

    public m(p pVar, Runnable runnable, com.smartdigimkt.h3.b bVar, String str) {
        this.d = pVar;
        this.a = runnable;
        this.b = bVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d.e()) {
            synchronized (this.d.f) {
                p pVar = this.d;
                Runnable runnable = this.a;
                pVar.h();
                com.smartdigimkt.q3.f.a().c(runnable);
            }
            return;
        }
        synchronized (this.d.f) {
            if (!this.d.e()) {
                this.d.n.add(new o(this.a, this.b, this.c));
                p.d(this.d);
            } else {
                p pVar2 = this.d;
                Runnable runnable2 = this.a;
                pVar2.h();
                com.smartdigimkt.q3.f.a().c(runnable2);
            }
        }
    }
}
