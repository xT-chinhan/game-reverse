package com.byazt.bz;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.byazt.gct.lh;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 762, 19})
public class n {
    public final Vibrator l;
    public List<qg> n;
    public Context qg;
    public final List<Long> s = new ArrayList();
    public final List<Integer> q = new ArrayList();
    public long w = 0;
    public long x = 0;

    private static float n(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    public n(Context context, lh lhVar) {
        this.qg = context;
        this.l = s.s(context);
        this.n = lhVar.qg();
        n();
    }

    public void n() {
        s();
        List<qg> list = this.n;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.n, new Comparator<qg>() { // from class: com.byazt.bz.n.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(qg qgVar, qg qgVar2) {
                return Long.compare(qgVar.n(), qgVar2.n());
            }
        });
        for (qg qgVar : this.n) {
            long jN = ((long) qgVar.n()) + qgVar.qg();
            if (jN > this.x) {
                this.x = jN;
            }
        }
        for (qg qgVar2 : this.n) {
            if (this.w < qgVar2.n()) {
                n(((long) qgVar2.n()) - this.w);
            }
            n(qgVar2.qg(), qgVar2.s(), qgVar2.q());
        }
        long j = this.w;
        long j2 = this.x;
        if (j < j2) {
            n(j2 - j);
        }
    }

    public void qg() {
        if (!s.n(this.qg) || this.s.isEmpty() || this.q.isEmpty()) {
            return;
        }
        long[] jArrN = n(this.s);
        int[] iArrQg = qg(this.q);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.l.vibrate(VibrationEffect.createWaveform(jArrN, iArrQg, -1));
            } else {
                this.l.vibrate(100L);
            }
        } catch (Throwable th) {
            k.n("HapticController", "playVibrate error", th);
        }
    }

    private void n(long j) {
        if (j > 0) {
            this.s.add(Long.valueOf(j));
            this.q.add(0);
            this.w += j;
        }
    }

    private void n(long j, float f, float f2) {
        float fN = n(f, 0.0f, 1.0f);
        float fN2 = n(f2, 0.0f, 1.0f);
        int iPow = (int) (((float) Math.pow(fN, 1.5d)) * 255.0f);
        int iMax = Math.max(1, (int) (fN2 * ((int) (j / 22))));
        long j2 = j - (((long) iMax) * 20);
        for (int i = 0; i < iMax; i++) {
            this.s.add(20L);
            this.q.add(Integer.valueOf(iPow));
            int i2 = iMax - 1;
            if (i < i2) {
                this.s.add(Long.valueOf(Math.max(2L, j2 / ((long) i2))));
                this.q.add(0);
            }
        }
        this.w += j;
    }

    public void s() {
        this.s.clear();
        this.q.clear();
        this.w = 0L;
        this.x = 0L;
    }

    private long[] n(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    private int[] qg(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
