package com.byazt.ea;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 19})
public class n implements Callback<Object> {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.n != null) {
            this.n.apply(com.byazt.qvu.s.n().n(0, obj).n(-99999987, 1).qg().sparseArray());
        }
    }
}
