package com.byazt.mgr;

import android.view.View;
import android.view.ViewParent;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2431, 101})
public final class fs {
    public static boolean n(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof w) {
            return ((w) viewParent).n(view, view2, i, i2);
        }
        if (i2 != 0) {
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (AbstractMethodError e) {
            k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    public static void qg(ViewParent viewParent, View view, View view2, int i, int i2) {
        if ((viewParent instanceof w) || i2 != 0) {
            return;
        }
        try {
            viewParent.onNestedScrollAccepted(view, view2, i);
        } catch (AbstractMethodError e) {
            k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
        }
    }

    public static void n(ViewParent viewParent, View view, int i) {
        if ((viewParent instanceof w) || i != 0) {
            return;
        }
        try {
            viewParent.onStopNestedScroll(view);
        } catch (AbstractMethodError e) {
            k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
        }
    }

    public static void n(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if ((viewParent instanceof w) || i5 != 0) {
            return;
        }
        try {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        } catch (AbstractMethodError e) {
            k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
        }
    }

    public static void n(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof w) {
            ((w) viewParent).n(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }
    }

    public static boolean n(ViewParent viewParent, View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public static boolean n(ViewParent viewParent, View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            k.n("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }
}
