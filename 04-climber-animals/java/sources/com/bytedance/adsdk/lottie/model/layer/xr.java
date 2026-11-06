package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.t;
import com.umeng.analytics.pro.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ab {
    private com.bykv.vk.openvk.component.video.ms.d.d ch;
    private volatile boolean hi;
    private float ny;
    private TextureView sl;
    private final Handler u;
    private final Runnable ub;
    private float x;
    private LottieAnimationView zb;

    /* JADX WARN: Code duplicated, block: B:17:0x0068  */
    public xr(com.bytedance.adsdk.lottie.x xVar, x xVar2, final Context context) {
        JSONObject jSONObject;
        super(xVar, xVar2);
        this.x = -1.0f;
        this.ny = -1.0f;
        this.u = new Handler(Looper.getMainLooper());
        this.ub = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xr.4
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.zb != null) {
                    xr.this.zb.invalidate();
                }
                xr.this.u.postDelayed(xr.this.ub, 40L);
            }
        };
        if (this.ab == null || xVar == null || context == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewXr = xVar.xr();
        this.zb = lottieAnimationViewXr;
        if (lottieAnimationViewXr == null) {
            return;
        }
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        this.x = (int) (this.ab.ms() * fMs);
        this.ny = (int) (this.ab.xr() * fMs);
        t tVarW = xVar.w();
        if (tVarW != null) {
            String strMs = tVarW.ms(this.ab.sl());
            if (TextUtils.isEmpty(strMs)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(strMs);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                    jSONObject = null;
                }
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            final String strOptString = jSONObject.optString("file_hash");
            final String strOptString2 = jSONObject.optString("video_url");
            jSONObject.optString("video_duration");
            jSONObject.optString(bv.z);
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            TextureView textureView = new TextureView(context);
            this.sl = textureView;
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.bytedance.adsdk.lottie.model.layer.xr.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    xr.this.ms(strOptString2, strOptString, context, surfaceTexture);
                    xr.this.h();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    xr.this.u();
                    surfaceTexture.release();
                    xr.this.ao();
                    return true;
                }
            });
            this.zb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.xr.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (xr.this.zb == view) {
                        if (xr.this.xr()) {
                            xr.this.zb.removeOnAttachStateChangeListener(this);
                        } else {
                            xr.this.ms(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xr.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    xr.this.ub();
                                }
                            });
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (xr.this.zb == view) {
                        xr.this.ms(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.xr.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent parent = xr.this.sl.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).removeView(xr.this.sl);
                                }
                            }
                        });
                    }
                }
            });
            ub();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        u();
        com.bykv.vk.openvk.component.video.ms.d.d dVar = new com.bykv.vk.openvk.component.video.ms.d.d("uttie");
        this.ch = dVar;
        dVar.ms(surfaceTexture);
        this.ch.ms(new com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms() { // from class: com.bytedance.adsdk.lottie.model.layer.xr.3
            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ah(com.bykv.vk.openvk.component.video.api.ms msVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2, int i3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void xr(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void xr(com.bykv.vk.openvk.component.video.api.ms msVar) {
                xr.this.hi = true;
                msVar.ah(true);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
                com.bytedance.sdk.component.utils.sl.d("uttie-video", xrVar.ms() + ":" + xrVar.xr() + ":" + xrVar.ah());
            }
        });
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar = new com.bykv.vk.openvk.component.video.api.ah.ah();
        ahVar.ah(str);
        ahVar.ka(str2);
        this.ch.ms(new com.bykv.vk.openvk.component.video.api.ah.d(com.bytedance.adsdk.lottie.ka.xr.xr(context), ahVar, null, 0, 0));
        this.ch.ms(true);
        this.ch.ms(true, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.ch != null) {
            if (this.hi) {
                this.ch.d();
            }
            this.ch.ka();
            this.ch = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub() {
        ViewParent parent = this.sl.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.sl);
        }
        ViewParent parent2 = this.zb.getParent();
        if (parent2 instanceof ViewGroup) {
            this.sl.setTranslationX(2.1474836E9f);
            ((ViewGroup) parent2).addView(this.sl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        this.u.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ao();
        if (this.zb != null) {
            this.u.postDelayed(this.ub, 40L);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ab, com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        if (this.x <= 0.0f || this.sl == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        ms(i);
        float fX = x();
        ms(this.sl, (int) this.x, (int) this.ny);
        this.sl.setAlpha(fX);
        this.sl.draw(canvas);
        canvas.restore();
    }

    private static void ms(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
