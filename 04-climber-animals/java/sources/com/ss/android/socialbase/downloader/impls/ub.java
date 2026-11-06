package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ub implements com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.zb {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4702ms = "ub";
    private com.ss.android.socialbase.downloader.downloader.ub<IndependentProcessDownloadService> ah;
    private com.ss.android.socialbase.downloader.downloader.zb d = new ao();
    private volatile com.ss.android.socialbase.downloader.downloader.ny xr;

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(DownloadInfo downloadInfo) {
    }

    public ub() {
        com.ss.android.socialbase.downloader.downloader.ub<IndependentProcessDownloadService> ubVarOp = com.ss.android.socialbase.downloader.downloader.ah.op();
        this.ah = ubVarOp;
        ubVarOp.ms(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ms(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, boolean z) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ms(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean xr(int i) {
        if (this.xr == null) {
            return false;
        }
        try {
            return this.xr.xr(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ah(int i) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ah(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void d(int i) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.d(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms() {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ms();
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public long ka(int i) {
        if (this.xr == null) {
            return 0L;
        }
        try {
            return this.xr.ka(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public int c(int i) {
        if (this.xr == null) {
            return 0;
        }
        try {
            return this.xr.c(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ab(int i) {
        if (this.xr == null) {
            return false;
        }
        try {
            return this.xr.ab(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public DownloadInfo x(int i) {
        if (this.xr == null) {
            return this.d.x(i);
        }
        try {
            return this.xr.x(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> ms(String str) {
        if (this.xr == null) {
            return this.d.ms(str);
        }
        try {
            return this.xr.ms(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<com.ss.android.socialbase.downloader.model.xr> ny(int i) {
        if (this.xr == null) {
            return this.d.ny(i);
        }
        try {
            return this.xr.ny(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public int ms(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.ah.ms(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public DownloadInfo xr(String str, String str2) {
        return x(ms(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> xr(String str) {
        if (this.xr == null) {
            return this.d.xr(str);
        }
        try {
            return this.xr.xr(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> ah(String str) {
        if (this.xr == null) {
            return this.d.ah(str);
        }
        try {
            return this.xr.ah(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> d() {
        if (this.xr == null) {
            return this.d.d();
        }
        try {
            return this.xr.xr();
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(List<String> list) {
        if (this.xr == null) {
            this.d.ms(list);
            return;
        }
        try {
            this.xr.ms(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(List<String> list) {
        if (this.xr == null) {
            this.d.xr(list);
            return;
        }
        try {
            this.xr.xr(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(int i, boolean z) {
        if (this.xr == null) {
            this.d.xr(i, z);
            return;
        }
        try {
            this.xr.xr(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ch(int i) {
        if (this.xr == null) {
            this.d.ch(i);
            return;
        }
        try {
            this.xr.ch(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.xr(i, i2, com.ss.android.socialbase.downloader.ny.ab.ms(iDownloadListener, cVar != com.ss.android.socialbase.downloader.constants.c.SUB), cVar.ordinal(), z);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z, boolean z2) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ms(i, i2, com.ss.android.socialbase.downloader.ny.ab.ms(iDownloadListener, cVar != com.ss.android.socialbase.downloader.constants.c.SUB), cVar.ordinal(), z, z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ms(i, i2, com.ss.android.socialbase.downloader.ny.ab.ms(iDownloadListener, cVar != com.ss.android.socialbase.downloader.constants.c.SUB), cVar.ordinal(), z);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ms(DownloadInfo downloadInfo) {
        if (this.xr == null) {
            return this.d.ms(downloadInfo);
        }
        try {
            this.xr.ms(downloadInfo);
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, Notification notification) {
        if (this.xr == null) {
            com.ss.android.socialbase.downloader.ah.ms.d(f4702ms, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.ah(f4702ms, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.xr.ms(i, notification);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(boolean z, boolean z2) {
        if (this.xr == null) {
            com.ss.android.socialbase.downloader.ah.ms.d(f4702ms, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.ah(f4702ms, "aidlService.stopForeground");
        try {
            this.xr.ms(z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean xr() {
        if (this.xr == null) {
            com.ss.android.socialbase.downloader.ah.ms.d(f4702ms, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.ah.ms.ah(f4702ms, "aidlService.isServiceForeground");
        try {
            return this.xr.c();
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ah() {
        return com.ss.android.socialbase.downloader.downloader.ah.eg();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> d(String str) {
        if (this.xr == null) {
            return this.d.d(str);
        }
        try {
            return this.xr.ka(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public List<DownloadInfo> ka(String str) {
        if (this.xr == null) {
            return null;
        }
        try {
            return this.xr.d(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ub<IndependentProcessDownloadService> ubVar;
        if (downloadTask == null || (ubVar = this.ah) == null) {
            return;
        }
        ubVar.xr(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ub<IndependentProcessDownloadService> ubVar;
        if (downloadTask == null || (ubVar = this.ah) == null) {
            return;
        }
        ubVar.ah(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean sl(int i) {
        if (this.xr == null) {
            return false;
        }
        try {
            return this.xr.hi(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void hi(int i) {
        com.ss.android.socialbase.downloader.downloader.ub<IndependentProcessDownloadService> ubVar = this.ah;
        if (ubVar != null) {
            ubVar.ms(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.ub<IndependentProcessDownloadService> ubVar = this.ah;
        if (ubVar != null) {
            ubVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ka() {
        if (this.xr == null) {
            return this.d.ka();
        }
        try {
            return this.xr.d();
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.xr(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ah(int i, boolean z) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.d(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public int zb(int i) {
        if (this.xr == null) {
            return com.ss.android.socialbase.downloader.downloader.d.ms().xr(i);
        }
        try {
            return this.xr.zb(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        if (this.xr == null) {
            this.d.ms(xrVar);
            return;
        }
        try {
            this.xr.ms(xrVar);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ah(DownloadInfo downloadInfo) {
        if (this.xr == null) {
            return this.d.ah(downloadInfo);
        }
        try {
            return this.xr.xr(downloadInfo);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean u(int i) {
        if (this.xr == null) {
            return this.d.u(i);
        }
        try {
            return this.xr.u(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ub(int i) {
        if (this.xr == null) {
            this.d.ub(i);
            return;
        }
        try {
            this.xr.ub(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, long j) {
        if (this.xr == null) {
            this.d.ms(i, i2, j);
            return;
        }
        try {
            this.xr.ms(i, i2, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, int i3, long j) {
        if (this.xr == null) {
            this.d.ms(i, i2, i3, j);
            return;
        }
        try {
            this.xr.ms(i, i2, i3, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2, int i3, int i4) {
        if (this.xr == null) {
            this.d.ms(i, i2, i3, i4);
            return;
        }
        try {
            this.xr.ms(i, i2, i3, i4);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ao(int i) {
        if (this.xr == null) {
            return this.d.ao(i);
        }
        try {
            return this.xr.ao(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void c() {
        if (this.xr == null) {
            this.d.c();
            return;
        }
        try {
            this.xr.ka();
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        if (this.xr == null) {
            this.d.xr(i, list);
            return;
        }
        try {
            this.xr.ms(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public boolean ab() {
        return this.xr != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(ul ulVar) {
        if (this.xr != null) {
            try {
                this.xr.ms(com.ss.android.socialbase.downloader.ny.ab.ms(ulVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, int i2) {
        if (this.xr != null) {
            try {
                this.xr.ms(i, i2);
            } catch (RemoteException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public yu h(int i) {
        if (this.xr == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.ny.ab.ms(this.xr.h(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public of qv(int i) {
        if (this.xr == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.ny.ab.ms(this.xr.qv(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, yu yuVar) {
        if (this.xr != null) {
            try {
                this.xr.ms(i, com.ss.android.socialbase.downloader.ny.ab.ms(yuVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public IDownloadFileUriProvider y(int i) {
        if (this.xr == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.ny.ab.ms(this.xr.y(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void ms(IBinder iBinder) {
        this.xr = com.ss.android.socialbase.downloader.downloader.ny.ms.ms(iBinder);
        if (com.ss.android.socialbase.downloader.ny.c.ms()) {
            ms(new ul() { // from class: com.ss.android.socialbase.downloader.impls.ub.1
                @Override // com.ss.android.socialbase.downloader.depend.ul
                public void ms(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).pause(i);
                        List<com.ss.android.socialbase.downloader.model.xr> listNy = sl.ms(false).ny(i);
                        if (listNy != null) {
                            sl.ms(true).ms(i, com.ss.android.socialbase.downloader.ny.c.ms(listNy));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void x() {
        this.xr = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zb
    public void ms(int i, long j) {
        if (this.xr == null) {
            return;
        }
        try {
            this.xr.ms(i, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }
}
