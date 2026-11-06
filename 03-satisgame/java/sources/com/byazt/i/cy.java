package com.byazt.i;

import android.app.Notification;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.f;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements com.byazt.xv.oa {
    public final n n;
    public final boolean q;
    public final com.byazt.xv.tj qg;
    public final com.byazt.xv.k s;

    @Override // com.byazt.xv.oa
    public void startService() {
    }

    public cy() {
        this(false);
    }

    public cy(boolean z) {
        this.n = com.byazt.xv.s.ln();
        this.qg = com.byazt.xv.s.hu();
        if (!z) {
            this.s = com.byazt.xv.s.h();
        } else {
            this.s = com.byazt.xv.s.t();
        }
        this.q = com.byazt.f.n.s().qg("service_alive", false);
    }

    @Override // com.byazt.xv.oa
    public void n(int i) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.l(i);
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, boolean z) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.n(i, z);
        }
    }

    @Override // com.byazt.xv.oa
    public boolean qg(int i) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.sz(i);
        }
        return false;
    }

    @Override // com.byazt.xv.oa
    public void s(int i) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.w(i);
        }
    }

    @Override // com.byazt.xv.oa
    public void q(int i) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.x(i);
        }
    }

    @Override // com.byazt.xv.oa
    public void n() {
        n nVar = this.n;
        if (nVar != null) {
            nVar.qg();
        }
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> qg(String str) {
        com.byazt.xv.tj tjVar = this.qg;
        if (tjVar != null) {
            return tjVar.qg(str);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> q() {
        com.byazt.xv.tj tjVar = this.qg;
        if (tjVar != null) {
            return tjVar.qg();
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public void n(List<String> list) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.n(list);
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(List<String> list) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.qg(list);
        }
    }

    @Override // com.byazt.xv.oa
    public long l(int i) {
        DownloadInfo downloadInfoQg;
        com.byazt.xv.tj tjVar = this.qg;
        if (tjVar == null || (downloadInfoQg = tjVar.qg(i)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfoQg.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfoQg.getCurBytes();
        }
        List<com.byazt.wm.qg> listS = this.qg.s(i);
        if (listS == null || listS.size() != chunkCount) {
            return 0L;
        }
        return com.byazt.ta.w.qg(listS);
    }

    @Override // com.byazt.xv.oa
    public int w(int i) {
        DownloadInfo downloadInfoQ;
        n nVar = this.n;
        if (nVar == null || (downloadInfoQ = nVar.q(i)) == null) {
            return 0;
        }
        return downloadInfoQ.getStatus();
    }

    @Override // com.byazt.xv.oa
    public boolean x(int i) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.n(i);
        }
        return false;
    }

    @Override // com.byazt.xv.oa
    public DownloadInfo fs(int i) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.q(i);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> n(String str) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.n(str);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public List<com.byazt.wm.qg> rv(int i) {
        return this.qg.s(i);
    }

    @Override // com.byazt.xv.oa
    public DownloadInfo qg(String str, String str2) {
        return fs(com.byazt.xv.s.n(str, str2));
    }

    @Override // com.byazt.xv.oa
    public int n(String str, String str2) {
        return com.byazt.xv.s.n(str, str2);
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> s(String str) {
        com.byazt.xv.tj tjVar = this.qg;
        if (tjVar != null) {
            return tjVar.s(str);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public void qg(int i, boolean z) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.qg(i, z);
        }
    }

    public void q(int i, boolean z) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.s(i, z);
        }
    }

    @Override // com.byazt.xv.oa
    public void tj(int i) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.oa(i);
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.qg(i, i2, iDownloadListener, wVar, z);
        }
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z, boolean z2) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.n(i, i2, iDownloadListener, wVar, z, z2);
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.n(i, i2, iDownloadListener, wVar, z);
        }
    }

    @Override // com.byazt.xv.oa
    public boolean n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zN = com.byazt.ta.w.n(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (zN) {
            if (com.byazt.ta.n.n(33554432)) {
                qg(downloadInfo.getId(), true);
            } else {
                q(downloadInfo.getId(), true);
            }
        }
        return zN;
    }

    @Override // com.byazt.xv.oa
    public void n(int i, Notification notification) {
        com.byazt.xv.k kVar = this.s;
        if (kVar != null) {
            kVar.n(i, notification);
        }
    }

    @Override // com.byazt.xv.oa
    public void n(boolean z, boolean z2) {
        com.byazt.xv.k kVar = this.s;
        if (kVar != null) {
            kVar.n(z2);
        }
    }

    @Override // com.byazt.xv.oa
    public boolean qg() {
        com.byazt.xv.k kVar = this.s;
        if (kVar != null) {
            return kVar.qg();
        }
        return false;
    }

    @Override // com.byazt.xv.oa
    public boolean s() {
        return com.byazt.xv.s.pk();
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> q(String str) {
        com.byazt.xv.tj tjVar = this.qg;
        if (tjVar != null) {
            return tjVar.q(str);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public List<DownloadInfo> l(String str) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.qg(str);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public void n(DownloadTask downloadTask) {
        com.byazt.xv.k kVar = this.s;
        if (kVar != null) {
            kVar.qg(downloadTask);
        } else if (downloadTask != null) {
            com.byazt.g.n.n(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.byazt.xv.oa
    public void qg(DownloadTask downloadTask) {
        com.byazt.xv.k kVar = this.s;
        if (kVar != null) {
            kVar.s(downloadTask);
        }
    }

    @Override // com.byazt.xv.oa
    public boolean d(int i) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.cp(i);
        }
        return false;
    }

    @Override // com.byazt.xv.oa
    public void cp(int i) {
        com.byazt.fe.n.n(i);
    }

    @Override // com.byazt.xv.oa
    public boolean l() {
        return this.qg.q();
    }

    @Override // com.byazt.xv.oa
    public void qg(DownloadInfo downloadInfo) {
        this.qg.qg(downloadInfo);
    }

    @Override // com.byazt.xv.oa
    public void n(int i, List<com.byazt.wm.qg> list) {
        this.qg.n(i, list);
    }

    @Override // com.byazt.xv.oa
    public void s(int i, boolean z) {
        com.byazt.xv.q.n().n(i, z);
    }

    @Override // com.byazt.xv.oa
    public int oa(int i) {
        return com.byazt.xv.q.n().n(i);
    }

    @Override // com.byazt.xv.oa
    public void n(com.byazt.wm.qg qgVar) {
        this.qg.n(qgVar);
    }

    @Override // com.byazt.xv.oa
    public boolean s(DownloadInfo downloadInfo) {
        return this.qg.n(downloadInfo);
    }

    @Override // com.byazt.xv.oa
    public boolean sz(int i) {
        return this.qg.l(i);
    }

    @Override // com.byazt.xv.oa
    public void k(int i) {
        this.qg.q(i);
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, long j) {
        this.qg.n(i, i2, j);
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, int i3, long j) {
        this.qg.n(i, i2, i3, j);
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2, int i3, int i4) {
        this.qg.n(i, i2, i3, i4);
    }

    @Override // com.byazt.xv.oa
    public boolean cy(int i) {
        return this.qg.w(i);
    }

    @Override // com.byazt.xv.oa
    public void w() {
        this.qg.s();
    }

    @Override // com.byazt.xv.oa
    public void qg(int i, List<com.byazt.wm.qg> list) {
        this.qg.qg(i, list);
    }

    @Override // com.byazt.xv.oa
    public boolean x() {
        com.byazt.xv.k kVar;
        return this.q && (kVar = this.s) != null && kVar.n();
    }

    @Override // com.byazt.xv.oa
    public void n(f fVar) {
        com.byazt.xv.s.n(fVar);
    }

    @Override // com.byazt.xv.oa
    public void n(int i, int i2) {
        if (com.byazt.xv.s.l() != null) {
            for (f fVar : com.byazt.xv.s.l()) {
                if (fVar != null) {
                    fVar.n(i2, i);
                }
            }
        }
    }

    @Override // com.byazt.xv.oa
    public h hd(int i) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.rv(i);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public lh cd(int i) {
        n nVar = this.n;
        lh lhVarFs = nVar != null ? nVar.fs(i) : null;
        return lhVarFs == null ? com.byazt.xv.s.fi() : lhVarFs;
    }

    @Override // com.byazt.xv.oa
    public void n(int i, h hVar) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.n(i, hVar);
        }
    }

    @Override // com.byazt.xv.oa
    public IDownloadFileUriProvider um(int i) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.tj(i);
        }
        return null;
    }

    @Override // com.byazt.xv.oa
    public void n(int i, long j) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.qg(i, j);
        }
    }
}
