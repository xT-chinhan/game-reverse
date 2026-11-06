package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar extends LinearLayout {
    private Drawable ab;
    private int ah;
    private float c;
    private float d;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f4297ms;
    private Drawable ny;
    private Drawable x;
    private int xr;

    public TTRatingBar(Context context) {
        super(context);
        this.f4297ms = 5;
        this.xr = 0;
        this.ah = 0;
        ms(context);
    }

    private void ms(Context context) {
        setOrientation(0);
        this.ab = t.ah(context, "tt_star_empty_bg");
        this.x = t.ah(context, "tt_star_full_bg");
        this.ny = t.ah(context, "tt_star_empty_bg");
        this.d = ms(context, 15.0f);
        this.ka = ms(context, 15.0f);
        this.c = ms(context, 5.0f);
    }

    private int ms(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getStarFillNum() {
        return this.f4297ms;
    }

    public void setStarFillNum(int i) {
        this.f4297ms = i;
    }

    public int getStarHalfNum() {
        return this.xr;
    }

    public void setStarHalfNum(int i) {
        this.xr = i;
    }

    public int getStarEmptyNum() {
        return this.ah;
    }

    public void setStarEmptyNum(int i) {
        this.ah = i;
    }

    public float getStarImageWidth() {
        return this.d;
    }

    public void setStarImageWidth(float f) {
        this.d = f;
    }

    public float getStarImageHeight() {
        return this.ka;
    }

    public void setStarImageHeight(float f) {
        this.ka = f;
    }

    public float getStarImagePadding() {
        return this.c;
    }

    public void setStarImagePadding(float f) {
        this.c = f;
    }

    public Drawable getStarEmptyDrawable() {
        return this.ab;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.ab = drawable;
    }

    public Drawable getStarFillDrawable() {
        return this.x;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.x = drawable;
    }

    public Drawable getStarHalfDrawable() {
        return this.ny;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.ny = drawable;
    }

    public void ms() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.d), Math.round(this.ka)));
        imageView.setPadding(0, 0, Math.round(this.c), 0);
        return imageView;
    }
}
