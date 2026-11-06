package com.byazt.qg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.aa.x;
import com.byazt.aa.zo;
import com.byazt.llk.c;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 591, 1674})
public class UGRatingBar extends FrameLayout {
    public LinearLayout c;
    public Context fw;
    public double hn;
    public float hw;
    public float pr;
    public LinearLayout uc;
    public float x;
    public c zo;

    public UGRatingBar(Context context) {
        super(context);
        this.fw = context;
        this.c = new LinearLayout(context);
        this.uc = new LinearLayout(context);
        this.c.setOrientation(0);
        this.c.setGravity(GravityCompat.START);
        this.uc.setOrientation(0);
        this.uc.setGravity(GravityCompat.START);
    }

    public void pr(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.c.removeAllViews();
        this.uc.removeAllViews();
        this.pr = (int) zo.pr(this.fw, f);
        this.hw = (int) zo.pr(this.fw, f);
        this.hn = d;
        this.x = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            pr(starImageView, "tt_ugen_rating_star");
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.uc.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            pr(starImageView2, "tt_ugen_rating_star");
            starImageView2.setColorFilter(i2);
            this.c.addView(starImageView2);
        }
        addView(this.c);
        addView(this.uc);
        requestLayout();
    }

    public void pr(ImageView imageView, String str) {
        imageView.setImageResource(x.hw(this.fw, str));
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.pr, (int) this.hw);
        layoutParams.leftMargin = (int) this.x;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.x;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.zo;
        if (cVar != null) {
            cVar.pr(i, i2);
        }
        super.onMeasure(i, i2);
        this.c.measure(i, i2);
        double dFloor = Math.floor(this.hn);
        float f = this.x;
        float f2 = this.pr;
        this.uc.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.hn - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.c.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.zo;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.zo;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.zo;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.zo;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c cVar = this.zo;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }

    public void pr(c cVar) {
        this.zo = cVar;
    }
}
