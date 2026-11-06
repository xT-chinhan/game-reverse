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
public class AlbumScaleItemView02 extends BaseAlbumScaleItemView {
    public ImageView e;
    public ImageView f;
    public ImageView g;

    public AlbumScaleItemView02(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public final int a(Context context) {
        return k.a(context, "myoffer_scale_second", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public void initView(View view) {
        super.initView(view);
        Context context = getContext();
        this.e = (ImageView) view.findViewById(k.a(context, "iv_left", "id"));
        this.f = (ImageView) view.findViewById(k.a(context, "iv_right_top", "id"));
        this.g = (ImageView) view.findViewById(k.a(context, "iv_right_bottom", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
        if (list == null || list.size() < 4) {
            return;
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageBitmap(list.get(0));
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageBitmap(list.get(1));
        }
        ImageView imageView3 = this.g;
        if (imageView3 != null) {
            imageView3.setImageBitmap(list.get(3));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.smartdigimkt.q1.l
    public void start() {
        if (this.a == null) {
            this.a = new AnimatorSet();
            ImageView imageView = this.e;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, -(imageView.getX() + this.e.getWidth()));
            ImageView imageView2 = this.e;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", 0.0f, (float) (-Math.cos(imageView2.getY())));
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f, "translationX", 0.0f, getScreenWidth() - this.f.getX());
            ImageView imageView3 = this.f;
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView3, "translationY", 0.0f, (float) (-Math.cos(imageView3.getY())));
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.g, "translationX", 0.0f, getScreenWidth() - this.g.getX());
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.g, "translationY", 0.0f, (float) Math.cos(getScreenHeight() - this.g.getY()));
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 5.0f);
            ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 5.0f);
            this.a.setDuration(2000L);
            this.a.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat6, objectAnimatorOfFloat5, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
            long j = this.d;
            if (j > 0) {
                this.a.setStartDelay(j);
            }
        }
        this.a.start();
    }

    public AlbumScaleItemView02(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleItemView02(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
