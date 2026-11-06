package com.ss.android.socialbase.downloader.c;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class sl implements ka {
    private final ka ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ny f4621ms;
    private final com.ss.android.socialbase.downloader.model.ka xr;

    public sl(DownloadInfo downloadInfo, xr xrVar, ny nyVar) throws BaseException {
        this.f4621ms = nyVar;
        this.xr = ms(downloadInfo, nyVar);
        this.ah = new x(xrVar, this);
    }

    public ka ms() {
        return this.ah;
    }

    @Override // com.ss.android.socialbase.downloader.c.ka
    public void xr(ms msVar) throws IOException {
        this.xr.ms(msVar.f4619ms, 0, msVar.ah);
        this.f4621ms.xr(msVar.ah);
    }

    public void xr() throws IOException {
        this.xr.xr();
    }

    public void ah() throws IOException {
        this.xr.ah();
    }

    public void d() {
        com.ss.android.socialbase.downloader.ny.c.ms(this.xr);
    }

    public ny ka() {
        return this.f4621ms;
    }

    private com.ss.android.socialbase.downloader.model.ka ms(DownloadInfo downloadInfo, ny nyVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.ka kaVarMs = com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("flush_buffer_size_byte", -1));
        try {
            kaVarMs.ms(nyVar.ka());
            return kaVarMs;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }
}
