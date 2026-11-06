package com.byazt.yy;

import android.os.Looper;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 8})
public class s extends com.byazt.ap.n implements qg {
    public long n;

    public s(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.n = System.currentTimeMillis();
    }

    @Override // com.byazt.ap.n
    public void n(final com.byazt.fvm.qg qgVar) {
        if (com.byazt.hi.w.n()) {
            super.n(qgVar);
        } else {
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.yy.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.super.n(qgVar);
                }
            });
        }
    }

    @Override // com.byazt.ap.n
    public void n(final com.byazt.fvm.n nVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(nVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.s.2
                @Override // java.lang.Runnable
                public void run() {
                    s.super.n(nVar);
                }
            });
        }
    }

    @Override // com.byazt.ap.n
    public void qg(final com.byazt.fvm.qg qgVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.qg(qgVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.s.3
                @Override // java.lang.Runnable
                public void run() {
                    s.super.qg(qgVar);
                }
            });
        }
    }

    @Override // com.byazt.ap.n
    public void n(final com.byazt.fvm.qg qgVar, final com.byazt.fvm.n nVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.n(qgVar, nVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.yy.s.4
                @Override // java.lang.Runnable
                public void run() {
                    s.super.n(qgVar, nVar);
                }
            });
        }
    }

    @Override // com.byazt.yy.qg
    public long qg() {
        return this.n;
    }
}
