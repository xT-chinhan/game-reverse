package com.byazt.xv;

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
import com.byazt.wm.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 19})
public abstract class n implements k {
    public static final String l = "n";
    public volatile boolean s;
    public WeakReference<Service> w;
    public final SparseArray<List<DownloadTask>> n = new SparseArray<>();
    public volatile boolean qg = false;
    public volatile boolean q = false;
    public Handler x = new Handler(Looper.getMainLooper());
    public Runnable fs = new Runnable() { // from class: com.byazt.xv.n.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.byazt.fe.n.n()) {
                com.byazt.fe.n.qg(n.l, "tryDownload: 2 try");
            }
            if (n.this.qg) {
                return;
            }
            if (com.byazt.fe.n.n()) {
                com.byazt.fe.n.qg(n.l, "tryDownload: 2 error");
            }
            n.this.startService(s.u(), null);
        }
    };

    @Override // com.byazt.xv.k
    public void n(Intent intent, int i, int i2) {
    }

    @Override // com.byazt.xv.k
    public void n(sz szVar) {
    }

    @Override // com.byazt.xv.k
    public void s() {
    }

    @Override // com.byazt.xv.k
    public void s(DownloadTask downloadTask) {
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.byazt.xv.k
    public void n(WeakReference weakReference) {
        this.w = weakReference;
    }

    @Override // com.byazt.xv.k
    public boolean n() {
        return this.qg;
    }

    @Override // com.byazt.xv.k
    public boolean qg() {
        com.byazt.fe.n.s(l, "isServiceForeground = " + this.s);
        return this.s;
    }

    @Override // com.byazt.xv.k
    public IBinder n(Intent intent) {
        com.byazt.fe.n.qg(l, "onBind Abs");
        return new Binder();
    }

    @Override // com.byazt.xv.k
    public void n(int i, Notification notification) {
        WeakReference<Service> weakReference = this.w;
        if (weakReference != null && weakReference.get() != null) {
            com.byazt.fe.n.s(l, "startForeground  id = " + i + ", service = " + this.w.get() + ",  isServiceAlive = " + this.qg);
            try {
                this.w.get().startForeground(i, notification);
                this.s = true;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.byazt.fe.n.q(l, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.byazt.xv.k
    public void n(boolean z) {
        WeakReference<Service> weakReference = this.w;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.byazt.fe.n.s(l, "stopForeground  service = " + this.w.get() + ",  isServiceAlive = " + this.qg);
        try {
            this.s = false;
            this.w.get().stopForeground(z);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.xv.k
    public void q() {
        this.qg = false;
    }

    public void n(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.n) {
            String str = l;
            com.byazt.fe.n.qg(str, "pendDownloadTask pendingTasks.size:" + this.n.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.n.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.n.put(downloadId, arrayList);
            }
            com.byazt.fe.n.qg(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.byazt.fe.n.qg(str, "after pendDownloadTask pendingTasks.size:" + this.n.size());
        }
    }

    @Override // com.byazt.xv.k
    public void qg(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.qg) {
            if (com.byazt.fe.n.n()) {
                com.byazt.fe.n.qg(l, "tryDownload but service is not alive");
            }
            if (com.byazt.ta.n.n(262144)) {
                n(downloadTask);
                if (!this.q) {
                    if (com.byazt.fe.n.n()) {
                        com.byazt.fe.n.qg(l, "tryDownload: 1");
                    }
                    startService(s.u(), null);
                    this.q = true;
                    return;
                }
                this.x.removeCallbacks(this.fs);
                this.x.postDelayed(this.fs, 10L);
                return;
            }
            n(downloadTask);
            startService(s.u(), null);
            return;
        }
        String str = l;
        com.byazt.fe.n.qg(str, "tryDownload when isServiceAlive");
        l();
        com.byazt.i.n nVarLn = s.ln();
        if (nVarLn != null) {
            com.byazt.fe.n.qg(str, "tryDownload current task: " + downloadTask.getDownloadId());
            nVarLn.n(downloadTask);
        }
    }

    public void l() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.n) {
            com.byazt.fe.n.qg(l, "resumePendingTask pendingTasks.size:" + this.n.size());
            sparseArrayClone = this.n.clone();
            this.n.clear();
        }
        com.byazt.i.n nVarLn = s.ln();
        if (nVarLn != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.byazt.fe.n.qg(l, "resumePendingTask key:" + downloadTask.getDownloadId());
                        nVarLn.n(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.byazt.xv.k
    public void n(int i) {
        com.byazt.fe.n.n(i);
    }

    @Override // com.byazt.xv.k
    public void startService() {
        if (this.qg) {
            return;
        }
        if (com.byazt.fe.n.n()) {
            com.byazt.fe.n.qg(l, "startService");
        }
        startService(s.u(), null);
    }
}
