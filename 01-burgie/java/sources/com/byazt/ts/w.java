package com.byazt.ts;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 109})
public class w implements com.byazt.lj.vk {
    public final SparseArray<DownloadInfo> pr = new SparseArray<>();
    public final SparseArray<List<com.byazt.auw.hw>> hw = new SparseArray<>();
    public final SparseArray<Map<Long, com.byazt.stx.aj>> hn = new SparseArray<>();

    public SparseArray<DownloadInfo> pr() {
        return this.pr;
    }

    public SparseArray<List<com.byazt.auw.hw>> uc() {
        return this.hw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo fw(int i) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setStatus(2);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public synchronized DownloadInfo hw(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.pr.get(i);
        } catch (Exception e) {
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.byazt.lj.vk
    public synchronized List<DownloadInfo> pr(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.pr.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo downloadInfoValueAt = this.pr.valueAt(i);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    @Override // com.byazt.lj.vk
    public synchronized List<DownloadInfo> hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.pr.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.pr.size(); i++) {
            DownloadInfo downloadInfo = this.pr.get(this.pr.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.lj.vk
    public synchronized List<DownloadInfo> hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.pr.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.pr.size(); i++) {
            DownloadInfo downloadInfo = this.pr.get(this.pr.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.lj.vk
    public synchronized List<DownloadInfo> x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.pr.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.pr.size(); i++) {
            DownloadInfo downloadInfo = this.pr.get(this.pr.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.lj.vk
    public synchronized List<DownloadInfo> hw() {
        if (this.pr.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.pr.size());
        for (int i = 0; i < this.pr.size(); i++) {
            DownloadInfo downloadInfoValueAt = this.pr.valueAt(i);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.lj.vk
    public synchronized List<com.byazt.auw.hw> hn(int i) {
        return this.hw.get(i);
    }

    @Override // com.byazt.lj.vk
    public synchronized void x(int i) {
        this.hw.remove(i);
    }

    @Override // com.byazt.lj.vk
    public void pr(com.byazt.auw.hw hwVar) {
        int iW = hwVar.w();
        List<com.byazt.auw.hw> arrayList = this.hw.get(iW);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.hw.put(iW, arrayList);
        }
        arrayList.add(hwVar);
    }

    @Override // com.byazt.lj.vk
    public void hw(com.byazt.auw.hw hwVar) {
    }

    @Override // com.byazt.lj.vk
    public synchronized void pr(int i, int i2, long j) {
        List<com.byazt.auw.hw> listHn = hn(i);
        if (listHn == null) {
            return;
        }
        for (com.byazt.auw.hw hwVar : listHn) {
            if (hwVar != null && hwVar.qa() == i2) {
                hwVar.hw(j);
                return;
            }
        }
    }

    @Override // com.byazt.lj.vk
    public synchronized void pr(int i, int i2, int i3, long j) {
        List<com.byazt.auw.hw> listHn = hn(i);
        if (listHn == null) {
            return;
        }
        for (com.byazt.auw.hw hwVar : listHn) {
            if (hwVar != null && hwVar.qa() == i3 && !hwVar.uc()) {
                if (hwVar.fw() == null) {
                    break;
                }
                for (com.byazt.auw.hw hwVar2 : hwVar.fw()) {
                    if (hwVar2 != null && hwVar2.qa() == i2) {
                        hwVar2.hw(j);
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, int i3, int i4) {
    }

    @Override // com.byazt.lj.vk
    public synchronized DownloadInfo pr(int i, int i2) {
        DownloadInfo downloadInfoHw;
        downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setChunkCount(i2);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public synchronized boolean pr(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.pr.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.pr.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.byazt.lj.vk
    public synchronized boolean c(int i) {
        this.pr.remove(i);
        return true;
    }

    @Override // com.byazt.lj.vk
    public boolean uc(int i) {
        c(i);
        x(i);
        m(i);
        return true;
    }

    @Override // com.byazt.lj.vk
    public synchronized void hn() {
        this.pr.clear();
        this.hw.clear();
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setTotalBytes(j);
            downloadInfoHw.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoHw.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoHw.setName(str2);
            }
            downloadInfoHw.setStatus(3);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, long j) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setCurBytes(j, false);
            if (downloadInfoHw.getStatus() != -3 && downloadInfoHw.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoHw.getStatus()) && downloadInfoHw.getStatus() != -4) {
                downloadInfoHw.setStatus(4);
            }
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hw(int i, long j) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setCurBytes(j, false);
            downloadInfoHw.setStatus(-1);
            downloadInfoHw.setFirstDownload(false);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo zo(int i) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setStatus(5);
            downloadInfoHw.setFirstDownload(false);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hn(int i, long j) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setCurBytes(j, false);
            downloadInfoHw.setStatus(-3);
            downloadInfoHw.setFirstDownload(false);
            downloadInfoHw.setFirstSuccess(false);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo x(int i, long j) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setCurBytes(j, false);
            downloadInfoHw.setStatus(-2);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo aj(int i) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setStatus(1);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo vk(int i) {
        DownloadInfo downloadInfoHw = hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setStatus(-7);
        }
        return downloadInfoHw;
    }

    @Override // com.byazt.lj.vk
    public boolean x() {
        return false;
    }

    @Override // com.byazt.lj.vk
    public boolean c() {
        return false;
    }

    @Override // com.byazt.lj.vk
    public void hw(DownloadInfo downloadInfo) {
        pr(downloadInfo);
    }

    @Override // com.byazt.lj.vk
    public synchronized void pr(int i, List<com.byazt.auw.hw> list) {
        if (list == null) {
            return;
        }
        x(i);
        for (com.byazt.auw.hw hwVar : list) {
            if (hwVar != null) {
                pr(hwVar);
                if (hwVar.uc()) {
                    Iterator<com.byazt.auw.hw> it = hwVar.fw().iterator();
                    while (it.hasNext()) {
                        pr(it.next());
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.byazt.lj.vk
    public void hw(int i, List<com.byazt.auw.hw> list) {
    }

    @Override // com.byazt.lj.vk
    public synchronized List<com.byazt.stx.aj> g(int i) {
        Map<Long, com.byazt.stx.aj> map = this.hn.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.byazt.lj.vk
    public synchronized Map<Long, com.byazt.stx.aj> k(int i) {
        return this.hn.get(i);
    }

    @Override // com.byazt.lj.vk
    public synchronized boolean pr(int i, Map<Long, com.byazt.stx.aj> map) {
        this.hn.put(i, map);
        return false;
    }

    @Override // com.byazt.lj.vk
    public synchronized void m(int i) {
        this.hn.remove(i);
    }
}
