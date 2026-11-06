package com.smartdigimkt.o4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static volatile h a;

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    public static void a(com.smartdigimkt.g4.e eVar, f fVar) {
        String str = eVar.d;
        if (TextUtils.isEmpty(str)) {
            fVar.a(com.smartdigimkt.z3.b.a("10008", "The placementId is empty."));
            return;
        }
        try {
            new com.smartdigimkt.f4.f(eVar).a(0, (com.smartdigimkt.a4.b) new g(str, fVar, eVar.g));
        } catch (Throwable th) {
            fVar.a(com.smartdigimkt.z3.b.a("10008", "start bid request with an exception." + th));
        }
    }
}
