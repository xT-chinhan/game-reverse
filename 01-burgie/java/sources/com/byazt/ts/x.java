package com.byazt.ts;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.byazt.lj.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 121})
public class x implements com.byazt.lj.vk {
    public volatile boolean hn;
    public a hw;
    public com.byazt.gi.zo uc;
    public volatile boolean x;
    public com.byazt.gi.zo.pr c = new com.byazt.gi.zo.pr() { // from class: com.byazt.ts.x.1
        @Override // com.byazt.gi.zo.pr
        public void pr(Message message) {
            if (message.what == 1) {
                com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.ts.x.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            x.this.aj();
                        } catch (Exception e) {
                        }
                    }
                });
            }
        }
    };
    public final w pr = new w();

    public x() {
        this.uc = null;
        if (!com.byazt.ew.pr.hn().pr("fix_sigbus_downloader_db") || com.byazt.tuy.uc.pr() || !com.byazt.lj.hn.nw()) {
            this.hw = new com.byazt.mef.c();
        } else {
            this.hw = com.byazt.lj.hn.ie().pr(new com.byazt.lj.hn.pr.InterfaceC0121pr() { // from class: com.byazt.ts.x.2
                @Override // com.byazt.lj.hn.pr.InterfaceC0121pr
                public void pr() {
                    x.this.hw = new com.byazt.mef.c();
                    com.byazt.ca.ho.hw("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.hn = false;
        this.uc = new com.byazt.gi.zo(Looper.getMainLooper(), this.c);
        fw();
    }

    public w pr() {
        return this.pr;
    }

    public a uc() {
        return this.hw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo fw(int i) {
        DownloadInfo downloadInfoFw = this.pr.fw(i);
        hn(downloadInfoFw);
        return downloadInfoFw;
    }

    public void fw() {
        List<com.byazt.auw.hw> list;
        DownloadInfo downloadInfo;
        com.byazt.lj.hn.pr(com.byazt.mrs.x.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.byazt.auw.hw>> sparseArray2 = new SparseArray<>();
        synchronized (this.pr) {
            SparseArray<DownloadInfo> sparseArrayPr = this.pr.pr();
            for (int i = 0; i < sparseArrayPr.size(); i++) {
                int iKeyAt = sparseArrayPr.keyAt(i);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayPr.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.byazt.auw.hw>> sparseArrayUc = this.pr.uc();
            for (int i2 = 0; i2 < sparseArrayUc.size(); i2++) {
                int iKeyAt2 = sparseArrayUc.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayUc.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.hw.pr(sparseArray, sparseArray2, new com.byazt.mef.x() { // from class: com.byazt.ts.x.3
            @Override // com.byazt.mef.x
            public void pr() {
                synchronized (x.this.pr) {
                    SparseArray<DownloadInfo> sparseArrayPr2 = x.this.pr.pr();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayPr2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.byazt.auw.hw>> sparseArrayUc2 = x.this.pr.uc();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayUc2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                x.this.vk();
                x.this.zo();
                com.byazt.lj.hn.pr(com.byazt.mrs.x.SYNC_SUCCESS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        synchronized (this) {
            this.hn = true;
            notifyAll();
        }
    }

    @Override // com.byazt.lj.vk
    public boolean c() {
        if (this.hn) {
            return true;
        }
        synchronized (this) {
            if (!this.hn) {
                com.byazt.p000do.pr.x("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                }
                com.byazt.p000do.pr.x("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.hn;
    }

    @Override // com.byazt.lj.vk
    public boolean x() {
        return this.hn;
    }

    public void zo() {
        long j;
        if (com.byazt.ew.pr.hn().pr("task_resume_delay")) {
            j = 4000;
        } else if (Build.VERSION.SDK_INT >= 23) {
            j = 1000;
        } else {
            j = 5000;
        }
        this.uc.sendMessageDelayed(this.uc.obtainMessage(1), j);
    }

    public void aj() {
        List<String> listPr;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (!this.hn) {
            return;
        }
        if (this.x) {
            com.byazt.p000do.pr.hw("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
            return;
        }
        this.x = true;
        if (!com.byazt.tuy.uc.pr()) {
            return;
        }
        com.byazt.lj.k kVarRc = com.byazt.lj.hn.rc();
        if (kVarRc == null) {
            listPr = null;
            arrayList = null;
        } else {
            listPr = kVarRc.pr();
            if (listPr != null && !listPr.isEmpty()) {
                arrayList = new ArrayList();
            } else {
                arrayList = null;
            }
        }
        SparseArray sparseArray = new SparseArray();
        synchronized (this) {
            SparseArray<DownloadInfo> sparseArrayPr = this.pr.pr();
            for (int i = 0; i < sparseArrayPr.size(); i++) {
                int iKeyAt = sparseArrayPr.keyAt(i);
                if (iKeyAt != 0 && (downloadInfo2 = sparseArrayPr.get(iKeyAt)) != null) {
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
                    com.byazt.cha.pr.pr(com.byazt.lj.hn.fw(), downloadInfo, (BaseException) null, -5);
                }
                if (listPr != null && arrayList != null && downloadInfo.getMimeType() != null && listPr.contains(downloadInfo.getMimeType()) && (com.byazt.ew.pr.pr(downloadInfo.getId()).hw("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                    arrayList.add(downloadInfo);
                }
            }
        }
        if (kVarRc != null && arrayList != null && !arrayList.isEmpty()) {
            kVarRc.pr(arrayList, 1);
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hw(int i) {
        return this.pr.hw(i);
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> pr(String str) {
        return this.pr.pr(str);
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> hw(String str) {
        return this.pr.hw(str);
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> hn(String str) {
        return this.pr.hn(str);
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> x(String str) {
        return this.pr.x(str);
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> hw() {
        return this.pr.hw();
    }

    @Override // com.byazt.lj.vk
    public List<com.byazt.auw.hw> hn(int i) {
        return this.pr.hn(i);
    }

    @Override // com.byazt.lj.vk
    public void x(int i) {
        this.pr.x(i);
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.ho(i);
                return;
            } else {
                this.hw.x(i);
                return;
            }
        }
        this.hw.x(i);
    }

    @Override // com.byazt.lj.vk
    public void pr(com.byazt.auw.hw hwVar) {
        synchronized (this.pr) {
            this.pr.pr(hwVar);
        }
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.pr(hwVar);
                return;
            } else {
                this.hw.pr(hwVar);
                return;
            }
        }
        this.hw.pr(hwVar);
    }

    @Override // com.byazt.lj.vk
    public void hw(com.byazt.auw.hw hwVar) {
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.pr(hwVar);
                return;
            } else {
                this.hw.pr(hwVar);
                return;
            }
        }
        this.hw.pr(hwVar);
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, long j) {
        this.pr.pr(i, i2, j);
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.pr(i, i2, j);
                return;
            } else {
                this.hw.pr(i, i2, j);
                return;
            }
        }
        this.hw.pr(i, i2, j);
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, int i3, long j) {
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.pr(i, i2, i3, j);
                return;
            } else {
                this.hw.pr(i, i2, i3, j);
                return;
            }
        }
        this.hw.pr(i, i2, i3, j);
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, int i3, int i4) {
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.pr(i, i2, i3, i4);
                return;
            } else {
                this.hw.pr(i, i2, i3, i4);
                return;
            }
        }
        this.hw.pr(i, i2, i3, i4);
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, int i2) {
        DownloadInfo downloadInfoPr = this.pr.pr(i, i2);
        hn(downloadInfoPr);
        return downloadInfoPr;
    }

    @Override // com.byazt.lj.vk
    public boolean pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zPr = this.pr.pr(downloadInfo);
        hn(downloadInfo);
        return zPr;
    }

    @Override // com.byazt.lj.vk
    public boolean c(int i) {
        com.byazt.lj.m mVarPr;
        try {
            if (com.byazt.tuy.uc.hw() && (mVarPr = k.pr(true)) != null) {
                mVarPr.g(i);
            } else {
                this.hw.c(i);
            }
        } catch (SQLiteException e) {
        }
        return this.pr.c(i);
    }

    @Override // com.byazt.lj.vk
    public boolean uc(int i) {
        com.byazt.lj.m mVarPr;
        if (com.byazt.tuy.uc.hw() && (mVarPr = k.pr(true)) != null) {
            mVarPr.nt(i);
        } else {
            this.hw.uc(i);
        }
        return this.pr.uc(i);
    }

    @Override // com.byazt.lj.vk
    public void hn() {
        try {
            this.pr.hn();
        } catch (SQLiteException e) {
        }
        if (com.byazt.tuy.uc.hw()) {
            com.byazt.lj.m mVarPr = k.pr(true);
            if (mVarPr != null) {
                mVarPr.uc();
                return;
            } else {
                this.hw.hn();
                return;
            }
        }
        this.hw.hn();
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoPr = this.pr.pr(i, j, str, str2);
        hn(downloadInfoPr);
        return downloadInfoPr;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, long j) {
        DownloadInfo downloadInfoPr = this.pr.pr(i, j);
        pr(downloadInfoPr, false);
        return downloadInfoPr;
    }

    private void hn(DownloadInfo downloadInfo) {
        pr(downloadInfo, true);
    }

    private void pr(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (com.byazt.tuy.uc.hw()) {
            if (z) {
                com.byazt.lj.m mVarPr = k.pr(true);
                if (mVarPr != null) {
                    mVarPr.hn(downloadInfo);
                    return;
                } else {
                    this.hw.pr(downloadInfo);
                    return;
                }
            }
            return;
        }
        this.hw.pr(downloadInfo);
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hw(int i, long j) {
        DownloadInfo downloadInfoHw = this.pr.hw(i, j);
        hw(i, (List<com.byazt.auw.hw>) null);
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo zo(int i) {
        DownloadInfo downloadInfoZo = this.pr.zo(i);
        hn(downloadInfoZo);
        return downloadInfoZo;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hn(int i, long j) {
        DownloadInfo downloadInfoHn = this.pr.hn(i, j);
        hw(i, (List<com.byazt.auw.hw>) null);
        return downloadInfoHn;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo x(int i, long j) {
        DownloadInfo downloadInfoX = this.pr.x(i, j);
        hw(i, (List<com.byazt.auw.hw>) null);
        return downloadInfoX;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo aj(int i) {
        DownloadInfo downloadInfoAj = this.pr.aj(i);
        hn(downloadInfoAj);
        return downloadInfoAj;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo vk(int i) {
        DownloadInfo downloadInfoVk = this.pr.vk(i);
        hn(downloadInfoVk);
        return downloadInfoVk;
    }

    @Override // com.byazt.lj.vk
    public void hw(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.pr.pr(downloadInfo);
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, List<com.byazt.auw.hw> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.pr.pr(i, list);
        if (com.byazt.tuy.uc.hn()) {
            this.hw.hw(i, list);
        }
    }

    @Override // com.byazt.lj.vk
    public void hw(int i, List<com.byazt.auw.hw> list) {
        try {
            pr(this.pr.hw(i));
            if (list == null) {
                list = this.pr.hn(i);
            }
            if (com.byazt.tuy.uc.hw()) {
                com.byazt.lj.m mVarPr = k.pr(true);
                if (mVarPr != null) {
                    mVarPr.hw(i, list);
                    return;
                } else {
                    this.hw.hw(i, list);
                    return;
                }
            }
            this.hw.hw(i, list);
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.lj.vk
    public List<com.byazt.stx.aj> g(int i) {
        List<com.byazt.stx.aj> listG = this.pr.g(i);
        if (listG == null || listG.size() == 0) {
            return this.hw.g(i);
        }
        return listG;
    }

    @Override // com.byazt.lj.vk
    public Map<Long, com.byazt.stx.aj> k(int i) {
        Map<Long, com.byazt.stx.aj> mapK = this.pr.k(i);
        if (mapK == null || mapK.isEmpty()) {
            Map<Long, com.byazt.stx.aj> mapK2 = this.hw.k(i);
            this.pr.pr(i, mapK2);
            return mapK2;
        }
        return mapK;
    }

    @Override // com.byazt.lj.vk
    public boolean pr(int i, Map<Long, com.byazt.stx.aj> map) {
        this.pr.pr(i, map);
        this.hw.pr(i, map);
        return false;
    }

    @Override // com.byazt.lj.vk
    public void m(int i) {
        this.pr.m(i);
        this.hw.m(i);
    }
}
