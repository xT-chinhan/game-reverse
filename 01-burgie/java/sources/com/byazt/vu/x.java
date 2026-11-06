package com.byazt.vu;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 733, 121})
public class x {
    public int[] c;
    public final View hn;
    public ViewParent hw;
    public ViewParent pr;
    public boolean x;

    public x(View view) {
        this.hn = view;
    }

    public void pr(boolean z) {
        if (this.x) {
            fw.vk(this.hn);
        }
        this.x = z;
    }

    public boolean pr() {
        return this.x;
    }

    public boolean hw() {
        return pr(0);
    }

    public boolean pr(int i) {
        return x(i) != null;
    }

    public boolean hw(int i) {
        return pr(i, 0);
    }

    public boolean pr(int i, int i2) {
        if (pr(i2)) {
            return true;
        }
        if (pr()) {
            View view = this.hn;
            for (ViewParent parent = this.hn.getParent(); parent != null; parent = parent.getParent()) {
                if (zo.pr(parent, view, this.hn, i, i2)) {
                    pr(i2, parent);
                    zo.hw(parent, view, this.hn, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void hn() {
        hn(0);
    }

    public void hn(int i) {
        ViewParent viewParentX = x(i);
        if (viewParentX != null) {
            zo.pr(viewParentX, this.hn, i);
            pr(i, (ViewParent) null);
        }
    }

    public boolean pr(int i, int i2, int i3, int i4, int[] iArr) {
        return pr(i, i2, i3, i4, iArr, 0);
    }

    public boolean pr(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentX;
        int i6;
        int i7;
        if (!pr() || (viewParentX = x(i5)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            if (iArr == null) {
                i6 = 0;
                i7 = 0;
            } else {
                this.hn.getLocationInWindow(iArr);
                i6 = iArr[0];
                i7 = iArr[1];
            }
            zo.pr(viewParentX, this.hn, i, i2, i3, i4, i5);
            if (iArr != null) {
                this.hn.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i7;
            }
            return true;
        }
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return false;
    }

    public boolean pr(int i, int i2, int[] iArr, int[] iArr2) {
        return pr(i, i2, iArr, iArr2, 0);
    }

    public boolean pr(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentX;
        int i4;
        int i5;
        if (!pr() || (viewParentX = x(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 == null) {
                i4 = 0;
                i5 = 0;
            } else {
                this.hn.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            }
            if (iArr == null) {
                if (this.c == null) {
                    this.c = new int[2];
                }
                iArr = this.c;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            zo.pr(viewParentX, this.hn, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.hn.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        }
        if (iArr2 != null) {
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return false;
    }

    public boolean pr(float f, float f2, boolean z) {
        ViewParent viewParentX;
        if (!pr() || (viewParentX = x(0)) == null) {
            return false;
        }
        return zo.pr(viewParentX, this.hn, f, f2, z);
    }

    public boolean pr(float f, float f2) {
        ViewParent viewParentX;
        if (!pr() || (viewParentX = x(0)) == null) {
            return false;
        }
        return zo.pr(viewParentX, this.hn, f, f2);
    }

    private ViewParent x(int i) {
        switch (i) {
            case 0:
                return this.pr;
            case 1:
                return this.hw;
            default:
                return null;
        }
    }

    private void pr(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.pr = viewParent;
                break;
            case 1:
                this.hw = viewParent;
                break;
        }
    }
}
