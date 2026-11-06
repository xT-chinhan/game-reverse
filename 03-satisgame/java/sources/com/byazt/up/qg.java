package com.byazt.up;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.byazt.ih.s;
import com.byazt.xz.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, 26})
public class qg extends com.byazt.ss.n {
    @Override // com.byazt.ss.n
    public void qg() {
    }

    public qg(s sVar, String str, x.n nVar) {
        super(sVar, str, nVar);
    }

    @Override // com.byazt.ss.n
    public void n() {
        s sVarQg;
        if (this.w == null || this.w.isEmpty()) {
            return;
        }
        Object obj = this.w.get("id");
        if (obj == null) {
            obj = this.w.get(TapEventParamConstants.PARAM_NAME);
        }
        if (obj == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (sVarQg = this.s.qg(this.s)) == null) {
            return;
        }
        s sVarQ = sVarQg.q(strValueOf);
        if (sVarQ instanceof com.byazt.kru.qg) {
            com.byazt.kru.qg qgVar = (com.byazt.kru.qg) sVarQ;
            qgVar.lq();
            qgVar.n(new AnimatorListenerAdapter() { // from class: com.byazt.up.qg.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    qg.this.s();
                }
            });
        }
    }
}
