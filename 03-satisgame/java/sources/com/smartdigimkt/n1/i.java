package com.smartdigimkt.n1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final Rect a = new Rect();
    public final Rect b = new Rect();
    public ViewGroup.MarginLayoutParams c;

    public final void a(View view, Rect rect) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i = marginLayoutParams.leftMargin;
        int i2 = rect.left + i;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = this.c;
        int i3 = 0;
        int i4 = i2 - ((marginLayoutParams == marginLayoutParams2 && i == this.b.left) ? this.a.left : 0);
        int i5 = marginLayoutParams.topMargin;
        int i6 = (rect.top + i5) - ((marginLayoutParams == marginLayoutParams2 && i5 == this.b.top) ? this.a.top : 0);
        int i7 = marginLayoutParams.rightMargin;
        int i8 = (rect.right + i7) - ((marginLayoutParams == marginLayoutParams2 && i7 == this.b.right) ? this.a.right : 0);
        int i9 = marginLayoutParams.bottomMargin;
        int i10 = rect.bottom + i9;
        if (marginLayoutParams == marginLayoutParams2 && i9 == this.b.bottom) {
            i3 = this.a.bottom;
        }
        int i11 = i10 - i3;
        if (i4 != i || i6 != i5 || i8 != i7 || i11 != i9) {
            marginLayoutParams.setMargins(i4, i6, i8, i11);
            view.setLayoutParams(marginLayoutParams);
        }
        this.c = marginLayoutParams;
        this.b.set(i4, i6, i8, i11);
        this.a.set(rect);
    }
}
