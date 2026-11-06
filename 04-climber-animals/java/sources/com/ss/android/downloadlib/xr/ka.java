package com.ss.android.downloadlib.xr;

import com.ss.android.downloadlib.addownload.hi;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka implements com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f4535ms;

    @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
    public void ah() {
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ka f4537ms = new ka();
    }

    public static ka ms() {
        return ms.f4537ms;
    }

    private ka() {
        this.f4535ms = 0L;
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(this);
    }

    @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
    public void xr() {
        this.f4535ms = System.currentTimeMillis();
    }

    public void ms(final d dVar, final long j) {
        if (dVar == null) {
            return;
        }
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.xr.ka.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.ss.android.socialbase.downloader.ms.ms.ms().ah() || System.currentTimeMillis() - ka.this.f4535ms <= j) {
                    dVar.ms(true);
                } else {
                    dVar.ms(false);
                }
            }
        }, j);
    }

    public void ms(d dVar) {
        ms(dVar, 5000L);
    }

    public void xr(d dVar) {
        if (dVar == null) {
            return;
        }
        JSONObject jSONObjectNy = hi.ny();
        int i = ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR;
        int iOptInt = jSONObjectNy.optInt("check_an_result_delay", ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        if (iOptInt > 0) {
            i = iOptInt;
        }
        ms(dVar, i);
    }
}
