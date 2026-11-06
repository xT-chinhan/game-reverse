package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.d5;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleMediaATView extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public ImageView d;
    public ImageView e;
    public Bitmap f;

    public SimpleMediaATView(Context context) {
        this(context, null);
    }

    public final void a(Bitmap bitmap) {
        int[] iArrA = d.a(this.a, this.b, bitmap.getWidth() / bitmap.getHeight());
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = iArrA[0];
        layoutParams.height = iArrA[1];
        this.d.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            int i = layoutParams2.width == -2 ? iArrA[0] : this.a;
            int i2 = layoutParams2.height == -2 ? iArrA[1] : this.b;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.d)) {
                    ViewGroup.LayoutParams layoutParams3 = childAt.getLayoutParams();
                    layoutParams3.width = i;
                    childAt.setLayoutParams(layoutParams3);
                    ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                    layoutParams4.height = i2;
                    childAt.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void initView(c cVar) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_simple_media_ad_view", "layout"), this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.c = iMax;
        this.a = iMax;
        this.b = iMax;
        this.e = (ImageView) findViewById(k.a(getContext(), "myoffer_simple_background", "id"));
        ImageView imageView = (ImageView) findViewById(k.a(getContext(), "myoffer_simple_main_image", "id"));
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = cVar.f;
        try {
            m.a(getContext()).a(new o(1, str), -1, -1, new d5(this, str));
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.f;
        if (bitmap == null) {
            if (size != 0 && size < this.a) {
                this.a = size;
            }
            if (size2 == 0 || size2 >= this.b) {
                return;
            }
            this.b = size2;
            return;
        }
        if (size == 0 || size >= this.a) {
            z = false;
        } else {
            this.a = size;
            z = true;
        }
        if (size2 != 0 && size2 < this.b) {
            this.b = size2;
        } else if (!z) {
            return;
        }
        a(bitmap);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0028  */
    /* JADX WARN: Code duplicated, block: B:22:0x0031 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean z;
        int i;
        Bitmap bitmap;
        super.setLayoutParams(layoutParams);
        int i2 = layoutParams.width;
        boolean z2 = true;
        if (i2 != -1 && i2 != -2) {
            if (this.a != i2) {
                this.a = i2;
                z = true;
            }
            i = layoutParams.height;
            if (i == -1 && i != -2) {
                if (this.b != i) {
                    this.b = i;
                }
                bitmap = this.f;
                if (bitmap == null && z2) {
                    a(bitmap);
                    return;
                }
            }
            this.b = this.c;
            z2 = z;
            bitmap = this.f;
            if (bitmap == null) {
            }
        }
        this.a = this.c;
        z = false;
        i = layoutParams.height;
        if (i == -1) {
            this.b = this.c;
            z2 = z;
        } else {
            this.b = this.c;
            z2 = z;
        }
        bitmap = this.f;
        if (bitmap == null) {
        }
    }

    public SimpleMediaATView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleMediaATView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
