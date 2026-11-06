package com.byazt.prf;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 13})
public class w extends RecyclerView.rv implements RecyclerView.a.qg {
    public boolean cp;
    public int d;
    public int fs;
    public final n k;
    public boolean l;
    public s n;
    public int oa;
    public boolean q;
    public boolean qg;
    public int rv;
    public boolean s;
    public q sz;
    public rv tj;
    public boolean w;
    public final qg x;

    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, n nVar, int i) {
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean s() {
        return true;
    }

    public w(Context context) {
        this(context, 1, false);
    }

    public w(Context context, int i, boolean z) {
        this.rv = 1;
        this.s = false;
        this.cp = false;
        this.q = false;
        this.l = true;
        this.d = -1;
        this.oa = Integer.MIN_VALUE;
        this.sz = null;
        this.k = new n();
        this.x = new qg();
        this.fs = 2;
        qg(i);
        n(z);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public RecyclerView.tj n() {
        return new RecyclerView.tj(-2, -2);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, RecyclerView.cy cyVar) {
        super.n(recyclerView, cyVar);
        if (this.w) {
            s(cyVar);
            cyVar.n();
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean q() {
        return this.rv == 0;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean l() {
        return this.rv == 1;
    }

    public int w() {
        return this.rv;
    }

    public void qg(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        n((String) null);
        if (i != this.rv || this.tj == null) {
            rv rvVarN = rv.n(this, i);
            this.tj = rvVarN;
            this.k.n = rvVarN;
            this.rv = i;
            sz();
        }
    }

    private void fi() {
        if (this.rv != 1 && x()) {
            this.cp = !this.s;
        } else {
            this.cp = this.s;
        }
    }

    public void n(boolean z) {
        n((String) null);
        if (z != this.s) {
            this.s = z;
            sz();
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public View s(int i) {
        int iPy = py();
        if (iPy == 0) {
            return null;
        }
        int iQ = i - q(rv(0));
        if (iQ >= 0 && iQ < iPy) {
            View viewRv = rv(iQ);
            if (q(viewRv) == i) {
                return viewRv;
            }
        }
        return super.s(i);
    }

    public int qg(RecyclerView.py pyVar) {
        if (pyVar.q()) {
            return this.tj.w();
        }
        return 0;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, RecyclerView.py pyVar, int i) {
        x xVar = new x(recyclerView.getContext());
        xVar.s(i);
        n(xVar);
    }

    @Override // com.byazt.prf.RecyclerView.a.qg
    public PointF q(int i) {
        if (py() == 0) {
            return null;
        }
        int i2 = (i < q(rv(0))) != this.cp ? -1 : 1;
        return this.rv == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iN;
        int i6;
        View viewS;
        int iN2;
        int iQ;
        int i7 = -1;
        if ((this.sz != null || this.d != -1) && pyVar.l() == 0) {
            s(cyVar);
            return;
        }
        q qVar = this.sz;
        if (qVar != null && qVar.n()) {
            this.d = this.sz.n;
        }
        fs();
        this.n.n = false;
        fi();
        View viewLn = ln();
        if (this.k.l && this.d == -1 && this.sz == null) {
            if (viewLn != null && (this.tj.n(viewLn) >= this.tj.q() || this.tj.qg(viewLn) <= this.tj.s())) {
                this.k.n(viewLn, q(viewLn));
            }
        } else {
            this.k.n();
            this.k.q = this.cp ^ this.q;
            n(cyVar, pyVar, this.k);
            this.k.l = true;
        }
        int iQg = qg(pyVar);
        if (this.n.tj >= 0) {
            i = iQg;
            iQg = 0;
        } else {
            i = 0;
        }
        int iS = iQg + this.tj.s();
        int iX = i + this.tj.x();
        if (pyVar.n() && (i6 = this.d) != -1 && this.oa != Integer.MIN_VALUE && (viewS = s(i6)) != null) {
            if (this.cp) {
                iQ = this.tj.q() - this.tj.qg(viewS);
                iN2 = this.oa;
            } else {
                iN2 = this.tj.n(viewS) - this.tj.s();
                iQ = this.oa;
            }
            int i8 = iQ - iN2;
            if (i8 > 0) {
                iS += i8;
            } else {
                iX -= i8;
            }
        }
        if (!this.k.q ? !this.cp : this.cp) {
            i7 = 1;
        }
        n(cyVar, pyVar, this.k, i7);
        n(cyVar);
        this.n.d = tj();
        this.n.rv = pyVar.n();
        if (this.k.q) {
            qg(this.k);
            this.n.fs = iS;
            n(cyVar, this.n, pyVar, false);
            i3 = this.n.qg;
            int i9 = this.n.q;
            if (this.n.s > 0) {
                iX += this.n.s;
            }
            n(this.k);
            this.n.fs = iX;
            this.n.q += this.n.l;
            n(cyVar, this.n, pyVar, false);
            i2 = this.n.qg;
            if (this.n.s > 0) {
                int i10 = this.n.s;
                x(i9, i3);
                this.n.fs = i10;
                n(cyVar, this.n, pyVar, false);
                i3 = this.n.qg;
            }
        } else {
            n(this.k);
            this.n.fs = iX;
            n(cyVar, this.n, pyVar, false);
            i2 = this.n.qg;
            int i11 = this.n.q;
            if (this.n.s > 0) {
                iS += this.n.s;
            }
            qg(this.k);
            this.n.fs = iS;
            this.n.q += this.n.l;
            n(cyVar, this.n, pyVar, false);
            i3 = this.n.qg;
            if (this.n.s > 0) {
                int i12 = this.n.s;
                n(i11, i2);
                this.n.fs = i12;
                n(cyVar, this.n, pyVar, false);
                i2 = this.n.qg;
            }
        }
        if (py() > 0) {
            if (this.cp ^ this.q) {
                int iN3 = n(i2, cyVar, pyVar, true);
                i4 = i3 + iN3;
                i5 = i2 + iN3;
                iN = qg(i4, cyVar, pyVar, false);
            } else {
                int iQg2 = qg(i3, cyVar, pyVar, true);
                i4 = i3 + iQg2;
                i5 = i2 + iQg2;
                iN = n(i5, cyVar, pyVar, false);
            }
            i3 = i4 + iN;
            i2 = i5 + iN;
        }
        qg(cyVar, pyVar, i3, i2);
        if (!pyVar.n()) {
            this.tj.n();
        } else {
            this.k.n();
        }
        this.qg = this.q;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView.py pyVar) {
        super.n(pyVar);
        this.sz = null;
        this.d = -1;
        this.oa = Integer.MIN_VALUE;
        this.k.n();
    }

    private void qg(RecyclerView.cy cyVar, RecyclerView.py pyVar, int i, int i2) {
        if (!pyVar.qg() || py() == 0 || pyVar.n() || !qg()) {
            return;
        }
        List<RecyclerView.m> listS = cyVar.s();
        int size = listS.size();
        int iQ = q(rv(0));
        int iL = 0;
        int iL2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.m mVar = listS.get(i3);
            if (!mVar.hd()) {
                if (((mVar.q() < iQ) != this.cp ? (byte) -1 : (byte) 1) == -1) {
                    iL += this.tj.l(mVar.n);
                } else {
                    iL2 += this.tj.l(mVar.n);
                }
            }
        }
        this.n.cp = listS;
        if (iL > 0) {
            x(q(df()), i);
            this.n.fs = iL;
            this.n.s = 0;
            this.n.n();
            n(cyVar, this.n, pyVar, false);
        }
        if (iL2 > 0) {
            n(q(oj()), i2);
            this.n.fs = iL2;
            this.n.s = 0;
            this.n.n();
            n(cyVar, this.n, pyVar, false);
        }
        this.n.cp = null;
    }

    private void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, n nVar) {
        if (n(pyVar, nVar) || qg(cyVar, pyVar, nVar)) {
            return;
        }
        nVar.qg();
        nVar.qg = this.q ? pyVar.l() - 1 : 0;
    }

    private boolean qg(RecyclerView.cy cyVar, RecyclerView.py pyVar, n nVar) {
        if (py() == 0) {
            return false;
        }
        View viewLn = ln();
        if (viewLn != null && nVar.n(viewLn, pyVar)) {
            nVar.n(viewLn, q(viewLn));
            return true;
        }
        if (this.qg != this.q) {
            return false;
        }
        View viewQg = nVar.q ? qg(cyVar, pyVar) : s(cyVar, pyVar);
        if (viewQg == null) {
            return false;
        }
        nVar.qg(viewQg, q(viewQg));
        if (!pyVar.n() && qg()) {
            if (this.tj.n(viewQg) >= this.tj.q() || this.tj.qg(viewQg) < this.tj.s()) {
                nVar.s = nVar.q ? this.tj.q() : this.tj.s();
            }
        }
        return true;
    }

    private boolean n(RecyclerView.py pyVar, n nVar) {
        int i;
        if (!pyVar.n() && (i = this.d) != -1) {
            if (i >= 0 && i < pyVar.l()) {
                nVar.qg = this.d;
                q qVar = this.sz;
                if (qVar != null && qVar.n()) {
                    nVar.q = this.sz.s;
                    if (nVar.q) {
                        nVar.s = this.tj.q() - this.sz.qg;
                    } else {
                        nVar.s = this.tj.s() + this.sz.qg;
                    }
                    return true;
                }
                if (this.oa == Integer.MIN_VALUE) {
                    View viewS = s(this.d);
                    if (viewS != null) {
                        if (this.tj.l(viewS) > this.tj.w()) {
                            nVar.qg();
                            return true;
                        }
                        if (this.tj.n(viewS) - this.tj.s() < 0) {
                            nVar.s = this.tj.s();
                            nVar.q = false;
                            return true;
                        }
                        if (this.tj.q() - this.tj.qg(viewS) < 0) {
                            nVar.s = this.tj.q();
                            nVar.q = true;
                            return true;
                        }
                        nVar.s = nVar.q ? this.tj.qg(viewS) + this.tj.qg() : this.tj.n(viewS);
                    } else {
                        if (py() > 0) {
                            nVar.q = (this.d < q(rv(0))) == this.cp;
                        }
                        nVar.qg();
                    }
                    return true;
                }
                nVar.q = this.cp;
                if (this.cp) {
                    nVar.s = this.tj.q() - this.oa;
                } else {
                    nVar.s = this.tj.s() + this.oa;
                }
                return true;
            }
            this.d = -1;
            this.oa = Integer.MIN_VALUE;
        }
        return false;
    }

    private int n(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar, boolean z) {
        int iQ;
        int iQ2 = this.tj.q() - i;
        if (iQ2 <= 0) {
            return 0;
        }
        int i2 = -s(-iQ2, cyVar, pyVar);
        int i3 = i + i2;
        if (!z || (iQ = this.tj.q() - i3) <= 0) {
            return i2;
        }
        this.tj.n(iQ);
        return iQ + i2;
    }

    private int qg(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar, boolean z) {
        int iS;
        int iS2 = i - this.tj.s();
        if (iS2 <= 0) {
            return 0;
        }
        int i2 = -s(iS2, cyVar, pyVar);
        int i3 = i + i2;
        if (!z || (iS = i3 - this.tj.s()) <= 0) {
            return i2;
        }
        this.tj.n(-iS);
        return i2 - iS;
    }

    private void n(n nVar) {
        n(nVar.qg, nVar.s);
    }

    private void n(int i, int i2) {
        this.n.s = this.tj.q() - i2;
        this.n.l = this.cp ? -1 : 1;
        this.n.q = i;
        this.n.w = 1;
        this.n.qg = i2;
        this.n.x = Integer.MIN_VALUE;
    }

    private void qg(n nVar) {
        x(nVar.qg, nVar.s);
    }

    private void x(int i, int i2) {
        this.n.s = i2 - this.tj.s();
        this.n.q = i;
        this.n.l = this.cp ? 1 : -1;
        this.n.w = -1;
        this.n.qg = i2;
        this.n.x = Integer.MIN_VALUE;
    }

    public boolean x() {
        return um() == 1;
    }

    public void fs() {
        if (this.n == null) {
            this.n = rv();
        }
    }

    public s rv() {
        return new s();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void l(int i) {
        this.d = i;
        this.oa = Integer.MIN_VALUE;
        q qVar = this.sz;
        if (qVar != null) {
            qVar.qg();
        }
        sz();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int n(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        if (this.rv == 1) {
            return 0;
        }
        return s(i, cyVar, pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int qg(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        if (this.rv == 0) {
            return 0;
        }
        return s(i, cyVar, pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int s(RecyclerView.py pyVar) {
        return rv(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int q(RecyclerView.py pyVar) {
        return rv(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int l(RecyclerView.py pyVar) {
        return tj(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int w(RecyclerView.py pyVar) {
        return tj(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int x(RecyclerView.py pyVar) {
        return cp(pyVar);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public int fs(RecyclerView.py pyVar) {
        return cp(pyVar);
    }

    private int rv(RecyclerView.py pyVar) {
        if (py() == 0) {
            return 0;
        }
        fs();
        return cp.n(pyVar, this.tj, n(!this.l, true), qg(!this.l, true), this, this.l, this.cp);
    }

    private int tj(RecyclerView.py pyVar) {
        if (py() == 0) {
            return 0;
        }
        fs();
        return cp.n(pyVar, this.tj, n(!this.l, true), qg(!this.l, true), this, this.l);
    }

    private int cp(RecyclerView.py pyVar) {
        if (py() == 0) {
            return 0;
        }
        fs();
        return cp.qg(pyVar, this.tj, n(!this.l, true), qg(!this.l, true), this, this.l);
    }

    private void n(int i, int i2, boolean z, RecyclerView.py pyVar) {
        int iS;
        this.n.d = tj();
        this.n.fs = qg(pyVar);
        this.n.w = i;
        if (i == 1) {
            this.n.fs += this.tj.x();
            View viewOj = oj();
            this.n.l = this.cp ? -1 : 1;
            this.n.q = q(viewOj) + this.n.l;
            this.n.qg = this.tj.qg(viewOj);
            iS = this.tj.qg(viewOj) - this.tj.q();
        } else {
            View viewDf = df();
            this.n.fs += this.tj.s();
            this.n.l = this.cp ? 1 : -1;
            this.n.q = q(viewDf) + this.n.l;
            this.n.qg = this.tj.n(viewDf);
            iS = (-this.tj.n(viewDf)) + this.tj.s();
        }
        this.n.s = i2;
        if (z) {
            this.n.s -= iS;
        }
        this.n.x = iS;
    }

    public boolean tj() {
        return this.tj.fs() == 0 && this.tj.l() == 0;
    }

    public void n(RecyclerView.py pyVar, s sVar, RecyclerView.rv.n nVar) {
        int i = sVar.q;
        if (i < 0 || i >= pyVar.l()) {
            return;
        }
        nVar.qg(i, Math.max(0, sVar.x));
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(int i, RecyclerView.rv.n nVar) {
        boolean z;
        int i2;
        q qVar = this.sz;
        if (qVar != null && qVar.n()) {
            z = this.sz.s;
            i2 = this.sz.n;
        } else {
            fi();
            z = this.cp;
            i2 = this.d;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.fs && i2 >= 0 && i2 < i; i4++) {
            nVar.qg(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(int i, int i2, RecyclerView.py pyVar, RecyclerView.rv.n nVar) {
        if (this.rv != 0) {
            i = i2;
        }
        if (py() == 0 || i == 0) {
            return;
        }
        fs();
        n(i > 0 ? 1 : -1, Math.abs(i), true, pyVar);
        n(pyVar, this.n, nVar);
    }

    public int s(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        if (py() == 0 || i == 0) {
            return 0;
        }
        this.n.n = true;
        fs();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        n(i2, iAbs, true, pyVar);
        int iN = this.n.x + n(cyVar, this.n, pyVar, false);
        if (iN < 0) {
            return 0;
        }
        if (iAbs > iN) {
            i = i2 * iN;
        }
        this.tj.n(-i);
        this.n.tj = i;
        return i;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(String str) {
        if (this.sz == null) {
            super.n(str);
        }
    }

    private void n(RecyclerView.cy cyVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    n(i, cyVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    n(i3, cyVar);
                }
            }
        }
    }

    private void n(RecyclerView.cy cyVar, int i) {
        if (i >= 0) {
            int iPy = py();
            if (!this.cp) {
                for (int i2 = 0; i2 < iPy; i2++) {
                    View viewRv = rv(i2);
                    if (this.tj.qg(viewRv) > i || this.tj.s(viewRv) > i) {
                        n(cyVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iPy - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewRv2 = rv(i4);
                if (this.tj.qg(viewRv2) > i || this.tj.s(viewRv2) > i) {
                    n(cyVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void qg(RecyclerView.cy cyVar, int i) {
        int iPy = py();
        if (i >= 0) {
            int iL = this.tj.l() - i;
            if (this.cp) {
                for (int i2 = 0; i2 < iPy; i2++) {
                    View viewRv = rv(i2);
                    if (this.tj.n(viewRv) < iL || this.tj.q(viewRv) < iL) {
                        n(cyVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iPy - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewRv2 = rv(i4);
                if (this.tj.n(viewRv2) < iL || this.tj.q(viewRv2) < iL) {
                    n(cyVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void n(RecyclerView.cy cyVar, s sVar) {
        if (!sVar.n || sVar.d) {
            return;
        }
        if (sVar.w == -1) {
            qg(cyVar, sVar.x);
        } else {
            n(cyVar, sVar.x);
        }
    }

    public int n(RecyclerView.cy cyVar, s sVar, RecyclerView.py pyVar, boolean z) {
        int i = sVar.s;
        if (sVar.x != Integer.MIN_VALUE) {
            if (sVar.s < 0) {
                sVar.x += sVar.s;
            }
            n(cyVar, sVar);
        }
        int i2 = sVar.s + sVar.fs;
        qg qgVar = this.x;
        while (true) {
            if ((!sVar.d && i2 <= 0) || !sVar.n(pyVar)) {
                break;
            }
            qgVar.n();
            n(cyVar, pyVar, sVar, qgVar);
            if (!qgVar.qg) {
                sVar.qg += qgVar.n * sVar.w;
                if (!qgVar.s || this.n.cp != null || !pyVar.n()) {
                    sVar.s -= qgVar.n;
                    i2 -= qgVar.n;
                }
                if (sVar.x != Integer.MIN_VALUE) {
                    sVar.x += qgVar.n;
                    if (sVar.s < 0) {
                        sVar.x += sVar.s;
                    }
                    n(cyVar, sVar);
                }
                if (z && qgVar.q) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - sVar.s;
    }

    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, s sVar, qg qgVar) {
        int i;
        int i2;
        int i3;
        int iH;
        int iW;
        View viewN = sVar.n(cyVar);
        if (viewN == null) {
            qgVar.qg = true;
            return;
        }
        RecyclerView.tj tjVar = (RecyclerView.tj) viewN.getLayoutParams();
        if (sVar.cp == null) {
            if (this.cp == (sVar.w == -1)) {
                qg(viewN);
            } else {
                qg(viewN, 0);
            }
        } else {
            if (this.cp == (sVar.w == -1)) {
                n(viewN);
            } else {
                n(viewN, 0);
            }
        }
        n(viewN, 0, 0);
        qgVar.n = this.tj.l(viewN);
        if (this.rv == 1) {
            if (x()) {
                iW = m() - ur();
                iH = iW - this.tj.w(viewN);
            } else {
                iH = h();
                iW = this.tj.w(viewN) + iH;
            }
            if (sVar.w == -1) {
                int i4 = sVar.qg;
                i2 = sVar.qg - qgVar.n;
                i = iW;
                i3 = i4;
            } else {
                int i5 = sVar.qg;
                i3 = sVar.qg + qgVar.n;
                i = iW;
                i2 = i5;
            }
        } else {
            int iT = t();
            int iW2 = this.tj.w(viewN) + iT;
            if (sVar.w == -1) {
                i2 = iT;
                i = sVar.qg;
                i3 = iW2;
                iH = sVar.qg - qgVar.n;
            } else {
                int i6 = sVar.qg;
                i = sVar.qg + qgVar.n;
                i2 = iT;
                i3 = iW2;
                iH = i6;
            }
        }
        n(viewN, iH, i2, i, i3);
        if (tjVar.q() || tjVar.l()) {
            qgVar.s = true;
        }
        qgVar.q = viewN.hasFocusable();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean cp() {
        return (wm() == 1073741824 || ou() == 1073741824 || !f()) ? false : true;
    }

    public int w(int i) {
        if (i == 1) {
            return (this.rv != 1 && x()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.rv != 1 && x()) ? -1 : 1;
        }
        if (i == 17) {
            return this.rv == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.rv == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.rv == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.rv == 0 ? 1 : Integer.MIN_VALUE;
    }

    private View df() {
        return rv(this.cp ? py() - 1 : 0);
    }

    private View oj() {
        return rv(this.cp ? 0 : py() - 1);
    }

    private View n(boolean z, boolean z2) {
        int iPy;
        int iPy2;
        if (this.cp) {
            iPy = py() - 1;
            iPy2 = -1;
        } else {
            iPy = 0;
            iPy2 = py();
        }
        return n(iPy, iPy2, z, z2);
    }

    private View qg(boolean z, boolean z2) {
        int iPy;
        int iPy2;
        if (this.cp) {
            iPy = 0;
            iPy2 = py();
        } else {
            iPy = py() - 1;
            iPy2 = -1;
        }
        return n(iPy, iPy2, z, z2);
    }

    private View qg(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return this.cp ? q(cyVar, pyVar) : l(cyVar, pyVar);
    }

    private View s(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return this.cp ? l(cyVar, pyVar) : q(cyVar, pyVar);
    }

    private View q(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return n(cyVar, pyVar, 0, py(), pyVar.l());
    }

    private View l(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return n(cyVar, pyVar, py() - 1, -1, pyVar.l());
    }

    public View n(RecyclerView.cy cyVar, RecyclerView.py pyVar, int i, int i2, int i3) {
        fs();
        int iS = this.tj.s();
        int iQ = this.tj.q();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewRv = rv(i);
            int iQ2 = q(viewRv);
            if (iQ2 >= 0 && iQ2 < i3) {
                if (((RecyclerView.tj) viewRv.getLayoutParams()).q()) {
                    if (view2 == null) {
                        view2 = viewRv;
                    }
                } else {
                    if (this.tj.n(viewRv) < iQ && this.tj.qg(viewRv) >= iS) {
                        return viewRv;
                    }
                    if (view == null) {
                        view = viewRv;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View w(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return this.cp ? fs(cyVar, pyVar) : rv(cyVar, pyVar);
    }

    private View x(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return this.cp ? rv(cyVar, pyVar) : fs(cyVar, pyVar);
    }

    private View fs(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return qg(0, py());
    }

    private View rv(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        return qg(py() - 1, -1);
    }

    public int d() {
        View viewN = n(0, py(), false, true);
        if (viewN == null) {
            return -1;
        }
        return q(viewN);
    }

    public int oa() {
        View viewN = n(py() - 1, -1, false, true);
        if (viewN == null) {
            return -1;
        }
        return q(viewN);
    }

    public View n(int i, int i2, boolean z, boolean z2) {
        fs();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return (this.rv == 0 ? this.cd : this.um).n(i, i2, i4, i3);
    }

    public View qg(int i, int i2) {
        byte b;
        int i3;
        int i4;
        fs();
        if (i2 > i) {
            b = 1;
        } else {
            b = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b == 0) {
            return rv(i);
        }
        if (this.tj.n(rv(i)) < this.tj.s()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        return (this.rv == 0 ? this.cd : this.um).n(i, i2, i3, i4);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public View n(View view, int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        int iW;
        View viewW;
        View viewOj;
        fi();
        if (py() == 0 || (iW = w(i)) == Integer.MIN_VALUE) {
            return null;
        }
        fs();
        fs();
        n(iW, (int) (this.tj.w() * 0.33333334f), false, pyVar);
        this.n.x = Integer.MIN_VALUE;
        this.n.n = false;
        n(cyVar, this.n, pyVar, true);
        if (iW == -1) {
            viewW = x(cyVar, pyVar);
        } else {
            viewW = w(cyVar, pyVar);
        }
        if (iW == -1) {
            viewOj = df();
        } else {
            viewOj = oj();
        }
        if (!viewOj.hasFocusable()) {
            return viewW;
        }
        if (viewW == null) {
            return null;
        }
        return viewOj;
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public boolean qg() {
        return this.sz == null && this.qg == this.q;
    }

    @com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    protected static class qg {
        public int n;
        public boolean q;
        public boolean qg;
        public boolean s;

        public void n() {
            this.n = 0;
            this.qg = false;
            this.s = false;
            this.q = false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 108})
    static class n {
        public boolean l;
        public rv n;
        public boolean q;
        public int qg;
        public int s;

        public n() {
            n();
        }

        public void n() {
            this.qg = -1;
            this.s = Integer.MIN_VALUE;
            this.q = false;
            this.l = false;
        }

        public void qg() {
            this.s = this.q ? this.n.q() : this.n.s();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.qg + ", mCoordinate=" + this.s + ", mLayoutFromEnd=" + this.q + ", mValid=" + this.l + AbstractJsonLexerKt.END_OBJ;
        }

        public boolean n(View view, RecyclerView.py pyVar) {
            RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
            return !tjVar.q() && tjVar.w() >= 0 && tjVar.w() < pyVar.l();
        }

        public void n(View view, int i) {
            int iQg = this.n.qg();
            if (iQg >= 0) {
                qg(view, i);
                return;
            }
            this.qg = i;
            if (this.q) {
                int iQ = (this.n.q() - iQg) - this.n.qg(view);
                this.s = this.n.q() - iQ;
                if (iQ > 0) {
                    int iL = this.s - this.n.l(view);
                    int iS = this.n.s();
                    int iMin = iL - (iS + Math.min(this.n.n(view) - iS, 0));
                    if (iMin < 0) {
                        this.s += Math.min(iQ, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iN = this.n.n(view);
            int iS2 = iN - this.n.s();
            this.s = iN;
            if (iS2 > 0) {
                int iQ2 = (this.n.q() - Math.min(0, (this.n.q() - iQg) - this.n.qg(view))) - (iN + this.n.l(view));
                if (iQ2 < 0) {
                    this.s -= Math.min(iS2, -iQ2);
                }
            }
        }

        public void qg(View view, int i) {
            if (this.q) {
                this.s = this.n.qg(view) + this.n.qg();
            } else {
                this.s = this.n.n(view);
            }
            this.qg = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, AVMDLDataLoader.KeyIsGetVersionInfo})
    public static class q implements Parcelable {
        public static final Parcelable.Creator<q> CREATOR = new Parcelable.Creator<q>() { // from class: com.byazt.prf.w.q.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public q createFromParcel(Parcel parcel) {
                return new q(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public q[] newArray(int i) {
                return new q[i];
            }
        };
        public int n;
        public int qg;
        public boolean s;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public q() {
        }

        public q(Parcel parcel) {
            this.n = parcel.readInt();
            this.qg = parcel.readInt();
            this.s = parcel.readInt() == 1;
        }

        public boolean n() {
            return this.n >= 0;
        }

        public void qg() {
            this.n = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.n);
            parcel.writeInt(this.qg);
            parcel.writeInt(this.s ? 1 : 0);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME})
    static class s {
        public boolean d;
        public int l;
        public int q;
        public int qg;
        public int s;
        public int tj;
        public int w;
        public int x;
        public boolean n = true;
        public int fs = 0;
        public boolean rv = false;
        public List<RecyclerView.m> cp = null;

        public boolean n(RecyclerView.py pyVar) {
            int i = this.q;
            return i >= 0 && i < pyVar.l();
        }

        public View n(RecyclerView.cy cyVar) {
            if (this.cp != null) {
                return qg();
            }
            View viewS = cyVar.s(this.q);
            this.q += this.l;
            return viewS;
        }

        private View qg() {
            int size = this.cp.size();
            for (int i = 0; i < size; i++) {
                View view = this.cp.get(i).n;
                RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
                if (!tjVar.q() && this.q == tjVar.w()) {
                    n(view);
                    return view;
                }
            }
            return null;
        }

        public void n() {
            n((View) null);
        }

        public void n(View view) {
            View viewQg = qg(view);
            if (viewQg == null) {
                this.q = -1;
            } else {
                this.q = ((RecyclerView.tj) viewQg.getLayoutParams()).w();
            }
        }

        public View qg(View view) {
            int iW;
            int size = this.cp.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.cp.get(i2).n;
                RecyclerView.tj tjVar = (RecyclerView.tj) view3.getLayoutParams();
                if (view3 != view && !tjVar.q() && (iW = (tjVar.w() - this.q) * this.l) >= 0 && iW < i) {
                    view2 = view3;
                    if (iW == 0) {
                        break;
                    }
                    i = iW;
                }
            }
            return view2;
        }
    }
}
