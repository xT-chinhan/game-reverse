package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class xr implements t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final boolean f1066ms;

    public xr(boolean z) {
        this.f1066ms = z;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t
    public cv ms(t.ms msVar) throws IOException {
        cv cvVarMs;
        ab abVar = (ab) msVar;
        ah ahVarAb = abVar.ab();
        com.bytedance.sdk.component.ah.xr.ms.xr.ab abVarC = abVar.c();
        com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar = (com.bytedance.sdk.component.ah.xr.ms.xr.ah) abVar.ka();
        yu yuVarMs = abVar.ms();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (yuVarMs != null && yuVarMs.c != null) {
            yuVarMs.c.ms(jCurrentTimeMillis);
        }
        abVar.call();
        ahVarAb.ms(yuVarMs);
        abVar.call();
        cv.ms msVarMs = null;
        if (c.ah(yuVarMs.xr()) && yuVarMs.d() != null) {
            if ("100-continue".equalsIgnoreCase(yuVarMs.ms("Expect"))) {
                ahVarAb.ms();
                abVar.call();
                msVarMs = ahVarAb.ms(true);
            }
            if (msVarMs == null) {
                abVar.call();
                com.bytedance.sdk.component.ah.ms.d dVarMs = com.bytedance.sdk.component.ah.ms.sl.ms(new ms(ahVarAb.ms(yuVarMs, yuVarMs.d().xr())));
                yuVarMs.d().ms(dVarMs);
                dVarMs.close();
                abVar.call();
            } else if (!ahVar.ka()) {
                abVarC.d();
            }
        }
        ahVarAb.xr();
        if (msVarMs == null) {
            abVar.call();
            msVarMs = ahVarAb.ms(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (yuVarMs.c != null) {
            yuVarMs.c.xr(jCurrentTimeMillis2);
        }
        cv cvVarMs2 = msVarMs.ms(yuVarMs).ms(abVarC.xr().d()).ms(jCurrentTimeMillis).xr(jCurrentTimeMillis2).ms();
        abVar.call();
        int iAh = cvVarMs2.ah();
        if (this.f1066ms && iAh == 101) {
            cvVarMs = cvVarMs2.ny().ms(com.bytedance.sdk.component.ah.xr.ms.ah.ah).ms();
        } else {
            cvVarMs = cvVarMs2.ny().ms(ahVarAb.ms(cvVarMs2)).ms();
        }
        if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(cvVarMs.ms().ms("Connection")) || ILivePush.ClickType.CLOSE.equalsIgnoreCase(cvVarMs.ms("Connection"))) {
            abVarC.d();
        }
        if ((iAh == 204 || iAh == 205) && cvVarMs.x().xr() > 0) {
            throw new ProtocolException("HTTP " + iAh + " had non-zero Content-Length: " + cvVarMs.x().xr());
        }
        return cvVarMs;
    }

    static final class ms extends com.bytedance.sdk.component.ah.ms.ab {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        long f1067ms;

        ms(qv qvVar) {
            super(qvVar);
        }

        @Override // com.bytedance.sdk.component.ah.ms.ab, com.bytedance.sdk.component.ah.ms.qv
        public void a_(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            super.a_(ahVar, j);
            this.f1067ms += j;
        }
    }
}
