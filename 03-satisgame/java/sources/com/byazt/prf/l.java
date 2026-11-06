package com.byazt.prf;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 18})
public class l extends w {
    public final Rect fs;
    public final SparseIntArray l;
    public boolean n;
    public View[] q;
    public int qg;
    public int[] s;
    public final SparseIntArray w;
    public s x;

    public l(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.n = false;
        this.qg = -1;
        this.l = new SparseIntArray();
        this.w = new SparseIntArray();
        this.x = new n();
        this.fs = new Rect();
        n(i);
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        if (pyVar.n()) {
            df();
        }
        super.n(cyVar, pyVar);
        fi();
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView.py pyVar) {
        super.n(pyVar);
        this.n = false;
    }

    private void fi() {
        this.l.clear();
        this.w.clear();
    }

    private void df() {
        int iPy = py();
        for (int i = 0; i < iPy; i++) {
            qg qgVar = (qg) rv(i).getLayoutParams();
            int iW = qgVar.w();
            this.l.put(iW, qgVar.qg());
            this.w.put(iW, qgVar.n());
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, int i, int i2) {
        this.x.n();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView) {
        this.x.n();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void qg(RecyclerView recyclerView, int i, int i2) {
        this.x.n();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.x.n();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, int i, int i2, int i3) {
        this.x.n();
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public RecyclerView.tj n() {
        if (this.rv == 0) {
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

    private void oj() {
        int iHu;
        int iT;
        if (w() == 1) {
            iHu = m() - ur();
            iT = h();
        } else {
            iHu = hu() - bb();
            iT = t();
        }
        oa(iHu - iT);
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void n(Rect rect, int i, int i2) {
        int iN;
        int iN2;
        if (this.s == null) {
            super.n(rect, i, i2);
        }
        int iH = h() + ur();
        int iT = t() + bb();
        if (this.rv == 1) {
            iN2 = n(i2, rect.height() + iT, j());
            int[] iArr = this.s;
            iN = n(i, iArr[iArr.length - 1] + iH, v());
        } else {
            iN = n(i, rect.width() + iH, v());
            int[] iArr2 = this.s;
            iN2 = n(i2, iArr2[iArr2.length - 1] + iT, j());
        }
        w(iN, iN2);
    }

    private void oa(int i) {
        this.s = n(this.s, this.qg, i);
    }

    public static int[] n(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    public int n(int i, int i2) {
        if (this.rv == 1 && x()) {
            int[] iArr = this.s;
            int i3 = this.qg;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.s;
        return iArr2[i2 + i] - iArr2[i];
    }

    @Override // com.byazt.prf.w
    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, w.n nVar, int i) {
        super.n(cyVar, pyVar, nVar, i);
        oj();
        if (pyVar.l() > 0 && !pyVar.n()) {
            qg(cyVar, pyVar, nVar, i);
        }
        dg();
    }

    private void dg() {
        View[] viewArr = this.q;
        if (viewArr == null || viewArr.length != this.qg) {
            this.q = new View[this.qg];
        }
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public int n(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        oj();
        dg();
        return super.n(i, cyVar, pyVar);
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public int qg(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        oj();
        dg();
        return super.qg(i, cyVar, pyVar);
    }

    private void qg(RecyclerView.cy cyVar, RecyclerView.py pyVar, w.n nVar, int i) {
        boolean z = i == 1;
        int iQg = qg(cyVar, pyVar, nVar.qg);
        if (z) {
            while (iQg > 0 && nVar.qg > 0) {
                nVar.qg--;
                iQg = qg(cyVar, pyVar, nVar.qg);
            }
            return;
        }
        int iL = pyVar.l() - 1;
        int i2 = nVar.qg;
        while (i2 < iL) {
            int i3 = i2 + 1;
            int iQg2 = qg(cyVar, pyVar, i3);
            if (iQg2 <= iQg) {
                break;
            }
            i2 = i3;
            iQg = iQg2;
        }
        nVar.qg = i2;
    }

    @Override // com.byazt.prf.w
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
            if (iQ2 >= 0 && iQ2 < i3 && qg(cyVar, pyVar, iQ2) == 0) {
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

    private int n(RecyclerView.cy cyVar, RecyclerView.py pyVar, int i) {
        if (!pyVar.n()) {
            return this.x.s(i, this.qg);
        }
        int iQg = cyVar.qg(i);
        if (iQg == -1) {
            return 0;
        }
        return this.x.s(iQg, this.qg);
    }

    private int qg(RecyclerView.cy cyVar, RecyclerView.py pyVar, int i) {
        if (!pyVar.n()) {
            return this.x.qg(i, this.qg);
        }
        int i2 = this.w.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iQg = cyVar.qg(i);
        if (iQg == -1) {
            return 0;
        }
        return this.x.qg(iQg, this.qg);
    }

    private int s(RecyclerView.cy cyVar, RecyclerView.py pyVar, int i) {
        if (!pyVar.n()) {
            return this.x.n(i);
        }
        int i2 = this.l.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iQg = cyVar.qg(i);
        if (iQg == -1) {
            return 1;
        }
        return this.x.n(iQg);
    }

    @Override // com.byazt.prf.w
    public void n(RecyclerView.py pyVar, w.s sVar, RecyclerView.rv.n nVar) {
        int iN = this.qg;
        for (int i = 0; i < this.qg && sVar.n(pyVar) && iN > 0; i++) {
            int i2 = sVar.q;
            nVar.qg(i2, Math.max(0, sVar.x));
            iN -= this.x.n(i2);
            sVar.q += sVar.l;
        }
    }

    @Override // com.byazt.prf.w
    public void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, w.s sVar, w.qg qgVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iW;
        int iW2;
        int iW3;
        int iN;
        int iN2;
        boolean z;
        View viewN;
        int iRv = this.tj.rv();
        boolean z2 = iRv != 1073741824;
        int i6 = py() > 0 ? this.s[this.qg] : 0;
        if (z2) {
            oj();
        }
        boolean z3 = sVar.l == 1;
        int iQg = this.qg;
        if (!z3) {
            iQg = qg(cyVar, pyVar, sVar.q) + s(cyVar, pyVar, sVar.q);
        }
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.qg && sVar.n(pyVar) && iQg > 0) {
            int i9 = sVar.q;
            int iS = s(cyVar, pyVar, i9);
            if (iS > this.qg) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + iS + " spans but GridLayoutManager has only " + this.qg + " spans.");
            }
            iQg -= iS;
            if (iQg < 0 || (viewN = sVar.n(cyVar)) == null) {
                break;
            }
            i7 += iS;
            this.q[i8] = viewN;
            i8++;
        }
        if (i8 == 0) {
            qgVar.qg = true;
            return;
        }
        int i10 = i8;
        n(cyVar, pyVar, i8, i7, z3);
        float f = 0.0f;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            View view = this.q[i12];
            if (sVar.cp != null) {
                z = false;
                if (z3) {
                    n(view);
                } else {
                    n(view, 0);
                }
            } else if (z3) {
                qg(view);
                z = false;
            } else {
                z = false;
                qg(view, 0);
            }
            qg(view, this.fs);
            n(view, iRv, z);
            int iL = this.tj.l(view);
            if (iL > i11) {
                i11 = iL;
            }
            float fW = (this.tj.w(view) * 1.0f) / ((qg) view.getLayoutParams()).qg;
            if (fW > f) {
                f = fW;
            }
        }
        if (z2) {
            n(f, i6);
            i11 = 0;
            for (int i13 = 0; i13 < i10; i13++) {
                View view2 = this.q[i13];
                n(view2, C.ENCODING_PCM_32BIT, true);
                int iL2 = this.tj.l(view2);
                if (iL2 > i11) {
                    i11 = iL2;
                }
            }
        }
        for (int i14 = 0; i14 < i10; i14++) {
            View view3 = this.q[i14];
            if (this.tj.l(view3) != i11) {
                qg qgVar2 = (qg) view3.getLayoutParams();
                Rect rect = qgVar2.q;
                int i15 = rect.top + rect.bottom + qgVar2.topMargin + qgVar2.bottomMargin;
                int i16 = rect.left + rect.right + qgVar2.leftMargin + qgVar2.rightMargin;
                int iN3 = n(qgVar2.n, qgVar2.qg);
                if (this.rv == 1) {
                    iN2 = n(iN3, C.ENCODING_PCM_32BIT, i16, qgVar2.width, false);
                    iN = View.MeasureSpec.makeMeasureSpec(i11 - i15, C.ENCODING_PCM_32BIT);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i16, C.ENCODING_PCM_32BIT);
                    iN = n(iN3, C.ENCODING_PCM_32BIT, i15, qgVar2.height, false);
                    iN2 = iMakeMeasureSpec;
                }
                n(view3, iN2, iN, true);
            }
        }
        int i17 = 0;
        qgVar.n = i11;
        if (this.rv == 1) {
            if (sVar.w == -1) {
                int i18 = sVar.qg;
                i4 = i18 - i11;
                i2 = i18;
            } else {
                int i19 = sVar.qg;
                i2 = i19 + i11;
                i4 = i19;
            }
            i = 0;
            i3 = 0;
        } else if (sVar.w == -1) {
            i3 = sVar.qg;
            i = i3 - i11;
            i4 = 0;
            i2 = 0;
        } else {
            int i20 = sVar.qg;
            int i21 = i20 + i11;
            i = i20;
            i2 = 0;
            i3 = i21;
            i4 = 0;
        }
        while (i17 < i10) {
            View view4 = this.q[i17];
            qg qgVar3 = (qg) view4.getLayoutParams();
            if (this.rv == 1) {
                if (x()) {
                    int iH = h() + this.s[this.qg - qgVar3.n];
                    i5 = i4;
                    iW = i2;
                    iW3 = iH;
                    iW2 = iH - this.tj.w(view4);
                } else {
                    int iH2 = h() + this.s[qgVar3.n];
                    i5 = i4;
                    iW = i2;
                    iW2 = iH2;
                    iW3 = this.tj.w(view4) + iH2;
                }
            } else {
                int iT = t() + this.s[qgVar3.n];
                i5 = iT;
                iW = this.tj.w(view4) + iT;
                iW2 = i;
                iW3 = i3;
            }
            n(view4, iW2, i5, iW3, iW);
            if (qgVar3.q() || qgVar3.l()) {
                qgVar.s = true;
            }
            qgVar.q |= view4.hasFocusable();
            i17++;
            i4 = i5;
            i2 = iW;
            i = iW2;
            i3 = iW3;
        }
        Arrays.fill(this.q, (Object) null);
    }

    private void n(View view, int i, boolean z) {
        int iN;
        int iN2;
        qg qgVar = (qg) view.getLayoutParams();
        Rect rect = qgVar.q;
        int i2 = rect.top + rect.bottom + qgVar.topMargin + qgVar.bottomMargin;
        int i3 = rect.left + rect.right + qgVar.leftMargin + qgVar.rightMargin;
        int iN3 = n(qgVar.n, qgVar.qg);
        if (this.rv == 1) {
            iN2 = n(iN3, i, i3, qgVar.width, false);
            iN = n(this.tj.w(), wm(), i2, qgVar.height, true);
        } else {
            int iN4 = n(iN3, i, i2, qgVar.height, false);
            int iN5 = n(this.tj.w(), ou(), i3, qgVar.width, true);
            iN = iN4;
            iN2 = iN5;
        }
        n(view, iN2, iN, z);
    }

    private void n(float f, int i) {
        oa(Math.max(Math.round(f * this.qg), i));
    }

    private void n(View view, int i, int i2, boolean z) {
        boolean zQg;
        RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
        if (z) {
            zQg = n(view, i, i2, tjVar);
        } else {
            zQg = qg(view, i, i2, tjVar);
        }
        if (zQg) {
            view.measure(i, i2);
        }
    }

    private void n(RecyclerView.cy cyVar, RecyclerView.py pyVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (z) {
            i5 = 1;
            i4 = i;
            i3 = 0;
        } else {
            i3 = i - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View view = this.q[i3];
            qg qgVar = (qg) view.getLayoutParams();
            qgVar.qg = s(cyVar, pyVar, q(view));
            qgVar.n = i6;
            i6 += qgVar.qg;
            i3 += i5;
        }
    }

    public void n(int i) {
        if (i == this.qg) {
            return;
        }
        this.n = true;
        if (i <= 0) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(i)));
        }
        this.qg = i;
        this.x.n();
        sz();
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1721})
    public static abstract class s {
        public final SparseIntArray n = new SparseIntArray();
        public boolean qg = false;

        public abstract int n(int i);

        public void n() {
            this.n.clear();
        }

        public int qg(int i, int i2) {
            if (!this.qg) {
                return n(i, i2);
            }
            int i3 = this.n.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iN = n(i, i2);
            this.n.put(i, iN);
            return iN;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x002a  */
        /* JADX WARN: Code duplicated, block: B:16:0x0031  */
        /* JADX WARN: Code duplicated, block: B:17:0x0033 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:18:0x0035  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public int n(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.n(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.qg
                if (r2 == 0) goto L26
                android.util.SparseIntArray r2 = r5.n
                int r2 = r2.size()
                if (r2 <= 0) goto L26
                int r2 = r5.qg(r6)
                if (r2 < 0) goto L26
                android.util.SparseIntArray r3 = r5.n
                int r3 = r3.get(r2)
                int r4 = r5.n(r2)
                int r3 = r3 + r4
                goto L36
            L26:
                r2 = r1
                r3 = r2
            L28:
                if (r2 >= r6) goto L39
                int r4 = r5.n(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L33
                r3 = r1
                goto L36
            L33:
                if (r3 <= r7) goto L36
                r3 = r4
            L36:
                int r2 = r2 + 1
                goto L28
            L39:
                int r0 = r0 + r3
                if (r0 > r7) goto L3d
                return r3
            L3d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.byazt.prf.l.s.n(int, int):int");
        }

        public int qg(int i) {
            int size = this.n.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.n.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.n.size()) {
                return -1;
            }
            return this.n.keyAt(i4);
        }

        public int s(int i, int i2) {
            int iN = n(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int iN2 = n(i5);
                i3 += iN2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = iN2;
                }
            }
            return i3 + iN > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View n(android.view.View r23, int r24, com.byazt.prf.RecyclerView.cy r25, com.byazt.prf.RecyclerView.py r26) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.prf.l.n(android.view.View, int, com.byazt.prf.RecyclerView$cy, com.byazt.prf.RecyclerView$py):android.view.View");
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public boolean qg() {
        return this.sz == null && !this.n;
    }

    @com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static final class n extends s {
        @Override // com.byazt.prf.l.s
        public int n(int i) {
            return 1;
        }

        @Override // com.byazt.prf.l.s
        public int n(int i, int i2) {
            return i % i2;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 120})
    public static class qg extends RecyclerView.tj {
        public int n;
        public int qg;

        public qg(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
            this.qg = 0;
        }

        public qg(int i, int i2) {
            super(i, i2);
            this.n = -1;
            this.qg = 0;
        }

        public qg(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.n = -1;
            this.qg = 0;
        }

        public qg(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.n = -1;
            this.qg = 0;
        }

        public int n() {
            return this.n;
        }

        public int qg() {
            return this.qg;
        }
    }
}
