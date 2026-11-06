package com.byazt.dc;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE, 8})
public class s {
    public final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(View view, float f, float f2, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(-99999987, 142101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
