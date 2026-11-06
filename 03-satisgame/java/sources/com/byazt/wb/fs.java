package com.byazt.wb;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byazt.tk.k;
import com.byazt.tk.rv;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1324, 101})
public class fs {
    public static volatile String l;
    public static String w;
    public GLSurfaceView n;
    public AtomicBoolean q = new AtomicBoolean();
    public Handler qg = rv.n();
    public Handler s = rv.qg();
    public static AtomicBoolean x = new AtomicBoolean();
    public static AtomicInteger fs = new AtomicInteger();

    interface n {
        void n(GLSurfaceView gLSurfaceView);
    }

    public static String n() {
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        String strS = com.byazt.ed.s.n().s("dev20", LongCompanionObject.MAX_VALUE);
        l = strS;
        if (!TextUtils.isEmpty(strS)) {
            return l;
        }
        if (!TextUtils.isEmpty(w)) {
            return w;
        }
        String strS2 = com.byazt.ed.s.n().s("dev21", LongCompanionObject.MAX_VALUE);
        w = strS2;
        if (!TextUtils.isEmpty(strS2)) {
            return w;
        }
        if (fs.addAndGet(1) >= 3) {
            return w;
        }
        String strN = com.byazt.ehw.rv.n("ro.board.gpu");
        w = strN;
        if (TextUtils.isEmpty(strN)) {
            w = com.byazt.ehw.rv.n("ro.hardware.egl");
        }
        if (!TextUtils.isEmpty(w)) {
            com.byazt.ed.s.n().s("dev21", w);
        }
        return w;
    }

    public static void n(View view) {
        if (TextUtils.isEmpty(l) && (view instanceof ViewGroup) && com.byazt.nf.rv.qg().dh() && x.compareAndSet(false, true)) {
            String strS = com.byazt.ed.s.n().s("dev20", LongCompanionObject.MAX_VALUE);
            if (!TextUtils.isEmpty(strS)) {
                l = strS;
            } else {
                new fs().n((ViewGroup) view, new x() { // from class: com.byazt.wb.fs.1
                    @Override // com.byazt.wb.x
                    public void n(String str) {
                        String unused = fs.l = str;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        com.byazt.ed.s.n().s("dev20", fs.l);
                    }
                });
            }
        }
    }

    public void n(final ViewGroup viewGroup, final x xVar) {
        Handler handler = this.s;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.wb.fs.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context = viewGroup.getContext();
                        fs.this.n = new GLSurfaceView(context);
                        fs.this.n.setAlpha(0.0f);
                        fs.this.n.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                        viewGroup.addView(fs.this.n);
                        fs fsVar = fs.this;
                        fsVar.n(viewGroup, fsVar.n, xVar, new n() { // from class: com.byazt.wb.fs.2.1
                            @Override // com.byazt.wb.fs.n
                            public void n(GLSurfaceView gLSurfaceView) {
                                fs.this.n(gLSurfaceView);
                            }
                        });
                    } catch (Throwable th) {
                        k.qg("gpuInfo", th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final GLSurfaceView gLSurfaceView) {
        Handler handler = this.s;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.wb.fs.3
                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent = gLSurfaceView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(gLSurfaceView);
                    }
                    fs.this.n = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ViewGroup viewGroup, final GLSurfaceView gLSurfaceView, final x xVar, final n nVar) {
        final String[] strArr = new String[1];
        final Runnable runnable = new Runnable() { // from class: com.byazt.wb.fs.4
            @Override // java.lang.Runnable
            public void run() {
                x xVar2;
                fs.this.q.set(true);
                try {
                    gLSurfaceView.onPause();
                    String str = strArr[0];
                    if (str != null && (xVar2 = xVar) != null) {
                        xVar2.n(str);
                    }
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(gLSurfaceView);
                    }
                } catch (Throwable th) {
                    k.qg("gpuInfo2", th.getMessage());
                }
            }
        };
        try {
            gLSurfaceView.setEGLContextClientVersion(2);
            gLSurfaceView.setRenderer(new GLSurfaceView.Renderer() { // from class: com.byazt.wb.fs.5
                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    strArr[0] = GLES20.glGetString(7937);
                    Handler handler = fs.this.qg;
                    if (handler == null || fs.this.q.get()) {
                        return;
                    }
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onDrawFrame(GL10 gl10) {
                    gLSurfaceView.setRenderMode(0);
                }
            });
            gLSurfaceView.setRenderMode(0);
            Handler handler = this.qg;
            if (handler != null) {
                handler.postDelayed(runnable, 2000L);
            }
        } catch (Throwable th) {
            k.qg("gpuInfo1", th.getMessage());
        }
    }
}
