package com.smartdigimkt.f0;

import com.smartdigimkt.r4.q;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ e a;

    public a(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strC;
        e eVar = this.a;
        synchronized (eVar.d) {
            strC = e.g;
            if (eVar.c != null) {
                try {
                    File file = new File(eVar.c, "tracker_mapping.txt");
                    if (file.exists() && file.canRead()) {
                        strC = q.c(file);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        eVar.b = strC;
        e eVar2 = this.a;
        eVar2.a(eVar2.b);
    }
}
