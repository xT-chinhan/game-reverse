package com.byazt.cg;

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
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 37})
public class pr extends fw {
    public float aj;
    public final Runnable g;
    public LottieAnimationView k;
    public final Handler m;
    public ImageView vk;
    public Drawable w;
    public float zo;

    public pr(com.byazt.dx.zo zoVar, zo zoVar2, Context context) {
        super(zoVar, zoVar2);
        this.zo = -1.0f;
        this.aj = -1.0f;
        this.m = new Handler(Looper.getMainLooper());
        this.g = new Runnable() { // from class: com.byazt.cg.pr.5
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.k != null && pr.this.k.c()) {
                    pr.this.k.invalidate();
                }
                pr.this.m.postDelayed(pr.this.g, 40L);
            }
        };
        if (this.fw != null && zoVar != null) {
            LottieAnimationView lottieAnimationViewHw = zoVar.hw();
            this.k = lottieAnimationViewHw;
            if (lottieAnimationViewHw == null) {
                return;
            }
            float fPr = com.byazt.ptr.vk.pr();
            this.zo = (int) (this.fw.pr() * fPr);
            this.aj = (int) (this.fw.hw() * fPr);
            cz czVarZ = zoVar.z();
            String strPr = czVarZ != null ? czVarZ.pr(this.fw.m()) : null;
            if (!TextUtils.isEmpty(strPr)) {
                ImageView imageView = new ImageView(context);
                this.vk = imageView;
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.vk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.cg.pr.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        if (pr.this.vk == view) {
                            pr.this.yb();
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        if (pr.this.vk == view) {
                            pr.this.ho();
                            if (Build.VERSION.SDK_INT >= 28 && (pr.this.w instanceof AnimatedImageDrawable)) {
                                ((AnimatedImageDrawable) pr.this.w).stop();
                            }
                        }
                    }
                });
                this.k.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.cg.pr.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        if (pr.this.k == view) {
                            if (pr.this.hw()) {
                                pr.this.k.removeOnAttachStateChangeListener(this);
                            } else {
                                pr.this.pr(new Runnable() { // from class: com.byazt.cg.pr.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        pr.this.lb();
                                    }
                                });
                            }
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        if (pr.this.k == view) {
                            pr.this.pr(new Runnable() { // from class: com.byazt.cg.pr.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ViewParent parent = pr.this.vk.getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(pr.this.vk);
                                    }
                                }
                            });
                        }
                    }
                });
                pr(strPr, context);
            }
        }
    }

    private void pr(String str, Context context) {
        File file = new File(com.byazt.ptr.hn.pr(context), com.byazt.ca.c.hw(str));
        if (file.exists()) {
            pr(file);
        } else {
            com.byazt.ptr.hn.pr(str, context, new com.byazt.ptr.hn.pr<File>() { // from class: com.byazt.cg.pr.3
                @Override // com.byazt.ptr.hn.pr
                public void pr(File file2) {
                    pr.this.pr(file2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawable = this.w;
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).stop();
                }
                this.w = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.m.post(new Runnable() { // from class: com.byazt.cg.pr.4
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.lb();
                    }
                });
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho() {
        this.m.removeCallbacksAndMessages(null);
    }

    private void nt() {
        ho();
        if (this.k != null) {
            this.m.postDelayed(this.g, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        if (Build.VERSION.SDK_INT >= 28) {
            Drawable drawable = this.w;
            if (!(drawable instanceof AnimatedImageDrawable) || ((AnimatedImageDrawable) drawable).isRunning()) {
                return;
            }
            ((AnimatedImageDrawable) this.w).setRepeatCount(-1);
            ((AnimatedImageDrawable) this.w).start();
            nt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        if (this.w != null) {
            ViewParent parent = this.vk.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.vk);
            }
            ViewParent parent2 = this.k.getParent();
            if (parent2 instanceof ViewGroup) {
                this.vk.setTranslationX(2.1474836E9f);
                this.vk.setImageDrawable(this.w);
                ((ViewGroup) parent2).addView(this.vk);
            }
        }
    }

    @Override // com.byazt.cg.fw, com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        if (this.zo > 0.0f && this.vk != null) {
            canvas.save();
            canvas.concat(matrix);
            pr(i);
            float fZo = zo();
            pr(this.vk, (int) this.zo, (int) this.aj);
            this.vk.setAlpha(fZo);
            canvas.clipRect(0.0f, 0.0f, this.zo, this.aj);
            this.vk.draw(canvas);
            canvas.restore();
        }
    }

    private static void pr(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
