package com.byazt.cv;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.mr.vk;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.pis.hn implements hw {
    public long pr;

    public c(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.pis.hn
    public void pr(final int i, final String str) {
        if (str == null) {
            str = gz.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(i, str);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.super.pr(i, str);
                }
            });
        }
    }

    @Override // com.byazt.pis.hn
    public void pr(final List<vk> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(list);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.super.pr(list);
                }
            });
        }
    }

    @Override // com.byazt.cv.hw
    public long pr() {
        return this.pr;
    }
}
