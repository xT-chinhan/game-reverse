package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.adexpress.dynamic.d.hi;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar2 extends FrameLayout {
    private double ab;
    private float ah;
    private Drawable c;
    private float d;
    private Drawable ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    LinearLayout f983ms;
    private float x;
    LinearLayout xr;
    private static final int ny = (hi.xr("", 0.0f, true)[1] / 2) + 1;
    private static final int ch = (hi.xr("", 0.0f, true)[1] / 2) + 3;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f983ms = new LinearLayout(getContext());
        this.xr = new LinearLayout(getContext());
        this.f983ms.setOrientation(0);
        this.f983ms.setGravity(GravityCompat.START);
        this.xr.setOrientation(0);
        this.xr.setGravity(GravityCompat.START);
        this.ka = t.ah(context, "tt_star_thick");
        this.c = t.ah(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.ka;
    }

    public Drawable getStarFillDrawable() {
        return this.c;
    }

    public void ms(double d, int i, int i2, int i3) {
        float f = i2;
        this.ah = (int) x.ah(getContext(), f);
        this.d = (int) x.ah(getContext(), f);
        this.ab = d;
        this.x = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.xr.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.f983ms.addView(starImageView2);
        }
        addView(this.f983ms);
        addView(this.xr);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.ah, (int) this.d));
        imageView.setPadding(1, ny, 1, ch);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f983ms.measure(i, i2);
        double d = this.ab;
        float f = this.ah;
        this.xr.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f983ms.getMeasuredHeight(), 1073741824));
        if (this.x > 0.0f) {
            LinearLayout linearLayout = this.f983ms;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.x)) / 2, 0, 0);
            this.xr.setPadding(0, ((int) (this.f983ms.getMeasuredHeight() - this.x)) / 2, 0, 0);
        }
    }
}
