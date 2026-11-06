package com.smartdigimkt.i3;

import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final d a;
    public boolean b;
    public final /* synthetic */ f c;

    public c(f fVar, d dVar) {
        this.c = fVar;
        this.a = dVar;
    }

    public final void a() {
        if (!this.b) {
            f.a(this.c, this, true);
        } else {
            f.a(this.c, this, false);
            this.c.d(this.a.a);
        }
    }

    public final b b() {
        b bVar;
        synchronized (this.c) {
            if (this.a.d != this) {
                throw new IllegalStateException();
            }
            bVar = new b(this, new FileOutputStream(this.a.b(0)));
        }
        return bVar;
    }
}
