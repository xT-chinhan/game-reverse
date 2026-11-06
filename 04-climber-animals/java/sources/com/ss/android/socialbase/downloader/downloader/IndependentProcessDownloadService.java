package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ah.ms(this);
        if (ah.l() == null) {
            ah.ms(new b());
        }
        this.f4655ms = ah.op();
        this.f4655ms.ms(new WeakReference(this));
    }
}
