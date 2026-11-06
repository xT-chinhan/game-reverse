package com.anythink.basead.ui.guidetoclickv2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView;
import com.anythink.basead.ui.guidetoclickv2.picverify.TextSeekbar;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class PicVerifyG2CV2View extends BaseG2CV2View {
    PictureVerifyView d;
    TextSeekbar e;
    String f;
    ValueAnimator g;
    ValueAnimator h;
    int i;
    private boolean j;
    private boolean k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;

    public PicVerifyG2CV2View(Context context) {
        super(context);
        this.l = 30;
        this.m = 15;
        this.n = 500;
        this.o = 300;
        this.i = -1;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_pic_vertify", "layout"), this);
        this.d = (PictureVerifyView) findViewById(q.a(getContext(), "myoffer_g2c_picvertify", "id"));
        this.e = (TextSeekbar) findViewById(q.a(getContext(), "myoffer_g2c_picvertify_seekbar", "id"));
        final int iA = q.a(getContext(), 48.0f);
        this.d.setBlockSize(iA);
        this.d.callback(new PictureVerifyView.a() { // from class: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.1
            @Override // com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a
            public final void b() {
            }

            @Override // com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a
            public final void a() {
                if (PicVerifyG2CV2View.this.c != null) {
                    PicVerifyG2CV2View.this.c.a(11, 16);
                }
            }
        });
        if (!TextUtils.isEmpty(this.f)) {
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.f), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, PicVerifyG2CV2View.this.f)) {
                        DisplayMetrics displayMetrics = PicVerifyG2CV2View.this.getContext().getResources().getDisplayMetrics();
                        int[] iArrA = am.a(displayMetrics.widthPixels, displayMetrics.heightPixels, bitmap.getWidth() / bitmap.getHeight());
                        int i3 = iA * 2;
                        if (bitmap.getWidth() < i3 || bitmap.getHeight() < i3) {
                            if (PicVerifyG2CV2View.this.a != null) {
                                PicVerifyG2CV2View.this.a.a();
                                return;
                            }
                            return;
                        }
                        int iA2 = q.a(PicVerifyG2CV2View.this.getContext(), 180.0f);
                        if (iArrA[0] < iA2 || iArrA[1] < iA2) {
                            if (PicVerifyG2CV2View.this.a != null) {
                                PicVerifyG2CV2View.this.a.a();
                                return;
                            }
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams = PicVerifyG2CV2View.this.d.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iArrA[0];
                            layoutParams.height = iArrA[1];
                            PicVerifyG2CV2View.this.d.setLayoutParams(layoutParams);
                        }
                        PicVerifyG2CV2View.this.d.setImageBitmap(bitmap);
                        PicVerifyG2CV2View.this.post(new Runnable() { // from class: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ((RelativeLayout.LayoutParams) PicVerifyG2CV2View.this.e.getLayoutParams()).setMargins(0, (PicVerifyG2CV2View.this.getMeasuredHeight() / 2) + (iA / 2), 0, 0);
                                PicVerifyG2CV2View.this.e.setVisibility(0);
                                PicVerifyG2CV2View.a(PicVerifyG2CV2View.this);
                            }
                        });
                    }
                }
            });
        }
        this.e.setProgressDrawable(getResources().getDrawable(q.a(getContext(), "myoffer_g2c_seek_bar_bg", "drawable")));
        TextSeekbar textSeekbar = this.e;
        Context context = getContext();
        int iA2 = q.a(getContext(), "myoffer_seek_bar_icon", "drawable");
        textSeekbar.setThumb(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), iA2), q.a(getContext(), 60.0f), q.a(getContext(), 24.0f), false)));
        this.e.setThumbOffset(0);
        this.e.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                if (z) {
                    if (PicVerifyG2CV2View.this.k) {
                        PicVerifyG2CV2View.this.k = false;
                        if (i3 > 30) {
                            PicVerifyG2CV2View.this.j = false;
                        } else {
                            PicVerifyG2CV2View.this.j = true;
                        }
                    }
                    if (!PicVerifyG2CV2View.this.j) {
                        seekBar.setProgress(0);
                        return;
                    } else if (i3 > 30) {
                        PicVerifyG2CV2View.a(PicVerifyG2CV2View.this, i3);
                        return;
                    } else {
                        PicVerifyG2CV2View.this.d.move(i3);
                        return;
                    }
                }
                PicVerifyG2CV2View.this.d.move(i3);
                if (i3 == 100) {
                    PicVerifyG2CV2View.this.d.loose();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onStartTrackingTouch(SeekBar seekBar) {
                PicVerifyG2CV2View.this.k = true;
                PicVerifyG2CV2View.d(PicVerifyG2CV2View.this);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onStopTrackingTouch(SeekBar seekBar) {
                if (PicVerifyG2CV2View.this.j) {
                    PicVerifyG2CV2View.this.d.loose();
                }
                PicVerifyG2CV2View.a(PicVerifyG2CV2View.this);
            }
        });
    }

    public void loadImage(String str) {
        this.f = str;
    }

    private void d() {
        this.e.setProgress(0);
    }

    private void e() {
        if (this.g == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 15);
            this.g = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(new AnonymousClass4());
            this.g.setRepeatMode(2);
            this.g.setRepeatCount(-1);
            this.g.setDuration(500L);
        }
        if (this.g.isStarted() || this.h != null) {
            return;
        }
        this.g.start();
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$4, reason: invalid class name */
    final class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            PicVerifyG2CV2View.this.e.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private void f() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private void a(int i) {
        this.e.setClickable(false);
        this.e.setEnabled(false);
        this.e.getProgressDrawable().setAlpha(255);
        if (this.h == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 100);
            this.h = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(new AnonymousClass5());
            this.h.setDuration(300L);
            this.h.start();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$5, reason: invalid class name */
    final class AnonymousClass5 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (PicVerifyG2CV2View.this.i != iIntValue) {
                PicVerifyG2CV2View.this.i = iIntValue;
                PicVerifyG2CV2View.this.e.setProgress(iIntValue);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.h;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public boolean canStartNextAnim() {
        return this.h == null;
    }

    private BitmapDrawable a(Context context, int i, int i2, int i3) {
        return new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), i), i2, i3, false));
    }

    static /* synthetic */ void a(PicVerifyG2CV2View picVerifyG2CV2View) {
        if (picVerifyG2CV2View.g == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 15);
            picVerifyG2CV2View.g = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(picVerifyG2CV2View.new AnonymousClass4());
            picVerifyG2CV2View.g.setRepeatMode(2);
            picVerifyG2CV2View.g.setRepeatCount(-1);
            picVerifyG2CV2View.g.setDuration(500L);
        }
        if (picVerifyG2CV2View.g.isStarted() || picVerifyG2CV2View.h != null) {
            return;
        }
        picVerifyG2CV2View.g.start();
    }

    static /* synthetic */ void a(PicVerifyG2CV2View picVerifyG2CV2View, int i) {
        picVerifyG2CV2View.e.setClickable(false);
        picVerifyG2CV2View.e.setEnabled(false);
        picVerifyG2CV2View.e.getProgressDrawable().setAlpha(255);
        if (picVerifyG2CV2View.h == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 100);
            picVerifyG2CV2View.h = valueAnimatorOfInt;
            valueAnimatorOfInt.addUpdateListener(picVerifyG2CV2View.new AnonymousClass5());
            picVerifyG2CV2View.h.setDuration(300L);
            picVerifyG2CV2View.h.start();
        }
    }

    static /* synthetic */ void d(PicVerifyG2CV2View picVerifyG2CV2View) {
        ValueAnimator valueAnimator = picVerifyG2CV2View.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
