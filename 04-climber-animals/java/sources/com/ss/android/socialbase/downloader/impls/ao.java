package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ao implements com.ss.android.socialbase.downloader.downloader.zb {
    private final com.ss.android.socialbase.downloader.downloader.ub ah;
    private final boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ms f4679ms;
    private final com.ss.android.socialbase.downloader.downloader.ch xr;

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void startService() {
    }

    public ao() {
        this(false);
    }

    public ao(boolean z) {
        this.f4679ms = com.ss.android.socialbase.downloader.downloader.ah.g();
        this.xr = com.ss.android.socialbase.downloader.downloader.ah.w();
        if (!z) {
            this.ah = com.ss.android.socialbase.downloader.downloader.ah.yu();
        } else {
            this.ah = com.ss.android.socialbase.downloader.downloader.ah.op();
        }
        this.d = com.ss.android.socialbase.downloader.ab.ms.ah().xr("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ka(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, boolean z) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ms(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean xr(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.u(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ah(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void d(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ab(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms() {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.xr();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> xr(String str) {
        com.ss.android.socialbase.downloader.downloader.ch chVar = this.xr;
        if (chVar != null) {
            return chVar.xr(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> d() {
        com.ss.android.socialbase.downloader.downloader.ch chVar = this.xr;
        if (chVar != null) {
            return chVar.xr();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(List<String> list) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ms(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(List<String> list) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.xr(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public long ka(int i) {
        DownloadInfo downloadInfoXr;
        com.ss.android.socialbase.downloader.downloader.ch chVar = this.xr;
        if (chVar == null || (downloadInfoXr = chVar.xr(i)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfoXr.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfoXr.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.xr> listAh = this.xr.ah(i);
        if (listAh == null || listAh.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.ny.c.xr(listAh);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public int c(int i) {
        DownloadInfo downloadInfoD;
        ms msVar = this.f4679ms;
        if (msVar == null || (downloadInfoD = msVar.d(i)) == null) {
            return 0;
        }
        return downloadInfoD.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ab(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.ms(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public DownloadInfo x(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.d(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> ms(String str) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.ms(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<com.ss.android.socialbase.downloader.model.xr> ny(int i) {
        return this.xr.ah(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public DownloadInfo xr(String str, String str2) {
        return x(com.ss.android.socialbase.downloader.downloader.ah.ms(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public int ms(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.ah.ms(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> ah(String str) {
        com.ss.android.socialbase.downloader.downloader.ch chVar = this.xr;
        if (chVar != null) {
            return chVar.ah(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(int i, boolean z) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.xr(i, z);
        }
    }

    public void d(int i, boolean z) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ah(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ch(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.zb(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.xr(i, i2, iDownloadListener, cVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z, boolean z2) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ms(i, i2, iDownloadListener, cVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ms(i, i2, iDownloadListener, cVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zMs = com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (zMs) {
            if (com.ss.android.socialbase.downloader.ny.ms.ms(33554432)) {
                xr(downloadInfo.getId(), true);
            } else {
                d(downloadInfo.getId(), true);
            }
        }
        return zMs;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.ub ubVar = this.ah;
        if (ubVar != null) {
            ubVar.ms(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.ub ubVar = this.ah;
        if (ubVar != null) {
            ubVar.ms(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean xr() {
        com.ss.android.socialbase.downloader.downloader.ub ubVar = this.ah;
        if (ubVar != null) {
            return ubVar.xr();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ah() {
        return com.ss.android.socialbase.downloader.downloader.ah.eg();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> d(String str) {
        com.ss.android.socialbase.downloader.downloader.ch chVar = this.xr;
        if (chVar != null) {
            return chVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> ka(String str) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.xr(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ub ubVar = this.ah;
        if (ubVar != null) {
            ubVar.xr(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.d.ms.ms(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ub ubVar = this.ah;
        if (ubVar != null) {
            ubVar.ah(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean sl(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.hi(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void hi(int i) {
        com.ss.android.socialbase.downloader.ah.ms.ms(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ka() {
        return this.xr.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(DownloadInfo downloadInfo) {
        this.xr.xr(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        this.xr.ms(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ah(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.d.ms().ms(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public int zb(int i) {
        return com.ss.android.socialbase.downloader.downloader.d.ms().ms(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        this.xr.ms(xrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ah(DownloadInfo downloadInfo) {
        return this.xr.ms(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean u(int i) {
        return this.xr.ka(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ub(int i) {
        this.xr.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, long j) {
        this.xr.ms(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, int i3, long j) {
        this.xr.ms(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, int i3, int i4) {
        this.xr.ms(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ao(int i) {
        return this.xr.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void c() {
        this.xr.ah();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        this.xr.xr(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ab() {
        com.ss.android.socialbase.downloader.downloader.ub ubVar;
        return this.d && (ubVar = this.ah) != null && ubVar.ms();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(ul ulVar) {
        com.ss.android.socialbase.downloader.downloader.ah.ms(ulVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.ah.ka() != null) {
            for (ul ulVar : com.ss.android.socialbase.downloader.downloader.ah.ka()) {
                if (ulVar != null) {
                    ulVar.ms(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public yu h(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.ny(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public of qv(int i) {
        ms msVar = this.f4679ms;
        of ofVarX = msVar != null ? msVar.x(i) : null;
        return ofVarX == null ? com.ss.android.socialbase.downloader.downloader.ah.az() : ofVarX;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, yu yuVar) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.ms(i, yuVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public IDownloadFileUriProvider y(int i) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            return msVar.ch(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, long j) {
        ms msVar = this.f4679ms;
        if (msVar != null) {
            msVar.xr(i, j);
        }
    }
}
