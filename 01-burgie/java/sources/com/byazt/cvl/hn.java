package com.byazt.cvl;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.eld.k;
import com.byazt.lhc.BaseException;
import com.byazt.uk.m;
import com.byazt.uk.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.DownloadTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 20})
public class hn implements com.byazt.zkm.aj {
    public static String pr = hn.class.getSimpleName();
    public Handler hw = new Handler(Looper.getMainLooper());

    @Override // com.byazt.zkm.aj
    public void pr(DownloadInfo downloadInfo, BaseException baseException, int i) {
        final DownloadModel downloadModelPr;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.uk.uc.hn(downloadInfo, jSONObject);
            pr.pr(jSONObject, downloadInfo);
            w.pr("download_failed", jSONObject.toString());
        }
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
        if (hwVarPr == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    pr.pr(downloadInfo, hwVarPr);
                    return;
                }
                if (i == 2001) {
                    pr.pr().pr(downloadInfo, hwVarPr, 2001);
                    return;
                } else {
                    if (i == 11) {
                        pr.pr().pr(downloadInfo, hwVarPr, DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
                        if (!hwVarPr.hs()) {
                            pr(downloadInfo, hwVarPr);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.hw.post(new Runnable() { // from class: com.byazt.cvl.hn.1
                        @Override // java.lang.Runnable
                        public void run() {
                            k.hn().pr(5, k.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.byazt.tuy.uc.zo(baseException)) {
                    if (k.m() != null) {
                        k.m();
                        hwVarPr.hw();
                    }
                    com.byazt.mf.pr.pr().pr("download_failed_for_space", hwVarPr);
                    if (!hwVarPr.i()) {
                        com.byazt.mf.pr.pr().pr("download_can_restart", hwVarPr);
                        pr(downloadInfo);
                    }
                    if ((k.m() == null || !k.m().hn()) && (downloadModelPr = com.byazt.shh.uc.pr().pr(hwVarPr.hw())) != null && downloadModelPr.isShowToast()) {
                        final com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
                        if (prVarPr.pr("show_no_enough_space_toast", 0) == 1) {
                            this.hw.post(new Runnable() { // from class: com.byazt.cvl.hn.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    k.hn().pr(2, k.getContext(), downloadModelPr, prVarPr.pr("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), m.pr(baseException.getMessage(), k.aj().optInt("exception_msg_length", 500)));
            }
            com.byazt.mf.pr.pr().hw(downloadInfo, baseException2);
            zo.pr().pr(downloadInfo, baseException, "");
        } catch (Exception e) {
            k.a().pr(e, "onAppDownloadMonitorSend");
        }
    }

    private void pr(final DownloadInfo downloadInfo, final com.byazt.tia.hw hwVar) {
        final long jPr = m.pr(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, m.pr(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + jMin;
        if (jPr > -1 && totalBytes > -1) {
            double d2 = jPr;
            if (d2 < d && d - d2 > com.byazt.eld.x.hw()) {
                com.byazt.eld.x.pr(downloadInfo.getId());
            }
        }
        com.byazt.wel.pr.pr().pr(new com.byazt.wel.pr.InterfaceC0223pr() { // from class: com.byazt.cvl.hn.3
            @Override // com.byazt.wel.pr.InterfaceC0223pr
            public void hw() {
                if (!m.hw(hwVar)) {
                    long j = jPr;
                    if (j > -1 && totalBytes > -1 && j < d) {
                        com.byazt.mf.pr.pr().pr("clean_space_install", com.byazt.eld.x.pr("install_no_enough_space"), hwVar);
                        if (com.byazt.eld.x.pr(downloadInfo, ((long) d) - jPr)) {
                            com.byazt.wel.pr.pr().hw(this);
                            hwVar.fw(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.byazt.wel.pr.pr().hw(this);
            }

            @Override // com.byazt.wel.pr.InterfaceC0223pr
            public void hn() {
            }
        });
    }

    private void pr(DownloadInfo downloadInfo) {
        if (!com.byazt.uk.c.uc(downloadInfo.getId())) {
            return;
        }
        c.pr().hw(new com.byazt.ute.hw(downloadInfo));
    }
}
