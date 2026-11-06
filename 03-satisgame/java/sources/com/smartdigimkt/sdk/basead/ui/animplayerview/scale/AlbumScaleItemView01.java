package com.smartdigimkt.sdk.basead.ui.animplayerview.scale;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.smartdigimkt.r4.k;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlbumScaleItemView01 extends BaseAlbumScaleItemView {
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;

    public AlbumScaleItemView01(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public final int a(Context context) {
        return k.a(context, "myoffer_scale_first", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public void initView(View view) {
        super.initView(view);
        Context context = getContext();
        this.e = (ImageView) view.findViewById(k.a(context, "iv_left_top", "id"));
        this.f = (ImageView) view.findViewById(k.a(context, "iv_left_bottom", "id"));
        this.g = (ImageView) view.findViewById(k.a(context, "iv_right_top", "id"));
        this.h = (ImageView) view.findViewById(k.a(context, "iv_right_bottom", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
        if (list == null || list.size() < 4) {
            return;
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageBitmap(list.get(0));
        }
        ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setImageBitmap(list.get(1));
        }
        ImageView imageView3 = this.f;
        if (imageView3 != null) {
            imageView3.setImageBitmap(list.get(2));
        }
        ImageView imageView4 = this.e;
        if (imageView4 != null) {
            imageView4.setImageBitmap(list.get(3));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.smartdigimkt.q1.l
    public void start() {
        if (this.a == null) {
            this.a = new AnimatorSet();
            ImageView imageView = this.e;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, -imageView.getX());
            ImageView imageView2 = this.e;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", 0.0f, (float) (-Math.cos(imageView2.getY())));
            ImageView imageView3 = this.f;
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView3, "translationX", 0.0f, -imageView3.getX());
            ImageView imageView4 = this.f;
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView4, "translationY", 0.0f, (float) Math.cos(imageView4.getY()));
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.g, "translationX", 0.0f, getScreenWidth() - this.g.getX());
            ImageView imageView5 = this.g;
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(imageView5, "translationY", 0.0f, -((float) Math.cos(imageView5.getY())));
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.h, "translationX", 0.0f, getScreenWidth() - this.h.getX());
            ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.h, "translationY", 0.0f, (float) Math.cos(getScreenHeight() - this.h.getY()));
            ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 5.0f);
            ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 5.0f);
            this.a.setDuration(2500L);
            this.a.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.playTogether(objectAnimatorOfFloat9, objectAnimatorOfFloat10, objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat6, objectAnimatorOfFloat5, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
            long j = this.d;
            if (j > 0) {
                this.a.setStartDelay(j);
            }
        }
        this.a.start();
    }

    public AlbumScaleItemView01(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleItemView01(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
