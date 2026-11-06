package com.smartdigimkt.l4;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final String a;
    public final p b;
    public final AtomicBoolean c = new AtomicBoolean();
    public final /* synthetic */ q d;

    public o(q qVar, String str, p pVar) {
        this.d = qVar;
        this.a = str;
        this.b = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a(this.c);
        } finally {
            this.d.a.remove(this.a);
        }
    }
}
