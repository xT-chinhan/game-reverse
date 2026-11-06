package com.byazt.yey;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 109})
public class w {
    public static w pr;
    public List<aj> hw;

    public static w pr() {
        if (pr == null) {
            synchronized (w.class) {
                if (pr == null) {
                    pr = new w();
                }
            }
        }
        return pr;
    }

    private w() {
        ArrayList arrayList = new ArrayList();
        this.hw = arrayList;
        arrayList.add(new vk());
        this.hw.add(new k());
        this.hw.add(new uc());
        this.hw.add(new pr());
    }

    public void pr(com.byazt.tia.hw hwVar, int i, zo zoVar) {
        DownloadInfo downloadInfoHw;
        List<aj> list = this.hw;
        if (list == null || list.size() == 0 || hwVar == null) {
            zoVar.pr(hwVar);
            return;
        }
        if (!TextUtils.isEmpty(hwVar.gu())) {
            downloadInfoHw = com.byazt.cvl.vk.pr((Context) null).pr(hwVar.gu(), null, true);
        } else {
            downloadInfoHw = com.byazt.cvl.vk.pr((Context) null).hw(hwVar.pr());
        }
        if (downloadInfoHw == null || !AdBaseConstants.MIME_APK.equals(downloadInfoHw.getMimeType())) {
            zoVar.pr(hwVar);
            return;
        }
        boolean z = com.byazt.ew.pr.pr(hwVar.qa()).pr("pause_optimise_switch", 0) == 1;
        for (aj ajVar : this.hw) {
            if (z || (ajVar instanceof k)) {
                if (ajVar.pr(hwVar, i, zoVar)) {
                    return;
                }
            }
        }
        zoVar.pr(hwVar);
    }
}
