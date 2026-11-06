package com.byazt.up;

import android.text.TextUtils;
import com.byazt.ih.s;
import com.byazt.xz.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, 19})
public class n extends com.byazt.ss.n {
    public n(s sVar, String str, x.n nVar) {
        super(sVar, str, nVar);
    }

    @Override // com.byazt.ss.n
    public void n() {
        Object obj;
        s sVarQg;
        int i;
        int i2;
        if (this.w == null || this.w.size() <= 0 || (obj = this.w.get("id")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (sVarQg = this.s.qg(this.s)) == null) {
            return;
        }
        s sVarQ = sVarQg.q(strValueOf);
        if (sVarQ instanceof com.byazt.ty.n) {
            com.byazt.ty.n nVar = (com.byazt.ty.n) sVarQ;
            int i3 = 3;
            try {
                i = Integer.parseInt(String.valueOf(this.w.get("col")));
                try {
                    i3 = Integer.parseInt(String.valueOf(this.w.get("row")));
                    i2 = Integer.parseInt(String.valueOf(this.w.get(MediationConstant.EXTRA_DURATION)));
                } catch (Exception unused) {
                    i2 = 600;
                }
            } catch (Exception unused2) {
                i = 4;
            }
            nVar.n(i, i3, i2);
        }
    }
}
