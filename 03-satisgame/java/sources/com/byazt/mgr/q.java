package com.byazt.mgr;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2431, 5})
public class q {
    public int[] l;
    public ViewParent n;
    public boolean q;
    public ViewParent qg;
    public final View s;

    public q(View view) {
        this.s = view;
    }

    public void n(boolean z) {
        if (this.q) {
            x.tj(this.s);
        }
        this.q = z;
    }

    public boolean n() {
        return this.q;
    }

    public boolean qg() {
        return n(0);
    }

    public boolean n(int i) {
        return q(i) != null;
    }

    public boolean qg(int i) {
        return n(i, 0);
    }

    public boolean n(int i, int i2) {
        if (n(i2)) {
            return true;
        }
        if (!n()) {
            return false;
        }
        View view = this.s;
        for (ViewParent parent = this.s.getParent(); parent != null; parent = parent.getParent()) {
            if (fs.n(parent, view, this.s, i, i2)) {
                n(i2, parent);
                fs.qg(parent, view, this.s, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void s() {
        s(0);
    }

    public void s(int i) {
        ViewParent viewParentQ = q(i);
        if (viewParentQ != null) {
            fs.n(viewParentQ, this.s, i);
            n(i, (ViewParent) null);
        }
    }

    public boolean n(int i, int i2, int i3, int i4, int[] iArr) {
        return n(i, i2, i3, i4, iArr, 0);
    }

    public boolean n(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentQ;
        int i6;
        int i7;
        if (!n() || (viewParentQ = q(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.s.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        fs.n(viewParentQ, this.s, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.s.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean n(int i, int i2, int[] iArr, int[] iArr2) {
        return n(i, i2, iArr, iArr2, 0);
    }

    public boolean n(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentQ;
        int i4;
        int i5;
        if (!n() || (viewParentQ = q(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.s.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.l == null) {
                this.l = new int[2];
            }
            iArr = this.l;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        fs.n(viewParentQ, this.s, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.s.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean n(float f, float f2, boolean z) {
        ViewParent viewParentQ;
        if (!n() || (viewParentQ = q(0)) == null) {
            return false;
        }
        return fs.n(viewParentQ, this.s, f, f2, z);
    }

    public boolean n(float f, float f2) {
        ViewParent viewParentQ;
        if (!n() || (viewParentQ = q(0)) == null) {
            return false;
        }
        return fs.n(viewParentQ, this.s, f, f2);
    }

    private ViewParent q(int i) {
        if (i == 0) {
            return this.n;
        }
        if (i != 1) {
            return null;
        }
        return this.qg;
    }

    private void n(int i, ViewParent viewParent) {
        if (i == 0) {
            this.n = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.qg = viewParent;
        }
    }
}
