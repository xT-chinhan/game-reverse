package com.tapsdk.tapad.internal.ui.views.web;

import com.tapsdk.tapad.internal.download.l;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static final String a = "WebFileDownload";
    private static final l b = new l();

    private e() {
    }

    public static com.tapsdk.tapad.internal.download.f a(b bVar, c cVar, com.tapsdk.tapad.internal.download.c cVar2) {
        com.tapsdk.tapad.internal.download.f fVarA = new com.tapsdk.tapad.internal.download.f.a(bVar.a, cVar.b, bVar.b).c(true).c(500).a(true).b(true).a();
        l lVar = b;
        lVar.a(fVarA.b());
        lVar.d(fVarA, cVar2);
        return fVarA;
    }
}
