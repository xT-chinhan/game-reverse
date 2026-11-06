package com.byazt.cv;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.sd.lb;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, 20})
public class hn extends com.byazt.pis.pr implements hw {
    public long pr;

    public hn(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.pis.pr
    public void pr(final com.byazt.mr.hw hwVar) {
        if (com.byazt.jm.uc.hn()) {
            super.pr(hwVar);
        } else {
            com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.cv.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    hn.super.pr(hwVar);
                }
            });
        }
    }

    @Override // com.byazt.pis.pr
    public void pr(final com.byazt.mr.pr prVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(prVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    hn.super.pr(prVar);
                }
            });
        }
    }

    @Override // com.byazt.pis.pr
    public void hw(final com.byazt.mr.hw hwVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hw(hwVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.hn.3
                @Override // java.lang.Runnable
                public void run() {
                    hn.super.hw(hwVar);
                }
            });
        }
    }

    @Override // com.byazt.pis.pr
    public void pr(final com.byazt.mr.hw hwVar, final com.byazt.mr.pr prVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(hwVar, prVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.hn.4
                @Override // java.lang.Runnable
                public void run() {
                    hn.super.pr(hwVar, prVar);
                }
            });
        }
    }

    @Override // com.byazt.cv.hw
    public long pr() {
        return this.pr;
    }
}
