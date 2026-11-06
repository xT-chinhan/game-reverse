package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ms implements ub {
    private static final String ka = "ms";
    protected volatile boolean ah;
    private WeakReference<Service> c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final SparseArray<List<DownloadTask>> f4666ms = new SparseArray<>();
    protected volatile boolean xr = false;
    protected volatile boolean d = false;
    private Handler ab = new Handler(Looper.getMainLooper());
    private Runnable x = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ms.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.xr(ms.ka, "tryDownload: 2 try");
            }
            if (ms.this.xr) {
                return;
            }
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.xr(ms.ka, "tryDownload: 2 error");
            }
            ms.this.startService(ah.k(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ah() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ah(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ms(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ms(u uVar) {
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ms(WeakReference weakReference) {
        this.c = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public boolean ms() {
        return this.xr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public boolean xr() {
        com.ss.android.socialbase.downloader.ah.ms.ah(ka, "isServiceForeground = " + this.ah);
        return this.ah;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public IBinder ms(Intent intent) {
        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ms(int i, Notification notification) {
        WeakReference<Service> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.ah.ms.ah(ka, "startForeground  id = " + i + ", service = " + this.c.get() + ",  isServiceAlive = " + this.xr);
            try {
                this.c.get().startForeground(i, notification);
                this.ah = true;
                return;
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
                return;
            }
        }
        com.ss.android.socialbase.downloader.ah.ms.d(ka, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ms(boolean z) {
        WeakReference<Service> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.ah(ka, "stopForeground  service = " + this.c.get() + ",  isServiceAlive = " + this.xr);
        try {
            this.ah = false;
            this.c.get().stopForeground(z);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void d() {
        this.xr = false;
    }

    public void ms(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.f4666ms) {
            String str = ka;
            com.ss.android.socialbase.downloader.ah.ms.xr(str, "pendDownloadTask pendingTasks.size:" + this.f4666ms.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.f4666ms.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f4666ms.put(downloadId, arrayList);
            }
            com.ss.android.socialbase.downloader.ah.ms.xr(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.ss.android.socialbase.downloader.ah.ms.xr(str, "after pendDownloadTask pendingTasks.size:" + this.f4666ms.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void xr(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.xr) {
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.xr(ka, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.ny.ms.ms(262144)) {
                ms(downloadTask);
                if (!this.d) {
                    if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "tryDownload: 1");
                    }
                    startService(ah.k(), null);
                    this.d = true;
                    return;
                }
                this.ab.removeCallbacks(this.x);
                this.ab.postDelayed(this.x, 10L);
                return;
            }
            ms(downloadTask);
            startService(ah.k(), null);
            return;
        }
        String str = ka;
        com.ss.android.socialbase.downloader.ah.ms.xr(str, "tryDownload when isServiceAlive");
        ka();
        com.ss.android.socialbase.downloader.impls.ms msVarG = ah.g();
        if (msVarG != null) {
            com.ss.android.socialbase.downloader.ah.ms.xr(str, "tryDownload current task: " + downloadTask.getDownloadId());
            msVarG.ms(downloadTask);
        }
    }

    protected void ka() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.f4666ms) {
            com.ss.android.socialbase.downloader.ah.ms.xr(ka, "resumePendingTask pendingTasks.size:" + this.f4666ms.size());
            sparseArrayClone = this.f4666ms.clone();
            this.f4666ms.clear();
        }
        com.ss.android.socialbase.downloader.impls.ms msVarG = ah.g();
        if (msVarG != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "resumePendingTask key:" + downloadTask.getDownloadId());
                        msVarG.ms(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void ms(int i) {
        com.ss.android.socialbase.downloader.ah.ms.ms(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ub
    public void startService() {
        if (this.xr) {
            return;
        }
        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(ka, "startService");
        }
        startService(ah.k(), null);
    }
}
