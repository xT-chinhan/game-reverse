package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.picverify.PictureVerifyView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.picverify.TextSeekbar;
import com.smartdigimkt.y1.o0;
import com.smartdigimkt.y1.q0;
import com.smartdigimkt.y1.r0;
import com.smartdigimkt.y1.s0;
import com.smartdigimkt.y1.t0;

/* JADX INFO: loaded from: classes3.dex */
public class PicVerifyG2CV2View extends BaseG2CV2View {
    public PictureVerifyView h;
    public TextSeekbar i;
    public String j;
    public boolean k;
    public boolean l;
    public ValueAnimator m;
    public ValueAnimator n;
    public int o;

    public PicVerifyG2CV2View(Context context) {
        super(context);
        this.o = -1;
    }

    public static void a(PicVerifyG2CV2View picVerifyG2CV2View) {
        if (picVerifyG2CV2View.m == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 15);
            picVerifyG2CV2View.m = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(new s0(picVerifyG2CV2View));
            picVerifyG2CV2View.m.setRepeatMode(2);
            picVerifyG2CV2View.m.setRepeatCount(-1);
            picVerifyG2CV2View.m.setDuration(500L);
        }
        if (picVerifyG2CV2View.m.isStarted() || picVerifyG2CV2View.n != null) {
            return;
        }
        picVerifyG2CV2View.m.start();
    }

    public static void b(PicVerifyG2CV2View picVerifyG2CV2View) {
        ValueAnimator valueAnimator = picVerifyG2CV2View.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public boolean canStartNextAnim() {
        return this.n == null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_pic_vertify", "layout"), this);
        this.h = (PictureVerifyView) findViewById(k.a(getContext(), "myoffer_g2c_picvertify", "id"));
        this.i = (TextSeekbar) findViewById(k.a(getContext(), "myoffer_g2c_picvertify_seekbar", "id"));
        int iA = k.a(getContext(), 48.0f);
        this.h.setBlockSize(iA);
        this.h.callback(new o0(this));
        if (!TextUtils.isEmpty(this.j)) {
            m.a(getContext()).a(new o(1, this.j), -1, -1, new q0(this, iA));
        }
        this.i.setProgressDrawable(getResources().getDrawable(k.a(getContext(), "myoffer_g2c_seek_bar_bg", "drawable")));
        TextSeekbar textSeekbar = this.i;
        Context context = getContext();
        int iA2 = k.a(getContext(), "myoffer_seek_bar_icon", "drawable");
        textSeekbar.setThumb(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), iA2), k.a(getContext(), 60.0f), k.a(getContext(), 24.0f), false)));
        this.i.setThumbOffset(0);
        this.i.setOnSeekBarChangeListener(new r0(this));
    }

    public void loadImage(String str) {
        this.j = str;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.n;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    public static void a(PicVerifyG2CV2View picVerifyG2CV2View, int i) {
        picVerifyG2CV2View.i.setClickable(false);
        picVerifyG2CV2View.i.setEnabled(false);
        picVerifyG2CV2View.i.getProgressDrawable().setAlpha(255);
        if (picVerifyG2CV2View.n == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 100);
            picVerifyG2CV2View.n = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(new t0(picVerifyG2CV2View));
            picVerifyG2CV2View.n.setDuration(300L);
            picVerifyG2CV2View.n.start();
        }
    }
}
