package com.smartdigimkt.sdk.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.n1.f3;
import com.smartdigimkt.n1.g3;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class GuideToClickView extends RelativeLayout {
    public WaveAnimImageView a;
    public WaveAnimImageView b;
    public ImageView c;
    public TextView d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public ValueAnimator k;
    public ValueAnimator l;
    public ScaleAnimation m;

    public GuideToClickView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(k.a(context, "myoffer_guide_to_click", "layout"), this);
        setBackgroundColor(Color.parseColor("#66000000"));
        this.e = 0.8f;
        this.f = 0.05f;
        this.g = k.a(context, 4.0f);
        this.h = (int) ((context.getResources().getDisplayMetrics().density * 18.0f) + 0.5f);
        this.i = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
        this.j = (int) ((context.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
        this.a = (WaveAnimImageView) findViewById(k.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (WaveAnimImageView) findViewById(k.a(context, "myoffer_wave_anim_image2", "id"));
        this.k = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = (ImageView) findViewById(k.a(context, "myoffer_guide_to_click_finger", "id"));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.m = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.m.setRepeatCount(-1);
        this.m.setDuration(333L);
        this.d = (TextView) findViewById(k.a(context, "myoffer_guide_to_click_hint", "id"));
        String strB = d.a().b(b.d.i);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        d0.a().a(new o(3, strB), -1, -1, new f3(this));
    }

    public void hideBackground() {
        setBackgroundColor(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim(this.k, this.a, 0L);
        startAnim(this.l, this.b, 800L);
        this.c.startAnimation(this.m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.l;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ScaleAnimation scaleAnimation = this.m;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    public void setFingerImageResource(Bitmap bitmap) {
        ImageView imageView = this.c;
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    public void setFingerViewMode(int i) {
        int iA;
        int iA2;
        hideBackground();
        k.a(getContext(), 200.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        switch (i) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE /* 501 */:
            case 507:
                layoutParams.addRule(14);
                layoutParams.addRule(13, 0);
                this.a.setLayoutParams(layoutParams);
                layoutParams2.addRule(14);
                layoutParams2.addRule(13, 0);
                this.b.setLayoutParams(layoutParams2);
                break;
            case 502:
            case 503:
                if (i == 502) {
                    iA = k.a(getContext(), 100.0f);
                    this.d.setTextSize(1, 14.0f);
                    this.h = k.a(getContext(), 12.0f);
                    this.j = k.a(getContext(), 30.0f);
                } else {
                    iA = k.a(getContext(), 160.0f);
                    this.d.setTextSize(1, 16.0f);
                }
                layoutParams.width = iA;
                layoutParams.height = iA;
                layoutParams.addRule(14);
                layoutParams.addRule(13, 0);
                layoutParams2.width = iA;
                layoutParams2.height = iA;
                layoutParams2.addRule(14);
                layoutParams2.addRule(13, 0);
                int i2 = iA / 2;
                layoutParams3.width = i2;
                layoutParams3.height = (int) ((((double) iA) / 2.0d) * 1.1d);
                layoutParams3.setMargins(i2, i2, 0, 0);
                break;
            case 504:
            case 505:
            case 506:
                if (i == 505 || i == 504) {
                    iA2 = k.a(getContext(), 50.0f);
                    this.h = k.a(getContext(), 6.0f);
                    this.j = k.a(getContext(), 18.0f);
                } else {
                    iA2 = k.a(getContext(), 120.0f);
                    this.h = k.a(getContext(), 8.0f);
                    this.j = k.a(getContext(), 24.0f);
                }
                layoutParams.width = iA2;
                layoutParams.height = iA2;
                layoutParams.addRule(15);
                layoutParams.addRule(13, 0);
                this.a.setLayoutParams(layoutParams);
                layoutParams2.width = iA2;
                layoutParams2.height = iA2;
                layoutParams2.addRule(15);
                layoutParams2.addRule(13, 0);
                this.b.setLayoutParams(layoutParams2);
                int i3 = iA2 / 2;
                layoutParams3.width = i3;
                layoutParams3.height = (int) ((((double) iA2) / 2.0d) * 1.1d);
                layoutParams3.setMargins(i3, i3, 0, 0);
                this.c.setLayoutParams(layoutParams3);
                layoutParams4.addRule(14, 0);
                layoutParams4.addRule(3, 0);
                layoutParams4.addRule(15);
                layoutParams4.addRule(1, this.a.getId());
                layoutParams4.setMargins(k.a(getContext(), 6.0f), 0, k.a(getContext(), 10.0f), 0);
                this.d.setLayoutParams(layoutParams4);
                this.d.setTextSize(1, 12.0f);
                break;
        }
    }

    public void startAnim(ValueAnimator valueAnimator, WaveAnimImageView waveAnimImageView, long j) {
        if (valueAnimator != null) {
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setDuration(1400L);
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new g3(this, waveAnimImageView));
            valueAnimator.setStartDelay(j);
            valueAnimator.start();
        }
    }

    public GuideToClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public GuideToClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
