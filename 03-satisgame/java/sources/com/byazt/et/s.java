package com.byazt.et;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 8})
public class s extends qg implements com.byazt.vt.q {
    public com.byazt.vt.s cp;

    public s(Context context) {
        super(context);
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        com.byazt.vt.n nVarOj = this.qg.oj();
        if (nVarOj == null) {
            return false;
        }
        com.byazt.vt.s sVarN = nVarOj.n(this.w);
        this.cp = sVarN;
        if (sVarN != null) {
            sVarN.n(this);
            return false;
        }
        nVarOj.n(this.w, new com.byazt.vt.qg());
        return false;
    }

    @Override // com.byazt.vt.q
    public void n(String str) {
        this.n.n(this.qg, this.w, this.s.qg(), this.s);
    }
}
