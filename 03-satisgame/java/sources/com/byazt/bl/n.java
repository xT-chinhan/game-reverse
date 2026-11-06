package com.byazt.bl;

import android.util.SparseArray;
import com.byazt.qt.qg;
import com.byazt.qt.s;
import com.byazt.vf.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD, 19})
public class n implements wm, Function {
    public com.byazt.vf.n n;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return n();
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(qg());
        }
        if (iIntValue == 3) {
            return Integer.valueOf(s());
        }
        if (iIntValue != 4) {
            return null;
        }
        return Long.valueOf(q());
    }

    public n(com.byazt.vf.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.vf.wm
    public String n() {
        return s.qg();
    }

    @Override // com.byazt.vf.wm
    public boolean qg() {
        return qg.n().l();
    }

    @Override // com.byazt.vf.wm
    public int s() {
        return qg.n().oj();
    }

    @Override // com.byazt.vf.wm
    public long q() {
        return qg.n().dg();
    }
}
