package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar2 extends FrameLayout {
    private int ab;
    private int ah;
    private int c;
    private Drawable ch;
    private int d;
    private Drawable hi;
    private double ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    LinearLayout f4298ms;
    private int ny;
    private int x;
    LinearLayout xr;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4298ms = new LinearLayout(getContext());
        this.xr = new LinearLayout(getContext());
        this.f4298ms.setOrientation(0);
        this.f4298ms.setGravity(GravityCompat.START);
        this.xr.setOrientation(0);
        this.xr.setGravity(GravityCompat.START);
        this.ch = t.ah(context, "tt_ratingbar_empty_star2");
        this.hi = t.ah(context, "tt_ratingbar_full_star2");
    }

    public Drawable getEmptyStarDrawable() {
        return this.ch;
    }

    public Drawable getFillStarDrawable() {
        return this.hi;
    }

    public void setRating(double d) {
        this.ka = d;
    }

    public void ms(int i, int i2) {
        this.ah = i2;
        this.d = i;
    }

    public void ms() {
        removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.xr.addView(starImageView);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.f4298ms.addView(starImageView2);
        }
        addView(this.f4298ms);
        addView(this.xr);
        requestLayout();
    }

    public void ms(int i, int i2, int i3, int i4) {
        this.c = i;
        this.ab = i2;
        this.x = i3;
        this.ny = i4;
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ah, this.d);
        layoutParams.leftMargin = this.c;
        layoutParams.topMargin = this.ab;
        layoutParams.rightMargin = this.x;
        layoutParams.bottomMargin = this.ny;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f4298ms.measure(i, i2);
        double dFloor = Math.floor(this.ka);
        int i3 = this.c;
        int i4 = this.x + i3;
        int i5 = this.ah;
        this.xr.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.ka - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f4298ms.getMeasuredHeight(), 1073741824));
    }
}
