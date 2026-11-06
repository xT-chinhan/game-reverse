package com.tapsdk.tapad.internal.download.m.h;

import android.util.Log;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.i;
import com.tapsdk.tapad.internal.download.m.e.f;
import com.tapsdk.tapad.internal.download.m.f.g;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class a implements c.a, c.b {
    private static final String a = "BreakpointInterceptor";
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    static long a(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    long a(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a) {
        long j;
        String strC = interfaceC0605a.c("Content-Range");
        if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) strC)) {
            j = -1;
        } else {
            long jA = a(strC);
            if (jA > 0) {
                j = jA + 1;
            } else {
                j = -1;
            }
        }
        if (j >= 0) {
            return j;
        }
        String strC2 = interfaceC0605a.c("Content-Length");
        return !com.tapsdk.tapad.internal.download.m.c.a((CharSequence) strC2) ? Long.parseLong(strC2) : j;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    @Override // com.tapsdk.tapad.internal.download.m.h.c.b
    public long a(f fVar) throws IOException {
        long j = fVar.j();
        int iC = fVar.c();
        boolean z = j != -1;
        com.tapsdk.tapad.internal.download.m.g.d dVarI = fVar.i();
        long j2 = 0;
        while (true) {
            try {
                try {
                    long jM = fVar.m();
                    if (jM == -1) {
                        break;
                    }
                    j2 += jM;
                } catch (Exception e) {
                    Log.e(a, e.getMessage());
                    fVar.b();
                    if (!fVar.d().k()) {
                        dVarI.c(iC);
                    }
                }
            } catch (Throwable th) {
                fVar.b();
                if (!fVar.d().k()) {
                    dVarI.c(iC);
                }
                throw th;
            }
        }
        fVar.b();
        if (!fVar.d().k()) {
            dVarI.c(iC);
        }
        if (z) {
            dVarI.d(iC);
            if (j2 != j) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j2 + "!= " + j);
            }
        }
        return j2;
    }

    @Override // com.tapsdk.tapad.internal.download.m.h.c.a
    public com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a b(f fVar) throws IOException {
        com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605aN = fVar.n();
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVarH = fVar.h();
        if (fVar.d().f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        if (cVarH.b() == 1 && !cVarH.k()) {
            long jA = a(interfaceC0605aN);
            long jH = cVarH.h();
            if (jA > 0 && jA != jH) {
                com.tapsdk.tapad.internal.download.m.c.a(a, "SingleBlock special check: the response instance-length[" + jA + "] isn't equal to the instance length from trial-connection[" + jH + "]");
                boolean z = cVarH.b(0).d() != 0;
                com.tapsdk.tapad.internal.download.core.breakpoint.a aVar = new com.tapsdk.tapad.internal.download.core.breakpoint.a(0L, jA);
                cVarH.n();
                cVarH.a(aVar);
                if (z) {
                    com.tapsdk.tapad.internal.download.m.c.c(a, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                i.j().b().a().a(fVar.k(), cVarH, ResumeFailedCause.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (fVar.g().a(cVarH)) {
                return interfaceC0605aN;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }
}
