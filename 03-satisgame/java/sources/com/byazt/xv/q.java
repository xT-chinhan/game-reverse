package com.byazt.xv;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.i.DownloadHandleService;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.je.ur;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 5})
public class q {
    public static volatile q n;
    public volatile SparseArray<Boolean> qg = new SparseArray<>();
    public Handler s = new Handler(Looper.getMainLooper());
    public volatile List<ur> q = new ArrayList();

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                n = new q();
            }
        }
        return n;
    }

    public void n(ur urVar) {
        if (urVar == null || com.byazt.ta.w.s()) {
            return;
        }
        com.byazt.i.d.n(true);
        synchronized (this.q) {
            if (!this.q.contains(urVar)) {
                this.q.add(urVar);
            }
        }
    }

    public void qg(ur urVar) {
        if (urVar == null) {
            return;
        }
        synchronized (this.q) {
            if (this.q.contains(urVar)) {
                this.q.remove(urVar);
            }
        }
    }

    public void qg() {
        synchronized (this.q) {
            Iterator<ur> it = this.q.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void n(int i, boolean z) {
        qg(i, z);
        if (s.rf() && !com.byazt.ta.w.s() && com.byazt.i.d.n(true).x()) {
            com.byazt.i.d.n(true).s(i, z);
        }
        if (s.s() || com.byazt.ta.w.s() || com.byazt.ta.w.n()) {
            return;
        }
        try {
            Intent intent = new Intent(s.u(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            s.u().startService(intent);
        } catch (Throwable unused) {
        }
    }

    public synchronized void qg(int i, boolean z) {
        this.qg.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int n(int i) {
        if (!s.rf()) {
            return -1;
        }
        if (!com.byazt.ta.w.s() && com.byazt.i.d.n(true).x()) {
            return com.byazt.i.d.n(true).oa(i);
        }
        return qg(i);
    }

    public synchronized int qg(int i) {
        if (this.qg.get(i) == null) {
            return -1;
        }
        return this.qg.get(i).booleanValue() ? 1 : 0;
    }

    public oa s(int i) {
        return com.byazt.i.d.n(n(i) == 1 && !com.byazt.ta.w.s());
    }

    private oa qg(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.byazt.wm.qg> listRv;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.byazt.ta.w.s() || !com.byazt.ta.w.n()) {
            zIsNeedIndependentProcess = true;
        }
        int iN = n(downloadInfo.getId());
        if (iN >= 0 && iN != zIsNeedIndependentProcess) {
            try {
                if (iN == 1) {
                    if (com.byazt.ta.w.n()) {
                        com.byazt.i.d.n(true).n(downloadInfo.getId());
                        DownloadInfo downloadInfoFs = com.byazt.i.d.n(true).fs(downloadInfo.getId());
                        if (downloadInfoFs != null) {
                            com.byazt.i.d.n(false).qg(downloadInfoFs);
                        }
                        if (downloadInfoFs.getChunkCount() > 1 && (listRv = com.byazt.i.d.n(true).rv(downloadInfo.getId())) != null) {
                            com.byazt.i.d.n(false).n(downloadInfo.getId(), com.byazt.ta.w.n(listRv));
                        }
                    }
                } else if (com.byazt.ta.w.n()) {
                    com.byazt.i.d.n(false).n(downloadInfo.getId());
                    List<com.byazt.wm.qg> listRv2 = com.byazt.i.d.n(false).rv(downloadInfo.getId());
                    if (listRv2 != null) {
                        com.byazt.i.d.n(true).n(downloadInfo.getId(), com.byazt.ta.w.n(listRv2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.byazt.i.d.n(true).n(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        n(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.byazt.i.d.n(zIsNeedIndependentProcess);
    }

    public void q(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.n(i);
    }

    public void s(int i, boolean z) {
        if (com.byazt.ta.w.n()) {
            if (com.byazt.ta.n.n(8388608)) {
                oa oaVarN = com.byazt.i.d.n(true);
                if (oaVarN != null) {
                    oaVarN.n(i, z);
                }
                oa oaVarN2 = com.byazt.i.d.n(false);
                if (oaVarN2 != null) {
                    oaVarN2.n(i, z);
                    return;
                }
                return;
            }
            oa oaVarN3 = com.byazt.i.d.n(false);
            if (oaVarN3 != null) {
                oaVarN3.n(i, z);
            }
            oa oaVarN4 = com.byazt.i.d.n(true);
            if (oaVarN4 != null) {
                oaVarN4.n(i, z);
                return;
            }
            return;
        }
        oa oaVarS = s(i);
        if (oaVarS != null) {
            oaVarS.n(i, z);
        }
        com.byazt.i.d.n(true).n(2, i);
    }

    public boolean l(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return false;
        }
        return oaVarS.qg(i);
    }

    public void w(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.s(i);
    }

    public void x(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.q(i);
    }

    public void s() {
        oa oaVarN = com.byazt.i.d.n(false);
        if (oaVarN != null) {
            oaVarN.n();
        }
        oa oaVarN2 = com.byazt.i.d.n(true);
        if (oaVarN2 != null) {
            oaVarN2.n();
        }
    }

    public long fs(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return 0L;
        }
        return oaVarS.l(i);
    }

    public int rv(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return 0;
        }
        return oaVarS.w(i);
    }

    public boolean tj(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return false;
        }
        return oaVarS.x(i);
    }

    public DownloadInfo cp(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return null;
        }
        return oaVarS.fs(i);
    }

    public int n(String str, String str2) {
        return s.n(str, str2);
    }

    public DownloadInfo qg(String str, String str2) {
        int iN = n(str, str2);
        oa oaVarS = s(iN);
        if (oaVarS == null) {
            return null;
        }
        return oaVarS.fs(iN);
    }

    public List<DownloadInfo> n(String str) {
        List<DownloadInfo> listN = com.byazt.i.d.n(false).n(str);
        List<DownloadInfo> listN2 = com.byazt.i.d.n(true).n(str);
        if (listN == null && listN2 == null) {
            return null;
        }
        if (listN == null || listN2 == null) {
            return listN != null ? listN : listN2;
        }
        ArrayList arrayList = new ArrayList(listN);
        arrayList.addAll(listN2);
        return arrayList;
    }

    public h d(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return null;
        }
        return oaVarS.hd(i);
    }

    public lh oa(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return null;
        }
        return oaVarS.cd(i);
    }

    public void n(int i, h hVar) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.n(i, hVar);
    }

    public List<DownloadInfo> qg(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        oa oaVarN = com.byazt.i.d.n(false);
        List<DownloadInfo> listQg = oaVarN != null ? oaVarN.qg(str) : null;
        oa oaVarN2 = com.byazt.i.d.n(true);
        return n(listQg, oaVarN2 != null ? oaVarN2.qg(str) : null, sparseArray);
    }

    private List<DownloadInfo> n(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
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

    public List<DownloadInfo> s(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        oa oaVarN = com.byazt.i.d.n(false);
        List<DownloadInfo> listS = oaVarN != null ? oaVarN.s(str) : null;
        oa oaVarN2 = com.byazt.i.d.n(true);
        return n(listS, oaVarN2 != null ? oaVarN2.s(str) : null, sparseArray);
    }

    public void n(List<String> list) {
        oa oaVarN = com.byazt.i.d.n(false);
        if (oaVarN != null) {
            oaVarN.n(list);
        }
        oa oaVarN2 = com.byazt.i.d.n(true);
        if (oaVarN2 != null) {
            oaVarN2.n(list);
        }
    }

    public void qg(List<String> list) {
        oa oaVarN = com.byazt.i.d.n(false);
        if (oaVarN != null) {
            oaVarN.qg(list);
        }
        oa oaVarN2 = com.byazt.i.d.n(true);
        if (oaVarN2 != null) {
            oaVarN2.qg(list);
        }
    }

    public void q(int i, boolean z) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.qg(i, z);
    }

    public void sz(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.tj(i);
    }

    public void n(int i, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.qg(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, wVar, z);
    }

    public void qg(int i, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.n(i, iDownloadListener.hashCode(), iDownloadListener, wVar, z);
    }

    public void n(int i, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z, boolean z2) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.n(i, iDownloadListener.hashCode(), iDownloadListener, wVar, z, z2);
    }

    public boolean n(DownloadInfo downloadInfo) {
        oa oaVarS;
        if (downloadInfo == null || (oaVarS = s(downloadInfo.getId())) == null) {
            return false;
        }
        return oaVarS.n(downloadInfo);
    }

    public boolean q() {
        return s.pk();
    }

    public List<DownloadInfo> q(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        oa oaVarN = com.byazt.i.d.n(false);
        List<DownloadInfo> listQ = oaVarN != null ? oaVarN.q(str) : null;
        oa oaVarN2 = com.byazt.i.d.n(true);
        return n(listQ, oaVarN2 != null ? oaVarN2.q(str) : null, sparseArray);
    }

    public List<DownloadInfo> l(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        oa oaVarN = com.byazt.i.d.n(false);
        List<DownloadInfo> listL = oaVarN != null ? oaVarN.l(str) : null;
        oa oaVarN2 = com.byazt.i.d.n(true);
        return n(listL, oaVarN2 != null ? oaVarN2.l(str) : null, sparseArray);
    }

    public List<DownloadInfo> l() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        oa oaVarN = com.byazt.i.d.n(false);
        List<DownloadInfo> listQ = oaVarN != null ? oaVarN.q() : null;
        oa oaVarN2 = com.byazt.i.d.n(true);
        return n(listQ, oaVarN2 != null ? oaVarN2.q() : null, sparseArray);
    }

    public void n(final DownloadTask downloadTask) {
        final oa oaVarQg = qg(downloadTask);
        if (oaVarQg == null) {
            if (downloadTask != null) {
                com.byazt.g.n.n(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.s.postDelayed(new Runnable() { // from class: com.byazt.xv.q.1
                @Override // java.lang.Runnable
                public void run() {
                    oaVarQg.n(downloadTask);
                }
            }, 500L);
        } else {
            oaVarQg.n(downloadTask);
        }
    }

    public boolean k(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return false;
        }
        return oaVarS.d(i);
    }

    public void cy(int i) {
        oa oaVarN = com.byazt.i.d.n(false);
        if (oaVarN != null) {
            oaVarN.cp(i);
        }
        oa oaVarN2 = com.byazt.i.d.n(true);
        if (oaVarN2 != null) {
            oaVarN2.cp(i);
        }
    }

    public void hd(int i) {
        if (i == 0) {
            return;
        }
        qg(i, true);
        oa oaVarN = com.byazt.i.d.n(true);
        if (oaVarN == null) {
            return;
        }
        oaVarN.startService();
    }

    public void n(com.byazt.je.cp cpVar) {
        s.n(cpVar);
    }

    public void qg(com.byazt.je.cp cpVar) {
        s.qg(cpVar);
    }

    public boolean w() {
        oa oaVarN = com.byazt.i.d.n(false);
        if (oaVarN != null) {
            return oaVarN.l();
        }
        return false;
    }

    public IDownloadFileUriProvider cd(int i) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return null;
        }
        return oaVarS.um(i);
    }

    public void n(int i, long j) {
        oa oaVarS = s(i);
        if (oaVarS == null) {
            return;
        }
        oaVarS.n(i, j);
    }
}
