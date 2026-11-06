package com.byazt.shh;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.km.AdDownloadModel;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 5})
public class uc {
    public final ConcurrentHashMap<Long, com.byazt.tia.hw> c;
    public final ConcurrentHashMap<Long, DownloadEventConfig> hn;
    public final ConcurrentHashMap<Long, DownloadModel> hw;
    public volatile boolean pr;
    public final ConcurrentHashMap<Long, DownloadController> x;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 129})
    private static class pr {
        public static uc pr = new uc();
    }

    public static uc pr() {
        return pr.pr;
    }

    private uc() {
        this.pr = false;
        this.hw = new ConcurrentHashMap<>();
        this.hn = new ConcurrentHashMap<>();
        this.x = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
    }

    public void hw() {
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.shh.uc.1
            @Override // java.lang.Runnable
            public void run() {
                if (!uc.this.pr) {
                    synchronized (uc.class) {
                        if (!uc.this.pr) {
                            uc.this.c.putAll(aj.pr().hw());
                            uc.this.pr = true;
                        }
                    }
                }
            }
        }, true);
    }

    public void pr(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.hw.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void pr(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.hn.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void pr(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.x.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void pr(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        this.c.put(Long.valueOf(hwVar.hw()), hwVar);
        aj.pr().pr(hwVar);
    }

    public DownloadModel pr(long j) {
        return this.hw.get(Long.valueOf(j));
    }

    public DownloadEventConfig hw(long j) {
        return this.hn.get(Long.valueOf(j));
    }

    public DownloadController hn(long j) {
        return this.x.get(Long.valueOf(j));
    }

    public com.byazt.tia.hw x(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.byazt.tia.hw> hn() {
        return this.c;
    }

    public com.byazt.tia.hw pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.tia.hw hwVar : this.c.values()) {
            if (hwVar != null && str.equals(hwVar.c())) {
                return hwVar;
            }
        }
        return null;
    }

    public com.byazt.tia.hw hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.tia.hw hwVar : this.c.values()) {
            if (hwVar != null && str.equals(hwVar.pr())) {
                return hwVar;
            }
        }
        return null;
    }

    public com.byazt.tia.hw pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.byazt.tia.hw hwVar : this.c.values()) {
            if (hwVar != null && hwVar.qa() == downloadInfo.getId()) {
                return hwVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jPr = m.pr(new JSONObject(downloadInfo.getExtra()), "extra");
                if (jPr != 0) {
                    for (com.byazt.tia.hw hwVar2 : this.c.values()) {
                        if (hwVar2 != null && hwVar2.hw() == jPr) {
                            return hwVar2;
                        }
                    }
                    com.byazt.vi.hn.pr().pr("getNativeModelByInfo");
                }
            } catch (Exception e) {
            }
        }
        for (com.byazt.tia.hw hwVar3 : this.c.values()) {
            if (hwVar3 != null && TextUtils.equals(hwVar3.pr(), downloadInfo.getUrl())) {
                return hwVar3;
            }
        }
        return null;
    }

    public com.byazt.tia.hw pr(int i) {
        for (com.byazt.tia.hw hwVar : this.c.values()) {
            if (hwVar != null && hwVar.qa() == i) {
                return hwVar;
            }
        }
        return null;
    }

    public c c(long j) {
        c cVar = new c();
        cVar.pr = j;
        cVar.hw = pr(j);
        cVar.hn = hw(j);
        if (cVar.hn == null) {
            cVar.hn = new com.byazt.bek.x();
        }
        cVar.x = hn(j);
        if (cVar.x == null) {
            cVar.x = new com.byazt.bek.hn();
        }
        return cVar;
    }

    public void uc(long j) {
        this.hw.remove(Long.valueOf(j));
        this.hn.remove(Long.valueOf(j));
        this.x.remove(Long.valueOf(j));
    }

    public Map<Long, com.byazt.tia.hw> pr(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return map;
        }
        for (com.byazt.tia.hw hwVar : this.c.values()) {
            if (hwVar != null && TextUtils.equals(hwVar.pr(), str)) {
                hwVar.hw(str2);
                map.put(Long.valueOf(hwVar.hw()), hwVar);
            }
        }
        return map;
    }

    public void hw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.hw.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public synchronized void pr(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.c.remove(Long.valueOf(jLongValue));
        }
        aj.pr().pr((List<String>) arrayList);
    }
}
