package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.le;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f4662ms;
    private volatile SparseArray<Boolean> xr = new SparseArray<>();
    private Handler ah = new Handler(Looper.getMainLooper());
    private volatile List<le> d = new ArrayList();

    public static d ms() {
        if (f4662ms == null) {
            synchronized (d.class) {
                f4662ms = new d();
            }
        }
        return f4662ms;
    }

    public void ms(le leVar) {
        if (leVar == null || com.ss.android.socialbase.downloader.ny.c.ah()) {
            return;
        }
        com.ss.android.socialbase.downloader.impls.sl.ms(true);
        synchronized (this.d) {
            if (!this.d.contains(leVar)) {
                this.d.add(leVar);
            }
        }
    }

    public void xr(le leVar) {
        if (leVar == null) {
            return;
        }
        synchronized (this.d) {
            if (this.d.contains(leVar)) {
                this.d.remove(leVar);
            }
        }
    }

    public void xr() {
        synchronized (this.d) {
            Iterator<le> it = this.d.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void ms(int i, boolean z) {
        xr(i, z);
        if (ah.qf() && !com.ss.android.socialbase.downloader.ny.c.ah() && com.ss.android.socialbase.downloader.impls.sl.ms(true).ab()) {
            com.ss.android.socialbase.downloader.impls.sl.ms(true).ah(i, z);
        }
        if (ah.ah() || com.ss.android.socialbase.downloader.ny.c.ah() || com.ss.android.socialbase.downloader.ny.c.ms()) {
            return;
        }
        try {
            Intent intent = new Intent(ah.k(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            ah.k().startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public synchronized void xr(int i, boolean z) {
        this.xr.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int ms(int i) {
        if (!ah.qf()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.ny.c.ah() && com.ss.android.socialbase.downloader.impls.sl.ms(true).ab()) {
            return com.ss.android.socialbase.downloader.impls.sl.ms(true).zb(i);
        }
        return xr(i);
    }

    public synchronized int xr(int i) {
        if (this.xr.get(i) == null) {
            return -1;
        }
        return this.xr.get(i).booleanValue() ? 1 : 0;
    }

    public zb ah(int i) {
        return com.ss.android.socialbase.downloader.impls.sl.ms(ms(i) == 1 && !com.ss.android.socialbase.downloader.ny.c.ah());
    }

    private zb xr(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.xr> listNy;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.ny.c.ah() || !com.ss.android.socialbase.downloader.ny.c.ms()) {
            zIsNeedIndependentProcess = true;
        }
        int iMs = ms(downloadInfo.getId());
        if (iMs >= 0 && iMs != zIsNeedIndependentProcess) {
            try {
                if (iMs == 1) {
                    if (com.ss.android.socialbase.downloader.ny.c.ms()) {
                        com.ss.android.socialbase.downloader.impls.sl.ms(true).ms(downloadInfo.getId());
                        DownloadInfo downloadInfoX = com.ss.android.socialbase.downloader.impls.sl.ms(true).x(downloadInfo.getId());
                        if (downloadInfoX != null) {
                            com.ss.android.socialbase.downloader.impls.sl.ms(false).xr(downloadInfoX);
                        }
                        if (downloadInfoX.getChunkCount() > 1 && (listNy = com.ss.android.socialbase.downloader.impls.sl.ms(true).ny(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.sl.ms(false).ms(downloadInfo.getId(), com.ss.android.socialbase.downloader.ny.c.ms(listNy));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.ny.c.ms()) {
                    com.ss.android.socialbase.downloader.impls.sl.ms(false).ms(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.xr> listNy2 = com.ss.android.socialbase.downloader.impls.sl.ms(false).ny(downloadInfo.getId());
                    if (listNy2 != null) {
                        com.ss.android.socialbase.downloader.impls.sl.ms(true).ms(downloadInfo.getId(), com.ss.android.socialbase.downloader.ny.c.ms(listNy2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.sl.ms(true).ms(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        ms(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.ss.android.socialbase.downloader.impls.sl.ms(zIsNeedIndependentProcess);
    }

    public void d(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ms(i);
    }

    public void ah(int i, boolean z) {
        if (com.ss.android.socialbase.downloader.ny.c.ms()) {
            if (com.ss.android.socialbase.downloader.ny.ms.ms(8388608)) {
                zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(true);
                if (zbVarMs != null) {
                    zbVarMs.ms(i, z);
                }
                zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(false);
                if (zbVarMs2 != null) {
                    zbVarMs2.ms(i, z);
                    return;
                }
                return;
            }
            zb zbVarMs3 = com.ss.android.socialbase.downloader.impls.sl.ms(false);
            if (zbVarMs3 != null) {
                zbVarMs3.ms(i, z);
            }
            zb zbVarMs4 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
            if (zbVarMs4 != null) {
                zbVarMs4.ms(i, z);
                return;
            }
            return;
        }
        zb zbVarAh = ah(i);
        if (zbVarAh != null) {
            zbVarAh.ms(i, z);
        }
        com.ss.android.socialbase.downloader.impls.sl.ms(true).ms(2, i);
    }

    public boolean ka(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return false;
        }
        return zbVarAh.xr(i);
    }

    public void c(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ah(i);
    }

    public void ab(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.d(i);
    }

    public void ah() {
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        if (zbVarMs != null) {
            zbVarMs.ms();
        }
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        if (zbVarMs2 != null) {
            zbVarMs2.ms();
        }
    }

    public long x(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return 0L;
        }
        return zbVarAh.ka(i);
    }

    public int ny(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return 0;
        }
        return zbVarAh.c(i);
    }

    public boolean ch(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return false;
        }
        return zbVarAh.ab(i);
    }

    public DownloadInfo hi(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return null;
        }
        return zbVarAh.x(i);
    }

    public int ms(String str, String str2) {
        return ah.ms(str, str2);
    }

    public DownloadInfo xr(String str, String str2) {
        int iMs = ms(str, str2);
        zb zbVarAh = ah(iMs);
        if (zbVarAh == null) {
            return null;
        }
        return zbVarAh.x(iMs);
    }

    public List<DownloadInfo> ms(String str) {
        List<DownloadInfo> listMs = com.ss.android.socialbase.downloader.impls.sl.ms(false).ms(str);
        List<DownloadInfo> listMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true).ms(str);
        if (listMs == null && listMs2 == null) {
            return null;
        }
        if (listMs == null || listMs2 == null) {
            return listMs != null ? listMs : listMs2;
        }
        ArrayList arrayList = new ArrayList(listMs);
        arrayList.addAll(listMs2);
        return arrayList;
    }

    public yu sl(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return null;
        }
        return zbVarAh.h(i);
    }

    public of zb(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return null;
        }
        return zbVarAh.qv(i);
    }

    public void ms(int i, yu yuVar) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ms(i, yuVar);
    }

    public List<DownloadInfo> xr(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        List<DownloadInfo> listXr = zbVarMs != null ? zbVarMs.xr(str) : null;
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        return ms(listXr, zbVarMs2 != null ? zbVarMs2.xr(str) : null, sparseArray);
    }

    private List<DownloadInfo> ms(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public List<DownloadInfo> ah(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        List<DownloadInfo> listAh = zbVarMs != null ? zbVarMs.ah(str) : null;
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        return ms(listAh, zbVarMs2 != null ? zbVarMs2.ah(str) : null, sparseArray);
    }

    public void ms(List<String> list) {
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        if (zbVarMs != null) {
            zbVarMs.ms(list);
        }
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        if (zbVarMs2 != null) {
            zbVarMs2.ms(list);
        }
    }

    public void xr(List<String> list) {
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        if (zbVarMs != null) {
            zbVarMs.xr(list);
        }
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        if (zbVarMs2 != null) {
            zbVarMs2.xr(list);
        }
    }

    public void d(int i, boolean z) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.xr(i, z);
    }

    public void u(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ch(i);
    }

    public void ms(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.xr(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, cVar, z);
    }

    public void xr(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ms(i, iDownloadListener.hashCode(), iDownloadListener, cVar, z);
    }

    public void ms(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z, boolean z2) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ms(i, iDownloadListener.hashCode(), iDownloadListener, cVar, z, z2);
    }

    public boolean ms(DownloadInfo downloadInfo) {
        zb zbVarAh;
        if (downloadInfo == null || (zbVarAh = ah(downloadInfo.getId())) == null) {
            return false;
        }
        return zbVarAh.ms(downloadInfo);
    }

    public boolean d() {
        return ah.eg();
    }

    public List<DownloadInfo> d(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        List<DownloadInfo> listD = zbVarMs != null ? zbVarMs.d(str) : null;
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        return ms(listD, zbVarMs2 != null ? zbVarMs2.d(str) : null, sparseArray);
    }

    public List<DownloadInfo> ka(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        List<DownloadInfo> listKa = zbVarMs != null ? zbVarMs.ka(str) : null;
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        return ms(listKa, zbVarMs2 != null ? zbVarMs2.ka(str) : null, sparseArray);
    }

    public List<DownloadInfo> ka() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        List<DownloadInfo> listD = zbVarMs != null ? zbVarMs.d() : null;
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        return ms(listD, zbVarMs2 != null ? zbVarMs2.d() : null, sparseArray);
    }

    public void ms(final DownloadTask downloadTask) {
        final zb zbVarXr = xr(downloadTask);
        if (zbVarXr == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.d.ms.ms(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.ah.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    zbVarXr.ms(downloadTask);
                }
            }, 500L);
        } else {
            zbVarXr.ms(downloadTask);
        }
    }

    public boolean ub(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return false;
        }
        return zbVarAh.sl(i);
    }

    public void ao(int i) {
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        if (zbVarMs != null) {
            zbVarMs.hi(i);
        }
        zb zbVarMs2 = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        if (zbVarMs2 != null) {
            zbVarMs2.hi(i);
        }
    }

    public void h(int i) {
        if (i == 0) {
            return;
        }
        xr(i, true);
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(true);
        if (zbVarMs == null) {
            return;
        }
        zbVarMs.startService();
    }

    public void ms(com.ss.android.socialbase.downloader.depend.hi hiVar) {
        ah.ms(hiVar);
    }

    public void xr(com.ss.android.socialbase.downloader.depend.hi hiVar) {
        ah.xr(hiVar);
    }

    public boolean c() {
        zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(false);
        if (zbVarMs != null) {
            return zbVarMs.ka();
        }
        return false;
    }

    public IDownloadFileUriProvider qv(int i) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return null;
        }
        return zbVarAh.y(i);
    }

    public void ms(int i, long j) {
        zb zbVarAh = ah(i);
        if (zbVarAh == null) {
            return;
        }
        zbVarAh.ms(i, j);
    }
}
