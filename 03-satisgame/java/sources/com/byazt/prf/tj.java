package com.byazt.prf;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends oa {
    public rv qg;
    public rv s;

    @Override // com.byazt.prf.oa
    public int[] n(RecyclerView.rv rvVar, View view) {
        int[] iArr = new int[2];
        if (rvVar.q()) {
            iArr[0] = n(rvVar, view, l(rvVar));
        } else {
            iArr[0] = 0;
        }
        if (rvVar.l()) {
            iArr[1] = n(rvVar, view, q(rvVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.byazt.prf.oa
    public View n(RecyclerView.rv rvVar) {
        if (rvVar.l()) {
            return n(rvVar, q(rvVar));
        }
        if (rvVar.q()) {
            return n(rvVar, l(rvVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.prf.oa
    public int n(RecyclerView.rv rvVar, int i, int i2) {
        View viewQg;
        int iQ;
        PointF pointFQ;
        int iLh = rvVar.lh();
        if (iLh == 0) {
            return -1;
        }
        if (rvVar.l()) {
            viewQg = qg(rvVar, q(rvVar));
        } else {
            viewQg = rvVar.q() ? qg(rvVar, l(rvVar)) : null;
        }
        if (viewQg == null || (iQ = rvVar.q(viewQg)) == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !rvVar.q() ? i2 <= 0 : i <= 0;
        if ((rvVar instanceof RecyclerView.a.qg) && (pointFQ = ((RecyclerView.a.qg) rvVar).q(iLh - 1)) != null && (pointFQ.x < 0.0f || pointFQ.y < 0.0f)) {
            z = true;
        }
        if (z) {
            return z2 ? iQ - 1 : iQ;
        }
        return z2 ? iQ + 1 : iQ;
    }

    @Override // com.byazt.prf.oa
    public x qg(RecyclerView.rv rvVar) {
        if (rvVar instanceof RecyclerView.a.qg) {
            return new x(this.n.getContext()) { // from class: com.byazt.prf.tj.1
                @Override // com.byazt.prf.x, com.byazt.prf.RecyclerView.a
                public void n(View view, RecyclerView.py pyVar, RecyclerView.a.n nVar) {
                    tj tjVar = tj.this;
                    int[] iArrN = tjVar.n(tjVar.n.getLayoutManager(), view);
                    int i = iArrN[0];
                    int i2 = iArrN[1];
                    int iN = n(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iN > 0) {
                        nVar.update(i, i2, iN, this.qg);
                    }
                }

                @Override // com.byazt.prf.x
                public float n(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // com.byazt.prf.x
                public int qg(int i) {
                    return Math.min(100, super.qg(i));
                }
            };
        }
        return null;
    }

    private int n(RecyclerView.rv rvVar, View view, rv rvVar2) {
        int iL;
        int iN = rvVar2.n(view) + (rvVar2.l(view) / 2);
        if (rvVar.hd()) {
            iL = rvVar2.s() + (rvVar2.w() / 2);
        } else {
            iL = rvVar2.l() / 2;
        }
        return iN - iL;
    }

    private View n(RecyclerView.rv rvVar, rv rvVar2) {
        int iL;
        int iPy = rvVar.py();
        View view = null;
        if (iPy == 0) {
            return null;
        }
        if (rvVar.hd()) {
            iL = rvVar2.s() + (rvVar2.w() / 2);
        } else {
            iL = rvVar2.l() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iPy; i2++) {
            View viewRv = rvVar.rv(i2);
            int iAbs = Math.abs((rvVar2.n(viewRv) + (rvVar2.l(viewRv) / 2)) - iL);
            if (iAbs < i) {
                view = viewRv;
                i = iAbs;
            }
        }
        return view;
    }

    private View qg(RecyclerView.rv rvVar, rv rvVar2) {
        int iPy = rvVar.py();
        View view = null;
        if (iPy == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iPy; i2++) {
            View viewRv = rvVar.rv(i2);
            int iN = rvVar2.n(viewRv);
            if (iN < i) {
                view = viewRv;
                i = iN;
            }
        }
        return view;
    }

    private rv q(RecyclerView.rv rvVar) {
        rv rvVar2 = this.qg;
        if (rvVar2 == null || rvVar2.n != rvVar) {
            this.qg = rv.qg(rvVar);
        }
        return this.qg;
    }

    private rv l(RecyclerView.rv rvVar) {
        rv rvVar2 = this.s;
        if (rvVar2 == null || rvVar2.n != rvVar) {
            this.s = rv.n(rvVar);
        }
        return this.s;
    }
}
