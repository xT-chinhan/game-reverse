package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes2.dex */
public abstract class sl extends RecyclerView.sl {
    private final RecyclerView.u ah = new RecyclerView.u() { // from class: com.bytedance.sdk.component.widget.recycler.sl.1

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1427ms = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
        public void ms(RecyclerView recyclerView, int i) {
            super.ms(recyclerView, i);
            if (i == 0 && this.f1427ms) {
                this.f1427ms = false;
                sl.this.ms();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
        public void ms(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f1427ms = true;
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    RecyclerView f1426ms;
    private Scroller xr;

    public abstract int ms(RecyclerView.ny nyVar, int i, int i2);

    public abstract View ms(RecyclerView.ny nyVar);

    public abstract int[] ms(RecyclerView.ny nyVar, View view);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.sl
    public boolean ms(int i, int i2) {
        RecyclerView.ny layoutManager = this.f1426ms.getLayoutManager();
        if (layoutManager == null || this.f1426ms.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1426ms.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && xr(layoutManager, i, i2);
    }

    public void ms(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f1426ms;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                ah();
            }
            this.f1426ms = recyclerView;
            if (recyclerView != null) {
                xr();
                this.xr = new Scroller(this.f1426ms.getContext(), new DecelerateInterpolator());
                ms();
            }
        }
    }

    private void xr() throws IllegalStateException {
        if (this.f1426ms.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1426ms.ms(this.ah);
        this.f1426ms.setOnFlingListener(this);
    }

    private void ah() {
        this.f1426ms.xr(this.ah);
        this.f1426ms.setOnFlingListener(null);
    }

    private boolean xr(RecyclerView.ny nyVar, int i, int i2) {
        RecyclerView.y yVarAh;
        int iMs;
        if (!(nyVar instanceof RecyclerView.y.xr) || (yVarAh = ah(nyVar)) == null || (iMs = ms(nyVar, i, i2)) == -1) {
            return false;
        }
        yVarAh.ah(iMs);
        nyVar.ms(yVarAh);
        return true;
    }

    void ms() {
        RecyclerView.ny layoutManager;
        View viewMs;
        RecyclerView recyclerView = this.f1426ms;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewMs = ms(layoutManager)) == null) {
            return;
        }
        int[] iArrMs = ms(layoutManager, viewMs);
        int i = iArrMs[0];
        if (i == 0 && iArrMs[1] == 0) {
            return;
        }
        this.f1426ms.ms(i, iArrMs[1]);
    }

    protected RecyclerView.y ah(RecyclerView.ny nyVar) {
        return xr(nyVar);
    }

    @Deprecated
    protected c xr(RecyclerView.ny nyVar) {
        if (nyVar instanceof RecyclerView.y.xr) {
            return new c(this.f1426ms.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.sl.2
                @Override // com.bytedance.sdk.component.widget.recycler.c, com.bytedance.sdk.component.widget.recycler.RecyclerView.y
                protected void ms(View view, RecyclerView.t tVar, RecyclerView.y.ms msVar) {
                    if (sl.this.f1426ms != null) {
                        sl slVar = sl.this;
                        int[] iArrMs = slVar.ms(slVar.f1426ms.getLayoutManager(), view);
                        int i = iArrMs[0];
                        int i2 = iArrMs[1];
                        int iMs = ms(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iMs > 0) {
                            msVar.update(i, i2, iMs, this.xr);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.c
                protected float ms(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
