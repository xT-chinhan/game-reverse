package com.byazt.eg;

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
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.py;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.C;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 26})
public class qg extends x {
    public com.byazt.ej.x.n cp;
    public final Runnable cy;
    public volatile boolean d;
    public float fs;
    public final Handler k;
    public n oa;
    public float rv;
    public LottieAnimationView sz;
    public com.byazt.vmq.q tj;

    /* JADX WARN: Code duplicated, block: B:15:0x0064  */
    public qg(com.byazt.pp.fs fsVar, fs fsVar2, final Context context) {
        JSONObject jSONObject;
        super(fsVar, fsVar2);
        this.fs = -1.0f;
        this.rv = -1.0f;
        this.k = new Handler(Looper.getMainLooper());
        this.cy = new Runnable() { // from class: com.byazt.eg.qg.4
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.sz != null) {
                    qg.this.sz.invalidate();
                }
                qg.this.k.postDelayed(qg.this.cy, 40L);
            }
        };
        if (this.x == null || fsVar == null || context == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewQg = fsVar.qg();
        this.sz = lottieAnimationViewQg;
        if (lottieAnimationViewQg == null) {
            return;
        }
        float fN = com.byazt.nu.tj.n();
        this.fs = (int) (this.x.n() * fN);
        this.rv = (int) (this.x.qg() * fN);
        py pyVarHu = fsVar.hu();
        if (pyVarHu != null) {
            String strN = pyVarHu.n(this.x.oa());
            if (TextUtils.isEmpty(strN)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(strN);
                } catch (JSONException unused) {
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
            jSONObject.optString("resolution");
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            n nVar = new n(context);
            this.oa = nVar;
            nVar.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.byazt.eg.qg.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    qg.this.n(strOptString2, strOptString, context, surfaceTexture);
                    qg.this.cd();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    qg.this.k();
                    surfaceTexture.release();
                    qg.this.hd();
                    return true;
                }
            });
            this.sz.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.eg.qg.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (qg.this.sz == view) {
                        if (qg.this.qg()) {
                            qg.this.sz.removeOnAttachStateChangeListener(this);
                        } else {
                            qg.this.n(new Runnable() { // from class: com.byazt.eg.qg.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    qg.this.cy();
                                }
                            });
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (qg.this.sz == view) {
                        qg.this.n(new Runnable() { // from class: com.byazt.eg.qg.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent parent = qg.this.oa.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).removeView(qg.this.oa);
                                }
                            }
                        });
                    }
                }
            });
            cy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        k();
        LottieAnimationView lottieAnimationView = this.sz;
        com.byazt.vmq.q qVar = new com.byazt.vmq.q("uttie", lottieAnimationView != null ? lottieAnimationView.getVideoStats() : null);
        this.tj = qVar;
        qVar.n(surfaceTexture);
        com.byazt.ej.x.n nVar = new com.byazt.ej.x.n() { // from class: com.byazt.eg.qg.3
            @Override // com.byazt.ej.x.n
            public void l(com.byazt.ej.x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, int i) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, int i, int i2) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, int i, int i2, int i3) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, long j) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, long j, long j2) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, boolean z) {
            }

            @Override // com.byazt.ej.x.n
            public void q(com.byazt.ej.x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void qg(com.byazt.ej.x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void qg(com.byazt.ej.x xVar, int i) {
            }

            @Override // com.byazt.ej.x.n
            public void w(com.byazt.ej.x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void s(com.byazt.ej.x xVar) {
                qg.this.d = true;
                xVar.s(true);
            }

            @Override // com.byazt.ej.x.n
            public void n(com.byazt.ej.x xVar, com.byazt.ej.s sVar) {
                k.qg("uttie-video", sVar.n() + ":" + sVar.qg() + ":" + sVar.s());
            }
        };
        this.cp = nVar;
        this.tj.n(nVar);
        com.byazt.zsl.s sVar = new com.byazt.zsl.s();
        sVar.s(str);
        sVar.w(str2);
        this.tj.n(new com.byazt.zsl.l(com.byazt.nu.s.qg(context), sVar, null, 0, 0));
        this.tj.qg(true);
        this.tj.n(true, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.tj != null) {
            if (this.d) {
                this.tj.x();
            }
            this.tj.w();
            this.tj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        ViewParent parent = this.oa.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.oa);
        }
        ViewParent parent2 = this.sz.getParent();
        if (parent2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent2;
            int i = 0;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof n) {
                    viewGroup.removeView(childAt);
                    i--;
                }
                i++;
            }
            this.oa.setTranslationX(2.1474836E9f);
            viewGroup.addView(this.oa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        this.k.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        hd();
        if (this.sz != null) {
            this.k.postDelayed(this.cy, 40L);
        }
    }

    @Override // com.byazt.eg.x, com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        if (this.fs <= 0.0f || this.oa == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        n(i);
        float fFs = fs();
        n(this.oa, (int) this.fs, (int) this.rv);
        this.oa.setAlpha(fFs);
        this.oa.draw(canvas);
        canvas.restore();
    }

    private static void n(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i2, C.ENCODING_PCM_32BIT));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @com.byazt.cp.n(n = {0, 1, 959, 48})
    private static class n extends TextureView {
        public n(Context context) {
            super(context);
        }
    }
}
