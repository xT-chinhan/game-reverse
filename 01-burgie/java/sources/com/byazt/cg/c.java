package com.byazt.cg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends fw {
    public float aj;
    public com.byazt.dx.aj.pr.C0046pr k;
    public VideoFrame vk;
    public LottieAnimationView w;
    public float zo;

    public c(com.byazt.dx.zo zoVar, zo zoVar2, Context context, com.byazt.dx.aj.pr.C0046pr c0046pr) {
        super(zoVar, zoVar2);
        this.zo = -1.0f;
        this.aj = -1.0f;
        this.k = c0046pr;
        if (this.fw != null && zoVar != null) {
            LottieAnimationView lottieAnimationViewHw = zoVar.hw();
            this.w = lottieAnimationViewHw;
            if (lottieAnimationViewHw == null) {
                return;
            }
            float fPr = com.byazt.ptr.vk.pr();
            this.zo = (int) (this.fw.pr() * fPr);
            this.aj = (int) (this.fw.hw() * fPr);
            ny nyVarPr = zoVar.pr();
            View viewPr = nyVarPr != null ? nyVarPr.pr("videoview:", null) : null;
            if (viewPr instanceof TextureView) {
                this.vk = new VideoFrame(context, (TextureView) viewPr, c0046pr);
            }
            this.w.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.cg.c.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (c.this.w == view) {
                        c.this.ho();
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
            ho();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho() {
        VideoFrame videoFrame = this.vk;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.vk);
            }
            ViewParent parent2 = this.w.getParent();
            if (parent2 instanceof ViewGroup) {
                this.vk.setTranslationX(2.1474836E9f);
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
