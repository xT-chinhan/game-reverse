package com.byazt.ht;

import com.byazt.qx.BaseException;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 101})
public class fs {

    @com.byazt.cp.n(n = {0, 1, 1169, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    private static class n {
        public static fs n = new fs();
    }

    public static fs n() {
        return n.n;
    }

    private fs() {
    }

    public void n(com.byazt.h.qg qgVar) {
        qg(qgVar, 5L);
    }

    public void qg(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        qg(qgVar, com.byazt.f.n.n(qgVar.um()).n("noti_continue_delay_secs", 5));
    }

    private void qg(final com.byazt.h.qg qgVar, long j) {
        final int iUm = qgVar.um();
        if (com.byazt.f.n.n(iUm).qg("notification_opt_2") != 1) {
            return;
        }
        n(iUm);
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.ht.fs.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(iUm);
                JSONObject jSONObject = new JSONObject();
                oa.n(jSONObject, "ttdownloader_type", (Object) 1);
                com.byazt.rz.w.s(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    fs.this.n(iUm, qgVar, jSONObject);
                } else {
                    oa.n(jSONObject, "error_code", (Object) 1001);
                }
                com.byazt.vj.n.n().qg("download_notification_try_show", jSONObject, qgVar);
            }
        }, j * 1000);
    }

    public void s(com.byazt.h.qg qgVar) {
        s(qgVar, 5L);
    }

    public void q(com.byazt.h.qg qgVar) {
        s(qgVar, com.byazt.f.n.n(qgVar.um()).n("noti_install_delay_secs", 5));
    }

    private void s(final com.byazt.h.qg qgVar, long j) {
        final int iUm = qgVar.um();
        if (com.byazt.f.n.n(iUm).qg("notification_opt_2") != 1) {
            return;
        }
        n(iUm);
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.ht.fs.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(iUm);
                JSONObject jSONObject = new JSONObject();
                oa.n(jSONObject, "ttdownloader_type", (Object) 2);
                com.byazt.rz.w.s(downloadInfo, jSONObject);
                if (!oa.qg(qgVar)) {
                    fs.this.n(iUm, qgVar, jSONObject);
                } else {
                    oa.n(jSONObject, "error_code", (Object) 1002);
                }
                com.byazt.vj.n.n().qg("download_notification_try_show", jSONObject, qgVar);
            }
        }, j * 1000);
    }

    public void l(com.byazt.h.qg qgVar) {
        n(qgVar, 5L);
    }

    public void w(com.byazt.h.qg qgVar) {
        n(qgVar, com.byazt.f.n.n(qgVar.um()).n("noti_open_delay_secs", 5));
    }

    public void n(final com.byazt.h.qg qgVar, long j) {
        final int iUm = qgVar.um();
        if (com.byazt.f.n.n(iUm).qg("notification_opt_2") != 1) {
            return;
        }
        n(iUm);
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.ht.fs.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(iUm);
                JSONObject jSONObject = new JSONObject();
                oa.n(jSONObject, "ttdownloader_type", (Object) 3);
                com.byazt.rz.w.s(downloadInfo, jSONObject);
                if (!oa.s(qgVar.l())) {
                    fs.this.n(iUm, qgVar, jSONObject);
                } else {
                    oa.n(jSONObject, "error_code", (Object) 1003);
                }
                com.byazt.vj.n.n().qg("download_notification_try_show", jSONObject, qgVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, com.byazt.h.qg qgVar, JSONObject jSONObject) {
        if (!com.byazt.j.q.n()) {
            oa.n(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            oa.n(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.byazt.av.qg.n().l(i) != null) {
            com.byazt.av.qg.n().w(i);
        }
        com.byazt.j.n nVar = new com.byazt.j.n(d.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        nVar.n(downloadInfo.getCurBytes());
        nVar.qg(downloadInfo.getTotalBytes());
        nVar.n(downloadInfo.getStatus(), null, false, false);
        com.byazt.av.qg.n().n(nVar);
        nVar.n((BaseException) null, false);
        com.byazt.vj.n.n().qg("download_notification_show", jSONObject, qgVar);
    }

    public void n(int i) {
        DownloadInfo downloadInfo;
        if (com.byazt.j.s.n().n(i) != null || (downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.byazt.j.s.n().n(i, downloadInfo.getIconUrl());
    }
}
