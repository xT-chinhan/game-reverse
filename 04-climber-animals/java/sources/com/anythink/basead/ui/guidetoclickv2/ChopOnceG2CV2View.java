package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class ChopOnceG2CV2View extends BaseLifecycleG2CV2View {
    ImageView d;
    ImageView e;
    Animation f;
    Animation g;
    ImageView h;

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View
    final int e() {
        return 44;
    }

    public ChopOnceG2CV2View(Context context) {
        super(context);
    }

    public ChopOnceG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChopOnceG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_chop_once", "layout"), this);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.d = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_gift_group", "id"));
        this.e = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_gift_chop", "id"));
        this.h = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        String strA = g.a().a(com.anythink.core.common.a.b.d.f);
        if (!TextUtils.isEmpty(strA)) {
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (ChopOnceG2CV2View.this.d != null) {
                        ChopOnceG2CV2View.this.d.setImageBitmap(bitmap);
                    }
                }
            });
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChopOnceG2CV2View.this.removeAllViews();
                    ChopOnceG2CV2View.this.d();
                }
            });
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChopOnceG2CV2View.this.removeAllViews();
                    ChopOnceG2CV2View.this.d();
                }
            });
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        ImageView imageView3 = this.h;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChopOnceG2CV2View.this.c();
                }
            });
        }
        setClipChildren(false);
        if (this.f == null && this.d != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.f = rotateAnimation;
            rotateAnimation.setDuration(com.anythink.basead.exoplayer.i.a.f);
            this.f.setInterpolator(new LinearInterpolator());
            this.f.setRepeatCount(-1);
            this.d.startAnimation(this.f);
        }
        if (this.g != null || this.e == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, q.a(getContext(), 10.0f));
        this.g = translateAnimation;
        translateAnimation.setDuration(500L);
        this.g.setRepeatCount(-1);
        this.g.setRepeatMode(2);
        this.e.startAnimation(this.g);
    }

    private void f() {
        if (this.f == null && this.d != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.f = rotateAnimation;
            rotateAnimation.setDuration(com.anythink.basead.exoplayer.i.a.f);
            this.f.setInterpolator(new LinearInterpolator());
            this.f.setRepeatCount(-1);
            this.d.startAnimation(this.f);
        }
        if (this.g != null || this.e == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, q.a(getContext(), 10.0f));
        this.g = translateAnimation;
        translateAnimation.setDuration(500L);
        this.g.setRepeatCount(-1);
        this.g.setRepeatMode(2);
        this.e.startAnimation(this.g);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void a() {
        super.a();
        Animation animation = this.f;
        if (animation != null) {
            animation.start();
        }
        Animation animation2 = this.g;
        if (animation2 != null) {
            animation2.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void b() {
        super.b();
        Animation animation = this.f;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.g;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        Animation animation = this.f;
        if (animation != null) {
            animation.cancel();
            this.f = null;
        }
        Animation animation2 = this.g;
        if (animation2 != null) {
            animation2.cancel();
            this.g = null;
        }
    }

    private void g() {
        Animation animation = this.f;
        if (animation != null) {
            animation.cancel();
            this.f = null;
        }
        Animation animation2 = this.g;
        if (animation2 != null) {
            animation2.cancel();
            this.g = null;
        }
    }
}
