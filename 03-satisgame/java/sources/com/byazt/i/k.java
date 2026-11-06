package com.byazt.i;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.f;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.CSJIndependentProcessDownloadService;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 210})
public class k implements com.byazt.xv.oa, com.byazt.xv.sz {
    public static final String n = "k";
    public com.byazt.xv.oa q = new cy();
    public volatile com.byazt.xv.rv qg;
    public com.byazt.xv.k<CSJIndependentProcessDownloadService> s;

    @Override // com.byazt.xv.oa
    public void qg(DownloadInfo downloadInfo) {
    }

    public k() {
        com.byazt.xv.k<CSJIndependentProcessDownloadService> kVarT = com.byazt.xv.s.t();
        this.s = kVarT;
        kVarT.n(this);
    }

    @Override // com.byazt.xv.oa
    public void n(int i) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.n(i);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, boolean z) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.n(i, z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public boolean qg(int i) {
        if (this.qg == null) {
            return false;
        }
        try {
            return this.qg.qg(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public void s(int i) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.s(i);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void q(int i) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.q(i);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void n() {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.n();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public long l(int i) {
        if (this.qg == null) {
            return 0L;
        }
        try {
            return this.qg.l(i);
        } catch (RemoteException unused) {
            return 0L;
        }
    }

    @Override // com.byazt.xv.oa
    public int w(int i) {
        if (this.qg == null) {
            return 0;
        }
        try {
            return this.qg.w(i);
        } catch (RemoteException unused) {
            return 0;
        }
    }

    @Override // com.byazt.xv.oa
    public boolean x(int i) {
        if (this.qg == null) {
            return false;
        }
        try {
            return this.qg.x(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public DownloadInfo fs(int i) {
        if (this.qg == null) {
            return this.q.fs(i);
        }
        try {
            return this.qg.fs(i);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> n(String str) {
        if (this.qg == null) {
            return this.q.n(str);
        }
        try {
            return this.qg.n(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public List<com.byazt.wm.qg> rv(int i) {
        if (this.qg == null) {
            return this.q.rv(i);
        }
        try {
            return this.qg.rv(i);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public int n(String str, String str2) {
        return com.byazt.xv.s.n(str, str2);
    }

    @Override // com.byazt.xv.oa
    public DownloadInfo qg(String str, String str2) {
        return fs(n(str, str2));
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> qg(String str) {
        if (this.qg == null) {
            return this.q.qg(str);
        }
        try {
            return this.qg.qg(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> s(String str) {
        if (this.qg == null) {
            return this.q.s(str);
        }
        try {
            return this.qg.s(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> q() {
        if (this.qg == null) {
            return this.q.q();
        }
        try {
            return this.qg.qg();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public void n(List<String> list) {
        if (this.qg == null) {
            this.q.n(list);
        } else {
            try {
                this.qg.n(list);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(List<String> list) {
        if (this.qg == null) {
            this.q.qg(list);
        } else {
            try {
                this.qg.qg(list);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(int i, boolean z) {
        if (this.qg == null) {
            this.q.qg(i, z);
        } else {
            try {
                this.qg.qg(i, z);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void tj(int i) {
        if (this.qg == null) {
            this.q.tj(i);
        } else {
            try {
                this.qg.tj(i);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.qg(i, i2, com.byazt.ta.x.n(iDownloadListener, wVar != com.byazt.sk.w.SUB), wVar.ordinal(), z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z, boolean z2) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.n(i, i2, com.byazt.ta.x.n(iDownloadListener, wVar != com.byazt.sk.w.SUB), wVar.ordinal(), z, z2);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.n(i, i2, com.byazt.ta.x.n(iDownloadListener, wVar != com.byazt.sk.w.SUB), wVar.ordinal(), z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public boolean n(DownloadInfo downloadInfo) {
        if (this.qg == null) {
            return this.q.n(downloadInfo);
        }
        try {
            this.qg.n(downloadInfo);
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, Notification notification) {
        if (this.qg == null) {
            com.byazt.fe.n.q(n, "startForeground, aidlService is null");
            return;
        }
        com.byazt.fe.n.s(n, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.qg.n(i, notification);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void n(boolean z, boolean z2) {
        if (this.qg == null) {
            com.byazt.fe.n.q(n, "stopForeground, aidlService is null");
            return;
        }
        com.byazt.fe.n.s(n, "aidlService.stopForeground");
        try {
            this.qg.n(z2);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public boolean qg() {
        if (this.qg == null) {
            com.byazt.fe.n.q(n, "isServiceForeground, aidlService is null");
            return false;
        }
        com.byazt.fe.n.s(n, "aidlService.isServiceForeground");
        try {
            return this.qg.w();
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public boolean s() {
        return com.byazt.xv.s.pk();
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> q(String str) {
        if (this.qg == null) {
            return this.q.q(str);
        }
        try {
            return this.qg.l(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> l(String str) {
        if (this.qg == null) {
            return null;
        }
        try {
            return this.qg.q(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public void n(DownloadTask downloadTask) {
        com.byazt.xv.k<CSJIndependentProcessDownloadService> kVar;
        if (downloadTask == null || (kVar = this.s) == null) {
            return;
        }
        kVar.qg(downloadTask);
    }

    @Override // com.byazt.xv.oa
    public void qg(DownloadTask downloadTask) {
        com.byazt.xv.k<CSJIndependentProcessDownloadService> kVar;
        if (downloadTask == null || (kVar = this.s) == null) {
            return;
        }
        kVar.s(downloadTask);
    }

    @Override // com.byazt.xv.oa
    public boolean d(int i) {
        if (this.qg == null) {
            return false;
        }
        try {
            return this.qg.cp(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public void cp(int i) {
        com.byazt.xv.k<CSJIndependentProcessDownloadService> kVar = this.s;
        if (kVar != null) {
            kVar.n(i);
        }
    }

    @Override // com.byazt.xv.oa
    public void startService() {
        com.byazt.xv.k<CSJIndependentProcessDownloadService> kVar = this.s;
        if (kVar != null) {
            kVar.startService();
        }
    }

    @Override // com.byazt.xv.oa
    public boolean l() {
        if (this.qg == null) {
            return this.q.l();
        }
        try {
            return this.qg.q();
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, List<com.byazt.wm.qg> list) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.qg(i, list);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public void s(int i, boolean z) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.q(i, z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.oa
    public int oa(int i) {
        if (this.qg == null) {
            return com.byazt.xv.q.n().qg(i);
        }
        try {
            return this.qg.oa(i);
        } catch (RemoteException unused) {
            return -1;
        }
    }

    @Override // com.byazt.xv.oa
    public void n(com.byazt.wm.qg qgVar) {
        if (this.qg == null) {
            this.q.n(qgVar);
        } else {
            try {
                this.qg.n(qgVar);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public boolean s(DownloadInfo downloadInfo) {
        if (this.qg == null) {
            return this.q.s(downloadInfo);
        }
        try {
            return this.qg.qg(downloadInfo);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public boolean sz(int i) {
        if (this.qg == null) {
            return this.q.sz(i);
        }
        try {
            return this.qg.sz(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public void k(int i) {
        if (this.qg == null) {
            this.q.k(i);
        } else {
            try {
                this.qg.k(i);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, long j) {
        if (this.qg == null) {
            this.q.n(i, i2, j);
        } else {
            try {
                this.qg.n(i, i2, j);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, int i3, long j) {
        if (this.qg == null) {
            this.q.n(i, i2, i3, j);
        } else {
            try {
                this.qg.n(i, i2, i3, j);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, int i3, int i4) {
        if (this.qg == null) {
            this.q.n(i, i2, i3, i4);
        } else {
            try {
                this.qg.n(i, i2, i3, i4);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public boolean cy(int i) {
        if (this.qg == null) {
            return this.q.cy(i);
        }
        try {
            return this.qg.cy(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.oa
    public void w() {
        if (this.qg == null) {
            this.q.w();
        } else {
            try {
                this.qg.l();
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(int i, List<com.byazt.wm.qg> list) {
        if (this.qg == null) {
            this.q.qg(i, list);
        } else {
            try {
                this.qg.n(i, list);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public boolean x() {
        return this.qg != null;
    }

    @Override // com.byazt.xv.oa
    public void n(f fVar) {
        if (this.qg != null) {
            try {
                this.qg.n(com.byazt.ta.x.n(fVar));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2) {
        if (this.qg != null) {
            try {
                this.qg.n(i, i2);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public h hd(int i) {
        if (this.qg == null) {
            return null;
        }
        try {
            return com.byazt.ta.x.n(this.qg.hd(i));
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public lh cd(int i) {
        if (this.qg == null) {
            return null;
        }
        try {
            return com.byazt.ta.x.n(this.qg.cd(i));
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, h hVar) {
        if (this.qg != null) {
            try {
                this.qg.n(i, com.byazt.ta.x.n(hVar));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.byazt.xv.oa
    public IDownloadFileUriProvider um(int i) {
        if (this.qg == null) {
            return null;
        }
        try {
            return com.byazt.ta.x.n(this.qg.um(i));
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.sz
    public void n(IBinder iBinder) {
        this.qg = com.byazt.xv.rv.n.n(iBinder);
        if (com.byazt.ta.w.n()) {
            n(new f() { // from class: com.byazt.i.k.1
                @Override // com.byazt.je.f
                public void n(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.byazt.xv.s.u()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.byazt.xv.s.u()).pause(i);
                        List<com.byazt.wm.qg> listRv = d.n(false).rv(i);
                        if (listRv != null) {
                            d.n(true).n(i, com.byazt.ta.w.n(listRv));
                        }
                    }
                }
            });
        }
    }

    @Override // com.byazt.xv.sz
    public void fs() {
        this.qg = null;
    }

    @Override // com.byazt.xv.oa
    public void n(int i, long j) {
        if (this.qg == null) {
            return;
        }
        try {
            this.qg.n(i, j);
        } catch (RemoteException unused) {
        }
    }
}
