package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.e;
import com.smartdigimkt.y1.f;
import com.smartdigimkt.y1.g;
import com.smartdigimkt.y1.h;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class ChopOnceG2CV2View extends BaseLifecycleG2CV2View {
    public ImageView i;
    public ImageView j;
    public RotateAnimation k;
    public TranslateAnimation l;
    public ImageView m;

    public ChopOnceG2CV2View(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View
    public int getClickArea() {
        return 44;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_chop_once", "layout"), this);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.i = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_gift_group", "id"));
        this.j = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_gift_chop", "id"));
        this.m = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        String strB = d.a().b(b.d.f);
        if (!TextUtils.isEmpty(strB)) {
            d0.a().a(new o(3, strB), -1, -1, new com.smartdigimkt.y1.d(this));
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener(new e(this));
        }
        ImageView imageView2 = this.j;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new f(this));
        }
        setOnClickListener(new g());
        ImageView imageView3 = this.m;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new h(this));
        }
        setClipChildren(false);
        if (this.k == null && this.i != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.k = rotateAnimation;
            rotateAnimation.setDuration(2000L);
            this.k.setInterpolator(new LinearInterpolator());
            this.k.setRepeatCount(-1);
            this.i.startAnimation(this.k);
        }
        if (this.l != null || this.j == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, k.a(getContext(), 10.0f));
        this.l = translateAnimation;
        translateAnimation.setDuration(500L);
        this.l.setRepeatCount(-1);
        this.l.setRepeatMode(2);
        this.j.startAnimation(this.l);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void pauseAnim() {
        super.pauseAnim();
        RotateAnimation rotateAnimation = this.k;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
        TranslateAnimation translateAnimation = this.l;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        RotateAnimation rotateAnimation = this.k;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.k = null;
        }
        TranslateAnimation translateAnimation = this.l;
        if (translateAnimation != null) {
            translateAnimation.cancel();
            this.l = null;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void resumeAnim() {
        super.resumeAnim();
        RotateAnimation rotateAnimation = this.k;
        if (rotateAnimation != null) {
            rotateAnimation.start();
        }
        TranslateAnimation translateAnimation = this.l;
        if (translateAnimation != null) {
            translateAnimation.start();
        }
    }

    public ChopOnceG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChopOnceG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
