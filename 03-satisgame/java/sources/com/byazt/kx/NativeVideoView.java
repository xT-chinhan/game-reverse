package com.byazt.kx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gu.l;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.ia.q;
import com.byazt.iag.s;
import com.byazt.tk.k;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1706, 1838})
public class NativeVideoView extends NativeVideoTsView implements s.n {
    public int n;
    public boolean ou;
    public l py;
    public n qg;

    public NativeVideoView(Context context) {
        super(context);
        if (this.l != null) {
            this.l.n(true);
        }
        this.a.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void oa() {
        super.oa();
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public s n(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        n nVar = new n(context, viewGroup, pkVar, str, z, z2, z3);
        this.qg = nVar;
        return nVar;
    }

    public void setPlayerType(int i) {
        this.n = i;
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void q() {
        if (this.l == null) {
            oa();
        } else if ((this.l instanceof q) && !um()) {
            ((q) this.l).sh();
        }
        if (this.l == null || !this.a.get()) {
            return;
        }
        this.a.set(false);
        r_();
        if (hd()) {
            com.byazt.okk.s.n((View) this.tj, 0);
            if (this.d != null) {
                com.byazt.okk.s.n((View) this.d, 8);
            }
            if (ta.k(this.q) != null) {
                com.byazt.zsl.l lVarN = ta.n(4, this.q);
                lVarN.qg(this.q.q());
                lVarN.qg(this.w.getWidth());
                lVarN.s(this.w.getHeight());
                lVarN.s(this.q.F_());
                this.q.cx(this.n);
                lVarN.l(this.n);
                lVarN.n(com.byazt.ql.s.n(this.q));
                lVarN.n(this.l.cp());
                lVarN.qg(this.l.um());
                ((q) this.l).q(this.n);
                ((q) this.l).qg(this.q);
                n(lVarN);
                this.l.s(false);
                return;
            }
            k.qg("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.l.a()) {
            com.byazt.okk.s.n((View) this.tj, 0);
        } else {
            d();
            com.byazt.okk.s.n((View) this.tj, 0);
        }
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void k() {
        super.k();
        com.byazt.okk.s.n((View) this.tj, 0);
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        com.byazt.okk.s.n((View) this.tj, 0);
    }

    public void qg(boolean z, boolean z2) {
        d();
        com.byazt.okk.s.n((View) this.tj, 0);
        com.byazt.okk.s.n((View) this.oa, z ? 0 : 8);
        com.byazt.okk.s.n((View) this.cp, z2 ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.py;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public boolean n(long j, boolean z, boolean z2) {
        this.w.setVisibility(0);
        if (this.l == null) {
            this.l = new q(getContext(), this.x, this.q, this.k, false, false);
        }
        if (sz() || this.rv) {
            n(this.s, 25, ta.qg(this.q));
        }
        return false;
    }

    @Override // com.byazt.ia.NativeVideoTsView, com.byazt.ia.q.n
    public void fs() {
        com.byazt.okk.s.n((View) this.tj, 8);
        super.fs();
    }

    @Override // com.byazt.ia.NativeVideoTsView, com.byazt.iag.s.n
    public void qg(long j, int i) {
        super.qg(j, i);
        com.byazt.okk.s.n((View) this.tj, 0);
    }

    @Override // com.byazt.ia.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.ou && i == 8) {
            k();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        if (this.l != null) {
            this.l.qg(map);
        }
    }

    public void l() {
        n nVar = this.qg;
        if (nVar != null) {
            nVar.fs();
            com.byazt.okk.s.n((View) this.tj, 8);
        }
    }

    public void w() {
        n nVar = this.qg;
        if (nVar != null) {
            nVar.w();
        }
    }

    public void setLp(boolean z) {
        this.ou = z;
    }

    public void n(l lVar) {
        this.py = lVar;
    }
}
