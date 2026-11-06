package com.byazt.yy;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.fvm.cp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 13})
public class w extends com.byazt.ap.q implements qg {
    public long n;

    public w(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = System.currentTimeMillis();
    }

    @Override // com.byazt.ap.q
    public void n(final int i, final String str) {
        if (str == null) {
            str = com.byazt.yn.n.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(i, str);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.super.n(i, str);
                }
            });
        }
    }

    @Override // com.byazt.ap.q
    public void n(final cp cpVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(cpVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.super.n(cpVar);
                }
            });
        }
    }

    @Override // com.byazt.ap.q
    public void n() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n();
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.w.3
                @Override // java.lang.Runnable
                public void run() {
                    w.super.n();
                }
            });
        }
    }

    @Override // com.byazt.ap.q
    public void qg(final cp cpVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.qg(cpVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.w.4
                @Override // java.lang.Runnable
                public void run() {
                    w.super.qg(cpVar);
                }
            });
        }
    }

    @Override // com.byazt.yy.qg
    public long qg() {
        return this.n;
    }
}
