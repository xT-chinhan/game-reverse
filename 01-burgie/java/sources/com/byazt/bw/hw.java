package com.byazt.bw;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 13})
public class hw implements pr.InterfaceC0028pr {
    public Function<SparseArray<Object>, Object> pr;

    public hw(Function<SparseArray<Object>, Object> function) {
        this.pr = function;
    }

    @Override // com.byazt.bw.pr.InterfaceC0028pr
    public void pr() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.pr;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.byazt.bw.pr.InterfaceC0028pr
    public void hw() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.pr;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
