package com.byazt.prf;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public abstract class oa extends RecyclerView.d {
    public RecyclerView n;
    public Scroller qg;
    public final RecyclerView.sz s = new RecyclerView.sz() { // from class: com.byazt.prf.oa.1
        public boolean n = false;

        @Override // com.byazt.prf.RecyclerView.sz
        public void n(RecyclerView recyclerView, int i) {
            super.n(recyclerView, i);
            if (i == 0 && this.n) {
                this.n = false;
                oa.this.n();
            }
        }

        @Override // com.byazt.prf.RecyclerView.sz
        public void n(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.n = true;
        }
    };

    public abstract int n(RecyclerView.rv rvVar, int i, int i2);

    public abstract View n(RecyclerView.rv rvVar);

    public abstract int[] n(RecyclerView.rv rvVar, View view);

    @Override // com.byazt.prf.RecyclerView.d
    public boolean n(int i, int i2) {
        RecyclerView.rv layoutManager = this.n.getLayoutManager();
        if (layoutManager == null || this.n.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.n.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && qg(layoutManager, i, i2);
    }

    public void n(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.n;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                s();
            }
            this.n = recyclerView;
            if (recyclerView != null) {
                qg();
                this.qg = new Scroller(this.n.getContext(), new DecelerateInterpolator());
                n();
            }
        }
    }

    private void qg() throws IllegalStateException {
        if (this.n.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.n.n(this.s);
        this.n.setOnFlingListener(this);
    }

    private void s() {
        this.n.qg(this.s);
        this.n.setOnFlingListener(null);
    }

    private boolean qg(RecyclerView.rv rvVar, int i, int i2) {
        RecyclerView.a aVarS;
        int iN;
        if (!(rvVar instanceof RecyclerView.a.qg) || (aVarS = s(rvVar)) == null || (iN = n(rvVar, i, i2)) == -1) {
            return false;
        }
        aVarS.s(iN);
        rvVar.n(aVarS);
        return true;
    }

    public void n() {
        RecyclerView.rv layoutManager;
        View viewN;
        RecyclerView recyclerView = this.n;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewN = n(layoutManager)) == null) {
            return;
        }
        int[] iArrN = n(layoutManager, viewN);
        int i = iArrN[0];
        if (i == 0 && iArrN[1] == 0) {
            return;
        }
        this.n.n(i, iArrN[1]);
    }

    public RecyclerView.a s(RecyclerView.rv rvVar) {
        return qg(rvVar);
    }

    @Deprecated
    public x qg(RecyclerView.rv rvVar) {
        if (rvVar instanceof RecyclerView.a.qg) {
            return new x(this.n.getContext()) { // from class: com.byazt.prf.oa.2
                @Override // com.byazt.prf.x, com.byazt.prf.RecyclerView.a
                public void n(View view, RecyclerView.py pyVar, RecyclerView.a.n nVar) {
                    if (oa.this.n != null) {
                        oa oaVar = oa.this;
                        int[] iArrN = oaVar.n(oaVar.n.getLayoutManager(), view);
                        int i = iArrN[0];
                        int i2 = iArrN[1];
                        int iN = n(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iN > 0) {
                            nVar.update(i, i2, iN, this.qg);
                        }
                    }
                }

                @Override // com.byazt.prf.x
                public float n(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
