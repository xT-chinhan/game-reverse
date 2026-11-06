package com.byazt.xv;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends hw implements fw {
    public String k;
    public String w;

    public zo(Context context) {
        super(context);
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        if (this.c != null && !this.c.isEmpty()) {
            Object obj = this.c.get(Common.System.NAME);
            if (obj != null) {
                this.w = String.valueOf(obj);
            }
            Object obj2 = this.c.get("state");
            if (obj2 != null) {
                this.k = String.valueOf(obj2);
            }
        }
        com.byazt.ik.hn hnVarHw = this.hw.hw(this.hw);
        if (hnVarHw == null) {
            return false;
        }
        hw(hnVarHw);
        return false;
    }

    private void hw(com.byazt.ik.hn hnVar) {
        List<com.byazt.ik.hn<View>> listFw;
        List<hw> listHw;
        if (hnVar == null) {
            return;
        }
        com.byazt.dd.vk vkVarL = hnVar.l();
        if (vkVarL != null && (listHw = vkVarL.hw("timer")) != null && !listHw.isEmpty()) {
            for (hw hwVar : listHw) {
                if (hwVar instanceof uc) {
                    uc ucVar = (uc) hwVar;
                    if (TextUtils.isEmpty(this.w) || TextUtils.equals(this.w, ucVar.hw())) {
                        ucVar.pr(this);
                    }
                }
            }
        }
        if (!(hnVar instanceof com.byazt.ik.pr) || (listFw = ((com.byazt.ik.pr) hnVar).fw()) == null || listFw.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            hw(it.next());
        }
    }

    @Override // com.byazt.xv.fw
    public void pr(String str) {
        if (TextUtils.equals(this.k, TrackAction.START) || TextUtils.isEmpty(this.k)) {
            if ((TextUtils.isEmpty(this.w) || TextUtils.equals(this.w, str)) && this.pr != null) {
                this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
            }
        }
    }

    @Override // com.byazt.xv.fw
    public void hw(String str) {
        if (TextUtils.equals(this.k, "complete") || TextUtils.isEmpty(this.k)) {
            if ((TextUtils.isEmpty(this.w) || TextUtils.equals(this.w, str)) && this.pr != null) {
                this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
            }
        }
    }
}
