package com.smartdigimkt.n4;

import com.smartdigimkt.l4.u;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static volatile boolean a = false;

    public static b a(com.smartdigimkt.k4.d dVar) {
        if (!a) {
            a = true;
            com.smartdigimkt.q3.b bVar = com.smartdigimkt.q3.f.a().a;
            ExecutorService executorServiceD = bVar != null ? bVar.d() : null;
            if (executorServiceD != null) {
                u.b = executorServiceD;
            }
            u.a = new c();
        }
        return new b(dVar);
    }
}
