package com.byazt.cv;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.mr.ho;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, 61})
public class aj extends com.byazt.pis.fw implements hw {
    public long pr;

    public aj(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.pis.fw
    public void pr(final int i, final String str) {
        if (str == null) {
            str = gz.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(i, str);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.super.pr(i, str);
                }
            });
        }
    }

    @Override // com.byazt.pis.fw
    public void pr(final ho hoVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(hoVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.aj.2
                @Override // java.lang.Runnable
                public void run() {
                    aj.super.pr(hoVar);
                }
            });
        }
    }

    @Override // com.byazt.pis.fw
    public void hw() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hw();
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.aj.3
                @Override // java.lang.Runnable
                public void run() {
                    aj.super.hw();
                }
            });
        }
    }

    @Override // com.byazt.pis.fw
    public void hw(final ho hoVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.hw(hoVar);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.aj.4
                @Override // java.lang.Runnable
                public void run() {
                    aj.super.hw(hoVar);
                }
            });
        }
    }

    @Override // com.byazt.cv.hw
    public long pr() {
        return this.pr;
    }
}
