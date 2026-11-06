package com.byazt.ts;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.ls;
import com.byazt.fn.y;
import com.byazt.lj.CSJIndependentProcessDownloadService;
import com.byazt.lj.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 19})
public class ho implements com.byazt.lj.g, com.byazt.lj.m {
    public static final String pr = ho.class.getSimpleName();
    public com.byazt.lj.ho<CSJIndependentProcessDownloadService> hn;
    public volatile com.byazt.lj.aj hw;
    public com.byazt.lj.m x = new nt();

    public ho() {
        com.byazt.lj.ho<CSJIndependentProcessDownloadService> hoVarIu = com.byazt.lj.hn.iu();
        this.hn = hoVarIu;
        hoVarIu.pr(this);
    }

    @Override // com.byazt.lj.m
    public void pr(int i) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.pr(i);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, boolean z) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.pr(i, z);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public boolean hw(int i) {
        if (this.hw == null) {
            return false;
        }
        try {
            return this.hw.hw(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public void hn(int i) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.hn(i);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void x(int i) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.x(i);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void pr() {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.pr();
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public long c(int i) {
        if (this.hw == null) {
            return 0L;
        }
        try {
            return this.hw.c(i);
        } catch (RemoteException e) {
            return 0L;
        }
    }

    @Override // com.byazt.lj.m
    public int uc(int i) {
        if (this.hw == null) {
            return 0;
        }
        try {
            return this.hw.uc(i);
        } catch (RemoteException e) {
            return 0;
        }
    }

    @Override // com.byazt.lj.m
    public boolean fw(int i) {
        if (this.hw == null) {
            return false;
        }
        try {
            return this.hw.fw(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public DownloadInfo zo(int i) {
        if (this.hw == null) {
            return this.x.zo(i);
        }
        try {
            return this.hw.zo(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> pr(String str) {
        if (this.hw == null) {
            return this.x.pr(str);
        }
        try {
            return this.hw.pr(str);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public List<com.byazt.auw.hw> aj(int i) {
        if (this.hw == null) {
            return this.x.aj(i);
        }
        try {
            return this.hw.aj(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public int pr(String str, String str2) {
        return com.byazt.lj.hn.pr(str, str2);
    }

    @Override // com.byazt.lj.m
    public DownloadInfo hw(String str, String str2) {
        return zo(pr(str, str2));
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> hw(String str) {
        if (this.hw == null) {
            return this.x.hw(str);
        }
        try {
            return this.hw.hw(str);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> hn(String str) {
        if (this.hw == null) {
            return this.x.hn(str);
        }
        try {
            return this.hw.hn(str);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> x() {
        if (this.hw == null) {
            return this.x.x();
        }
        try {
            return this.hw.hw();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public void pr(List<String> list) {
        if (this.hw == null) {
            this.x.pr(list);
        } else {
            try {
                this.hw.pr(list);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void hw(List<String> list) {
        if (this.hw == null) {
            this.x.hw(list);
        } else {
            try {
                this.hw.hw(list);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void hw(int i, boolean z) {
        if (this.hw == null) {
            this.x.hw(i, z);
        } else {
            try {
                this.hw.hw(i, z);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void vk(int i) {
        if (this.hw == null) {
            this.x.vk(i);
        } else {
            try {
                this.hw.vk(i);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.hw(i, i2, com.byazt.tuy.fw.pr(iDownloadListener, ucVar != com.byazt.mrs.uc.SUB), ucVar.ordinal(), z);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z, boolean z2) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.pr(i, i2, com.byazt.tuy.fw.pr(iDownloadListener, ucVar != com.byazt.mrs.uc.SUB), ucVar.ordinal(), z, z2);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void hw(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.pr(i, i2, com.byazt.tuy.fw.pr(iDownloadListener, ucVar != com.byazt.mrs.uc.SUB), ucVar.ordinal(), z);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public boolean pr(DownloadInfo downloadInfo) {
        if (this.hw == null) {
            return this.x.pr(downloadInfo);
        }
        try {
            this.hw.pr(downloadInfo);
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, Notification notification) {
        if (this.hw == null) {
            com.byazt.p000do.pr.x(pr, "startForeground, aidlService is null");
            return;
        }
        com.byazt.p000do.pr.hn(pr, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.hw.pr(i, notification);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void pr(boolean z, boolean z2) {
        if (this.hw == null) {
            com.byazt.p000do.pr.x(pr, "stopForeground, aidlService is null");
            return;
        }
        com.byazt.p000do.pr.hn(pr, "aidlService.stopForeground");
        try {
            this.hw.pr(z2);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public boolean hw() {
        if (this.hw == null) {
            com.byazt.p000do.pr.x(pr, "isServiceForeground, aidlService is null");
            return false;
        }
        com.byazt.p000do.pr.hn(pr, "aidlService.isServiceForeground");
        try {
            return this.hw.uc();
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public boolean hn() {
        return com.byazt.lj.hn.ii();
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> x(String str) {
        if (this.hw == null) {
            return this.x.x(str);
        }
        try {
            return this.hw.c(str);
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> c(String str) {
        if (this.hw != null) {
            try {
                return this.hw.x(str);
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public void pr(DownloadTask downloadTask) {
        com.byazt.lj.ho<CSJIndependentProcessDownloadService> hoVar;
        if (downloadTask != null && (hoVar = this.hn) != null) {
            hoVar.hw(downloadTask);
        }
    }

    @Override // com.byazt.lj.m
    public void hw(DownloadTask downloadTask) {
        com.byazt.lj.ho<CSJIndependentProcessDownloadService> hoVar;
        if (downloadTask != null && (hoVar = this.hn) != null) {
            hoVar.hn(downloadTask);
        }
    }

    @Override // com.byazt.lj.m
    public boolean k(int i) {
        if (this.hw == null) {
            return false;
        }
        try {
            return this.hw.w(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public void w(int i) {
        com.byazt.lj.ho<CSJIndependentProcessDownloadService> hoVar = this.hn;
        if (hoVar != null) {
            hoVar.pr(i);
        }
    }

    @Override // com.byazt.lj.m
    public void startService() {
        com.byazt.lj.ho<CSJIndependentProcessDownloadService> hoVar = this.hn;
        if (hoVar != null) {
            hoVar.startService();
        }
    }

    @Override // com.byazt.lj.m
    public boolean c() {
        if (this.hw == null) {
            return this.x.c();
        }
        try {
            return this.hw.x();
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public void hw(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.lj.m
    public void pr(int i, List<com.byazt.auw.hw> list) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.hw(i, list);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public void hn(int i, boolean z) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.x(i, z);
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.m
    public int m(int i) {
        if (this.hw == null) {
            return com.byazt.lj.x.pr().hw(i);
        }
        try {
            return this.hw.m(i);
        } catch (RemoteException e) {
            return -1;
        }
    }

    @Override // com.byazt.lj.m
    public void pr(com.byazt.auw.hw hwVar) {
        if (this.hw == null) {
            this.x.pr(hwVar);
        } else {
            try {
                this.hw.pr(hwVar);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public boolean hn(DownloadInfo downloadInfo) {
        if (this.hw == null) {
            return this.x.hn(downloadInfo);
        }
        try {
            return this.hw.hw(downloadInfo);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public boolean g(int i) {
        if (this.hw == null) {
            return this.x.g(i);
        }
        try {
            return this.hw.g(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public void ho(int i) {
        if (this.hw == null) {
            this.x.ho(i);
        } else {
            try {
                this.hw.ho(i);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, long j) {
        if (this.hw == null) {
            this.x.pr(i, i2, j);
        } else {
            try {
                this.hw.pr(i, i2, j);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, int i3, long j) {
        if (this.hw == null) {
            this.x.pr(i, i2, i3, j);
        } else {
            try {
                this.hw.pr(i, i2, i3, j);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, int i3, int i4) {
        if (this.hw == null) {
            this.x.pr(i, i2, i3, i4);
        } else {
            try {
                this.hw.pr(i, i2, i3, i4);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public boolean nt(int i) {
        if (this.hw == null) {
            return this.x.nt(i);
        }
        try {
            return this.hw.nt(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.m
    public void uc() {
        if (this.hw == null) {
            this.x.uc();
        } else {
            try {
                this.hw.c();
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void hw(int i, List<com.byazt.auw.hw> list) {
        if (this.hw == null) {
            this.x.hw(i, list);
        } else {
            try {
                this.hw.pr(i, list);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public boolean fw() {
        return this.hw != null;
    }

    @Override // com.byazt.lj.m
    public void pr(ls lsVar) {
        if (this.hw != null) {
            try {
                this.hw.pr(com.byazt.tuy.fw.pr(lsVar));
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2) {
        if (this.hw != null) {
            try {
                this.hw.pr(i, i2);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public b yb(int i) {
        if (this.hw != null) {
            try {
                return com.byazt.tuy.fw.pr(this.hw.yb(i));
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public y lb(int i) {
        if (this.hw != null) {
            try {
                return com.byazt.tuy.fw.pr(this.hw.lb(i));
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public void pr(int i, b bVar) {
        if (this.hw != null) {
            try {
                this.hw.pr(i, com.byazt.tuy.fw.pr(bVar));
            } catch (RemoteException e) {
            }
        }
    }

    @Override // com.byazt.lj.m
    public IDownloadFileUriProvider qa(int i) {
        if (this.hw != null) {
            try {
                return com.byazt.tuy.fw.pr(this.hw.qa(i));
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    @Override // com.byazt.lj.g
    public void pr(IBinder iBinder) {
        this.hw = com.byazt.lj.aj.pr.pr(iBinder);
        if (com.byazt.tuy.uc.pr()) {
            pr(new ls() { // from class: com.byazt.ts.ho.1
                @Override // com.byazt.fn.ls
                public void pr(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.byazt.lj.hn.of()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.byazt.lj.hn.of()).pause(i);
                        List<com.byazt.auw.hw> listAj = k.pr(false).aj(i);
                        if (listAj != null) {
                            k.pr(true).pr(i, com.byazt.tuy.uc.pr(listAj));
                        }
                    }
                }
            });
        }
    }

    @Override // com.byazt.lj.g
    public void zo() {
        this.hw = null;
    }

    @Override // com.byazt.lj.m
    public void pr(int i, long j) {
        if (this.hw == null) {
            return;
        }
        try {
            this.hw.pr(i, j);
        } catch (RemoteException e) {
        }
    }
}
