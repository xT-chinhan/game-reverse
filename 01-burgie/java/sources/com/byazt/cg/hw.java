package com.byazt.cg;

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
import com.byazt.ca.ho;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 13})
public class hw extends fw {
    public float aj;
    public LottieAnimationView g;
    public final Handler ho;
    public volatile boolean k;
    public pr m;
    public final Runnable nt;
    public com.byazt.p.x vk;
    public com.byazt.ihe.fw.pr w;
    public float zo;

    public hw(com.byazt.dx.zo zoVar, zo zoVar2, final Context context) {
        super(zoVar, zoVar2);
        this.zo = -1.0f;
        this.aj = -1.0f;
        this.ho = new Handler(Looper.getMainLooper());
        this.nt = new Runnable() { // from class: com.byazt.cg.hw.4
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.g != null) {
                    hw.this.g.invalidate();
                }
                hw.this.ho.postDelayed(hw.this.nt, 40L);
            }
        };
        if (this.fw != null && zoVar != null && context != null) {
            LottieAnimationView lottieAnimationViewHw = zoVar.hw();
            this.g = lottieAnimationViewHw;
            if (lottieAnimationViewHw == null) {
                return;
            }
            float fPr = com.byazt.ptr.vk.pr();
            this.zo = (int) (this.fw.pr() * fPr);
            this.aj = (int) (this.fw.hw() * fPr);
            JSONObject jSONObject = null;
            cz czVarZ = zoVar.z();
            if (czVarZ != null) {
                String strPr = czVarZ.pr(this.fw.m());
                if (!TextUtils.isEmpty(strPr)) {
                    try {
                        jSONObject = new JSONObject(strPr);
                    } catch (JSONException e) {
                    }
                }
            }
            if (jSONObject != null) {
                final String strOptString = jSONObject.optString("file_hash");
                final String strOptString2 = jSONObject.optString("video_url");
                jSONObject.optString(Constants.VIDEO_DURATION_FIELD);
                jSONObject.optString(an.z);
                if (!TextUtils.isEmpty(strOptString2)) {
                    pr prVar = new pr(context);
                    this.m = prVar;
                    prVar.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.byazt.cg.hw.1
                        @Override // android.view.TextureView.SurfaceTextureListener
                        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                            hw.this.pr(strOptString2, strOptString, context, surfaceTexture);
                            hw.this.lb();
                        }

                        @Override // android.view.TextureView.SurfaceTextureListener
                        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                        }

                        @Override // android.view.TextureView.SurfaceTextureListener
                        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                            hw.this.ho();
                            surfaceTexture.release();
                            hw.this.yb();
                            return true;
                        }

                        @Override // android.view.TextureView.SurfaceTextureListener
                        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                        }
                    });
                    this.g.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.cg.hw.2
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View view) {
                            if (hw.this.g == view) {
                                if (hw.this.hw()) {
                                    hw.this.g.removeOnAttachStateChangeListener(this);
                                } else {
                                    hw.this.pr(new Runnable() { // from class: com.byazt.cg.hw.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            hw.this.nt();
                                        }
                                    });
                                }
                            }
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View view) {
                            if (hw.this.g == view) {
                                hw.this.pr(new Runnable() { // from class: com.byazt.cg.hw.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ViewParent parent = hw.this.m.getParent();
                                        if (parent instanceof ViewGroup) {
                                            ((ViewGroup) parent).removeView(hw.this.m);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    nt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        com.byazt.n.hw videoStats;
        ho();
        LottieAnimationView lottieAnimationView = this.g;
        if (lottieAnimationView == null) {
            videoStats = null;
        } else {
            videoStats = lottieAnimationView.getVideoStats();
        }
        com.byazt.p.x xVar = new com.byazt.p.x("uttie", videoStats);
        this.vk = xVar;
        xVar.pr(surfaceTexture);
        com.byazt.ihe.fw.pr prVar = new com.byazt.ihe.fw.pr() { // from class: com.byazt.cg.hw.3
            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void hw(com.byazt.ihe.fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, long j) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void hn(com.byazt.ihe.fw fwVar) {
                hw.this.k = true;
                fwVar.hn(true);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, com.byazt.ihe.hn hnVar) {
                ho.hw("uttie-video", hnVar.pr() + ":" + hnVar.hw() + ":" + hnVar.hn());
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, boolean z) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void x(com.byazt.ihe.fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, int i, int i2) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, int i, int i2, int i3) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, int i) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void hw(com.byazt.ihe.fw fwVar, int i) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, long j, long j2) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(com.byazt.ihe.fw fwVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void c(com.byazt.ihe.fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void uc(com.byazt.ihe.fw fwVar) {
            }
        };
        this.w = prVar;
        this.vk.pr(prVar);
        com.byazt.n.x xVar2 = new com.byazt.n.x();
        xVar2.hn(str);
        xVar2.uc(str2);
        this.vk.pr(new com.byazt.n.uc(com.byazt.ptr.hn.hw(context), xVar2, null, 0, 0));
        this.vk.hw(true);
        this.vk.pr(true, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho() {
        if (this.vk != null) {
            if (this.k) {
                this.vk.fw();
            }
            this.vk.uc();
            this.vk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt() {
        ViewParent parent = this.m.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.m);
        }
        ViewParent parent2 = this.g.getParent();
        if (parent2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent2;
            int i = 0;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof pr) {
                    viewGroup.removeView(childAt);
                    i--;
                }
                i++;
            }
            this.m.setTranslationX(2.1474836E9f);
            viewGroup.addView(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        this.ho.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        yb();
        if (this.g != null) {
            this.ho.postDelayed(this.nt, 40L);
        }
    }

    @Override // com.byazt.cg.fw, com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        if (this.zo > 0.0f && this.m != null) {
            canvas.save();
            canvas.concat(matrix);
            pr(i);
            float fZo = zo();
            pr(this.m, (int) this.zo, (int) this.aj);
            this.m.setAlpha(fZo);
            this.m.draw(canvas);
            canvas.restore();
        }
    }

    private static void pr(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr extends TextureView {
        public pr(Context context) {
            super(context);
        }
    }
}
