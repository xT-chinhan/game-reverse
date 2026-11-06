package com.bytedance.sdk.component.ah.xr.ms.ms;

import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.ms.sl;
import com.bytedance.sdk.component.ah.ms.y;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.g;
import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.component.ah.xr.ms.ah.x;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final c f1116ms;

    public ms(c cVar) {
        this.f1116ms = cVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t
    public cv ms(t.ms msVar) throws IOException {
        c cVar = this.f1116ms;
        cv cvVarMs = cVar != null ? cVar.ms(msVar.ms()) : null;
        ah ahVarMs = new ah.ms(System.currentTimeMillis(), msVar.ms(), cvVarMs).ms();
        yu yuVar = ahVarMs.f1107ms;
        cv cvVar = ahVarMs.xr;
        if (cvVarMs != null && cvVar == null) {
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(cvVarMs.x());
        }
        if (yuVar == null && cvVar == null) {
            return new cv.ms().ms(msVar.ms()).ms(i.HTTP_1_1).ms(504).ms("Unsatisfiable Request (only-if-cached)").ms(com.bytedance.sdk.component.ah.xr.ms.ah.ah).ms(-1L).xr(System.currentTimeMillis()).ms();
        }
        if (yuVar == null) {
            return cvVar.ny().xr(ms(cvVar)).ms();
        }
        try {
            cv cvVarMs2 = msVar.ms(yuVar);
            if (cvVarMs2 == null && cvVarMs != null) {
                com.bytedance.sdk.component.ah.xr.ms.ah.ms(cvVarMs.x());
            }
            if (cvVar != null) {
                if (cvVarMs2.ah() == 304) {
                    cv cvVarMs3 = cvVar.ny().ms(ms(cvVar.ab(), cvVarMs2.ab())).ms(cvVarMs2.zb()).xr(cvVarMs2.u()).xr(ms(cvVar)).ms(ms(cvVarMs2)).ms();
                    cvVarMs2.x().close();
                    this.f1116ms.update(cvVar, cvVarMs3);
                    return cvVarMs3;
                }
                com.bytedance.sdk.component.ah.xr.ms.ah.ms(cvVar.x());
            }
            cv cvVarMs4 = cvVarMs2.ny().xr(ms(cvVar)).ms(ms(cvVarMs2)).ms();
            if (this.f1116ms != null) {
                if (com.bytedance.sdk.component.ah.xr.ms.ah.ka.ah(cvVarMs4) && ah.ms(cvVarMs4, yuVar)) {
                    return ms(this.f1116ms.ms(cvVarMs4), cvVarMs4);
                }
                com.bytedance.sdk.component.ah.xr.ms.ah.c.ms(yuVar.xr());
            }
            return cvVarMs4;
        } catch (Throwable th) {
            if (cvVarMs != null) {
                com.bytedance.sdk.component.ah.xr.ms.ah.ms(cvVarMs.x());
            }
            throw th;
        }
    }

    private static cv ms(cv cvVar) {
        return (cvVar == null || cvVar.x() == null) ? cvVar : cvVar.ny().ms((g) null).ms();
    }

    private cv ms(final xr xrVar, cv cvVar) throws IOException {
        qv qvVarMs;
        if (xrVar == null || (qvVarMs = xrVar.ms()) == null) {
            return cvVar;
        }
        final com.bytedance.sdk.component.ah.ms.ka kaVarAh = cvVar.x().ah();
        final com.bytedance.sdk.component.ah.ms.d dVarMs = sl.ms(qvVarMs);
        return cvVar.ny().ms(new x(cvVar.ms("Content-Type"), cvVar.x().xr(), sl.ms(new y() { // from class: com.bytedance.sdk.component.ah.xr.ms.ms.ms.1

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            boolean f1117ms;

            @Override // com.bytedance.sdk.component.ah.ms.y
            public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
                try {
                    long jMs = kaVarAh.ms(ahVar, j);
                    if (jMs == -1) {
                        if (!this.f1117ms) {
                            this.f1117ms = true;
                            dVarMs.close();
                        }
                        return -1L;
                    }
                    ahVar.ms(dVarMs.ah(), ahVar.xr() - jMs, jMs);
                    dVarMs.nw();
                    return jMs;
                } catch (IOException e) {
                    if (!this.f1117ms) {
                        this.f1117ms = true;
                    }
                    throw e;
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.y
            public com.bytedance.sdk.component.ah.ms.t ms() {
                return kaVarAh.ms();
            }

            @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f1117ms && !com.bytedance.sdk.component.ah.xr.ms.ah.ms(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f1117ms = true;
                }
                kaVarAh.close();
            }
        }))).ms();
    }

    private static com.bytedance.sdk.component.ah.xr.qv ms(com.bytedance.sdk.component.ah.xr.qv qvVar, com.bytedance.sdk.component.ah.xr.qv qvVar2) {
        com.bytedance.sdk.component.ah.xr.qv.ms msVar = new com.bytedance.sdk.component.ah.xr.qv.ms();
        int iMs = qvVar.ms();
        for (int i = 0; i < iMs; i++) {
            String strMs = qvVar.ms(i);
            String strXr = qvVar.xr(i);
            if ((!"Warning".equalsIgnoreCase(strMs) || !strXr.startsWith("1")) && (!ms(strMs) || qvVar2.ms(strMs) == null)) {
                com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(msVar, strMs, strXr);
            }
        }
        int iMs2 = qvVar2.ms();
        for (int i2 = 0; i2 < iMs2; i2++) {
            String strMs2 = qvVar2.ms(i2);
            if (!"Content-Length".equalsIgnoreCase(strMs2) && ms(strMs2)) {
                com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(msVar, strMs2, qvVar2.xr(i2));
            }
        }
        return msVar.ms();
    }

    static boolean ms(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
