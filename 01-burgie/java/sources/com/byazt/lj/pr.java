package com.byazt.lj;

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
import com.byazt.auw.DownloadTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 37})
public abstract class pr implements ho {
    public static final String c = pr.class.getSimpleName();
    public volatile boolean hn;
    public WeakReference<Service> uc;
    public final SparseArray<List<DownloadTask>> pr = new SparseArray<>();
    public volatile boolean hw = false;
    public volatile boolean x = false;
    public Handler fw = new Handler(Looper.getMainLooper());
    public Runnable zo = new Runnable() { // from class: com.byazt.lj.pr.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.byazt.p000do.pr.pr()) {
                com.byazt.p000do.pr.hw(pr.c, "tryDownload: 2 try");
            }
            if (!pr.this.hw) {
                if (com.byazt.p000do.pr.pr()) {
                    com.byazt.p000do.pr.hw(pr.c, "tryDownload: 2 error");
                }
                pr.this.startService(hn.of(), null);
            }
        }
    };

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.byazt.lj.ho
    public void pr(WeakReference weakReference) {
        this.uc = weakReference;
    }

    @Override // com.byazt.lj.ho
    public boolean pr() {
        return this.hw;
    }

    @Override // com.byazt.lj.ho
    public boolean hw() {
        com.byazt.p000do.pr.hn(c, "isServiceForeground = " + this.hn);
        return this.hn;
    }

    @Override // com.byazt.lj.ho
    public IBinder pr(Intent intent) {
        com.byazt.p000do.pr.hw(c, "onBind Abs");
        return new Binder();
    }

    @Override // com.byazt.lj.ho
    public void pr(int i, Notification notification) {
        WeakReference<Service> weakReference = this.uc;
        if (weakReference != null && weakReference.get() != null) {
            com.byazt.p000do.pr.hn(c, "startForeground  id = " + i + ", service = " + this.uc.get() + ",  isServiceAlive = " + this.hw);
            try {
                this.uc.get().startForeground(i, notification);
                this.hn = true;
                return;
            } catch (Exception e) {
                return;
            }
        }
        com.byazt.p000do.pr.x(c, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.byazt.lj.ho
    public void pr(boolean z) {
        WeakReference<Service> weakReference = this.uc;
        if (weakReference != null && weakReference.get() != null) {
            com.byazt.p000do.pr.hn(c, "stopForeground  service = " + this.uc.get() + ",  isServiceAlive = " + this.hw);
            try {
                this.hn = false;
                this.uc.get().stopForeground(z);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.byazt.lj.ho
    public void hn() {
    }

    @Override // com.byazt.lj.ho
    public void pr(Intent intent, int i, int i2) {
    }

    @Override // com.byazt.lj.ho
    public void x() {
        this.hw = false;
    }

    public void pr(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.pr) {
            String str = c;
            com.byazt.p000do.pr.hw(str, "pendDownloadTask pendingTasks.size:" + this.pr.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.pr.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.pr.put(downloadId, arrayList);
            }
            com.byazt.p000do.pr.hw(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.byazt.p000do.pr.hw(str, "after pendDownloadTask pendingTasks.size:" + this.pr.size());
        }
    }

    @Override // com.byazt.lj.ho
    public void hw(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.hw) {
            if (com.byazt.p000do.pr.pr()) {
                com.byazt.p000do.pr.hw(c, "tryDownload but service is not alive");
            }
            if (com.byazt.tuy.pr.pr(262144)) {
                pr(downloadTask);
                if (!this.x) {
                    if (com.byazt.p000do.pr.pr()) {
                        com.byazt.p000do.pr.hw(c, "tryDownload: 1");
                    }
                    startService(hn.of(), null);
                    this.x = true;
                    return;
                }
                this.fw.removeCallbacks(this.zo);
                this.fw.postDelayed(this.zo, 10L);
                return;
            }
            pr(downloadTask);
            startService(hn.of(), null);
            return;
        }
        String str = c;
        com.byazt.p000do.pr.hw(str, "tryDownload when isServiceAlive");
        c();
        com.byazt.ts.pr prVarNl = hn.nl();
        if (prVarNl != null) {
            com.byazt.p000do.pr.hw(str, "tryDownload current task: " + downloadTask.getDownloadId());
            prVarNl.pr(downloadTask);
        }
    }

    @Override // com.byazt.lj.ho
    public void hn(DownloadTask downloadTask) {
    }

    public void c() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.pr) {
            com.byazt.p000do.pr.hw(c, "resumePendingTask pendingTasks.size:" + this.pr.size());
            sparseArrayClone = this.pr.clone();
            this.pr.clear();
        }
        com.byazt.ts.pr prVarNl = hn.nl();
        if (prVarNl != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.byazt.p000do.pr.hw(c, "resumePendingTask key:" + downloadTask.getDownloadId());
                        prVarNl.pr(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.byazt.lj.ho
    public void pr(g gVar) {
    }

    @Override // com.byazt.lj.ho
    public void pr(int i) {
        com.byazt.p000do.pr.pr(i);
    }

    @Override // com.byazt.lj.ho
    public void startService() {
        if (!this.hw) {
            if (com.byazt.p000do.pr.pr()) {
                com.byazt.p000do.pr.hw(c, "startService");
            }
            startService(hn.of(), null);
        }
    }
}
