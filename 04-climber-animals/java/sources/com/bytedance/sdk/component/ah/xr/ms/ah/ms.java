package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.nw;
import com.bytedance.sdk.component.ah.xr.op;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.yu;
import com.bytedance.sdk.component.ah.xr.zb;
import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final zb f1064ms;

    public ms(zb zbVar) {
        this.f1064ms = zbVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t
    public cv ms(t.ms msVar) throws IOException {
        yu yuVarMs = msVar.ms();
        yu.ms msVarC = yuVarMs.c();
        op opVarD = yuVarMs.d();
        if (opVarD != null) {
            nw nwVarMs = opVarD.ms();
            if (nwVarMs != null) {
                msVarC.ms("Content-Type", nwVarMs.toString());
            }
            long jXr = opVarD.xr();
            if (jXr != -1) {
                msVarC.ms("Content-Length", Long.toString(jXr));
                msVarC.ms("Transfer-Encoding");
            } else {
                msVarC.ms("Transfer-Encoding", "chunked");
                msVarC.ms("Content-Length");
            }
        }
        boolean z = false;
        if (yuVarMs.ms("Host") == null) {
            msVarC.ms("Host", com.bytedance.sdk.component.ah.xr.ms.ah.ms(yuVarMs.ms(), false));
        }
        if (yuVarMs.ms("Connection") == null) {
            msVarC.ms("Connection", "Keep-Alive");
        }
        if (yuVarMs.ms("Accept-Encoding") == null && yuVarMs.ms("Range") == null) {
            msVarC.ms("Accept-Encoding", Constants.CP_GZIP);
            z = true;
        }
        List<com.bytedance.sdk.component.ah.xr.sl> listMs = this.f1064ms.ms(yuVarMs.ms());
        if (!listMs.isEmpty()) {
            msVarC.ms("Cookie", ms(listMs));
        }
        if (yuVarMs.ms("User-Agent") == null) {
            msVarC.ms("User-Agent", com.bytedance.sdk.component.ah.xr.ms.d.ms());
        }
        cv cvVarMs = msVar.ms(msVarC.ms());
        ka.ms(this.f1064ms, yuVarMs.ms(), cvVarMs.ab());
        cv.ms msVarMs = cvVarMs.ny().ms(yuVarMs);
        if (z && Constants.CP_GZIP.equalsIgnoreCase(cvVarMs.ms("Content-Encoding")) && ka.ah(cvVarMs)) {
            com.bytedance.sdk.component.ah.ms.ch chVar = new com.bytedance.sdk.component.ah.ms.ch(cvVarMs.x().ah());
            msVarMs.ms(cvVarMs.ab().xr().xr("Content-Encoding").xr("Content-Length").ms());
            msVarMs.ms(new x(cvVarMs.ms("Content-Type"), -1L, com.bytedance.sdk.component.ah.ms.sl.ms(chVar)));
        }
        return msVarMs.ms();
    }

    private String ms(List<com.bytedance.sdk.component.ah.xr.sl> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.ah.xr.sl slVar = list.get(i);
            sb.append(slVar.ms()).append('=').append(slVar.xr());
        }
        return sb.toString();
    }
}
