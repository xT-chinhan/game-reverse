package com.byazt.vzj;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.hlq.SSRenderTextureView;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.ou;
import com.byazt.pp.py;
import com.byazt.pp.q;
import com.byazt.vk.rv;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 1409})
public class UpieVideoView extends FrameLayout implements com.byazt.hlq.qg {
    public final Handler l;
    public final com.byazt.hlq.qg n;
    public final Map<String, Integer> q;
    public final LottieAnimationView qg;
    public final Map<String, Bitmap> s;
    public final Runnable w;
    public com.byazt.hlq.qg.n x;

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.byazt.hlq.qg
    public View getView() {
        return this;
    }

    public UpieVideoView(final Context context, final com.byazt.ts.n nVar) {
        super(context);
        this.s = new HashMap();
        this.q = new HashMap();
        this.l = new Handler(Looper.getMainLooper());
        this.w = new Runnable() { // from class: com.byazt.vzj.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.qg != null && UpieVideoView.this.qg.l()) {
                    UpieVideoView.this.qg.invalidate();
                }
                UpieVideoView.this.l.postDelayed(UpieVideoView.this.w, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.n = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.qg = lottieAnimationView;
        lottieAnimationView.setMaintainOriginalImageBounds(true);
        lottieAnimationView.setImageAssetDelegate(new q() { // from class: com.byazt.vzj.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
            
                if (r1.startsWith("http") != false) goto L17;
             */
            @Override // com.byazt.pp.q
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public android.graphics.Bitmap n(com.byazt.pp.rv r6) {
                /*
                    r5 = this;
                    r0 = 0
                    if (r6 == 0) goto L56
                    java.lang.String r1 = r6.oa()
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L56
                    java.lang.String r2 = "${"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L38
                    java.lang.String r2 = "}"
                    boolean r2 = r1.endsWith(r2)
                    if (r2 == 0) goto L38
                    com.byazt.ts.n r2 = r2
                    if (r2 == 0) goto L37
                    org.json.JSONObject r2 = r2.x()
                    java.lang.String r1 = com.byazt.oa.n.n(r1, r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L37
                    java.lang.String r2 = "http"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L38
                L37:
                    return r0
                L38:
                    com.byazt.vzj.UpieVideoView r2 = com.byazt.vzj.UpieVideoView.this
                    java.util.Map r2 = com.byazt.vzj.UpieVideoView.n(r2)
                    java.lang.Object r2 = r2.get(r1)
                    android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                    if (r2 == 0) goto L47
                    return r2
                L47:
                    com.byazt.vzj.UpieVideoView r2 = com.byazt.vzj.UpieVideoView.this
                    android.content.Context r3 = r3
                    int r4 = r6.n()
                    int r6 = r6.qg()
                    com.byazt.vzj.UpieVideoView.n(r2, r3, r1, r4, r6)
                L56:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.byazt.vzj.UpieVideoView.AnonymousClass1.n(com.byazt.pp.rv):android.graphics.Bitmap");
            }
        });
        lottieAnimationView.setTextDelegate(new py(lottieAnimationView) { // from class: com.byazt.vzj.UpieVideoView.2
            @Override // com.byazt.pp.py
            public String n(String str) {
                com.byazt.ts.n nVar2 = nVar;
                return com.byazt.oa.n.n(str, nVar2 != null ? nVar2.x() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new ou() { // from class: com.byazt.vzj.UpieVideoView.3
            @Override // com.byazt.pp.ou
            public View n(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.n.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.n(new Animator.AnimatorListener() { // from class: com.byazt.vzj.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.qg != null) {
                    UpieVideoView.this.qg.qg(this);
                }
                UpieVideoView.this.q();
            }
        });
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.vzj.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.qg == view) {
                    UpieVideoView.this.s();
                }
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.l.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        s();
        if (this.qg != null) {
            this.l.postDelayed(this.w, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Context context, final String str, final int i, final int i2) {
        Integer num = this.q.get(str);
        if (num == null || num.intValue() != 1) {
            this.q.put(str, 1);
            this.qg.n(str, new rv() { // from class: com.byazt.vzj.UpieVideoView.7
                @Override // com.byazt.vk.rv
                public void n(Bitmap bitmap) {
                    UpieVideoView.this.n(bitmap, str, i, i2);
                }

                @Override // com.byazt.vk.rv
                public void n() {
                    com.byazt.ts.qg.n().n(context, str, new com.byazt.ts.qg.n<Bitmap>() { // from class: com.byazt.vzj.UpieVideoView.7.1
                        @Override // com.byazt.ts.qg.n
                        public void n(Bitmap bitmap) {
                            UpieVideoView.this.n(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.ts.qg.n
                        public void n(int i3, String str2) {
                            UpieVideoView.this.q.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            this.s.put(str, bitmap);
        }
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.qg;
    }

    @Override // com.byazt.hlq.qg
    public void n(com.byazt.hlq.n nVar) {
        com.byazt.hlq.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    @Override // com.byazt.hlq.qg
    public void n(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.qg;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    public void n() {
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.q();
            }
        });
    }

    public void qg() {
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.s();
            }
        });
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.byazt.hlq.qg.n nVar) {
        this.x = nVar;
    }
}
