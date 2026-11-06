package com.byazt.vl;

import android.text.TextUtils;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.rz.oa;
import com.byazt.wm.DownloadInfo;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 13})
public class w {
    public final ConcurrentHashMap<Long, com.byazt.h.qg> l;
    public volatile boolean n;
    public final ConcurrentHashMap<Long, DownloadController> q;
    public final ConcurrentHashMap<Long, DownloadModel> qg;
    public final ConcurrentHashMap<Long, DownloadEventConfig> s;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 108})
    private static class n {
        public static w n = new w();
    }

    public static w n() {
        return n.n;
    }

    private w() {
        this.n = false;
        this.qg = new ConcurrentHashMap<>();
        this.s = new ConcurrentHashMap<>();
        this.q = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
    }

    public void qg() {
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.vl.w.1
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.n) {
                    return;
                }
                synchronized (w.class) {
                    if (!w.this.n) {
                        w.this.l.putAll(rv.n().qg());
                        w.this.n = true;
                    }
                }
            }
        }, true);
    }

    public void n(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.qg.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void n(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.s.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void n(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.q.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void n(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        this.l.put(Long.valueOf(qgVar.qg()), qgVar);
        rv.n().n(qgVar);
    }

    public DownloadModel n(long j) {
        return this.qg.get(Long.valueOf(j));
    }

    public DownloadEventConfig qg(long j) {
        return this.s.get(Long.valueOf(j));
    }

    public DownloadController s(long j) {
        return this.q.get(Long.valueOf(j));
    }

    public com.byazt.h.qg q(long j) {
        return this.l.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.byazt.h.qg> s() {
        return this.l;
    }

    public com.byazt.h.qg n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.h.qg qgVar : this.l.values()) {
            if (qgVar != null && str.equals(qgVar.l())) {
                return qgVar;
            }
        }
        return null;
    }

    public com.byazt.h.qg qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.h.qg qgVar : this.l.values()) {
            if (qgVar != null && str.equals(qgVar.n())) {
                return qgVar;
            }
        }
        return null;
    }

    public com.byazt.h.qg n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.byazt.h.qg qgVar : this.l.values()) {
            if (qgVar != null && qgVar.um() == downloadInfo.getId()) {
                return qgVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jN = oa.n(new JSONObject(downloadInfo.getExtra()), "extra");
                if (jN != 0) {
                    for (com.byazt.h.qg qgVar2 : this.l.values()) {
                        if (qgVar2 != null && qgVar2.qg() == jN) {
                            return qgVar2;
                        }
                    }
                    com.byazt.ch.s.n().n("getNativeModelByInfo");
                }
            } catch (Exception unused) {
            }
        }
        for (com.byazt.h.qg qgVar3 : this.l.values()) {
            if (qgVar3 != null && TextUtils.equals(qgVar3.n(), downloadInfo.getUrl())) {
                return qgVar3;
            }
        }
        return null;
    }

    public com.byazt.h.qg n(int i) {
        for (com.byazt.h.qg qgVar : this.l.values()) {
            if (qgVar != null && qgVar.um() == i) {
                return qgVar;
            }
        }
        return null;
    }

    public l l(long j) {
        l lVar = new l();
        lVar.n = j;
        lVar.qg = n(j);
        lVar.s = qg(j);
        if (lVar.s == null) {
            lVar.s = new com.byazt.hj.q();
        }
        lVar.q = s(j);
        if (lVar.q == null) {
            lVar.q = new com.byazt.hj.s();
        }
        return lVar;
    }

    public void w(long j) {
        this.qg.remove(Long.valueOf(j));
        this.s.remove(Long.valueOf(j));
        this.q.remove(Long.valueOf(j));
    }

    public Map<Long, com.byazt.h.qg> n(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.byazt.h.qg qgVar : this.l.values()) {
                if (qgVar != null && TextUtils.equals(qgVar.n(), str)) {
                    qgVar.qg(str2);
                    map.put(Long.valueOf(qgVar.qg()), qgVar);
                }
            }
        }
        return map;
    }

    public void qg(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.qg.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public synchronized void n(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.l.remove(Long.valueOf(jLongValue));
        }
        rv.n().n((List<String>) arrayList);
    }
}
