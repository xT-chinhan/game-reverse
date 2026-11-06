package com.ss.android.downloadlib.addownload.compliance;

/* JADX INFO: loaded from: classes3.dex */
public class ah extends com.ss.android.socialbase.downloader.ny.x<Long, com.ss.android.downloadlib.addownload.xr.xr> {

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ah f4370ms = new ah();
    }

    public static ah ms() {
        return ms.f4370ms;
    }

    private ah() {
        super(16, 16);
    }

    public void ms(com.ss.android.downloadlib.addownload.xr.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        put(Long.valueOf(xrVar.ms()), xrVar);
    }

    public com.ss.android.downloadlib.addownload.xr.xr ms(long j, long j2) {
        return (com.ss.android.downloadlib.addownload.xr.xr) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.xr.xr ms(long j) {
        return (com.ss.android.downloadlib.addownload.xr.xr) get(Long.valueOf(j));
    }
}
