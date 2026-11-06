package com.byazt.yy;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.fvm.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends com.byazt.ap.x implements qg {
    public long n;

    public rv(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = System.currentTimeMillis();
    }

    @Override // com.byazt.ap.x
    public void n(final int i, final String str) {
        if (str == null) {
            str = com.byazt.yn.n.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(i, str);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.rv.1
                @Override // java.lang.Runnable
                public void run() {
                    rv.super.n(i, str);
                }
            });
        }
    }

    @Override // com.byazt.ap.x
    public void n(final k kVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(kVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.rv.2
                @Override // java.lang.Runnable
                public void run() {
                    rv.super.n(kVar);
                }
            });
        }
    }

    @Override // com.byazt.ap.x
    public void n() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n();
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.rv.3
                @Override // java.lang.Runnable
                public void run() {
                    rv.super.n();
                }
            });
        }
    }

    @Override // com.byazt.ap.x
    public void qg(final k kVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.qg(kVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.rv.4
                @Override // java.lang.Runnable
                public void run() {
                    rv.super.qg(kVar);
                }
            });
        }
    }

    @Override // com.byazt.yy.qg
    public long qg() {
        return this.n;
    }
}
