package com.byazt.cv;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, 121})
public class x extends com.byazt.pis.hw implements hw {
    public long pr;

    public x(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.pis.hw
    public void pr(final int i, final String str) {
        if (str == null) {
            str = gz.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(i, str);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.super.pr(i, str);
                }
            });
        }
    }

    @Override // com.byazt.pis.hw
    public void pr(final List<com.byazt.mr.aj> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(list);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.super.pr(list);
                }
            });
        }
    }

    @Override // com.byazt.cv.hw
    public long pr() {
        return this.pr;
    }
}
