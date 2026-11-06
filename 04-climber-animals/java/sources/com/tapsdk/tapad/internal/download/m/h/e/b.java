package com.tapsdk.tapad.internal.download.m.h.e;

import com.tapsdk.tapad.internal.download.i;
import com.tapsdk.tapad.internal.download.m.e.f;
import com.tapsdk.tapad.internal.download.m.h.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c.a {
    private static final String a = "HeaderInterceptor";

    @Override // com.tapsdk.tapad.internal.download.m.h.c.a
    public com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a b(f fVar) throws IOException {
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVarH = fVar.h();
        com.tapsdk.tapad.internal.download.core.connection.a aVarF = fVar.f();
        com.tapsdk.tapad.internal.download.f fVarK = fVar.k();
        Map<String, List<String>> mapK = fVarK.k();
        if (mapK != null) {
            com.tapsdk.tapad.internal.download.m.c.b(mapK, aVarF);
        }
        if (mapK == null || !mapK.containsKey("User-Agent")) {
            com.tapsdk.tapad.internal.download.m.c.a(aVarF);
        }
        int iC = fVar.c();
        com.tapsdk.tapad.internal.download.core.breakpoint.a aVarB = cVarH.b(iC);
        if (aVarB == null) {
            throw new IOException("No block-info found on " + iC);
        }
        aVarF.a("Range", ("bytes=" + aVarB.d() + "-") + aVarB.e());
        com.tapsdk.tapad.internal.download.m.c.a(a, "AssembleHeaderRange (" + fVarK.b() + ") block(" + iC + ") downloadFrom(" + aVarB.d() + ") currentOffset(" + aVarB.c() + ")");
        String strC = cVarH.c();
        if (!com.tapsdk.tapad.internal.download.m.c.a((CharSequence) strC)) {
            aVarF.a("If-Match", strC);
        }
        if (fVar.d().f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        i.j().b().a().a(fVarK, iC, aVarF.c());
        com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605aN = fVar.n();
        if (fVar.d().f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        Map<String, List<String>> mapE = interfaceC0605aN.e();
        if (mapE == null) {
            mapE = new HashMap<>();
        }
        i.j().b().a().a(fVarK, iC, interfaceC0605aN.f(), mapE);
        i.j().f().a(interfaceC0605aN, iC, cVarH).a();
        String strC2 = interfaceC0605aN.c("Content-Length");
        fVar.b((strC2 == null || strC2.length() == 0) ? com.tapsdk.tapad.internal.download.m.c.d(interfaceC0605aN.c("Content-Range")) : com.tapsdk.tapad.internal.download.m.c.c(strC2));
        return interfaceC0605aN;
    }
}
