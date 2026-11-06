package com.byazt.dc;

import android.util.SparseArray;
import android.view.View;
import com.byazt.fvm.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE, 19})
public class n {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(View view, oa oaVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, oaVar);
        sparseArray.put(-99999987, 141101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void qg(View view, oa oaVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, oaVar);
        sparseArray.put(-99999987, 141102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(oa oaVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, oaVar);
        sparseArray.put(-99999987, 141103);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
