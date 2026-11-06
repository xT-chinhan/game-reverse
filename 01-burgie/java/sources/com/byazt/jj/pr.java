package com.byazt.jj;

import android.text.TextUtils;
import com.byazt.dd.fw;
import com.byazt.ik.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 37})
public class pr extends com.byazt.tby.pr {
    public pr(hn hnVar, String str, fw.pr prVar) {
        super(hnVar, str, prVar);
    }

    @Override // com.byazt.tby.pr
    public void pr() {
        Object obj;
        hn hnVarHw;
        if (this.uc == null || this.uc.size() <= 0 || (obj = this.uc.get("id")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (hnVarHw = this.hn.hw(this.hn)) == null) {
            return;
        }
        hn hnVarX = hnVarHw.x(strValueOf);
        if (hnVarX instanceof com.byazt.ny.pr) {
            com.byazt.ny.pr prVar = (com.byazt.ny.pr) hnVarX;
            int i = 4;
            int i2 = 3;
            int i3 = 600;
            try {
                i = Integer.parseInt(String.valueOf(this.uc.get("col")));
                i2 = Integer.parseInt(String.valueOf(this.uc.get("row")));
                i3 = Integer.parseInt(String.valueOf(this.uc.get("duration")));
            } catch (Exception e) {
            }
            prVar.pr(i, i2, i3);
        }
    }
}
