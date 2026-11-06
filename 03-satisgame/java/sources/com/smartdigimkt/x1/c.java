package com.smartdigimkt.x1;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            d dVar = this.a;
            if (!dVar.j) {
                return;
            }
            try {
                if (dVar.g != null && (dVar.c().getParent() instanceof View)) {
                    d dVar2 = this.a;
                    if (dVar2.o.a((View) dVar2.c().getParent(), this.a.c(), 50, 0)) {
                        b bVar = this.a.i;
                        if (bVar != null) {
                            try {
                                bVar.sendEmptyMessage(1);
                            } catch (Throwable unused) {
                            }
                            try {
                                Thread.sleep(200L);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        } else {
                            try {
                                Thread.sleep(10L);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        d dVar3 = this.a;
                        long j = dVar3.l;
                        if (j >= dVar3.m) {
                            dVar3.j = false;
                            dVar3.k = null;
                        } else {
                            dVar3.l = j + 200;
                        }
                    }
                }
                Thread.sleep(1000L);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }
}
