package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;

/* JADX INFO: loaded from: classes3.dex */
public class x extends com.ss.android.socialbase.downloader.downloader.ms {
    private static final String ka = "x";

    @Override // com.ss.android.socialbase.downloader.downloader.ms
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) DownloadService.class));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) DownloadService.class));
        this.xr = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void ah() {
        if (com.ss.android.socialbase.downloader.ny.ms.ms(262144)) {
            this.xr = true;
            this.d = false;
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.xr(ka, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void ms(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(ka, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.ny.ms.ms(262144)) {
            this.xr = true;
        }
        ka();
    }
}
