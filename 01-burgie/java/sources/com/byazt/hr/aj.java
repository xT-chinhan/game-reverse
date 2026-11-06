package com.byazt.hr;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 61})
public class aj extends k {
    public zo hn;
    public zo hw;

    @Override // com.byazt.hr.k
    public int[] pr(RecyclerView.aj ajVar, View view) {
        int[] iArr = new int[2];
        if (ajVar.hn()) {
            iArr[0] = pr(ajVar, view, c(ajVar));
        } else {
            iArr[0] = 0;
        }
        if (ajVar.x()) {
            iArr[1] = pr(ajVar, view, x(ajVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.byazt.hr.k
    public View pr(RecyclerView.aj ajVar) {
        if (ajVar.x()) {
            return pr(ajVar, x(ajVar));
        }
        if (ajVar.hn()) {
            return pr(ajVar, c(ajVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.hr.k
    public int pr(RecyclerView.aj ajVar, int i, int i2) {
        int iX;
        boolean z;
        PointF pointFHn;
        int iGz = ajVar.gz();
        if (iGz == 0) {
            return -1;
        }
        View viewHw = null;
        if (ajVar.x()) {
            viewHw = hw(ajVar, x(ajVar));
        } else if (ajVar.hn()) {
            viewHw = hw(ajVar, c(ajVar));
        }
        if (viewHw == null || (iX = ajVar.x(viewHw)) == -1) {
            return -1;
        }
        boolean z2 = false;
        if (ajVar.hn()) {
            z = i > 0;
        } else {
            z = i2 > 0;
        }
        if ((ajVar instanceof RecyclerView.qa.hw) && (pointFHn = ((RecyclerView.qa.hw) ajVar).hn(iGz - 1)) != null && (pointFHn.x < 0.0f || pointFHn.y < 0.0f)) {
            z2 = true;
        }
        if (z2) {
            return z ? iX - 1 : iX;
        }
        return z ? iX + 1 : iX;
    }

    @Override // com.byazt.hr.k
    public uc hw(RecyclerView.aj ajVar) {
        if (ajVar instanceof RecyclerView.qa.hw) {
            return new uc(this.pr.getContext()) { // from class: com.byazt.hr.aj.1
                @Override // com.byazt.hr.uc, com.byazt.hr.RecyclerView.qa
                public void pr(View view, RecyclerView.a aVar, RecyclerView.qa.pr prVar) {
                    aj ajVar2 = aj.this;
                    int[] iArrPr = ajVar2.pr(ajVar2.pr.getLayoutManager(), view);
                    int i = iArrPr[0];
                    int i2 = iArrPr[1];
                    int iPr = pr(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iPr > 0) {
                        prVar.update(i, i2, iPr, this.hw);
                    }
                }

                @Override // com.byazt.hr.uc
                public float pr(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // com.byazt.hr.uc
                public int hw(int i) {
                    return Math.min(100, super.hw(i));
                }
            };
        }
        return null;
    }

    private int pr(RecyclerView.aj ajVar, View view, zo zoVar) {
        int iC;
        int iPr = zoVar.pr(view) + (zoVar.c(view) / 2);
        if (ajVar.ho()) {
            iC = zoVar.hn() + (zoVar.uc() / 2);
        } else {
            iC = zoVar.c() / 2;
        }
        return iPr - iC;
    }

    private View pr(RecyclerView.aj ajVar, zo zoVar) {
        int iC;
        int iQa = ajVar.qa();
        View view = null;
        if (iQa == 0) {
            return null;
        }
        if (ajVar.ho()) {
            iC = zoVar.hn() + (zoVar.uc() / 2);
        } else {
            iC = zoVar.c() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iQa; i2++) {
            View viewZo = ajVar.zo(i2);
            int iAbs = Math.abs((zoVar.pr(viewZo) + (zoVar.c(viewZo) / 2)) - iC);
            if (iAbs < i) {
                view = viewZo;
                i = iAbs;
            }
        }
        return view;
    }

    private View hw(RecyclerView.aj ajVar, zo zoVar) {
        int iQa = ajVar.qa();
        View view = null;
        if (iQa == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iQa; i2++) {
            View viewZo = ajVar.zo(i2);
            int iPr = zoVar.pr(viewZo);
            if (iPr < i) {
                view = viewZo;
                i = iPr;
            }
        }
        return view;
    }

    private zo x(RecyclerView.aj ajVar) {
        zo zoVar = this.hw;
        if (zoVar == null || zoVar.pr != ajVar) {
            this.hw = zo.hw(ajVar);
        }
        return this.hw;
    }

    private zo c(RecyclerView.aj ajVar) {
        zo zoVar = this.hn;
        if (zoVar == null || zoVar.pr != ajVar) {
            this.hn = zo.pr(ajVar);
        }
        return this.hn;
    }
}
