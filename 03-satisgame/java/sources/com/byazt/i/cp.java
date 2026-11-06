package com.byazt.i;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.sk.DownloadStatus;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 29})
public class cp implements com.byazt.xv.tj {
    public final SparseArray<DownloadInfo> n = new SparseArray<>();
    public final SparseArray<List<com.byazt.wm.qg>> qg = new SparseArray<>();
    public final SparseArray<Map<Long, com.byazt.kl.rv>> s = new SparseArray<>();

    @Override // com.byazt.xv.tj
    public boolean l() {
        return false;
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, int i3, int i4) {
    }

    @Override // com.byazt.xv.tj
    public boolean q() {
        return false;
    }

    @Override // com.byazt.xv.tj
    public void qg(int i, List<com.byazt.wm.qg> list) {
    }

    @Override // com.byazt.xv.tj
    public void qg(com.byazt.wm.qg qgVar) {
    }

    public SparseArray<DownloadInfo> n() {
        return this.n;
    }

    public SparseArray<List<com.byazt.wm.qg>> w() {
        return this.qg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setStatus(2);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public synchronized DownloadInfo qg(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.n.get(i);
        } catch (Exception unused) {
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.byazt.xv.tj
    public synchronized List<DownloadInfo> n(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.n.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo downloadInfoValueAt = this.n.valueAt(i);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // com.byazt.xv.tj
    public synchronized List<DownloadInfo> qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.n.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.size(); i++) {
            DownloadInfo downloadInfo = this.n.get(this.n.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.xv.tj
    public synchronized List<DownloadInfo> s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.n.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.size(); i++) {
            DownloadInfo downloadInfo = this.n.get(this.n.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.xv.tj
    public synchronized List<DownloadInfo> q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.n.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.size(); i++) {
            DownloadInfo downloadInfo = this.n.get(this.n.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.xv.tj
    public synchronized List<DownloadInfo> qg() {
        if (this.n.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.n.size());
        for (int i = 0; i < this.n.size(); i++) {
            DownloadInfo downloadInfoValueAt = this.n.valueAt(i);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.xv.tj
    public synchronized List<com.byazt.wm.qg> s(int i) {
        return this.qg.get(i);
    }

    @Override // com.byazt.xv.tj
    public synchronized void q(int i) {
        this.qg.remove(i);
    }

    @Override // com.byazt.xv.tj
    public void n(com.byazt.wm.qg qgVar) {
        int iCp = qgVar.cp();
        List<com.byazt.wm.qg> arrayList = this.qg.get(iCp);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.qg.put(iCp, arrayList);
        }
        arrayList.add(qgVar);
    }

    @Override // com.byazt.xv.tj
    public synchronized void n(int i, int i2, long j) {
        List<com.byazt.wm.qg> listS = s(i);
        if (listS == null) {
            return;
        }
        for (com.byazt.wm.qg qgVar : listS) {
            if (qgVar != null && qgVar.um() == i2) {
                qgVar.qg(j);
                return;
            }
        }
    }

    @Override // com.byazt.xv.tj
    public synchronized void n(int i, int i2, int i3, long j) {
        List<com.byazt.wm.qg> listS = s(i);
        if (listS == null) {
            return;
        }
        for (com.byazt.wm.qg qgVar : listS) {
            if (qgVar != null && qgVar.um() == i3 && !qgVar.w()) {
                if (qgVar.x() == null) {
                    break;
                }
                for (com.byazt.wm.qg qgVar2 : qgVar.x()) {
                    if (qgVar2 != null && qgVar2.um() == i2) {
                        qgVar2.qg(j);
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // com.byazt.xv.tj
    public synchronized DownloadInfo n(int i, int i2) {
        DownloadInfo downloadInfoQg;
        downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setChunkCount(i2);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public synchronized boolean n(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.n.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.n.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.byazt.xv.tj
    public synchronized boolean l(int i) {
        this.n.remove(i);
        return true;
    }

    @Override // com.byazt.xv.tj
    public boolean w(int i) {
        l(i);
        q(i);
        oa(i);
        return true;
    }

    @Override // com.byazt.xv.tj
    public synchronized void s() {
        this.n.clear();
        this.qg.clear();
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setTotalBytes(j);
            downloadInfoQg.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoQg.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoQg.setName(str2);
            }
            downloadInfoQg.setStatus(3);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, long j) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setCurBytes(j, false);
            if (downloadInfoQg.getStatus() != -3 && downloadInfoQg.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoQg.getStatus()) && downloadInfoQg.getStatus() != -4) {
                downloadInfoQg.setStatus(4);
            }
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo qg(int i, long j) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setCurBytes(j, false);
            downloadInfoQg.setStatus(-1);
            downloadInfoQg.setFirstDownload(false);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo fs(int i) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setStatus(5);
            downloadInfoQg.setFirstDownload(false);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo s(int i, long j) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setCurBytes(j, false);
            downloadInfoQg.setStatus(-3);
            downloadInfoQg.setFirstDownload(false);
            downloadInfoQg.setFirstSuccess(false);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo q(int i, long j) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setCurBytes(j, false);
            downloadInfoQg.setStatus(-2);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo rv(int i) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setStatus(1);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo tj(int i) {
        DownloadInfo downloadInfoQg = qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setStatus(-7);
        }
        return downloadInfoQg;
    }

    @Override // com.byazt.xv.tj
    public void qg(DownloadInfo downloadInfo) {
        n(downloadInfo);
    }

    @Override // com.byazt.xv.tj
    public synchronized void n(int i, List<com.byazt.wm.qg> list) {
        if (list == null) {
            return;
        }
        q(i);
        for (com.byazt.wm.qg qgVar : list) {
            if (qgVar != null) {
                n(qgVar);
                if (qgVar.w()) {
                    Iterator<com.byazt.wm.qg> it = qgVar.x().iterator();
                    while (it.hasNext()) {
                        n(it.next());
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.byazt.xv.tj
    public synchronized List<com.byazt.kl.rv> sz(int i) {
        Map<Long, com.byazt.kl.rv> map = this.s.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.byazt.xv.tj
    public synchronized Map<Long, com.byazt.kl.rv> d(int i) {
        return this.s.get(i);
    }

    @Override // com.byazt.xv.tj
    public synchronized boolean n(int i, Map<Long, com.byazt.kl.rv> map) {
        this.s.put(i, map);
        return false;
    }

    @Override // com.byazt.xv.tj
    public synchronized void oa(int i) {
        this.s.remove(i);
    }
}
