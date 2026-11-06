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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 37})
public class pr implements aj {
    public static com.byazt.wc.x pr;

    public static com.byazt.wc.x pr() {
        return pr;
    }

    @Override // com.byazt.yey.aj
    public boolean pr(final com.byazt.tia.hw hwVar, int i, final zo zoVar) {
        DownloadInfo downloadInfoHw;
        if (hwVar == null || hwVar.vj() || !pr(hwVar)) {
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
        if (jPr <= 0 || totalBytes <= 0 || totalBytes > pr(hwVar.qa())) {
            return false;
        }
        pr = new com.byazt.wc.x() { // from class: com.byazt.yey.pr.1
            @Override // com.byazt.wc.x
            public void pr() {
                com.byazt.wc.x unused = pr.pr = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", Constants.APK_SIZE_FIELD);
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e) {
                }
                com.byazt.mf.pr.pr().pr("pause_optimise", jSONObject, hwVar);
            }

            @Override // com.byazt.wc.x
            public void hw() {
                com.byazt.wc.x unused = pr.pr = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", Constants.APK_SIZE_FIELD);
                    jSONObject.putOpt("pause_optimise_action", TrackAction.CANCEL);
                } catch (JSONException e) {
                }
                com.byazt.mf.pr.pr().pr("pause_optimise", jSONObject, hwVar);
                zoVar.pr(hwVar);
            }
        };
        TTDelegateActivity.pr(hwVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", m.pr(totalBytes - jPr)), "继续", "暂停");
        hwVar.g(true);
        return true;
    }

    private int pr(int i) {
        return com.byazt.ew.pr.pr(i).pr("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean pr(com.byazt.tia.pr prVar) {
        return com.byazt.uk.c.pr(prVar).pr("pause_optimise_apk_size_switch", 0) == 1 && prVar.yb();
    }
}
