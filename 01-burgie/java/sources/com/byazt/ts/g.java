package com.byazt.ts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.byazt.auw.DownloadTask;
import com.byazt.lj.CSJIndependentProcessDownloadService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g extends com.byazt.lj.pr implements ServiceConnection {
    public static final String c = g.class.getSimpleName();
    public com.byazt.lj.g fw;
    public com.byazt.lj.aj uc;
    public int zo = -1;

    @Override // com.byazt.lj.pr
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.byazt.p000do.pr.hw(c, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.byazt.tuy.uc.pr()) {
                intent.putExtra("fix_downloader_db_sigbus", com.byazt.ew.pr.hn().pr("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.lj.pr
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.byazt.p000do.pr.hw(c, "stopService");
        this.hw = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public IBinder pr(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.byazt.ew.pr.pr("fix_sigbus_downloader_db", true);
        }
        com.byazt.p000do.pr.hw(c, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void hw(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.p000do.pr.hw(c, "tryDownload aidlService == null:" + (this.uc == null));
        if (this.uc == null) {
            pr(downloadTask);
            startService(com.byazt.lj.hn.of(), this);
        } else {
            fw();
            try {
                this.uc.pr(com.byazt.tuy.fw.pr(downloadTask));
            } catch (RemoteException e) {
            }
        }
    }

    private void fw() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.pr) {
                sparseArrayClone = this.pr.clone();
                this.pr.clear();
            }
            if (sparseArrayClone != null && sparseArrayClone.size() > 0 && com.byazt.lj.hn.nl() != null) {
                for (int i = 0; i < sparseArrayClone.size(); i++) {
                    List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                    if (list != null) {
                        Iterator<DownloadTask> it = list.iterator();
                        while (it.hasNext()) {
                            try {
                                this.uc.pr(com.byazt.tuy.fw.pr(it.next()));
                            } catch (RemoteException e) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.byazt.p000do.pr.hw(c, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void hn(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.lj.x.pr().pr(downloadTask.getDownloadId(), true);
        pr prVarNl = com.byazt.lj.hn.nl();
        if (prVarNl != null) {
            prVarNl.pr(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = c;
        com.byazt.p000do.pr.hw(str, "onServiceConnected ");
        this.uc = com.byazt.lj.aj.pr.pr(iBinder);
        com.byazt.lj.g gVar = this.fw;
        if (gVar != null) {
            gVar.pr(iBinder);
        }
        com.byazt.p000do.pr.hw(str, "onServiceConnected aidlService!=null" + (this.uc != null) + " pendingTasks.size:" + this.pr.size());
        if (this.uc != null) {
            com.byazt.lj.x.pr().hw();
            this.hw = true;
            this.x = false;
            int i = this.zo;
            if (i != -1) {
                try {
                    this.uc.k(i);
                } catch (RemoteException e) {
                }
            }
            if (this.uc != null) {
                fw();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.byazt.p000do.pr.hw(c, "onServiceDisconnected ");
        this.uc = null;
        this.hw = false;
        com.byazt.lj.g gVar = this.fw;
        if (gVar != null) {
            gVar.zo();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.uc = null;
        com.byazt.lj.g gVar = this.fw;
        if (gVar != null) {
            gVar.zo();
        }
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void pr(com.byazt.lj.g gVar) {
        this.fw = gVar;
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void pr(int i) {
        com.byazt.lj.aj ajVar = this.uc;
        if (ajVar == null) {
            this.zo = i;
        } else {
            try {
                ajVar.k(i);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void startService() {
        if (this.uc == null) {
            startService(com.byazt.lj.hn.of(), this);
        }
    }
}
