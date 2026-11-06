package com.byazt.tm;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.byazt.hg.nl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2289, 37})
public class pr {
    public final Vibrator c;
    public Context hw;
    public List<hw> pr;
    public final List<Long> hn = new ArrayList();
    public final List<Integer> x = new ArrayList();
    public long uc = 0;
    public long fw = 0;

    public pr(Context context, nl nlVar) {
        this.hw = context;
        this.c = hn.hn(context);
        this.pr = nlVar.hw();
        pr();
    }

    public void pr() {
        hn();
        List<hw> list = this.pr;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.pr, new Comparator<hw>() { // from class: com.byazt.tm.pr.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(hw hwVar, hw hwVar2) {
                return Long.compare(hwVar.pr(), hwVar2.pr());
            }
        });
        for (hw hwVar : this.pr) {
            long jPr = ((long) hwVar.pr()) + hwVar.hw();
            if (jPr > this.fw) {
                this.fw = jPr;
            }
        }
        for (hw hwVar2 : this.pr) {
            if (this.uc < hwVar2.pr()) {
                pr(((long) hwVar2.pr()) - this.uc);
            }
            pr(hwVar2.hw(), hwVar2.hn(), hwVar2.x());
        }
        long j = this.uc;
        long j2 = this.fw;
        if (j < j2) {
            pr(j2 - j);
        }
    }

    public void hw() {
        if (!hn.pr(this.hw) || this.hn.isEmpty() || this.x.isEmpty()) {
            return;
        }
        long[] jArrPr = pr(this.hn);
        int[] iArrHw = hw(this.x);
        if (Build.VERSION.SDK_INT >= 26) {
            this.c.vibrate(VibrationEffect.createWaveform(jArrPr, iArrHw, -1));
        } else {
            this.c.vibrate(100L);
        }
    }

    private void pr(long j) {
        if (j > 0) {
            this.hn.add(Long.valueOf(j));
            this.x.add(0);
            this.uc += j;
        }
    }

    private void pr(long j, float f, float f2) {
        float fPr = pr(f, 0.0f, 1.0f);
        float fPr2 = pr(f2, 0.0f, 1.0f);
        int iPow = (int) (((float) Math.pow(fPr, 1.5d)) * 255.0f);
        int iMax = Math.max(1, (int) (fPr2 * ((int) (j / 22))));
        long j2 = j - (((long) iMax) * 20);
        for (int i = 0; i < iMax; i++) {
            this.hn.add(20L);
            this.x.add(Integer.valueOf(iPow));
            int i2 = iMax - 1;
            if (i < i2) {
                this.hn.add(Long.valueOf(Math.max(2L, j2 / ((long) i2))));
                this.x.add(0);
            }
        }
        this.uc += j;
    }

    public void hn() {
        this.hn.clear();
        this.x.clear();
        this.uc = 0L;
        this.fw = 0L;
    }

    private static float pr(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    private long[] pr(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    private int[] hw(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
