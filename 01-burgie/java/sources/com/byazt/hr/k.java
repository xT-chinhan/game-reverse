package com.byazt.hr;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 250})
public abstract class k extends RecyclerView.k {
    public final RecyclerView.g hn = new RecyclerView.g() { // from class: com.byazt.hr.k.1
        public boolean pr = false;

        @Override // com.byazt.hr.RecyclerView.g
        public void pr(RecyclerView recyclerView, int i) {
            super.pr(recyclerView, i);
            if (i == 0 && this.pr) {
                this.pr = false;
                k.this.pr();
            }
        }

        @Override // com.byazt.hr.RecyclerView.g
        public void pr(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.pr = true;
            }
        }
    };
    public Scroller hw;
    public RecyclerView pr;

    public abstract int pr(RecyclerView.aj ajVar, int i, int i2);

    public abstract View pr(RecyclerView.aj ajVar);

    public abstract int[] pr(RecyclerView.aj ajVar, View view);

    @Override // com.byazt.hr.RecyclerView.k
    public boolean pr(int i, int i2) {
        RecyclerView.aj layoutManager = this.pr.getLayoutManager();
        if (layoutManager == null || this.pr.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.pr.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && hw(layoutManager, i, i2);
    }

    public void pr(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.pr;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                hn();
            }
            this.pr = recyclerView;
            if (recyclerView != null) {
                hw();
                this.hw = new Scroller(this.pr.getContext(), new DecelerateInterpolator());
                pr();
            }
        }
    }

    private void hw() throws IllegalStateException {
        if (this.pr.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.pr.pr(this.hn);
        this.pr.setOnFlingListener(this);
    }

    private void hn() {
        this.pr.hw(this.hn);
        this.pr.setOnFlingListener(null);
    }

    private boolean hw(RecyclerView.aj ajVar, int i, int i2) {
        RecyclerView.qa qaVarHn;
        int iPr;
        if (!(ajVar instanceof RecyclerView.qa.hw) || (qaVarHn = hn(ajVar)) == null || (iPr = pr(ajVar, i, i2)) == -1) {
            return false;
        }
        qaVarHn.hn(iPr);
        ajVar.pr(qaVarHn);
        return true;
    }

    public void pr() {
        RecyclerView.aj layoutManager;
        View viewPr;
        RecyclerView recyclerView = this.pr;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (viewPr = pr(layoutManager)) != null) {
            int[] iArrPr = pr(layoutManager, viewPr);
            int i = iArrPr[0];
            if (i != 0 || iArrPr[1] != 0) {
                this.pr.pr(i, iArrPr[1]);
            }
        }
    }

    public RecyclerView.qa hn(RecyclerView.aj ajVar) {
        return hw(ajVar);
    }

    @Deprecated
    public uc hw(RecyclerView.aj ajVar) {
        if (ajVar instanceof RecyclerView.qa.hw) {
            return new uc(this.pr.getContext()) { // from class: com.byazt.hr.k.2
                @Override // com.byazt.hr.uc, com.byazt.hr.RecyclerView.qa
                public void pr(View view, RecyclerView.a aVar, RecyclerView.qa.pr prVar) {
                    if (k.this.pr != null) {
                        k kVar = k.this;
                        int[] iArrPr = kVar.pr(kVar.pr.getLayoutManager(), view);
                        int i = iArrPr[0];
                        int i2 = iArrPr[1];
                        int iPr = pr(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iPr > 0) {
                            prVar.update(i, i2, iPr, this.hw);
                        }
                    }
                }

                @Override // com.byazt.hr.uc
                public float pr(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
