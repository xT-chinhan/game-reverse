package com.byazt.ug;

import com.byazt.i.cd;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 210})
public class k {
    public static com.byazt.bn.q n;
    public static com.byazt.bn.s qg;

    public static boolean n(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.byazt.bn.q n() {
        return n;
    }

    public static void n(com.byazt.bn.q qVar) {
        n = qVar;
    }

    public static com.byazt.bn.s qg() {
        return qg;
    }

    public static void n(com.byazt.bn.s sVar) {
        qg = sVar;
    }

    public static boolean n(final com.byazt.h.qg qgVar, DownloadInfo downloadInfo, int i, final com.byazt.mx.fs fsVar, final boolean z, final com.byazt.bn.s sVar) {
        boolean zQg;
        if (qgVar == null) {
            com.byazt.ch.s.n().n("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.byazt.ch.s.n().n("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            zQg = com.byazt.rz.l.s((com.byazt.h.n) qgVar);
        } else {
            zQg = com.byazt.rz.l.qg((com.byazt.h.n) qgVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zQg ? 1 : 0));
        } catch (Exception unused) {
        }
        if (z) {
            com.byazt.vj.n.n().n("cancel_pause_reserve_wifi_switch_status", jSONObject, qgVar);
        } else {
            com.byazt.vj.n.n().n("pause_reserve_wifi_switch_status", jSONObject, qgVar);
        }
        if (!zQg || !n(i) || com.byazt.ta.w.qg(d.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        n(new com.byazt.bn.q() { // from class: com.byazt.ug.k.1
            @Override // com.byazt.bn.q
            public void n() {
                k.n((com.byazt.bn.q) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(d.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    cd.n().n(downloadInfo2);
                    if (z) {
                        com.byazt.vj.n.n().n("cancel_pause_reserve_wifi_confirm", qgVar);
                    } else {
                        com.byazt.vj.n.n().qg("pause_reserve_wifi_confirm", qgVar);
                    }
                }
                fsVar.n(qgVar);
            }

            @Override // com.byazt.bn.q
            public void qg() {
                k.n((com.byazt.bn.q) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(d.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.byazt.vj.n.n().n("cancel_pause_reserve_wifi_cancel", qgVar);
                } else {
                    com.byazt.vj.n.n().qg("pause_reserve_wifi_cancel", qgVar);
                }
                fsVar.n(qgVar);
            }
        });
        if (z && sVar != null) {
            n(new com.byazt.bn.s() { // from class: com.byazt.ug.k.2
                @Override // com.byazt.bn.s
                public void delete() {
                    com.byazt.vj.n.n().n("cancel_pause_reserve_wifi_delete", qgVar);
                    sVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.n(qgVar, "删除");
        } else {
            TTDelegateActivity.qg(qgVar);
        }
        return true;
    }
}
