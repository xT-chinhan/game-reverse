package com.byazt.yey;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.lj.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 121})
public class x {
    public static x pr;
    public List<fw> hw;

    public static x pr() {
        if (pr == null) {
            synchronized (w.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    private x() {
        ArrayList arrayList = new ArrayList();
        this.hw = arrayList;
        arrayList.add(new c());
        this.hw.add(new hw());
        this.hw.add(new hn());
    }

    public void pr(com.byazt.tia.hw hwVar, int i, zo zoVar, com.byazt.wc.hn hnVar) {
        DownloadInfo downloadInfoHw;
        List<fw> list = this.hw;
        if (list == null || list.size() == 0 || hwVar == null) {
            zoVar.pr(hwVar);
        }
        if (!TextUtils.isEmpty(hwVar.gu())) {
            downloadInfoHw = com.byazt.cvl.vk.pr(com.byazt.eld.k.getContext()).pr(hwVar.gu(), null, true);
        } else {
            downloadInfoHw = com.byazt.cvl.vk.pr(com.byazt.eld.k.getContext()).hw(hwVar.pr());
        }
        if (downloadInfoHw == null) {
            downloadInfoHw = Downloader.getInstance(com.byazt.eld.k.getContext()).getDownloadInfo(hwVar.qa());
        }
        if (downloadInfoHw == null || !AdBaseConstants.MIME_APK.equals(downloadInfoHw.getMimeType())) {
            zoVar.pr(hwVar);
            return;
        }
        if (new vk().pr(hwVar, i, zoVar)) {
            return;
        }
        Iterator<fw> it = this.hw.iterator();
        while (it.hasNext()) {
            if (it.next().pr(hwVar, i, zoVar, hnVar)) {
                return;
            }
        }
        zoVar.pr(hwVar);
    }
}
