package com.byazt.ug;

import com.byazt.hj.DownloadModel;
import com.byazt.wm.DownloadInfo;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 8})
public class s {
    public static String n = "s";
    public static volatile s qg;
    public ConcurrentHashMap<Long, Runnable> s;

    public s() {
        this.s = null;
        this.s = new ConcurrentHashMap<>();
    }

    public static s n() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    public void n(l lVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                n(id, false, 2);
                lVar.qg(false);
                return;
            } else {
                n(id, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                n(id, false, 1);
                lVar.s(false);
                return;
            } else {
                n(id, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable runnableRemove = this.s.remove(Long.valueOf(id));
        if (z) {
            com.byazt.vj.n.n().n(id, 1);
            n(id, true, 1);
        } else {
            if (runnableRemove != null) {
                com.byazt.s.fs.n().qg().post(runnableRemove);
            }
            n(id, false, 1);
        }
    }

    private void n(long j, boolean z, int i) {
        com.byazt.vj.n.n().n(j, z, i);
        if (z) {
            d.py().n(null, null, null, null, null, 3);
        }
    }

    public void n(final l lVar, final int i, final DownloadModel downloadModel) {
        com.byazt.t.l.n().n(new com.byazt.t.q() { // from class: com.byazt.ug.s.1
            @Override // com.byazt.t.q
            public void n(boolean z) {
                s.this.n(lVar, z, i, downloadModel);
            }
        }, qg());
    }

    public long qg() {
        return d.rv().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean n(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
