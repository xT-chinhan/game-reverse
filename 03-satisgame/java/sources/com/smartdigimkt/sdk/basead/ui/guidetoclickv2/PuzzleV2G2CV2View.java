package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.picverify.TextSeekbar;
import com.smartdigimkt.y1.u0;
import com.smartdigimkt.y1.v0;
import com.smartdigimkt.y1.w0;
import com.smartdigimkt.y1.x0;
import com.smartdigimkt.y1.y0;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class PuzzleV2G2CV2View extends BaseLifecycleG2CV2View {
    public static final /* synthetic */ int t = 0;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public int l;
    public TranslateAnimation m;
    public TextSeekbar n;
    public int o;
    public boolean p;
    public boolean q;
    public ValueAnimator r;
    public int s;

    public PuzzleV2G2CV2View(Context context) {
        super(context);
        this.s = -1;
    }

    public static void a(PuzzleV2G2CV2View puzzleV2G2CV2View, int i) {
        TextSeekbar textSeekbar = puzzleV2G2CV2View.n;
        if (textSeekbar != null) {
            textSeekbar.setClickable(false);
            puzzleV2G2CV2View.n.setEnabled(false);
            if (puzzleV2G2CV2View.r == null) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 100);
                puzzleV2G2CV2View.r = valueAnimatorOfInt;
                valueAnimatorOfInt.addUpdateListener(new y0(puzzleV2G2CV2View));
                puzzleV2G2CV2View.r.setDuration(300L);
                puzzleV2G2CV2View.r.start();
            }
        }
    }

    public static void b(PuzzleV2G2CV2View puzzleV2G2CV2View, int i) {
        ImageView imageView = puzzleV2G2CV2View.j;
        if (imageView != null) {
            imageView.setTranslationX((i * puzzleV2G2CV2View.o) / 100);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public boolean canStartNextAnim() {
        ValueAnimator valueAnimator = this.r;
        return valueAnimator == null || !valueAnimator.isRunning();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View
    public int getClickArea() {
        return 45;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_puzzle_v2", "layout"), this);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.i = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        this.j = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_lucky_bag_iv", "id"));
        this.k = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_g2c_finger", "id"));
        if (this.j != null) {
            String strB = d.a().b(b.d.l);
            if (!TextUtils.isEmpty(strB)) {
                d0.a().a(new o(3, strB), -1, -1, new u0(this));
            }
        }
        if (this.k != null) {
            String strB2 = d.a().b(b.d.k);
            if (!TextUtils.isEmpty(strB2)) {
                d0.a().a(new o(3, strB2), -1, -1, new v0(this));
            }
        }
        this.l = k.a(getContext(), 20.0f);
        this.o = k.a(getContext(), 176.0f);
        TextSeekbar textSeekbar = (TextSeekbar) findViewById(k.a(getContext(), "myoffer_g2c_picvertify_seekbar", "id"));
        this.n = textSeekbar;
        if (textSeekbar != null) {
            textSeekbar.hideAll();
            this.n.setProgressDrawable(null);
            this.n.setThumb(null);
            this.n.setThumbOffset(0);
            this.n.setOnSeekBarChangeListener(new w0(this));
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener(new x0(this));
        }
        if (this.m != null || this.k == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.l, 0.0f, 0.0f);
        this.m = translateAnimation;
        translateAnimation.setDuration(1000L);
        this.m.setRepeatCount(-1);
        this.k.startAnimation(this.m);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void pauseAnim() {
        super.pauseAnim();
        TranslateAnimation translateAnimation = this.m;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        TranslateAnimation translateAnimation = this.m;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void resumeAnim() {
        super.resumeAnim();
        TranslateAnimation translateAnimation = this.m;
        if (translateAnimation != null) {
            translateAnimation.start();
        }
    }

    public PuzzleV2G2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = -1;
    }

    public PuzzleV2G2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = -1;
    }
}
