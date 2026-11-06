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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlbumScaleItemView03 extends BaseAlbumScaleItemView {
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;

    public AlbumScaleItemView03(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public final int a(Context context) {
        return k.a(context, "myoffer_scale_third", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public void initView(View view) {
        super.initView(view);
        Context context = getContext();
        this.e = (ImageView) view.findViewById(k.a(context, "iv_left_01", "id"));
        this.f = (ImageView) view.findViewById(k.a(context, "iv_left_02", "id"));
        this.g = (ImageView) view.findViewById(k.a(context, "iv_left_03", "id"));
        this.h = (ImageView) view.findViewById(k.a(context, "iv_left_04", "id"));
        this.i = (ImageView) view.findViewById(k.a(context, "iv_right_01", "id"));
        this.j = (ImageView) view.findViewById(k.a(context, "iv_right_02", "id"));
        this.k = (ImageView) view.findViewById(k.a(context, "iv_right_03", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
        if (list == null || list.size() < 4) {
            return;
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setImageBitmap(list.get(2));
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageBitmap(list.get(0));
        }
        ImageView imageView3 = this.g;
        if (imageView3 != null) {
            imageView3.setImageBitmap(list.get(3));
        }
        ImageView imageView4 = this.h;
        if (imageView4 != null) {
            imageView4.setImageBitmap(list.get(0));
        }
        ImageView imageView5 = this.i;
        if (imageView5 != null) {
            imageView5.setImageBitmap(list.get(1));
        }
        ImageView imageView6 = this.j;
        if (imageView6 != null) {
            imageView6.setImageBitmap(list.get(2));
        }
        ImageView imageView7 = this.k;
        if (imageView7 != null) {
            imageView7.setImageBitmap(list.get(3));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.smartdigimkt.q1.l
    public void start() {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        if (this.a == null) {
            this.a = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            if (this.c) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "translationX", 0.0f, -dip2px(20.0f));
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "translationY", 0.0f, dip2px(15.0f));
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.i, "translationX", 0.0f, dip2px(15.0f));
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.i, "translationY", 0.0f, dip2px(15.0f));
            }
            arrayList.add(objectAnimatorOfFloat);
            arrayList.add(objectAnimatorOfFloat2);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, this.b);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, this.b);
            arrayList.add(objectAnimatorOfFloat3);
            arrayList.add(objectAnimatorOfFloat4);
            this.a.setDuration(4000L);
            this.a.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.playTogether(arrayList);
            long j = this.d;
            if (j > 0) {
                this.a.setStartDelay(j);
            }
        }
        this.a.start();
    }

    public AlbumScaleItemView03(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleItemView03(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
