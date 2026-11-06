package com.byazt.i;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 5})
public class q implements com.byazt.xv.tj {
    public com.byazt.l.fs.n l = new com.byazt.l.fs.n() { // from class: com.byazt.i.q.1
        @Override // com.byazt.l.fs.n
        public void n(Message message) {
            if (message.what == 1) {
                com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.i.q.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            q.this.rv();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
    };
    public final cp n = new cp();
    public volatile boolean q;
    public a qg;
    public volatile boolean s;
    public com.byazt.l.fs w;

    public q() {
        this.w = null;
        if (!com.byazt.f.n.s().n("fix_sigbus_downloader_db") || com.byazt.ta.w.n() || !com.byazt.xv.s.rf()) {
            this.qg = new com.byazt.u.l();
        } else {
            this.qg = com.byazt.xv.s.dh().n(new com.byazt.xv.s.n.InterfaceC0397n() { // from class: com.byazt.i.q.2
                @Override // com.byazt.xv.s.n.InterfaceC0397n
                public void n() {
                    q.this.qg = new com.byazt.u.l();
                    com.byazt.tk.k.qg("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.s = false;
        this.w = new com.byazt.l.fs(Looper.getMainLooper(), this.l);
        x();
    }

    public cp n() {
        return this.n;
    }

    public a w() {
        return this.qg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoX = this.n.x(i);
        s(downloadInfoX);
        return downloadInfoX;
    }

    public void x() {
        List<com.byazt.wm.qg> list;
        DownloadInfo downloadInfo;
        com.byazt.xv.s.n(com.byazt.sk.q.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.byazt.wm.qg>> sparseArray2 = new SparseArray<>();
        synchronized (this.n) {
            SparseArray<DownloadInfo> sparseArrayN = this.n.n();
            for (int i = 0; i < sparseArrayN.size(); i++) {
                int iKeyAt = sparseArrayN.keyAt(i);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayN.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.byazt.wm.qg>> sparseArrayW = this.n.w();
            for (int i2 = 0; i2 < sparseArrayW.size(); i2++) {
                int iKeyAt2 = sparseArrayW.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayW.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.qg.n(sparseArray, sparseArray2, new com.byazt.u.q() { // from class: com.byazt.i.q.3
            @Override // com.byazt.u.q
            public void n() {
                synchronized (q.this.n) {
                    SparseArray<DownloadInfo> sparseArrayN2 = q.this.n.n();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayN2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.byazt.wm.qg>> sparseArrayW2 = q.this.n.w();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayW2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                q.this.tj();
                q.this.fs();
                com.byazt.xv.s.n(com.byazt.sk.q.SYNC_SUCCESS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        synchronized (this) {
            this.s = true;
            notifyAll();
        }
    }

    @Override // com.byazt.xv.tj
    public boolean l() {
        if (this.s) {
            return true;
        }
        synchronized (this) {
            if (!this.s) {
                com.byazt.fe.n.q("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException unused) {
                }
                com.byazt.fe.n.q("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.s;
    }

    @Override // com.byazt.xv.tj
    public boolean q() {
        return this.s;
    }

    public void fs() {
        this.w.sendMessageDelayed(this.w.obtainMessage(1), com.byazt.f.n.s().n("task_resume_delay") ? 4000L : 1000L);
    }

    public void rv() {
        List<String> listN;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.s) {
            if (this.q) {
                com.byazt.fe.n.qg("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.q = true;
            if (com.byazt.ta.w.n()) {
                com.byazt.xv.d dVarM = com.byazt.xv.s.m();
                if (dVarM != null) {
                    listN = dVarM.n();
                    arrayList = (listN == null || listN.isEmpty()) ? null : new ArrayList();
                } else {
                    listN = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> sparseArrayN = this.n.n();
                    for (int i = 0; i < sparseArrayN.size(); i++) {
                        int iKeyAt = sparseArrayN.keyAt(i);
                        if (iKeyAt != 0 && (downloadInfo2 = sparseArrayN.get(iKeyAt)) != null) {
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
                            com.byazt.g.n.n(com.byazt.xv.s.x(), downloadInfo, (BaseException) null, -5);
                        }
                        if (listN != null && arrayList != null && downloadInfo.getMimeType() != null && listN.contains(downloadInfo.getMimeType()) && (com.byazt.f.n.n(downloadInfo.getId()).qg("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (dVarM == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                dVarM.n(arrayList, 1);
            }
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo qg(int i) {
        return this.n.qg(i);
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> n(String str) {
        return this.n.n(str);
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> qg(String str) {
        return this.n.qg(str);
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> s(String str) {
        return this.n.s(str);
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> q(String str) {
        return this.n.q(str);
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> qg() {
        return this.n.qg();
    }

    @Override // com.byazt.xv.tj
    public List<com.byazt.wm.qg> s(int i) {
        return this.n.s(i);
    }

    @Override // com.byazt.xv.tj
    public void q(int i) {
        this.n.q(i);
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.k(i);
                return;
            } else {
                this.qg.q(i);
                return;
            }
        }
        this.qg.q(i);
    }

    @Override // com.byazt.xv.tj
    public void n(com.byazt.wm.qg qgVar) {
        synchronized (this.n) {
            this.n.n(qgVar);
        }
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.n(qgVar);
                return;
            } else {
                this.qg.n(qgVar);
                return;
            }
        }
        this.qg.n(qgVar);
    }

    @Override // com.byazt.xv.tj
    public void qg(com.byazt.wm.qg qgVar) {
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.n(qgVar);
                return;
            } else {
                this.qg.n(qgVar);
                return;
            }
        }
        this.qg.n(qgVar);
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, long j) {
        this.n.n(i, i2, j);
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.n(i, i2, j);
                return;
            } else {
                this.qg.n(i, i2, j);
                return;
            }
        }
        this.qg.n(i, i2, j);
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, int i3, long j) {
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.n(i, i2, i3, j);
                return;
            } else {
                this.qg.n(i, i2, i3, j);
                return;
            }
        }
        this.qg.n(i, i2, i3, j);
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, int i3, int i4) {
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.n(i, i2, i3, i4);
                return;
            } else {
                this.qg.n(i, i2, i3, i4);
                return;
            }
        }
        this.qg.n(i, i2, i3, i4);
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, int i2) {
        DownloadInfo downloadInfoN = this.n.n(i, i2);
        s(downloadInfoN);
        return downloadInfoN;
    }

    @Override // com.byazt.xv.tj
    public boolean n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zN = this.n.n(downloadInfo);
        s(downloadInfo);
        return zN;
    }

    @Override // com.byazt.xv.tj
    public boolean l(int i) {
        com.byazt.xv.oa oaVarN;
        try {
            if (com.byazt.ta.w.qg() && (oaVarN = d.n(true)) != null) {
                oaVarN.sz(i);
            } else {
                this.qg.l(i);
            }
        } catch (SQLiteException unused) {
        }
        return this.n.l(i);
    }

    @Override // com.byazt.xv.tj
    public boolean w(int i) {
        com.byazt.xv.oa oaVarN;
        if (com.byazt.ta.w.qg() && (oaVarN = d.n(true)) != null) {
            oaVarN.cy(i);
        } else {
            this.qg.w(i);
        }
        return this.n.w(i);
    }

    @Override // com.byazt.xv.tj
    public void s() {
        try {
            this.n.s();
        } catch (SQLiteException unused) {
        }
        if (com.byazt.ta.w.qg()) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.w();
                return;
            } else {
                this.qg.s();
                return;
            }
        }
        this.qg.s();
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoN = this.n.n(i, j, str, str2);
        s(downloadInfoN);
        return downloadInfoN;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, long j) {
        DownloadInfo downloadInfoN = this.n.n(i, j);
        n(downloadInfoN, false);
        return downloadInfoN;
    }

    private void s(DownloadInfo downloadInfo) {
        n(downloadInfo, true);
    }

    private void n(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.byazt.ta.w.qg()) {
            this.qg.n(downloadInfo);
            return;
        }
        if (z) {
            com.byazt.xv.oa oaVarN = d.n(true);
            if (oaVarN != null) {
                oaVarN.s(downloadInfo);
            } else {
                this.qg.n(downloadInfo);
            }
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo qg(int i, long j) {
        DownloadInfo downloadInfoQg = this.n.qg(i, j);
        qg(i, (List<com.byazt.wm.qg>) null);
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo fs(int i) {
        DownloadInfo downloadInfoFs = this.n.fs(i);
        s(downloadInfoFs);
        return downloadInfoFs;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo s(int i, long j) {
        DownloadInfo downloadInfoS = this.n.s(i, j);
        qg(i, (List<com.byazt.wm.qg>) null);
        return downloadInfoS;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo q(int i, long j) {
        DownloadInfo downloadInfoQ = this.n.q(i, j);
        qg(i, (List<com.byazt.wm.qg>) null);
        return downloadInfoQ;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo rv(int i) {
        DownloadInfo downloadInfoRv = this.n.rv(i);
        s(downloadInfoRv);
        return downloadInfoRv;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo tj(int i) {
        DownloadInfo downloadInfoTj = this.n.tj(i);
        s(downloadInfoTj);
        return downloadInfoTj;
    }

    @Override // com.byazt.xv.tj
    public void qg(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.n.n(downloadInfo);
    }

    @Override // com.byazt.xv.tj
    public void n(int i, List<com.byazt.wm.qg> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.n.n(i, list);
        if (com.byazt.ta.w.s()) {
            this.qg.qg(i, list);
        }
    }

    @Override // com.byazt.xv.tj
    public void qg(int i, List<com.byazt.wm.qg> list) {
        try {
            n(this.n.qg(i));
            if (list == null) {
                list = this.n.s(i);
            }
            if (com.byazt.ta.w.qg()) {
                com.byazt.xv.oa oaVarN = d.n(true);
                if (oaVarN != null) {
                    oaVarN.qg(i, list);
                    return;
                } else {
                    this.qg.qg(i, list);
                    return;
                }
            }
            this.qg.qg(i, list);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public List<com.byazt.kl.rv> sz(int i) {
        List<com.byazt.kl.rv> listSz = this.n.sz(i);
        return (listSz == null || listSz.size() == 0) ? this.qg.sz(i) : listSz;
    }

    @Override // com.byazt.xv.tj
    public Map<Long, com.byazt.kl.rv> d(int i) {
        Map<Long, com.byazt.kl.rv> mapD = this.n.d(i);
        if (mapD != null && !mapD.isEmpty()) {
            return mapD;
        }
        Map<Long, com.byazt.kl.rv> mapD2 = this.qg.d(i);
        this.n.n(i, mapD2);
        return mapD2;
    }

    @Override // com.byazt.xv.tj
    public boolean n(int i, Map<Long, com.byazt.kl.rv> map) {
        this.n.n(i, map);
        this.qg.n(i, map);
        return false;
    }

    @Override // com.byazt.xv.tj
    public void oa(int i) {
        this.n.oa(i);
        this.qg.oa(i);
    }
}
