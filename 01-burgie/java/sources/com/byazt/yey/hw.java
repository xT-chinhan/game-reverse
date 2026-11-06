package com.byazt.yey;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 13})
public class hw implements fw {
    public static com.byazt.wc.hn hw;
    public static com.byazt.wc.x pr;

    public static com.byazt.wc.x pr() {
        return pr;
    }

    public static com.byazt.wc.hn hw() {
        return hw;
    }

    public static void pr(com.byazt.wc.hn hnVar) {
        hw = hnVar;
    }

    @Override // com.byazt.yey.fw
    public boolean pr(final com.byazt.tia.hw hwVar, int i, final zo zoVar, final com.byazt.wc.hn hnVar) {
        DownloadInfo downloadInfoHw;
        if (hwVar == null || !pr(hwVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(hwVar.gu())) {
            downloadInfoHw = com.byazt.cvl.vk.pr(com.byazt.eld.k.getContext()).pr(hwVar.gu(), null, true);
        } else {
            downloadInfoHw = com.byazt.cvl.vk.pr(com.byazt.eld.k.getContext()).hw(hwVar.pr());
        }
        if (downloadInfoHw == null) {
            return false;
        }
        long jPr = com.byazt.eld.vk.pr(downloadInfoHw.getId(), downloadInfoHw.getCurBytes(), downloadInfoHw.getTotalBytes());
        long totalBytes = downloadInfoHw.getTotalBytes();
        if (jPr >= 0 && totalBytes > 0) {
            if (totalBytes <= pr(hwVar.qa())) {
                final int i2 = (int) (jPr / 1048576);
                pr = new com.byazt.wc.x() { // from class: com.byazt.yey.hw.1
                    @Override // com.byazt.wc.x
                    public void pr() {
                        com.byazt.wc.x unused = hw.pr = null;
                        hw.this.pr(i2, i2, hwVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.byazt.wc.x
                    public void hw() {
                        com.byazt.wc.x unused = hw.pr = null;
                        hw.this.pr(i2, i2, hwVar, "apk_size_cancel", TrackAction.CANCEL);
                        zoVar.pr(hwVar);
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", m.pr(totalBytes - jPr));
                if (hnVar != null) {
                    pr(new com.byazt.wc.hn() { // from class: com.byazt.yey.hw.2
                        @Override // com.byazt.wc.hn
                        public void delete() {
                            com.byazt.wc.x unused = hw.pr = null;
                            hw.this.pr(i2, i2, hwVar, "apk_size_cancel", "delete");
                            hnVar.delete();
                        }
                    });
                }
                TTDelegateActivity.pr(hwVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int pr(int i) {
        return com.byazt.ew.pr.pr(i).pr("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean pr(com.byazt.tia.pr prVar) {
        return com.byazt.uk.c.pr(prVar).pr("cancel_pause_optimise_apk_retain_switch", 0) == 1 && prVar.yb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2, com.byazt.tia.hw hwVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt(Constants.DOWNLOAD_TOTAL_BYTES_FIELD, Integer.valueOf(i2));
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("pause_cancel_optimise", jSONObject, hwVar);
    }
}
