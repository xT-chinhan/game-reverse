package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class hi implements com.ss.android.socialbase.downloader.downloader.ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final SparseArray<DownloadInfo> f4687ms = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> xr = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.c.ny>> ah = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ka() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(com.ss.android.socialbase.downloader.model.xr xrVar) {
    }

    public SparseArray<DownloadInfo> ms() {
        return this.f4687ms;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> c() {
        return this.xr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ab(int i) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setStatus(2);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized DownloadInfo xr(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.f4687ms.get(i);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<DownloadInfo> ms(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.f4687ms.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo downloadInfoValueAt = this.f4687ms.valueAt(i);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<DownloadInfo> xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f4687ms.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f4687ms.size(); i++) {
            DownloadInfo downloadInfo = this.f4687ms.get(this.f4687ms.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<DownloadInfo> ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f4687ms.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f4687ms.size(); i++) {
            DownloadInfo downloadInfo = this.f4687ms.get(this.f4687ms.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f4687ms.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f4687ms.size(); i++) {
            DownloadInfo downloadInfo = this.f4687ms.get(this.f4687ms.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<DownloadInfo> xr() {
        if (this.f4687ms.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f4687ms.size());
        for (int i = 0; i < this.f4687ms.size(); i++) {
            DownloadInfo downloadInfoValueAt = this.f4687ms.valueAt(i);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<com.ss.android.socialbase.downloader.model.xr> ah(int i) {
        return this.xr.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized void d(int i) {
        this.xr.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        int iHi = xrVar.hi();
        List<com.ss.android.socialbase.downloader.model.xr> arrayList = this.xr.get(iHi);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.xr.put(iHi, arrayList);
        }
        arrayList.add(xrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized void ms(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.model.xr> listAh = ah(i);
        if (listAh == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.xr xrVar : listAh) {
            if (xrVar != null && xrVar.y() == i2) {
                xrVar.xr(j);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized void ms(int i, int i2, int i3, long j) {
        List<com.ss.android.socialbase.downloader.model.xr> listAh = ah(i);
        if (listAh == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.xr xrVar : listAh) {
            if (xrVar != null && xrVar.y() == i3 && !xrVar.c()) {
                if (xrVar.ab() == null) {
                    break;
                }
                for (com.ss.android.socialbase.downloader.model.xr xrVar2 : xrVar.ab()) {
                    if (xrVar2 != null && xrVar2.y() == i2) {
                        xrVar2.xr(j);
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized DownloadInfo ms(int i, int i2) {
        DownloadInfo downloadInfoXr;
        downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setChunkCount(i2);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized boolean ms(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.f4687ms.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.f4687ms.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized boolean ka(int i) {
        this.f4687ms.remove(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean c(int i) {
        ka(i);
        d(i);
        zb(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized void ah() {
        this.f4687ms.clear();
        this.xr.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setTotalBytes(j);
            downloadInfoXr.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoXr.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoXr.setName(str2);
            }
            downloadInfoXr.setStatus(3);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, long j) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setCurBytes(j, false);
            if (downloadInfoXr.getStatus() != -3 && downloadInfoXr.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoXr.getStatus()) && downloadInfoXr.getStatus() != -4) {
                downloadInfoXr.setStatus(4);
            }
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo xr(int i, long j) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setCurBytes(j, false);
            downloadInfoXr.setStatus(-1);
            downloadInfoXr.setFirstDownload(false);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setStatus(5);
            downloadInfoXr.setFirstDownload(false);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ah(int i, long j) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setCurBytes(j, false);
            downloadInfoXr.setStatus(-3);
            downloadInfoXr.setFirstDownload(false);
            downloadInfoXr.setFirstSuccess(false);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo d(int i, long j) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setCurBytes(j, false);
            downloadInfoXr.setStatus(-2);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ny(int i) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setStatus(1);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ch(int i) {
        DownloadInfo downloadInfoXr = xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setStatus(-7);
        }
        return downloadInfoXr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(DownloadInfo downloadInfo) {
        ms(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        if (list == null) {
            return;
        }
        d(i);
        for (com.ss.android.socialbase.downloader.model.xr xrVar : list) {
            if (xrVar != null) {
                ms(xrVar);
                if (xrVar.c()) {
                    Iterator<com.ss.android.socialbase.downloader.model.xr> it = xrVar.ab().iterator();
                    while (it.hasNext()) {
                        ms(it.next());
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized List<com.ss.android.socialbase.downloader.c.ny> u(int i) {
        Map<Long, com.ss.android.socialbase.downloader.c.ny> map = this.ah.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized Map<Long, com.ss.android.socialbase.downloader.c.ny> sl(int i) {
        return this.ah.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized boolean ms(int i, Map<Long, com.ss.android.socialbase.downloader.c.ny> map) {
        this.ah.put(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public synchronized void zb(int i) {
        this.ah.remove(i);
    }
}
