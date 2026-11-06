package com.byazt.tby;

import android.view.View;
import com.byazt.dd.fw;
import com.byazt.dd.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 225, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public c(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
        super(hnVar, str, prVar);
    }

    @Override // com.byazt.tby.pr
    public void pr() {
        String strValueOf;
        Object obj;
        if (this.uc != null && this.uc.size() > 0 && (obj = this.uc.get(Common.System.NAME)) != null) {
            strValueOf = String.valueOf(obj);
        } else {
            strValueOf = "";
        }
        com.byazt.ik.hn hnVarHw = this.hn.hw(this.hn);
        if (hnVarHw == null) {
            return;
        }
        pr(hnVarHw, strValueOf);
    }

    private void pr(com.byazt.ik.hn hnVar, String str) {
        List<com.byazt.ik.hn<View>> listFw;
        if (hnVar == null) {
            return;
        }
        vk vkVarL = hnVar.l();
        if (vkVarL != null) {
            vkVarL.pr(str);
        }
        if (!(hnVar instanceof com.byazt.ik.pr) || (listFw = ((com.byazt.ik.pr) hnVar).fw()) == null || listFw.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            pr(it.next(), str);
        }
    }

    @Override // com.byazt.tby.pr
    public void hw() {
    }
}
