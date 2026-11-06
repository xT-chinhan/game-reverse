package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.ah;
import com.bytedance.adsdk.ugeno.c.d;
import com.bytedance.adsdk.ugeno.c.x;

/* JADX INFO: loaded from: classes2.dex */
public class UGRatingBar extends FrameLayout {
    private Context ab;
    private double ah;
    private LinearLayout c;
    private float d;
    private LinearLayout ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f424ms;
    private ah x;
    private float xr;

    public UGRatingBar(Context context) {
        super(context);
        this.ab = context;
        this.ka = new LinearLayout(context);
        this.c = new LinearLayout(context);
        this.ka.setOrientation(0);
        this.ka.setGravity(GravityCompat.START);
        this.c.setOrientation(0);
        this.c.setGravity(GravityCompat.START);
    }

    public void ms(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.ka.removeAllViews();
        this.c.removeAllViews();
        this.f424ms = (int) x.ms(this.ab, f);
        this.xr = (int) x.ms(this.ab, f);
        this.ah = d;
        this.d = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(d.ms(this.ab, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.c.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(d.ms(this.ab, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.ka.addView(starImageView2);
        }
        addView(this.ka);
        addView(this.c);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.f424ms, (int) this.xr);
        layoutParams.leftMargin = (int) this.d;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.d;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.x;
        if (ahVar != null) {
            ahVar.ms(i, i2);
        }
        super.onMeasure(i, i2);
        this.ka.measure(i, i2);
        double dFloor = Math.floor(this.ah);
        float f = this.d;
        float f2 = this.f424ms;
        this.c.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.ah - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.ka.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.x;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.x;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.x;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.x;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ah ahVar = this.x;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }

    public void ms(ah ahVar) {
        this.x = ahVar;
    }
}
