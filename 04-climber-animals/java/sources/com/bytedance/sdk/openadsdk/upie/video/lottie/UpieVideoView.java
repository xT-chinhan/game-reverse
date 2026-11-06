package com.bytedance.sdk.openadsdk.upie.video.lottie;

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
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.nw;
import com.bytedance.adsdk.lottie.t;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UpieVideoView extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.xr {
    private com.bykv.vk.openvk.component.video.api.renderview.xr.ms ab;
    private final Map<String, Bitmap> ah;
    private final Runnable c;
    private final Map<String, Integer> d;
    private final Handler ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bykv.vk.openvk.component.video.api.renderview.xr f4239ms;
    private final LottieAnimationView xr;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public View getView() {
        return this;
    }

    public UpieVideoView(final Context context, final com.bytedance.sdk.openadsdk.upie.ms msVar) {
        super(context);
        this.ah = new HashMap();
        this.d = new HashMap();
        this.ka = new Handler(Looper.getMainLooper());
        this.c = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.xr != null && UpieVideoView.this.xr.ka()) {
                    UpieVideoView.this.xr.invalidate();
                }
                UpieVideoView.this.ka.postDelayed(UpieVideoView.this.c, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.f4239ms = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.xr = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new d() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
            
                if (r1.startsWith("http") != false) goto L17;
             */
            @Override // com.bytedance.adsdk.lottie.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public android.graphics.Bitmap ms(com.bytedance.adsdk.lottie.ny r6) {
                /*
                    r5 = this;
                    r0 = 0
                    if (r6 == 0) goto L56
                    java.lang.String r1 = r6.sl()
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L56
                    java.lang.String r2 = "${"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L38
                    java.lang.String r2 = "}"
                    boolean r2 = r1.endsWith(r2)
                    if (r2 == 0) goto L38
                    com.bytedance.sdk.openadsdk.upie.ms r2 = r2
                    if (r2 == 0) goto L37
                    org.json.JSONObject r2 = r2.ab()
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.upie.ms.ms.ms(r1, r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L37
                    java.lang.String r2 = "http"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L38
                L37:
                    return r0
                L38:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    java.util.Map r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.ms(r2)
                    java.lang.Object r2 = r2.get(r1)
                    android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                    if (r2 == 0) goto L47
                    return r2
                L47:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    android.content.Context r3 = r3
                    int r4 = r6.ms()
                    int r6 = r6.xr()
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.ms(r2, r3, r1, r4, r6)
                L56:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.AnonymousClass1.ms(com.bytedance.adsdk.lottie.ny):android.graphics.Bitmap");
            }
        });
        lottieAnimationView.setTextDelegate(new t(lottieAnimationView) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.2
            @Override // com.bytedance.adsdk.lottie.t
            public String ms(String str) {
                com.bytedance.sdk.openadsdk.upie.ms msVar2 = msVar;
                return com.bytedance.sdk.openadsdk.upie.ms.ms.ms(str, msVar2 != null ? msVar2.ab() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new nw() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.3
            @Override // com.bytedance.adsdk.lottie.nw
            public View ms(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.f4239ms.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.ms(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.4
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
                if (UpieVideoView.this.xr != null) {
                    UpieVideoView.this.xr.xr(this);
                }
                UpieVideoView.this.d();
            }
        });
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.xr == view) {
                    UpieVideoView.this.ah();
                }
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        this.ka.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ah();
        if (this.xr != null) {
            this.ka.postDelayed(this.c, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Context context, final String str, final int i, final int i2) {
        Integer num = this.d.get(str);
        if (num == null || num.intValue() != 1) {
            this.d.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.xr.ms().ms(context, str, new com.bytedance.sdk.openadsdk.upie.xr.ms<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.7
                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieVideoView.this.ah.put(str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(int i3, String str2) {
                    UpieVideoView.this.d.put(str, 2);
                }
            });
        }
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.xr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(com.bykv.vk.openvk.component.video.api.renderview.ms msVar) {
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.f4239ms;
        if (xrVar != null) {
            xrVar.ms(msVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.xr;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    public void ms() {
        com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.d();
            }
        });
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.ah();
            }
        });
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.bykv.vk.openvk.component.video.api.renderview.xr.ms msVar) {
        this.ab = msVar;
    }
}
