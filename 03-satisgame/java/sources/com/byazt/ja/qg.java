package com.byazt.ja;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 26})
public class qg implements n.InterfaceC0206n {
    public Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function;
    }

    @Override // com.byazt.ja.n.InterfaceC0206n
    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.n;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.byazt.ja.n.InterfaceC0206n
    public void qg() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.n;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
