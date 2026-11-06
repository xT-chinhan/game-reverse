package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.ch {
    private volatile boolean ah;
    private com.ss.android.socialbase.downloader.x.x c;
    private volatile boolean d;
    private com.ss.android.socialbase.downloader.x.x.ms ka = new com.ss.android.socialbase.downloader.x.x.ms() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.x.x.ms
        public void ms(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.ny();
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e);
                        }
                    }
                });
            }
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final hi f4681ms = new hi();
    private t xr;

    public d() {
        this.c = null;
        if (!com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_sigbus_downloader_db") || com.ss.android.socialbase.downloader.ny.c.ms() || !com.ss.android.socialbase.downloader.downloader.ah.qf()) {
            this.xr = new com.ss.android.socialbase.downloader.xr.ka();
        } else {
            this.xr = com.ss.android.socialbase.downloader.downloader.ah.l().ms(new com.ss.android.socialbase.downloader.downloader.ah.ms.InterfaceC0564ms() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                @Override // com.ss.android.socialbase.downloader.downloader.ah.ms.InterfaceC0564ms
                public void ms() {
                    d.this.xr = new com.ss.android.socialbase.downloader.xr.ka();
                    com.bytedance.sdk.openadsdk.api.ab.ka("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.ah = false;
        this.c = new com.ss.android.socialbase.downloader.x.x(Looper.getMainLooper(), this.ka);
        ab();
    }

    public hi ms() {
        return this.f4681ms;
    }

    public t c() {
        return this.xr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ab(int i) {
        DownloadInfo downloadInfoAb = this.f4681ms.ab(i);
        ah(downloadInfoAb);
        return downloadInfoAb;
    }

    public void ab() {
        List<com.ss.android.socialbase.downloader.model.xr> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.ah.ms(com.ss.android.socialbase.downloader.constants.d.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArray2 = new SparseArray<>();
        synchronized (this.f4681ms) {
            SparseArray<DownloadInfo> sparseArrayMs = this.f4681ms.ms();
            for (int i = 0; i < sparseArrayMs.size(); i++) {
                int iKeyAt = sparseArrayMs.keyAt(i);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayMs.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArrayC = this.f4681ms.c();
            for (int i2 = 0; i2 < sparseArrayC.size(); i2++) {
                int iKeyAt2 = sparseArrayC.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayC.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.xr.ms(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.xr.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
            @Override // com.ss.android.socialbase.downloader.xr.d
            public void ms() {
                synchronized (d.this.f4681ms) {
                    SparseArray<DownloadInfo> sparseArrayMs2 = d.this.f4681ms.ms();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayMs2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArrayC2 = d.this.f4681ms.c();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayC2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                d.this.ch();
                d.this.x();
                com.ss.android.socialbase.downloader.downloader.ah.ms(com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        synchronized (this) {
            this.ah = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ka() {
        if (this.ah) {
            return true;
        }
        synchronized (this) {
            if (!this.ah) {
                com.ss.android.socialbase.downloader.ah.ms.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
                com.ss.android.socialbase.downloader.ah.ms.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.ah;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean d() {
        return this.ah;
    }

    public void x() {
        this.c.sendMessageDelayed(this.c.obtainMessage(1), com.ss.android.socialbase.downloader.ab.ms.ah().ms("task_resume_delay") ? 4000L : 1000L);
    }

    public void ny() {
        List<String> listMs;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.ah) {
            if (this.d) {
                com.ss.android.socialbase.downloader.ah.ms.xr("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.d = true;
            if (com.ss.android.socialbase.downloader.ny.c.ms()) {
                com.ss.android.socialbase.downloader.downloader.sl slVarI = com.ss.android.socialbase.downloader.downloader.ah.i();
                if (slVarI != null) {
                    listMs = slVarI.ms();
                    arrayList = (listMs == null || listMs.isEmpty()) ? null : new ArrayList();
                } else {
                    listMs = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> sparseArrayMs = this.f4681ms.ms();
                    for (int i = 0; i < sparseArrayMs.size(); i++) {
                        int iKeyAt = sparseArrayMs.keyAt(i);
                        if (iKeyAt != 0 && (downloadInfo2 = sparseArrayMs.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    if (iKeyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(iKeyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit > 0 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.d.ms.ms(com.ss.android.socialbase.downloader.downloader.ah.ab(), downloadInfo, (BaseException) null, -5);
                        }
                        if (listMs != null && arrayList != null && downloadInfo.getMimeType() != null && listMs.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).xr("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (slVarI == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                slVarI.ms(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo xr(int i) {
        return this.f4681ms.xr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> ms(String str) {
        return this.f4681ms.ms(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> xr(String str) {
        return this.f4681ms.xr(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> ah(String str) {
        return this.f4681ms.ah(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> d(String str) {
        return this.f4681ms.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> xr() {
        return this.f4681ms.xr();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<com.ss.android.socialbase.downloader.model.xr> ah(int i) {
        return this.f4681ms.ah(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void d(int i) {
        this.f4681ms.d(i);
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ub(i);
                return;
            } else {
                this.xr.d(i);
                return;
            }
        }
        this.xr.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        synchronized (this.f4681ms) {
            this.f4681ms.ms(xrVar);
        }
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ms(xrVar);
                return;
            } else {
                this.xr.ms(xrVar);
                return;
            }
        }
        this.xr.ms(xrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(com.ss.android.socialbase.downloader.model.xr xrVar) {
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ms(xrVar);
                return;
            } else {
                this.xr.ms(xrVar);
                return;
            }
        }
        this.xr.ms(xrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, long j) {
        this.f4681ms.ms(i, i2, j);
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ms(i, i2, j);
                return;
            } else {
                this.xr.ms(i, i2, j);
                return;
            }
        }
        this.xr.ms(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ms(i, i2, i3, j);
                return;
            } else {
                this.xr.ms(i, i2, i3, j);
                return;
            }
        }
        this.xr.ms(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ms(i, i2, i3, i4);
                return;
            } else {
                this.xr.ms(i, i2, i3, i4);
                return;
            }
        }
        this.xr.ms(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, int i2) {
        DownloadInfo downloadInfoMs = this.f4681ms.ms(i, i2);
        ah(downloadInfoMs);
        return downloadInfoMs;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zMs = this.f4681ms.ms(downloadInfo);
        ah(downloadInfo);
        return zMs;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ka(int i) {
        com.ss.android.socialbase.downloader.downloader.zb zbVarMs;
        try {
            if (com.ss.android.socialbase.downloader.ny.c.xr() && (zbVarMs = sl.ms(true)) != null) {
                zbVarMs.u(i);
            } else {
                this.xr.ka(i);
            }
        } catch (SQLiteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return this.f4681ms.ka(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean c(int i) {
        com.ss.android.socialbase.downloader.downloader.zb zbVarMs;
        if (com.ss.android.socialbase.downloader.ny.c.xr() && (zbVarMs = sl.ms(true)) != null) {
            zbVarMs.ao(i);
        } else {
            this.xr.c(i);
        }
        return this.f4681ms.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ah() {
        try {
            this.f4681ms.ah();
        } catch (SQLiteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        if (com.ss.android.socialbase.downloader.ny.c.xr()) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.c();
                return;
            } else {
                this.xr.ah();
                return;
            }
        }
        this.xr.ah();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoMs = this.f4681ms.ms(i, j, str, str2);
        ah(downloadInfoMs);
        return downloadInfoMs;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, long j) {
        DownloadInfo downloadInfoMs = this.f4681ms.ms(i, j);
        ms(downloadInfoMs, false);
        return downloadInfoMs;
    }

    private void ah(DownloadInfo downloadInfo) {
        ms(downloadInfo, true);
    }

    private void ms(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.ny.c.xr()) {
            this.xr.ms(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
            if (zbVarMs != null) {
                zbVarMs.ah(downloadInfo);
            } else {
                this.xr.ms(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo xr(int i, long j) {
        DownloadInfo downloadInfoXr = this.f4681ms.xr(i, j);
        xr(i, (List<com.ss.android.socialbase.downloader.model.xr>) null);
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoX = this.f4681ms.x(i);
        ah(downloadInfoX);
        return downloadInfoX;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ah(int i, long j) {
        DownloadInfo downloadInfoAh = this.f4681ms.ah(i, j);
        xr(i, (List<com.ss.android.socialbase.downloader.model.xr>) null);
        return downloadInfoAh;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo d(int i, long j) {
        DownloadInfo downloadInfoD = this.f4681ms.d(i, j);
        xr(i, (List<com.ss.android.socialbase.downloader.model.xr>) null);
        return downloadInfoD;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ny(int i) {
        DownloadInfo downloadInfoNy = this.f4681ms.ny(i);
        ah(downloadInfoNy);
        return downloadInfoNy;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ch(int i) {
        DownloadInfo downloadInfoCh = this.f4681ms.ch(i);
        ah(downloadInfoCh);
        return downloadInfoCh;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f4681ms.ms(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4681ms.ms(i, list);
        if (com.ss.android.socialbase.downloader.ny.c.ah()) {
            this.xr.xr(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        try {
            ms(this.f4681ms.xr(i));
            if (list == null) {
                list = this.f4681ms.ah(i);
            }
            if (com.ss.android.socialbase.downloader.ny.c.xr()) {
                com.ss.android.socialbase.downloader.downloader.zb zbVarMs = sl.ms(true);
                if (zbVarMs != null) {
                    zbVarMs.xr(i, list);
                    return;
                } else {
                    this.xr.xr(i, list);
                    return;
                }
            }
            this.xr.xr(i, list);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<com.ss.android.socialbase.downloader.c.ny> u(int i) {
        List<com.ss.android.socialbase.downloader.c.ny> listU = this.f4681ms.u(i);
        return (listU == null || listU.size() == 0) ? this.xr.u(i) : listU;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public Map<Long, com.ss.android.socialbase.downloader.c.ny> sl(int i) {
        Map<Long, com.ss.android.socialbase.downloader.c.ny> mapSl = this.f4681ms.sl(i);
        if (mapSl != null && !mapSl.isEmpty()) {
            return mapSl;
        }
        Map<Long, com.ss.android.socialbase.downloader.c.ny> mapSl2 = this.xr.sl(i);
        this.f4681ms.ms(i, mapSl2);
        return mapSl2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ms(int i, Map<Long, com.ss.android.socialbase.downloader.c.ny> map) {
        this.f4681ms.ms(i, map);
        this.xr.ms(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void zb(int i) {
        this.f4681ms.zb(i);
        this.xr.zb(i);
    }
}
