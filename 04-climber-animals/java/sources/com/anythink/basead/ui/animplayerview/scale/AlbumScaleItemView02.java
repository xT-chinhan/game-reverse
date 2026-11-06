package com.anythink.basead.ui.animplayerview.scale;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.anythink.basead.exoplayer.i.a;
import com.anythink.core.common.v.q;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlbumScaleItemView02 extends BaseAlbumScaleItemView {
    private ImageView f;
    private ImageView g;
    private ImageView h;

    public AlbumScaleItemView02(Context context) {
        this(context, null);
    }

    public AlbumScaleItemView02(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleItemView02(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    protected final int a(Context context) {
        return q.a(context, "myoffer_scale_second", "layout");
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public void initView(View view) {
        super.initView(view);
        Context context = getContext();
        this.f = (ImageView) view.findViewById(q.a(context, "iv_left", "id"));
        this.g = (ImageView) view.findViewById(q.a(context, "iv_right_top", "id"));
        this.h = (ImageView) view.findViewById(q.a(context, "iv_right_bottom", "id"));
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(List<Bitmap> list) {
        if (list == null || list.size() < 4) {
            return;
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageBitmap(list.get(0));
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageBitmap(list.get(1));
        }
        ImageView imageView3 = this.h;
        if (imageView3 != null) {
            imageView3.setImageBitmap(list.get(3));
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.anythink.basead.ui.animplayerview.b
    public void start() {
        if (this.b == null) {
            this.b = new AnimatorSet();
            ImageView imageView = this.f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, -(imageView.getX() + this.f.getWidth()));
            ImageView imageView2 = this.f;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", 0.0f, (float) (-Math.cos(imageView2.getY())));
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.g, "translationX", 0.0f, a() - this.g.getX());
            ImageView imageView3 = this.g;
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView3, "translationY", 0.0f, (float) (-Math.cos(imageView3.getY())));
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.h, "translationX", 0.0f, a() - this.h.getX());
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.h, "translationY", 0.0f, (float) Math.cos(b() - this.h.getY()));
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 5.0f);
            ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 5.0f);
            this.b.setDuration(a.f);
            this.b.setInterpolator(new AccelerateDecelerateInterpolator());
            this.b.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat6, objectAnimatorOfFloat5, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
            if (this.e > 0) {
                this.b.setStartDelay(this.e);
            }
        }
        this.b.start();
    }
}
