package com.bytedance.sdk.component.widget.recycler.ms.ah;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final View ah;
    private boolean d;
    private int[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ViewParent f1421ms;
    private ViewParent xr;

    public d(View view) {
        this.ah = view;
    }

    public void ms(boolean z) {
        if (this.d) {
            ab.ch(this.ah);
        }
        this.d = z;
    }

    public boolean ms() {
        return this.d;
    }

    public boolean xr() {
        return ms(0);
    }

    public boolean ms(int i) {
        return d(i) != null;
    }

    public boolean xr(int i) {
        return ms(i, 0);
    }

    public boolean ms(int i, int i2) {
        if (ms(i2)) {
            return true;
        }
        if (!ms()) {
            return false;
        }
        View view = this.ah;
        for (ViewParent parent = this.ah.getParent(); parent != null; parent = parent.getParent()) {
            if (x.ms(parent, view, this.ah, i, i2)) {
                ms(i2, parent);
                x.xr(parent, view, this.ah, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void ah() {
        ah(0);
    }

    public void ah(int i) {
        ViewParent viewParentD = d(i);
        if (viewParentD != null) {
            x.ms(viewParentD, this.ah, i);
            ms(i, (ViewParent) null);
        }
    }

    public boolean ms(int i, int i2, int i3, int i4, int[] iArr) {
        return ms(i, i2, i3, i4, iArr, 0);
    }

    public boolean ms(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentD;
        int i6;
        int i7;
        if (!ms() || (viewParentD = d(i5)) == null) {
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
            this.ah.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        x.ms(viewParentD, this.ah, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.ah.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean ms(int i, int i2, int[] iArr, int[] iArr2) {
        return ms(i, i2, iArr, iArr2, 0);
    }

    public boolean ms(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentD;
        int i4;
        int i5;
        if (!ms() || (viewParentD = d(i3)) == null) {
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
            this.ah.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.ka == null) {
                this.ka = new int[2];
            }
            iArr = this.ka;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        x.ms(viewParentD, this.ah, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.ah.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean ms(float f, float f2, boolean z) {
        ViewParent viewParentD;
        if (!ms() || (viewParentD = d(0)) == null) {
            return false;
        }
        return x.ms(viewParentD, this.ah, f, f2, z);
    }

    public boolean ms(float f, float f2) {
        ViewParent viewParentD;
        if (!ms() || (viewParentD = d(0)) == null) {
            return false;
        }
        return x.ms(viewParentD, this.ah, f, f2);
    }

    private ViewParent d(int i) {
        if (i == 0) {
            return this.f1421ms;
        }
        if (i != 1) {
            return null;
        }
        return this.xr;
    }

    private void ms(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f1421ms = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.xr = viewParent;
        }
    }
}
