package com.byazt.jj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.byazt.dd.fw;
import com.byazt.ik.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 13})
public class hw extends com.byazt.tby.pr {
    public hw(hn hnVar, String str, fw.pr prVar) {
        super(hnVar, str, prVar);
    }

    @Override // com.byazt.tby.pr
    public void pr() {
        hn hnVarHw;
        if (this.uc == null || this.uc.isEmpty()) {
            return;
        }
        Object obj = this.uc.get("id");
        if (obj == null) {
            obj = this.uc.get(Common.System.NAME);
        }
        if (obj == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (hnVarHw = this.hn.hw(this.hn)) == null) {
            return;
        }
        hn hnVarX = hnVarHw.x(strValueOf);
        if (hnVarX instanceof com.byazt.qs.hw) {
            com.byazt.qs.hw hwVar = (com.byazt.qs.hw) hnVarX;
            hwVar.od();
            hwVar.pr(new AnimatorListenerAdapter() { // from class: com.byazt.jj.hw.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    hw.this.hn();
                }
            });
        }
    }

    @Override // com.byazt.tby.pr
    public void hw() {
    }
}
