package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class zb extends com.ss.android.socialbase.downloader.downloader.ny.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4704ms = "zb";
    private final com.ss.android.socialbase.downloader.downloader.zb xr = new ao(true);

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(com.ss.android.socialbase.downloader.model.ms msVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.xr(com.ss.android.socialbase.downloader.ny.ab.ms(msVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean xr(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.xr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ah(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ah(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void d(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public long ka(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return 0L;
        }
        return zbVar.ka(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public int c(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return 0;
        }
        return zbVar.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean ab(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.ab(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public DownloadInfo x(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.x(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<DownloadInfo> ms(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.ms(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<com.ss.android.socialbase.downloader.model.xr> ny(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.ny(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public int ms(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return 0;
        }
        return zbVar.ms(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public DownloadInfo xr(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.xr(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<DownloadInfo> xr(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.xr(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<DownloadInfo> ah(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.ah(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<DownloadInfo> d(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.ka(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<DownloadInfo> xr() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void xr(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar != null) {
            zbVar.xr(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void xr(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.xr(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ah(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.xr(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ch(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ch(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.xr(i, i2, com.ss.android.socialbase.downloader.ny.ab.ms(nyVar), com.ss.android.socialbase.downloader.ny.c.ka(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void xr(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, i2, com.ss.android.socialbase.downloader.ny.ab.ms(nyVar), com.ss.android.socialbase.downloader.ny.c.ka(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, i2, com.ss.android.socialbase.downloader.ny.ab.ms(nyVar), com.ss.android.socialbase.downloader.ny.c.ka(i3), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean ms(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.ms(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean c() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.xr();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean ah() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.ah();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public List<DownloadInfo> ka(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return zbVar.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean hi(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.sl(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void sl(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.hi(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean d() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.ka();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void d(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.d.ms().xr(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public int zb(int i) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.d.ms().xr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(xrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean xr(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.ah(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean u(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ub(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ub(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, int i2, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, int i2, int i3, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, int i2, int i3, int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public boolean ao(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return false;
        }
        return zbVar.ao(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ka() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.xr(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(f fVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(com.ss.android.socialbase.downloader.ny.ab.ms(fVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public w h(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.ny.ab.ms(zbVar.h(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public g qv(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.ny.ab.ms(zbVar.qv(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public void ms(int i, w wVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return;
        }
        zbVar.ms(i, com.ss.android.socialbase.downloader.ny.ab.ms(wVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ny
    public com.ss.android.socialbase.downloader.depend.ab y(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.zb zbVar = this.xr;
        if (zbVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.ny.ab.ms(zbVar.y(i));
    }
}
