package com.byazt.cv;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.mr.w;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, 5})
public class uc extends com.byazt.pis.x implements hw {
    public long pr;

    public uc(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.pis.x
    public void pr(final int i, final String str) {
        if (str == null) {
            str = gz.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(i, str);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    uc.super.pr(i, str);
                }
            });
        }
    }

    @Override // com.byazt.pis.x
    public void pr(final w wVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(wVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.uc.2
                @Override // java.lang.Runnable
                public void run() {
                    uc.super.pr(wVar);
                }
            });
        }
    }

    @Override // com.byazt.pis.x
    public void hw() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hw();
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.uc.3
                @Override // java.lang.Runnable
                public void run() {
                    uc.super.hw();
                }
            });
        }
    }

    @Override // com.byazt.pis.x
    public void hw(final w wVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hw(wVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.uc.4
                @Override // java.lang.Runnable
                public void run() {
                    uc.super.hw(wVar);
                }
            });
        }
    }

    @Override // com.byazt.cv.hw
    public long pr() {
        return this.pr;
    }
}
