package com.ss.android.socialbase.downloader.ka;

import com.ss.android.socialbase.downloader.ny.c;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final InputStream f4705ms;
    private final com.ss.android.socialbase.downloader.c.ms xr;

    @Override // com.ss.android.socialbase.downloader.ka.xr
    public void ms(com.ss.android.socialbase.downloader.c.ms msVar) {
    }

    public ah(InputStream inputStream, int i) {
        this.f4705ms = inputStream;
        this.xr = new com.ss.android.socialbase.downloader.c.ms(i);
    }

    @Override // com.ss.android.socialbase.downloader.ka.xr
    public com.ss.android.socialbase.downloader.c.ms ms() throws IOException {
        com.ss.android.socialbase.downloader.c.ms msVar = this.xr;
        msVar.ah = this.f4705ms.read(msVar.f4619ms);
        return this.xr;
    }

    @Override // com.ss.android.socialbase.downloader.ka.xr
    public void xr() {
        c.ms(this.f4705ms);
    }
}
