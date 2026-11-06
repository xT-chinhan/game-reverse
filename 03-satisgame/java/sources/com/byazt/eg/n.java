package com.byazt.eg;

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
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.py;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 19})
public class n extends x {
    public Drawable cp;
    public LottieAnimationView d;
    public float fs;
    public final Handler oa;
    public float rv;
    public final Runnable sz;
    public ImageView tj;

    public n(com.byazt.pp.fs fsVar, fs fsVar2, Context context) {
        super(fsVar, fsVar2);
        this.fs = -1.0f;
        this.rv = -1.0f;
        this.oa = new Handler(Looper.getMainLooper());
        this.sz = new Runnable() { // from class: com.byazt.eg.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.d != null && n.this.d.l()) {
                    n.this.d.invalidate();
                }
                n.this.oa.postDelayed(n.this.sz, 40L);
            }
        };
        if (this.x == null || fsVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewQg = fsVar.qg();
        this.d = lottieAnimationViewQg;
        if (lottieAnimationViewQg == null) {
            return;
        }
        float fN = com.byazt.nu.tj.n();
        this.fs = (int) (this.x.n() * fN);
        this.rv = (int) (this.x.qg() * fN);
        py pyVarHu = fsVar.hu();
        String strN = pyVarHu != null ? pyVarHu.n(this.x.oa()) : null;
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.tj = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.tj.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.eg.n.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (n.this.tj == view) {
                    n.this.hd();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (n.this.tj == view) {
                    n.this.k();
                    if (Build.VERSION.SDK_INT < 28 || !(n.this.cp instanceof AnimatedImageDrawable)) {
                        return;
                    }
                    ((AnimatedImageDrawable) n.this.cp).stop();
                }
            }
        });
        this.d.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.eg.n.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (n.this.d == view) {
                    if (n.this.qg()) {
                        n.this.d.removeOnAttachStateChangeListener(this);
                    } else {
                        n.this.n(new Runnable() { // from class: com.byazt.eg.n.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.cd();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (n.this.d == view) {
                    n.this.n(new Runnable() { // from class: com.byazt.eg.n.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = n.this.tj.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(n.this.tj);
                            }
                        }
                    });
                }
            }
        });
        n(strN, context);
    }

    private void n(String str, Context context) {
        File file = new File(com.byazt.nu.s.n(context), com.byazt.tk.l.qg(str));
        if (file.exists()) {
            n(file);
        } else {
            com.byazt.nu.s.n(str, context, new com.byazt.nu.s.n<File>() { // from class: com.byazt.eg.n.3
                @Override // com.byazt.nu.s.n
                public void n(File file2) {
                    n.this.n(file2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawable = this.cp;
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).stop();
                }
                this.cp = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.oa.post(new Runnable() { // from class: com.byazt.eg.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.cd();
                    }
                });
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.oa.removeCallbacksAndMessages(null);
    }

    private void cy() {
        k();
        if (this.d != null) {
            this.oa.postDelayed(this.sz, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        if (Build.VERSION.SDK_INT >= 28) {
            Drawable drawable = this.cp;
            if (!(drawable instanceof AnimatedImageDrawable) || ((AnimatedImageDrawable) drawable).isRunning()) {
                return;
            }
            ((AnimatedImageDrawable) this.cp).setRepeatCount(-1);
            ((AnimatedImageDrawable) this.cp).start();
            cy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        if (this.cp != null) {
            ViewParent parent = this.tj.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tj);
            }
            ViewParent parent2 = this.d.getParent();
            if (parent2 instanceof ViewGroup) {
                this.tj.setTranslationX(2.1474836E9f);
                this.tj.setImageDrawable(this.cp);
                ((ViewGroup) parent2).addView(this.tj);
            }
        }
    }

    @Override // com.byazt.eg.x, com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        if (this.fs <= 0.0f || this.tj == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        n(i);
        float fFs = fs();
        n(this.tj, (int) this.fs, (int) this.rv);
        this.tj.setAlpha(fFs);
        canvas.clipRect(0.0f, 0.0f, this.fs, this.rv);
        this.tj.draw(canvas);
        canvas.restore();
    }

    private static void n(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i2, C.ENCODING_PCM_32BIT));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
