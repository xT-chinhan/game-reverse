package com.byazt.gf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 26})
public class qg {
    public final Function<SparseArray<Object>, Object> n;
    public s q;
    public final boolean qg;
    public n s;

    public void n(n nVar) {
        this.s = nVar;
    }

    public void n(s sVar) {
        this.q = sVar;
    }

    public qg(Function<SparseArray<Object>, Object> function) {
        this(function, false);
    }

    public qg(Function<SparseArray<Object>, Object> function, boolean z) {
        this.n = function;
        this.qg = z;
    }

    public void n() {
        s sVar = this.q;
        if (sVar != null) {
            sVar.n();
        }
    }

    public void n(int i, SparseArray<Object> sparseArray) {
        boolean zBooleanValue = com.byazt.qvu.n.n(sparseArray).qg().booleanValue(-999903);
        if (this.qg) {
            if (qg(i, sparseArray, zBooleanValue)) {
                return;
            }
        } else if (n(i, sparseArray, zBooleanValue)) {
            return;
        }
        qg(i, sparseArray);
    }

    private boolean n(int i, SparseArray<Object> sparseArray, boolean z) {
        n nVar;
        if (!z || i != 8001 || (nVar = this.s) == null) {
            return false;
        }
        nVar.n(true);
        return true;
    }

    private boolean qg(int i, SparseArray<Object> sparseArray, boolean z) {
        s sVar = this.q;
        if (sVar == null) {
            return false;
        }
        if (z && i == 8001) {
            sVar.n(i, sparseArray);
            return true;
        }
        if (z) {
            return false;
        }
        sVar.qg(i, sparseArray);
        return true;
    }

    private void qg(int i, SparseArray<Object> sparseArray) {
        if (this.n != null) {
            this.n.apply(com.byazt.of.qg.n().n(i).n(Void.class).n(-99999979, sparseArray).qg());
        }
    }
}
