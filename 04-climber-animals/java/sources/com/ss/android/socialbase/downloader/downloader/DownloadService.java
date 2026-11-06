package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadService extends Service {
    private static final String xr = "DownloadService";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected ub f4655ms;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ah.ms(this);
        ub ubVarYu = ah.yu();
        this.f4655ms = ubVarYu;
        ubVarYu.ms(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.ah.ms.xr(xr, "onBind downloadServiceHandler != null:" + (this.f4655ms != null));
        ub ubVar = this.f4655ms;
        if (ubVar != null) {
            return ubVar.ms(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(xr, "DownloadService onStartCommand");
        }
        this.f4655ms.ah();
        ExecutorService executorServiceSl = ah.sl();
        if (executorServiceSl != null) {
            executorServiceSl.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadService.this.f4655ms != null) {
                        DownloadService.this.f4655ms.ms(intent, i, i2);
                    }
                }
            });
        }
        return ah.ch() ? 2 : 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(xr, "Service onDestroy");
        }
        ub ubVar = this.f4655ms;
        if (ubVar != null) {
            ubVar.d();
            this.f4655ms = null;
        }
        super.onDestroy();
    }
}
