package com.byazt.ts;

import android.app.Notification;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.ls;
import com.byazt.fn.y;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 74})
public class nt implements com.byazt.lj.m {
    public final com.byazt.lj.ho hn;
    public final com.byazt.lj.vk hw;
    public final pr pr;
    public final boolean x;

    public nt() {
        this(false);
    }

    public nt(boolean z) {
        this.pr = com.byazt.lj.hn.nl();
        this.hw = com.byazt.lj.hn.z();
        if (!z) {
            this.hn = com.byazt.lj.hn.b();
        } else {
            this.hn = com.byazt.lj.hn.iu();
        }
        this.x = com.byazt.ew.pr.hn().hw("service_alive", false);
    }

    @Override // com.byazt.lj.m
    public void pr(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.c(i);
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, boolean z) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.pr(i, z);
        }
    }

    @Override // com.byazt.lj.m
    public boolean hw(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.g(i);
        }
        return false;
    }

    @Override // com.byazt.lj.m
    public void hn(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.uc(i);
        }
    }

    @Override // com.byazt.lj.m
    public void x(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.fw(i);
        }
    }

    @Override // com.byazt.lj.m
    public void pr() {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.hw();
        }
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> hw(String str) {
        com.byazt.lj.vk vkVar = this.hw;
        if (vkVar != null) {
            return vkVar.hw(str);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> x() {
        com.byazt.lj.vk vkVar = this.hw;
        if (vkVar != null) {
            return vkVar.hw();
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public void pr(List<String> list) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.pr(list);
        }
    }

    @Override // com.byazt.lj.m
    public void hw(List<String> list) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.hw(list);
        }
    }

    @Override // com.byazt.lj.m
    public long c(int i) {
        DownloadInfo downloadInfoHw;
        com.byazt.lj.vk vkVar = this.hw;
        if (vkVar == null || (downloadInfoHw = vkVar.hw(i)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfoHw.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfoHw.getCurBytes();
        }
        List<com.byazt.auw.hw> listHn = this.hw.hn(i);
        if (listHn == null || listHn.size() != chunkCount) {
            return 0L;
        }
        return com.byazt.tuy.uc.hw(listHn);
    }

    @Override // com.byazt.lj.m
    public int uc(int i) {
        DownloadInfo downloadInfoX;
        pr prVar = this.pr;
        if (prVar == null || (downloadInfoX = prVar.x(i)) == null) {
            return 0;
        }
        return downloadInfoX.getStatus();
    }

    @Override // com.byazt.lj.m
    public boolean fw(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.pr(i);
        }
        return false;
    }

    @Override // com.byazt.lj.m
    public DownloadInfo zo(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.x(i);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> pr(String str) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.pr(str);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public List<com.byazt.auw.hw> aj(int i) {
        return this.hw.hn(i);
    }

    @Override // com.byazt.lj.m
    public DownloadInfo hw(String str, String str2) {
        return zo(com.byazt.lj.hn.pr(str, str2));
    }

    @Override // com.byazt.lj.m
    public int pr(String str, String str2) {
        return com.byazt.lj.hn.pr(str, str2);
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> hn(String str) {
        com.byazt.lj.vk vkVar = this.hw;
        if (vkVar != null) {
            return vkVar.hn(str);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public void hw(int i, boolean z) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.hw(i, z);
        }
    }

    public void x(int i, boolean z) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.hn(i, z);
        }
    }

    @Override // com.byazt.lj.m
    public void vk(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.m(i);
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.hw(i, i2, iDownloadListener, ucVar, z);
        }
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z, boolean z2) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.pr(i, i2, iDownloadListener, ucVar, z, z2);
        }
    }

    @Override // com.byazt.lj.m
    public void hw(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.pr(i, i2, iDownloadListener, ucVar, z);
        }
    }

    @Override // com.byazt.lj.m
    public boolean pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zPr = com.byazt.tuy.uc.pr(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (zPr) {
            if (com.byazt.tuy.pr.pr(RustResolvedAsset.MAX_HTML_BYTES)) {
                hw(downloadInfo.getId(), true);
            } else {
                x(downloadInfo.getId(), true);
            }
        }
        return zPr;
    }

    @Override // com.byazt.lj.m
    public void pr(int i, Notification notification) {
        com.byazt.lj.ho hoVar = this.hn;
        if (hoVar != null) {
            hoVar.pr(i, notification);
        }
    }

    @Override // com.byazt.lj.m
    public void pr(boolean z, boolean z2) {
        com.byazt.lj.ho hoVar = this.hn;
        if (hoVar != null) {
            hoVar.pr(z2);
        }
    }

    @Override // com.byazt.lj.m
    public boolean hw() {
        com.byazt.lj.ho hoVar = this.hn;
        if (hoVar != null) {
            return hoVar.hw();
        }
        return false;
    }

    @Override // com.byazt.lj.m
    public boolean hn() {
        return com.byazt.lj.hn.ii();
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> x(String str) {
        com.byazt.lj.vk vkVar = this.hw;
        if (vkVar != null) {
            return vkVar.x(str);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public List<DownloadInfo> c(String str) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.hw(str);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public void pr(DownloadTask downloadTask) {
        com.byazt.lj.ho hoVar = this.hn;
        if (hoVar != null) {
            hoVar.hw(downloadTask);
        } else if (downloadTask != null) {
            com.byazt.cha.pr.pr(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.byazt.lj.m
    public void hw(DownloadTask downloadTask) {
        com.byazt.lj.ho hoVar = this.hn;
        if (hoVar != null) {
            hoVar.hn(downloadTask);
        }
    }

    @Override // com.byazt.lj.m
    public boolean k(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.w(i);
        }
        return false;
    }

    @Override // com.byazt.lj.m
    public void w(int i) {
        com.byazt.p000do.pr.pr(i);
    }

    @Override // com.byazt.lj.m
    public void startService() {
    }

    @Override // com.byazt.lj.m
    public boolean c() {
        return this.hw.x();
    }

    @Override // com.byazt.lj.m
    public void hw(DownloadInfo downloadInfo) {
        this.hw.hw(downloadInfo);
    }

    @Override // com.byazt.lj.m
    public void pr(int i, List<com.byazt.auw.hw> list) {
        this.hw.pr(i, list);
    }

    @Override // com.byazt.lj.m
    public void hn(int i, boolean z) {
        com.byazt.lj.x.pr().pr(i, z);
    }

    @Override // com.byazt.lj.m
    public int m(int i) {
        return com.byazt.lj.x.pr().pr(i);
    }

    @Override // com.byazt.lj.m
    public void pr(com.byazt.auw.hw hwVar) {
        this.hw.pr(hwVar);
    }

    @Override // com.byazt.lj.m
    public boolean hn(DownloadInfo downloadInfo) {
        return this.hw.pr(downloadInfo);
    }

    @Override // com.byazt.lj.m
    public boolean g(int i) {
        return this.hw.c(i);
    }

    @Override // com.byazt.lj.m
    public void ho(int i) {
        this.hw.x(i);
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, long j) {
        this.hw.pr(i, i2, j);
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, int i3, long j) {
        this.hw.pr(i, i2, i3, j);
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2, int i3, int i4) {
        this.hw.pr(i, i2, i3, i4);
    }

    @Override // com.byazt.lj.m
    public boolean nt(int i) {
        return this.hw.uc(i);
    }

    @Override // com.byazt.lj.m
    public void uc() {
        this.hw.hn();
    }

    @Override // com.byazt.lj.m
    public void hw(int i, List<com.byazt.auw.hw> list) {
        this.hw.hw(i, list);
    }

    @Override // com.byazt.lj.m
    public boolean fw() {
        com.byazt.lj.ho hoVar;
        return this.x && (hoVar = this.hn) != null && hoVar.pr();
    }

    @Override // com.byazt.lj.m
    public void pr(ls lsVar) {
        com.byazt.lj.hn.pr(lsVar);
    }

    @Override // com.byazt.lj.m
    public void pr(int i, int i2) {
        if (com.byazt.lj.hn.c() != null) {
            for (ls lsVar : com.byazt.lj.hn.c()) {
                if (lsVar != null) {
                    lsVar.pr(i2, i);
                }
            }
        }
    }

    @Override // com.byazt.lj.m
    public b yb(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.aj(i);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public y lb(int i) {
        y yVarZo;
        pr prVar = this.pr;
        if (prVar == null) {
            yVarZo = null;
        } else {
            yVarZo = prVar.zo(i);
        }
        if (yVarZo == null) {
            return com.byazt.lj.hn.er();
        }
        return yVarZo;
    }

    @Override // com.byazt.lj.m
    public void pr(int i, b bVar) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.pr(i, bVar);
        }
    }

    @Override // com.byazt.lj.m
    public IDownloadFileUriProvider qa(int i) {
        pr prVar = this.pr;
        if (prVar != null) {
            return prVar.vk(i);
        }
        return null;
    }

    @Override // com.byazt.lj.m
    public void pr(int i, long j) {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.hw(i, j);
        }
    }
}
