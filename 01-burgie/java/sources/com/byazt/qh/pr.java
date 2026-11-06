package com.byazt.qh;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 37})
public class pr extends hw {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }
}
