package com.byazt.ute;

import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.lj.Downloader;
import com.byazt.shh.aj;
import com.byazt.shh.uc;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, 13})
public class hw implements Runnable {
    public DownloadInfo pr;

    public hw(DownloadInfo downloadInfo) {
        this.pr = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.byazt.tia.hw hwVarPr;
        if (this.pr == null || (hwVarPr = uc.pr().pr(this.pr)) == null) {
            return;
        }
        com.byazt.mf.pr.pr().pr("cleanspace_task", hwVarPr);
        long jLongValue = Double.valueOf((com.byazt.uk.c.pr(this.pr.getId()) + 1.0d) * this.pr.getTotalBytes()).longValue() - this.pr.getCurBytes();
        long jHw = m.hw(0L);
        if (k.m() != null) {
            k.m();
        }
        hn.pr();
        hn.hw();
        if (com.byazt.uk.c.fw(hwVarPr.qa())) {
            hn.pr(k.getContext());
        }
        long jHw2 = m.hw(0L);
        if (jHw2 >= jLongValue) {
            hwVarPr.k("1");
            aj.pr().pr(hwVarPr);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jHw2 - jHw));
            } catch (JSONException e) {
            }
            com.byazt.mf.pr.pr().pr("cleanspace_download_after_quite_clean", jSONObject, hwVarPr);
            Downloader.getInstance(k.getContext()).restart(this.pr.getId());
            return;
        }
        if (k.m() != null) {
            hwVarPr.x(false);
            x.pr().pr(hwVarPr.pr(), new c() { // from class: com.byazt.ute.hw.1
            });
            if (k.m().pr(this.pr.getId(), this.pr.getUrl(), true, jLongValue)) {
                hwVarPr.c(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
        }
        com.byazt.mf.pr.pr().pr("cleanspace_window_show", jSONObject2, hwVarPr);
    }
}
