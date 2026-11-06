package com.byazt.yy;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.fvm.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 21})
public class x extends com.byazt.ap.l implements qg {
    public long n;

    public x(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = System.currentTimeMillis();
    }

    @Override // com.byazt.ap.l
    public void n(final int i, final String str) {
        if (str == null) {
            str = com.byazt.yn.n.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(i, str);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.super.n(i, str);
                }
            });
        }
    }

    @Override // com.byazt.ap.l
    public void n(final List<oa> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(list);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.super.n(list);
                }
            });
        }
    }

    @Override // com.byazt.yy.qg
    public long qg() {
        return this.n;
    }
}
