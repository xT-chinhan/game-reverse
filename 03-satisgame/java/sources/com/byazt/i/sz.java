package com.byazt.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.CSJIndependentProcessDownloadService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 110})
public class sz extends com.byazt.xv.n implements ServiceConnection {
    public static final String l = "sz";
    public int fs = -1;
    public com.byazt.xv.rv w;
    public com.byazt.xv.sz x;

    @Override // com.byazt.xv.n
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.byazt.fe.n.qg(l, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.byazt.ta.w.n()) {
                intent.putExtra("fix_downloader_db_sigbus", com.byazt.f.n.s().n("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.xv.n
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.byazt.fe.n.qg(l, "stopService");
        this.qg = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public IBinder n(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.byazt.f.n.n("fix_sigbus_downloader_db", true);
        }
        com.byazt.fe.n.qg(l, "onBind IndependentDownloadBinder");
        return new oa();
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void qg(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.fe.n.qg(l, "tryDownload aidlService == null:" + (this.w == null));
        if (this.w == null) {
            n(downloadTask);
            startService(com.byazt.xv.s.u(), this);
        } else {
            x();
            try {
                this.w.n(com.byazt.ta.x.n(downloadTask));
            } catch (RemoteException unused) {
            }
        }
    }

    private void x() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.n) {
                sparseArrayClone = this.n.clone();
                this.n.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.byazt.xv.s.ln() == null) {
                return;
            }
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.w.n(com.byazt.ta.x.n(it.next()));
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.byazt.fe.n.qg(l, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void s(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.xv.q.n().n(downloadTask.getDownloadId(), true);
        n nVarLn = com.byazt.xv.s.ln();
        if (nVarLn != null) {
            nVarLn.n(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = l;
        com.byazt.fe.n.qg(str, "onServiceConnected ");
        this.w = com.byazt.xv.rv.n.n(iBinder);
        com.byazt.xv.sz szVar = this.x;
        if (szVar != null) {
            szVar.n(iBinder);
        }
        com.byazt.fe.n.qg(str, "onServiceConnected aidlService!=null" + (this.w != null) + " pendingTasks.size:" + this.n.size());
        if (this.w != null) {
            com.byazt.xv.q.n().qg();
            this.qg = true;
            this.q = false;
            int i = this.fs;
            if (i != -1) {
                try {
                    this.w.d(i);
                } catch (RemoteException unused) {
                }
            }
            if (this.w != null) {
                x();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.byazt.fe.n.qg(l, "onServiceDisconnected ");
        this.w = null;
        this.qg = false;
        com.byazt.xv.sz szVar = this.x;
        if (szVar != null) {
            szVar.fs();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.w = null;
        com.byazt.xv.sz szVar = this.x;
        if (szVar != null) {
            szVar.fs();
        }
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void n(com.byazt.xv.sz szVar) {
        this.x = szVar;
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void n(int i) {
        com.byazt.xv.rv rvVar = this.w;
        if (rvVar == null) {
            this.fs = i;
        } else {
            try {
                rvVar.d(i);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void startService() {
        if (this.w == null) {
            startService(com.byazt.xv.s.u(), this);
        }
    }
}
