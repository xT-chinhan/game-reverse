package com.byazt.eg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.ou;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 18})
public class l extends x {
    public LottieAnimationView cp;
    public com.byazt.pp.rv.n.C0302n d;
    public float fs;
    public float rv;
    public VideoFrame tj;

    public l(com.byazt.pp.fs fsVar, fs fsVar2, Context context, com.byazt.pp.rv.n.C0302n c0302n) {
        super(fsVar, fsVar2);
        this.fs = -1.0f;
        this.rv = -1.0f;
        this.d = c0302n;
        if (this.x == null || fsVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewQg = fsVar.qg();
        this.cp = lottieAnimationViewQg;
        if (lottieAnimationViewQg == null) {
            return;
        }
        float fN = com.byazt.nu.tj.n();
        this.fs = (int) (this.x.n() * fN);
        this.rv = (int) (this.x.qg() * fN);
        ou ouVarN = fsVar.n();
        View viewN = ouVarN != null ? ouVarN.n("videoview:", null) : null;
        if (viewN instanceof TextureView) {
            this.tj = new VideoFrame(context, (TextureView) viewN, c0302n);
        }
        this.cp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.eg.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (l.this.cp == view) {
                    l.this.k();
                }
            }
        });
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        VideoFrame videoFrame = this.tj;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tj);
            }
            ViewParent parent2 = this.cp.getParent();
            if (parent2 instanceof ViewGroup) {
                this.tj.setTranslationX(2.1474836E9f);
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
        this.tj.draw(canvas);
        canvas.restore();
    }

    private static void n(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i2, C.ENCODING_PCM_32BIT));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
