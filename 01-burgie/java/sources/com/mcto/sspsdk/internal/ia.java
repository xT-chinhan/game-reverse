package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class ia extends TextureView {
    public int a;
    public int b;
    public int c;

    public ia(Context context) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public final void a(int i, int i2) {
        if (this.b == i || this.a == i2) {
            return;
        }
        this.b = i;
        this.a = i2;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.c == 1) {
            super.onMeasure(i, i2);
            return;
        }
        int i4 = this.b;
        int i5 = this.a;
        int defaultSize = View.getDefaultSize(i4, i);
        int defaultSize2 = View.getDefaultSize(i5, i2);
        if (i4 > 0 && i5 > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i6 = i4 * size2;
                int i7 = size * i5;
                if (i6 < i7) {
                    defaultSize = i6 / i5;
                    defaultSize2 = size2;
                } else if (i6 > i7) {
                    defaultSize2 = i7 / i4;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i8 = (size * i5) / i4;
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    defaultSize2 = i8;
                    defaultSize = size;
                } else {
                    defaultSize = (i4 * size2) / i5;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i9 = (size2 * i4) / i5;
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                    defaultSize2 = size2;
                } else {
                    defaultSize2 = (i5 * size) / i4;
                    defaultSize = size;
                }
            } else {
                if (mode2 != Integer.MIN_VALUE || i5 <= size2) {
                    i3 = i4;
                    size2 = i5;
                } else {
                    i3 = (size2 * i4) / i5;
                }
                if (mode != Integer.MIN_VALUE || i3 <= size) {
                    defaultSize = i3;
                    defaultSize2 = size2;
                } else {
                    defaultSize2 = (i5 * size) / i4;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public final void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
