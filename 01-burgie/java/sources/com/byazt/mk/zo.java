package com.byazt.mk;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.byazt.wt.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1191, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static volatile String c;
    public static String uc;
    public GLSurfaceView pr;
    public static AtomicBoolean fw = new AtomicBoolean();
    public static AtomicInteger zo = new AtomicInteger();
    public AtomicBoolean x = new AtomicBoolean();
    public Handler hw = aj.pr();
    public Handler hn = aj.hw();

    interface pr {
        void pr(GLSurfaceView gLSurfaceView);
    }

    public static String pr() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strHn = com.byazt.mp.x.pr().hn("dev20", LongCompanionObject.MAX_VALUE);
        c = strHn;
        if (!TextUtils.isEmpty(strHn)) {
            return c;
        }
        if (!TextUtils.isEmpty(uc)) {
            return uc;
        }
        String strHn2 = com.byazt.mp.x.pr().hn("dev21", LongCompanionObject.MAX_VALUE);
        uc = strHn2;
        if (!TextUtils.isEmpty(strHn2)) {
            return uc;
        }
        if (zo.addAndGet(1) >= 3) {
            return uc;
        }
        String strPr = z.pr("ro.board.gpu");
        uc = strPr;
        if (TextUtils.isEmpty(strPr)) {
            uc = z.pr("ro.hardware.egl");
        }
        if (!TextUtils.isEmpty(uc)) {
            com.byazt.mp.x.pr().hn("dev21", uc);
        }
        return uc;
    }

    public static void pr(View view) {
        if (TextUtils.isEmpty(c) && (view instanceof ViewGroup) && a.hw().hs() && fw.compareAndSet(false, true)) {
            String strHn = com.byazt.mp.x.pr().hn("dev20", LongCompanionObject.MAX_VALUE);
            if (!TextUtils.isEmpty(strHn)) {
                c = strHn;
            } else {
                new zo().pr((ViewGroup) view, new fw() { // from class: com.byazt.mk.zo.1
                    @Override // com.byazt.mk.fw
                    public void pr(String str) {
                        String unused = zo.c = str;
                        if (!TextUtils.isEmpty(str)) {
                            com.byazt.mp.x.pr().hn("dev20", zo.c);
                        }
                    }
                });
            }
        }
    }

    public void pr(final ViewGroup viewGroup, final fw fwVar) {
        Handler handler = this.hn;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.mk.zo.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context = viewGroup.getContext();
                        zo.this.pr = new GLSurfaceView(context);
                        zo.this.pr.setAlpha(0.0f);
                        zo.this.pr.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                        viewGroup.addView(zo.this.pr);
                        zo zoVar = zo.this;
                        zoVar.pr(viewGroup, zoVar.pr, fwVar, new pr() { // from class: com.byazt.mk.zo.2.1
                            @Override // com.byazt.mk.zo.pr
                            public void pr(GLSurfaceView gLSurfaceView) {
                                zo.this.pr(gLSurfaceView);
                            }
                        });
                    } catch (Throwable th) {
                        ho.hw("gpuInfo", th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final GLSurfaceView gLSurfaceView) {
        Handler handler = this.hn;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.mk.zo.3
                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent = gLSurfaceView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(gLSurfaceView);
                    }
                    zo.this.pr = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(ViewGroup viewGroup, final GLSurfaceView gLSurfaceView, final fw fwVar, final pr prVar) {
        final String[] strArr = new String[1];
        final Runnable runnable = new Runnable() { // from class: com.byazt.mk.zo.4
            @Override // java.lang.Runnable
            public void run() {
                fw fwVar2;
                zo.this.x.set(true);
                try {
                    gLSurfaceView.onPause();
                    String str = strArr[0];
                    if (str != null && (fwVar2 = fwVar) != null) {
                        fwVar2.pr(str);
                    }
                    pr prVar2 = prVar;
                    if (prVar2 != null) {
                        prVar2.pr(gLSurfaceView);
                    }
                } catch (Throwable th) {
                    ho.hw("gpuInfo2", th.getMessage());
                }
            }
        };
        try {
            gLSurfaceView.setEGLContextClientVersion(2);
            gLSurfaceView.setRenderer(new GLSurfaceView.Renderer() { // from class: com.byazt.mk.zo.5
                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    strArr[0] = GLES20.glGetString(7937);
                    Handler handler = zo.this.hw;
                    if (handler != null && !zo.this.x.get()) {
                        handler.removeCallbacks(runnable);
                        handler.post(runnable);
                    }
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onDrawFrame(GL10 gl10) {
                    gLSurfaceView.setRenderMode(0);
                }
            });
            gLSurfaceView.setRenderMode(0);
            Handler handler = this.hw;
            if (handler != null) {
                handler.postDelayed(runnable, 2000L);
            }
        } catch (Throwable th) {
            ho.hw("gpuInfo1", th.getMessage());
        }
    }
}
