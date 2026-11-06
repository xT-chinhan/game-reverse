package com.byazt.far;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.gu.l;
import com.byazt.hb.fs;
import com.byazt.hb.q;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1219, 1835})
public class UGRatingBar extends FrameLayout {
    public l fs;
    public LinearLayout l;
    public float n;
    public float q;
    public float qg;
    public double s;
    public LinearLayout w;
    public Context x;

    public UGRatingBar(Context context) {
        super(context);
        this.x = context;
        this.l = new LinearLayout(context);
        this.w = new LinearLayout(context);
        this.l.setOrientation(0);
        this.l.setGravity(GravityCompat.START);
        this.w.setOrientation(0);
        this.w.setGravity(GravityCompat.START);
    }

    public void n(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.l.removeAllViews();
        this.w.removeAllViews();
        this.n = (int) fs.n(this.x, f);
        this.qg = (int) fs.n(this.x, f);
        this.s = d;
        this.q = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            n(starImageView, "tt_ugen_rating_star");
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.w.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            n(starImageView2, "tt_ugen_rating_star");
            starImageView2.setColorFilter(i2);
            this.l.addView(starImageView2);
        }
        addView(this.l);
        addView(this.w);
        requestLayout();
    }

    public void n(ImageView imageView, String str) {
        imageView.setImageResource(q.qg(this.x, str));
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.n, (int) this.qg);
        layoutParams.leftMargin = (int) this.q;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.q;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.fs;
        if (lVar != null) {
            lVar.n(i, i2);
        }
        super.onMeasure(i, i2);
        this.l.measure(i, i2);
        double dFloor = Math.floor(this.s);
        float f = this.q;
        float f2 = this.n;
        this.w.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.s - dFloor) * ((double) f2))), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(this.l.getMeasuredHeight(), C.ENCODING_PCM_32BIT));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.fs;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
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
        l lVar = this.fs;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.fs;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.fs;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l lVar = this.fs;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    public void n(l lVar) {
        this.fs = lVar;
    }
}
