package com.smartdigimkt.p3;

import android.graphics.Rect;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final Rect a = new Rect();
    public final int b;

    public l(int i) {
        new WeakHashMap();
        this.b = i;
    }

    public final boolean a(View view, View view2, int i, Integer num) {
        if (view2 != null && view != null) {
            try {
                if (view.getParent() != null && view2.getWindowVisibility() == 0) {
                    if ((this.b == 1 && !view2.hasWindowFocus()) || !view2.getGlobalVisibleRect(this.a)) {
                        return false;
                    }
                    long jHeight = ((long) this.a.height()) * ((long) this.a.width());
                    long height = ((long) view2.getHeight()) * ((long) view2.getWidth());
                    if (height <= 0) {
                        return false;
                    }
                    long j = 100 * jHeight;
                    long j2 = j / height;
                    if ((num == null || num.intValue() <= 0 || jHeight >= num.intValue()) && j >= ((long) i) * height) {
                        return view2.isShown();
                    }
                    return false;
                }
            } catch (Throwable th) {
                th.getMessage();
                th.printStackTrace();
            }
        }
        return false;
    }
}
