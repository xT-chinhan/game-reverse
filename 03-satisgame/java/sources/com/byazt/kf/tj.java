package com.byazt.kf;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1116, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends s {
    public tj(com.byazt.pl.qg qgVar, Function<SparseArray<Object>, Object> function) {
        super(qgVar, function);
    }

    @Override // com.byazt.sg.s
    public void n(ViewGroup viewGroup) {
        try {
            qg(viewGroup);
        } catch (Exception unused) {
        }
    }

    public void qg(ViewGroup viewGroup) {
        if (this.tj != null) {
            this.tj.w();
        }
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(6152).n(20060, viewGroup).n(Void.class).qg());
        }
    }
}
