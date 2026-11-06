package com.ss.android.socialbase.downloader.c;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class x implements ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ka f4623ms;
    private final ka xr;

    x(ka kaVar, ka kaVar2) {
        this.f4623ms = kaVar;
        this.xr = kaVar2;
    }

    @Override // com.ss.android.socialbase.downloader.c.ka
    public void xr(ms msVar) throws IOException {
        msVar.xr = this.xr;
        this.f4623ms.xr(msVar);
    }
}
