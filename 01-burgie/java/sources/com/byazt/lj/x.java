package com.byazt.lj;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.ve;
import com.byazt.fn.y;
import com.byazt.lhc.BaseException;
import com.byazt.ts.DownloadHandleService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 121})
public class x {
    public static volatile x pr = null;
    public volatile SparseArray<Boolean> hw = new SparseArray<>();
    public Handler hn = new Handler(Looper.getMainLooper());
    public volatile List<ve> x = new ArrayList();

    public static x pr() {
        if (pr == null) {
            synchronized (x.class) {
                pr = new x();
            }
        }
        return pr;
    }

    public void pr(ve veVar) {
        if (veVar == null || com.byazt.tuy.uc.hn()) {
            return;
        }
        com.byazt.ts.k.pr(true);
        synchronized (this.x) {
            if (!this.x.contains(veVar)) {
                this.x.add(veVar);
            }
        }
    }

    public void hw(ve veVar) {
        if (veVar == null) {
            return;
        }
        synchronized (this.x) {
            if (this.x.contains(veVar)) {
                this.x.remove(veVar);
            }
        }
    }

    public void hw() {
        synchronized (this.x) {
            Iterator<ve> it = this.x.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void pr(int i, boolean z) {
        hw(i, z);
        if (hn.nw() && !com.byazt.tuy.uc.hn() && com.byazt.ts.k.pr(true).fw()) {
            com.byazt.ts.k.pr(true).hn(i, z);
        }
        if (!hn.hn() && !com.byazt.tuy.uc.hn() && !com.byazt.tuy.uc.pr()) {
            try {
                Intent intent = new Intent(hn.of(), (Class<?>) DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i);
                hn.of().startService(intent);
            } catch (Throwable th) {
            }
        }
    }

    public synchronized void hw(int i, boolean z) {
        this.hw.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int pr(int i) {
        if (!hn.nw()) {
            return -1;
        }
        if (!com.byazt.tuy.uc.hn() && com.byazt.ts.k.pr(true).fw()) {
            return com.byazt.ts.k.pr(true).m(i);
        }
        return hw(i);
    }

    public synchronized int hw(int i) {
        if (this.hw.get(i) == null) {
            return -1;
        }
        return this.hw.get(i).booleanValue() ? 1 : 0;
    }

    public m hn(int i) {
        return com.byazt.ts.k.pr(pr(i) == 1 && !com.byazt.tuy.uc.hn());
    }

    private m hw(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.byazt.auw.hw> listAj;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.byazt.tuy.uc.hn() || !com.byazt.tuy.uc.pr()) {
            zIsNeedIndependentProcess = true;
        }
        int iPr = pr(downloadInfo.getId());
        if (iPr >= 0 && iPr != zIsNeedIndependentProcess) {
            try {
                if (iPr == 1) {
                    if (com.byazt.tuy.uc.pr()) {
                        com.byazt.ts.k.pr(true).pr(downloadInfo.getId());
                        DownloadInfo downloadInfoZo = com.byazt.ts.k.pr(true).zo(downloadInfo.getId());
                        if (downloadInfoZo != null) {
                            com.byazt.ts.k.pr(false).hw(downloadInfoZo);
                        }
                        if (downloadInfoZo.getChunkCount() > 1 && (listAj = com.byazt.ts.k.pr(true).aj(downloadInfo.getId())) != null) {
                            com.byazt.ts.k.pr(false).pr(downloadInfo.getId(), com.byazt.tuy.uc.pr(listAj));
                        }
                    }
                } else if (com.byazt.tuy.uc.pr()) {
                    com.byazt.ts.k.pr(false).pr(downloadInfo.getId());
                    List<com.byazt.auw.hw> listAj2 = com.byazt.ts.k.pr(false).aj(downloadInfo.getId());
                    if (listAj2 != null) {
                        com.byazt.ts.k.pr(true).pr(downloadInfo.getId(), com.byazt.tuy.uc.pr(listAj2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.byazt.ts.k.pr(true).pr(1, downloadInfo.getId());
                }
            } catch (Throwable th) {
            }
        }
        pr(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.byazt.ts.k.pr(zIsNeedIndependentProcess);
    }

    public void x(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.pr(i);
    }

    public void hn(int i, boolean z) {
        if (com.byazt.tuy.uc.pr()) {
            if (com.byazt.tuy.pr.pr(8388608)) {
                m mVarPr = com.byazt.ts.k.pr(true);
                if (mVarPr != null) {
                    mVarPr.pr(i, z);
                }
                m mVarPr2 = com.byazt.ts.k.pr(false);
                if (mVarPr2 != null) {
                    mVarPr2.pr(i, z);
                    return;
                }
                return;
            }
            m mVarPr3 = com.byazt.ts.k.pr(false);
            if (mVarPr3 != null) {
                mVarPr3.pr(i, z);
            }
            m mVarPr4 = com.byazt.ts.k.pr(true);
            if (mVarPr4 != null) {
                mVarPr4.pr(i, z);
                return;
            }
            return;
        }
        m mVarHn = hn(i);
        if (mVarHn != null) {
            mVarHn.pr(i, z);
        }
        com.byazt.ts.k.pr(true).pr(2, i);
    }

    public boolean c(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return false;
        }
        return mVarHn.hw(i);
    }

    public void uc(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.hn(i);
    }

    public void fw(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.x(i);
    }

    public void hn() {
        m mVarPr = com.byazt.ts.k.pr(false);
        if (mVarPr != null) {
            mVarPr.pr();
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            mVarPr2.pr();
        }
    }

    public long zo(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return 0L;
        }
        return mVarHn.c(i);
    }

    public int aj(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return 0;
        }
        return mVarHn.uc(i);
    }

    public boolean vk(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return false;
        }
        return mVarHn.fw(i);
    }

    public DownloadInfo w(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return null;
        }
        return mVarHn.zo(i);
    }

    public int pr(String str, String str2) {
        return hn.pr(str, str2);
    }

    public DownloadInfo hw(String str, String str2) {
        int iPr = pr(str, str2);
        m mVarHn = hn(iPr);
        if (mVarHn == null) {
            return null;
        }
        return mVarHn.zo(iPr);
    }

    public List<DownloadInfo> pr(String str) {
        List<DownloadInfo> listPr = com.byazt.ts.k.pr(false).pr(str);
        List<DownloadInfo> listPr2 = com.byazt.ts.k.pr(true).pr(str);
        if (listPr == null && listPr2 == null) {
            return null;
        }
        if (listPr == null || listPr2 == null) {
            return listPr != null ? listPr : listPr2;
        }
        ArrayList arrayList = new ArrayList(listPr);
        arrayList.addAll(listPr2);
        return arrayList;
    }

    public b k(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return null;
        }
        return mVarHn.yb(i);
    }

    public y m(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return null;
        }
        return mVarHn.lb(i);
    }

    public void pr(int i, b bVar) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.pr(i, bVar);
    }

    public List<DownloadInfo> hw(String str) {
        List<DownloadInfo> listHw;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarPr = com.byazt.ts.k.pr(false);
        List<DownloadInfo> listHw2 = null;
        if (mVarPr == null) {
            listHw = null;
        } else {
            listHw = mVarPr.hw(str);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            listHw2 = mVarPr2.hw(str);
        }
        return pr(listHw, listHw2, sparseArray);
    }

    private List<DownloadInfo> pr(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
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

    public List<DownloadInfo> hn(String str) {
        List<DownloadInfo> listHn;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarPr = com.byazt.ts.k.pr(false);
        List<DownloadInfo> listHn2 = null;
        if (mVarPr == null) {
            listHn = null;
        } else {
            listHn = mVarPr.hn(str);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            listHn2 = mVarPr2.hn(str);
        }
        return pr(listHn, listHn2, sparseArray);
    }

    public void pr(List<String> list) {
        m mVarPr = com.byazt.ts.k.pr(false);
        if (mVarPr != null) {
            mVarPr.pr(list);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            mVarPr2.pr(list);
        }
    }

    public void hw(List<String> list) {
        m mVarPr = com.byazt.ts.k.pr(false);
        if (mVarPr != null) {
            mVarPr.hw(list);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            mVarPr2.hw(list);
        }
    }

    public void x(int i, boolean z) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.hw(i, z);
    }

    public void g(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.vk(i);
    }

    public void pr(int i, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.hw(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, ucVar, z);
    }

    public void hw(int i, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.pr(i, iDownloadListener.hashCode(), iDownloadListener, ucVar, z);
    }

    public void pr(int i, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z, boolean z2) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.pr(i, iDownloadListener.hashCode(), iDownloadListener, ucVar, z, z2);
    }

    public boolean pr(DownloadInfo downloadInfo) {
        m mVarHn;
        if (downloadInfo == null || (mVarHn = hn(downloadInfo.getId())) == null) {
            return false;
        }
        return mVarHn.pr(downloadInfo);
    }

    public boolean x() {
        return hn.ii();
    }

    public List<DownloadInfo> x(String str) {
        List<DownloadInfo> listX;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarPr = com.byazt.ts.k.pr(false);
        List<DownloadInfo> listX2 = null;
        if (mVarPr == null) {
            listX = null;
        } else {
            listX = mVarPr.x(str);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            listX2 = mVarPr2.x(str);
        }
        return pr(listX, listX2, sparseArray);
    }

    public List<DownloadInfo> c(String str) {
        List<DownloadInfo> listC;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarPr = com.byazt.ts.k.pr(false);
        List<DownloadInfo> listC2 = null;
        if (mVarPr == null) {
            listC = null;
        } else {
            listC = mVarPr.c(str);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            listC2 = mVarPr2.c(str);
        }
        return pr(listC, listC2, sparseArray);
    }

    public List<DownloadInfo> c() {
        List<DownloadInfo> listX;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarPr = com.byazt.ts.k.pr(false);
        List<DownloadInfo> listX2 = null;
        if (mVarPr == null) {
            listX = null;
        } else {
            listX = mVarPr.x();
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            listX2 = mVarPr2.x();
        }
        return pr(listX, listX2, sparseArray);
    }

    public void pr(final DownloadTask downloadTask) {
        final m mVarHw = hw(downloadTask);
        if (mVarHw == null) {
            if (downloadTask != null) {
                com.byazt.cha.pr.pr(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.hn.postDelayed(new Runnable() { // from class: com.byazt.lj.x.1
                @Override // java.lang.Runnable
                public void run() {
                    mVarHw.pr(downloadTask);
                }
            }, 500L);
        } else {
            mVarHw.pr(downloadTask);
        }
    }

    public boolean ho(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return false;
        }
        return mVarHn.k(i);
    }

    public void nt(int i) {
        m mVarPr = com.byazt.ts.k.pr(false);
        if (mVarPr != null) {
            mVarPr.w(i);
        }
        m mVarPr2 = com.byazt.ts.k.pr(true);
        if (mVarPr2 != null) {
            mVarPr2.w(i);
        }
    }

    public void yb(int i) {
        if (i == 0) {
            return;
        }
        hw(i, true);
        m mVarPr = com.byazt.ts.k.pr(true);
        if (mVarPr == null) {
            return;
        }
        mVarPr.startService();
    }

    public void pr(com.byazt.fn.w wVar) {
        hn.pr(wVar);
    }

    public void hw(com.byazt.fn.w wVar) {
        hn.hw(wVar);
    }

    public boolean uc() {
        m mVarPr = com.byazt.ts.k.pr(false);
        if (mVarPr == null) {
            return false;
        }
        return mVarPr.c();
    }

    public IDownloadFileUriProvider lb(int i) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return null;
        }
        return mVarHn.qa(i);
    }

    public void pr(int i, long j) {
        m mVarHn = hn(i);
        if (mVarHn == null) {
            return;
        }
        mVarHn.pr(i, j);
    }
}
