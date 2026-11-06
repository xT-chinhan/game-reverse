package com.byazt.cv;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.mr.m;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, 62})
public class fw extends com.byazt.pis.c implements hw {
    public long pr;

    public fw(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.pis.c
    public void pr(final int i, final String str) {
        if (str == null) {
            str = gz.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(i, str);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.fw.1
                @Override // java.lang.Runnable
                public void run() {
                    fw.super.pr(i, str);
                }
            });
        }
    }

    @Override // com.byazt.pis.c
    public void pr(final List<m> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pr(list);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.cv.fw.2
                @Override // java.lang.Runnable
                public void run() {
                    fw.super.pr(list);
                }
            });
        }
    }

    @Override // com.byazt.cv.hw
    public long pr() {
        return this.pr;
    }
}
