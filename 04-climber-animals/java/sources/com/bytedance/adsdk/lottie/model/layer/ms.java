package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.t;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ab {
    private ImageView ch;
    private Drawable hi;
    private float ny;
    private LottieAnimationView sl;
    private final Runnable u;
    private float x;
    private final Handler zb;

    public ms(com.bytedance.adsdk.lottie.x xVar, x xVar2, Context context) {
        super(xVar, xVar2);
        this.x = -1.0f;
        this.ny = -1.0f;
        this.zb = new Handler(Looper.getMainLooper());
        this.u = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.5
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.sl != null && ms.this.sl.ka()) {
                    ms.this.sl.invalidate();
                }
                ms.this.zb.postDelayed(ms.this.u, 40L);
            }
        };
        if (this.ab == null || xVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewXr = xVar.xr();
        this.sl = lottieAnimationViewXr;
        if (lottieAnimationViewXr == null) {
            return;
        }
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        this.x = (int) (this.ab.ms() * fMs);
        this.ny = (int) (this.ab.xr() * fMs);
        t tVarW = xVar.w();
        String strMs = tVarW != null ? tVarW.ms(this.ab.sl()) : null;
        if (TextUtils.isEmpty(strMs)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.ch = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ch.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (ms.this.ch == view) {
                    ms.this.ao();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (ms.this.ch == view) {
                    ms.this.u();
                    if (Build.VERSION.SDK_INT < 28 || !(ms.this.hi instanceof AnimatedImageDrawable)) {
                        return;
                    }
                    ((AnimatedImageDrawable) ms.this.hi).stop();
                }
            }
        });
        this.sl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (ms.this.sl == view) {
                    if (ms.this.xr()) {
                        ms.this.sl.removeOnAttachStateChangeListener(this);
                    } else {
                        ms.this.ms(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ms.this.h();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (ms.this.sl == view) {
                    ms.this.ms(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = ms.this.ch.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(ms.this.ch);
                            }
                        }
                    });
                }
            }
        });
        ms(strMs, context);
    }

    private void ms(String str, Context context) {
        File file = new File(com.bytedance.adsdk.lottie.ka.xr.ms(context), com.bytedance.sdk.component.utils.ka.xr(str));
        if (file.exists()) {
            ms(file);
        } else {
            com.bytedance.adsdk.lottie.ka.xr.ms(str, context, new com.bytedance.adsdk.lottie.ka.xr.ms<File>() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.3
                @Override // com.bytedance.adsdk.lottie.ka.xr.ms
                public void ms(File file2) {
                    ms.this.ms(file2);
                }

                @Override // com.bytedance.adsdk.lottie.ka.xr.ms
                public void ms(int i, String str2) {
                    com.bytedance.sdk.component.utils.sl.ms("TMe", "--==--- webp: " + i + ", " + str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawable = this.hi;
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).stop();
                }
                this.hi = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.zb.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.ms.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.h();
                    }
                });
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.zb.removeCallbacksAndMessages(null);
    }

    private void ub() {
        u();
        if (this.sl != null) {
            this.zb.postDelayed(this.u, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        if (Build.VERSION.SDK_INT >= 28) {
            Drawable drawable = this.hi;
            if (!(drawable instanceof AnimatedImageDrawable) || ((AnimatedImageDrawable) drawable).isRunning()) {
                return;
            }
            ((AnimatedImageDrawable) this.hi).setRepeatCount(-1);
            ((AnimatedImageDrawable) this.hi).start();
            ub();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.hi != null) {
            ViewParent parent = this.ch.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.ch);
            }
            ViewParent parent2 = this.sl.getParent();
            if (parent2 instanceof ViewGroup) {
                this.ch.setTranslationX(2.1474836E9f);
                this.ch.setImageDrawable(this.hi);
                ((ViewGroup) parent2).addView(this.ch);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ab, com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        if (this.x <= 0.0f || this.ch == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        ms(i);
        float fX = x();
        ms(this.ch, (int) this.x, (int) this.ny);
        this.ch.setAlpha(fX);
        canvas.clipRect(0.0f, 0.0f, this.x, this.ny);
        this.ch.draw(canvas);
        canvas.restore();
    }

    private static void ms(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
