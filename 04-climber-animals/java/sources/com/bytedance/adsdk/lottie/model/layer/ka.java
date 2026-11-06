package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.nw;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ab {
    private VideoFrame ch;
    private LottieAnimationView hi;
    private float ny;
    private com.bytedance.adsdk.lottie.ny.ms.C0190ms sl;
    private float x;

    public ka(com.bytedance.adsdk.lottie.x xVar, x xVar2, Context context, com.bytedance.adsdk.lottie.ny.ms.C0190ms c0190ms) {
        super(xVar, xVar2);
        this.x = -1.0f;
        this.ny = -1.0f;
        this.sl = c0190ms;
        if (this.ab == null || xVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewXr = xVar.xr();
        this.hi = lottieAnimationViewXr;
        if (lottieAnimationViewXr == null) {
            return;
        }
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        this.x = (int) (this.ab.ms() * fMs);
        this.ny = (int) (this.ab.xr() * fMs);
        nw nwVarMs = xVar.ms();
        View viewMs = nwVarMs != null ? nwVarMs.ms("videoview:", null) : null;
        if (viewMs instanceof TextureView) {
            this.ch = new VideoFrame(context, (TextureView) viewMs, c0190ms);
        }
        this.hi.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.ka.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (ka.this.hi == view) {
                    ka.this.u();
                }
            }
        });
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        VideoFrame videoFrame = this.ch;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.ch);
            }
            ViewParent parent2 = this.hi.getParent();
            if (parent2 instanceof ViewGroup) {
                this.ch.setTranslationX(2.1474836E9f);
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
        this.ch.draw(canvas);
        canvas.restore();
    }

    private static void ms(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
