package com.byazt.eld;

import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import com.byazt.ts.lb;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 19})
public class ho {
    public static com.byazt.wc.hn hw;
    public static com.byazt.wc.x pr;

    public static com.byazt.wc.x pr() {
        return pr;
    }

    public static void pr(com.byazt.wc.x xVar) {
        pr = xVar;
    }

    public static com.byazt.wc.hn hw() {
        return hw;
    }

    public static void pr(com.byazt.wc.hn hnVar) {
        hw = hnVar;
    }

    public static boolean pr(final com.byazt.tia.hw hwVar, DownloadInfo downloadInfo, int i, final com.byazt.yey.zo zoVar, final boolean z, final com.byazt.wc.hn hnVar) {
        boolean zHw;
        int i2;
        if (hwVar == null) {
            com.byazt.vi.hn.pr().pr("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.byazt.vi.hn.pr().pr("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            zHw = com.byazt.uk.c.hn((com.byazt.tia.pr) hwVar);
        } else {
            zHw = com.byazt.uk.c.hw((com.byazt.tia.pr) hwVar);
        }
        JSONObject jSONObject = new JSONObject();
        if (!zHw) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(i2));
        } catch (Exception e) {
        }
        if (z) {
            com.byazt.mf.pr.pr().pr("cancel_pause_reserve_wifi_switch_status", jSONObject, hwVar);
        } else {
            com.byazt.mf.pr.pr().pr("pause_reserve_wifi_switch_status", jSONObject, hwVar);
        }
        if (!zHw || !pr(i) || com.byazt.tuy.uc.hw(k.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        pr(new com.byazt.wc.x() { // from class: com.byazt.eld.ho.1
            @Override // com.byazt.wc.x
            public void pr() {
                ho.pr((com.byazt.wc.x) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    lb.pr().pr(downloadInfo2);
                    if (z) {
                        com.byazt.mf.pr.pr().pr("cancel_pause_reserve_wifi_confirm", hwVar);
                    } else {
                        com.byazt.mf.pr.pr().hw("pause_reserve_wifi_confirm", hwVar);
                    }
                }
                zoVar.pr(hwVar);
            }

            @Override // com.byazt.wc.x
            public void hw() {
                ho.pr((com.byazt.wc.x) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.byazt.mf.pr.pr().pr("cancel_pause_reserve_wifi_cancel", hwVar);
                } else {
                    com.byazt.mf.pr.pr().hw("pause_reserve_wifi_cancel", hwVar);
                }
                zoVar.pr(hwVar);
            }
        });
        if (z && hnVar != null) {
            pr(new com.byazt.wc.hn() { // from class: com.byazt.eld.ho.2
                @Override // com.byazt.wc.hn
                public void delete() {
                    com.byazt.mf.pr.pr().pr("cancel_pause_reserve_wifi_delete", hwVar);
                    hnVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.pr(hwVar, "删除");
        } else {
            TTDelegateActivity.hw(hwVar);
        }
        return true;
    }

    public static boolean pr(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }
}
