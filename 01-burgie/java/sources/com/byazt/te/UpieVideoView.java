package com.byazt.te;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.c.SSRenderTextureView;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.aj;
import com.byazt.dx.cz;
import com.byazt.dx.ny;
import com.byazt.dx.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 1275})
public class UpieVideoView extends FrameLayout implements com.byazt.c.hw {
    public final Handler c;
    public com.byazt.c.hw.pr fw;
    public final Map<String, Bitmap> hn;
    public final LottieAnimationView hw;
    public final com.byazt.c.hw pr;
    public final Runnable uc;
    public final Map<String, Integer> x;

    public UpieVideoView(final Context context, final com.byazt.ic.pr prVar) {
        super(context);
        this.hn = new HashMap();
        this.x = new HashMap();
        this.c = new Handler(Looper.getMainLooper());
        this.uc = new Runnable() { // from class: com.byazt.te.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.hw != null && UpieVideoView.this.hw.c()) {
                    UpieVideoView.this.hw.invalidate();
                }
                UpieVideoView.this.c.postDelayed(UpieVideoView.this.uc, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.pr = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.hw = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new x() { // from class: com.byazt.te.UpieVideoView.1
            @Override // com.byazt.dx.x
            public Bitmap pr(aj ajVar) {
                if (ajVar != null) {
                    String strM = ajVar.m();
                    if (!TextUtils.isEmpty(strM)) {
                        if (strM.startsWith("${") && strM.endsWith("}")) {
                            com.byazt.ic.pr prVar2 = prVar;
                            if (prVar2 == null) {
                                return null;
                            }
                            strM = com.byazt.rhv.pr.pr(strM, prVar2.fw());
                            if (TextUtils.isEmpty(strM) || !strM.startsWith("http")) {
                                return null;
                            }
                        }
                        Bitmap bitmap = (Bitmap) UpieVideoView.this.hn.get(strM);
                        if (bitmap == null) {
                            UpieVideoView.this.pr(context, strM, ajVar.pr(), ajVar.hw());
                        } else {
                            return bitmap;
                        }
                    }
                }
                return null;
            }
        });
        lottieAnimationView.setTextDelegate(new cz(lottieAnimationView) { // from class: com.byazt.te.UpieVideoView.2
            @Override // com.byazt.dx.cz
            public String pr(String str) {
                com.byazt.ic.pr prVar2 = prVar;
                return com.byazt.rhv.pr.pr(str, prVar2 != null ? prVar2.fw() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new ny() { // from class: com.byazt.te.UpieVideoView.3
            @Override // com.byazt.dx.ny
            public View pr(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.pr.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.pr(new Animator.AnimatorListener() { // from class: com.byazt.te.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.hw != null) {
                    UpieVideoView.this.hw.hw(this);
                }
                UpieVideoView.this.x();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.te.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.hw == view) {
                    UpieVideoView.this.hn();
                }
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        this.c.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        hn();
        if (this.hw != null) {
            this.c.postDelayed(this.uc, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final Context context, final String str, final int i, final int i2) {
        Integer num = this.x.get(str);
        if (num == null || num.intValue() != 1) {
            this.x.put(str, 1);
            this.hw.pr(str, new com.byazt.rwn.aj() { // from class: com.byazt.te.UpieVideoView.7
                @Override // com.byazt.rwn.aj
                public void pr(Bitmap bitmap) {
                    UpieVideoView.this.pr(bitmap, str, i, i2);
                }

                @Override // com.byazt.rwn.aj
                public void pr() {
                    com.byazt.ic.hw.pr().pr(context, str, new com.byazt.ic.hw.pr<Bitmap>() { // from class: com.byazt.te.UpieVideoView.7.1
                        @Override // com.byazt.ic.hw.pr
                        public void pr(Bitmap bitmap) {
                            UpieVideoView.this.pr(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.ic.hw.pr
                        public void pr(int i3, String str2) {
                            UpieVideoView.this.x.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            }
            this.hn.put(str, bitmap);
        }
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.hw;
    }

    @Override // com.byazt.c.hw
    public void pr(com.byazt.c.pr prVar) {
        com.byazt.c.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr(prVar);
        }
    }

    @Override // com.byazt.c.hw
    public void pr(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.byazt.c.hw
    public View getView() {
        return this;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.hw;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    public void pr() {
        com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.x();
            }
        });
    }

    public void hw() {
        com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.hn();
            }
        });
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.byazt.c.hw.pr prVar) {
        this.fw = prVar;
    }
}
