package com.byazt.prf;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 110})
public class sz extends RecyclerView.rv implements RecyclerView.a.qg {
    public int cp;
    public final s d;
    public boolean h;
    public int[] j;
    public boolean k;
    public w[] n;
    public BitSet oa;
    public rv qg;
    public rv s;
    public l t;
    public int tj;
    public int ur;
    public int rv = -1;
    public boolean q = false;
    public boolean l = false;
    public int w = -1;
    public int x = Integer.MIN_VALUE;
    public q fs = new q();
    public int sz = 2;
    public final Rect bb = new Rect();
    public final n ln = new n();
    public boolean lh = false;
    public boolean v = true;
    public final Runnable an = new Runnable() { // from class: com.byazt.prf.sz.1
        @Override // java.lang.Runnable
        public void run() {
            sz.this.w();
        }
    };

    public sz(int i, int i2) {
        this.tj = i2;
        n(i);
        this.d = new s();
        df();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean s() {
        return this.sz != 0;
    }

    private void df() {
        this.qg = rv.n(this, this.tj);
        this.s = rv.n(this, 1 - this.tj);
    }

    public boolean w() {
        int iFi;
        int iOa;
        if (py() == 0 || this.sz == 0 || !cy()) {
            return false;
        }
        if (this.l) {
            iFi = oa();
            iOa = fi();
        } else {
            iFi = fi();
            iOa = oa();
        }
        if (iFi == 0 && x() != null) {
            this.fs.n();
            ae();
            sz();
            return true;
        }
        if (!this.lh) {
            return false;
        }
        int i = this.l ? -1 : 1;
        int i2 = iOa + 1;
        q.n nVarN = this.fs.n(iFi, i2, i, true);
        if (nVarN == null) {
            this.lh = false;
            this.fs.n(i2);
            return false;
        }
        q.n nVarN2 = this.fs.n(iFi, nVarN.n, i * (-1), true);
        if (nVarN2 == null) {
            this.fs.n(nVarN.n);
        } else {
            this.fs.n(nVarN2.n + 1);
        }
        ae();
        sz();
        return true;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void d(int i) {
        if (i == 0) {
            w();
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, RecyclerView.cy cyVar) {
        super.n(recyclerView, cyVar);
        n(this.an);
        for (int i = 0; i < this.rv; i++) {
            this.n[i].l();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    public View x() {
        int i;
        int i2;
        boolean z;
        int iPy = py() - 1;
        BitSet bitSet = new BitSet(this.rv);
        bitSet.set(0, this.rv, true);
        byte b = (this.tj == 1 && rv()) ? (byte) 1 : (byte) -1;
        if (this.l) {
            i = -1;
        } else {
            i = iPy + 1;
            iPy = 0;
        }
        int i3 = iPy < i ? 1 : -1;
        while (iPy != i) {
            View viewRv = rv(iPy);
            qg qgVar = (qg) viewRv.getLayoutParams();
            if (bitSet.get(qgVar.n.l)) {
                if (n(qgVar.n)) {
                    return viewRv;
                }
                bitSet.clear(qgVar.n.l);
            }
            if (!qgVar.qg && (i2 = iPy + i3) != i) {
                View viewRv2 = rv(i2);
                if (this.l) {
                    int iQg = this.qg.qg(viewRv);
                    int iQg2 = this.qg.qg(viewRv2);
                    if (iQg < iQg2) {
                        return viewRv;
                    }
                    if (iQg == iQg2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int iN = this.qg.n(viewRv);
                    int iN2 = this.qg.n(viewRv2);
                    if (iN > iN2) {
                        return viewRv;
                    }
                    if (iN == iN2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if ((qgVar.n.l - ((qg) viewRv2.getLayoutParams()).n.l < 0) != (b < 0)) {
                        return viewRv;
                    }
                } else {
                    continue;
                }
            }
            iPy += i3;
        }
        return null;
    }

    private boolean n(w wVar) {
        if (this.l) {
            return wVar.q() < this.qg.q() && !wVar.s(wVar.n.get(wVar.n.size() - 1)).qg;
        }
        if (wVar.qg() > this.qg.s() && !wVar.s(wVar.n.get(0)).qg) {
            return true;
        }
        return false;
    }

    public void n(int i) {
        n((String) null);
        if (i != this.rv) {
            fs();
            this.rv = i;
            this.oa = new BitSet(this.rv);
            this.n = new w[this.rv];
            for (int i2 = 0; i2 < this.rv; i2++) {
                this.n[i2] = new w(i2);
            }
            sz();
        }
    }

    public void n(boolean z) {
        n((String) null);
        l lVar = this.t;
        if (lVar != null && lVar.fs != z) {
            this.t.fs = z;
        }
        this.q = z;
        sz();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(String str) {
        if (this.t == null) {
            super.n(str);
        }
    }

    public void fs() {
        this.fs.n();
        sz();
    }

    private void oj() {
        boolean z = true;
        if (this.tj == 1 || !rv()) {
            z = this.q;
        } else if (this.q) {
            z = false;
        }
        this.l = z;
    }

    public boolean rv() {
        return um() == 1;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(Rect rect, int i, int i2) {
        int iN;
        int iN2;
        int iH = h() + ur();
        int iT = t() + bb();
        if (this.tj == 1) {
            iN2 = n(i2, rect.height() + iT, j());
            iN = n(i, (this.cp * this.rv) + iH, v());
        } else {
            iN = n(i, rect.width() + iH, v());
            iN2 = n(i2, (this.cp * this.rv) + iT, j());
        }
        w(iN, iN2);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        n(cyVar, pyVar, true);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0164  */
    private void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, boolean z) {
        boolean z2;
        l lVar;
        n nVar = this.ln;
        if ((this.t != null || this.w != -1) && pyVar.l() == 0) {
            s(cyVar);
            nVar.n();
            return;
        }
        boolean z3 = (nVar.l && this.w == -1 && this.t == null) ? false : true;
        if (z3) {
            nVar.n();
            if (this.t != null) {
                n(nVar);
            } else {
                oj();
                nVar.s = this.l;
            }
            n(pyVar, nVar);
            nVar.l = true;
        }
        if (this.t == null && this.w == -1 && (nVar.s != this.k || rv() != this.h)) {
            this.fs.n();
            nVar.q = true;
        }
        if (py() > 0 && ((lVar = this.t) == null || lVar.s <= 0)) {
            if (nVar.q) {
                for (int i = 0; i < this.rv; i++) {
                    this.n[i].l();
                    if (nVar.qg != Integer.MIN_VALUE) {
                        this.n[i].s(nVar.qg);
                    }
                }
            } else if (z3 || this.ln.w == null) {
                for (int i2 = 0; i2 < this.rv; i2++) {
                    this.n[i2].n(this.l, nVar.qg);
                }
                this.ln.n(this.n);
            } else {
                for (int i3 = 0; i3 < this.rv; i3++) {
                    w wVar = this.n[i3];
                    wVar.l();
                    wVar.s(this.ln.w[i3]);
                }
            }
        }
        n(cyVar);
        this.d.n = false;
        this.lh = false;
        qg(this.s.w());
        qg(nVar.n, pyVar);
        if (nVar.s) {
            w(-1);
            n(cyVar, this.d, pyVar);
            w(1);
            this.d.s = nVar.n + this.d.q;
            n(cyVar, this.d, pyVar);
        } else {
            w(1);
            n(cyVar, this.d, pyVar);
            w(-1);
            this.d.s = nVar.n + this.d.q;
            n(cyVar, this.d, pyVar);
        }
        dg();
        if (py() > 0) {
            if (this.l) {
                qg(cyVar, pyVar, true);
                s(cyVar, pyVar, false);
            } else {
                s(cyVar, pyVar, true);
                qg(cyVar, pyVar, false);
            }
        }
        if (z && !pyVar.n()) {
            if (this.sz != 0 && py() > 0 && (this.lh || x() != null)) {
                n(this.an);
                z2 = w();
            }
        }
        if (pyVar.n()) {
            this.ln.n();
        }
        this.k = nVar.s;
        this.h = rv();
        if (z2) {
            this.ln.n();
            n(cyVar, pyVar, false);
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView.py pyVar) {
        super.n(pyVar);
        this.w = -1;
        this.x = Integer.MIN_VALUE;
        this.t = null;
        this.ln.n();
    }

    private void dg() {
        if (this.s.fs() == 1073741824) {
            return;
        }
        int iPy = py();
        float fMax = 0.0f;
        for (int i = 0; i < iPy; i++) {
            View viewRv = rv(i);
            float fL = this.s.l(viewRv);
            if (fL >= fMax) {
                if (((qg) viewRv.getLayoutParams()).n()) {
                    fL = (fL * 1.0f) / this.rv;
                }
                fMax = Math.max(fMax, fL);
            }
        }
        int i2 = this.cp;
        int iRound = Math.round(fMax * this.rv);
        if (this.s.fs() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.s.w());
        }
        qg(iRound);
        if (this.cp == i2) {
            return;
        }
        for (int i3 = 0; i3 < iPy; i3++) {
            View viewRv2 = rv(i3);
            qg qgVar = (qg) viewRv2.getLayoutParams();
            if (!qgVar.qg) {
                if (rv() && this.tj == 1) {
                    viewRv2.offsetLeftAndRight(((-((this.rv - 1) - qgVar.n.l)) * this.cp) - ((-((this.rv - 1) - qgVar.n.l)) * i2));
                } else {
                    int i4 = qgVar.n.l * this.cp;
                    int i5 = qgVar.n.l * i2;
                    if (this.tj == 1) {
                        viewRv2.offsetLeftAndRight(i4 - i5);
                    } else {
                        viewRv2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    private void n(n nVar) {
        int iS;
        if (this.t.s > 0) {
            if (this.t.s == this.rv) {
                for (int i = 0; i < this.rv; i++) {
                    this.n[i].l();
                    int i2 = this.t.q[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.t.rv) {
                            iS = this.qg.q();
                        } else {
                            iS = this.qg.s();
                        }
                        i2 += iS;
                    }
                    this.n[i].s(i2);
                }
            } else {
                this.t.n();
                l lVar = this.t;
                lVar.n = lVar.qg;
            }
        }
        this.h = this.t.tj;
        n(this.t.fs);
        oj();
        if (this.t.n != -1) {
            this.w = this.t.n;
            nVar.s = this.t.rv;
        } else {
            nVar.s = this.l;
        }
        if (this.t.l > 1) {
            this.fs.n = this.t.w;
            this.fs.qg = this.t.x;
        }
    }

    public void n(RecyclerView.py pyVar, n nVar) {
        if (qg(pyVar, nVar) || s(pyVar, nVar)) {
            return;
        }
        nVar.qg();
        nVar.n = 0;
    }

    private boolean s(RecyclerView.py pyVar, n nVar) {
        int iPy;
        if (this.k) {
            iPy = ou(pyVar.l());
        } else {
            iPy = py(pyVar.l());
        }
        nVar.n = iPy;
        nVar.qg = Integer.MIN_VALUE;
        return true;
    }

    public boolean qg(RecyclerView.py pyVar, n nVar) {
        int i;
        int iS;
        if (!pyVar.n() && (i = this.w) != -1) {
            if (i < 0 || i >= pyVar.l()) {
                this.w = -1;
                this.x = Integer.MIN_VALUE;
            } else {
                l lVar = this.t;
                if (lVar == null || lVar.n == -1 || this.t.s <= 0) {
                    View viewS = s(this.w);
                    if (viewS != null) {
                        nVar.n = this.l ? oa() : fi();
                        if (this.x != Integer.MIN_VALUE) {
                            if (nVar.s) {
                                nVar.qg = (this.qg.q() - this.x) - this.qg.qg(viewS);
                            } else {
                                nVar.qg = (this.qg.s() + this.x) - this.qg.n(viewS);
                            }
                            return true;
                        }
                        if (this.qg.l(viewS) > this.qg.w()) {
                            if (nVar.s) {
                                iS = this.qg.q();
                            } else {
                                iS = this.qg.s();
                            }
                            nVar.qg = iS;
                            return true;
                        }
                        int iN = this.qg.n(viewS) - this.qg.s();
                        if (iN < 0) {
                            nVar.qg = -iN;
                            return true;
                        }
                        int iQ = this.qg.q() - this.qg.qg(viewS);
                        if (iQ < 0) {
                            nVar.qg = iQ;
                            return true;
                        }
                        nVar.qg = Integer.MIN_VALUE;
                    } else {
                        nVar.n = this.w;
                        int i2 = this.x;
                        if (i2 == Integer.MIN_VALUE) {
                            nVar.s = a(nVar.n) == 1;
                            nVar.qg();
                        } else {
                            nVar.n(i2);
                        }
                        nVar.q = true;
                    }
                } else {
                    nVar.qg = Integer.MIN_VALUE;
                    nVar.n = this.w;
                }
                return true;
            }
        }
        return false;
    }

    public void qg(int i) {
        this.cp = i / this.rv;
        this.ur = View.MeasureSpec.makeMeasureSpec(i, this.s.fs());
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean qg() {
        return this.t == null;
    }

    public int[] n(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.rv];
        } else if (iArr.length < this.rv) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.rv + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.rv; i++) {
            iArr[i] = this.n[i].cp();
        }
        return iArr;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int s(RecyclerView.py pyVar) {
        return qg(pyVar);
    }

    private int qg(RecyclerView.py pyVar) {
        if (py() == 0) {
            return 0;
        }
        return cp.n(pyVar, this.qg, qg(!this.v), s(!this.v), this, this.v, this.l);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int q(RecyclerView.py pyVar) {
        return qg(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int l(RecyclerView.py pyVar) {
        return rv(pyVar);
    }

    private int rv(RecyclerView.py pyVar) {
        if (py() == 0) {
            return 0;
        }
        return cp.n(pyVar, this.qg, qg(!this.v), s(!this.v), this, this.v);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int w(RecyclerView.py pyVar) {
        return rv(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int x(RecyclerView.py pyVar) {
        return tj(pyVar);
    }

    private int tj(RecyclerView.py pyVar) {
        if (py() == 0) {
            return 0;
        }
        return cp.qg(pyVar, this.qg, qg(!this.v), s(!this.v), this, this.v);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int fs(RecyclerView.py pyVar) {
        return tj(pyVar);
    }

    private void n(View view, qg qgVar, boolean z) {
        if (qgVar.qg) {
            if (this.tj == 1) {
                n(view, this.ur, n(hu(), wm(), t() + bb(), qgVar.height, true), z);
                return;
            } else {
                n(view, n(m(), ou(), h() + ur(), qgVar.width, true), this.ur, z);
                return;
            }
        }
        if (this.tj == 1) {
            n(view, n(this.cp, ou(), 0, qgVar.width, false), n(hu(), wm(), t() + bb(), qgVar.height, true), z);
        } else {
            n(view, n(m(), ou(), h() + ur(), qgVar.width, true), n(this.cp, wm(), 0, qgVar.height, false), z);
        }
    }

    private void n(View view, int i, int i2, boolean z) {
        boolean zQg;
        qg(view, this.bb);
        qg qgVar = (qg) view.getLayoutParams();
        int iQg = qg(i, qgVar.leftMargin + this.bb.left, qgVar.rightMargin + this.bb.right);
        int iQg2 = qg(i2, qgVar.topMargin + this.bb.top, qgVar.bottomMargin + this.bb.bottom);
        if (z) {
            zQg = n(view, iQg, iQg2, qgVar);
        } else {
            zQg = qg(view, iQg, iQg2, qgVar);
        }
        if (zQg) {
            view.measure(iQg, iQg2);
        }
    }

    private int qg(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    public View qg(boolean z) {
        int iS = this.qg.s();
        int iQ = this.qg.q();
        int iPy = py();
        View view = null;
        for (int i = 0; i < iPy; i++) {
            View viewRv = rv(i);
            int iN = this.qg.n(viewRv);
            if (this.qg.qg(viewRv) > iS && iN < iQ) {
                if (iN >= iS || !z) {
                    return viewRv;
                }
                if (view == null) {
                    view = viewRv;
                }
            }
        }
        return view;
    }

    public View s(boolean z) {
        int iS = this.qg.s();
        int iQ = this.qg.q();
        View view = null;
        for (int iPy = py() - 1; iPy >= 0; iPy--) {
            View viewRv = rv(iPy);
            int iN = this.qg.n(viewRv);
            int iQg = this.qg.qg(viewRv);
            if (iQg > iS && iN < iQ) {
                if (iQg <= iQ || !z) {
                    return viewRv;
                }
                if (view == null) {
                    view = viewRv;
                }
            }
        }
        return view;
    }

    private void qg(RecyclerView.cy cyVar, RecyclerView.py pyVar, boolean z) {
        int iQ;
        int iHd = hd(Integer.MIN_VALUE);
        if (iHd != Integer.MIN_VALUE && (iQ = this.qg.q() - iHd) > 0) {
            int i = iQ - (-s(-iQ, cyVar, pyVar));
            if (!z || i <= 0) {
                return;
            }
            this.qg.n(i);
        }
    }

    private void s(RecyclerView.cy cyVar, RecyclerView.py pyVar, boolean z) {
        int iS;
        int iCy = cy(Integer.MAX_VALUE);
        if (iCy != Integer.MAX_VALUE && (iS = iCy - this.qg.s()) > 0) {
            int iS2 = iS - s(iS, cyVar, pyVar);
            if (!z || iS2 <= 0) {
                return;
            }
            this.qg.n(-iS2);
        }
    }

    private void qg(int i, RecyclerView.py pyVar) {
        int iW;
        int iW2;
        int iS;
        boolean z = false;
        this.d.qg = 0;
        this.d.s = i;
        if (!cd() || (iS = pyVar.s()) == -1) {
            iW = 0;
            iW2 = 0;
        } else {
            if (this.l == (iS < i)) {
                iW = this.qg.w();
                iW2 = 0;
            } else {
                iW2 = this.qg.w();
                iW = 0;
            }
        }
        if (hd()) {
            this.d.w = this.qg.s() - iW2;
            this.d.x = this.qg.q() + iW;
        } else {
            this.d.x = this.qg.l() + iW;
            this.d.w = -iW2;
        }
        this.d.fs = false;
        this.d.n = true;
        s sVar = this.d;
        if (this.qg.fs() == 0 && this.qg.l() == 0) {
            z = true;
        }
        sVar.rv = z;
    }

    private void w(int i) {
        this.d.l = i;
        this.d.q = this.l != (i == -1) ? -1 : 1;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void tj(int i) {
        super.tj(i);
        for (int i2 = 0; i2 < this.rv; i2++) {
            this.n[i2].q(i);
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void cp(int i) {
        super.cp(i);
        for (int i2 = 0; i2 < this.rv; i2++) {
            this.n[i2].q(i);
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void qg(RecyclerView recyclerView, int i, int i2) {
        s(i, i2, 2);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, int i, int i2) {
        s(i, i2, 1);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView) {
        this.fs.n();
        sz();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, int i, int i2, int i3) {
        s(i, i2, 8);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, int i, int i2, Object obj) {
        s(i, i2, 4);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void s(int i, int i2, int i3) {
        int i4;
        int i5;
        int iOa;
        int iOa2 = this.l ? oa() : fi();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            this.fs.qg(i5);
            if (i3 != 1) {
                this.fs.qg(i, i2);
            } else if (i3 != 2) {
                this.fs.n(i, i2);
            } else if (i3 == 8) {
                this.fs.n(i, 1);
                this.fs.qg(i2, 1);
            }
            if (i4 <= iOa2) {
                return;
            }
            if (this.l) {
                iOa = fi();
            } else {
                iOa = oa();
            }
            if (i5 <= iOa) {
                sz();
            }
        }
        i4 = i + i2;
        i5 = i;
        this.fs.qg(i5);
        if (i3 != 1) {
            this.fs.qg(i, i2);
        } else if (i3 != 2) {
            this.fs.n(i, i2);
        } else if (i3 == 8) {
            this.fs.n(i, 1);
            this.fs.qg(i2, 1);
        }
        if (i4 <= iOa2) {
            return;
        }
        if (this.l) {
            iOa = fi();
        } else {
            iOa = oa();
        }
        if (i5 <= iOa) {
            sz();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.byazt.prf.sz] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v5 */
    private int n(RecyclerView.cy cyVar, s sVar, RecyclerView.py pyVar) {
        int i;
        int iS;
        int iHd;
        w wVarN;
        int iL;
        int i2;
        int iL2;
        int iL3;
        boolean zD;
        ?? r9 = 0;
        this.oa.set(0, this.rv, true);
        if (this.d.rv) {
            i = sVar.l == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (sVar.l == 1) {
            i = sVar.x + sVar.qg;
        } else {
            i = sVar.w - sVar.qg;
        }
        int i3 = i;
        n(sVar.l, i3);
        if (this.l) {
            iS = this.qg.q();
        } else {
            iS = this.qg.s();
        }
        int i4 = iS;
        boolean z = false;
        while (sVar.n(pyVar) && (this.d.rv || !this.oa.isEmpty())) {
            View viewN = sVar.n(cyVar);
            qg qgVar = (qg) viewN.getLayoutParams();
            int iW = qgVar.w();
            int iS2 = this.fs.s(iW);
            ?? r3 = iS2 == -1 ? 1 : r9;
            if (r3 != 0) {
                wVarN = qgVar.qg ? this.n[r9] : n(sVar);
                this.fs.n(iW, wVarN);
            } else {
                wVarN = this.n[iS2];
            }
            w wVar = wVarN;
            qgVar.n = wVar;
            if (sVar.l == 1) {
                qg(viewN);
            } else {
                qg(viewN, r9);
            }
            n(viewN, qgVar, r9);
            if (sVar.l == 1) {
                int iHd2 = qgVar.qg ? hd(i4) : wVar.qg(i4);
                int iL4 = this.qg.l(viewN) + iHd2;
                if (r3 != 0 && qgVar.qg) {
                    q.n nVarOa = oa(iHd2);
                    nVarOa.qg = -1;
                    nVarOa.n = iW;
                    this.fs.n(nVarOa);
                }
                i2 = iL4;
                iL = iHd2;
            } else {
                int iCy = qgVar.qg ? cy(i4) : wVar.n(i4);
                iL = iCy - this.qg.l(viewN);
                if (r3 != 0 && qgVar.qg) {
                    q.n nVarSz = sz(iCy);
                    nVarSz.qg = 1;
                    nVarSz.n = iW;
                    this.fs.n(nVarSz);
                }
                i2 = iCy;
            }
            if (qgVar.qg && sVar.q == -1) {
                if (r3 == 0) {
                    if (sVar.l == 1) {
                        zD = tj();
                    } else {
                        zD = d();
                    }
                    if (!zD) {
                        q.n nVarW = this.fs.w(iW);
                        if (nVarW != null) {
                            nVarW.q = true;
                        }
                        this.lh = true;
                    }
                } else {
                    this.lh = true;
                }
            }
            n(viewN, qgVar, sVar);
            if (rv() && this.tj == 1) {
                int iQ = qgVar.qg ? this.s.q() : this.s.q() - (((this.rv - 1) - wVar.l) * this.cp);
                iL3 = iQ;
                iL2 = iQ - this.s.l(viewN);
            } else {
                int iS3 = qgVar.qg ? this.s.s() : (wVar.l * this.cp) + this.s.s();
                iL2 = iS3;
                iL3 = this.s.l(viewN) + iS3;
            }
            if (this.tj == 1) {
                n(viewN, iL2, iL, iL3, i2);
            } else {
                n(viewN, iL, iL2, i2, iL3);
            }
            if (qgVar.qg) {
                n(this.d.l, i3);
            } else {
                n(wVar, this.d.l, i3);
            }
            n(cyVar, this.d);
            if (this.d.fs && viewN.hasFocusable()) {
                if (qgVar.qg) {
                    this.oa.clear();
                } else {
                    this.oa.set(wVar.l, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            n(cyVar, this.d);
        }
        if (this.d.l == -1) {
            iHd = this.qg.s() - cy(this.qg.s());
        } else {
            iHd = hd(this.qg.q()) - this.qg.q();
        }
        if (iHd > 0) {
            return Math.min(sVar.qg, iHd);
        }
        return 0;
    }

    private q.n oa(int i) {
        q.n nVar = new q.n();
        nVar.s = new int[this.rv];
        for (int i2 = 0; i2 < this.rv; i2++) {
            nVar.s[i2] = i - this.n[i2].qg(i);
        }
        return nVar;
    }

    private q.n sz(int i) {
        q.n nVar = new q.n();
        nVar.s = new int[this.rv];
        for (int i2 = 0; i2 < this.rv; i2++) {
            nVar.s[i2] = this.n[i2].n(i) - i;
        }
        return nVar;
    }

    private void n(View view, qg qgVar, s sVar) {
        if (sVar.l == 1) {
            if (qgVar.qg) {
                cy(view);
                return;
            } else {
                qgVar.n.qg(view);
                return;
            }
        }
        if (qgVar.qg) {
            hd(view);
        } else {
            qgVar.n.n(view);
        }
    }

    private void n(RecyclerView.cy cyVar, s sVar) {
        int iMin;
        int iMin2;
        if (!sVar.n || sVar.rv) {
            return;
        }
        if (sVar.qg == 0) {
            if (sVar.l == -1) {
                qg(cyVar, sVar.x);
                return;
            } else {
                n(cyVar, sVar.w);
                return;
            }
        }
        if (sVar.l == -1) {
            int iK = sVar.w - k(sVar.w);
            if (iK < 0) {
                iMin2 = sVar.x;
            } else {
                iMin2 = sVar.x - Math.min(iK, sVar.qg);
            }
            qg(cyVar, iMin2);
            return;
        }
        int iCd = cd(sVar.x) - sVar.x;
        if (iCd < 0) {
            iMin = sVar.w;
        } else {
            iMin = Math.min(iCd, sVar.qg) + sVar.w;
        }
        n(cyVar, iMin);
    }

    private void cy(View view) {
        for (int i = this.rv - 1; i >= 0; i--) {
            this.n[i].qg(view);
        }
    }

    private void hd(View view) {
        for (int i = this.rv - 1; i >= 0; i--) {
            this.n[i].n(view);
        }
    }

    private void n(int i, int i2) {
        for (int i3 = 0; i3 < this.rv; i3++) {
            if (!this.n[i3].n.isEmpty()) {
                n(this.n[i3], i, i2);
            }
        }
    }

    private void n(w wVar, int i, int i2) {
        int iRv = wVar.rv();
        if (i == -1) {
            if (wVar.qg() + iRv <= i2) {
                this.oa.set(wVar.l, false);
            }
        } else if (wVar.q() - iRv >= i2) {
            this.oa.set(wVar.l, false);
        }
    }

    private int k(int i) {
        int iN = this.n[0].n(i);
        for (int i2 = 1; i2 < this.rv; i2++) {
            int iN2 = this.n[i2].n(i);
            if (iN2 > iN) {
                iN = iN2;
            }
        }
        return iN;
    }

    private int cy(int i) {
        int iN = this.n[0].n(i);
        for (int i2 = 1; i2 < this.rv; i2++) {
            int iN2 = this.n[i2].n(i);
            if (iN2 < iN) {
                iN = iN2;
            }
        }
        return iN;
    }

    public boolean tj() {
        int iQg = this.n[0].qg(Integer.MIN_VALUE);
        for (int i = 1; i < this.rv; i++) {
            if (this.n[i].qg(Integer.MIN_VALUE) != iQg) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        int iN = this.n[0].n(Integer.MIN_VALUE);
        for (int i = 1; i < this.rv; i++) {
            if (this.n[i].n(Integer.MIN_VALUE) != iN) {
                return false;
            }
        }
        return true;
    }

    private int hd(int i) {
        int iQg = this.n[0].qg(i);
        for (int i2 = 1; i2 < this.rv; i2++) {
            int iQg2 = this.n[i2].qg(i);
            if (iQg2 > iQg) {
                iQg = iQg2;
            }
        }
        return iQg;
    }

    private int cd(int i) {
        int iQg = this.n[0].qg(i);
        for (int i2 = 1; i2 < this.rv; i2++) {
            int iQg2 = this.n[i2].qg(i);
            if (iQg2 < iQg) {
                iQg = iQg2;
            }
        }
        return iQg;
    }

    private void n(RecyclerView.cy cyVar, int i) {
        while (py() > 0) {
            View viewRv = rv(0);
            if (this.qg.qg(viewRv) > i || this.qg.s(viewRv) > i) {
                return;
            }
            qg qgVar = (qg) viewRv.getLayoutParams();
            if (qgVar.qg) {
                for (int i2 = 0; i2 < this.rv; i2++) {
                    if (this.n[i2].n.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.rv; i3++) {
                    this.n[i3].fs();
                }
            } else if (qgVar.n.n.size() == 1) {
                return;
            } else {
                qgVar.n.fs();
            }
            n(viewRv, cyVar);
        }
    }

    private void qg(RecyclerView.cy cyVar, int i) {
        for (int iPy = py() - 1; iPy >= 0; iPy--) {
            View viewRv = rv(iPy);
            if (this.qg.n(viewRv) < i || this.qg.q(viewRv) < i) {
                return;
            }
            qg qgVar = (qg) viewRv.getLayoutParams();
            if (qgVar.qg) {
                for (int i2 = 0; i2 < this.rv; i2++) {
                    if (this.n[i2].n.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.rv; i3++) {
                    this.n[i3].x();
                }
            } else if (qgVar.n.n.size() == 1) {
                return;
            } else {
                qgVar.n.x();
            }
            n(viewRv, cyVar);
        }
    }

    private boolean um(int i) {
        if (this.tj == 0) {
            return (i == -1) != this.l;
        }
        return ((i == -1) == this.l) == rv();
    }

    private w n(s sVar) {
        int i;
        int i2;
        int i3;
        if (um(sVar.l)) {
            i2 = this.rv - 1;
            i = -1;
            i3 = -1;
        } else {
            i = this.rv;
            i2 = 0;
            i3 = 1;
        }
        w wVar = null;
        if (sVar.l == 1) {
            int iS = this.qg.s();
            int i4 = Integer.MAX_VALUE;
            while (i2 != i) {
                w wVar2 = this.n[i2];
                int iQg = wVar2.qg(iS);
                if (iQg < i4) {
                    wVar = wVar2;
                    i4 = iQg;
                }
                i2 += i3;
            }
            return wVar;
        }
        int iQ = this.qg.q();
        int i5 = Integer.MIN_VALUE;
        while (i2 != i) {
            w wVar3 = this.n[i2];
            int iN = wVar3.n(iQ);
            if (iN > i5) {
                wVar = wVar3;
                i5 = iN;
            }
            i2 += i3;
        }
        return wVar;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean l() {
        return this.tj == 1;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean q() {
        return this.tj == 0;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int n(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return s(i, cyVar, pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int qg(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return s(i, cyVar, pyVar);
    }

    private int a(int i) {
        if (py() == 0) {
            return this.l ? 1 : -1;
        }
        return (i < fi()) != this.l ? -1 : 1;
    }

    @Override // com.byazt.prf.RecyclerView.a.qg
    public PointF q(int i) {
        int iA = a(i);
        PointF pointF = new PointF();
        if (iA == 0) {
            return null;
        }
        if (this.tj == 0) {
            pointF.x = iA;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iA;
        }
        return pointF;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, RecyclerView.py pyVar, int i) {
        x xVar = new x(recyclerView.getContext());
        xVar.s(i);
        n(xVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void l(int i) {
        l lVar = this.t;
        if (lVar != null && lVar.n != i) {
            this.t.qg();
        }
        this.w = i;
        this.x = Integer.MIN_VALUE;
        sz();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(int i, int i2, RecyclerView.py pyVar, RecyclerView.rv.n nVar) {
        int iQg;
        int iN;
        if (this.tj != 0) {
            i = i2;
        }
        if (py() == 0 || i == 0) {
            return;
        }
        n(i, pyVar);
        int[] iArr = this.j;
        if (iArr == null || iArr.length < this.rv) {
            this.j = new int[this.rv];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.rv; i4++) {
            if (this.d.q == -1) {
                iQg = this.d.w;
                iN = this.n[i4].n(this.d.w);
            } else {
                iQg = this.n[i4].qg(this.d.x);
                iN = this.d.x;
            }
            int i5 = iQg - iN;
            if (i5 >= 0) {
                this.j[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.j, 0, i3);
        for (int i6 = 0; i6 < i3 && this.d.n(pyVar); i6++) {
            nVar.qg(this.d.s, this.j[i6]);
            this.d.s += this.d.q;
        }
    }

    public void n(int i, RecyclerView.py pyVar) {
        int iFi;
        int i2;
        if (i > 0) {
            iFi = oa();
            i2 = 1;
        } else {
            iFi = fi();
            i2 = -1;
        }
        this.d.n = true;
        qg(iFi, pyVar);
        w(i2);
        s sVar = this.d;
        sVar.s = iFi + sVar.q;
        this.d.qg = Math.abs(i);
    }

    public int s(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        if (py() == 0 || i == 0) {
            return 0;
        }
        n(i, pyVar);
        int iN = n(cyVar, this.d, pyVar);
        if (this.d.qg >= iN) {
            i = i < 0 ? -iN : iN;
        }
        this.qg.n(-i);
        this.k = this.l;
        this.d.qg = 0;
        n(cyVar, this.d);
        return i;
    }

    public int oa() {
        int iPy = py();
        if (iPy == 0) {
            return 0;
        }
        return q(rv(iPy - 1));
    }

    public int fi() {
        if (py() == 0) {
            return 0;
        }
        return q(rv(0));
    }

    private int py(int i) {
        int iPy = py();
        for (int i2 = 0; i2 < iPy; i2++) {
            int iQ = q(rv(i2));
            if (iQ >= 0 && iQ < i) {
                return iQ;
            }
        }
        return 0;
    }

    private int ou(int i) {
        for (int iPy = py() - 1; iPy >= 0; iPy--) {
            int iQ = q(rv(iPy));
            if (iQ >= 0 && iQ < i) {
                return iQ;
            }
        }
        return 0;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public RecyclerView.tj n() {
        if (this.tj == 0) {
            return new qg(-2, -1);
        }
        return new qg(-1, -2);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public RecyclerView.tj n(Context context, AttributeSet attributeSet) {
        return new qg(context, attributeSet);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public RecyclerView.tj n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new qg((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new qg(layoutParams);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean n(RecyclerView.tj tjVar) {
        return tjVar instanceof qg;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public View n(View view, int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        View viewL;
        int iFi;
        int iD;
        int iD2;
        int iD3;
        View viewN;
        if (py() == 0 || (viewL = l(view)) == null) {
            return null;
        }
        oj();
        int iWm = wm(i);
        if (iWm == Integer.MIN_VALUE) {
            return null;
        }
        qg qgVar = (qg) viewL.getLayoutParams();
        boolean z = qgVar.qg;
        w wVar = qgVar.n;
        if (iWm == 1) {
            iFi = oa();
        } else {
            iFi = fi();
        }
        qg(iFi, pyVar);
        w(iWm);
        s sVar = this.d;
        sVar.s = sVar.q + iFi;
        this.d.qg = (int) (this.qg.w() * 0.33333334f);
        this.d.fs = true;
        this.d.n = false;
        n(cyVar, this.d, pyVar);
        this.k = this.l;
        if (!z && (viewN = wVar.n(iFi, iWm)) != null && viewN != viewL) {
            return viewN;
        }
        if (um(iWm)) {
            for (int i2 = this.rv - 1; i2 >= 0; i2--) {
                View viewN2 = this.n[i2].n(iFi, iWm);
                if (viewN2 != null && viewN2 != viewL) {
                    return viewN2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.rv; i3++) {
                View viewN3 = this.n[i3].n(iFi, iWm);
                if (viewN3 != null && viewN3 != viewL) {
                    return viewN3;
                }
            }
        }
        boolean z2 = (this.q ^ true) == (iWm == -1);
        if (!z) {
            if (z2) {
                iD3 = wVar.tj();
            } else {
                iD3 = wVar.d();
            }
            View viewS = s(iD3);
            if (viewS != null && viewS != viewL) {
                return viewS;
            }
        }
        if (um(iWm)) {
            for (int i4 = this.rv - 1; i4 >= 0; i4--) {
                if (i4 != wVar.l) {
                    if (z2) {
                        iD2 = this.n[i4].tj();
                    } else {
                        iD2 = this.n[i4].d();
                    }
                    View viewS2 = s(iD2);
                    if (viewS2 != null && viewS2 != viewL) {
                        return viewS2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.rv; i5++) {
                if (z2) {
                    iD = this.n[i5].tj();
                } else {
                    iD = this.n[i5].d();
                }
                View viewS3 = s(iD);
                if (viewS3 != null && viewS3 != viewL) {
                    return viewS3;
                }
            }
        }
        return null;
    }

    private int wm(int i) {
        if (i == 1) {
            return (this.tj != 1 && rv()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.tj != 1 && rv()) ? -1 : 1;
        }
        if (i == 17) {
            return this.tj == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.tj == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.tj == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.tj == 0 ? 1 : Integer.MIN_VALUE;
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2156})
    public static class qg extends RecyclerView.tj {
        public w n;
        public boolean qg;

        public qg(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public qg(int i, int i2) {
            super(i, i2);
        }

        public qg(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public qg(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean n() {
            return this.qg;
        }

        public final int qg() {
            w wVar = this.n;
            if (wVar == null) {
                return -1;
            }
            return wVar.l;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1751})
    class w {
        public final int l;
        public ArrayList<View> n = new ArrayList<>();
        public int qg = Integer.MIN_VALUE;
        public int s = Integer.MIN_VALUE;
        public int q = 0;

        public w(int i) {
            this.l = i;
        }

        public int n(int i) {
            int i2 = this.qg;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.n.size() == 0) {
                return i;
            }
            n();
            return this.qg;
        }

        public void n() {
            q.n nVarW;
            View view = this.n.get(0);
            qg qgVarS = s(view);
            this.qg = sz.this.qg.n(view);
            if (qgVarS.qg && (nVarW = sz.this.fs.w(qgVarS.w())) != null && nVarW.qg == -1) {
                this.qg -= nVarW.n(this.l);
            }
        }

        public int qg() {
            int i = this.qg;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            n();
            return this.qg;
        }

        public int qg(int i) {
            int i2 = this.s;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.n.size() == 0) {
                return i;
            }
            s();
            return this.s;
        }

        public void s() {
            q.n nVarW;
            ArrayList<View> arrayList = this.n;
            View view = arrayList.get(arrayList.size() - 1);
            qg qgVarS = s(view);
            this.s = sz.this.qg.qg(view);
            if (qgVarS.qg && (nVarW = sz.this.fs.w(qgVarS.w())) != null && nVarW.qg == 1) {
                this.s += nVarW.n(this.l);
            }
        }

        public int q() {
            int i = this.s;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            s();
            return this.s;
        }

        public void n(View view) {
            qg qgVarS = s(view);
            qgVarS.n = this;
            this.n.add(0, view);
            this.qg = Integer.MIN_VALUE;
            if (this.n.size() == 1) {
                this.s = Integer.MIN_VALUE;
            }
            if (qgVarS.q() || qgVarS.l()) {
                this.q += sz.this.qg.l(view);
            }
        }

        public void qg(View view) {
            qg qgVarS = s(view);
            qgVarS.n = this;
            this.n.add(view);
            this.s = Integer.MIN_VALUE;
            if (this.n.size() == 1) {
                this.qg = Integer.MIN_VALUE;
            }
            if (qgVarS.q() || qgVarS.l()) {
                this.q += sz.this.qg.l(view);
            }
        }

        public void n(boolean z, int i) {
            int iN;
            if (z) {
                iN = qg(Integer.MIN_VALUE);
            } else {
                iN = n(Integer.MIN_VALUE);
            }
            l();
            if (iN == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iN >= sz.this.qg.q()) {
                if (z || iN <= sz.this.qg.s()) {
                    if (i != Integer.MIN_VALUE) {
                        iN += i;
                    }
                    this.s = iN;
                    this.qg = iN;
                }
            }
        }

        public void l() {
            this.n.clear();
            w();
            this.q = 0;
        }

        public void w() {
            this.qg = Integer.MIN_VALUE;
            this.s = Integer.MIN_VALUE;
        }

        public void s(int i) {
            this.qg = i;
            this.s = i;
        }

        public void x() {
            int size = this.n.size();
            View viewRemove = this.n.remove(size - 1);
            qg qgVarS = s(viewRemove);
            qgVarS.n = null;
            if (qgVarS.q() || qgVarS.l()) {
                this.q -= sz.this.qg.l(viewRemove);
            }
            if (size == 1) {
                this.qg = Integer.MIN_VALUE;
            }
            this.s = Integer.MIN_VALUE;
        }

        public void fs() {
            View viewRemove = this.n.remove(0);
            qg qgVarS = s(viewRemove);
            qgVarS.n = null;
            if (this.n.size() == 0) {
                this.s = Integer.MIN_VALUE;
            }
            if (qgVarS.q() || qgVarS.l()) {
                this.q -= sz.this.qg.l(viewRemove);
            }
            this.qg = Integer.MIN_VALUE;
        }

        public int rv() {
            return this.q;
        }

        public qg s(View view) {
            return (qg) view.getLayoutParams();
        }

        public void q(int i) {
            int i2 = this.qg;
            if (i2 != Integer.MIN_VALUE) {
                this.qg = i2 + i;
            }
            int i3 = this.s;
            if (i3 != Integer.MIN_VALUE) {
                this.s = i3 + i;
            }
        }

        public int tj() {
            if (sz.this.q) {
                return qg(this.n.size() - 1, -1, true);
            }
            return qg(0, this.n.size(), true);
        }

        public int cp() {
            if (sz.this.q) {
                return n(0, this.n.size(), false);
            }
            return n(this.n.size() - 1, -1, false);
        }

        public int d() {
            if (sz.this.q) {
                return qg(0, this.n.size(), true);
            }
            return qg(this.n.size() - 1, -1, true);
        }

        public int n(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iS = sz.this.qg.s();
            int iQ = sz.this.qg.q();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.n.get(i);
                int iN = sz.this.qg.n(view);
                int iQg = sz.this.qg.qg(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iN >= iQ : iN > iQ;
                if (!z3 ? iQg > iS : iQg >= iS) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iN >= iS && iQg <= iQ) {
                            return sz.this.q(view);
                        }
                    } else {
                        if (z2) {
                            return sz.this.q(view);
                        }
                        if (iN < iS || iQg > iQ) {
                            return sz.this.q(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        public int n(int i, int i2, boolean z) {
            return n(i, i2, z, true, false);
        }

        public int qg(int i, int i2, boolean z) {
            return n(i, i2, false, false, z);
        }

        public View n(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.n.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.n.get(i3);
                    if ((sz.this.q && sz.this.q(view2) <= i) || ((!sz.this.q && sz.this.q(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.n.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.n.get(size2);
                    if ((sz.this.q && sz.this.q(view3) >= i) || ((!sz.this.q && sz.this.q(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1754})
    static class q {
        public int[] n;
        public List<n> qg;

        public int n(int i) {
            List<n> list = this.qg;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.qg.get(size).n >= i) {
                        this.qg.remove(size);
                    }
                }
            }
            return qg(i);
        }

        public int qg(int i) {
            int[] iArr = this.n;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int iX = x(i);
            if (iX == -1) {
                int[] iArr2 = this.n;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.n.length;
            }
            int i2 = iX + 1;
            Arrays.fill(this.n, i, i2, -1);
            return i2;
        }

        public int s(int i) {
            int[] iArr = this.n;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        public void n(int i, w wVar) {
            l(i);
            this.n[i] = wVar.l;
        }

        public int q(int i) {
            int length = this.n.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        public void l(int i) {
            int[] iArr = this.n;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.n = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[q(i)];
                this.n = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.n;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public void n() {
            int[] iArr = this.n;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.qg = null;
        }

        public void n(int i, int i2) {
            int[] iArr = this.n;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            l(i3);
            int[] iArr2 = this.n;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.n;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            s(i, i2);
        }

        private void s(int i, int i2) {
            List<n> list = this.qg;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                n nVar = this.qg.get(size);
                if (nVar.n >= i) {
                    if (nVar.n < i3) {
                        this.qg.remove(size);
                    } else {
                        nVar.n -= i2;
                    }
                }
            }
        }

        public void qg(int i, int i2) {
            int[] iArr = this.n;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            l(i3);
            int[] iArr2 = this.n;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.n, i, i3, -1);
            q(i, i2);
        }

        private void q(int i, int i2) {
            List<n> list = this.qg;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                n nVar = this.qg.get(size);
                if (nVar.n >= i) {
                    nVar.n += i2;
                }
            }
        }

        private int x(int i) {
            if (this.qg == null) {
                return -1;
            }
            n nVarW = w(i);
            if (nVarW != null) {
                this.qg.remove(nVarW);
            }
            int size = this.qg.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.qg.get(i2).n >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            n nVar = this.qg.get(i2);
            this.qg.remove(i2);
            return nVar.n;
        }

        public void n(n nVar) {
            if (this.qg == null) {
                this.qg = new ArrayList();
            }
            int size = this.qg.size();
            for (int i = 0; i < size; i++) {
                n nVar2 = this.qg.get(i);
                if (nVar2.n == nVar.n) {
                    this.qg.remove(i);
                }
                if (nVar2.n >= nVar.n) {
                    this.qg.add(i, nVar);
                    return;
                }
            }
            this.qg.add(nVar);
        }

        public n w(int i) {
            List<n> list = this.qg;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                n nVar = this.qg.get(size);
                if (nVar.n == i) {
                    return nVar;
                }
            }
            return null;
        }

        public n n(int i, int i2, int i3, boolean z) {
            List<n> list = this.qg;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                n nVar = this.qg.get(i4);
                if (nVar.n >= i2) {
                    return null;
                }
                if (nVar.n >= i && (i3 == 0 || nVar.qg == i3 || (z && nVar.q))) {
                    return nVar;
                }
            }
            return null;
        }

        @com.byazt.cp.n(n = {0, 1, 102, 2096})
        static class n implements Parcelable {
            public static final Parcelable.Creator<n> CREATOR = new Parcelable.Creator<n>() { // from class: com.byazt.prf.sz.q.n.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public n createFromParcel(Parcel parcel) {
                    return new n(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public n[] newArray(int i) {
                    return new n[i];
                }
            };
            public int n;
            public boolean q;
            public int qg;
            public int[] s;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public n(Parcel parcel) {
                this.n = parcel.readInt();
                this.qg = parcel.readInt();
                this.q = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.s = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public n() {
            }

            public int n(int i) {
                int[] iArr = this.s;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.n);
                parcel.writeInt(this.qg);
                parcel.writeInt(this.q ? 1 : 0);
                int[] iArr = this.s;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.s);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.n + ", mGapDir=" + this.qg + ", mHasUnwantedGapAfter=" + this.q + ", mGapPerSpan=" + Arrays.toString(this.s) + AbstractJsonLexerKt.END_OBJ;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1749})
    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: com.byazt.prf.sz.l.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i) {
                return new l[i];
            }
        };
        public boolean fs;
        public int l;
        public int n;
        public int[] q;
        public int qg;
        public boolean rv;
        public int s;
        public boolean tj;
        public int[] w;
        public List<q.n> x;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public l() {
        }

        public l(Parcel parcel) {
            this.n = parcel.readInt();
            this.qg = parcel.readInt();
            int i = parcel.readInt();
            this.s = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.q = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.l = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.w = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.fs = parcel.readInt() == 1;
            this.rv = parcel.readInt() == 1;
            this.tj = parcel.readInt() == 1;
            this.x = parcel.readArrayList(q.n.class.getClassLoader());
        }

        public void n() {
            this.q = null;
            this.s = 0;
            this.l = 0;
            this.w = null;
            this.x = null;
        }

        public void qg() {
            this.q = null;
            this.s = 0;
            this.n = -1;
            this.qg = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.n);
            parcel.writeInt(this.qg);
            parcel.writeInt(this.s);
            if (this.s > 0) {
                parcel.writeIntArray(this.q);
            }
            parcel.writeInt(this.l);
            if (this.l > 0) {
                parcel.writeIntArray(this.w);
            }
            parcel.writeInt(this.fs ? 1 : 0);
            parcel.writeInt(this.rv ? 1 : 0);
            parcel.writeInt(this.tj ? 1 : 0);
            parcel.writeList(this.x);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1222})
    class n {
        public boolean l;
        public int n;
        public boolean q;
        public int qg;
        public boolean s;
        public int[] w;

        public n() {
            n();
        }

        public void n() {
            this.n = -1;
            this.qg = Integer.MIN_VALUE;
            this.s = false;
            this.q = false;
            this.l = false;
            int[] iArr = this.w;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void n(w[] wVarArr) {
            int length = wVarArr.length;
            int[] iArr = this.w;
            if (iArr == null || iArr.length < length) {
                this.w = new int[sz.this.n.length];
            }
            for (int i = 0; i < length; i++) {
                this.w[i] = wVarArr[i].n(Integer.MIN_VALUE);
            }
        }

        public void qg() {
            this.qg = this.s ? sz.this.qg.q() : sz.this.qg.s();
        }

        public void n(int i) {
            if (this.s) {
                this.qg = sz.this.qg.q() - i;
            } else {
                this.qg = sz.this.qg.s() + i;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1752})
    private static class s {
        public boolean fs;
        public int l;
        public boolean n;
        public int q;
        public int qg;
        public boolean rv;
        public int s;
        public int w;
        public int x;

        private s() {
            this.n = true;
            this.w = 0;
            this.x = 0;
        }

        public boolean n(RecyclerView.py pyVar) {
            int i = this.s;
            return i >= 0 && i < pyVar.l();
        }

        public View n(RecyclerView.cy cyVar) {
            View viewS = cyVar.s(this.s);
            this.s += this.q;
            return viewS;
        }
    }
}
