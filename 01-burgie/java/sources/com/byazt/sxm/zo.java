package com.byazt.sxm;

import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {

    @com.byazt.vzx.pr(pr = {0, 1, 448, 673})
    private static class pr {
        public static zo pr = new zo();
    }

    public static zo pr() {
        return pr.pr;
    }

    private zo() {
    }

    public void pr(com.byazt.tia.hw hwVar) {
        hw(hwVar, 5L);
    }

    public void hw(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        hw(hwVar, com.byazt.ew.pr.pr(hwVar.qa()).pr("noti_continue_delay_secs", 5));
    }

    private void hw(final com.byazt.tia.hw hwVar, long j) {
        final int iQa = hwVar.qa();
        if (com.byazt.ew.pr.pr(iQa).hw("notification_opt_2") != 1) {
            return;
        }
        pr(iQa);
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.sxm.zo.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(iQa);
                JSONObject jSONObject = new JSONObject();
                m.pr(jSONObject, "ttdownloader_type", (Object) 1);
                com.byazt.uk.uc.hn(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    zo.this.pr(iQa, hwVar, jSONObject);
                } else {
                    m.pr(jSONObject, Constants.ERROR_CODE_FIELD, (Object) 1001);
                }
                com.byazt.mf.pr.pr().hw("download_notification_try_show", jSONObject, hwVar);
            }
        }, j * 1000);
    }

    public void hn(com.byazt.tia.hw hwVar) {
        hn(hwVar, 5L);
    }

    public void x(com.byazt.tia.hw hwVar) {
        hn(hwVar, com.byazt.ew.pr.pr(hwVar.qa()).pr("noti_install_delay_secs", 5));
    }

    private void hn(final com.byazt.tia.hw hwVar, long j) {
        final int iQa = hwVar.qa();
        if (com.byazt.ew.pr.pr(iQa).hw("notification_opt_2") != 1) {
            return;
        }
        pr(iQa);
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.sxm.zo.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(iQa);
                JSONObject jSONObject = new JSONObject();
                m.pr(jSONObject, "ttdownloader_type", (Object) 2);
                com.byazt.uk.uc.hn(downloadInfo, jSONObject);
                if (!m.hw(hwVar)) {
                    zo.this.pr(iQa, hwVar, jSONObject);
                } else {
                    m.pr(jSONObject, Constants.ERROR_CODE_FIELD, (Object) 1002);
                }
                com.byazt.mf.pr.pr().hw("download_notification_try_show", jSONObject, hwVar);
            }
        }, j * 1000);
    }

    public void c(com.byazt.tia.hw hwVar) {
        pr(hwVar, 5L);
    }

    public void uc(com.byazt.tia.hw hwVar) {
        pr(hwVar, com.byazt.ew.pr.pr(hwVar.qa()).pr("noti_open_delay_secs", 5));
    }

    public void pr(final com.byazt.tia.hw hwVar, long j) {
        final int iQa = hwVar.qa();
        if (com.byazt.ew.pr.pr(iQa).hw("notification_opt_2") != 1) {
            return;
        }
        pr(iQa);
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.sxm.zo.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(iQa);
                JSONObject jSONObject = new JSONObject();
                m.pr(jSONObject, "ttdownloader_type", (Object) 3);
                com.byazt.uk.uc.hn(downloadInfo, jSONObject);
                if (!m.hn(hwVar.c())) {
                    zo.this.pr(iQa, hwVar, jSONObject);
                } else {
                    m.pr(jSONObject, Constants.ERROR_CODE_FIELD, (Object) 1003);
                }
                com.byazt.mf.pr.pr().hw("download_notification_try_show", jSONObject, hwVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, com.byazt.tia.hw hwVar, JSONObject jSONObject) {
        if (!com.byazt.owr.x.pr()) {
            m.pr(jSONObject, Constants.ERROR_CODE_FIELD, (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            m.pr(jSONObject, Constants.ERROR_CODE_FIELD, (Object) 1005);
            return;
        }
        if (com.byazt.lxs.hw.pr().c(i) != null) {
            com.byazt.lxs.hw.pr().uc(i);
        }
        com.byazt.owr.pr prVar = new com.byazt.owr.pr(k.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        prVar.pr(downloadInfo.getCurBytes());
        prVar.hw(downloadInfo.getTotalBytes());
        prVar.pr(downloadInfo.getStatus(), null, false, false);
        com.byazt.lxs.hw.pr().pr(prVar);
        prVar.pr((BaseException) null, false);
        com.byazt.mf.pr.pr().hw("download_notification_show", jSONObject, hwVar);
    }

    public void pr(int i) {
        DownloadInfo downloadInfo;
        if (com.byazt.owr.hn.pr().pr(i) == null && (downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i)) != null) {
            com.byazt.owr.hn.pr().pr(i, downloadInfo.getIconUrl());
        }
    }
}
