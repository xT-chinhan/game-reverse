package com.kwad.sdk.core.diskcache.b;

import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    static void a(final com.kwad.sdk.core.diskcache.a.a aVar, final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                OutputStream outputStreamDs = null;
                try {
                    com.kwad.sdk.core.diskcache.a.a.C0488a c0488aDE = aVar.dE(str2);
                    if (c0488aDE != null) {
                        outputStreamDs = c0488aDE.ds(0);
                        if (b.a(str, outputStreamDs, new com.kwad.sdk.core.network.a.a.C0498a())) {
                            c0488aDE.commit();
                        } else {
                            c0488aDE.abort();
                        }
                        aVar.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamDs);
                }
            }
        });
    }

    static File a(com.kwad.sdk.core.diskcache.a.a aVar, String str) throws Throwable {
        com.kwad.sdk.core.diskcache.a.a.c cVarDD;
        com.kwad.sdk.core.diskcache.a.a.c cVar = null;
        try {
            cVarDD = aVar.dD(str);
            if (cVarDD != null) {
                try {
                    File fileDv = cVarDD.dv(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVarDD);
                    return fileDv;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar = cVarDD;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVarDD = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVarDD);
        return null;
    }

    static boolean a(com.kwad.sdk.core.diskcache.a.a aVar, String str, String str2, com.kwad.sdk.core.network.a.a.C0498a c0498a) {
        boolean z = false;
        OutputStream outputStreamDs = null;
        try {
            try {
                com.kwad.sdk.core.diskcache.a.a.C0488a c0488aDE = aVar.dE(str2);
                if (c0488aDE != null) {
                    outputStreamDs = c0488aDE.ds(0);
                    if (a(str, outputStreamDs, c0498a)) {
                        c0488aDE.commit();
                        z = true;
                    } else {
                        c0488aDE.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c0498a.msg = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamDs);
        }
    }

    public static boolean a(String str, OutputStream outputStream, com.kwad.sdk.core.network.a.a.C0498a c0498a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0498a, -1L, true, null);
    }
}
